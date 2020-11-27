package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class ToolBar extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6816043191534090577L;
	
	public ToolBar() {
		
		super(SwingConstants.HORIZONTAL);
		setFloatable(false);
		
		// New sekcija
		NewAction na = new NewAction();
		JButton newBtn = new JButton(na);
		this.add(newBtn);
		
		// Edit sekcija
		EditAction ea = new EditAction();
		JButton editBtn = new JButton(ea);
		this.add(editBtn);
		
		// Remove sekcija
		DeleteAction da = new DeleteAction();
		JButton deleteBtn = new JButton(da);
		this.add(deleteBtn);
		
		// Search field sekcija
		JPanel rightPan = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		rightPan.setOpaque(false);
		
		JTextField searchField = new JTextField();
		searchField.setPreferredSize(new Dimension(250, 28));
		searchField.setToolTipText("Polje za unos pretrage");
		rightPan.add(searchField);
		
		this.add(rightPan);
		
		// Search button sekcija
		SearchAction sa = new SearchAction();
		JButton searchBtn = new JButton(sa);
		this.add(searchBtn);	
	}
}
