package analista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaAuxEstados {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaAuxEstados window = new ListaAuxEstados();
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
	public ListaAuxEstados() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 10));
		frame.getContentPane().setBackground(Color.decode("#f9fafb"));
		frame.setBounds(100, 100, 561, 431);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		

		//Imagen
		JLabel lblLogoUtec = new JLabel("");
		lblLogoUtec.setIcon(new ImageIcon(AgregarITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 0, 107, 50);
		frame.getContentPane().add(lblLogoUtec);
		
		//Titulo listado de r,c y j
		JLabel lblTitLista = new JLabel("Listado de Estados de reclamos,");
		lblTitLista.setForeground(Color.decode("#08ACEC"));
		lblTitLista.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblTitLista.setBounds(123, 10, 356, 20);
		frame.getContentPane().add(lblTitLista);
		
		JLabel lblTitLista2 = new JLabel(" constancias y justificaciones ");
		lblTitLista2.setForeground(Color.decode("#08ACEC"));
		lblTitLista2.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblTitLista2.setBounds(123, 40, 326, 20);
		frame.getContentPane().add(lblTitLista2);
		
		
		//Panel
		JPanel panel = new JPanel();
		panel.setBounds(45, 108, 448, 209);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		//Estado
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		lblEstado.setBounds(10, 10, 116, 13);
		panel.add(lblEstado);
		
		
		//Dar de baja
		JLabel lblBaja = new JLabel("Dado de Baja");
		lblBaja.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		lblBaja.setBounds(292, 10, 105, 13);
		panel.add(lblBaja);
		
		JCheckBox chBoxBaja = new JCheckBox("Baja");
		chBoxBaja.setBounds(292, 45, 93, 21);
		panel.add(chBoxBaja);
		
		//Botones
			//Nuevo estado
		JButton btnNuevoEst = new JButton("Nuevo estado");
		btnNuevoEst.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNuevoEst.setForeground(Color.decode("#f0f9ff"));
		btnNuevoEst.setBackground(Color.decode("#0284c7"));
		btnNuevoEst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNuevoEst.setBounds(371, 342, 122, 28);
		frame.getContentPane().add(btnNuevoEst);
			
			//Atras
		JButton btnAtras = new JButton("Atrás");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnAtras.setForeground(Color.decode("#f0f9ff"));
		btnAtras.setBackground(Color.decode("#0284c7"));
		btnAtras.setBounds(241, 342, 107, 28);
		frame.getContentPane().add(btnAtras);
		
	}
}
