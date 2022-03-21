package Proiect_CI;

/**
 * BRIDGE DESIGN PATTERN
 * - IMPLEMENTOR CLASS 
 * 		=> Tip_destinatie<br>
 *      Functioneaza ca un template pentru viitoare implementari ale aceluiasi concept dinamic, avand functionalitati similare este conectat direct la clasa Tip_Ci prin variabila destinatie
 */

public interface Tip_destinatie {

	/**
	 * 
	 * @param tip Tipul de carte de identitate
	 * @return Returneaza un mesaj Specific<br>
	 * Functie generala care este suprascrisa in clasa copil
	 */
	public String Destinatie(String tip);

}