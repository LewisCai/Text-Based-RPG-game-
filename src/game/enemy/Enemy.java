package game.enemy;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.action.attackactions.AttackAction;
import game.action.WeaponSkillAction;
import game.action.attackactions.StatusEffectAttackAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.gamereset.ResetManager;
import game.gamereset.Resettable;
import game.weapons.StatusEffectWeapon;
import game.weapons.statuseffect.EffectCapability;
import game.weapons.statuseffect.StatusEffectBehaviour;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Enemy Class, subclass of Actor
 *
 * Created by:
 * @author Jun Choi
 * @version Updated as of 2/05/23
 */
public abstract class Enemy extends Actor implements Resettable {



    /**
     * Behaviour Hashmap to store behaviours by priority
     */
    protected Map<Integer, Behaviour> behaviours = new HashMap<>();
    /**
     * Priority level key for wander
     */
    protected static final int WANDER_KEY = 999;
    /**
     * Priority level key for death passive
     */
    protected static final int DEATH_PASSIVE_KEY = 1;
    /**
     * Priority level key for follow
     */
    protected static final int FOLLOW_KEY = 5;
    /**
     * Priority level key for attack
     */
    protected static final int ATTACK_KEY = 3;

    /**
     * Lower Bound value for rune drop rates
     */
    private int runeLowerBound;

    /**
     * Upper bound value for rune drop rates
     */
    private int runeUpperBound;

    /**
     * Random number generator
     */
    private Random rand = new Random();

    private StatusEffectBehaviour statusEffect = null;

    /**
     * Enemy Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Enemy(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        registerInManager();
        setBehaviours();
        this.addCapability(EnemyCapabilities.ENEMY);
    }

    /**
     * Method for setting all necessary behaviours needed for enemies
     */
    public void setBehaviours() {
        this.behaviours.put(WANDER_KEY, new WanderBehaviour());
        this.behaviours.put(ATTACK_KEY, new AttackBehaviour());
    }

    public Map<Integer, Behaviour> getBehaviours(){
        return this.behaviours;
    }

    public void setStatusEffect(StatusEffectBehaviour statusEffect) {
        this.statusEffect = statusEffect;
        if (statusEffect != null) {
            this.addCapability(EffectCapability.AFFECTED);
        } else {
            this.removeCapability(EffectCapability.AFFECTED);
        }

    }

    /**
     * Enemy Name getter method
     * @return String of enemy name
     */
    public String getName(){
        return super.name;
    }

    /**
     * Setter method for rune drop rate lower and upperbound
     * @param lowerBound An integer value representing the lower bound
     * @param upperBound An integer value representing the upper bound
     */
    protected void setRuneBoundaries(int lowerBound, int upperBound){
        this.runeLowerBound = lowerBound;
        this.runeUpperBound = upperBound;
    }

    /**
     * Getter method for Rune drop rate lower bound
     * @return An Integer value of the lowest possible rune drop size
     */
    public int getRuneLowerBound() {
        return runeLowerBound;
    }

    /**
     * Getter method for Rune drop rate upper bound
     * @return An Integer value of the highest possible rune drop size
     */
    public int getRuneUpperBound() {
        return runeUpperBound;
    }

    public int runeDropNumber(){
        return rand.nextInt(getRuneUpperBound() - getRuneLowerBound()) + getRuneLowerBound();
    }

    /**
     * At each turn, select a valid action to perform.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (statusEffect != null){
            System.out.println(System.lineSeparator() + statusEffect.getAction(this, map).execute(this, map));
            if (statusEffect.getRemainingPlayCount() <= 0){
                setStatusEffect(null);
            }
        }

        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }


    /**
     * The allowable actions against enemies
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return A list of available actions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            WeaponItem availableWeapon;
            try {
                availableWeapon = otherActor.getWeaponInventory().get(0);
            } catch (Exception e){
                availableWeapon = null;
            }
            this.behaviours.put(FOLLOW_KEY, new FollowBehaviour(otherActor));
            this.addCapability(EnemyCapabilities.IS_FOLLOWING);
            if (availableWeapon != null) {
                if (availableWeapon.hasCapability(EffectCapability.HAS_STATUS_EFFECT)){
                    actions.add(new StatusEffectAttackAction(this, direction, (StatusEffectWeapon) availableWeapon));
                } else {
                    actions.add(new AttackAction(this, direction, availableWeapon));
                }
                Action weaponSkill = availableWeapon.getSkill(this, direction);

                if (weaponSkill != null){
                    actions.add(new WeaponSkillAction(this, direction, availableWeapon));
                }

            } else {
                actions.add(new AttackAction(this, direction));

            }
        }
        return actions;
    }

    /**
     * Reset enemy by removing them from map
     * @param actor Player
     * @param map Map the player is on
     */
    @Override
    public void reset(Actor actor, GameMap map) {
        map.removeActor(this);
    }

    /**
     * Register enemy in rest manager
     */
    @Override
    public void registerInManager() {
        ResetManager.getInstance().registerResettable(this);
    }

    public boolean isFollowing(){
        return this.behaviours.containsKey(FOLLOW_KEY);
    }
}
