package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 780842779808006261L;
	
	private static Frame instance = null;
	
	private Frame() {
		initialise();
	}
	
	private void initialise() {
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		
		setSize(screenWidth * 3/4,screenHeight * 3/4);
		ImageIcon imageIcon = new ImageIcon("Images/iconmonstr-school-21-240.png");
		Image image = imageIcon.getImage();
		setIconImage(image);
		setTitle("Studentska Služba");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		MenuBar menu = new MenuBar();
		this.setJMenuBar(menu);
		
		ToolBar toolbar = new ToolBar();
		this.add(toolbar, BorderLayout.NORTH);
		
		JPanel pan = new JPanel();
		pan.setLayout(new BorderLayout());
		pan.setBackground(new java.awt.Color(209, 224, 240));
		pan.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
		
		TabbedPanel tabbedpan = new TabbedPanel();
		
		pan.add(tabbedpan, BorderLayout.CENTER);
		
		this.add(pan, BorderLayout.CENTER);
		
		StatusBar statusbar = new StatusBar();
		this.add(statusbar, BorderLayout.SOUTH);

	}
	
	public static Frame getInstance() {
		if(instance == null) {
			instance = new Frame();
		}
		return instance;
	}
	
	/**REFERENCA: Vezbe 05 projekat MVCExample funkcija za skaliranje ikonica */
	protected static ImageIcon createImageIcon(String path, boolean scaleImage, int width, int height) {
		if (scaleImage) {
			// how to scale image
			ImageIcon imageIcon = new ImageIcon(path); // load the image to a imageIcon
			Image image = imageIcon.getImage(); // transform it
			Image newimg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			imageIcon = new ImageIcon(newimg); // transform it back
			return imageIcon;

		} else {
			return new ImageIcon(path);
		}
	}

}