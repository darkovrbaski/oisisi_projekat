package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

public class Table extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -500762274265898052L;
	
	public Table() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
	
	public void azurirajPrikaz() {
		AbstractTableModel model = (AbstractTableModel) this.getModel();
		model.fireTableDataChanged();
		this.validate();
	}

	public int getCurrentSelectedRow() {
		if (this.getSelectedRow() == -1) {
			return -1;
		}
		return this.convertRowIndexToModel(this.getSelectedRow());
	}

}
