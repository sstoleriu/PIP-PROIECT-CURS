package Proiect_CI;

/**
 * BRIDGE DESIGN PATTERN
 * - CHILD CLASS 
 * 		=> SUA_CANADA
 */

public class SUA_Canada implements Tip_destinatie {

	/**
	 * Returneaza un String in functie de argumentul oferit
	 */
	@Override
	public String Destinatie(String tip) {
		if (tip == "Viza") {
			return "Poate calatori cu " + tip;
		} else {
			return "Nu poate calatori cu " + tip + "ul";
		}

	}
}
