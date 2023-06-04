package analista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class ListaUsuarios {

	private JFrame frame;

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
		frame = new JFrame();
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
		JLabel lblTitListUsua = new JLabel("Lista de Usuarios");
		lblTitListUsua.setForeground(Color.decode("#08ACEC"));  
		lblTitListUsua.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblTitListUsua.setBounds(343, 10, 259, 31);
		frame.getContentPane().add(lblTitListUsua);
		
		//*Filtro
		
		// Generacion
		JLabel lblGeneracion = new JLabel("Generación");
		lblGeneracion.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblGeneracion.setBounds(565, 88, 73, 13);
		// frame.getContentPane().add(lblGeneracion);

		JComboBox cBoxGeneracion = new JComboBox();
		cBoxGeneracion.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		cBoxGeneracion.setBounds(630, 84, 107, 21);
		// frame.getContentPane().add(cBoxGeneracion);
		
		//Tipo de usuario
		JLabel lblTipoUsu = new JLabel("Tipo de usuario");
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
		JLabel lblItrFil = new JLabel("ITR");
		lblItrFil.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblItrFil.setBounds(241, 88, 45, 13);
		frame.getContentPane().add(lblItrFil);
		
		JComboBox cBoxItr = new JComboBox();
		cBoxItr.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		cBoxItr.setBounds(264, 84, 107, 21);
		frame.getContentPane().add(cBoxItr);
		
		//Estado
		JLabel lblEstadoFil = new JLabel("Estado");
		lblEstadoFil.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblEstadoFil.setBounds(396, 88, 45, 13);
		frame.getContentPane().add(lblEstadoFil);
		
		JComboBox cBoxEstado = new JComboBox();
		cBoxEstado.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		cBoxEstado.setBounds(435, 84, 107, 21);
		frame.getContentPane().add(cBoxEstado);
		

		
		//Botones
			//Filtrar
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnFiltrar.setForeground(Color.decode("#f0f9ff"));
		btnFiltrar.setBackground(Color.decode("#0ea5e9"));
		btnFiltrar.setBounds(773, 84, 85, 21);
		frame.getContentPane().add(btnFiltrar);
			//Limpiar Filtro
		JButton btnLimpiarF = new JButton("Limpiar Filtro");
		btnLimpiarF.setFont(new Font("Tahona", Font.BOLD, 10));
		btnLimpiarF.setForeground(Color.decode("#f0f9ff"));
		btnLimpiarF.setBackground(Color.decode("#0ea5e9"));
		btnLimpiarF.setBounds(868, 84, 139, 21);
		frame.getContentPane().add(btnLimpiarF);
		
		
		//*Tabla
		//Usuario
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblUsuario.setBounds(37, 150, 45, 13);
		frame.getContentPane().add(lblUsuario);
		
		//ITR
		JLabel lblItr = new JLabel("ITR");
		lblItr.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblItr.setBounds(191, 150, 45, 13);
		frame.getContentPane().add(lblItr);
		
		//Datos
		JLabel lblDatos = new JLabel("Datos");
		lblDatos.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblDatos.setBounds(374, 150, 45, 13);
		frame.getContentPane().add(lblDatos);
		
		//Historial
		JLabel lblHistorial = new JLabel("Historial");
		lblHistorial.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblHistorial.setBounds(523, 150, 66, 13);
		frame.getContentPane().add(lblHistorial);
		
		//Estado
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblEstado.setBounds(664, 150, 45, 13);
		frame.getContentPane().add(lblEstado);
		
		//Botones
			//Guardar
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnGuardar.setForeground(Color.decode("#f0f9ff"));
		btnGuardar.setBackground(Color.decode("#0ea5e9"));
		btnGuardar.setBounds(827, 180, 85, 21);
		frame.getContentPane().add(btnGuardar);
			//Eliminar
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnEliminar.setForeground(Color.decode("#f0f9ff"));
		btnEliminar.setBackground(Color.decode("#0ea5e9"));
		btnEliminar.setBounds(922, 180, 85, 21);
		frame.getContentPane().add(btnEliminar);
		
		//btn Atras
		JButton btnAtras = new JButton("Atrás");
		btnAtras.setFont(new Font("Tahona", Font.BOLD, 10));
		btnAtras.setForeground(Color.decode("#f0f9ff"));
		btnAtras.setBackground(Color.decode("#0284c7"));
		btnAtras.setBounds(895, 412, 96, 31);
		frame.getContentPane().add(btnAtras);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(630, 180, 152, 21);
		frame.getContentPane().add(comboBox);
	}
}
