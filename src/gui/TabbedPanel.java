package gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabbedPanel extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9109758071824258550L;
	
	public TabbedPanel() {
		
		// Student sekcija
		JPanel StudentTab = new JPanel();
		ImageIcon iconS = Frame.createImageIcon("Images/iconmonstr-school-23-16.png", false, 16, 16);
		JLabel todoS = new JLabel("TODO: prikaz entiteta studenta");
		StudentTab.add(todoS);
		this.addTab("Studenti", iconS, StudentTab, "Prikaz studenta");
		
		// Profesor sekcija
		JPanel ProfesorTab = new JPanel();
		ImageIcon iconP = Frame.createImageIcon("Images/teacher-at-the-blackboard.png", true, 16, 16);
		JLabel todoP = new JLabel("TODO: prikaz entiteta profesora");
		ProfesorTab.add(todoP);
		this.addTab("Profesori", iconP, ProfesorTab, "Prikaz profesora");
		
		// Predmet sekcija
		JPanel PredmetTab = new JPanel();
		ImageIcon iconPd = Frame.createImageIcon("Images/books-stack-of-three.png", true, 16, 16);
		JLabel todoPd = new JLabel("TODO: prikaz entiteta predmet");
		PredmetTab.add(todoPd);
		this.addTab("Predmeti", iconPd, PredmetTab, "Prikaz predmeta");
		
	}
	
}
