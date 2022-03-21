package Proiect_CI;

/**
 * BRIDGE DESIGN PATTERN
 * - CHILD CLASS 
 * 		=> Oriunde
 */

public class Oriunde implements Tip_destinatie {
	/**
	 * Returneaza un String in functie de argumentul oferit
	 */
	@Override
	public String Destinatie(String tip) {
		if (tip == "Pasaport") {
			
			return "Poate calatori cu " + tip + "ul";
		} else {
			if(tip == "Viza") {		
				
				return "Nu poate calatori cu " + tip;
			} else {
				
				return "Nu poate calatori cu " + tip + "ul";
			}
			
		}

	}

}
