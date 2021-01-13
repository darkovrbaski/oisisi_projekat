package view.dialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.PredmetController;
import controller.ProfesoriController;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.Predmet;
import view.Frame;
import view.TabbedPanel;
import view.dialogs.TextFieldPredmet.Provera;

public class IzmeniPredmetDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6315505545841118187L;

	private Predmet predmet;
	public static JTextField txtSifraPredmeta;
	public static JTextField txtNaziv;
	public static JTextField txtBrojESPB;
	public static JTextField txtGodina;
	
	
	public static JComboBox<String> cbSemestar;
	
	private JButton btnPotvrdi;
	
	private DocumentListener documentListener = new DocumentListener() {

		// TODO: proveriPopunjenostIzmenjenihPolja
		@Override
		public void removeUpdate(DocumentEvent e) {
			if (PredmetController.getInstance().proveriPopunjenostIzmenjenihPoljaPredmeta()) {
				btnPotvrdi.setEnabled(true);
			} else {
				btnPotvrdi.setEnabled(false);
			}
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			if (PredmetController.getInstance().proveriPopunjenostIzmenjenihPoljaPredmeta()) {
				btnPotvrdi.setEnabled(true);
			} else {
				btnPotvrdi.setEnabled(false);
			}
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			if (PredmetController.getInstance().proveriPopunjenostIzmenjenihPoljaPredmeta()) {
				btnPotvrdi.setEnabled(true);
			} else {
				btnPotvrdi.setEnabled(false);
			}
		}
	};
	
	
	
	
	public IzmeniPredmetDialog() {
		super(Frame.getInstance(), "Izmena predmeta", true);
		this.setResizable(false);
		this.setSize(500, 600);
		this.setLocationRelativeTo(Frame.getInstance());
		
		predmet = BazaPredmeta.getInstance().getRow(TabbedPanel.tabelaPredmeta.getCurrentSelectedRow());

		JTabbedPane tabbedPanel = new JTabbedPane();

		JPanel informacijeTab = informacijePredmeta();
		tabbedPanel.addTab("Informacije", informacijeTab);

		//JPanel predmetiTab = predmetiProfesora(this);
		//tabbedPanel.addTab("Predmeti", predmetiTab);

		this.add(tabbedPanel);
		this.setVisible(true);
		
	}
	
	
	
	
	private JPanel informacijePredmeta() {
		JPanel panel = new JPanel();
		
		panel.setLayout(new BorderLayout(0, 30));
		JPanel panTop = new JPanel();
		panel.add(panTop, BorderLayout.CENTER);
		GridBagLayout gb = new GridBagLayout();
		panTop.setLayout(gb);

		
		

		
		
		// NAZIV
		JLabel lblNaziv = new JLabel("Naziv*");
		GridBagConstraints gbc_lblNaziv = new GridBagConstraints();
		gbc_lblNaziv.anchor = GridBagConstraints.WEST;
		gbc_lblNaziv.insets = new Insets(20, 0, 5, 20);
		gbc_lblNaziv.gridx = 0;
		gbc_lblNaziv.gridy = 0;
		panTop.add(lblNaziv, gbc_lblNaziv);

		
		txtNaziv = new TextFieldPredmet("Naziv", Provera.naziv, "Proverite uneti naziv.\nPolje sadrÅ¾i nedozvoljene karaktere!");
		txtNaziv.setText(predmet.getNaziv());
		GridBagConstraints gbc_txtNaziv = new GridBagConstraints();
		gbc_txtNaziv.gridwidth = 3;
		gbc_txtNaziv.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNaziv.insets = new Insets(20, 20, 0, 20);
		gbc_txtNaziv.gridx = 1;
		gbc_txtNaziv.gridy = 0;
		panTop.add(txtNaziv, gbc_txtNaziv);
		
		// ---------------------------------
		
		// SIFRA PREDMETA 
		
		
		JLabel lblSifraPredmeta = new JLabel("Sifra Predmeta*");
		GridBagConstraints gbc_lblSifraPredmeta = new GridBagConstraints();
		gbc_lblSifraPredmeta.anchor = GridBagConstraints.WEST;
		gbc_lblSifraPredmeta.insets = new Insets(20, 0, 5, 20);
		gbc_lblSifraPredmeta.gridx = 0;
		gbc_lblSifraPredmeta.gridy = 1;
		panTop.add(lblSifraPredmeta, gbc_lblSifraPredmeta);

		
	
		
		txtSifraPredmeta = new TextFieldPredmet("Sifra predmeta", Provera.sifraPredmeta,
				"Proverite unetu sifru predmeta.\nPolje sadrÅ¾i nedozvoljene karaktere!");
		txtSifraPredmeta.setText(predmet.getSifraPredmeta());
		txtSifraPredmeta.setEditable(false);
		GridBagConstraints gbc_txtSifraPredmeta = new GridBagConstraints();
		gbc_txtSifraPredmeta.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSifraPredmeta.gridwidth = 3;
		gbc_txtSifraPredmeta.insets = new Insets(20, 20, 0, 20);
		gbc_txtSifraPredmeta.gridx = 1;
		gbc_txtSifraPredmeta.gridy = 1;
		panTop.add(txtSifraPredmeta, gbc_txtSifraPredmeta);
		
		
		// ---------------------------------
		
		// BROJ ESPB
		JLabel lblBrojESPB = new JLabel("Broj ESPB*");
		GridBagConstraints gbc_lblBrojESPB = new GridBagConstraints();
		gbc_lblBrojESPB.anchor = GridBagConstraints.WEST;
		gbc_lblBrojESPB.insets = new Insets(20, 0, 5, 20);
		gbc_lblBrojESPB.gridx = 0;
		gbc_lblBrojESPB.gridy = 2;
		panTop.add(lblBrojESPB, gbc_lblBrojESPB);

		
		
		int intBrojESPB = predmet.getBrojESPB();
		String strBrojESPB=String.valueOf(intBrojESPB);
		
		txtBrojESPB = new TextFieldPredmet("Broj ESPB", Provera.brojESPB,
				"Proverite uneti broj ESPB bodova.\\nPolje sadrÅ¾i nedozvoljene karaktere!");
		txtBrojESPB.setText(strBrojESPB);
		GridBagConstraints gbc_txtBrojESPB = new GridBagConstraints();
		gbc_txtBrojESPB.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBrojESPB.gridwidth = 3;
		gbc_txtBrojESPB.insets = new Insets(20, 20, 0, 20);
		gbc_txtBrojESPB.gridx = 1;
		gbc_txtBrojESPB.gridy = 2;
		panTop.add(txtBrojESPB, gbc_txtBrojESPB);
		
		
		// ---------------------------------
		
		
		// GODINA
		JLabel lblGodina = new JLabel("Godina*");
		GridBagConstraints gbc_lblGodina = new GridBagConstraints();
		gbc_lblGodina.anchor = GridBagConstraints.WEST;
		gbc_lblGodina.insets = new Insets(20, 0, 5, 20);
		gbc_lblGodina.gridx = 0;
		gbc_lblGodina.gridy = 3;
		panTop.add(lblGodina, gbc_lblGodina);

		
		int intGodina = predmet.getGodina();
		String strGodina=String.valueOf(intGodina);
		
		txtGodina = new TextFieldPredmet("Godina", Provera.godina,
				"Proverite uneti broj ESPB bodova.\\nPolje sadrÅ¾i nedozvoljene karaktere!");
		txtGodina.setText(strGodina);
		GridBagConstraints gbc_txtGodina = new GridBagConstraints();
		gbc_txtGodina.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGodina.gridwidth = 3;
		gbc_txtGodina.insets = new Insets(20, 20, 0, 20);
		gbc_txtGodina.gridx = 1;
		gbc_txtGodina.gridy = 3;
		panTop.add(txtGodina, gbc_txtGodina);
		
		
		
		// ---------------------------------
		
		
		// SEMESTAR
		JLabel lblSemestar = new JLabel("Semestar*");
		GridBagConstraints gbc_lblSemestar = new GridBagConstraints();
		gbc_lblSemestar.anchor = GridBagConstraints.WEST;
		gbc_lblSemestar.insets = new Insets(20, 0, 5, 20);
		gbc_lblSemestar.gridx = 0;
		gbc_lblSemestar.gridy = 4;
		panTop.add(lblSemestar, gbc_lblSemestar);

		String[] trSemestar = { "Letnji", "Zimski" };
		cbSemestar = new JComboBox<String>(trSemestar);
		switch ( predmet.getSemestar() ) {
		case Letnji:
			cbSemestar.setSelectedIndex(0);
			break;
		case Zimski:
			cbSemestar.setSelectedIndex(1);
			break;
		}
		GridBagConstraints gbc_cbSemestar = new GridBagConstraints();
		gbc_cbSemestar.gridwidth = 3;
		gbc_cbSemestar.insets = new Insets(20, 20, 0, 20);
		gbc_cbSemestar.gridx = 1;
		gbc_cbSemestar.gridy = 4;
		cbSemestar.setPreferredSize(new Dimension(205, 20));
		panTop.add(cbSemestar, gbc_cbSemestar);
		
		
		// ---------------------------------
		
		
		

		JPanel panBottom = new JPanel();
		panel.add(panBottom, BorderLayout.SOUTH);
		panBottom.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));

		txtNaziv.getDocument().addDocumentListener(documentListener);
		txtSifraPredmeta.getDocument().addDocumentListener(documentListener);
		txtBrojESPB.getDocument().addDocumentListener(documentListener);
		txtGodina.getDocument().addDocumentListener(documentListener);
		

		
		// TODO: proveriIzmenuPredmeta   proveriIzmenuPredmeta
		btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setEnabled(false);
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PredmetController.getInstance().proveriIzmenuPredmeta() == true) {
					dispose();
				}
			}
		});
		panBottom.add(btnPotvrdi);

		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panBottom.add(btnOdustani);
		
		JButton btnUkloni = new JButton("-");
		panBottom.add(btnUkloni);
		btnUkloni.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PredmetController.getInstance().uklanjanjeProfesoraPredmetu(predmet);
			}
		});
		

		return panel;
	}
	
	
	
	
	
	
	
	

	
	

	
	
}
