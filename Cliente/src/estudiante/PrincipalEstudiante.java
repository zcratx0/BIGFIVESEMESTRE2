package estudiante;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.bigfive.entities.Estudiante;
import com.bigfive.entities.Usuario;

import analista.AgregarITR;
import analista.PerfilAnalista;
import analista.PrincipalAnalista;
import funcionalidades.DAODepartamento;
import funcionalidades.DAOITR;
import funcionalidades.DAOReclamo;
import logIn.LogIn;
import utils.TBFTable;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipalEstudiante {

	//Atributos
	JFrame frame = new JFrame();
	JButton btnConstancia = new JButton("Constancias");
	JLabel lblLogoUtec = new JLabel("");
	JButton btnPerfil = new JButton("Perfil");
	JButton btnEscolaridad = new JButton("Escolaridad");
	JButton btnReclamos = new JButton("Reclamos");
	JLabel lblPerfil = new JLabel("");
	private final JLabel lblNomUsuario = new JLabel("");
	private final JLabel lblTitEstudiante = new JLabel("Estudiante");
	private final JButton btnLogOut = new JButton("LogOut");
	private Estudiante usuarioEstudiante= null;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalEstudiante window = new PrincipalEstudiante();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void mostrarEstudiante(Estudiante estudiante) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalEstudiante window = new PrincipalEstudiante();
					//definimos el usuario con la variable usuario 
					window.usuarioEstudiante = estudiante;
					if(estudiante != null) {
						if(estudiante.getUsuario() !=null) {
							if(estudiante.getUsuario().getMailInstitucional() != null) {
								window.lblNomUsuario.setText(estudiante.getUsuario().getMailInstitucional().split("@")[0]);
							}
						}
					}
					window.lblNomUsuario.setText(estudiante.getUsuario().getMailInstitucional().split("@")[0]);
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
	public PrincipalEstudiante() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame.setBounds(100, 100, 667, 469);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.decode("#f9fafb"));
		frame.setResizable(false);

		// Imagen
		
		lblLogoUtec.setIcon(new ImageIcon(AgregarITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 0, 50, 50);
		frame.getContentPane().add(lblLogoUtec);

		// Imagen Perfil

		lblPerfil.setIcon(new ImageIcon(AgregarITR.class.getResource("/img/Perfil.png")));
		lblPerfil.setBounds(414, 0, 56, 50);
		frame.getContentPane().add(lblPerfil);
		
		//Titulo Estudiante
		lblTitEstudiante.setBounds(76, 14, 180, 28);
		lblTitEstudiante.setForeground(Color.decode("#08ACEC"));
		lblTitEstudiante.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		frame.getContentPane().add(lblTitEstudiante);
		
		//Nombre de usuario
		lblNomUsuario.setBounds(456, 22, 187, 13);
		frame.getContentPane().add(lblNomUsuario);

		//Botones
			//Perfil
		btnPerfil.setFont(new Font("Tahona", Font.BOLD, 10));
		btnPerfil.setForeground(Color.decode("#f0f9ff"));
		btnPerfil.setBackground(Color.decode("#3b82f6"));
		btnPerfil.setBounds(80, 65, 107, 40);
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (usuarioEstudiante != null) PerfilEstudiantes.mostrarPerfilEstudiante(usuarioEstudiante);
				else {PerfilEstudiantes.main(null);}
			}
		});
		frame.getContentPane().add(btnPerfil);
		
			//Escolaridad
		btnEscolaridad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DescargarEscolaridad.main(usuarioEstudiante);
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
				ListaReclamoEstu.main(usuarioEstudiante);
			}
		});
		frame.getContentPane().add(btnReclamos);
		
			//Constancias
		btnConstancia.setFont(new Font("Tahona", Font.BOLD, 10));
		btnConstancia.setForeground(Color.decode("#f0f9ff"));
		btnConstancia.setBackground(Color.decode("#3b82f6"));
		btnConstancia.setBounds(500, 65, 107, 40);
		btnConstancia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaConstancias.main(null);
			}
		});
		frame.getContentPane().add(btnConstancia);
		//TODO logout
		
		btnLogOut.setFont(new Font("Tahona", Font.BOLD, 10)); 
		btnLogOut.setForeground(Color.decode("#f0f9ff"));    
		btnLogOut.setBackground(Color.decode("#0369a1"));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogIn.main(null);
				frame.dispose();
			}
		});
		btnLogOut.setBounds(300, 15, 89, 23);
		
		frame.getContentPane().add(btnLogOut);
		
	}
	
	
	
}
