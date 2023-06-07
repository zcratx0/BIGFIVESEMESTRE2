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

import analista.ListaAuxITR;
import analista.ListaEscolaridad;

public class EscolaridadTut {

	// Atributo
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
					EscolaridadTut window = new EscolaridadTut();
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
	public EscolaridadTut() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.getContentPane().setBackground(Color.decode("#f9fafb"));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// Titulo Escolariad
		lblEsco.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblEsco.setForeground(Color.decode("#08ACEC"));
		lblEsco.setBounds(145, 24, 152, 13);
		frame.getContentPane().add(lblEsco);

		// Boton
		// Descargar
		btnDes.setBackground(Color.decode("#0284c7"));
		btnDes.setFont(new Font("Tahona", Font.BOLD, 10));
		btnDes.setForeground(Color.decode("#f0f9ff"));
		btnDes.setBounds(197, 230, 100, 23);
		frame.getContentPane().add(btnDes);

		// Imprimir
		btnImprimir.setBackground(Color.decode("#0284c7"));
		btnImprimir.setFont(new Font("Tahona", Font.BOLD, 10));
		btnImprimir.setForeground(Color.decode("#f0f9ff"));
		btnImprimir.setBounds(309, 230, 100, 23);
		frame.getContentPane().add(btnImprimir);

		// Atras
		btnAtras.setBackground(Color.decode("#0284c7"));
		btnAtras.setFont(new Font("Tahona", Font.BOLD, 10));
		btnAtras.setForeground(Color.decode("#f0f9ff"));
		btnAtras.setBounds(10, 230, 100, 23);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaEscolaridadTut.main(null);
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

