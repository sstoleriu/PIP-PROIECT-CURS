package Proiect_CI.GUI;

import java.awt.Panel;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;
/**
 * 
 * @author Stefan si Ionut
 *
 */
public class Info_Pasaport extends Panel{
	
	/**
	 * Panelul de Pasaport
	 */
	
	// Am creat campurile ce vor fi completate, in cadrul Pasaportului
	// Am folosit protected pentru a avea acces in Info_Destinatie, 
	// pentru a crea mesajul corespunzator tipului de CI
	/**
	 * Var pentru nume
	 */
	protected JTextField txtNume;
	/**
	 * Var pentru Prenume
	 */
	protected JTextField txtPrenume;
	/**
	 * Var pentru ID
	 */
	protected JTextField txtId;
	/**
	 * Var pentru Numar
	 */
	protected JTextField txtNumar;
	/**
	 * Var pentru Dara
	 */
	protected JTextField txtData;
	/**
	 * Var pentru Natiune
	 */
	protected JTextField txtNatiune;
	
	/**
	* Initializarea campurilor si pozitionarea lor
	*/
	Info_Pasaport(){

		setLayout(null);
	
		
		
		txtNume = new JTextField();
		txtNume.setBounds(123, 0, 167, 30);
		txtNume.setText("Nume");
		add(txtNume);
		txtNume.setColumns(10);
		Focus(txtNume);
		
		txtPrenume = new JTextField();
		txtPrenume.setBounds(123, 40, 167, 30);
		txtPrenume.setText("Prenume");
		txtPrenume.setColumns(10);
		add(txtPrenume);
		Focus(txtPrenume);
		
		txtId = new JTextField();
		txtId.setBounds(123, 80, 167, 30);
		txtId.setText("ID");
		txtId.setColumns(10);
		add(txtId);
		Focus(txtId);
		
		txtNumar = new JTextField();
		txtNumar.setBounds(123, 120, 167, 30);
		txtNumar.setText("Numar");
		txtNumar.setColumns(10);
		add(txtNumar);
		Focus(txtNumar);
		
		txtData = new JTextField();
		txtData.setBounds(123, 160, 167, 30);
		txtData.setText("Data Nasterii");
		txtData.setColumns(10);
		add(txtData);
		Focus(txtData);
		
		txtNatiune = new JTextField();
		txtNatiune.setBounds(123, 200, 167, 30);
		txtNatiune.setText("Natiune");
		txtNatiune.setColumns(10);
		add(txtNatiune);
		Focus(txtNatiune);
		
	}
	
	/**
	 * Functie ce sterge textul initial din camp la efectuarea unui click de catre utilizator
	 * @param aux Aici se afla textul din casuta
	 */
	void Focus(JTextField aux) {
		String temp = aux.getText();
		aux.addFocusListener(new FocusListener() {
			
			// Daca campul ramane gol, se va afisa in el textul initial
			@Override
			public void focusLost(FocusEvent e) {
							
				if(aux.getText().equals("")) {
					aux.setText(temp);
					
				} else {
					aux.setText(aux.getText());	
				}		
			}
			
			@Override
			/**
			 * Cand se apasa click-ul se seteaza campul ca fiind gol
			 */
			public void focusGained(FocusEvent e) {
				aux.setText("");
				
			}
		});
	}
	
}