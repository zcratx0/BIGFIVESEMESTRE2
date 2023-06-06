package analista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.bigfive.entities.Departamento;
import com.bigfive.entities.Itr;
import com.bigfive.entities.Usuario;

import funcionalidades.FuncionalidadesDepartamento;
import funcionalidades.FuncionalidadesITR;
import funcionalidades.FuncionalidadesUsuario;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DatosUsuario {
	int textSize = 14;
		//Atributo
	JFrame frame = new JFrame();
	JLabel lblTitDatos = new JLabel("Datos de Usuario");
	JLabel lblTipoUsu = new JLabel("Tipo de Usuario");
	JLabel lblNombre = new JLabel("Nombre");
	JTextField tfNombre = new JTextField();
	
	JLabel lblApellido = new JLabel("Apellido");
	JTextField tfApellido = new JTextField();
	
	JLabel lblCedula = new JLabel("Cédula");
	JTextField tfCedula = new JTextField();
	
	JLabel lblTel = new JLabel("Teléfono");
	JTextField tfTel = new JTextField();
	JLabel lblFechNac = new JLabel("Fecha de Nacimiento");
	
	JLabel lblEmailP = new JLabel("Email Personal");
	JTextField tfEmailP = new JTextField();
	
	JLabel lblEmailU = new JLabel("Email UTEC");
	JTextField tfEmailU = new JTextField();
	
	JLabel lblDepa = new JLabel("Departamento");
	JComboBox<Departamento> cBoxDepa = new JComboBox<Departamento>();
	
	JLabel lblLocalidad = new JLabel("Localidad");
	JTextField tfLocalidad = new JTextField();

	JLabel lblItr = new JLabel("ITR");
	JComboBox<Itr> cBoxItr = new JComboBox<Itr>();

	JLabel lblEstado = new JLabel("Estado");
	JComboBox cBoxEstado = new JComboBox();
	JButton btnGuardar = new JButton("Guardar");
	JButton btnAtras = new JButton("Atrás");
	Usuario user = null;
	
	

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

	public static void loadDatosUsuario(Usuario user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatosUsuario window = new DatosUsuario();
					window.frame.setVisible(true);
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
		frame.getContentPane().setBackground(Color.decode("#f9fafb"));
		frame.setBounds(100, 100, 431+50, 730);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false); 
		
		// Imagen
		JLabel lblLogoUtec = new JLabel("");
		lblLogoUtec.setIcon(new ImageIcon(AgregarITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 0, 107, 50);
		frame.getContentPane().add(lblLogoUtec);
		
		
		//Titulo Datos de Usuario
		lblTitDatos.setForeground(Color.decode("#08ACEC"));
		lblTitDatos.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblTitDatos.setBounds(108, 25, 265, 24);
		frame.getContentPane().add(lblTitDatos);
		
		
		// Tipo de usuario
		lblTipoUsu.setFont(new Font("Bookman Old Style", Font.PLAIN, textSize));
		lblTipoUsu.setBounds(39, 85, 265, 13);
		frame.getContentPane().add(lblTipoUsu);				
				
		//Nombre
		lblNombre.setFont(new Font("Bookman Old Style", Font.PLAIN, textSize));
		lblNombre.setBounds(39, 130, 265, 13);
		frame.getContentPane().add(lblNombre);
		

		tfNombre.setFont(new Font("Bookman Old Style", Font.PLAIN, textSize));
		tfNombre.setBounds(195, 130, 265, 18);
		tfNombre.setEnabled(false);
		frame.getContentPane().add(tfNombre);
		
		
		//Apellido
		lblApellido.setFont(new Font("Bookman Old Style", Font.PLAIN, textSize));
		lblApellido.setBounds(39, 175, 265, 13);
		frame.getContentPane().add(lblApellido);
		
		tfApellido.setFont(new Font("Bookman Old Style", Font.PLAIN, textSize));
		tfApellido.setBounds(195, 175, 265, 18);
		tfApellido.setEnabled(false);
		frame.getContentPane().add(tfApellido);
		
		
		//Cedula
		lblCedula.setFont(new Font("Bookman Old Style", Font.PLAIN, textSize));
		lblCedula.setBounds(39, 220, 265, 13);
		frame.getContentPane().add(lblCedula);
		
		tfCedula.setFont(new Font("Bookman Old Style", Font.PLAIN, textSize));
		tfCedula.setBounds(195, 220, 265, 18);
		tfCedula.setEnabled(false);
		frame.getContentPane().add(tfCedula);
		
		
		//Fecha de nacimiento
		lblFechNac.setFont(new Font("Bookman Old Style", Font.PLAIN, textSize));
		lblFechNac.setBounds(39, 265, 265, 13);
		frame.getContentPane().add(lblFechNac);
		
		//Email Personal
		lblEmailP.setFont(new Font("Bookman Old Style", Font.PLAIN, textSize));
		lblEmailP.setBounds(39, 310, 265, 13);
		frame.getContentPane().add(lblEmailP);

		tfEmailP.setFont(new Font("Bookman Old Style", Font.PLAIN, textSize));
		tfEmailP.setBounds(195, 310, 265, 18);
		tfEmailP.setEnabled(false);
		frame.getContentPane().add(tfEmailP);
		
		//Email UTEC
		lblEmailU.setFont(new Font("Bookman Old Style", Font.PLAIN, textSize));
		lblEmailU.setBounds(39, 355, 265, 13);
		frame.getContentPane().add(lblEmailU);

		tfEmailU.setFont(new Font("Bookman Old Style", Font.PLAIN, textSize));
		tfEmailU.setBounds(195, 355, 265, 18);
		tfEmailU.setEnabled(false);
		frame.getContentPane().add(tfEmailU);
		
		//Telefono
		lblTel.setFont(new Font("Bookman Old Style", Font.PLAIN, textSize));
		lblTel.setBounds(39, 400, 265, 13);
		frame.getContentPane().add(lblTel);

		tfTel.setFont(new Font("Bookman Old Style", Font.PLAIN, textSize));
		tfTel.setBounds(195, 400, 265, 18);
		tfTel.setEnabled(false);
		frame.getContentPane().add(tfTel);
		
		//Departamento
		lblDepa.setFont(new Font("Bookman Old Style", Font.PLAIN, textSize));
		lblDepa.setBounds(39, 445, 265, 13);
		frame.getContentPane().add(lblDepa);

		cBoxDepa.setFont(new Font("Bookman Old Style", Font.PLAIN, textSize));
		cBoxDepa.setBounds(195, 445, 265, 21);
		frame.getContentPane().add(cBoxDepa);
		
		//Localidad
		lblLocalidad.setFont(new Font("Bookman Old Style", Font.PLAIN, textSize));
		lblLocalidad.setBounds(39, 490, 265, 13);
		frame.getContentPane().add(lblLocalidad);

		tfLocalidad.setFont(new Font("Bookman Old Style", Font.PLAIN, textSize));
		tfLocalidad.setBounds(195, 490, 265, 18);
		tfLocalidad.setEnabled(false);
		frame.getContentPane().add(tfLocalidad);
		
		//ITR
		lblItr.setFont(new Font("Bookman Old Style", Font.PLAIN, textSize));
		lblItr.setBounds(39, 535, 265, 13);
		frame.getContentPane().add(lblItr);

		cBoxItr.setFont(new Font("Bookman Old Style", Font.PLAIN, textSize));
		cBoxItr.setBounds(195, 535, 265, 21);
		frame.getContentPane().add(cBoxItr);
		
		//Estado
		lblEstado.setFont(new Font("Bookman Old Style", Font.PLAIN, textSize));
		lblEstado.setBounds(39, 580, 265, 13);
		frame.getContentPane().add(lblEstado);
		
		cBoxEstado.setFont(new Font("Bookman Old Style", Font.PLAIN, textSize));
		cBoxEstado.setBounds(195, 580, 265, 21);
		frame.getContentPane().add(cBoxEstado);
		
		
		//Botones
			//Guardar
		btnGuardar.setFont(new Font("Tahona", Font.BOLD, textSize));
		btnGuardar.setForeground(Color.decode("#f0f9ff"));
		btnGuardar.setBackground(Color.decode("#0284c7"));
		btnGuardar.setBounds(298, 637, 93, 32);
		btnGuardar.setEnabled(false);
		frame.getContentPane().add(btnGuardar);
			//Atras
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (user != null) actualizarDatos();
				frame.dispose();
			}
		});
		btnAtras.setFont(new Font("Tahona", Font.BOLD, textSize));
		btnAtras.setForeground(Color.decode("#f0f9ff"));
		btnAtras.setBackground(Color.decode("#0284c7"));
		btnAtras.setBounds(165, 637, 93, 32);
		frame.getContentPane().add(btnAtras);
		
		//	FUNCIONALIDAD
		FuncionalidadesDepartamento.getInstance().cargarComboBox(cBoxDepa);
		FuncionalidadesITR.getInstance().cargarComboBox(cBoxItr);

		
		
	}
	
	

	public void cargarDatos(Usuario user) {
		this.user = user;
		if (user.getNombre() != null) tfNombre.setText(user.getNombre());
		if (user.getApellido() != null) tfApellido.setText(user.getApellido());
		if (user.getDocumento() != null) tfCedula.setText(user.getDocumento());
		if (user.getFechaNac() != null) lblFechNac.setText(user.getFechaNac().toString());
		if (user.getMail() != null) tfEmailP.setText(user.getMail());
		if (user.getMailInstitucional() != null) tfEmailU.setText(user.getMailInstitucional());
		if (user.getTelefono() != null) tfTel.setText(user.getTelefono());
		if (user.getDepartamento() != null) cBoxDepa.setSelectedItem(user.getDepartamento());
		if (user.getLocalidad() != null) tfLocalidad.setText(user.getLocalidad());
		if (user.getItr() != null) cBoxItr.setSelectedItem(user.getItr());
		btnGuardar.setEnabled(true);
	}
	public void actualizarDatos() {
		this.user.setNombre(tfNombre.getText());
		this.user.setApellido(tfApellido.getText());
		this.user.setDocumento(tfCedula.getText());
		this.user.setMail(tfEmailP.getText());
		this.user.setMailInstitucional(tfEmailU.getText());
		this.user.setTelefono(tfTel.getText());
		this.user.setDepartamento((Departamento)cBoxDepa.getSelectedItem());
		this.user.setItr((Itr) cBoxItr.getSelectedItem());
		FuncionalidadesUsuario.getInstance().getUserBean().modificar(this.user);
	}

}
