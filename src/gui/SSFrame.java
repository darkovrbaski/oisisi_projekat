package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class SSFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 780842779808006261L;
	
	private static SSFrame instance = null;
	
	private SSFrame() {
		initialise();
	}
	
	private void initialise() {
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		
		setSize(3 * screenWidth / 4, 3 * screenHeight / 4);
		setTitle("Studentska Služba");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		SSMenuBar menu = new SSMenuBar();
		this.setJMenuBar(menu);
		
		SSToolBar toolbar = new SSToolBar();
		this.add(toolbar, BorderLayout.NORTH);
		

	}
	
	public static SSFrame getInstance() {
		if(instance == null) {
			instance = new SSFrame();
		}
		return instance;
	}

}