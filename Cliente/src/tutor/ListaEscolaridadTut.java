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
import javax.swing.JScrollPane;
import javax.swing.JTable;

import analista.Escolaridad;
import analista.ListaAuxITR;
import analista.PrincipalAnalista;

public class ListaEscolaridadTut {

	// Atributos
	JFrame frame = new JFrame();
	JLabel lblEscPorEst = new JLabel("Escolaridad de estudiantes");
	JButton btnMostrarEsc = new JButton("Mostrar Escolaridad");
	JButton btnAtras = new JButton("Atrás");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaEscolaridadTut window = new ListaEscolaridadTut();
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
	public ListaEscolaridadTut() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.getContentPane().setBackground(Color.decode("#f9fafb"));
		frame.setBounds(100, 100, 517, 530);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		// Titulo Escolaridad de estudiante
		lblEscPorEst.setForeground(Color.decode("#08ACEC"));
		lblEscPorEst.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblEscPorEst.setBounds(115, 23, 322, 22);
		frame.getContentPane().add(lblEscPorEst);

		// Tabla
		Object[][] datosEsc = {

		};

		String[] columnasEsc = { "Nombre", "Apellido", "Cédula" };

		JTable tablaEsc = new JTable(datosEsc, columnasEsc);
		JScrollPane scrollPaneEsc = new JScrollPane(tablaEsc);
		scrollPaneEsc.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		scrollPaneEsc.setBackground(Color.decode("#f3f4f6"));
		scrollPaneEsc.setBounds(35, 69, 419, 345);
		frame.getContentPane().add(scrollPaneEsc);

		// Botones
		// Mostrar Escolaridad
		btnMostrarEsc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EscolaridadTut.main(null);
				frame.dispose();
			}
		});
		btnMostrarEsc.setFont(new Font("Tahona", Font.BOLD, 10));
		btnMostrarEsc.setForeground(Color.decode("#f0f9ff"));
		btnMostrarEsc.setBackground(Color.decode("#0284c7"));
		btnMostrarEsc.setBounds(309, 451, 145, 32);
		frame.getContentPane().add(btnMostrarEsc);

		// Atras
		btnAtras.setFont(new Font("Tahona", Font.BOLD, 10));
		btnAtras.setForeground(Color.decode("#f0f9ff"));
		btnAtras.setBackground(Color.decode("#0284c7"));
		btnAtras.setBounds(193, 451, 96, 32);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PrincipalTutor.main(null);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnAtras);

		// Imagen
		JLabel lblLogoUtec = new JLabel("");
		lblLogoUtec.setIcon(new ImageIcon(ListaAuxITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 1, 107, 50);
		frame.getContentPane().add(lblLogoUtec);

	}
}
