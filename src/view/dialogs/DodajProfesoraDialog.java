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

import controller.ProfesoriController;
import view.Frame;
import view.dialogs.TextField.Provera;

public class DodajProfesoraDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7297428227529238986L;

	public static JTextField txtIme;
	public static JTextField txtPrezime;
	public static JTextField txtDatumRodjenja;
	public static JTextField txtAdresaStanovanja;
	public static JTextField txtBrojTelefona;
	public static JTextField txtEmailAdresa;
	public static JTextField txtAdresaKancelarije;
	public static JTextField txtBrojLicneKarte;
	public static JComboBox<String> cbTitula;
	public static JComboBox<String> cbZvanje;
	private JButton btnPotvrdi;
	private DocumentListener documentListener = new DocumentListener() {

		@Override
		public void removeUpdate(DocumentEvent e) {
			if (ProfesoriController.getInstance().proveriPopunjenostPolja()) {
				btnPotvrdi.setEnabled(true);
			} else {
				btnPotvrdi.setEnabled(false);
			}
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			if (ProfesoriController.getInstance().proveriPopunjenostPolja()) {
				btnPotvrdi.setEnabled(true);
			} else {
				btnPotvrdi.setEnabled(false);
			}
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			if (ProfesoriController.getInstance().proveriPopunjenostPolja()) {
				btnPotvrdi.setEnabled(true);
			} else {
				btnPotvrdi.setEnabled(false);
			}
		}
	};

	public DodajProfesoraDialog() {
		super(Frame.getInstance(), "Dodavanje profesora", true);
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

		txtIme = new TextField("Ime", Provera.Ime, "Proverite uneto ime.\nPolje sadrži nedozvoljene karaktere!");
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

		txtPrezime = new TextField("Prezime", Provera.Prezime,
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

		txtDatumRodjenja = new TextField("dd.mm.yyyy", Provera.Datum,
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

		txtAdresaStanovanja = new TextField("Adresa, 123", Provera.Adresa,
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

		txtBrojTelefona = new TextField("06123123123", Provera.BrTel,
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

		txtEmailAdresa = new TextField("primer@primer.com", Provera.Email, "Proverite unetu eMail adresu.");
		GridBagConstraints gbc_txtEmailAdresa = new GridBagConstraints();
		gbc_txtEmailAdresa.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmailAdresa.gridwidth = 3;
		gbc_txtEmailAdresa.insets = new Insets(20, 20, 0, 20);
		gbc_txtEmailAdresa.gridx = 1;
		gbc_txtEmailAdresa.gridy = 5;
		panTop.add(txtEmailAdresa, gbc_txtEmailAdresa);

		JLabel lblAdresaKancelarije = new JLabel("Adresa kancelarije*");
		GridBagConstraints gbc_lblAdresaKancelarije = new GridBagConstraints();
		gbc_lblAdresaKancelarije.anchor = GridBagConstraints.WEST;
		gbc_lblAdresaKancelarije.insets = new Insets(20, 0, 5, 20);
		gbc_lblAdresaKancelarije.gridx = 0;
		gbc_lblAdresaKancelarije.gridy = 6;
		panTop.add(lblAdresaKancelarije, gbc_lblAdresaKancelarije);

		txtAdresaKancelarije = new TextField("Adresa, Kancelarija, 123", Provera.Adresa,
				"Proverite unetu adresu kancelarije.\nPolje sadrži nedozvoljene karaktere!");
		GridBagConstraints gbc_txtAdresakancelarije = new GridBagConstraints();
		gbc_txtAdresakancelarije.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdresakancelarije.gridwidth = 3;
		gbc_txtAdresakancelarije.insets = new Insets(20, 20, 0, 20);
		gbc_txtAdresakancelarije.gridx = 1;
		gbc_txtAdresakancelarije.gridy = 6;
		panTop.add(txtAdresaKancelarije, gbc_txtAdresakancelarije);

		JLabel lblBrojLicneKarte = new JLabel("Broj lične karte*");
		GridBagConstraints gbc_lblBrojLicneKarte = new GridBagConstraints();
		gbc_lblBrojLicneKarte.anchor = GridBagConstraints.WEST;
		gbc_lblBrojLicneKarte.insets = new Insets(20, 0, 5, 20);
		gbc_lblBrojLicneKarte.gridx = 0;
		gbc_lblBrojLicneKarte.gridy = 7;
		panTop.add(lblBrojLicneKarte, gbc_lblBrojLicneKarte);

		txtBrojLicneKarte = new TextField("111222333", Provera.BrLicne,
				"Proverite unet broj ličen karte.\nSamo brojevi su dozvoljeni!");
		GridBagConstraints gbc_txtBrojLicneKarte = new GridBagConstraints();
		gbc_txtBrojLicneKarte.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBrojLicneKarte.gridwidth = 3;
		gbc_txtBrojLicneKarte.insets = new Insets(20, 20, 0, 20);
		gbc_txtBrojLicneKarte.gridx = 1;
		gbc_txtBrojLicneKarte.gridy = 7;
		panTop.add(txtBrojLicneKarte, gbc_txtBrojLicneKarte);

		JLabel lblTitula = new JLabel("Titula*");
		GridBagConstraints gbc_lblTitula = new GridBagConstraints();
		gbc_lblTitula.anchor = GridBagConstraints.WEST;
		gbc_lblTitula.insets = new Insets(20, 0, 5, 20);
		gbc_lblTitula.gridx = 0;
		gbc_lblTitula.gridy = 8;
		panTop.add(lblTitula, gbc_lblTitula);

		String[] titule = { "Master", "Doktor", "Doktor profesor" };
		cbTitula = new JComboBox<String>(titule);
		GridBagConstraints gbc_cbTitula = new GridBagConstraints();
		gbc_cbTitula.gridwidth = 3;
		gbc_cbTitula.insets = new Insets(20, 20, 0, 20);
		gbc_cbTitula.gridx = 1;
		gbc_cbTitula.gridy = 8;
		cbTitula.setPreferredSize(new Dimension(205, 20));
		panTop.add(cbTitula, gbc_cbTitula);

		JLabel lblZvanje = new JLabel("Zvanje*");
		GridBagConstraints gbc_lblZvanje = new GridBagConstraints();
		gbc_lblZvanje.anchor = GridBagConstraints.WEST;
		gbc_lblZvanje.insets = new Insets(20, 0, 5, 20);
		gbc_lblZvanje.gridx = 0;
		gbc_lblZvanje.gridy = 9;
		panTop.add(lblZvanje, gbc_lblZvanje);

		String[] zvanja = { "Asistent", "Docent", "Vanredni profesor", "Redovni profesor" };
		cbZvanje = new JComboBox<String>(zvanja);
		GridBagConstraints gbc_cbZvanje = new GridBagConstraints();
		gbc_cbZvanje.gridwidth = 3;
		gbc_cbZvanje.insets = new Insets(20, 20, 0, 20);
		gbc_cbZvanje.gridx = 1;
		gbc_cbZvanje.gridy = 9;
		cbZvanje.setPreferredSize(new Dimension(205, 20));
		panTop.add(cbZvanje, gbc_cbZvanje);

		JPanel panBottom = new JPanel();
		this.add(panBottom, BorderLayout.SOUTH);
		panBottom.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));

		txtIme.getDocument().addDocumentListener(documentListener);
		txtPrezime.getDocument().addDocumentListener(documentListener);
		txtDatumRodjenja.getDocument().addDocumentListener(documentListener);
		txtAdresaStanovanja.getDocument().addDocumentListener(documentListener);
		txtBrojTelefona.getDocument().addDocumentListener(documentListener);
		txtEmailAdresa.getDocument().addDocumentListener(documentListener);
		txtAdresaKancelarije.getDocument().addDocumentListener(documentListener);
		txtBrojLicneKarte.getDocument().addDocumentListener(documentListener);

		btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setEnabled(false);
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ProfesoriController.getInstance().proveriProfesora() == true) {
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
