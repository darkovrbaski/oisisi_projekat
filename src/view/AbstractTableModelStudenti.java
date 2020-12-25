package view;

import javax.swing.table.AbstractTableModel;

import model.BazaStudent;

public class AbstractTableModelStudenti extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7349770694737017202L;

	@Override
	public int getColumnCount() {
		return BazaStudent.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		return BazaStudent.getInstance().getStudenti().size();
	}

	
	@Override
	public String getColumnName(int column) {
		return BazaStudent.getInstance().getColumnName(column);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaStudent.getInstance().getValueAt(rowIndex, columnIndex);
	}

}
