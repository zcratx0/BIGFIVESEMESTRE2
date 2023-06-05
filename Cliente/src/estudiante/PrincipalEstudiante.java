package estudiante;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import analista.AgregarITR;
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
		lblLogoUtec.setBounds(25, 0, 107, 50);
		frame.getContentPane().add(lblLogoUtec);
		
		//Botones
			//Perfil
		btnPerfil.setFont(new Font("Tahona", Font.BOLD, 10));
		btnPerfil.setForeground(Color.decode("#f0f9ff"));
		btnPerfil.setBackground(Color.decode("#3b82f6"));
		btnPerfil.setBounds(80, 10, 107, 40);
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PerfilEstudiantes.main(null);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnPerfil);
		
			//Escolaridad
		btnEscolaridad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DescargarEscolaridad.main(null);
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
				ListaReclamoEstu.main(null);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnReclamos);
		
			//Constancias
		btnConstancia.setFont(new Font("Tahona", Font.BOLD, 10));
		btnConstancia.setForeground(Color.decode("#f0f9ff"));
		btnConstancia.setBackground(Color.decode("#3b82f6"));
		btnConstancia.setBounds(500, 10, 107, 40);
		btnConstancia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaConstancias.main(null);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnConstancia);
	}

}
