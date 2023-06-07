package Tutor;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import analista.ListaAuxITR;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MantenimientoTutor {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantenimientoTutor window = new MantenimientoTutor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MantenimientoTutor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 100, 712, 587);
		frame.getContentPane().setBackground(Color.decode("#f9fafb"));  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		// Imagen
		JLabel lblMantenimiento = new JLabel("");
		lblMantenimiento.setBackground(Color.WHITE);
		lblMantenimiento.setIcon(new ImageIcon(ListaAuxITR.class.getResource("/img/mantenimiento.png")));
		lblMantenimiento.setBounds(87, 60, 584, 410);
		frame.getContentPane().add(lblMantenimiento);
		
		//Titulo Ventana en Mantenimiento
		JLabel lblTitMan = new JLabel("Ventana en Mantenimiento");
		lblTitMan.setFont(new Font("Bookman Old Style", Font.BOLD, 25));
		lblTitMan.setBounds(158, 0, 390, 62);
		frame.getContentPane().add(lblTitMan);

		//Boton Ventana principal
		JButton btnPrincipal = new JButton("Volver a Ventana Principal");
		btnPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrincipalTutor.main(null);
				frame.dispose();
				
			}
		});
		btnPrincipal.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnPrincipal.setForeground(Color.decode("#f0f9ff"));
		btnPrincipal.setBackground(Color.decode("#0284c7"));
		btnPrincipal.setBounds(458, 492, 214, 33);
		frame.getContentPane().add(btnPrincipal);
	}
}
