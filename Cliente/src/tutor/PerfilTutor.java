package tutor;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.bigfive.entities.Estudiante;
import com.bigfive.entities.Tutor;
import com.bigfive.entities.Usuario;

import analista.ListaAuxITR;
import estudiante.PerfilEstudiantes;
import funcionalidades.FuncionalidadesArea;
import funcionalidades.FuncionalidadesDepartamento;
import funcionalidades.FuncionalidadesITR;
import validaciones.ValidacionContrasenia;
import validaciones.ValidacionEmailInsti;
import validaciones.ValidacionEmailPersonal;
import validaciones.ValidacionMaxyMin;
import validaciones.ValidarInputs;

public class PerfilTutor {

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
	JLabel lblArea = new JLabel("Área");
	JComboBox cBoxArea = new JComboBox();
	JLabel lblRol = new JLabel("Rol");
	JComboBox cBoxRol = new JComboBox();
	private final JTextField tfFechaNac = new JTextField();
	private final JLabel lblGenero = new JLabel("Género");
	private final JComboBox cBoxGenero = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerfilTutor window = new PerfilTutor();
					window.cargarDatosTutor(null);

					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void mostrarPerfilTutor(Tutor tutor) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerfilTutor window = new PerfilTutor();
					window.cargarDatosTutor(tutor);
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
	public PerfilTutor() {
		tfFechaNac.setBounds(142, 178, 219, 19);
		tfFechaNac.setColumns(10);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.getContentPane().setBackground(Color.decode("#f9fafb"));  
		frame.setBounds(100, 30, 417, 750);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		
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
		tfTel.setInputVerifier(new ValidacionMaxyMin(8,16));
		
		
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
		
		//Contraseña
		lblContra.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblContra.setBounds(10, 430, 113, 13);
		frame.getContentPane().add(lblContra);
		
		pasFContra.setBounds(142, 427, 219, 19);
		frame.getContentPane().add(pasFContra);
		pasFContra.setInputVerifier(new ValidacionContrasenia (8));
		
		
		//ITR
		lblITR.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblITR.setBounds(10, 476, 45, 13);
		frame.getContentPane().add(lblITR);
		
		cBoxITR.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		cBoxITR.setBackground(Color.decode("#e5e7eb"));
		cBoxITR.setBounds(142, 472, 219, 21);
		frame.getContentPane().add(cBoxITR);
		
		//Area
		lblArea.setBounds(10, 522, 45, 13);
		lblArea.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		frame.getContentPane().add(lblArea);
	
		cBoxArea.setBounds(142, 518, 219, 21);
		cBoxArea.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		frame.getContentPane().add(cBoxArea);
		
		
		//Rol
		lblRol.setBounds(10, 574, 45, 13);
		lblRol.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		frame.getContentPane().add(lblRol);
	
		cBoxRol.setBounds(142, 570, 219, 21);
		cBoxRol.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		frame.getContentPane().add(cBoxRol);
	
		//Boton Registro
		btnConfirmar.setBackground(Color.decode("#0284c7")); 
		btnConfirmar.setFont(new Font("Tahona", Font.BOLD, 10)); 
		btnConfirmar.setForeground(Color.decode("#f0f9ff"));
		btnConfirmar.setBounds(281, 663, 112, 40);
		frame.getContentPane().add(btnConfirmar);
		
		
		// Boton Cancelar
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PrincipalTutor.main(null);
				frame.dispose();
			}
		});
		btnCancelar.setBackground(Color.decode("#0284c7"));
		btnCancelar.setFont(new Font("Tahona", Font.BOLD, 10)); 
		btnCancelar.setForeground(Color.decode("#f0f9ff"));
		btnCancelar.setBounds(145, 663, 112, 40);
        frame.getContentPane().add(btnCancelar);

			
			
		
		
		//Imagen
		JLabel lblLogoUtec = new JLabel("");
		lblLogoUtec.setIcon(new ImageIcon(ListaAuxITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 1, 107, 50);
		frame.getContentPane().add(lblLogoUtec);
		
		frame.getContentPane().add(tfFechaNac);
		lblGenero.setBounds(10, 616, 45, 13);
		
		frame.getContentPane().add(lblGenero);
		cBoxGenero.setBounds(142, 612, 219, 21);
		
		frame.getContentPane().add(cBoxGenero);
		
		
	}
	public void cargarDatosTutor(Tutor tutor) {
		Usuario usuario = null;
		
		//Carga el combobox de departamento e itr con los valores
		FuncionalidadesDepartamento.getInstance().cargarComboBox(cBoxDepa);
		FuncionalidadesITR.getInstance().cargarComboBox(cBoxITR);
		FuncionalidadesArea.getInstance().cargarComboBox(cBoxArea);
		//FuncionalidadesRol.getInstance().cargarComboBox(cBoxRol);
		if (tutor != null) {
		if (tutor.getUsuario() != null) usuario =  tutor.getUsuario(); 
		if (usuario.getNombre() != null) tfNombre.setText(usuario.getNombre());
		if (usuario.getApellido() != null) tfApellido.setText(usuario.getApellido());
		if (usuario.getDocumento() != null) tfDocumento.setText(usuario.getDocumento());
		if (usuario.getFechaNac() != null) tfFechaNac.setText(usuario.getFechaNac().toString());
		if (usuario.getMail() != null) tfMailPer.setText(usuario.getMail());
		if (usuario.getTelefono() != null) tfTel.setText(usuario.getTelefono());
		if (usuario.getLocalidad() != null) tfLoca.setText(usuario.getLocalidad());
		if (usuario.getDepartamento() != null) cBoxDepa.setSelectedItem(usuario.getDepartamento());
		if (usuario.getMailInstitucional() != null) tfMailInst.setText(usuario.getMailInstitucional());
		if (usuario.getContrasenia() != null) pasFContra.setText(usuario.getContrasenia());
		if (usuario.getItr() != null) cBoxITR.setSelectedItem(usuario.getItr());
		if (tutor.getArea() != null) cBoxArea.setSelectedItem(tutor.getArea());
		//if (tutor.getRol() != null) cBoxRol.setSelectedItem(tutor.getRol());

		}
	}
}



