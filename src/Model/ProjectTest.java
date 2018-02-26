package Model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class ProjectTest {

	// Defines a Board class contains 25 Location instances
	@Test
	public void LocationListTest() {

	}

	// Correctly reads codenames from a file named GameWords.txt and stores them in
	// a List
	@Test
	public void ReadCodenameTest() {
		Model m = new Model("GameWords.txt");
		ArrayList<String> test = m.getUnShuffledCodenames();
		String appendedCodename = "";
		for(String s : test) {
			appendedCodename = appendedCodename + s + "\r\n";
		}
		assertEquals("The codes name was not read correctly, refer to Model.java @ReadFile","AFRICA\r\n" + 
				"AGENT\r\n" + 
				"AIR\r\n" + 
				"ALIEN\r\n" + 
				"ALPS\r\n" + 
				"AMAZON\r\n" + 
				"AMBULANCE\r\n" + 
				"AMERICA\r\n" + 
				"ANGEL\r\n" + 
				"ANTARCTICA\r\n" + 
				"APPLE\r\n" + 
				"ARM\r\n" + 
				"ATLANTIS\r\n" + 
				"AUSTRALIA\r\n" + 
				"AZTEC\r\n" + 
				"BACK\r\n" + 
				"BALL\r\n" + 
				"BAND\r\n" + 
				"BANK\r\n" + 
				"BAR\r\n" + 
				"BARK\r\n" + 
				"BAT\r\n" + 
				"BATTERY\r\n" + 
				"BEACH\r\n" + 
				"BEAR\r\n" + 
				"BEAT\r\n" + 
				"BED\r\n" + 
				"BEIJING\r\n" + 
				"BELL\r\n" + 
				"BELT\r\n" + 
				"BERLIN\r\n" + 
				"BERMUDA\r\n" + 
				"BERRY\r\n" + 
				"BILL\r\n" + 
				"BLOCK\r\n" + 
				"BOARD\r\n" + 
				"BOLT\r\n" + 
				"BOMB\r\n" + 
				"BOND\r\n" + 
				"BOOM\r\n" + 
				"BOOT\r\n" + 
				"BOTTLE\r\n" + 
				"BOW\r\n" + 
				"BOX\r\n" + 
				"BRIDGE\r\n" + 
				"BRUSH\r\n" + 
				"BUCK\r\n" + 
				"BUFFALO\r\n" + 
				"BUG\r\n" + 
				"BUGLE\r\n" + 
				"BUTTON\r\n" + 
				"CALF\r\n" + 
				"CANADA\r\n" + 
				"CAP\r\n" + 
				"CAPITAL\r\n" + 
				"CAR\r\n" + 
				"CARD\r\n" + 
				"CARROT\r\n" + 
				"CASINO\r\n" + 
				"CAST\r\n" + 
				"CAT\r\n" + 
				"CELL\r\n" + 
				"CENTAUR\r\n" + 
				"CENTER\r\n" + 
				"CHAIR\r\n" + 
				"CHANGE\r\n" + 
				"CHARGE\r\n" + 
				"CHECK\r\n" + 
				"CHEST\r\n" + 
				"CHICK\r\n" + 
				"CHINA\r\n" + 
				"CHOCOLATE\r\n" + 
				"CHURCH\r\n" + 
				"CIRCLE\r\n" + 
				"CLIFF\r\n" + 
				"CLOAK\r\n" + 
				"CLUB\r\n" + 
				"CODE\r\n" + 
				"COLD\r\n" + 
				"COMIC\r\n" + 
				"COMPOUND\r\n" + 
				"CONCERT\r\n" + 
				"CONDUCTOR\r\n" + 
				"CONTRACT\r\n" + 
				"COOK\r\n" + 
				"COPPER\r\n" + 
				"COTTON\r\n" + 
				"COURT\r\n" + 
				"COVER\r\n" + 
				"CRANE\r\n" + 
				"CRASH\r\n" + 
				"CRICKET\r\n" + 
				"CROSS\r\n" + 
				"CROWN\r\n" + 
				"CYCLE\r\n" + 
				"CZECH\r\n" + 
				"DANCE\r\n" + 
				"DATE\r\n" + 
				"DAY\r\n" + 
				"DEATH\r\n" + 
				"DECK\r\n" + 
				"DEGREE\r\n" + 
				"DIAMOND\r\n" + 
				"DICE\r\n" + 
				"DINOSAUR\r\n" + 
				"DISEASE\r\n" + 
				"DOCTOR\r\n" + 
				"DOG\r\n" + 
				"DRAFT\r\n" + 
				"DRAGON\r\n" + 
				"DRESS\r\n" + 
				"DRILL\r\n" + 
				"DROP\r\n" + 
				"DUCK\r\n" + 
				"DWARF\r\n" + 
				"EAGLE\r\n" + 
				"EGYPT\r\n" + 
				"EMBASSY\r\n" + 
				"ENGINE\r\n" + 
				"ENGLAND\r\n" + 
				"EUROPE\r\n" + 
				"EYE\r\n" + 
				"FACE\r\n" + 
				"FAIR\r\n" + 
				"FALL\r\n" + 
				"FAN\r\n" + 
				"FENCE\r\n" + 
				"FIELD\r\n" + 
				"FIGHTER\r\n" + 
				"FIGURE\r\n" + 
				"FILE\r\n" + 
				"FILM\r\n" + 
				"FIRE\r\n" + 
				"FISH\r\n" + 
				"FLUTE\r\n" + 
				"FLY\r\n" + 
				"FOOT\r\n" + 
				"FORCE\r\n" + 
				"FOREST\r\n" + 
				"FORK\r\n" + 
				"FRANCE\r\n" + 
				"GAME\r\n" + 
				"GAS\r\n" + 
				"GENIUS\r\n" + 
				"GERMANY\r\n" + 
				"GHOST\r\n" + 
				"GIANT\r\n" + 
				"GLASS\r\n" + 
				"GLOVE\r\n" + 
				"GOLD\r\n" + 
				"GRACE\r\n" + 
				"GRASS\r\n" + 
				"GREECE\r\n" + 
				"GREEN\r\n" + 
				"GROUND\r\n" + 
				"HAM\r\n" + 
				"HAND\r\n" + 
				"HAWK\r\n" + 
				"HEAD\r\n" + 
				"HEART\r\n" + 
				"HELICOPTER\r\n" + 
				"HIMALAYAS\r\n" + 
				"HOLE\r\n" + 
				"HOLLYWOOD\r\n" + 
				"HONEY\r\n" + 
				"HOOD\r\n" + 
				"HOOK\r\n" + 
				"HORN\r\n" + 
				"HORSE\r\n" + 
				"HORSESHOE\r\n" + 
				"HOSPITAL\r\n" + 
				"HOTEL\r\n" + 
				"ICE\r\n" + 
				"ICE CREAM\r\n" + 
				"INDIA\r\n" + 
				"IRON\r\n" + 
				"IVORY\r\n" + 
				"JACK\r\n" + 
				"JAM\r\n" + 
				"JET\r\n" + 
				"JUPITER\r\n" + 
				"KANGAROO\r\n" + 
				"KETCHUP\r\n" + 
				"KEY\r\n" + 
				"KID\r\n" + 
				"KING\r\n" + 
				"KIWI\r\n" + 
				"KNIFE\r\n" + 
				"KNIGHT\r\n" + 
				"LAB\r\n" + 
				"LAP\r\n" + 
				"LASER\r\n" + 
				"LAWYER\r\n" + 
				"LEAD\r\n" + 
				"LEMON\r\n" + 
				"LEPRECHAUN\r\n" + 
				"LIFE\r\n" + 
				"LIGHT\r\n" + 
				"LIMOUSINE\r\n" + 
				"LINE\r\n" + 
				"LINK\r\n" + 
				"LION\r\n" + 
				"LITTER\r\n" + 
				"LOCH NESS\r\n" + 
				"LOCK\r\n" + 
				"LOG\r\n" + 
				"LONDON\r\n" + 
				"LUCK\r\n" + 
				"MAIL\r\n" + 
				"MAMMOTH\r\n" + 
				"MAPLE\r\n" + 
				"MARBLE\r\n" + 
				"MARCH\r\n" + 
				"MASS\r\n" + 
				"MATCH\r\n" + 
				"MERCURY\r\n" + 
				"MEXICO\r\n" + 
				"MICROSCOPE\r\n" + 
				"MILLIONAIRE\r\n" + 
				"MINE\r\n" + 
				"MINT\r\n" + 
				"MISSILE\r\n" + 
				"MODEL\r\n" + 
				"MOLE\r\n" + 
				"MOON\r\n" + 
				"MOSCOW\r\n" + 
				"MOUNT\r\n" + 
				"MOUSE\r\n" + 
				"MOUTH\r\n" + 
				"MUG\r\n" + 
				"NAIL\r\n" + 
				"NEEDLE\r\n" + 
				"NET\r\n" + 
				"NEW YORK\r\n" + 
				"NIGHT\r\n" + 
				"NINJA\r\n" + 
				"NOTE\r\n" + 
				"NOVEL\r\n" + 
				"NURSE\r\n" + 
				"NUT\r\n" + 
				"OCTOPUS\r\n" + 
				"OIL\r\n" + 
				"OLIVE\r\n" + 
				"OLYMPUS\r\n" + 
				"OPERA\r\n" + 
				"ORANGE\r\n" + 
				"ORGAN\r\n" + 
				"PALM\r\n" + 
				"PAN\r\n" + 
				"PANTS\r\n" + 
				"PAPER\r\n" + 
				"PARACHUTE\r\n" + 
				"PARK\r\n" + 
				"PART\r\n" + 
				"PASS\r\n" + 
				"PASTE\r\n" + 
				"PENGUIN\r\n" + 
				"PHOENIX\r\n" + 
				"PIANO\r\n" + 
				"PIE\r\n" + 
				"PILOT\r\n" + 
				"PIN\r\n" + 
				"PIPE\r\n" + 
				"PIRATE\r\n" + 
				"PISTOL\r\n" + 
				"PIT\r\n" + 
				"PITCH\r\n" + 
				"PLANE\r\n" + 
				"PLASTIC\r\n" + 
				"PLATE\r\n" + 
				"PLATYPUS\r\n" + 
				"PLAY\r\n" + 
				"PLOT\r\n" + 
				"POINT\r\n" + 
				"POISON\r\n" + 
				"POLE\r\n" + 
				"POLICE\r\n" + 
				"POOL\r\n" + 
				"PORT\r\n" + 
				"POST\r\n" + 
				"POUND\r\n" + 
				"PRESS\r\n" + 
				"PRINCESS\r\n" + 
				"PUMPKIN\r\n" + 
				"PUPIL\r\n" + 
				"PYRAMID\r\n" + 
				"QUEEN\r\n" + 
				"RABBIT\r\n" + 
				"RACKET\r\n" + 
				"RAY\r\n" + 
				"REVOLUTION\r\n" + 
				"RING\r\n" + 
				"ROBIN\r\n" + 
				"ROBOT\r\n" + 
				"ROCK\r\n" + 
				"ROME\r\n" + 
				"ROOT\r\n" + 
				"ROSE\r\n" + 
				"ROULETTE\r\n" + 
				"ROUND\r\n" + 
				"ROW\r\n" + 
				"RULER\r\n" + 
				"SATELLITE\r\n" + 
				"SATURN\r\n" + 
				"SCALE\r\n" + 
				"SCHOOL\r\n" + 
				"SCIENTIST\r\n" + 
				"SCORPION\r\n" + 
				"SCREEN\r\n" + 
				"SCUBA DIVER\r\n" + 
				"SEAL\r\n" + 
				"SERVER\r\n" + 
				"SHADOW\r\n" + 
				"SHAKESPEARE\r\n" + 
				"SHARK\r\n" + 
				"SHIP\r\n" + 
				"SHOE\r\n" + 
				"SHOP\r\n" + 
				"SHOT\r\n" + 
				"SINK\r\n" + 
				"SKYSCRAPER\r\n" + 
				"SLIP\r\n" + 
				"SLUG\r\n" + 
				"SMUGGLER\r\n" + 
				"SNOW\r\n" + 
				"SNOWMAN\r\n" + 
				"SOCK\r\n" + 
				"SOLDIER\r\n" + 
				"SOUL\r\n" + 
				"SOUND\r\n" + 
				"SPACE\r\n" + 
				"SPELL\r\n" + 
				"SPIDER\r\n" + 
				"SPIKE\r\n" + 
				"SPINE\r\n" + 
				"SPOT\r\n" + 
				"SPRING\r\n" + 
				"SPY\r\n" + 
				"SQUARE\r\n" + 
				"STADIUM\r\n" + 
				"STAFF\r\n" + 
				"STAR\r\n" + 
				"STATE\r\n" + 
				"STICK\r\n" + 
				"STOCK\r\n" + 
				"STRAW\r\n" + 
				"STREAM\r\n" + 
				"STRIKE\r\n" + 
				"STRING\r\n" + 
				"SUB\r\n" + 
				"SUIT\r\n" + 
				"SUPERHERO\r\n" + 
				"SWING\r\n" + 
				"SWITCH\r\n" + 
				"TABLE\r\n" + 
				"TABLET\r\n" + 
				"TAG\r\n" + 
				"TAIL\r\n" + 
				"TAP\r\n" + 
				"TEACHER\r\n" + 
				"TELESCOPE\r\n" + 
				"TEMPLE\r\n" + 
				"THEATER\r\n" + 
				"THIEF\r\n" + 
				"THUMB\r\n" + 
				"TICK\r\n" + 
				"TIE\r\n" + 
				"TIME\r\n" + 
				"TOKYO\r\n" + 
				"TOOTH\r\n" + 
				"TORCH\r\n" + 
				"TOWER\r\n" + 
				"TRACK\r\n" + 
				"TRAIN\r\n" + 
				"TRIANGLE\r\n" + 
				"TRIP\r\n" + 
				"TRUNK\r\n" + 
				"TUBE\r\n" + 
				"TURKEY\r\n" + 
				"UNDERTAKER\r\n" + 
				"UNICORN\r\n" + 
				"VACUUM\r\n" + 
				"VAN\r\n" + 
				"VET\r\n" + 
				"WAKE\r\n" + 
				"WALL\r\n" + 
				"WAR\r\n" + 
				"WASHER\r\n" + 
				"WASHINGTON\r\n" + 
				"WATCH\r\n" + 
				"WATER\r\n" + 
				"WAVE\r\n" + 
				"WEB\r\n" + 
				"WELL\r\n" + 
				"WHALE\r\n" + 
				"WHIP\r\n" + 
				"WIND\r\n" + 
				"WITCH\r\n" + 
				"WORM\r\n" + 
				"YARD", appendedCodename);
	}

	// Creates List containing 25 distinct codenames selected at random
	@Test
	public void CodenameListTest() {

	}

	// Creates List containing randomly generated assignments for each of the person
	// types
	@Test
	public void PersonListTest() {

	}

	// When game started, it is Red team's move and each of Board's 25 Location
	// instances is assigned a codename, Person, and is Not Revealed
	@Test
	public void StartGameTest() {

	}

	// Method defined which correctly returns if a clue is legal or illegal
	@Test
	public void ClueLegalityTest() {

	}

	// Method defined which decrements the count, updates a Location when the
	// Location's codename was selected, and returns if the Location contained the
	// current team's Agent
	@Test
	public void CountTest() {

	}
	
	@Test
	public void LocationUpdateTest() {

	}
	
	@Test
	public void ContainsAgentTest() {

	}
	
	// Method defined which correctly returns whether or not the Board is in one of the winning states
	@Test
	public void WinningStateTest() {

	}
	
	// Method defined which correctly returns which team did not lose (i.e., win) when the Assassin was revealed
	@Test
	public void AssassinTest() {

	}

}