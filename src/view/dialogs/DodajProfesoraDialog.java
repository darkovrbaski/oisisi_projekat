package view.dialogs;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import view.Frame;

public class DodajProfesoraDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7297428227529238986L;
	
	private JTextField txtIme;
	private JTextField txtPrezime;
	private JTextField txtDatumRodjenja;
	private JTextField txtAdresaStanovanja;
	private JTextField txtBrojTelefona;
	private JTextField txtEmailAdresa;
	private JTextField txtAdresakancelarije;
	private JTextField txtBrojLicneKarte;
	
	public DodajProfesoraDialog() {
		super(Frame.getInstance(), "Dodavanje profesora", true);
		this.setLocationRelativeTo(Frame.getInstance());
		this.setResizable(false);
		this.setVisible(true);
		getContentPane().setLayout(new BorderLayout(0, 30));
				
		JPanel panTop = new JPanel();
		getContentPane().add(panTop, BorderLayout.CENTER);
		GridBagLayout gb = new GridBagLayout();
		gb.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		gb.columnWeights = new double[]{0.0, 0.0, 1.0};
		panTop.setLayout(gb);
		
		JLabel lblIme = new JLabel("Ime*");
		GridBagConstraints gbc_lblIme = new GridBagConstraints();
		gbc_lblIme.anchor = GridBagConstraints.WEST;
		gbc_lblIme.insets = new Insets(0, 0, 5, 5);
		gbc_lblIme.gridx = 1;
		gbc_lblIme.gridy = 1;
		panTop.add(lblIme, gbc_lblIme);
		
		txtIme = new JTextField();
		GridBagConstraints gbc_txtIme = new GridBagConstraints();
		gbc_txtIme.insets = new Insets(0, 0, 5, 0);
		gbc_txtIme.gridx = 2;
		gbc_txtIme.gridy = 1;
		panTop.add(txtIme, gbc_txtIme);
		txtIme.setColumns(25);
		
		JLabel lblPrezime = new JLabel("Prezime*");
		GridBagConstraints gbc_lblPrezime = new GridBagConstraints();
		gbc_lblPrezime.anchor = GridBagConstraints.WEST;
		gbc_lblPrezime.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrezime.gridx = 1;
		gbc_lblPrezime.gridy = 2;
		panTop.add(lblPrezime, gbc_lblPrezime);
		
		txtPrezime = new JTextField();
		GridBagConstraints gbc_txtPrezime = new GridBagConstraints();
		gbc_txtPrezime.insets = new Insets(0, 0, 5, 0);
		gbc_txtPrezime.gridx = 2;
		gbc_txtPrezime.gridy = 2;
		panTop.add(txtPrezime, gbc_txtPrezime);
		txtPrezime.setColumns(25);
		
		JLabel lblDatumRodjenja = new JLabel("Datum rođenja*");
		GridBagConstraints gbc_lblDatumRodjenja = new GridBagConstraints();
		gbc_lblDatumRodjenja.anchor = GridBagConstraints.WEST;
		gbc_lblDatumRodjenja.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatumRodjenja.gridx = 1;
		gbc_lblDatumRodjenja.gridy = 3;
		panTop.add(lblDatumRodjenja, gbc_lblDatumRodjenja);
		
		txtDatumRodjenja = new JTextField();
		GridBagConstraints gbc_txtDatumRodjenja = new GridBagConstraints();
		gbc_txtDatumRodjenja.insets = new Insets(0, 0, 5, 0);
		gbc_txtDatumRodjenja.gridx = 2;
		gbc_txtDatumRodjenja.gridy = 3;
		panTop.add(txtDatumRodjenja, gbc_txtDatumRodjenja);
		txtDatumRodjenja.setColumns(25);
		
		JLabel lblAdresaStanovanja = new JLabel("Adresa stanovanja*");
		GridBagConstraints gbc_lblAdresaStanovanja = new GridBagConstraints();
		gbc_lblAdresaStanovanja.anchor = GridBagConstraints.WEST;
		gbc_lblAdresaStanovanja.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresaStanovanja.gridx = 1;
		gbc_lblAdresaStanovanja.gridy = 4;
		panTop.add(lblAdresaStanovanja, gbc_lblAdresaStanovanja);
		
		txtAdresaStanovanja = new JTextField();
		GridBagConstraints gbc_txtAdresaStanovanja = new GridBagConstraints();
		gbc_txtAdresaStanovanja.insets = new Insets(0, 0, 5, 0);
		gbc_txtAdresaStanovanja.gridx = 2;
		gbc_txtAdresaStanovanja.gridy = 4;
		panTop.add(txtAdresaStanovanja, gbc_txtAdresaStanovanja);
		txtAdresaStanovanja.setColumns(25);
		
		JLabel lblBrojTelefona = new JLabel("Broj telefona*");
		GridBagConstraints gbc_lblBrojTelefona = new GridBagConstraints();
		gbc_lblBrojTelefona.anchor = GridBagConstraints.WEST;
		gbc_lblBrojTelefona.insets = new Insets(0, 0, 5, 5);
		gbc_lblBrojTelefona.gridx = 1;
		gbc_lblBrojTelefona.gridy = 5;
		panTop.add(lblBrojTelefona, gbc_lblBrojTelefona);
		
		txtBrojTelefona = new JTextField();
		GridBagConstraints gbc_txtBrojTelefona = new GridBagConstraints();
		gbc_txtBrojTelefona.insets = new Insets(0, 0, 5, 0);
		gbc_txtBrojTelefona.gridx = 2;
		gbc_txtBrojTelefona.gridy = 5;
		panTop.add(txtBrojTelefona, gbc_txtBrojTelefona);
		txtBrojTelefona.setColumns(25);
		
		JLabel lblEmailAdresa = new JLabel("E-mail adresa*");
		GridBagConstraints gbc_lblEmailAdresa = new GridBagConstraints();
		gbc_lblEmailAdresa.anchor = GridBagConstraints.WEST;
		gbc_lblEmailAdresa.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmailAdresa.gridx = 1;
		gbc_lblEmailAdresa.gridy = 6;
		panTop.add(lblEmailAdresa, gbc_lblEmailAdresa);
		
		txtEmailAdresa = new JTextField();
		GridBagConstraints gbc_txtEmailAdresa = new GridBagConstraints();
		gbc_txtEmailAdresa.insets = new Insets(0, 0, 5, 0);
		gbc_txtEmailAdresa.gridx = 2;
		gbc_txtEmailAdresa.gridy = 6;
		panTop.add(txtEmailAdresa, gbc_txtEmailAdresa);
		txtEmailAdresa.setColumns(25);
		
		JLabel lblAdresaKancelarije = new JLabel("Adresa kancelarije*");
		GridBagConstraints gbc_lblAdresaKancelarije = new GridBagConstraints();
		gbc_lblAdresaKancelarije.anchor = GridBagConstraints.WEST;
		gbc_lblAdresaKancelarije.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresaKancelarije.gridx = 1;
		gbc_lblAdresaKancelarije.gridy = 7;
		panTop.add(lblAdresaKancelarije, gbc_lblAdresaKancelarije);
		
		txtAdresakancelarije = new JTextField();
		GridBagConstraints gbc_txtAdresakancelarije = new GridBagConstraints();
		gbc_txtAdresakancelarije.insets = new Insets(0, 0, 5, 0);
		gbc_txtAdresakancelarije.gridx = 2;
		gbc_txtAdresakancelarije.gridy = 7;
		panTop.add(txtAdresakancelarije, gbc_txtAdresakancelarije);
		txtAdresakancelarije.setColumns(25);
		
		JLabel lblBrojLicneKarte = new JLabel("Broj lične karte*");
		GridBagConstraints gbc_lblBrojLicneKarte = new GridBagConstraints();
		gbc_lblBrojLicneKarte.anchor = GridBagConstraints.WEST;
		gbc_lblBrojLicneKarte.insets = new Insets(0, 0, 5, 5);
		gbc_lblBrojLicneKarte.gridx = 1;
		gbc_lblBrojLicneKarte.gridy = 8;
		panTop.add(lblBrojLicneKarte, gbc_lblBrojLicneKarte);
		
		txtBrojLicneKarte = new JTextField();
		GridBagConstraints gbc_txtBrojLicneKarte = new GridBagConstraints();
		gbc_txtBrojLicneKarte.insets = new Insets(0, 0, 5, 0);
		gbc_txtBrojLicneKarte.gridx = 2;
		gbc_txtBrojLicneKarte.gridy = 8;
		panTop.add(txtBrojLicneKarte, gbc_txtBrojLicneKarte);
		txtBrojLicneKarte.setColumns(25);
		
		JLabel lblTitula = new JLabel("Titula*");
		GridBagConstraints gbc_lblTitula = new GridBagConstraints();
		gbc_lblTitula.anchor = GridBagConstraints.WEST;
		gbc_lblTitula.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitula.gridx = 1;
		gbc_lblTitula.gridy = 9;
		panTop.add(lblTitula, gbc_lblTitula);
		
		String[] titule = { "Master", "Doktor", "Doktor profesor" };
		JComboBox cbTitula = new JComboBox(titule);
		GridBagConstraints gbc_cbTitula = new GridBagConstraints();
		gbc_cbTitula.insets = new Insets(0, 0, 5, 0);
		gbc_cbTitula.gridx = 2;
		gbc_cbTitula.gridy = 9;
		cbTitula.setPreferredSize(new Dimension(205, 20));
		panTop.add(cbTitula, gbc_cbTitula);
		
		JLabel lblZvanje = new JLabel("Zvanje*");
		GridBagConstraints gbc_lblZvanje = new GridBagConstraints();
		gbc_lblZvanje.anchor = GridBagConstraints.WEST;
		gbc_lblZvanje.insets = new Insets(0, 0, 0, 5);
		gbc_lblZvanje.gridx = 1;
		gbc_lblZvanje.gridy = 10;
		panTop.add(lblZvanje, gbc_lblZvanje);
		
		String[] zvanja = { "Asistent", "Docent", "Vanredni profesor" , "Redovni profesor"};
		JComboBox cbZvanje = new JComboBox(zvanja);
		GridBagConstraints gbc_cbZvanje = new GridBagConstraints();
		gbc_cbZvanje.gridx = 2;
		gbc_cbZvanje.gridy = 10;
		cbZvanje.setPreferredSize(new Dimension(205, 20));
		panTop.add(cbZvanje, gbc_cbZvanje);
		
		JPanel panBottom = new JPanel();
		getContentPane().add(panBottom, BorderLayout.SOUTH);
		panBottom.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		panBottom.add(btnPotvrdi);
		
		JButton btnOdustani = new JButton("Odustani");
		panBottom.add(btnOdustani);

	}

}
