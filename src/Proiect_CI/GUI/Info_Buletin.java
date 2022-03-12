package Proiect_CI.GUI;

import java.awt.Panel;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class Info_Buletin  extends Panel{
	
	
	/**
	 * Panelul de Buletin
	 */

	
	// Am creat campurile ce vor fi completate, in cadrul Buletinului
	// Am folosit protected pentru a avea acces in Info_Destinatie, 
	// pentru a crea mesajul corespunzator tipului de CI
	protected JTextField txtNume;
	protected JTextField txtPrenume;
	protected JTextField txtCNP;
	protected JTextField txtNumar;
	protected JTextField txtSerie;
	protected JTextField txtAdresa;
	
	Info_Buletin(){

		setLayout(null);
	
		/**
		 * Initializarea campurilor si pozitionarea lor
		 */
		
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
		
		txtCNP = new JTextField();
		txtCNP.setBounds(123, 80, 167, 30);
		txtCNP.setText("CNP");
		txtCNP.setColumns(10);
		add(txtCNP);
		Focus(txtCNP);
		
		txtNumar = new JTextField();
		txtNumar.setBounds(123, 120, 167, 30);
		txtNumar.setText("Numar");
		txtNumar.setColumns(10);
		add(txtNumar);
		Focus(txtNumar);
		
		
		txtSerie = new JTextField();
		txtSerie.setBounds(123, 160, 167, 30);
		txtSerie.setText("Serie");
		txtSerie.setColumns(10);
		add(txtSerie);
		Focus(txtSerie);
		
		txtAdresa = new JTextField();
		txtAdresa.setBounds(123, 200, 167, 30);
		txtAdresa.setText("Adresa");
		txtAdresa.setColumns(10);
		add(txtAdresa);	
		Focus(txtAdresa);
	}
	
	// Functie ce sterge textul initial din camp la efectuarea unui click de catre utilizator 
	void Focus(JTextField aux) {
		String temp = aux.getText();
		aux.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
							
				// Daca campul ramane gol, se va afisa in el textul initial
				if(aux.getText().equals("")) {
					aux.setText(temp);
					
				} else {
					aux.setText(aux.getText());	
				}		
			}
			
			// Cand se apasa click-ul se seteaza campul ca fiind gol
			@Override
			public void focusGained(FocusEvent e) {
				aux.setText("");
				
			}
		});
	}

}
