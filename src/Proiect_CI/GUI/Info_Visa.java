package Proiect_CI.GUI;

import java.awt.Panel;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class Info_Visa extends Panel{
	
	/**
	 * Panelul de Viza
	 */
	
	
	// Am creat campurile ce vor fi completate, in cadrul Vizei
	// Am folosit protected pentru a avea acces in Info_Destinatie, 
	// pentru a crea mesajul corespunzator tipului de CI
	protected JTextField txtNume;
	protected JTextField txtPrenume;
	protected JTextField txtId;
	protected JTextField txtNumar;
	protected JTextField txtTara;
	
	Info_Visa(){

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
		
		txtTara = new JTextField();
		txtTara.setBounds(123, 160, 167, 30);
		txtTara.setText("Tara Origine");
		txtTara.setColumns(10);
		add(txtTara);
		Focus(txtTara);
		
	}
	
	// Functie ce sterge textul initial din camp la efectuarea unui click de catre utilizator 
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
			
			// Cand se apasa click-ul se seteaza campul ca fiind gol
			@Override
			public void focusGained(FocusEvent e) {
				aux.setText("");
				
			}
		});
	}
	
	
}