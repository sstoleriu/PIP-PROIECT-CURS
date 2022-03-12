package Proiect_CI;

/**
 * BRIDGE DESIGN PATTERN
 * - CHILD CLASS 
 * 		=> Pasaport
 */

public class Pasaport extends Tip_CI {

	// constructorul ce implementeaza constructorul delcarat in clasa parinte
	public Pasaport(Tip_destinatie destinatie, String tip) {
		super(destinatie, tip);
	}

	// adaptarea metodei abstracte in functie de nevoile clasei
	@Override
	public String Validare() {
		// returneaza o referinta a functiei Destinatie din implementor, prin intermediul variabilei destinatie declarata in clasa parinte
		return destinatie.Destinatie(tip);
	}

}
