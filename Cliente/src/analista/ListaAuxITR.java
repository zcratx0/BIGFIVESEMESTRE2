package analista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class ListaAuxITR {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaAuxITR window = new ListaAuxITR();
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
	public ListaAuxITR() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.decode("#f9fafb")); 
		frame.setBounds(100, 100, 401, 490);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		//Titulo 
		JLabel lblTitListITR = new JLabel("Lista de ITR");
		lblTitListITR.setForeground(Color.decode("#08ACEC"));  
		lblTitListITR.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblTitListITR.setBounds(116, 10, 142, 25);
		frame.getContentPane().add(lblTitListITR);
			//ITR
		JLabel lblITR = new JLabel("ITR");
		lblITR.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblITR.setBounds(44, 61, 80, 13);
		frame.getContentPane().add(lblITR);
			//NOMBRE
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblNombre.setBounds(216, 61, 95, 13);
		frame.getContentPane().add(lblNombre);
		
		
		//Boton 
			//Modificar
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(25, 383, 95, 35);
		btnModificar.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		btnModificar.setForeground(Color.decode("#f0f9ff"));
		btnModificar.setBackground(Color.decode("#0284c7"));  
		frame.getContentPane().add(btnModificar);
		
			//Eliminar
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(145, 383, 95, 35);
		btnEliminar.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		btnEliminar.setForeground(Color.decode("#f0f9ff"));
		btnEliminar.setBackground(Color.decode("#0284c7"));  
		frame.getContentPane().add(btnEliminar);
		
			//Agregar
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAgregar.setBounds(269, 383, 95, 35);
		btnAgregar.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		btnAgregar.setForeground(Color.decode("#f0f9ff"));
		btnAgregar.setBackground(Color.decode("#0284c7"));  
		frame.getContentPane().add(btnAgregar);
		
		
		//Imagen
		JLabel lblLogoUtec = new JLabel("");
		lblLogoUtec.setIcon(new ImageIcon(ListaAuxITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 1, 107, 50);
		frame.getContentPane().add(lblLogoUtec);
	}
}
