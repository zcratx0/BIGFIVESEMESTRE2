package logIn;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import analista.ListaAuxITR;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPasswordField;

public class RURegistroUsuario {

	private JFrame frame;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfCedula;
	private JTextField tfMailPer;
	private JTextField tfTel;
	private JTextField tfLoca;
	private JTextField tfMailInst;
	private JPasswordField pasFContra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RURegistroUsuario window = new RURegistroUsuario();
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
	public RURegistroUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.decode("#f9fafb"));  
		frame.setBounds(100, 100, 417, 770);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		
		//Fecha de Nacimiento 
		JLabel lblFecNac = new JLabel("Fecha de Nacimiento");
		lblFecNac.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblFecNac.setBounds(10, 181, 146, 13);
		frame.getContentPane().add(lblFecNac);
		
		
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
		
		
		//Contraseña
		JLabel lblContra = new JLabel("Contraseña");
		lblContra.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblContra.setBounds(10, 430, 113, 13);
		frame.getContentPane().add(lblContra);
		
		pasFContra = new JPasswordField();
		pasFContra.setBounds(142, 427, 219, 19);
		frame.getContentPane().add(pasFContra);
		
		
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
		
		//Año de ingreso - Est
		JLabel lblAnioIng = new JLabel("Año de Ingreso");
		lblAnioIng.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblAnioIng.setBounds(10, 568, 132, 13);
		
		
		
		//Area - Tutor
		JLabel lblArea = new JLabel("Área");
		lblArea.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblArea.setBounds(10, 568, 45, 13);
		
		
		JComboBox cBoxArea = new JComboBox();
		cBoxArea.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		cBoxArea.setBackground(Color.decode("#e5e7eb"));
		cBoxArea.setBounds(142, 564, 219, 21);
		
		
		
		//Rol - Tutor
		JLabel lblRol = new JLabel("Rol");
		lblRol.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblRol.setBounds(10, 609, 45, 13);
		
		
		JComboBox cBoxRol = new JComboBox();
		cBoxRol.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		cBoxRol.setBackground(Color.decode("#e5e7eb"));
		cBoxRol.setBounds(142, 605, 219, 21);
		
		
		//Boton Registro
		JButton btnRegistro = new JButton("Registrarse");
		btnRegistro.setBackground(Color.decode("#0284c7")); 
		btnRegistro.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		btnRegistro.setForeground(Color.decode("#f0f9ff"));
		btnRegistro.setBounds(249, 680, 112, 40);
		
		
		// Boton Cancelar
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(Color.decode("#0284c7"));
		btnCancelar.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		btnCancelar.setForeground(Color.decode("#f0f9ff"));
		btnCancelar.setBounds(100, 680, 112, 40);
        frame.getContentPane().add(btnCancelar);
		
		//Tipo de Usuario
		JLabel lblTipoUsu = new JLabel("Tipo de Usuario");
		lblTipoUsu.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblTipoUsu.setBounds(10, 518, 97, 13);
		frame.getContentPane().add(lblTipoUsu);
			
			//Combo Box
		JComboBox cBoxTipoUsu = new JComboBox(new String[]{"Seleccione Tipo","Analista", "Estudiante", "Tutor"});
		
		//TODO CAMBIAR AÑO POR ANIO
		
		cBoxTipoUsu.setBounds(142, 514, 219, 21);
		cBoxTipoUsu.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		cBoxTipoUsu.addActionListener(e -> {
	        String selected = cBoxTipoUsu.getSelectedItem().toString();
	        //estos son los nuevos datos que pediremos, no estan separados por eso hice un if
	        frame.getContentPane().remove(lblAnioIng);
	        frame.getContentPane().remove(btnRegistro);
	        frame.getContentPane().remove(lblArea);
	        frame.getContentPane().remove(cBoxArea);
	        frame.getContentPane().remove(lblRol);
	        frame.getContentPane().remove(cBoxRol);
	        // en estudiantes agrego el label y combo correspondiente
	        if (selected.equals("Estudiante")) {
	            frame.getContentPane().add(lblAnioIng);
	            frame.getContentPane().add(btnRegistro);
		        frame.getContentPane().remove(lblArea);
		        frame.getContentPane().remove(cBoxArea);
		        frame.getContentPane().remove(lblRol);
		        frame.getContentPane().remove(cBoxRol);
	            // en tutor agrego ek label y combo correspondiente
	        } else if (selected.equals("Tutor")) {
	            frame.getContentPane().add(lblArea);
	            frame.getContentPane().add(cBoxArea);
	            frame.getContentPane().add(lblRol);
	            frame.getContentPane().add(cBoxRol);
	            frame.getContentPane().add(btnRegistro);
	            frame.getContentPane().remove(lblAnioIng);

	            // en analista solo boton registar ya que no pide ningun dato mas.
	        } else if(selected.equals("Analista")) {
	        	frame.getContentPane().add(btnRegistro);
	        	 frame.getContentPane().remove(lblAnioIng);
	 	        frame.getContentPane().remove(lblArea);
	 	        frame.getContentPane().remove(cBoxArea);
	 	        frame.getContentPane().remove(lblRol);
	 	        frame.getContentPane().remove(cBoxRol);
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
			
	}
}
