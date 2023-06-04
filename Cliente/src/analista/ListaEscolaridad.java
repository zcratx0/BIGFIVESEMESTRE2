package analista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ListaEscolaridad {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaEscolaridad window = new ListaEscolaridad();
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
	public ListaEscolaridad() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.decode("#f9fafb"));  
		frame.setBounds(100, 100, 506, 326);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		//Titulo Escolaridad de estudiante
		JLabel lblEscPorEst = new JLabel("Escolaridad de estudiantes");
		lblEscPorEst.setForeground(Color.decode("#08ACEC"));
		lblEscPorEst.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblEscPorEst.setBounds(115, 23, 322, 22);
		frame.getContentPane().add(lblEscPorEst);
		
		//Nombre
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblNombre.setBounds(10, 68, 45, 13);
		frame.getContentPane().add(lblNombre);
		
		//Apellido
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblApellido.setBounds(152, 68, 45, 13);
		frame.getContentPane().add(lblApellido);
		
		//Ceduka
		JLabel lblCI = new JLabel("Cédula");
		lblCI.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblCI.setBounds(306, 68, 45, 13);
		frame.getContentPane().add(lblCI);
		
		//Botones
			//Mostrar Escolaridad
		JButton btnMostrarEsc = new JButton("Mostrar Escolaridad");
		btnMostrarEsc.setFont(new Font("Tahona", Font.BOLD, 10));
		btnMostrarEsc.setForeground(Color.decode("#f0f9ff"));
		btnMostrarEsc.setBackground(Color.decode("#0284c7"));    
		btnMostrarEsc.setBounds(337, 247, 145, 32);
		frame.getContentPane().add(btnMostrarEsc);
		
			//Atras
		JButton btnAtras = new JButton("Atrás");
		btnAtras.setFont(new Font("Tahona", Font.BOLD, 10));
		btnAtras.setForeground(Color.decode("#f0f9ff"));
		btnAtras.setBackground(Color.decode("#0284c7"));    
		btnAtras.setBounds(226, 247, 96, 32);
		frame.getContentPane().add(btnAtras);
		
		
		// Imagen
		JLabel lblLogoUtec = new JLabel("");
		lblLogoUtec.setIcon(new ImageIcon(ListaAuxITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 1, 107, 50);
		frame.getContentPane().add(lblLogoUtec);
		
		
	}

}
