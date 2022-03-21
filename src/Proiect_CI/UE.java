package Proiect_CI;

/**
 * BRIDGE DESIGN PATTERN
 * - CHILD CLASS 
 * 		=> UE
 */

public class UE implements Tip_destinatie {
	
	/**
	 * Returneaza un String in functie de argumentul oferit
	 */
	@Override
	public String Destinatie(String tip) {
		if (tip != "Viza") {
			return "Poate calatori cu " + tip + "ul";
		} else {
			return "Nu poate calatori cu " + tip;
		}
	}
}
