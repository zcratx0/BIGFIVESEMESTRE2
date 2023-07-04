package tutor;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.bigfive.entities.Estudiante;
import com.bigfive.entities.Tutor;

import analista.AgregarITR;
import estudiante.PrincipalEstudiante;

public class PrincipalTutor {

	//Atributos
		JFrame frame = new JFrame();
		JButton btnConstancia = new JButton("Constancias");
		JLabel lblLogoUtec = new JLabel("");
		JLabel lblPerfil = new JLabel("");
		JButton btnPerfil = new JButton("Perfil");
		JButton btnEscolaridad = new JButton("Escolaridad");
		JButton btnReclamos = new JButton("Reclamos");
		private final JLabel lblNombreUsuario = new JLabel("");
		private final JLabel lblTitTutor = new JLabel("Tutor");
		private Tutor usuarioTutor = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalTutor window = new PrincipalTutor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void mostrarTutor(Tutor tutor) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalTutor window = new PrincipalTutor();
					//definimos el usuario con la variable usuario 
					window.usuarioTutor = tutor;
					if(tutor != null) {
						if(tutor.getUsuario() != null) {
							if(tutor.getUsuario().getMailInstitucional() != null) {
								window.lblNombreUsuario.setText(tutor.getUsuario().getMailInstitucional().split("@")[0]);
							}
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
	public PrincipalTutor() {
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

		// Imagen Logo
		
		lblLogoUtec.setIcon(new ImageIcon(AgregarITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 0, 45, 50);
		frame.getContentPane().add(lblLogoUtec);
		
		// Imagen Perfil

		lblPerfil.setIcon(new ImageIcon(AgregarITR.class.getResource("/img/Perfil.png")));
		lblPerfil.setBounds(413, 0, 56, 50);
		frame.getContentPane().add(lblPerfil);

		// Titulo Tutor
		lblTitTutor.setBounds(80, 13, 167, 28);
		lblTitTutor.setForeground(Color.decode("#08ACEC"));
		lblTitTutor.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		frame.getContentPane().add(lblTitTutor);
		
		
		// Nombre Usuario
		lblNombreUsuario.setBounds(460, 20, 183, 15);
		lblNombreUsuario.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		frame.getContentPane().add(lblNombreUsuario);


		// Botones
			//Perfil
		btnPerfil.setFont(new Font("Tahona", Font.BOLD, 10));
		btnPerfil.setForeground(Color.decode("#f0f9ff"));
		btnPerfil.setBackground(Color.decode("#3b82f6"));
		btnPerfil.setBounds(76, 65, 107, 40);
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (usuarioTutor != null) PerfilTutor.mostrarPerfilTutor(usuarioTutor);
				else {PerfilTutor.main(null);}
				//frame.dispose();
			}
		});
		frame.getContentPane().add(btnPerfil);
		
			//Escolaridad
		btnEscolaridad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaEscolaridadTut.main(null);
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
				MantenimientoTutor.main(null);
				frame.dispose();
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
				MantenimientoTutor.main(null);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnConstancia);
		

	}
}
