package logIn;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.bigfive.entities.Estudiante;
import com.bigfive.entities.Tutor;
import com.bigfive.entities.Usuario;

import analista.PrincipalAnalista;
import estudiante.PrincipalEstudiante;
import funcionalidades.DAOUsuario;
import tutor.PrincipalTutor;
import validaciones.Mensajes;

public class LogIn {

	JFrame frame = new JFrame();
	JLabel lblUsuario = new JLabel("Usuario");
	JTextField tfUsuario = new JTextField();
	JLabel lblContrasenia = new JLabel("Contraseña");
	JPasswordField pasFContra = new JPasswordField();
	JLabel lblOlvidContra = new JLabel("¿Olvidaste tu Contraseña?");
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn window = new LogIn();
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
	public LogIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.getContentPane().setBackground(Color.decode("#f9fafb")); 
		frame.setBounds(100, 100, 453, 330);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 153, 273);
		frame.getContentPane().add(panel);
		
		
		//Usuario
		lblUsuario.setFont(new Font("Bookman Old Style", Font.BOLD, 10)); 
		lblUsuario.setBounds(226, 42, 45, 13);
		frame.getContentPane().add(lblUsuario);
		
		tfUsuario.setFont(new Font("Bookman Old Style", Font.PLAIN, 10)); 
		tfUsuario.setBounds(226, 74, 188, 19);
		frame.getContentPane().add(tfUsuario);
		tfUsuario.setColumns(10);
		
		JLabel lblImgUsuario = new JLabel("");
		lblImgUsuario.setIcon(new ImageIcon(LogIn.class.getResource("/img/Icono.png")));
		lblImgUsuario.setBounds(171, 61, 45, 32);
		frame.getContentPane().add(lblImgUsuario);
		
		//Contraseña
		lblContrasenia.setFont(new Font("Bookman Old Style", Font.BOLD, 10)); 
		lblContrasenia.setBounds(226, 131, 83, 13);
		frame.getContentPane().add(lblContrasenia);
		
		
		pasFContra.setBounds(226, 154, 188, 19);
		frame.getContentPane().add(pasFContra);
		
		JLabel lblImgContrasenia = new JLabel("");
		lblImgContrasenia.setIcon(new ImageIcon(LogIn.class.getResource("/img/Password.png")));
		lblImgContrasenia.setBounds(173, 131, 45, 48);
		frame.getContentPane().add(lblImgContrasenia);
		lblOlvidContra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblOlvidContra.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Mantenimiento.main(null);
				
			}
			
			
			@Override
			public void mouseEntered(MouseEvent e) {
				lblOlvidContra.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}
		});
		
		
		//Olvidaste tu contraseña
		lblOlvidContra.setFont(new Font("Bookman Old Style", Font.PLAIN, 10)); 
		lblOlvidContra.setBounds(226, 194, 171, 13);
		frame.getContentPane().add(lblOlvidContra);
		
		//Boton
			//Ingresar
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setBackground(Color.decode("#0284c7"));
		btnIngresar.setFont(new Font("Tahona", Font.BOLD, 10)); 
		btnIngresar.setForeground(Color.decode("#f0f9ff"));
		btnIngresar.setBounds(337, 243, 92, 29);
		btnIngresar.addActionListener(e -> {
			//Preguntar si existe la base de datos
			try {
				//Tipo = tipo de usuario - 0=Analista - 1=Tutor - 2=Estudiante
				int tipo = 0;
				//	CONSEGUIMOS EL USUARIO
				Usuario usuario = DAOUsuario.getInstance().login(tfUsuario.getText(),new String(pasFContra.getPassword()));
				tipo = DAOUsuario.getInstance().getTipo(usuario);
				if (usuario.getEstado() == 0) {JOptionPane.showMessageDialog(null, "USUARIO NO HABILITADO");}
				else {
					System.out.println("tipo: " + tipo);
					// Evlua que tipo de usuario ingresa
					if (tipo == 0) {
						PrincipalAnalista.mostrarAnalista(usuario);
						frame.dispose();
					}  if (tipo == 1) {
						Tutor tutor = DAOUsuario.getInstance().getUserBean().getTutor(usuario);
						PrincipalTutor.mostrarTutor(tutor);
						frame.dispose();
					} else if (tipo == 2) {
						Estudiante estudiante = DAOUsuario.getInstance().getUserBean()
								.getEstudiante(usuario);
						PrincipalEstudiante.mostrarEstudiante(estudiante);
						frame.dispose();
					}
				}
			} catch(Exception e1) {
				Mensajes.MostrarError("Usuario o Contraseña incorrecta");
			}
			
		});
		frame.getContentPane().add(btnIngresar);
		
		
			//Registrarse
		JButton btnRegistro = new JButton("Registrarse");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroUsuario.main(null);
				
			}
		});
		btnRegistro.setBackground(Color.decode("#0284c7"));
		btnRegistro.setFont(new Font("Tahona", Font.BOLD, 10)); 
		btnRegistro.setForeground(Color.decode("#f0f9ff"));
		btnRegistro.setBounds(191, 243, 118, 29);
		frame.getContentPane().add(btnRegistro);	
		
	}
}
