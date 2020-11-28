package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

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
		setTitle("Studentska Služba");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		MenuBar menu = new MenuBar();
		this.setJMenuBar(menu);
		
		ToolBar toolbar = new ToolBar();
		this.add(toolbar, BorderLayout.NORTH);
		
		TabbedPanel tabbedpan = new TabbedPanel();
		this.add(tabbedpan, BorderLayout.CENTER);
		
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