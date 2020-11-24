package main;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class SSFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SSFrame() {
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth / 2, screenHeight / 2);
		setTitle("Studentska Sluzba");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		SSMenuBar menu = new SSMenuBar();
		this.setJMenuBar(menu);
		


		
	}
	

}