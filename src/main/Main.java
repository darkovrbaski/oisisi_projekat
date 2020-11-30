package main;

import java.awt.Font;
import java.util.Enumeration;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import gui.Frame;

public class Main {

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			System.out.println("Look and Feel not set");
		}
		
		setUIFont(new javax.swing.plaf.FontUIResource("Tahoma", Font.PLAIN, 14));
		
		Frame studentskaSluzba = Frame.getInstance();
		studentskaSluzba.setVisible(true);
		
	}
	
	/**REFERENCA: rgagnon.com/javadetails/java-0335.html */
	public static void setUIFont(javax.swing.plaf.FontUIResource f) {
	    Enumeration<Object> keys = UIManager.getDefaults().keys();
	    while (keys.hasMoreElements()) {
	        Object key = keys.nextElement();
	        Object value = UIManager.get(key);
	        if (value instanceof javax.swing.plaf.FontUIResource)
	            UIManager.put(key, f);
	    }
	}

}
