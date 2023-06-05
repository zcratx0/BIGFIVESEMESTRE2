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

import estudiante.DescargarEscolaridad;
import estudiante.ListaConstancias;
import estudiante.ListaReclamoEstu;
import estudiante.PerfilEstudiantes;
import estudiante.PrincipalEstudiante;

public class PrincipalAnalista {//Atributos
	JFrame frame = new JFrame();
	JButton btnConstancia = new JButton("Constancias");
	JLabel lblLogoUtec = new JLabel("");
	JButton btnPerfil = new JButton("Perfil");
	JButton btnEscolaridad = new JButton("Escolaridad");
	JButton btnReclamos = new JButton("Reclamos");
	JButton btnMantenimiento = new JButton("Mantenimiento");
	JButton btnUsuarios = new JButton("Usuarios");
	
	

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
		
		frame.setBounds(100, 100, 952, 469);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.decode("#f9fafb"));
		frame.setResizable(false);

		// Imagen
		
		lblLogoUtec.setIcon(new ImageIcon(AgregarITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 0, 107, 50);
		frame.getContentPane().add(lblLogoUtec);
		

			//Perfil
		btnPerfil.setFont(new Font("Tahona", Font.BOLD, 10));
		btnPerfil.setForeground(Color.decode("#f0f9ff"));
		btnPerfil.setBackground(Color.decode("#3b82f6"));
		btnPerfil.setBounds(80, 10, 107, 40);
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PerfilAnalista.main(null);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnPerfil);
		
			//Escolaridad
		btnEscolaridad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaEscolaridad.main(null);
				frame.dispose();
			}
		});
		btnEscolaridad.setFont(new Font("Tahona", Font.BOLD, 10));
		btnEscolaridad.setForeground(Color.decode("#f0f9ff"));
		btnEscolaridad.setBackground(Color.decode("#3b82f6"));
		btnEscolaridad.setBounds(220, 10, 107, 40);
		frame.getContentPane().add(btnEscolaridad);
		
			//Reclamos
		btnReclamos.setFont(new Font("Tahona", Font.BOLD, 10));
		btnReclamos.setForeground(Color.decode("#f0f9ff"));
		btnReclamos.setBackground(Color.decode("#3b82f6"));
		btnReclamos.setBounds(360, 10, 107, 40);
		btnReclamos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaReclamo.main(null);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnReclamos);
		
			//Constancias
		btnConstancia.setFont(new Font("Tahona", Font.BOLD, 10));
		btnConstancia.setForeground(Color.decode("#f0f9ff"));
		btnConstancia.setBackground(Color.decode("#3b82f6"));
		btnConstancia.setBounds(640, 10, 107, 40);
		frame.getContentPane().add(btnConstancia);
		btnConstancia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaSoliConstancias.main(null);
				frame.dispose();
			}
		});
		
		// mantenimientos
		
		btnMantenimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMantenimiento.setFont(new Font("Tahona", Font.BOLD, 10));
		btnMantenimiento.setForeground(Color.decode("#f0f9ff"));
		btnMantenimiento.setBackground(Color.decode("#3b82f6"));
		btnMantenimiento.setBounds(500, 10, 107, 40);
		
		frame.getContentPane().add(btnMantenimiento);
		
		// usuarios 
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HabilitacionUsuario.main(null);
				frame.dispose();
			}
		});
		btnUsuarios.setFont(new Font("Tahona", Font.BOLD, 10));
		btnUsuarios.setForeground(Color.decode("#f0f9ff"));
		btnUsuarios.setBackground(Color.decode("#3b82f6"));
		btnUsuarios.setBounds(780, 10, 107, 40);
		
		frame.getContentPane().add(btnUsuarios);
		
		
	}

}
