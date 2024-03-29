package view;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TabbedPanel extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9109758071824258550L;

	public static int currentTab = 0;
	public static Table tabelaProfesora;
	public static Table tabelaPredmeta;
	
	public static StudentTable tabelaStudenata;
	
	public TabbedPanel() {

		// Student sekcija
		JPanel studentTab = new JPanel();
		studentTab.setLayout(new BorderLayout()); 
		ImageIcon iconS = Frame.createImageIcon("Images" + File.separator + "iconmonstr-school-23-16.png", false, 16, 16);
		tabelaStudenata = new StudentTable();
		JScrollPane scrollPanee = new JScrollPane(tabelaStudenata);	
		studentTab.add(scrollPanee, BorderLayout.CENTER);
		this.addTab("Studenti", iconS, studentTab, "Prikaz studenta");

		// Profesor sekcija
		JPanel profesorTab = new JPanel();
		profesorTab.setLayout(new BorderLayout());
		ImageIcon iconP = Frame.createImageIcon("Images" + File.separator + "teacher-at-the-blackboard.png", true, 16, 16);
		tabelaProfesora = new Table();
		tabelaProfesora.setModel(new AbstractTableModelProfesori());
		JScrollPane scrollPane = new JScrollPane(tabelaProfesora);
		profesorTab.add(scrollPane, BorderLayout.CENTER);
		this.addTab("Profesori", iconP, profesorTab, "Prikaz profesora");

		// Predmet sekcija
		JPanel predmetTab = new JPanel();
		predmetTab.setLayout(new BorderLayout());
		ImageIcon iconPd = Frame.createImageIcon("Images" + File.separator + "books-stack-of-three.png", true, 16, 16);
		tabelaPredmeta = new Table();
		tabelaPredmeta.setModel(new AbstractTableModelPredmeti());
		JScrollPane scrollPanePredmeti = new JScrollPane(tabelaPredmeta);
		predmetTab.add(scrollPanePredmeti, BorderLayout.CENTER);
		this.addTab("Predmeti", iconPd, predmetTab, "Prikaz predmeta");
		
		this.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				JTabbedPane tabbedPane = (JTabbedPane) e.getSource();
				currentTab = tabbedPane.getSelectedIndex();
			}
		});

	}

}
