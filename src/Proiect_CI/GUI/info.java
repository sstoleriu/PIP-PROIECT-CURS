package Proiect_CI.GUI;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class info extends JLabel{
	
	/**
	 * Panel ce contine poza ca rol de plash Screen
	 */
	
	
	private BufferedImage img;
	
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
