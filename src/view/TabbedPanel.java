package view;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class TabbedPanel extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9109758071824258550L;

	public TabbedPanel() {

		// Student sekcija
		JPanel studentTab = new JPanel();
		ImageIcon iconS = Frame.createImageIcon("Images" + File.separator + "iconmonstr-school-23-16.png", false, 16, 16);
		JLabel todoS = new JLabel("TODO: prikaz entiteta studenta");
		studentTab.add(todoS);
		this.addTab("Studenti", iconS, studentTab, "Prikaz studenta");

		// Profesor sekcija
		JPanel profesorTab = new JPanel();
		profesorTab.setLayout(new BorderLayout());
		ImageIcon iconP = Frame.createImageIcon("Images" + File.separator + "teacher-at-the-blackboard.png", true, 16, 16);
		ProfesorTable profTable = new ProfesorTable();
		JScrollPane scrollPane = new JScrollPane(profTable);
		profesorTab.add(scrollPane, BorderLayout.CENTER);
		this.addTab("Profesori", iconP, profesorTab, "Prikaz profesora");

		// Predmet sekcija
		JPanel predmetTab = new JPanel();
		ImageIcon iconPd = Frame.createImageIcon("Images" + File.separator + "books-stack-of-three.png", true, 16, 16);
		JLabel todoPd = new JLabel("TODO: prikaz entiteta predmet");
		predmetTab.add(todoPd);
		this.addTab("Predmeti", iconPd, predmetTab, "Prikaz predmeta");

	}

}
