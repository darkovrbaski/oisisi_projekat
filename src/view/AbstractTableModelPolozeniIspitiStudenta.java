package view;

import javax.swing.table.AbstractTableModel;

import model.BazaStudent;
import model.Student;

public class AbstractTableModelPolozeniIspitiStudenta extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3099206775504713269L;

	private Student student;
	
	public AbstractTableModelPolozeniIspitiStudenta(Student student) {
		this.student = student;
	}
	
	
	
	@Override
	public int getColumnCount() {
		
		return BazaStudent.getInstance().getColumnCountPolozeniPredmeti();
	}

	@Override
	public int getRowCount() {
		
		return BazaStudent.getInstance().getPolozeniPredmeti(student).size();
	}
	
	@Override
	public String getColumnName(int column) {
		return BazaStudent.getInstance().getColumnNamePolozeniPredmeti(column);
	}
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaStudent.getInstance().getValueAtPolozeniPredmeti(student, rowIndex, columnIndex);
	}

}
