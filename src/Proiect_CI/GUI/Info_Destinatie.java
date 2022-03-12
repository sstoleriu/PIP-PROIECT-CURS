package Proiect_CI.GUI;

import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

import Proiect_CI.Buletin;
import Proiect_CI.Oriunde;
import Proiect_CI.Pasaport;
import Proiect_CI.SUA_Canada;
import Proiect_CI.Tip_CI;
import Proiect_CI.UE;
import Proiect_CI.Viza;

public class Info_Destinatie extends Panel{
	
	/**
	 * Panelul de verificare si afisarea textului corespunzator
	 */
	
	
	// Un masiv de date, de tip String pentru a stoca variantele ce pot fi alese
	private String Locatie[] = {"SUA sau Canada", "UE", "Oriunde"};		
	// Un comboBox, ce ne da posibilitatea de a alege tipul de destinatie, variantele fiind stocate in Locatie
	private JComboBox<String> comboBox = new JComboBox<String>(Locatie);
	//Butonul de verificare
	private JButton Verificare;
	// Componenta ce va afisa textul
	protected JTextArea Mesaj;
	// Variabila ce va stoca textul
	private String msj;
	
	public Info_Destinatie() {
		setLayout(null);
		
		/**
		 * Initializarea campurilor si pozitionarea lor
		 */
		
		comboBox.setBounds(123, 0, 167, 30);
		add(comboBox);
		
		
		Mesaj = new JTextArea();
		Mesaj.setBounds(50, 80, 315, 100);
		Mesaj.setEditable(false);
		add(Mesaj);
		
		
		Verificare = new JButton("Verificare");
		Verificare.setBounds(123, 40, 167, 30);
		add(Verificare);
	}
	
	// Functie ce va initializa variabile Carte_Identitate, in functie de CI ales
	void SetInfo_Destinatie(String CI){
	
		
		Verificare.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				String Destinatie;
				Destinatie = String.valueOf(comboBox.getSelectedItem());
				
				Tip_CI Carte_Identitate;

				// Un switch ce va alege ce initializare sa foloseasca
				// Aici gasim legatura cu aplicatie propriu zisa,
				// initializarea facandu-se conform BRIDGE PATTERN
				
				switch (CI) {
				// In cazul in care am ales Buletinul
				case "Buletin": {
									// Alegerea in functie de locatia aleasa
									switch (Destinatie) {
										case "UE": {
											Carte_Identitate = new Buletin(new UE(), CI);
											break;
										}
										
										case "SUA sau Canada": {
											Carte_Identitate = new Buletin(new SUA_Canada(), CI);
											break;
										}
										
										case "Oriunde": {
											Carte_Identitate = new Buletin(new Oriunde(), CI);
											break;
										}
										default:
											throw new IllegalArgumentException("Valoare neasteptata (Buletin): " + Destinatie);
									}
					break;
				}
				
				
				// In cazul in care am ales Viza
				case "Viza": {
								// Alegerea in functie de locatia aleasa
								switch (Destinatie) {
									case "UE": {
										Carte_Identitate = new Viza(new UE(), CI);
										break;
									}
						
									case "SUA sau Canada": {
										Carte_Identitate = new Viza(new SUA_Canada(), CI);
										break;
									}
						
									case "Oriunde": {
										Carte_Identitate = new Viza(new Oriunde(), CI);
										break;
									}	
									default:
										throw new IllegalArgumentException("Valoare neasteptata (Viza): " + Destinatie);
									}
					break;
				}
				
				// In cazul in care am ales Pasaportul
				case "Pasaport": {
									// Alegerea in functie de locatia aleasa
									switch (Destinatie) {
										case "UE": {
											Carte_Identitate = new Pasaport(new UE(), CI);
											break;
										}
			
										case "SUA sau Canada": {
											Carte_Identitate = new Pasaport(new SUA_Canada(), CI);
											break;
										}
			
										case "Oriunde": {
											Carte_Identitate = new Pasaport(new Oriunde(), CI);
											break;
										}	
										default:
											throw new IllegalArgumentException("Valoare neasteptata (Pasaport): " + Destinatie);
									}
		break;
	}
				
				default:
					throw new IllegalArgumentException("Valoare neasteptata: " + CI);
				}
				
				// Adaugarea textului returnat de functia Validare(), creata folosind BRIDGE PATTERN
				// In msj deja este textul in functie de CI
				msj += Carte_Identitate.Validare();
				// Setarea textului in Componenta JAreaText
				Mesaj.setText(msj);
				// Stergerea mesajul returnat de functia Validare(),
				// pentru a utiliza programul de mai multe ori, fara a fi inchis
				// si afisa mesajul diferit
				msj = msj.replaceAll(Carte_Identitate.Validare(), "");
				
			}
		});
		
		
	}
	
	/**
	 * Functii ce au fost folosite pentru a seta mesajul in functie de,
	 * Tipul de Carte de Identitate, fiecare avand campuri diferite de completat
	 */
	
	
	void SetMesajBuletin(Info_Buletin bul) {
		
		this.msj = "Persoana: " + bul.txtNume.getText() + " " + bul.txtPrenume.getText()+"\n";
		this.msj += "CNP: " + bul.txtCNP.getText() + "\n";
		this.msj += "Numar: " + bul.txtNumar.getText() + " Seria: " + bul.txtSerie.getText() + "\n";
		this.msj += "Adresa: " + bul.txtAdresa.getText() + "\n";
			
	}
	
	void SetMesajViza(Info_Visa viza) {
		this.msj = "Persoana: " + viza.txtNume.getText() + " " + viza.txtPrenume.getText()+"\n";
		this.msj += "ID: " + viza.txtId.getText() + "\n";
		this.msj += "Numar: " + viza.txtNumar.getText() + "\n";
		this.msj += "Tara Origine: " + viza.txtTara.getText() + "\n";
		
	}
	
	void SetMesajPasaport(Info_Pasaport pas) {
		this.msj = "Persoana: " + pas.txtNume.getText() + " " + pas.txtPrenume.getText()+"\n";
		this.msj += "ID: " + pas.txtId.getText() + "\n";
		this.msj += "Numar: " + pas.txtNumar.getText() + "\n";
		this.msj += "Data: " + pas.txtData.getText() + "\n";
		this.msj += "Natiune: " + pas.txtNatiune.getText() + "\n";
		
		
	}
	
}