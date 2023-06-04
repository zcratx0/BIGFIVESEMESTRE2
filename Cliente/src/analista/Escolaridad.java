package analista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;

public class Escolaridad {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Escolaridad window = new Escolaridad();
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
	public Escolaridad() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.decode("#f9fafb"));  
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Titulo Escolariad
		JLabel lblEsco = new JLabel("Escolaridad");
		lblEsco.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblEsco.setForeground(Color.decode("#08ACEC")); 
		lblEsco.setBounds(145, 24, 152, 13);
		frame.getContentPane().add(lblEsco);
		
		
		//Boton
			//Descargar
		JButton btnDes = new JButton("Descargar");
		btnDes.setBackground(Color.decode("#0284c7"));   
		btnDes.setFont(new Font("Tahona", Font.BOLD, 10));
		btnDes.setForeground(Color.decode("#f0f9ff"));
		btnDes.setBounds(66, 202, 100, 39);
		frame.getContentPane().add(btnDes);
		
			//Imprimir
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.setBackground(Color.decode("#0284c7")); 
		btnImprimir.setFont(new Font("Tahona", Font.BOLD, 10));
		btnImprimir.setForeground(Color.decode("#f0f9ff"));
		btnImprimir.setBounds(241, 202, 100, 39);
		frame.getContentPane().add(btnImprimir);
		
		// Imagen
		JLabel lblLogoUtec = new JLabel("");
		lblLogoUtec.setIcon(new ImageIcon(ListaAuxITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 1, 107, 50);
		frame.getContentPane().add(lblLogoUtec);
	}
}
