package view.dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.ProfesoriController;
import model.Profesor;
import view.AbstractTableModelDodajPredmeteProfesoru;
import view.TableList;

public class DodajPredmeteProfesoruDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7673526937202511140L;

	public static Profesor profesor;
	public static TableList tabelaDodavanjePredmeta;

	public DodajPredmeteProfesoruDialog(JDialog parent, Profesor profesor) {
		super(parent, "Dodaj predmet", true);
		this.setResizable(false);
		this.setSize(450, 400);
		this.setLocationRelativeTo(parent);

		DodajPredmeteProfesoruDialog.profesor = profesor;

		JPanel panTop = new JPanel();
		this.add(panTop, BorderLayout.NORTH);
		panTop.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 15));
		JLabel lbl = new JLabel("Predmeti:");
		panTop.add(lbl, FlowLayout.LEFT);

		JPanel panCenter = new JPanel();
		this.add(panCenter, BorderLayout.CENTER);
		panCenter.setLayout(new BorderLayout());
		tabelaDodavanjePredmeta = new TableList();
		tabelaDodavanjePredmeta.setModel(new AbstractTableModelDodajPredmeteProfesoru(DodajPredmeteProfesoruDialog.profesor));
		JScrollPane scrollPanePredmeti = new JScrollPane(tabelaDodavanjePredmeta);
		panCenter.add(scrollPanePredmeti, BorderLayout.CENTER);

		JPanel panBottom = new JPanel();
		this.add(panBottom, BorderLayout.SOUTH);
		panBottom.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 20));

		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tabelaDodavanjePredmeta.getCurrentSelectedRow() != -1) {
					ProfesoriController.getInstance().dodajPredmetProfesoru();
				}
				dispose();
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
