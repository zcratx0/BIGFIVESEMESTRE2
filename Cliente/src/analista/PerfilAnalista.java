package analista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.bigfive.entities.EnumDepartamentos;
import com.bigfive.entities.Itr;
import com.bigfive.entities.Usuario;

import funcionalidades.DAODepartamento;
import funcionalidades.DAOITR;
import funcionalidades.DAOUsuario;
import io.netty.handler.codec.DateFormatter;
import validaciones.ValidacionContrasenia;
import validaciones.ValidacionEmailInsti;
import validaciones.ValidacionEmailPersonal;
import validaciones.ValidacionFecha;
import validaciones.ValidacionMaxyMin;
import validaciones.ValidacionTelefono;
import validaciones.ValidarInputs;

public class PerfilAnalista extends JPanel {
	//Atributo
JFrame frame = new JFrame();
JLabel lblTitPerfil = new JLabel("Perfil");
JLabel lblNombre = new JLabel("Nombres");
JTextField tfNombre = new JTextField();
JLabel lblApellido = new JLabel("Apellidos");
JTextField tfApellido = new JTextField();
JLabel lblCI = new JLabel("Cédula");
JLabel lblFecNac = new JLabel("Fecha de Nacimiento");
JTextField tfDocumento = new JTextField();
JTextField tfMailPer = new JTextField();
JLabel lblMailP = new JLabel("Email Personal");
JLabel lblTel = new JLabel("Teléfono");
JLabel lblLoc = new JLabel("Localidad");
JTextField tfLoca = new JTextField();
JLabel lblDepa = new JLabel("Departamento");
JComboBox cBoxDepa = new JComboBox();
JLabel lblMailIns = new JLabel("Email Institucional");
JTextField tfMailInst = new JTextField();
JLabel lblContra = new JLabel("Contraseña");
JPasswordField pasFContra = new JPasswordField();
JLabel lblITR = new JLabel("ITR");
JComboBox cBoxITR = new JComboBox();
JButton btnConfirmar = new JButton("Confirmar");
JButton btnCancelar = new JButton("Cancelar");
JTextField tfTel = new JTextField();
private final JTextField tfFechaNac = new JTextField();
private final JLabel lblGenero = new JLabel("Genero");
JComboBox cBoxGenero = new JComboBox();
Usuario usuario = null;
//	Fecha
private Date nac;
private SimpleDateFormat format;




/**
 * Launch the application.
 */
public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				PerfilAnalista window = new PerfilAnalista();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}

public static void mostrarPerfilAnalista(Usuario usuario) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				PerfilAnalista window = new PerfilAnalista();
				window.cargarDatosAnalista(usuario);
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
public PerfilAnalista() {
	
	initialize();
}

/**
 * Initialize the contents of the frame.
 */
