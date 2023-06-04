package logIn;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class LogIn {

	private JFrame frame;
	private JTextField tfUsuario;
	private JPasswordField pasFContra;

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
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.decode("#f9fafb")); 
		frame.setBounds(100, 100, 453, 330);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 153, 273);
		frame.getContentPane().add(panel);
		
		
		//Usuario
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Bookman Old Style", Font.BOLD, 10)); 
		lblUsuario.setBounds(226, 42, 45, 13);
		frame.getContentPane().add(lblUsuario);
		
		tfUsuario = new JTextField();
		tfUsuario.setFont(new Font("Bookman Old Style", Font.PLAIN, 10)); 
		tfUsuario.setBounds(226, 74, 188, 19);
		frame.getContentPane().add(tfUsuario);
		tfUsuario.setColumns(10);
		
		JLabel lblImgUsuario = new JLabel("");
		lblImgUsuario.setIcon(new ImageIcon(LogIn.class.getResource("/img/Icono.png")));
		lblImgUsuario.setBounds(171, 61, 45, 32);
		frame.getContentPane().add(lblImgUsuario);
		
		//Contraseña
		JLabel lblContrasenia = new JLabel("Contraseña");
		lblContrasenia.setFont(new Font("Bookman Old Style", Font.BOLD, 10)); 
		lblContrasenia.setBounds(226, 131, 83, 13);
		frame.getContentPane().add(lblContrasenia);
		
		pasFContra = new JPasswordField();
		pasFContra.setBounds(226, 154, 188, 19);
		frame.getContentPane().add(pasFContra);
		
		JLabel lblImgContrasenia = new JLabel("");
		lblImgContrasenia.setIcon(new ImageIcon(LogIn.class.getResource("/img/Password.png")));
		lblImgContrasenia.setBounds(173, 131, 45, 48);
		frame.getContentPane().add(lblImgContrasenia);
		
		//Olvidaste tu contraseña
		JLabel lblOlvidContra = new JLabel("¿Olvidaste tu Contraseña?");
		lblOlvidContra.setFont(new Font("Bookman Old Style", Font.PLAIN, 10)); 
		lblOlvidContra.setBounds(226, 194, 171, 13);
		frame.getContentPane().add(lblOlvidContra);
		
		//Boton
			//Ingresar
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setBackground(Color.decode("#0284c7"));
		btnIngresar.setFont(new Font("Bookman Old Style", Font.PLAIN, 10)); 
		btnIngresar.setForeground(Color.decode("#f0f9ff"));
		btnIngresar.setBounds(337, 243, 92, 29);
		frame.getContentPane().add(btnIngresar);
			//Registrarse
		JButton btnRegistro = new JButton("Registrarse");
		btnRegistro.setBackground(Color.decode("#0284c7"));
		btnRegistro.setFont(new Font("Bookman Old Style", Font.PLAIN, 10)); 
		btnRegistro.setForeground(Color.decode("#f0f9ff"));
		btnRegistro.setBounds(191, 243, 118, 29);
		frame.getContentPane().add(btnRegistro);

		
		
	}
}
