package utils;

import java.awt.Font;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class TBFTable extends JTable {
	private static final long serialVersionUID = 1L;
	private TableRowSorter<DefaultTableModel> sorter;
	
	public TBFTable(Object[][] datos, String[] columna ) {
		super(datos, columna);
		setRowSorter(sorter);
		setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	}
	
	public void limpiarFiltro() {
		try {
			sorter.setRowFilter(RowFilter.regexFilter(""));
		} catch (Exception e) {	}
	}

}
