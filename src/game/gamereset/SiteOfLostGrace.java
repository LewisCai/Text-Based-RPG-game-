package game.gamereset;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.action.RestAction;

/**
 * Class of Site of lost grace
 * Created by:
 * @author Linjun Cai
 * @version 2/5/2023
 */
public class SiteOfLostGrace extends Ground {


    /**
     * The name of the lost site of grace
     */
    private String name;

    /**
     * Constructor
     */
    public SiteOfLostGrace() {
        super( 'U');
    }

    /**
     * Adds Rest action to action list for player to choose
     * @param otheractor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return Action list that contains rest action
     */
    @Override
    public ActionList allowableActions(Actor otheractor, Location location, String direction){
        return new ActionList(new RestAction(name, location));
    }

    /**
     * Getter for the name of lost site of grace
     * @return the name of the lost site of grace
     */
    public String getSiteName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
