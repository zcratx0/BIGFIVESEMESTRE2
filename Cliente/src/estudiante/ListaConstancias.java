package estudiante;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import analista.AgregarITR;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaConstancias {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaConstancias window = new ListaConstancias();
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
	public ListaConstancias() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 590, 439);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.decode("#f9fafb"));
		frame.setResizable(false);
		
		//Imagen
		JLabel lblLogoUtec = new JLabel("");
		lblLogoUtec.setIcon(new ImageIcon(AgregarITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 0, 107, 50);
		frame.getContentPane().add(lblLogoUtec);
		
		
		//Titulo lista de constancias 
		JLabel lblTitListConst = new JLabel("Lista de Constancias");
		lblTitListConst.setForeground(Color.decode("#08ACEC"));
		lblTitListConst.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblTitListConst.setBounds(170, 10, 312, 24);
		frame.getContentPane().add(lblTitListConst);
		
		//*Filtro
		
		//Estado
		JLabel lblEstadoFil = new JLabel("Estado");
		lblEstadoFil.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblEstadoFil.setBounds(50, 72, 45, 13);
		frame.getContentPane().add(lblEstadoFil);
		
		JComboBox cBoxEstado = new JComboBox();
		cBoxEstado.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		cBoxEstado.setBounds(126, 68, 128, 21);
		frame.getContentPane().add(cBoxEstado);
		
		//Botones
			//Filtrar
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBackground(Color.decode("#0ea5e9"));
		btnFiltrar.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		btnFiltrar.setForeground(Color.decode("#f0f9ff"));
		btnFiltrar.setBounds(295, 68, 85, 21);
		frame.getContentPane().add(btnFiltrar);
		
			//Limpiar Filtro
		JButton btnLimpiarF = new JButton("Limpiar Filtro");
		btnLimpiarF.setBackground(Color.decode("#0ea5e9"));
		btnLimpiarF.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		btnLimpiarF.setForeground(Color.decode("#f0f9ff"));
		btnLimpiarF.setBounds(397, 68, 128, 21);
		frame.getContentPane().add(btnLimpiarF);
		
		//*Tabla
		
		//Constancia
		JLabel lblConstancia = new JLabel("Constancia");
		lblConstancia.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblConstancia.setBounds(50, 137, 107, 13);
		frame.getContentPane().add(lblConstancia);
		
		//Estado
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblEstado.setBounds(210, 137, 45, 13);
		frame.getContentPane().add(lblEstado);
		
		//Botones
			//Agregar
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnAgregar.setForeground(Color.decode("#f0f9ff"));
		btnAgregar.setBackground(Color.decode("#0284c7"));
		btnAgregar.setBounds(467, 342, 85, 31);
		frame.getContentPane().add(btnAgregar);
			
			// Modificar
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnModificar.setForeground(Color.decode("#f0f9ff"));
		btnModificar.setBackground(Color.decode("#0284c7"));
		btnModificar.setBounds(359, 342, 98, 31);
		frame.getContentPane().add(btnModificar);
		
			//Atras
		JButton btnAtras = new JButton("Atrás");
		btnAtras.setFont(new Font("Tahona", Font.BOLD, 10));
		btnAtras.setForeground(Color.decode("#f0f9ff"));
		btnAtras.setBackground(Color.decode("#0284c7"));
		btnAtras.setBounds(170, 342, 85, 31);
		frame.getContentPane().add(btnAtras);
			
			//Dar de baja
		JButton btnBaja = new JButton("Dar de Baja");
		btnBaja.setFont(new Font("Tahona", Font.BOLD, 10));
		btnBaja.setForeground(Color.decode("#f0f9ff"));
		btnBaja.setBackground(Color.decode("#0284c7"));
		btnBaja.setBounds(25, 342, 114, 31);
		frame.getContentPane().add(btnBaja);
		
		
		
		
	}

}
