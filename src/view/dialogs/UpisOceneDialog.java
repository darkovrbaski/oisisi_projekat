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
import model.BazaStudent;
import model.Predmet;
import model.Student;
import view.dialogs.TextFieldStudent.Provera;

public class UpisOceneDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8951081782872326241L;

	private Predmet predmet;
	public static JTextField txtSifra;
	public static JTextField txtNaziv;
	public static JComboBox<String> cbOcena;
	public static TextFieldStudent txtDatum;
	private JButton btnPotvrdi;

	public UpisOceneDialog(JDialog parent, Student student) {
		super(parent, "Unos ocene", true);
		this.setResizable(false);
		this.setSize(350, 350);
		this.setLocationRelativeTo(parent);

		this.predmet = BazaStudent.getInstance().getNepolozeniPredmeti(student)
				.get(IzmeniStudentaDialog.tabelaNepolozenihPredmeta.getCurrentSelectedRow());

		JPanel panTop = new JPanel();
		this.add(panTop, BorderLayout.CENTER);
		GridBagLayout gb = new GridBagLayout();
		panTop.setLayout(gb);

		JLabel lblSifra = new JLabel("Šifra*");
		GridBagConstraints gbc_lblSifra = new GridBagConstraints();
		gbc_lblSifra.anchor = GridBagConstraints.WEST;
		gbc_lblSifra.insets = new Insets(20, 0, 5, 20);
		gbc_lblSifra.gridx = 0;
		gbc_lblSifra.gridy = 0;
		panTop.add(lblSifra, gbc_lblSifra);

		txtSifra = new JTextField();
		txtSifra.setText(predmet.getSifraPredmeta());
		txtSifra.setEditable(false);
		GridBagConstraints gbc_txtSifra = new GridBagConstraints();
		gbc_txtSifra.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSifra.gridwidth = 3;
		gbc_txtSifra.insets = new Insets(20, 20, 0, 20);
		gbc_txtSifra.gridx = 1;
		gbc_txtSifra.gridy = 0;
		panTop.add(txtSifra, gbc_txtSifra);

		JLabel lblNaziv = new JLabel("Naziv*");
		GridBagConstraints gbc_lblNaziv = new GridBagConstraints();
		gbc_lblNaziv.anchor = GridBagConstraints.WEST;
		gbc_lblNaziv.insets = new Insets(20, 0, 5, 20);
		gbc_lblNaziv.gridx = 0;
		gbc_lblNaziv.gridy = 1;
		panTop.add(lblNaziv, gbc_lblNaziv);

		txtNaziv = new JTextField();
		txtNaziv.setText(predmet.getNaziv());
		txtNaziv.setEditable(false);
		GridBagConstraints gbc_txtNaziv = new GridBagConstraints();
		gbc_txtNaziv.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNaziv.gridwidth = 3;
		gbc_txtNaziv.insets = new Insets(20, 20, 0, 20);
		gbc_txtNaziv.gridx = 1;
		gbc_txtNaziv.gridy = 1;
		panTop.add(txtNaziv, gbc_txtNaziv);

		JLabel lblOcena = new JLabel("Ocena*");
		GridBagConstraints gbc_lblOcena = new GridBagConstraints();
		gbc_lblOcena.anchor = GridBagConstraints.WEST;
		gbc_lblOcena.insets = new Insets(20, 0, 5, 20);
		gbc_lblOcena.gridx = 0;
		gbc_lblOcena.gridy = 2;
		panTop.add(lblOcena, gbc_lblOcena);

		String[] ocene = { "6", "7", "8", "9", "10" };
		cbOcena = new JComboBox<String>(ocene);
		GridBagConstraints gbc_cbOcena = new GridBagConstraints();
		gbc_cbOcena.gridwidth = 3;
		gbc_cbOcena.insets = new Insets(20, 20, 0, 20);
		gbc_cbOcena.gridx = 1;
		gbc_cbOcena.gridy = 2;
		cbOcena.setPreferredSize(new Dimension(205, 20));
		panTop.add(cbOcena, gbc_cbOcena);

		JLabel lblDatum = new JLabel("Datum*");
		GridBagConstraints gbc_lblDatum = new GridBagConstraints();
		gbc_lblDatum.anchor = GridBagConstraints.WEST;
		gbc_lblDatum.insets = new Insets(20, 0, 5, 20);
		gbc_lblDatum.gridx = 0;
		gbc_lblDatum.gridy = 3;
		panTop.add(lblDatum, gbc_lblDatum);

		txtDatum = new TextFieldStudent("dd.mm.yyyy", Provera.Datum,
				"Proverite datum.\nFormat datuma je: dd.mm.yyyy");
		GridBagConstraints gbc_txtDatum = new GridBagConstraints();
		gbc_txtDatum.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDatum.gridwidth = 3;
		gbc_txtDatum.insets = new Insets(20, 20, 0, 20);
		gbc_txtDatum.gridx = 1;
		gbc_txtDatum.gridy = 3;
		panTop.add(txtDatum, gbc_txtDatum);
		txtDatum.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				if (StudentiController.getInstance().proveriDatum(txtDatum.getText().trim())) {
					btnPotvrdi.setEnabled(true);
				} else {
					btnPotvrdi.setEnabled(false);
				}
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				if (StudentiController.getInstance().proveriDatum(txtDatum.getText().trim())) {
					btnPotvrdi.setEnabled(true);
				} else {
					btnPotvrdi.setEnabled(false);
				}
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				if (StudentiController.getInstance().proveriDatum(txtDatum.getText().trim())) {
					btnPotvrdi.setEnabled(true);
				} else {
					btnPotvrdi.setEnabled(false);
				}
			}
		});

		JPanel panBottom = new JPanel();
		this.add(panBottom, BorderLayout.SOUTH);
		panBottom.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 20));

		btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setEnabled(false);
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (StudentiController.getInstance().proveriUpisOcene(student, predmet) == true) {
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