private void initialize() {
	frame.getContentPane().setBackground(Color.decode("#f9fafb"));  
	frame.setBounds(100, 30, 417, 650);
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	frame.setResizable(false);

	format = new SimpleDateFormat("dd-MM-yyyy");
	
	//Titulo
	lblTitPerfil.setForeground(Color.decode("#08ACEC"));  
	lblTitPerfil.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
	lblTitPerfil.setBounds(119, 1, 168, 29);
	frame.getContentPane().add(lblTitPerfil);
	
	//Nombre	
	lblNombre.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	lblNombre.setBounds(10, 52, 80, 13);
	frame.getContentPane().add(lblNombre);
	
	tfNombre.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	tfNombre.setBounds(142, 49, 219, 19);
	frame.getContentPane().add(tfNombre);
	tfNombre.setColumns(10);
	tfNombre.setInputVerifier(new ValidacionMaxyMin(2,32));
	tfNombre.addKeyListener(new KeyAdapter() {
		public void keyTyped(KeyEvent e) {
			ValidarInputs.ValidarSoloLetras(e);
		}
	}); 
	
	
	//Apellido
	lblApellido.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	lblApellido.setBounds(10, 92, 80, 13);
	frame.getContentPane().add(lblApellido);
	
	
	tfApellido.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	tfApellido.setText("");
	tfApellido.setBounds(142, 89, 219, 19);
	frame.getContentPane().add(tfApellido);
	tfApellido.setColumns(10);
	tfApellido.setInputVerifier(new ValidacionMaxyMin(2,32));
	tfApellido.addKeyListener(new KeyAdapter() {
		public void keyTyped(KeyEvent e) {
			ValidarInputs.ValidarSoloLetras(e);
		}
	}); 
	
	//Cedula
	lblCI.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	lblCI.setBounds(10, 139, 80, 13);
	frame.getContentPane().add(lblCI);
	
	tfDocumento.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	tfDocumento.setBounds(142, 136, 219, 19);
	frame.getContentPane().add(tfDocumento);
	tfDocumento.setColumns(10);
	tfDocumento.addKeyListener(new KeyAdapter () {
		public void keyTyped(KeyEvent e) {
			ValidarInputs.ValidarSoloNumeros(e);;
		}
	});
	//TODO Revisar porque esto se pude romper!!
			tfDocumento.setInputVerifier(new ValidacionMaxyMin(8,8));
	
	
	
	//Fecha de Nacimiento 
	lblFecNac.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	lblFecNac.setBounds(10, 181, 146, 13);
	frame.getContentPane().add(lblFecNac);
	
	tfFechaNac.setBounds(142, 178, 219, 19);
	tfFechaNac.setColumns(10);
	frame.getContentPane().add(tfFechaNac);
	//Verifica que la fecha ingresada tenga formato dd/mm/yy
	tfFechaNac.setInputVerifier(new ValidacionFecha());
	
	//Email Personal
	lblMailP.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	lblMailP.setBounds(10, 216, 113, 13);
	frame.getContentPane().add(lblMailP);

	tfMailPer.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	tfMailPer.setBounds(142, 213, 219, 19);
	frame.getContentPane().add(tfMailPer);
	tfMailPer.setColumns(10);
	tfMailPer.setInputVerifier(new ValidacionEmailPersonal());
	
	//Telefono
	lblTel.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	lblTel.setBounds(10, 261, 45, 13);
	frame.getContentPane().add(lblTel);
	
	tfTel.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	tfTel.setBounds(142, 258, 219, 19);
	frame.getContentPane().add(tfTel);
	tfTel.setColumns(10);
	//tfTel.setInputVerifier(new ValidacionMaxyMin(8,16));
	//Acepta paréntesis y signo de + al inicio además de puntos y guiones como separadores, minimo 8 caracteres
	tfTel.setInputVerifier(new ValidacionTelefono());
	
	//Localidad
	lblLoc.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	lblLoc.setBounds(10, 302, 122, 13);
	frame.getContentPane().add(lblLoc);
	
	tfLoca.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	tfLoca.setBounds(142, 299, 219, 19);
	frame.getContentPane().add(tfLoca);
	tfLoca.setColumns(10);
	tfLoca.addKeyListener(new KeyAdapter() {
		public void keyTyped(KeyEvent e) {
			ValidarInputs.ValidarSoloLetras(e);
		}
	}); 
	tfLoca.setInputVerifier(new ValidacionMaxyMin(2,24));
	
	
	//Departamento
	lblDepa.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	lblDepa.setBounds(10, 344, 113, 13);
	frame.getContentPane().add(lblDepa);
	
	cBoxDepa.setBounds(142, 340, 219, 21);
	cBoxDepa.setBackground(Color.decode("#e5e7eb"));
	frame.getContentPane().add(cBoxDepa);
	
	//Mail Insitucional
	lblMailIns.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	lblMailIns.setBounds(10, 385, 132, 13);
	frame.getContentPane().add(lblMailIns);
	
	tfMailInst.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	tfMailInst.setText("");
	tfMailInst.setBounds(142, 382, 219, 19);
	frame.getContentPane().add(tfMailInst);
	tfMailInst.setColumns(10);
	tfMailInst.setInputVerifier(new ValidacionEmailInsti());
	
	tfMailInst.setEnabled(false);
	
	//Contraseña
	lblContra.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	lblContra.setBounds(10, 430, 113, 13);
	frame.getContentPane().add(lblContra);
	
	pasFContra.setBounds(142, 427, 219, 19);
	pasFContra.setInputVerifier(new ValidacionContrasenia (8));
	frame.getContentPane().add(pasFContra);

	
	
	//ITR
	lblITR.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	lblITR.setBounds(10, 476, 45, 13);
	frame.getContentPane().add(lblITR);
	
	cBoxITR.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	cBoxITR.setBackground(Color.decode("#e5e7eb"));
	cBoxITR.setBounds(142, 472, 219, 21);
	frame.getContentPane().add(cBoxITR);
	
	//Genero
	lblGenero.setBounds(10, 515, 65, 13);
	lblGenero.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	frame.getContentPane().add(lblGenero);
	
	cBoxGenero.setBounds(142, 511, 219, 21);
	frame.getContentPane().add(cBoxGenero);

	
	//Boton Registro
	btnConfirmar.setBackground(Color.decode("#0284c7")); 
	btnConfirmar.setFont(new Font("Tahona", Font.BOLD, 10)); 
	btnConfirmar.setForeground(Color.decode("#f0f9ff"));
	btnConfirmar.setBounds(249, 563, 112, 40);
	btnConfirmar.addActionListener(e -> {

		if (camposCompletos()) {
	        guardarCambios(usuario);
	    } else {
	    	JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos antes de guardar.");
	    }
	});
	frame.getContentPane().add(btnConfirmar);
	
	
	// Boton Cancelar
	
	btnCancelar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//PrincipalAnalista.main(null);
			frame.dispose();
		}
	});
	btnCancelar.setBackground(Color.decode("#0284c7"));
	btnCancelar.setFont(new Font("Tahona", Font.BOLD, 10)); 
	btnCancelar.setForeground(Color.decode("#f0f9ff"));
	btnCancelar.setBounds(114, 563, 112, 40);
    frame.getContentPane().add(btnCancelar);

	
	//Imagen
	JLabel lblLogoUtec = new JLabel("");
	lblLogoUtec.setIcon(new ImageIcon(ListaAuxITR.class.getResource("/img/LogoUTEC30x30.png")));
	lblLogoUtec.setBounds(25, 1, 107, 50);
	frame.getContentPane().add(lblLogoUtec);
	
	//	CARGAR DATOS
	DAODepartamento.getInstance().cargarComboBox(cBoxDepa);
	
	
}
	public void cargarDatosAnalista(Usuario usuario) {
		this.usuario = usuario;
		//Carga el combobox de departamento e itr con los valores
		DAODepartamento.getInstance().cargarComboBox(cBoxDepa);
		DAOITR.getInstance().cargarComboBox(cBoxITR);
		if (usuario.getNombre() != null) tfNombre.setText(usuario.getNombre());
		if (usuario.getApellido() != null) tfApellido.setText(usuario.getApellido());
		if (usuario.getDocumento() != null) tfDocumento.setText(usuario.getDocumento());
		if (usuario.getFechaNacimiento() != null) tfFechaNac.setText(new SimpleDateFormat("dd/MM/YYYY").format(usuario.getFechaNacimiento()));
		if (usuario.getMail() != null) tfMailPer.setText(usuario.getMail());
		if (usuario.getTelefono() != null) tfTel.setText(usuario.getTelefono());
		if (usuario.getLocalidad() != null) tfLoca.setText(usuario.getLocalidad());
		//if (usuario.getDepartamento() != null) cBoxDepa.setSelectedItem(usuario.getDepartamento().getIdDepartamento());
		if (usuario.getDepartamentos() != null) cBoxDepa.setSelectedItem(usuario.getDepartamentos());
		if (usuario.getMailInstitucional() != null) tfMailInst.setText(usuario.getMailInstitucional());
		if (usuario.getContrasenia() != null) pasFContra.setText(usuario.getContrasenia());
		if (usuario.getItr() != null) cBoxITR.setSelectedItem(usuario.getItr());
	}
	public void guardarCambios(Usuario usuario) {
		//		PROCESAR FECHA DE NACIMIENTO
		try {
			Date fechaNac = new SimpleDateFormat("dd/mm/yyyy").parse(tfFechaNac.getText());
			System.out.println(fechaNac);
			usuario.setFechaNacimiento(fechaNac);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		usuario.setNombre(tfNombre.getText());
		usuario.setApellido(tfApellido.getText());
		usuario.setDocumento(tfDocumento.getText());
		usuario.setMail(tfMailPer.getText());
		usuario.setMailInstitucional(tfMailInst.getText());
		usuario.setTelefono(tfTel.getText());
		usuario.setDepartamentos( (EnumDepartamentos)cBoxDepa.getSelectedItem());
		usuario.setLocalidad(tfLoca.getText());
		usuario.setContrasenia(new String(pasFContra.getPassword()));
		usuario.setItr((Itr) cBoxITR.getSelectedItem());
		DAOUsuario.getInstance().getBean().modificar(usuario);
		
		
		
	}
	
	//Valida que todos los campos estén llenos antes de guardar
	public boolean camposCompletos() {
	    return !tfNombre.getText().isEmpty()
	            && !tfApellido.getText().isEmpty()
	            && !tfDocumento.getText().isEmpty()
	            // Agregar validación para la fecha de nacimiento aquí
	            && !tfMailPer.getText().isEmpty()
	            && !tfMailInst.getText().isEmpty()
	            && !tfTel.getText().isEmpty()
	            && cBoxDepa.getSelectedItem() != null
	            && !tfLoca.getText().isEmpty()
	            && pasFContra.getPassword().length > 0
	            && cBoxITR.getSelectedItem() != null;
	}
	
}
