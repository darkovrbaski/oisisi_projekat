package view.dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.Frame;

public class UpitPotvrdeDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4374863499652540364L;
	
	private boolean Yes = false;

	public UpitPotvrdeDialog(String title, String message) {
		super(Frame.getInstance(), title, true);
		this.setResizable(false);
		this.setSize(300, 150);
		this.setLocationRelativeTo(Frame.getInstance());
		
		JPanel panTop = new JPanel();
		this.add(panTop, BorderLayout.CENTER);
		
		JLabel lblPoruka = new JLabel(message);
		panTop.add(lblPoruka, BorderLayout.CENTER);
		
		JPanel panBottom = new JPanel();
		this.add(panBottom, BorderLayout.SOUTH);
		panBottom.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));

		JButton btnDa = new JButton("Da");
		btnDa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Yes = true;
				dispose();
			}
		});
		panBottom.add(btnDa);

		JButton btnNe = new JButton("Ne");
		btnNe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panBottom.add(btnNe);

		this.setVisible(true);
	}

	public boolean isYes() {
		return Yes;
	}

}
