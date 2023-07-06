package analista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.bigfive.entities.Analista;
import com.bigfive.entities.Usuario;

import funcionalidades.DAOAnalista;
import funcionalidades.DAOUsuario;
import logIn.LogIn;

public class PrincipalAnalista {//Atributos
	JFrame frame = new JFrame();
	JButton btnConstancia = new JButton("Constancias");
	JLabel lblLogoUtec = new JLabel("");
	JButton btnPerfil = new JButton("Perfil");
	JButton btnEscolaridad = new JButton("Escolaridad");
	JButton btnReclamos = new JButton("Reclamos");
	JButton btnMantenimiento = new JButton("Mantenimiento ITR's");
	JButton btnUsuarios = new JButton("Usuarios");
	JLabel lblPerfil = new JLabel("");
	JLabel lblNombrePerfil = new JLabel("");
	JLabel lblTitAnalista = new JLabel("Analista");
	Analista analista = null;
	private Usuario usuarioAnalista = null;
	private final JButton btnLogOut = new JButton("LogOut");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalAnalista window = new PrincipalAnalista();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//TODO Funcion para estudiante y tutor
	public static void mostrarAnalista(Usuario usuario) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalAnalista window = new PrincipalAnalista();
					//definimos el usuario con la variable usuario 
					window.usuarioAnalista = usuario;
					if (usuario != null) {
						if(usuario.getMailInstitucional() != null) {
							window.lblNombrePerfil.setText(usuario.getMailInstitucional().split("@")[0]);
							window.analista = DAOUsuario.getInstance().getBean().getAnalista(usuario);
						}
					}
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
	public PrincipalAnalista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame.setBounds(100, 100, 973, 363);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.decode("#f9fafb"));
		frame.setResizable(false);

		// Imagen

		lblLogoUtec.setIcon(new ImageIcon(AgregarITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 0, 56, 50);
		frame.getContentPane().add(lblLogoUtec);

		// Imagen Perfil

		lblPerfil.setIcon(new ImageIcon(AgregarITR.class.getResource("/img/Perfil.png")));
		lblPerfil.setBounds(707, 0, 56, 50);
		frame.getContentPane().add(lblPerfil);
		
		//Titulo analista 
		lblTitAnalista.setBounds(77, 8, 185, 30);
		lblTitAnalista.setForeground(Color.decode("#08ACEC"));
		lblTitAnalista.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		frame.getContentPane().add(lblTitAnalista);
		
		
		// Nombre de usuario
		lblNombrePerfil.setBounds(752, 20, 197, 13);
		frame.getContentPane().add(lblNombrePerfil);
		

			//Perfil
		btnPerfil.setFont(new Font("Tahona", Font.BOLD, 10));
		btnPerfil.setForeground(Color.decode("#f0f9ff"));
		btnPerfil.setBackground(Color.decode("#3b82f6"));
		btnPerfil.setBounds(80, 65, 107, 40);
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (usuarioAnalista != null) PerfilAnalista.mostrarPerfilAnalista(usuarioAnalista);
				else {PerfilAnalista.main(null);}
				//frame.dispose();
			}
		});
		frame.getContentPane().add(btnPerfil);
		
		//Escolaridad
		btnEscolaridad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaEscolaridad.main(null);
				//frame.dispose();
			}
		});
		btnEscolaridad.setFont(new Font("Tahona", Font.BOLD, 10));
		btnEscolaridad.setForeground(Color.decode("#f0f9ff"));
		btnEscolaridad.setBackground(Color.decode("#3b82f6"));
		btnEscolaridad.setBounds(220, 65, 107, 40);
		frame.getContentPane().add(btnEscolaridad);
		
			//Reclamos
		btnReclamos.setFont(new Font("Tahona", Font.BOLD, 10));
		btnReclamos.setForeground(Color.decode("#f0f9ff"));
		btnReclamos.setBackground(Color.decode("#3b82f6"));
		btnReclamos.setBounds(360, 65, 107, 40);
		btnReclamos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaReclamo.main(analista);
				//frame.dispose();
			}
		});
		frame.getContentPane().add(btnReclamos);
		
			//Constancias
		btnConstancia.setFont(new Font("Tahona", Font.BOLD, 10));
		btnConstancia.setForeground(Color.decode("#f0f9ff"));
		btnConstancia.setBackground(Color.decode("#3b82f6"));
		btnConstancia.setBounds(500, 65, 107, 40);
		frame.getContentPane().add(btnConstancia);
		btnConstancia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaSoliConstancias.main(null);
				//frame.dispose();
			}
		});
		
		// mantenimientos
		
		btnMantenimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaAuxITR.main(null);
			}
		});
		btnMantenimiento.setFont(new Font("Tahona", Font.BOLD, 10));
		btnMantenimiento.setForeground(Color.decode("#f0f9ff"));
		btnMantenimiento.setBackground(Color.decode("#3b82f6"));
		btnMantenimiento.setBounds(780, 65, 139, 40);
		frame.getContentPane().add(btnMantenimiento);
		
				//mantenimiento Estado
		JButton btnMantEstado = new JButton("Lista Estado");
		btnMantEstado.setBounds(780, 136, 139, 40);
		btnMantEstado.setFont(new Font("Tahona", Font.BOLD, 10));
		btnMantEstado.setForeground(Color.decode("#f0f9ff"));
		btnMantEstado.setBackground(Color.decode("#3b82f6"));
		btnMantEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaAuxEstados.main(null);
			}
		});
		frame.getContentPane().add(btnMantEstado);
		
		// usuarios 
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HabilitacionUsuario.mostrar();
				//frame.dispose();
			}
		});
		btnUsuarios.setFont(new Font("Tahona", Font.BOLD, 10)); 
		btnUsuarios.setForeground(Color.decode("#f0f9ff"));
		btnUsuarios.setBackground(Color.decode("#3b82f6"));
		btnUsuarios.setBounds(640, 65, 107, 40);
		
		//TODO logout
		frame.getContentPane().add(btnUsuarios);
		btnLogOut.setFont(new Font("Tahona", Font.BOLD, 10)); 
		btnLogOut.setForeground(Color.decode("#f0f9ff"));    
		btnLogOut.setBackground(Color.decode("#0369a1"));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogIn.main(null);
				frame.dispose();
			}
		});
		btnLogOut.setBounds(574, 15, 89, 23);
		
		frame.getContentPane().add(btnLogOut);

		
		
	}
}
