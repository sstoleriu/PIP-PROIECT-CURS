package Proiect_CI.GUI;

import java.awt.Dimension;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JComboBox;
import java.awt.Panel;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 
 * @author Stefan Stoleriu, Ionut Sopon
 *
 */
public class App {
	/**
	 * Variabila de tip String pentru a afla tipul de CI din ComboBox
	 */
	protected static String CI = null;
	/**
	 * Fereastra aplicatiei
	 */
	private JFrame frame;
	/**
	 * Un panel ce se afla in partea de sus a ferestrei
	 */
	private Panel SUS;
	/**
	 * Un panel ce se afla in partea de jos a ferestrei
	 */
	private Panel JOS;
	/**
	 * Un masiv de date, de tip String pentru a stoca variantele ce pot fi alese
	 */
	String Tip_CI[] = {"Buletin", "Viza", "Pasaport"};	
	/**
	 * Un comboBox, ce ne da posibilitatea de a alege tipul de CI, variantele fiind stocate in Tip_CI
	 */
	JComboBox<String> comboBox1 = new JComboBox<String>(Tip_CI);

	/**
	 * Se lanseaza Aplicatia
	 * @param args variabila unde sunt argumentele
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Se creaza Aplicatia
	 */
	public App() {
		initialize();
	}
	/**
	 * Se initializeaza componentele, si sunt adaugate in fereastra
	 */
	private void initialize() {
		
		
		// Generarea dimensiunelor ferestrei in functie de dimensiunile ecranului pentru o centrare a acesteia
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int X = screenSize.width/2-214;
		int Y = Math.abs((726 - screenSize.height)/2);
		
		frame = new JFrame();
		frame.setBounds(X, Y, 428, 590);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Creare CI");
		frame.getContentPane().setLayout(null);
		
		// Primul Panel ce va fi afisat pe post de splash screen
		info Panel_Info = new info();
		frame.add(Panel_Info);
		
		// Initializarea panelului de sus ce contine logoul si comboBoxul
		SUS = new Panel();
		SUS.setBounds(0, 0, 414, 151);
		frame.getContentPane().add(SUS);
		SUS.setLayout(null);
		
		// Pozitionarea comboBoxului si adaugarea in Panel SUS
		comboBox1.setBounds(123, 120, 167, 30);
		SUS.add(comboBox1);
		
		// Crearea obiectului de tip BufferedImage pentru logo
		BufferedImage logo = null;
		try {
			logo = ImageIO.read(new File("src/Images/logo.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		};
		
		JLabel Logo_Label = new JLabel();
		Logo_Label.setBounds(0, 0, 428, 110);
		
		ImageIcon imageIcon = new ImageIcon(logo);
		
		// Adaugarea logoului in Panel SUS
		Logo_Label.setIcon(imageIcon);
		SUS.add(Logo_Label);
		
		// Initializarea panelului de jos ce contine butoanele de navigatie
		JOS = new Panel();
		JOS.setBounds(0, 503, 420, 50);
		frame.getContentPane().add(JOS);		
		
		// Crearea si initializarea Panelurile pentru fiecare tip de CI
		// Buletin
		Info_Buletin Panel_Buletin = new Info_Buletin();
		Panel_Buletin.setBounds(0, 157, 414, 343);
		frame.getContentPane().add(Panel_Buletin);
		Panel_Buletin.setLayout(null);
		Panel_Buletin.setVisible(false);
		
		// Visa
		Info_Visa Panel_Visa = new Info_Visa();
		Panel_Visa.setBounds(0, 157, 414, 343);
		frame.getContentPane().add(Panel_Visa);
		Panel_Visa.setLayout(null);
		Panel_Visa.setVisible(false);
		
		// Pasaport
		Info_Pasaport Panel_Pasaport = new Info_Pasaport();
		Panel_Pasaport.setBounds(0, 157, 414, 343);
		frame.getContentPane().add(Panel_Pasaport);
		Panel_Pasaport.setLayout(null);
		Panel_Pasaport.setVisible(false);
		
		// Crearea si initializare ultimului panel ce contine butonul de verificare 
		// si o componenta de tip JTextArea ce ne va indica mesajul corespunzator, 
		// dat de algoritmul creat folosind BRIGDE PATTERN
		Info_Destinatie Panel_Destinatie = new Info_Destinatie();
		Panel_Destinatie.setBounds(0, 157, 414, 343);
		frame.getContentPane().add(Panel_Destinatie);
		Panel_Destinatie.setLayout(null);
		Panel_Destinatie.setVisible(false);
		
		// Crearea si initializarea butoanelor de navigatie
		JButton Urmatorul = new JButton("Urmatorul");
		JButton Creeaza = new JButton("Creeaza");
		JButton Inapoi = new JButton("Inapoi");
		JButton Inapoi2 = new JButton("Inapoi");
		JButton Home = new JButton("Alege CI");
	
		// Crearea unui Delay, ce va tine afisat primul Panel (Panel_info), tip de 2 secunde pe fereastra
		int delay = 2000; // 2 secunde
		  ActionListener taskPerformer = new ActionListener() {
		      public void actionPerformed(ActionEvent evt) {
		    	  Panel_Info.setVisible(false);
					SUS.setVisible(true);
					JOS.setVisible(true);
		      }
		  };
		  new Timer(delay, taskPerformer).start();

		// Functionalitatea butonului Urmatorul
		Urmatorul.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				// Se salveaza in CI optiunea aleasa si se va afisa Panelul corespunzator
				CI = String.valueOf(comboBox1.getSelectedItem());
				Panel_Destinatie.SetInfo_Destinatie(CI);
				comboBox1.setEnabled(false);
				Inapoi.setVisible(true);
				Urmatorul.setVisible(false);
				Creeaza.setVisible(true);
				
				// Switch folosit pentru a seta Panelul corespunzator sa fie vizibil
				switch (CI) {
				case "Buletin": {
					Panel_Buletin.setVisible(true);
					break;		
				}
				
				case "Viza": {
					Panel_Visa.setVisible(true);
					break;
				}
				
				case "Pasaport": {
					Panel_Pasaport.setVisible(true);
					break;
				}
				default:
					throw new IllegalArgumentException("Valoarea neasteptata: " + CI);
				}
			}
		});
		JOS.add(Urmatorul);	// Am adaugat butonul in Panel JOS
		
		// Functionalitatea butonului Inapoi
		Inapoi.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// Din Panelul corespunzator alegerii facute, ne intoarcem in Panelul de selectie
				Panel_Buletin.setVisible(false);
				Panel_Visa.setVisible(false);
				Panel_Pasaport.setVisible(false);
				Inapoi.setVisible(false);
				Creeaza.setVisible(false);
				Urmatorul.setVisible(true);
				comboBox1.setEnabled(true);
			}
		});

		JOS.add(Inapoi); // Am adaugat butonul in Panel JOS
		Inapoi.setVisible(false); // Am setat butonul pe false deoarece nu mai aveam nevoie de el
		
		// Functionalitatea butonului Creaza
		Creeaza.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
			// Dupa ce au fost introduse datele, butonul Creaza trece la urmatorul Panel, cel de verificare	
				Creeaza.setVisible(false);
				Inapoi.setVisible(false);
				Inapoi2.setVisible(true);
				Panel_Buletin.setVisible(false);
				Panel_Visa.setVisible(false);
				Panel_Pasaport.setVisible(false);
				Panel_Destinatie.setVisible(true);
				comboBox1.setVisible(false);
				Home.setVisible(true);
				Panel_Destinatie.Mesaj.setText("");
				
				
				
				// Un switch pentru a apela metoda de a seta mesajul corespunzator, cu datele introduse
				// Fiind diferite date, in functie de CI, s-a creat metode diferite
				switch (CI) {
				case "Buletin": {
					Panel_Destinatie.SetMesajBuletin(Panel_Buletin);
					break;
					
				}
				case "Viza": {
					Panel_Destinatie.SetMesajViza(Panel_Visa);
					break;
					
				}
				case "Pasaport": {
					Panel_Destinatie.SetMesajPasaport(Panel_Pasaport);
					break;
					
				}
				default:
					throw new IllegalArgumentException("Valoarea neasteptata (Setare Mesaj) : " + CI);
				}
				
				
			}
		});
		JOS.add(Creeaza); // Am adaugat butonul in Panel JOS
		Creeaza.setVisible(false);  // Am setat butonul pe false deoarece nu mai aveam nevoie de el
		
		// Functionalitatea butonului Inapoi2
		// Butonul e cel afisat pe ultimul Panel, cel de verificare
		Inapoi2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// Ne duce la Panelul anterior, unde se introduc datele
				Panel_Destinatie.setVisible(false);
				Inapoi2.setVisible(false);
				Inapoi.setVisible(true);			
				Creeaza.setVisible(true);
				comboBox1.setVisible(true);
				Home.setVisible(false);
				
				// Un switch pentru a stii ce panel sa se afiseze cand e apasat butonul
				switch (CI) {
				case "Buletin": {
					Panel_Buletin.setVisible(true);
					break;		
				}
				
				case "Viza": {
					Panel_Visa.setVisible(true);
					break;
				}
				
				case "Pasaport": {
					Panel_Pasaport.setVisible(true);
					break;
				}
				default:
					throw new IllegalArgumentException("Valoarea neasteptata: " + CI);
				}
				
			}
		});
		
		JOS.add(Inapoi2); // Am adaugat butonul in Panel JOS
		Inapoi2.setVisible(false); // Am setat butonul pe false deoarece nu mai aveam nevoie de el
		
		
		// Functionalitatea butonului Home
		// Butonul e cel afisat pe ultimul Panel, cel ce te aduce inapoi la Panelul de selectie
		Home.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Panel_Destinatie.setVisible(false);
				comboBox1.setVisible(true);
				comboBox1.setEnabled(true);
				Inapoi2.setVisible(false);
				Home.setVisible(false);
				Urmatorul.setVisible(true);
			}
		});
		JOS.add(Home);  // Am adaugat butonul in Panel JOS
		Home.setVisible(false); // Am setat butonul pe false deoarece nu mai aveam nevoie de el
			
	}
}
