package gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

public class NewAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9168389995353836270L;

	public NewAction() {
		putValue(MNEMONIC_KEY, KeyEvent.VK_A);
		putValue(SHORT_DESCRIPTION, "Dodaj");
		putValue(SMALL_ICON, SSFrame.createImageIcon("Images/iconmonstr-plus-2-12.png", true, 20, 20));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
	
}
