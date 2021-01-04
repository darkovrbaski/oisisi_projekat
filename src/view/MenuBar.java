package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;


import controller.ProfesoriController;
import controller.StudentiController;

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
		
		
		// Action Lisiteneri 
	    miNew.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {
	    		if (TabbedPanel.currentTab == 1) {
	    			ProfesoriController.getInstance().dodajProfesora();
	    		}
	    		
	    		if (TabbedPanel.currentTab == 0) {
	    			StudentiController.getInstance().dodajStudenta();
	    		}
	        }
	      });
	    
	    
	    miClose.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {
	        	System.exit(0);
	       
	        }
	        });
		
		//dodaj
		file.add(miNew);
		file.addSeparator();
		file.add(miClose);
		
	
		file.setMnemonic(KeyEvent.VK_A);
		miNew.setMnemonic(KeyEvent.VK_Q);
		miClose.setMnemonic(KeyEvent.VK_W);
		
		miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		
		
		// Edit Sekcija
		JMenu edit  = new JMenu("Edit");
		JMenuItem miEdit = new JMenuItem("Edit", new ImageIcon("Images" + File.separator + "iconmonstr-edit-9-12.png"));
		JMenuItem miDelete = new JMenuItem("Delete", new ImageIcon("Images" + File.separator + "iconmonstr-folder-26-12.png"));
		
		
		
		// Action Lisiteneri 
	    miEdit.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent avg0) {
	        	
	    		if (TabbedPanel.currentTab == 1 && TabbedPanel.tabelaProfesora.getSelectedRow() != -1) {
	    			ProfesoriController.getInstance().izmeniProfesora();
	    		}
	    		
	    		if (TabbedPanel.currentTab == 0 && TabbedPanel.tabelaStudenata.getSelectedRow() != -1) {
	    			StudentiController.getInstance().izmeniStudenta();
	    		}
	          
	        }
	      });
	    
	    
	    miDelete.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent avg0) {
	          
	        }
	      });
		
		// dodaj
		edit.add(miEdit);
		edit.addSeparator();
		edit.add(miDelete);
		
		edit.setMnemonic(KeyEvent.VK_B);
		miEdit.setMnemonic(KeyEvent.VK_E);
		miDelete.setMnemonic(KeyEvent.VK_R);
		
		miEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		miDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		
		
		// Help Sekcija
		JMenu help = new JMenu("Help");
		JMenuItem miHelp = new JMenuItem("Help", new ImageIcon("Images" + File.separator + "iconmonstr-help-3-12.png"));
		JMenuItem miAbout = new JMenuItem("About", new ImageIcon("Images" + File.separator + "iconmonstr-pen-4-12.png"));
		
		
		
		// Action Lisiteneri 
	    miHelp.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent avg0) {
	        
	             HelpDialog dialog = new HelpDialog();
	            
	        }
	      });
	    
	    
	    miAbout.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent avg0) {
	          
	        	 AboutDialog dialog = new AboutDialog();
	        	
	        }
	      });
		
		
		// dodaj
		help.add(miHelp);
		help.addSeparator();
		help.add(miAbout);
		
		help.setMnemonic(KeyEvent.VK_C);
		miHelp.setMnemonic(KeyEvent.VK_T);
		miAbout.setMnemonic(KeyEvent.VK_Z);
		
		miHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		
		
		this.add(file);
		this.add(edit);
		this.add(help);
		
		
		
	}
	
	
	
}


