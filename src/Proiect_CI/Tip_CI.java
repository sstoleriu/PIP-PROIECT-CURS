package Proiect_CI;

/**
 * BRIDGE DESIGN PATTERN
 * - ABSTRACTIZATION CLASS 
 * 		=> Tip_CI <br>
 *       functioneaza ca un template pentru viitoare implementari ale aceluiasi concept, avand functionalitati similare 
 */

public abstract class Tip_CI {
	
	/**
	 * Parametru ce va indica destinatia
	 */
	protected Tip_destinatie destinatie;
	/**
	 * Parametru ce va indica tipul Cartii de Identitate
	 */
	public String tip;

	/**
	 * Constructor<br>
	 *  @param 	destinatie	Parametru ce va indica destinatia
	 *  @param 	tip	Parametru ce va indica tipul Cartii de Identitate
	 */
	public Tip_CI(Tip_destinatie destinatie, String tip) {
		this.destinatie = destinatie;
		this.tip = tip;
	}
	/**
	 * Metoda abstracta ce urmeaza a fi suprascrisa in fiecare clasa copil a abstractizarii<br>
	 * @return Returneaza un mesaj specific
	 */
	abstract public String Validare();
}
