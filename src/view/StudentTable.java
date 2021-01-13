package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class StudentTable extends JTable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1029156741381290239L;
	
	//public static JTable tabelaStudenata;

	public StudentTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelStudenti());
//		tabelaStudenata = this;
		this.setAutoCreateRowSorter(true);
	}

	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(new java.awt.Color(209, 224, 240));
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
	

	public void azurirajPrikazStudenta() {
		AbstractTableModelStudenti model = (AbstractTableModelStudenti) this.getModel();
		model.fireTableDataChanged();
		this.validate();
	}
	
	public int getCurrentSelectedRow() {
		return this.convertRowIndexToModel(this.getSelectedRow());
	}
	
	

}
