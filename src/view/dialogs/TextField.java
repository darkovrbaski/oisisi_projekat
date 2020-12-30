package view.dialogs;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.ProfesoriController;

public class TextField extends JTextField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3956108496624088788L;

	public enum Provera {
		Ime, Prezime, Datum, Adresa, BrTel, Email, BrLicne
	};

	private JTextField tf;
	private Provera provera;

	public TextField(String text, Provera provera, String error) {
		tf = this;
		this.provera = provera;
		this.setText(text);
		this.setForeground(new Color(156, 156, 156));
		this.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (!proveraValidnosti() || tf.getText().trim().equals(text) || tf.getText().trim().isEmpty() == true) {
					if (!tf.getText().trim().equals(text) && tf.getText().trim().isEmpty() == false) {
						JOptionPane.showMessageDialog(null, error, "GREŠKA", JOptionPane.ERROR_MESSAGE);
					}
					tf.setForeground(new Color(156, 156, 156));
					tf.setText(text);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				tf.setForeground(Color.BLACK);
				if (tf.getText().trim().equals(text)) {
					tf.setText("");
				}

			}
		});
	}

	public boolean proveraValidnosti() {
		switch (provera) {
		case Ime:
			return ProfesoriController.getInstance().proveriIme(tf.getText().trim());
		case Prezime:
			return ProfesoriController.getInstance().proveriIme(tf.getText().trim());
		case Datum:
			return ProfesoriController.getInstance().proveriDatum(tf.getText().trim());
		case Adresa:
			return ProfesoriController.getInstance().proveriAdresu(tf.getText().trim());
		case BrTel:
			return ProfesoriController.getInstance().proveriBrTelefona(tf.getText().trim());
		case Email:
			return ProfesoriController.getInstance().proveriEmail(tf.getText().trim());
		case BrLicne:
			return ProfesoriController.getInstance().proveriBrLicne(tf.getText().trim());
		default:
			return false;
		}
	}
}
