package tutor;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.bigfive.entities.Estudiante;

import analista.Escolaridad;
import analista.ListaAuxITR;
import analista.PrincipalAnalista;
import funcionalidades.DAOAnalista;
import funcionalidades.DAOEstudiante;
import utils.GUIListaEscolaridad;

public class ListaEscolaridadTut extends GUIListaEscolaridad {

	public ListaEscolaridadTut() {
		getBtnMostrarEsc().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getTablaEsc().getSelectedRow() > -1) {
					if (getTablaEsc().getModel().getValueAt(getTablaEsc().getSelectedRow(), 0) instanceof Estudiante) {
						Estudiante estudiante = (Estudiante) getTablaEsc().getModel()
								.getValueAt(getTablaEsc().getSelectedRow(), 0);
						EscolaridadTut.main(estudiante);
						getFrame().dispose();
					}
				}
			}
		});
	}

}
