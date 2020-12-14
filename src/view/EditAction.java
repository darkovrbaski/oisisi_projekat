package view;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

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
		putValue(SMALL_ICON, Frame.createImageIcon("Images" + File.separator + "iconmonstr-pencil-7-32.png", true, 20, 20));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
	
}
