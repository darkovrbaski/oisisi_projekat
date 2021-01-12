package view;

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
	
	public static JTextField searchField;
	
	public ToolBar() {
		
		super(SwingConstants.HORIZONTAL);
		setFloatable(false);
		this.setBackground(new java.awt.Color(225, 230, 246));
		
		this.addSeparator(new Dimension(10, 0));
		
		// New sekcija
		NewAction na = new NewAction();
		JButton newBtn = new JButton(na);
		newBtn.setOpaque(false);
		newBtn.setBorder(null);
		this.add(newBtn);
		
		this.addSeparator(new Dimension(10, 0));
		
		// Edit sekcija
		EditAction ea = new EditAction();
		JButton editBtn = new JButton(ea);
		editBtn.setOpaque(false);
		editBtn.setBorder(null);
		this.add(editBtn);
		
		this.addSeparator(new Dimension(10, 0));
		
		// Remove sekcija
		DeleteAction da = new DeleteAction();
		JButton deleteBtn = new JButton(da);
		deleteBtn.setOpaque(false);
		deleteBtn.setBorder(null);
		this.add(deleteBtn);
		
		// Search field sekcija
		JPanel rightPan = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		rightPan.setOpaque(false);
		
		searchField = new JTextField();
		searchField.setPreferredSize(new Dimension(250, 25));
		searchField.setToolTipText("Polje za unos pretrage");
		rightPan.add(searchField);
		
		this.add(rightPan);
		
		// Search button sekcija
		SearchAction sa = new SearchAction();
		JButton searchBtn = new JButton(sa);
		searchBtn.setOpaque(false);
		searchBtn.setBorder(null);
		this.add(searchBtn);

		this.addSeparator(new Dimension(10, 0));
	}
}
