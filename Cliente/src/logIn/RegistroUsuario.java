package logIn;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.bigfive.entities.Analista;
import com.bigfive.entities.Area;
import com.bigfive.entities.Estudiante;
import com.bigfive.entities.Rol;
import com.bigfive.entities.Tutor;
import com.bigfive.entities.Usuario;

import analista.ListaAuxITR;
import funcionalidades.FuncionalidadesAnalista;
import funcionalidades.FuncionalidadesArea;
import funcionalidades.FuncionalidadesDepartamento;
import funcionalidades.FuncionalidadesEstudiante;
import funcionalidades.FuncionalidadesITR;
import funcionalidades.FuncionalidadesRol;
import funcionalidades.FuncionalidadesUsuario;
import validaciones.ValidacionContrasenia;
import validaciones.ValidacionEmailInsti;
import validaciones.ValidacionEmailPersonal;
import validaciones.ValidacionMaxyMin;
import validaciones.ValidarInputs;

public class RegistroUsuario {

	private JFrame frame;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfCedula;
	private JTextField tfMailPer;
	private JTextField tfTel;
	private JTextField tfLoca;
	private JTextField tfMailInst;
	private JPasswordField pasFContra;
	private JComboBox cBoxTipoUsu;
	private JTextField tfFech;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroUsuario window = new RegistroUsuario();
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
	public RegistroUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.decode("#f9fafb"));  
		frame.setBounds(100, 30, 417, 800);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		
		//Titulo
		JLabel lblTitRegUsu = new JLabel("Registro de Usuario");
		lblTitRegUsu.setForeground(Color.decode("#08ACEC"));  
		lblTitRegUsu.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblTitRegUsu.setBounds(78, 10, 295, 29);
		frame.getContentPane().add(lblTitRegUsu);
		
		//Nombre	
		JLabel lblNombre = new JLabel("Nombres");
		lblNombre.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblNombre.setBounds(10, 52, 80, 13);
		frame.getContentPane().add(lblNombre);
		
		tfNombre = new JTextField();
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
		JLabel lblApellido = new JLabel("Apellidos");
		lblApellido.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblApellido.setBounds(10, 92, 80, 13);
		frame.getContentPane().add(lblApellido);
		
		tfApellido = new JTextField();
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
		JLabel lblCI = new JLabel("Cédula");
		lblCI.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblCI.setBounds(10, 139, 80, 13);
		frame.getContentPane().add(lblCI);
		
		tfCedula = new JTextField();
		tfCedula.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		tfCedula.setBounds(142, 136, 219, 19);
		frame.getContentPane().add(tfCedula);
		tfCedula.setColumns(10);
		tfCedula.addKeyListener(new KeyAdapter () {
			public void keyTyped(KeyEvent e) {
				ValidarInputs.ValidarSoloNumeros(e);;
			}
		});
		//TODO Revisar porque esto se pude romper!!
		tfCedula.setInputVerifier(new ValidacionMaxyMin(8,8));
		
		
		
		//Fecha de Nacimiento 
		JLabel lblFecNac = new JLabel("Fecha de Nacimiento");
		lblFecNac.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblFecNac.setBounds(10, 181, 146, 13);
		frame.getContentPane().add(lblFecNac);
		
		tfFech = new JTextField();
		tfFech.setBounds(142, 178, 219, 19);
		frame.getContentPane().add(tfFech);
		tfFech.setColumns(10);
		tfFech.addKeyListener(new KeyAdapter () {
			public void keyTyped(KeyEvent e) {
				//ValidarInputs.ValidarFechas(e);
				 //ValidarTipos.ValidarFecha("Fecha", tfFech);
				
			}
		});
		tfFech.addFocusListener(new FocusAdapter() {
		    public void focusLost(FocusEvent e) {
		        //ValidarTipos.ValidarFecha("Fecha", tfFech);
		    }
		});
		
		//Email Personal
		JLabel lblMailP = new JLabel("Email Personal");
		lblMailP.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblMailP.setBounds(10, 216, 113, 13);
		frame.getContentPane().add(lblMailP);
		
		tfMailPer = new JTextField();
		tfMailPer.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		tfMailPer.setBounds(142, 213, 219, 19);
		frame.getContentPane().add(tfMailPer);
		tfMailPer.setColumns(10);
		tfMailPer.setInputVerifier(new ValidacionEmailPersonal());
		
		
		//Telefono
		JLabel lblTel = new JLabel("Teléfono");
		lblTel.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblTel.setBounds(10, 261, 45, 13);
		frame.getContentPane().add(lblTel);
		
		tfTel = new JTextField();
		tfTel.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		tfTel.setBounds(142, 258, 219, 19);
		frame.getContentPane().add(tfTel);
		tfTel.setColumns(10);
		tfTel.setInputVerifier(new ValidacionMaxyMin(8,16));
		
		
		//Localidad
		JLabel lblLoc = new JLabel("Localidad");
		lblLoc.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblLoc.setBounds(10, 302, 122, 13);
		frame.getContentPane().add(lblLoc);
		
		tfLoca = new JTextField();
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
		JLabel lblDepa = new JLabel("Departamento");
		lblDepa.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblDepa.setBounds(10, 344, 113, 13);
		frame.getContentPane().add(lblDepa);
		
		JComboBox cBoxDepa = new JComboBox();
		cBoxDepa.setBounds(142, 340, 219, 21);
		cBoxDepa.setBackground(Color.decode("#e5e7eb"));
		frame.getContentPane().add(cBoxDepa);
		
		//Mail Insitucional
		JLabel lblMailIns = new JLabel("Email Institucional");
		lblMailIns.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblMailIns.setBounds(10, 385, 132, 13);
		frame.getContentPane().add(lblMailIns);
		
		tfMailInst = new JTextField();
		tfMailInst.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		tfMailInst.setText("");
		tfMailInst.setBounds(142, 382, 219, 19);
		frame.getContentPane().add(tfMailInst);
		tfMailInst.setColumns(10);
		tfMailInst.setInputVerifier(new ValidacionEmailInsti());
		
		
		//Contraseña
		JLabel lblContra = new JLabel("Contraseña");
		lblContra.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblContra.setBounds(10, 430, 113, 13);
		frame.getContentPane().add(lblContra);
		
		pasFContra = new JPasswordField();
		pasFContra.setBounds(142, 427, 219, 19);
		frame.getContentPane().add(pasFContra);
		pasFContra.setInputVerifier(new ValidacionContrasenia (8));
		
		
		//ITR
		JLabel lblITR = new JLabel("ITR");
		lblITR.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblITR.setBounds(10, 476, 45, 13);
		frame.getContentPane().add(lblITR);
		
		JComboBox cBoxITR = new JComboBox();
		cBoxITR.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		cBoxITR.setBackground(Color.decode("#e5e7eb"));
		cBoxITR.setBounds(142, 472, 219, 21);
		frame.getContentPane().add(cBoxITR);
		
		// Genero
		JLabel lblGenero = new JLabel("Género");
		lblGenero.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblGenero.setBounds(10, 518, 45, 13);
		frame.getContentPane().add(lblGenero);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(142, 520, 219, 21);
		frame.getContentPane().add(comboBox);
		
		//Año de ingreso - Est
		JLabel lblAnioIng = new JLabel("Año de Ingreso");
		lblAnioIng.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblAnioIng.setBounds(10, 609, 132, 13);
		
		JTextField tfAnioIng = new JTextField();
		tfAnioIng.setBounds(142, 606, 219, 19);
		tfAnioIng.setColumns(10);
		tfAnioIng.addKeyListener(new KeyAdapter () {
			public void keyTyped(KeyEvent e) {
				//ValidarInputs.ValidarFechas(e);
				//ValidarTipos.ValidarFecha("Fecha", tfAnioIng.getText());
			}
		});
		
		
		
		//Area - Tutor
		JLabel lblArea = new JLabel("Área");
		lblArea.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblArea.setBounds(10, 609, 45, 13);
		
		
		JComboBox cBoxArea = new JComboBox();
		cBoxArea.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		cBoxArea.setBackground(Color.decode("#e5e7eb"));
		cBoxArea.setBounds(142, 605, 219, 21);
		
		
		
		//Rol - Tutor
		JLabel lblRol = new JLabel("Rol");
		lblRol.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblRol.setBounds(10, 654, 45, 13);
		
		
		JComboBox cBoxRol = new JComboBox();
		cBoxRol.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		cBoxRol.setBackground(Color.decode("#e5e7eb"));
		cBoxRol.setBounds(142, 650, 219, 21);
		
		
		//Boton Registro
		JButton btnRegistro = new JButton("Registrarse");
		btnRegistro.setBackground(Color.decode("#0284c7")); 
		btnRegistro.setFont(new Font("Tahona", Font.BOLD, 10)); 
		btnRegistro.setForeground(Color.decode("#f0f9ff"));
		btnRegistro.setBounds(261, 695, 112, 40);
		btnRegistro.addActionListener(e -> {
			System.out.println("USUARIO CREADO!");
			Usuario user = new Usuario();
			user.setNombre(tfNombre.getText());
			user.setApellido(tfApellido.getText());
			user.setDocumento(tfCedula.getText());
			user.setMail(tfMailPer.getText());
			user.setMailInstitucional(tfMailInst.getText());
			user.setTelefono(tfTel.getText());
			user.setLocalidad(tfLoca.getText());
			user.setContrasenia(new String(pasFContra.getPassword()));
			boolean resultado = false;
			Long x = FuncionalidadesUsuario.getInstance().getUserBean().createWithId(user);
			if (x!= null) {
				System.out.println(x);
				user.setIdUsuario(x);
				System.out.println(user.getIdUsuario());
				if (cBoxTipoUsu.getSelectedItem().toString().equalsIgnoreCase("analista")) {
					Analista analista = new Analista();
					analista.setUsuario(user);
					resultado = FuncionalidadesAnalista.getInstance().getBean().crear(analista);
					System.out.println("CREADO - ANALISTA");
				} else if (cBoxTipoUsu.getSelectedItem().toString().equalsIgnoreCase("estudiante")) {
					Estudiante estudiante = new Estudiante();
					estudiante.setUsuario(user);
					estudiante.setGeneracion(tfAnioIng.getText());
					resultado = FuncionalidadesEstudiante.getInstance().getBean().crear(estudiante);
					System.out.print("CREADO - ESTUDIANTE");
				} else if (cBoxTipoUsu.getSelectedItem().toString().equalsIgnoreCase("tutor")) {
					Tutor tutor = new Tutor();
					Area area = (Area) cBoxArea.getSelectedItem();
					Rol rol = (Rol) cBoxRol.getSelectedItem();
					
					tutor.setUsuario(user);
					tutor.setArea(area);
					tutor.setRol(rol);
					tutor.setTipo(null);
					
				}
				
					
			} else {
				System.out.println("RED ALERT");
			}
			
			
			if (resultado)JOptionPane.showMessageDialog(frame, "USUARIO REGISTRADO");
			else {
				JOptionPane.showMessageDialog(frame, "ERROR AL REGISTRAR EL USUARIO");
			}			
			System.out.println(user.toString());
		});
		
		
		
		// Boton Cancelar
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancelar.setBackground(Color.decode("#0284c7"));
		btnCancelar.setFont(new Font("Tahona", Font.BOLD, 10)); 
		btnCancelar.setForeground(Color.decode("#f0f9ff"));
		btnCancelar.setBounds(98, 695, 112, 40);
        frame.getContentPane().add(btnCancelar);
		
		//Tipo de Usuario
		JLabel lblTipoUsu = new JLabel("Tipo de Usuario");
		lblTipoUsu.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblTipoUsu.setBounds(10, 565, 97, 13);
		frame.getContentPane().add(lblTipoUsu);
			
			//Combo Box
		cBoxTipoUsu = new JComboBox(new String[]{"Seleccione Tipo","Analista", "Estudiante", "Tutor"});
		
		//TODO CAMBIAR AÑO POR ANIO
		
		cBoxTipoUsu.setBounds(142, 561, 219, 21);
		cBoxTipoUsu.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		cBoxTipoUsu.addActionListener(e -> {
	        String selected = cBoxTipoUsu.getSelectedItem().toString();
	        //estos son los nuevos datos que pediremos, no estan separados por eso hice un if
	        frame.getContentPane().remove(lblAnioIng);
	        frame.getContentPane().remove(tfAnioIng);
	        frame.getContentPane().remove(btnRegistro);
	        frame.getContentPane().remove(lblArea);
	        frame.getContentPane().remove(cBoxArea);
	        frame.getContentPane().remove(lblRol);
	        frame.getContentPane().remove(cBoxRol);
	        // en estudiantes agrego el label y combo correspondiente
	        if (selected.equals("Estudiante")) {
	            frame.getContentPane().add(lblAnioIng);
	            frame.getContentPane().add(tfAnioIng);
	            frame.getContentPane().add(btnRegistro);
		        frame.getContentPane().remove(lblArea);
		        frame.getContentPane().remove(cBoxArea);
		        frame.getContentPane().remove(lblRol);
		        frame.getContentPane().remove(cBoxRol);
	            // en tutor agrego ek label y combo correspondiente
		        btnRegistro.setEnabled(true);
	        } else if (selected.equals("Tutor")) {
	            frame.getContentPane().add(lblArea);
	            frame.getContentPane().add(cBoxArea);
	            frame.getContentPane().add(lblRol);
	            frame.getContentPane().add(cBoxRol);
	            frame.getContentPane().add(btnRegistro);
	            frame.getContentPane().remove(lblAnioIng);
	            frame.getContentPane().remove(tfAnioIng);
	            //	BLOQUEO BOTON PARA TUTOR
	            btnRegistro.setEnabled(false);
	            // en analista solo boton registar ya que no pide ningun dato mas.
	        } else if(selected.equals("Analista")) {
	        	frame.getContentPane().add(btnRegistro);
	        	 frame.getContentPane().remove(lblAnioIng);
	 	        frame.getContentPane().remove(lblArea);
	 	        frame.getContentPane().remove(cBoxArea);
	 	        frame.getContentPane().remove(lblRol);
	 	        frame.getContentPane().remove(cBoxRol);
	 	       frame.getContentPane().remove(tfAnioIng);
	 	      btnRegistro.setEnabled(true);
	        }
	        //se utilizan después de agregar o quitar algunos componentes de la ventana,
	        // para que Swing pueda actualizar su diseño y mostrar los cambios correctamente.
	        frame.getContentPane().revalidate();
	        frame.getContentPane().repaint();
	    }
				);
		frame.getContentPane().add(cBoxTipoUsu);
		
		
		//Imagen
		JLabel lblLogoUtec = new JLabel("");
		lblLogoUtec.setIcon(new ImageIcon(ListaAuxITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 1, 107, 50);
		frame.getContentPane().add(lblLogoUtec);
		
		FuncionalidadesDepartamento.getInstance().cargarComboBox(cBoxDepa);
		FuncionalidadesITR.getInstance().cargarComboBox(cBoxITR);
		FuncionalidadesRol.getInstance().cargarComboBox(cBoxRol);
		FuncionalidadesArea.getInstance().cargarComboBox(cBoxArea);
		
	}
}
