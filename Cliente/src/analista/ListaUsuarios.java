package analista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaUsuarios {

	//Atributos
	JFrame frame = new JFrame();
	JLabel lblTitListUsua = new JLabel("Lista de Usuarios");
	JLabel lblGeneracion = new JLabel("Generación");
	JComboBox cBoxGeneracion = new JComboBox();
	JLabel lblTipoUsu = new JLabel("Tipo de usuario");
	JLabel lblItrFil = new JLabel("ITR");
	JComboBox cBoxItr = new JComboBox();
	JLabel lblEstadoFil = new JLabel("Estado");
	JComboBox cBoxEstado = new JComboBox();
	JButton btnFiltrar = new JButton("Filtrar");
	JButton btnLimpiarF = new JButton("Limpiar Filtro");
	JButton btnAtras = new JButton("Atrás");
	JButton btnModificar = new JButton("Modificar");
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaUsuarios window = new ListaUsuarios();
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
	public ListaUsuarios() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.getContentPane().setBackground(Color.decode("#f9fafb")); 
		frame.setBounds(100, 100, 1031, 506);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		// Imagen
		JLabel lblLogoUtec = new JLabel("");
		lblLogoUtec.setIcon(new ImageIcon(ListaAuxITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 1, 107, 50);
		frame.getContentPane().add(lblLogoUtec);
		
		
		//Titulo Lista de Usuarios
		lblTitListUsua.setForeground(Color.decode("#08ACEC"));  
		lblTitListUsua.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblTitListUsua.setBounds(343, 10, 259, 31);
		frame.getContentPane().add(lblTitListUsua);
		
		//*Filtro
		
		// Generacion
		lblGeneracion.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblGeneracion.setBounds(565, 88, 73, 13);
		// frame.getContentPane().add(lblGeneracion);


		cBoxGeneracion.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		cBoxGeneracion.setBounds(630, 84, 107, 21);
		// frame.getContentPane().add(cBoxGeneracion);
		
		//Tipo de usuario
		lblTipoUsu.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblTipoUsu.setBounds(10, 88, 96, 13);
		frame.getContentPane().add(lblTipoUsu);
		
		JComboBox cBoxTipoUsu = new JComboBox(new String[] { "Seleccione", "Analista", "Estudiante", "Tutor" });
		cBoxTipoUsu.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		cBoxTipoUsu.setBounds(109, 84, 107, 21);
		cBoxTipoUsu.addActionListener(e -> {
			String selected = cBoxTipoUsu.getSelectedItem().toString();
			if (selected.equals("Estudiante")) {
				frame.getContentPane().add(lblGeneracion);
				frame.getContentPane().add(cBoxGeneracion);
			} else if (selected.equals("Tutor")) {
				frame.getContentPane().remove(lblGeneracion);
				frame.getContentPane().remove(cBoxGeneracion);
			} else if (selected.equals("Analista")) {
				frame.getContentPane().remove(lblGeneracion);
				frame.getContentPane().remove(cBoxGeneracion);
			}

			frame.getContentPane().revalidate();
			frame.getContentPane().repaint();
		});
		frame.getContentPane().add(cBoxTipoUsu);
		
		//ITR
		lblItrFil.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblItrFil.setBounds(241, 88, 45, 13);
		frame.getContentPane().add(lblItrFil);
		
		
		cBoxItr.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		cBoxItr.setBounds(264, 84, 107, 21);
		frame.getContentPane().add(cBoxItr);
		
		//Estado
		lblEstadoFil.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblEstadoFil.setBounds(396, 88, 45, 13);
		frame.getContentPane().add(lblEstadoFil);
		

		cBoxEstado.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		cBoxEstado.setBounds(435, 84, 107, 21);
		frame.getContentPane().add(cBoxEstado);
		

		
		//Botones
			//Filtrar
		btnFiltrar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnFiltrar.setForeground(Color.decode("#f0f9ff"));
		btnFiltrar.setBackground(Color.decode("#0ea5e9"));
		btnFiltrar.setBounds(773, 84, 85, 21);
		frame.getContentPane().add(btnFiltrar);
			//Limpiar Filtro
		btnLimpiarF.setFont(new Font("Tahona", Font.BOLD, 10));
		btnLimpiarF.setForeground(Color.decode("#f0f9ff"));
		btnLimpiarF.setBackground(Color.decode("#0ea5e9"));
		btnLimpiarF.setBounds(868, 84, 139, 21);
		frame.getContentPane().add(btnLimpiarF);
		
		
		// Tabla
				Object[][] datosUsu = {

				};

				String[] columnasUsu  = {"Usuario", "ITR", "Estado"};

				JTable tablaUsu = new JTable(datosUsu , columnasUsu );
				JScrollPane scrollPaneUsu  = new JScrollPane(tablaUsu );
				scrollPaneUsu.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
				scrollPaneUsu.setBackground(Color.decode("#f3f4f6"));
				scrollPaneUsu.setBounds(25, 140, 955, 248);
				frame.getContentPane().add(scrollPaneUsu);
		
		//botones
			//Atras
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnAtras.setFont(new Font("Tahona", Font.BOLD, 10));
		btnAtras.setForeground(Color.decode("#f0f9ff"));
		btnAtras.setBackground(Color.decode("#0284c7"));
		btnAtras.setBounds(754, 410, 96, 31);
		frame.getContentPane().add(btnAtras);
			//Modificar
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatosUsuario.main(null);
			}
		});
		btnModificar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnModificar.setForeground(Color.decode("#f0f9ff"));
		btnModificar.setBackground(Color.decode("#0284c7"));
		btnModificar.setBounds(884, 410, 96, 31);
		frame.getContentPane().add(btnModificar);
		
		// Historial
		JButton btnHistorial = new JButton("Historial");
		btnHistorial.setFont(new Font("Tahona", Font.BOLD, 10));
		btnHistorial.setForeground(Color.decode("#f0f9ff"));
		btnHistorial.setBackground(Color.decode("#0ea5e9"));
		btnHistorial.setBounds(131, 415, 85, 21);
		frame.getContentPane().add(btnHistorial);

		// Datos
		JButton btnDatos = new JButton("Datos");
		btnDatos.setFont(new Font("Tahona", Font.BOLD, 10));
		btnDatos.setForeground(Color.decode("#f0f9ff"));
		btnDatos.setBackground(Color.decode("#0ea5e9"));
		btnDatos.setBounds(25, 415, 85, 21);
		frame.getContentPane().add(btnDatos);
	}
}
