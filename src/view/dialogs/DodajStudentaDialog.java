package view.dialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.StudentiController;
import view.Frame;
import view.dialogs.TextFieldStudent.Provera;

public class DodajStudentaDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 356593115042387583L;

	public static JTextField txtIme;
	public static JTextField txtPrezime;
	public static JTextField txtDatumRodjenja;
	public static JTextField txtAdresaStanovanja;
	public static JTextField txtBrojTelefona;
	public static JTextField txtEmailAdresa;
	public static JTextField txtBrIndeksa;
	public static JTextField txtGodUpisa;
	public static JTextField txtTrenGodina;
	
	public static JTextField txtStatusStudenta;
	public static JTextField txtProsecnaOcjena;
	
	public static JComboBox<String> cbTrenutnaG;
	public static JComboBox<String> cbStatus;
	private JButton btnPotvrdi;
	
	private DocumentListener documentListener = new DocumentListener() {

		@Override
		public void removeUpdate(DocumentEvent e) {
			if (StudentiController.getInstance().proveriPopunjenostPolja()) {
				btnPotvrdi.setEnabled(true);
			} else {
				btnPotvrdi.setEnabled(false);
			}
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			if (StudentiController.getInstance().proveriPopunjenostPolja()) {
				btnPotvrdi.setEnabled(true);
			} else {
				btnPotvrdi.setEnabled(false);
			}
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			if (StudentiController.getInstance().proveriPopunjenostPolja()) {
				btnPotvrdi.setEnabled(true);
			} else {
				btnPotvrdi.setEnabled(false);
			}
		}
	};
	

	public DodajStudentaDialog() {
		super(Frame.getInstance(), "Dodavanje studenta", true);
		setResizable(false);
		this.setSize(500, 600);
		this.setLocationRelativeTo(Frame.getInstance());

		this.setLayout(new BorderLayout(0, 30));

		JPanel panTop = new JPanel();
		this.add(panTop, BorderLayout.CENTER);
		GridBagLayout gb = new GridBagLayout();
		panTop.setLayout(gb);

		
		
		JLabel lblIme = new JLabel("Ime*");
		GridBagConstraints gbc_lblIme = new GridBagConstraints();
		gbc_lblIme.anchor = GridBagConstraints.WEST;
		gbc_lblIme.insets = new Insets(20, 0, 5, 20);
		gbc_lblIme.gridx = 0;
		gbc_lblIme.gridy = 0;
		panTop.add(lblIme, gbc_lblIme);

		txtIme = new TextFieldStudent("Ime", Provera.Ime, "Proverite uneto ime.\nPolje sadrži nedozvoljene karaktere!");
		GridBagConstraints gbc_txtIme = new GridBagConstraints();
		gbc_txtIme.gridwidth = 3;
		gbc_txtIme.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIme.insets = new Insets(20, 20, 0, 20);
		gbc_txtIme.gridx = 1;
		gbc_txtIme.gridy = 0;
		panTop.add(txtIme, gbc_txtIme);
		
		

		JLabel lblPrezime = new JLabel("Prezime*");
		GridBagConstraints gbc_lblPrezime = new GridBagConstraints();
		gbc_lblPrezime.anchor = GridBagConstraints.WEST;
		gbc_lblPrezime.insets = new Insets(20, 0, 5, 20);
		gbc_lblPrezime.gridx = 0;
		gbc_lblPrezime.gridy = 1;
		panTop.add(lblPrezime, gbc_lblPrezime);

		txtPrezime = new TextFieldStudent("Prezime", Provera.Prezime,
				"Proverite uneto prezime.\nPolje sadrži nedozvoljene karaktere!");
		GridBagConstraints gbc_txtPrezime = new GridBagConstraints();
		gbc_txtPrezime.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPrezime.gridwidth = 3;
		gbc_txtPrezime.insets = new Insets(20, 20, 0, 20);
		gbc_txtPrezime.gridx = 1;
		gbc_txtPrezime.gridy = 1;
		panTop.add(txtPrezime, gbc_txtPrezime);

		
		
		
		JLabel lblDatumRodjenja = new JLabel("Datum rođenja*");
		GridBagConstraints gbc_lblDatumRodjenja = new GridBagConstraints();
		gbc_lblDatumRodjenja.anchor = GridBagConstraints.WEST;
		gbc_lblDatumRodjenja.insets = new Insets(20, 0, 5, 20);
		gbc_lblDatumRodjenja.gridx = 0;
		gbc_lblDatumRodjenja.gridy = 2;
		panTop.add(lblDatumRodjenja, gbc_lblDatumRodjenja);

		txtDatumRodjenja = new TextFieldStudent("dd.mm.yyyy", Provera.Datum,
				"Proverite datum rođenja.\nFormat datuma je: dd.mm.yyyy");
		GridBagConstraints gbc_txtDatumRodjenja = new GridBagConstraints();
		gbc_txtDatumRodjenja.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDatumRodjenja.gridwidth = 3;
		gbc_txtDatumRodjenja.insets = new Insets(20, 20, 0, 20);
		gbc_txtDatumRodjenja.gridx = 1;
		gbc_txtDatumRodjenja.gridy = 2;
		panTop.add(txtDatumRodjenja, gbc_txtDatumRodjenja);

		
		
		JLabel lblAdresaStanovanja = new JLabel("Adresa stanovanja*");
		GridBagConstraints gbc_lblAdresaStanovanja = new GridBagConstraints();
		gbc_lblAdresaStanovanja.anchor = GridBagConstraints.WEST;
		gbc_lblAdresaStanovanja.insets = new Insets(20, 0, 5, 20);
		gbc_lblAdresaStanovanja.gridx = 0;
		gbc_lblAdresaStanovanja.gridy = 3;
		panTop.add(lblAdresaStanovanja, gbc_lblAdresaStanovanja);

		txtAdresaStanovanja = new TextFieldStudent("Adresa, 123", Provera.Adresa,
				"Proverite unetu adresu stanovanja.\\nPolje sadrži nedozvoljene karaktere!");
		GridBagConstraints gbc_txtAdresaStanovanja = new GridBagConstraints();
		gbc_txtAdresaStanovanja.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdresaStanovanja.gridwidth = 3;
		gbc_txtAdresaStanovanja.insets = new Insets(20, 20, 0, 20);
		gbc_txtAdresaStanovanja.gridx = 1;
		gbc_txtAdresaStanovanja.gridy = 3;
		panTop.add(txtAdresaStanovanja, gbc_txtAdresaStanovanja);

		
		
		
		JLabel lblBrojTelefona = new JLabel("Broj telefona*");
		GridBagConstraints gbc_lblBrojTelefona = new GridBagConstraints();
		gbc_lblBrojTelefona.anchor = GridBagConstraints.WEST;
		gbc_lblBrojTelefona.insets = new Insets(20, 0, 5, 20);
		gbc_lblBrojTelefona.gridx = 0;
		gbc_lblBrojTelefona.gridy = 4;
		panTop.add(lblBrojTelefona, gbc_lblBrojTelefona);

		txtBrojTelefona = new TextFieldStudent("06123123123", Provera.BrTel,
				"Proverite unet broj telefona.\nSamo brojevi su dozvoljeni!");
		GridBagConstraints gbc_txtBrojTelefona = new GridBagConstraints();
		gbc_txtBrojTelefona.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBrojTelefona.gridwidth = 3;
		gbc_txtBrojTelefona.insets = new Insets(20, 20, 0, 20);
		gbc_txtBrojTelefona.gridx = 1;
		gbc_txtBrojTelefona.gridy = 4;
		panTop.add(txtBrojTelefona, gbc_txtBrojTelefona);

		
		
		
		
		JLabel lblEmailAdresa = new JLabel("E-mail adresa*");
		GridBagConstraints gbc_lblEmailAdresa = new GridBagConstraints();
		gbc_lblEmailAdresa.anchor = GridBagConstraints.WEST;
		gbc_lblEmailAdresa.insets = new Insets(20, 0, 5, 20);
		gbc_lblEmailAdresa.gridx = 0;
		gbc_lblEmailAdresa.gridy = 5;
		panTop.add(lblEmailAdresa, gbc_lblEmailAdresa);

		txtEmailAdresa = new TextFieldStudent("primer@primer.com", Provera.Email, "Proverite unetu eMail adresu.");
		GridBagConstraints gbc_txtEmailAdresa = new GridBagConstraints();
		gbc_txtEmailAdresa.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmailAdresa.gridwidth = 3;
		gbc_txtEmailAdresa.insets = new Insets(20, 20, 0, 20);
		gbc_txtEmailAdresa.gridx = 1;
		gbc_txtEmailAdresa.gridy = 5;
		panTop.add(txtEmailAdresa, gbc_txtEmailAdresa);

		
		
		JLabel lblBrIndeksa = new JLabel("Broj Indeksa*");
		GridBagConstraints gbc_lblBrIndeksa = new GridBagConstraints();
		gbc_lblBrIndeksa.anchor = GridBagConstraints.WEST;
		gbc_lblBrIndeksa.insets = new Insets(20, 0, 5, 20);
		gbc_lblBrIndeksa.gridx = 0;
		gbc_lblBrIndeksa.gridy = 6;
		panTop.add(lblBrIndeksa, gbc_lblBrIndeksa);

		
		txtBrIndeksa = new TextFieldStudent("NZ123", Provera.BrojIndeksa, "Proverite uneti broj indeksa");
		GridBagConstraints gbc_txtBrindeksa = new GridBagConstraints();
		gbc_txtBrindeksa.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBrindeksa.gridwidth = 3;
		gbc_txtBrindeksa.insets = new Insets(20, 20, 0, 20);
		gbc_txtBrindeksa.gridx = 1;
		gbc_txtBrindeksa.gridy = 6;
		panTop.add(txtBrIndeksa, gbc_txtBrindeksa);

		
		
		
		
		JLabel lblGodUpisa = new JLabel("Godina upisa*");
		GridBagConstraints gbc_lblGodUpisa = new GridBagConstraints();
		gbc_lblGodUpisa.anchor = GridBagConstraints.WEST;
		gbc_lblGodUpisa.insets = new Insets(20, 0, 5, 20);
		gbc_lblGodUpisa.gridx = 0;
		gbc_lblGodUpisa.gridy = 7;
		panTop.add(lblGodUpisa, gbc_lblGodUpisa);

		txtGodUpisa = new TextFieldStudent("1900", Provera.GodUpisa, "Proverite unetu godinu upisa.");
		GridBagConstraints gbc_txtGodUpisa = new GridBagConstraints();
		gbc_txtGodUpisa.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGodUpisa.gridwidth = 3;
		gbc_txtGodUpisa.insets = new Insets(20, 20, 0, 20);
		gbc_txtGodUpisa.gridx = 1;
		gbc_txtGodUpisa.gridy = 7;
		panTop.add(txtGodUpisa, gbc_txtGodUpisa);
		
		
		
		
		
		JLabel lblTrenGodina = new JLabel("Trenutna godina*");
		GridBagConstraints gbc_lblTrenGodina = new GridBagConstraints();
		gbc_lblTrenGodina.anchor = GridBagConstraints.WEST;
		gbc_lblTrenGodina.insets = new Insets(20, 0, 5, 20);
		gbc_lblTrenGodina.gridx = 0;
		gbc_lblTrenGodina.gridy = 8;
		panTop.add(lblTrenGodina, gbc_lblTrenGodina);

		String[] trGodina = { "PRVA", "DRUGA", "TRECA", "CETVRTA" };
		cbTrenutnaG = new JComboBox<String>(trGodina);
		GridBagConstraints gbc_cbTrenutnaG = new GridBagConstraints();
		gbc_cbTrenutnaG.gridwidth = 3;
		gbc_cbTrenutnaG.insets = new Insets(20, 20, 0, 20);
		gbc_cbTrenutnaG.gridx = 1;
		gbc_cbTrenutnaG.gridy = 8;
		cbTrenutnaG.setPreferredSize(new Dimension(205, 20));
		panTop.add(cbTrenutnaG, gbc_cbTrenutnaG);

		
		
		

		JLabel lblStatusStudenta = new JLabel("Status studenta*");
		GridBagConstraints gbc_lblStatusStudenta = new GridBagConstraints();
		gbc_lblStatusStudenta.anchor = GridBagConstraints.WEST;
		gbc_lblStatusStudenta.insets = new Insets(20, 0, 5, 20);
		gbc_lblStatusStudenta.gridx = 0;
		gbc_lblStatusStudenta.gridy = 9;
		panTop.add(lblStatusStudenta, gbc_lblStatusStudenta);

		String[] statusi = { "B", "S" };
		cbStatus = new JComboBox<String>(statusi);
		GridBagConstraints gbc_cbStatus = new GridBagConstraints();
		gbc_cbStatus.gridwidth = 3;
		gbc_cbStatus.insets = new Insets(20, 20, 0, 20);
		gbc_cbStatus.gridx = 1;
		gbc_cbStatus.gridy = 9;
		cbStatus.setPreferredSize(new Dimension(205, 20));
		panTop.add(cbStatus, gbc_cbStatus);
		

		

		JPanel panBottom = new JPanel();
		this.add(panBottom, BorderLayout.SOUTH);
		panBottom.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));

		
		
		txtIme.getDocument().addDocumentListener(documentListener);
		txtPrezime.getDocument().addDocumentListener(documentListener);
		txtDatumRodjenja.getDocument().addDocumentListener(documentListener);
		txtAdresaStanovanja.getDocument().addDocumentListener(documentListener);
		txtBrojTelefona.getDocument().addDocumentListener(documentListener);
		txtEmailAdresa.getDocument().addDocumentListener(documentListener);
		txtBrIndeksa.getDocument().addDocumentListener(documentListener);
		txtGodUpisa.getDocument().addDocumentListener(documentListener);

		btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setEnabled(false);
		
		
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (StudentiController.getInstance().proveriStudenta() == true) {
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

		this.setVisible(true);
	}
	
}
