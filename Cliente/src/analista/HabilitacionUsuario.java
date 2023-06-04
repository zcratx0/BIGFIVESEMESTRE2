package analista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class HabilitacionUsuario {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HabilitacionUsuario window = new HabilitacionUsuario();
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
	public HabilitacionUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.decode("#f9fafb"));
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 753, 423);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		// Imagen
		JLabel lblLogoUtec = new JLabel("");
		lblLogoUtec.setIcon(new ImageIcon(AgregarITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 0, 107, 50);
		frame.getContentPane().add(lblLogoUtec);
		
		
		//Titulo Habilitación de Usuarios
		JLabel lblTitHabUsu = new JLabel("Habilitación de Usuarios");
		lblTitHabUsu.setForeground(Color.decode("#08ACEC"));
		lblTitHabUsu.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblTitHabUsu.setBounds(201, 10, 411, 29);
		frame.getContentPane().add(lblTitHabUsu);
		
		
		//Tipo de Usuarios 
		JLabel lblTipoUsu = new JLabel("Tipo de Usuario");
		lblTipoUsu.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblTipoUsu.setBounds(43, 73, 139, 20);
		frame.getContentPane().add(lblTipoUsu);
		
		
		//ITR
		JLabel lblItr = new JLabel("ITR");
		lblItr.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblItr.setBounds(218, 77, 45, 13);
		frame.getContentPane().add(lblItr);
		
		
		//Generación
		JLabel lblGeneracion = new JLabel("Generación");
		lblGeneracion.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblGeneracion.setBounds(322, 75, 89, 16);
		frame.getContentPane().add(lblGeneracion);
		
		//Estado
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblEstado.setBounds(472, 77, 107, 13);
		frame.getContentPane().add(lblEstado);
		
		//Información
		JLabel lblInformacion = new JLabel("Información");
		lblInformacion.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblInformacion.setBounds(589, 77, 97, 13);
		frame.getContentPane().add(lblInformacion);
		
		JLabel lblVerMas = new JLabel("Ver Más");
		lblVerMas.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblVerMas.setBounds(554, 10, 65, 13);
		frame.getContentPane().add(lblVerMas);
		
		//El panel
		JPanel panel = new JPanel();
		panel.setBounds(43, 119, 654, 161);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		//Botones
			//Atras
		JButton btnAtras = new JButton("Atrás");
		btnAtras.setFont(new Font("Tahona", Font.BOLD, 10));
		btnAtras.setForeground(Color.decode("#f0f9ff"));
		btnAtras.setBackground(Color.decode("#0284c7"));
		btnAtras.setBounds(406, 333, 89, 29);
		frame.getContentPane().add(btnAtras);
			//Cancelar
		JButton btnListUsu = new JButton("Lista de Usuarios");
		btnListUsu.setFont(new Font("Tahona", Font.BOLD, 10));
		btnListUsu.setForeground(Color.decode("#f0f9ff"));
		btnListUsu.setBackground(Color.decode("#0284c7"));
		btnListUsu.setBounds(547, 333, 139, 29);
		frame.getContentPane().add(btnListUsu);
	}
}
