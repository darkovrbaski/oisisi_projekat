package view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.BazaProfesora;
import model.Predmet;
import model.Profesor;

public class AbstractTableModelDodajPredmeteProfesoru extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6222889652536944639L;
	
	private Profesor profesor;
	
	public AbstractTableModelDodajPredmeteProfesoru(Profesor profesor) {
		this.profesor = profesor;
	}
	
	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public int getRowCount() {
		return BazaProfesora.getInstance().getPredmetiKojeNePredaje(profesor).size();
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ArrayList<Predmet> predmeti = BazaProfesora.getInstance().getPredmetiKojeNePredaje(profesor);
		Predmet predmet = predmeti.get(rowIndex);
		return predmet.getSifraPredmeta() + " - " + predmet.getNaziv();
	}

}
