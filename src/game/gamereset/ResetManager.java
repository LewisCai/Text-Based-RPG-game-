package game.gamereset;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * A reset manager class that manages a list of resettables.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class ResetManager {
    /**
     * List of resettable registered
     */
    private List<Resettable> resettables;
    /**
     * Instance of RestManager
     */
    private static ResetManager instance = null;
    /**
     * Location of site of lost grace
     */
    private Location siteOfLostGraceLoc;

    /**
     * Constructor for RestManager
     */
    private ResetManager() {
        this.resettables = new ArrayList<>();
    }

    /**
     * Factory method for RestManager
     * @return RestManager instance
     */
    public static ResetManager getInstance(){
        if(instance == null){
            instance = new ResetManager();
        }
        return instance;
    }

    /**
     * Setter for location of SiteOfLostGrace
     * @param siteOfLostGraceLoc Location of SiteOfLostGrace
     */
    public void setSiteOfLostGraceLoc(Location siteOfLostGraceLoc, String name) {
        this.siteOfLostGraceLoc = siteOfLostGraceLoc;
        SiteOfLostGrace newSite = new SiteOfLostGrace();
        newSite.setName(name);
        this.siteOfLostGraceLoc.setGround(newSite);
    }

    /**
     * Getter for SiteOfLostGrace
     * @return Location for SiteOfLostGrace
     */
    public Location getSiteOfLostGraceLoc() {
        return siteOfLostGraceLoc;
    }


    /**
     * Trigger game rest with Lost Grace, catches Player actor and skip it
     * @param actor Player
     * @param map Map player is on
     */
    public void runRest(Actor actor, GameMap map){
        for(int i = 0; i < resettables.size(); i++){
            resettables.get(i).reset(actor, map);
            }
    }

    /**
     * Registering a thing to resettable.
     * @param resettable Resettable thing in game
     */
    public void registerResettable(Resettable resettable) {
        resettables.add(resettable);
    }

    /**
     * Remove something from resettable List
     * @param resettable Resettable thing in game
     */
    public void removeResettable(Resettable resettable) {
        resettables.remove(resettable);
    }
}
