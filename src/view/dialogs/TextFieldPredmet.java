package view.dialogs;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.PredmetController;


public class TextFieldPredmet extends JTextField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 545550862195341232L;

	public enum Provera {
		
		naziv, sifraPredmeta, godina, brojESPB
	};
	
	private JTextField tf;
	private Provera provera;
	private String txt;
	

	
	public TextFieldPredmet(String text, Provera provera, String error) {
		tf = this;
		this.provera = provera;
		this.setText(text);
		this.txt = text;
		this.setForeground(new Color(156, 156, 156));
		this.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if (!proveraValidnosti() || tf.getText().trim().equals(text) || tf.getText().trim().isEmpty() == true) {
					if (!tf.getText().trim().equals(text) && tf.getText().trim().isEmpty() == false) {
						JOptionPane.showMessageDialog(null, error, "GREÃ…Â KA", JOptionPane.ERROR_MESSAGE);
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
	
	public String getTxt() {
		return txt;
	}
	
	
	
	public boolean proveraValidnosti() {
		switch (provera) {
		case sifraPredmeta:
			return PredmetController.getInstance().proveriSifruPredmeta(tf.getText().trim());
		case naziv:
			return PredmetController.getInstance().proveriNaziv(tf.getText().trim());
		case brojESPB:
			return PredmetController.getInstance().proveriBrojESPB(tf.getText().trim());
		case godina:
			return PredmetController.getInstance().proveriGodina(tf.getText().trim());
			
		default:
			return false;
		}
	}
	
	
	
}


