package view;

import javax.swing.table.AbstractTableModel;

import model.BazaProfesora;
import model.Profesor;

public class AbstractTableModelProfesorPredajePredmete extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8791907538023694305L;
	
	private Profesor profesor;
	
	public AbstractTableModelProfesorPredajePredmete(Profesor profesor) {
		this.profesor = profesor;
	}
	
	@Override
	public int getColumnCount() {
		return BazaProfesora.getInstance().getColumnCountPredmeti();
	}

	@Override
	public int getRowCount() {
		return BazaProfesora.getInstance().getPredmeti(profesor).size();
	}
	
	@Override
	public String getColumnName(int column) {
		return BazaProfesora.getInstance().getColumnNamePredmeti(column);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaProfesora.getInstance().getValueAtPredmeti(profesor, rowIndex, columnIndex);
	}

}
