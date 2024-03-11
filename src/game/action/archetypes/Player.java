package game.action.archetypes;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.consumable.FlaskOfCrimsonTears;
import game.currency.RunesManager;
import game.gamereset.ResetManager;
import game.utils.Interactions;
import game.gamereset.Resettable;

/**
 * Class representing the Player. It implements the Resettable interface.
 * It carries around a club to attack a hostile creature in the Lands Between.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Player extends Actor implements Resettable {

	private final Menu menu = new Menu();

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
		registerInManager();
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		this.addCapability(Interactions.ABLE_TO_TRADE);
		this.addItemToInventory(FlaskOfCrimsonTears.getFlaskInstance());
		this.addCapability(Status.ALIVE);
		this.addCapability(Status.PLAYER);
	}

	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null){
			return lastAction.getNextAction();
		}

		display.println(super.name + " ("+super.hitPoints+"/"+super.maxHitPoints + "), runes: " + RunesManager.getRunesManagerInstance().getCurrentPlayerRunes());
		// return/print the console menu
		return menu.showMenu(this, actions, display);
	}

	@Override
	public void reset(Actor actor, GameMap map) {
		Location deathLocation = map.locationOf(actor);
		Location destination = ResetManager.getInstance().getSiteOfLostGraceLoc();
		RunesManager.getRunesManagerInstance().dropRunesAtLocation(deathLocation);
		actor.heal(9999999);
		FlaskOfCrimsonTears.getFlaskInstance().setToMax();
		Action action = new MoveActorAction(destination, "to the site of Lost Grace");
		action.execute(actor, map);
	}

	@Override
	public void registerInManager() {
		ResetManager.getInstance().registerResettable(this);
	}
}
