package view;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public MenuBar() {
		
		
		// File Sekcija
		JMenu file = new JMenu("File");
		JMenuItem miNew = new JMenuItem("New", new ImageIcon("Images" + File.separator + "iconmonstr-plus-2-12.png"));
		JMenuItem miClose = new JMenuItem("Close", new ImageIcon("Images" + File.separator + "iconmonstr-x-mark-1-12.png"));
		
		file.add(miNew);
		file.addSeparator();
		file.add(miClose);
		
	
		file.setMnemonic(KeyEvent.VK_A);
		miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		
		
		// Edit Sekcija
		JMenu edit  = new JMenu("Edit");
		JMenuItem miEdit = new JMenuItem("Edit", new ImageIcon("Images" + File.separator + "iconmonstr-edit-9-12.png"));
		JMenuItem miDelete = new JMenuItem("Delete", new ImageIcon("Images" + File.separator + "iconmonstr-folder-26-12.png"));
		
		edit.add(miEdit);
		edit.addSeparator();
		edit.add(miDelete);
		
		edit.setMnemonic(KeyEvent.VK_B);
		miEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		miDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		
		
		// Help Sekcija
		JMenu help = new JMenu("Help");
		JMenuItem miHelp = new JMenuItem("Help", new ImageIcon("Images" + File.separator + "iconmonstr-help-3-12.png"));
		JMenuItem miAbout = new JMenuItem("About", new ImageIcon("Images" + File.separator + "iconmonstr-pen-4-12.png"));
		
		help.add(miHelp);
		help.addSeparator();
		help.add(miAbout);
		
		help.setMnemonic(KeyEvent.VK_C);
		miHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		
		
		this.add(file);
		this.add(edit);
		this.add(help);
		
		
		
	}
	
	
	
}


