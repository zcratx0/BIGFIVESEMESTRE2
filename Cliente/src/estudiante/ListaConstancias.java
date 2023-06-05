package estudiante;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import analista.AgregarITR;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaConstancias {

	//Atributos
	JFrame frame = new JFrame();
	JLabel lblTitListConst = new JLabel("Lista de Constancias");
	JLabel lblEstadoFil = new JLabel("Estado");
	JComboBox cBoxEstado = new JComboBox();
	JButton btnFiltrar = new JButton("Filtrar");
	JButton btnLimpiarF = new JButton("Limpiar Filtro");
	JButton btnAgregar = new JButton("Agregar");
	JButton btnModificar = new JButton("Modificar");
	JButton btnAtras = new JButton("Atrás");
	JButton btnBaja = new JButton("Dar de Baja");
	
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
		lblTitListConst.setForeground(Color.decode("#08ACEC"));
		lblTitListConst.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblTitListConst.setBounds(170, 10, 312, 24);
		frame.getContentPane().add(lblTitListConst);
		
		//*Filtro
		
		//Estado
		lblEstadoFil.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblEstadoFil.setBounds(50, 72, 45, 13);
		frame.getContentPane().add(lblEstadoFil);
		
	
		cBoxEstado.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		cBoxEstado.setBounds(126, 68, 128, 21);
		frame.getContentPane().add(cBoxEstado);
		
		//Botones
			//Filtrar
		btnFiltrar.setBackground(Color.decode("#0ea5e9"));
		btnFiltrar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnFiltrar.setForeground(Color.decode("#f0f9ff"));
		btnFiltrar.setBounds(295, 68, 85, 21);
		frame.getContentPane().add(btnFiltrar);
		
			//Limpiar Filtro
		btnLimpiarF.setBackground(Color.decode("#0ea5e9"));
		btnLimpiarF.setFont(new Font("Tahona", Font.BOLD, 10));
		btnLimpiarF.setForeground(Color.decode("#f0f9ff"));
		btnLimpiarF.setBounds(397, 68, 128, 21);
		frame.getContentPane().add(btnLimpiarF);
		
		// Tabla
		Object[][] datosCons = {

		};

		String[] columnasCons  = {"Constancia", "Estado"};

		JTable tablaCons = new JTable(datosCons , columnasCons );
		JScrollPane scrollPaneCons = new JScrollPane(tablaCons );
		scrollPaneCons.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		scrollPaneCons.setBackground(Color.decode("#f3f4f6"));
		scrollPaneCons.setBounds(34, 107, 491, 203);
		frame.getContentPane().add(scrollPaneCons);
		
		//Botones
			//Agregar
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaConstancia.main(null);
				frame.dispose();
			}
		});
		btnAgregar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnAgregar.setForeground(Color.decode("#f0f9ff"));
		btnAgregar.setBackground(Color.decode("#0284c7"));
		btnAgregar.setBounds(467, 342, 85, 31);
		frame.getContentPane().add(btnAgregar);
			
			// Modificar
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaConstancia.main(null);
				frame.dispose();
			}
		});
		btnModificar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnModificar.setForeground(Color.decode("#f0f9ff"));
		btnModificar.setBackground(Color.decode("#0284c7"));
		btnModificar.setBounds(359, 342, 98, 31);
		frame.getContentPane().add(btnModificar);
	
		
			//Atras
		btnAtras.setFont(new Font("Tahona", Font.BOLD, 10));
		btnAtras.setForeground(Color.decode("#f0f9ff"));
		btnAtras.setBackground(Color.decode("#0284c7"));
		btnAtras.setBounds(170, 342, 85, 31);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrincipalEstudiante.main(null);
				frame.dispose();
				
			}
		});
		frame.getContentPane().add(btnAtras);
			
			//Dar de baja
		btnBaja.setFont(new Font("Tahona", Font.BOLD, 10));
		btnBaja.setForeground(Color.decode("#f0f9ff"));
		btnBaja.setBackground(Color.decode("#0284c7"));
		btnBaja.setBounds(25, 342, 114, 31);
		frame.getContentPane().add(btnBaja);
		
		
	}

}
