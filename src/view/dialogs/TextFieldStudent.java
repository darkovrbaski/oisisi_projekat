package view.dialogs;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.StudentiController;

public class TextFieldStudent extends JTextField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4135506329626174404L;

	
	
	public enum Provera {
		
		Ime, Prezime, Datum, Adresa, BrTel, Email, GodUpisa, BrojIndeksa
	};
	
	
	
	private JTextField tf;
	private Provera provera;
	
	
	
	
	public TextFieldStudent(String text, Provera provera, String error) {
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
				if (tf.getText().trim().equals(text)) {
					tf.setForeground(Color.BLACK);
					tf.setText("");
				}

			}


		});
	}
	
	
	
	public boolean proveraValidnosti() {
		switch (provera) {
		case Ime:
			return StudentiController.getInstance().proveriIme(tf.getText().trim());
		case Prezime:
			return StudentiController.getInstance().proveriIme(tf.getText().trim());
		case Datum:
			return StudentiController.getInstance().proveriDatum(tf.getText().trim());
		case Adresa:
			return StudentiController.getInstance().proveriAdresu(tf.getText().trim());
		case BrTel:
			return StudentiController.getInstance().proveriBrTelefona(tf.getText().trim());
		case Email:
			return StudentiController.getInstance().proveriEmail(tf.getText().trim());
		case GodUpisa:
			return StudentiController.getInstance().proveriGodUpisa(tf.getText().trim());
		case BrojIndeksa:
			return StudentiController.getInstance().proveriBrIndeksa(tf.getText().trim());
			
		default:
			return false;
		}
	}
	
	
	
	
}
