package view;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import controller.ProfesoriController;

public class NewAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9168389995353836270L;

	public NewAction() {
		putValue(MNEMONIC_KEY, KeyEvent.VK_A);
		putValue(SHORT_DESCRIPTION, "Dodaj");
		putValue(SMALL_ICON, Frame.createImageIcon("Images" + File.separator + "iconmonstr-plus-4-32.png", true, 20, 20));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (TabbedPanel.currentTab == 1) {
			ProfesoriController.getInstance().dodajProfesora();
		}
	}

}
 	