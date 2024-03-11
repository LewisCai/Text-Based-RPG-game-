package game;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.World;
import game.action.archetypes.Player;
import game.currency.RunesManager;
import game.enemy.east.HeavySkeletalSwordsman;
import game.enemy.west.GiantDog;
import game.environment.*;
import game.gamereset.ResetManager;
import game.gamereset.SiteOfLostGrace;
import game.ground.Cliff;
import game.ground.Dirt;
import game.ground.Floor;
import game.ground.Wall;
import game.utils.ArchetypesMenu;
import game.weapons.FireBlade;
import game.weapons.PoisonDagger;

import java.util.Arrays;
import java.util.List;

public class testArea {

    public static void main(String[] args) {

        World world = new World(new Display());

        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Graveyard(), new GustOfWind(), new SummonSign(), new PuddleOfWater(), new SiteOfLostGrace(), new Cliff(), new Cage(), new Barrack());

        List<String> map = Arrays.asList(
                "+++++++++++++++++++++++++",
                ".....=...................",
                ".........................",
                ".........................",
                ".........................",
                ".........................",
                ".........................",
                ".........................",
                "+++++++++++++++++++++++++"); // 9 x 25


        GameMap gameMap = new GameMap(groundFactory, map);
        world.addGameMap(gameMap);


        Player player = new Player("Tarnished", '@', 300);
        ArchetypesMenu archetypesMenu = new ArchetypesMenu(player, gameMap);
        world.addPlayer(player, gameMap.at(0,0));


        ResetManager resetManager = ResetManager.getInstance();
        RunesManager runesManager = RunesManager.getRunesManagerInstance();

        Location fireBladeLocation = gameMap.at(11, 7);
        fireBladeLocation.addItem(new FireBlade());



        world.run();
    }
}
