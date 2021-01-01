package view;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import controller.PredmetController;

public class DeleteAction extends AbstractAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6760985195515950519L;

	public DeleteAction() {
		putValue(MNEMONIC_KEY, KeyEvent.VK_D);
		putValue(SHORT_DESCRIPTION, "Obriši");
		putValue(SMALL_ICON, Frame.createImageIcon("Images" + File.separator + "iconmonstr-trash-can-27-32.png", true, 20, 20));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (TabbedPanel.currentTab == 2 && TabbedPanel.tabelaPredmeta.getSelectedRow() != -1) {
			PredmetController.getInstance().izbrisiPredmet();
		}
	}

}
