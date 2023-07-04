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

import analista.ListaAuxITR;
import analista.ListaEscolaridad;
import utils.GUIEscolaridad;

public class EscolaridadTut extends GUIEscolaridad {

	public EscolaridadTut() {
		super();
		// Atras
		getBtnAtras().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getFrame().dispose();
			}
		});
	}

}
