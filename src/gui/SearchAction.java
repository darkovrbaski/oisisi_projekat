package gui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class SearchAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5179282676899712661L;

	public SearchAction() {
		putValue(SHORT_DESCRIPTION, "Pretraži");


		putValue(SMALL_ICON, Frame.createImageIcon("Images/iconmonstr-magnifier-4-32.png", true, 20, 20));
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
	
}
