package estudiante;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.bigfive.entities.EnumDepartamentos;
import com.bigfive.entities.Estudiante;
import com.bigfive.entities.Itr;
import com.bigfive.entities.Usuario;

import analista.ListaAuxITR;
import funcionalidades.DAOArea;
import utils.DatosFalsos;
import utils.Escolaridad;
import utils.GUIEscolaridad;
import utils.TBFDownload;

public class DescargarEscolaridad extends GUIEscolaridad {
	
	public DescargarEscolaridad() {
		super();
		getBtnAtras().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PrincipalEstudiante.main(null);
				getFrame().dispose();
			}
		});
		getFrame().getContentPane().add(getBtnAtras());
	}
	

}

