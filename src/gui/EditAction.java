package gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

public class EditAction extends AbstractAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7994641257537406598L;

	public EditAction() {
		putValue(MNEMONIC_KEY, KeyEvent.VK_B);
		putValue(SHORT_DESCRIPTION, "Izmeni");
		putValue(SMALL_ICON, SSFrame.createImageIcon("Images/iconmonstr-edit-9-12.png", true, 20, 20));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_MASK));
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
	
}
