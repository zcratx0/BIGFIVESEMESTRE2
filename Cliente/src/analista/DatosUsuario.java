package analista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class DatosUsuario {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatosUsuario window = new DatosUsuario();
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
	public DatosUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.decode("#f9fafb"));
		frame.setBounds(100, 100, 431, 730);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false); 
		
		// Imagen
		JLabel lblLogoUtec = new JLabel("");
		lblLogoUtec.setIcon(new ImageIcon(AgregarITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 0, 107, 50);
		frame.getContentPane().add(lblLogoUtec);
		
		
		//Titulo Datos de Usuario
		JLabel lblTitDatos = new JLabel("Datos de Usuario");
		lblTitDatos.setForeground(Color.decode("#08ACEC"));
		lblTitDatos.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblTitDatos.setBounds(108, 25, 215, 24);
		frame.getContentPane().add(lblTitDatos);
		
		
		// Tipo de usuario
		JLabel lblTipoUsu = new JLabel("Tipo de Usuario");
		lblTipoUsu.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblTipoUsu.setBounds(39, 85, 93, 13);
		frame.getContentPane().add(lblTipoUsu);				
				
		//Nombre
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblNombre.setBounds(39, 130, 64, 13);
		frame.getContentPane().add(lblNombre);
		
		
		//Apellido
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblApellido.setBounds(39, 175, 80, 13);
		frame.getContentPane().add(lblApellido);
		
		
		//Cedula
		JLabel lblCedula = new JLabel("Cédula");
		lblCedula.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblCedula.setBounds(39, 220, 45, 13);
		frame.getContentPane().add(lblCedula);
		
		
		//Fecha de nacimiento
		JLabel lblFechNac = new JLabel("Fecha de Nacimiento");
		lblFechNac.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblFechNac.setBounds(39, 265, 156, 13);
		frame.getContentPane().add(lblFechNac);
		
		//Email Personal
		JLabel lblEmailP = new JLabel("Email Personal");
		lblEmailP.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblEmailP.setBounds(39, 310, 116, 13);
		frame.getContentPane().add(lblEmailP);
		
		//Email UTEC
		JLabel lblEmailU = new JLabel("Email UTEC");
		lblEmailU.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblEmailU.setBounds(39, 355, 116, 13);
		frame.getContentPane().add(lblEmailU);
		
		
		//Telefono
		JLabel lblTel = new JLabel("Teléfono");
		lblTel.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblTel.setBounds(39, 400, 93, 13);
		frame.getContentPane().add(lblTel);
		
		
		//Departamento
		JLabel lblDepa = new JLabel("Departamento");
		lblDepa.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblDepa.setBounds(39, 445, 93, 13);
		frame.getContentPane().add(lblDepa);
		
		
		//Localidad
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblLocalidad.setBounds(39, 490, 93, 13);
		frame.getContentPane().add(lblLocalidad);
		
		
		//ITR
		JLabel lblItr = new JLabel("ITR");
		lblItr.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblItr.setBounds(39, 535, 45, 13);
		frame.getContentPane().add(lblItr);
		
		
		//Estado
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblEstado.setBounds(39, 580, 45, 13);
		frame.getContentPane().add(lblEstado);
		
		JComboBox cBoxEstado = new JComboBox();
		cBoxEstado.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		cBoxEstado.setBounds(195, 580, 183, 21);
		frame.getContentPane().add(cBoxEstado);
		
		
		//Botones
			//Guardar
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnGuardar.setForeground(Color.decode("#f0f9ff"));
		btnGuardar.setBackground(Color.decode("#0284c7"));
		btnGuardar.setBounds(298, 637, 93, 32);
		frame.getContentPane().add(btnGuardar);
			//Atras
		JButton btnAtras = new JButton("Atrás");
		btnAtras.setFont(new Font("Tahona", Font.BOLD, 10));
		btnAtras.setForeground(Color.decode("#f0f9ff"));
		btnAtras.setBackground(Color.decode("#0284c7"));
		btnAtras.setBounds(165, 637, 93, 32);
		frame.getContentPane().add(btnAtras);
		
	}

}
