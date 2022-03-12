package Proiect_CI;

/**
 * BRIDGE DESIGN PATTERN
 * - ABSTRACTIZATION CLASS 
 * 		=> Tip_CI
 *      * functioneaza ca un template pentru viitoare implementari ale aceluiasi concept, avand functionalitati similare 
 */

public abstract class Tip_CI {

	// referinta la implementor
	protected Tip_destinatie destinatie;
	// variabila de tip String pentru a determina tipul de document
	public String tip;

	// Constructor
	public Tip_CI(Tip_destinatie destinatie, String tip) {
		this.destinatie = destinatie;
		this.tip = tip;
	}
	// metoda abstracta ce urmeaza a fi suprascrisa in fiecare clasa copil a abstractizarii
	abstract public String Validare();
}
