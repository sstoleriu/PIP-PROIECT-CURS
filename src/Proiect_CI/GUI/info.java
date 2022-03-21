package Proiect_CI.GUI;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Panel ce contine poza ca rol de plash Screen
 */
public class info extends JLabel{
	
	/**
	 * Aici se afla imaginea de fundal
	 */
	private BufferedImage img;
	/**
	 * Constructor se initializeaza campurile
	 */
	info(){
		setBounds(0, 0, 428, 590);
		setLayout(null);
		
		try {
			img = ImageIO.read(new File("src/Images/2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Redimensionare pozei in functie de Panel
		Image dimg = img.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		setIcon(imageIcon);
		
	}
}
