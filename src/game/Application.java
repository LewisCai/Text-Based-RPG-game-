package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.*;
import game.action.archetypes.Player;
import game.currency.RunesManager;
import game.environment.*;
import game.gamereset.ResetManager;
import game.ground.*;
import game.trader.FingerReaderEnia;
import game.utils.ArchetypesMenu;
import game.gamereset.SiteOfLostGrace;
import game.trader.MerchantKale;
import game.utils.FancyMessage;
import game.weapons.FireBlade;
import game.weapons.PoisonDagger;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Application {

	public static void main(String[] args) {

		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Graveyard(), new GustOfWind(), new SummonSign(), new PuddleOfWater(), new SiteOfLostGrace(), new Cliff(), new Cage(), new Barrack());


		List<String> Limgrave = Arrays.asList(
				"......................#.............#..........................+++.........",
				"......................#.............#.......................+++++..........",
				"......................#..___....____#.........................+++++........",
				"......................#...........__#............................++........",
				"......................#_____........#.............................+++......",
				"......................#............_#..............................+++.....",
				"......................######...######......................................",
				"...........................................................................",
				"...........................=...............................................",
				"........++++......................###___###................................",
				"........+++++++...................________#................................",
				"..........+++.....................#___U____................................",
				"............+++...................#_______#................................",
				".............+....................###___###................................",
				"............++......................#___#..................................",
				"..............+...................=........................................",
				"..............++.................................................=.........",
				"..............................................++...........................",
				"..................++++......................+++...............######..##...",
				"#####___######....++...........................+++............#....____....",
				"_____________#.....++++..........................+..............__.....#...",
				"_____________#.....+....++........................++.........._.....__.#...",
				"_____________#.........+..+.....................+++...........###..__###...",
				"_____________#.............++..............................................");

		List<String> StormveilCastle = Arrays.asList(
				"...........................................................................",
				"..................<...............<........................................",
				"...........................................................................",
				"##############################################...##########################",
				"............................#................#.......B..............B......",
				".....B...............B......#................#.............................",
				"...............................<.........<.................................",
				".....B...............B......#................#.......B..............B......",
				"............................#................#.............................",
				"#####################..#############...############.####..#########...#####",
				"...............#++++++++++++#................#++++++++++++#................",
				"...............#++++++++++++...<.........<...#++++++++++++#................",
				"...............#++++++++++++..................++++++++++++#................",
				"...............#++++++++++++#................#++++++++++++#................",
				"#####...##########.....#############...#############..#############...#####",
				".._______........................B......B........................B.....B...",
				"_____..._..____....&&........<..............<..............................",
				".........____......&&......................................................",
				"...._______..................<..............<....................<.....<...",
				"#####....##...###..#####...##########___###############......##.....####...",
				"+++++++++++++++++++++++++++#...................#+++++++++++++++++++++++++++",
				"+++++++++++++++++++++++++++....................#+++++++++++++++++++++++++++",
				"+++++++++++++++++++++++++++#....................+++++++++++++++++++++++++++",
				"+++++++++++++++++++++++++++#...................#+++++++++++++++++++++++++++"); // (25 x 40)

		List<String> roundtableHold = Arrays.asList(
				"##################",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"########___#######"); // 12 x 20


		List<String> BossRoom = Arrays.asList(
				"+++++++++++++++++++++++++",
				".........................",
				".........................",
				".........................",
				".........................",
				".........................",
				".........................",
				".........................",
				"+++++++++++++++++++++++++"); // 9 x 25

		GameMap limgraveMap = new GameMap(groundFactory, Limgrave);
		GameMap roundtableHoldMap = new GameMap(groundFactory, roundtableHold);
		GameMap stormveilCastleMap = new GameMap(groundFactory, StormveilCastle);
		GameMap bossRoomMap = new GameMap(groundFactory, BossRoom);

		world.addGameMap(limgraveMap);
		world.addGameMap(roundtableHoldMap);
		world.addGameMap(stormveilCastleMap);
		world.addGameMap(bossRoomMap);


		// BEHOLD, ELDEN RING
		for (String line : FancyMessage.ELDEN_RING.split("\n")) {
			new Display().println(line);
			try {
				Thread.sleep(200);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}

		Player player = new Player("Tarnished", '@', 300);
		ArchetypesMenu archetypesMenu = new ArchetypesMenu(player, limgraveMap);
		world.addPlayer(player, limgraveMap.at(36, 10));
		ResetManager resetManager = ResetManager.getInstance();
		RunesManager runesManager = RunesManager.getRunesManagerInstance();

		Location lostGrace = limgraveMap.at(38,11);
		resetManager.setSiteOfLostGraceLoc(lostGrace, "First step");


		runesManager.setPlayer(player);
		MerchantKale kale = new MerchantKale();
		limgraveMap.at(39, 12).addActor(kale);

		FingerReaderEnia fingerReaderEnia = new FingerReaderEnia();
		roundtableHoldMap.at(10, 10).addActor(fingerReaderEnia);

		bossRoomMap.at(5, 5).addItem(new RemembranceOfTheGrafted());

		Location roundtableHoldDoor1 = new Location(roundtableHoldMap, 9, 9);
		Location limgraveDoor1 = new Location(limgraveMap, 37, 12);
		Location limgraveDoor2 = new Location(limgraveMap, 10,10);
		Location stormveilDoor1 = new Location(stormveilCastleMap, 2,2);
		Location stormveilDoor2 = new Location(stormveilCastleMap, 37, 22);
		Location bossRoom = new Location(bossRoomMap, 11, 7);

		limgraveMap.at(37,12).setGround(new GoldenFogDoor(limgraveDoor1, roundtableHoldDoor1,"Roundtable Hold", world));
		limgraveMap.at(36,10).setGround(new GoldenFogDoor(limgraveDoor2, stormveilDoor1, "Stormveil Castle", world));

		roundtableHoldMap.at(9,9).setGround(new GoldenFogDoor(roundtableHoldDoor1, limgraveDoor1, "Limgrave", world));

		stormveilCastleMap.at(2,2).setGround(new GoldenFogDoor(stormveilDoor1, limgraveDoor2, "Limgrave", world));
		stormveilCastleMap.at(37, 22).setGround(new GoldenFogDoor(stormveilDoor2, bossRoom, "Boss Room", world));

		Location fireBladeLocation = bossRoomMap.at(12,1);
		fireBladeLocation.addItem(new FireBlade());

		Location poisonDaggerLocation = roundtableHoldMap.at(1,9);
		poisonDaggerLocation.addItem(new PoisonDagger());

		world.run();
	}
}