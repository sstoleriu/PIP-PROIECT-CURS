package Proiect_CI;

/**
 * BRIDGE DESIGN PATTERN
 * - CHILD CLASS 
 * 		=> UE
 */

public class UE implements Tip_destinatie {
	
	// returneaza un String in functie de argumentul oferi
	@Override
	public String Destinatie(String tip) {
		if (tip != "Viza") {
			return "Poate calatori cu " + tip + "ul";
		} else {
			return "Nu poate calatori cu " + tip;
		}
	}
}
