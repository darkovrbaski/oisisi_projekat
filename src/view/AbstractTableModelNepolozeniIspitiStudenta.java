package view;

import javax.swing.table.AbstractTableModel;

import model.BazaStudent;
import model.Student;

public class AbstractTableModelNepolozeniIspitiStudenta extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7597999654617219093L;
	
	private Student student;
	
	public AbstractTableModelNepolozeniIspitiStudenta(Student student) {
		this.student = student;
	}
	
	@Override
	public int getColumnCount() {
		return BazaStudent.getInstance().getColumnCountNepolozeniPredmeti();
	}

	@Override
	public int getRowCount() {
		return BazaStudent.getInstance().getNepolozeniPredmeti(student).size();
	}
	
	@Override
	public String getColumnName(int column) {
		return BazaStudent.getInstance().getColumnNameNepolozeniPredmeti(column);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaStudent.getInstance().getValueAtNepolozeniPredmeti(student, rowIndex, columnIndex);
	}

}
