package analista;

import com.bigfive.entities.Estudiante;
import utils.GUIEscolaridad;
import utils.GUIListaEscolaridad;

import java.awt.event.ActionListener;

import javax.swing.JTable;

import java.awt.event.ActionEvent;

public class ListaEscolaridad extends GUIListaEscolaridad {

	public ListaEscolaridad() {
		getBtnMostrarEsc().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getTablaEsc().getSelectedRow() > -1) {
					if (getTablaEsc().getModel().getValueAt(getTablaEsc().getSelectedRow(), 0) instanceof Estudiante) {
						Estudiante estudiante = (Estudiante) getTablaEsc().getModel()
								.getValueAt(getTablaEsc().getSelectedRow(), 0);
						Escolaridad.main(estudiante);
						getFrame().dispose();
					}
				}
			}
		});
	}
	
}
