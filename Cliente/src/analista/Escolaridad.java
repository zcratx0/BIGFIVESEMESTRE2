package analista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Escolaridad {
	
	//Atributo
	JFrame frame = new JFrame();
	JLabel lblEsco = new JLabel("Escolaridad");
	JButton btnDes = new JButton("Descargar");
	JButton btnImprimir = new JButton("Imprimir");
	JButton btnAtras = new JButton("Atrás");
	JLabel lblLogoUtec = new JLabel("");

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
		frame.getContentPane().setBackground(Color.decode("#f9fafb"));  
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Titulo Escolariad
		lblEsco.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblEsco.setForeground(Color.decode("#08ACEC")); 
		lblEsco.setBounds(145, 24, 152, 13);
		frame.getContentPane().add(lblEsco);
		
		
		
		//Boton
			//Descargar
		btnDes.setBackground(Color.decode("#0284c7"));   
		btnDes.setFont(new Font("Tahona", Font.BOLD, 10));
		btnDes.setForeground(Color.decode("#f0f9ff"));
		btnDes.setBounds(197, 230, 100, 23);
		btnDes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MantenimientoAnalista.main(null);
			}
		});
		frame.getContentPane().add(btnDes);
		
			//Imprimir
		btnImprimir.setBackground(Color.decode("#0284c7")); 
		btnImprimir.setFont(new Font("Tahona", Font.BOLD, 10));
		btnImprimir.setForeground(Color.decode("#f0f9ff"));
		btnImprimir.setBounds(309, 230, 100, 23);
		frame.getContentPane().add(btnImprimir);
		
		
			//Atras
		btnAtras.setBackground(Color.decode("#0284c7")); 
		btnAtras.setFont(new Font("Tahona", Font.BOLD, 10));
		btnAtras.setForeground(Color.decode("#f0f9ff"));
		btnAtras.setBounds(10, 230, 100, 23);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaEscolaridad.main(null);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnAtras);
		
		// Imagen
		lblLogoUtec.setIcon(new ImageIcon(ListaAuxITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 1, 107, 50);
		frame.getContentPane().add(lblLogoUtec);
		
		
	}
}
