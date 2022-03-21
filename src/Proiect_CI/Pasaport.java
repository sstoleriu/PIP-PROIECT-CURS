package Proiect_CI;

/**
 * BRIDGE DESIGN PATTERN
 * - CHILD CLASS 
 * 		=> Pasaport
 */

public class Pasaport extends Tip_CI {

	/**
	 * 
	 * @param destinatie Parametru ce va indica destinatia
	 * @param tip Parametru ce va indica tipul Cartii de Identitate<br>
	 * Constructorul ce implementeaza constructorul delcarat in clasa parinte
	 * 
	 */
	public Pasaport(Tip_destinatie destinatie, String tip) {
		super(destinatie, tip);
	}

	/**
	 * Adaptarea metodei abstracte in functie de nevoile clasei<br>
	 * Returneaza o referinta a functiei Destinatie din implementor, prin intermediul variabilei destinatie declarata in clasa parinte
	 */
	@Override
	public String Validare() {
		return destinatie.Destinatie(tip);
	}

}
