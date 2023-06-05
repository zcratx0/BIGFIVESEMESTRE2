package analista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.naming.InitialContext;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.bigfive.beans.UsuarioBean;
import com.bigfive.beans.UsuarioBeanRemote;
import com.bigfive.entities.Usuario;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class DatosUsuario {

	private JFrame frame;
	JLabel lblLogoUtec = new JLabel("");
	JLabel lblNombre = new JLabel("Nombre");
	JLabel lblApellido = new JLabel("Apellido");
	JLabel lblCedula = new JLabel("Cédula");
	JLabel lblFechNac = new JLabel("Fecha de Nacimiento");
	JLabel lblEmailP = new JLabel("Email Personal");
	JLabel lblEmailU = new JLabel("Email UTEC");
	JLabel lblTel = new JLabel("Teléfono");
	JLabel lblDepa = new JLabel("Departamento");
	JLabel lblLocalidad = new JLabel("Localidad");
	JLabel lblItr = new JLabel("ITR");


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatosUsuario window = new DatosUsuario();
					window.frame.setVisible(true);
					UsuarioBeanRemote userBean = (UsuarioBeanRemote) InitialContext.doLookup("ejb:/ProyectoEJB/UsuarioBean!com.bigfive.beans.UsuarioBeanRemote");
					Usuario user = userBean.listarElementos().get(0);
					window.cargarDatos(user);
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
		
		lblNombre.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblNombre.setBounds(39, 130, 256, 13);
		frame.getContentPane().add(lblNombre);
		
		
		//Apellido
		lblApellido.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblApellido.setBounds(39, 175, 256, 13);
		frame.getContentPane().add(lblApellido);
		
		
		//Cedula
		lblCedula.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblCedula.setBounds(39, 220, 256, 13);
		frame.getContentPane().add(lblCedula);
		
		
		//Fecha de nacimiento
		lblFechNac.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblFechNac.setBounds(39, 265, 256, 13);
		frame.getContentPane().add(lblFechNac);
		
		//Email Personal
		lblEmailP.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblEmailP.setBounds(39, 310, 256, 13);
		frame.getContentPane().add(lblEmailP);
		
		//Email UTEC
		lblEmailU.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblEmailU.setBounds(39, 355, 256, 13);
		frame.getContentPane().add(lblEmailU);
		
		
		//Telefono
		lblTel.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblTel.setBounds(39, 400, 256, 13);
		frame.getContentPane().add(lblTel);
		
		
		//Departamento
		lblDepa.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblDepa.setBounds(39, 445, 256, 13);
		frame.getContentPane().add(lblDepa);
		
		
		//Localidad
		lblLocalidad.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblLocalidad.setBounds(39, 490, 256, 13);
		frame.getContentPane().add(lblLocalidad);
		
		
		//ITR
		lblItr.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblItr.setBounds(39, 535, 256, 13);
		frame.getContentPane().add(lblItr);
		
		
		//Estado
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblEstado.setBounds(39, 580, 256, 13);
		frame.getContentPane().add(lblEstado);
		
		JComboBox cBoxEstado = new JComboBox();
		cBoxEstado.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		cBoxEstado.setBounds(195, 580, 256, 21);
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
	public void cargarDatos(Usuario user) {
		if (user.getNombre() == null) 
		lblNombre.setText(lblNombre.getText() + ": "+ user.getNombre());
		lblApellido.setText(lblApellido.getText()+ " " + user.getApellido());
		lblCedula.setText(lblCedula.getText()+ ": " + user.getDocumento());
		//lblFechNac.setText(user.getFechaNac());
		lblEmailP.setText(lblEmailP.getText() + ": " + user.getMail());
		lblEmailU.setText(lblEmailU.getText() + ": " + user.getMailInstitucional());
		lblTel.setText(lblTel.getText() + ": " + user.getTelefono());
		//lblDepa.setText(user.getDepartamento().getNombre());
		lblLocalidad.setText(lblLocalidad.getText() + ": " +  user.getLocalidad());
	}

}
