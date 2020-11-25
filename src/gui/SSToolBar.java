package gui;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class SSToolBar extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6816043191534090577L;
	
	public SSToolBar() {
		
		super(SwingConstants.HORIZONTAL);
		
		JButton newBtn = new JButton();
		newBtn.setToolTipText("New");
		newBtn.setIcon(new ImageIcon("Images/iconmonstr-plus-2-12.png"));
		this.add(newBtn);
		
		JButton editBtn = new JButton();
		editBtn.setToolTipText("Edit");
		editBtn.setIcon(new ImageIcon("Images/iconmonstr-edit-9-12.png"));
		this.add(editBtn);
		
		JButton removeBtn = new JButton();
		removeBtn.setToolTipText("Delete");
		removeBtn.setIcon(new ImageIcon("Images/iconmonstr-folder-26-12.png"));
		this.add(removeBtn);
		
		JPanel pan = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		JTextField searchField = new JTextField();
		searchField.setColumns(20);
		pan.add(searchField);
		
		this.add(pan);
		
		JButton searchBtn = new JButton();
		searchBtn.setToolTipText("Search");
		searchBtn.setIcon(new ImageIcon("Images/iconmonstr-magnifier-4-12.png"));
		this.add(searchBtn);
		
		
		setFloatable(false);
	}
}
