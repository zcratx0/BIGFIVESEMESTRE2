package analista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ListAuxCosntancia {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListAuxCosntancia window = new ListAuxCosntancia();
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
	public ListAuxCosntancia() {
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
		
		//Titulo listado de constancias
		JLabel lblTitLista = new JLabel("Listado de Constancias");
		lblTitLista.setForeground(Color.decode("#08ACEC"));
		lblTitLista.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblTitLista.setBounds(123, 10, 356, 20);
		frame.getContentPane().add(lblTitLista);
		
		
		//Panel
		JPanel panel = new JPanel();
		panel.setBounds(45, 108, 448, 209);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		//Constancia
		JLabel lblConstancia = new JLabel("Constancia");
		lblConstancia.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		lblConstancia.setBounds(10, 10, 116, 13);
		panel.add(lblConstancia);
		
		
		//Dar de baja
		JLabel lblBaja = new JLabel("Dado de Baja");
		lblBaja.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		lblBaja.setBounds(292, 10, 105, 13);
		panel.add(lblBaja);
		
		JCheckBox chBoxBaja = new JCheckBox("Baja");
		chBoxBaja.setBounds(292, 45, 93, 21);
		panel.add(chBoxBaja);
		
		//Botones
			//Nueva constancia
		JButton btnNuevaConst = new JButton("Nueva Constancia");
		btnNuevaConst.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNuevaConst.setForeground(Color.decode("#f0f9ff"));
		btnNuevaConst.setBackground(Color.decode("#0284c7"));
		btnNuevaConst.setBounds(377, 342, 143, 28);
		frame.getContentPane().add(btnNuevaConst);
		
			//Modificar
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnModificar.setForeground(Color.decode("#f0f9ff"));
		btnModificar.setBackground(Color.decode("#0284c7"));
		btnModificar.setBounds(248, 342, 107, 28);
		frame.getContentPane().add(btnModificar);
			
			//Atras
		JButton btnAtras = new JButton("Atrás");
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnAtras.setForeground(Color.decode("#f0f9ff"));
		btnAtras.setBackground(Color.decode("#0284c7"));
		btnAtras.setBounds(45, 342, 107, 28);
		frame.getContentPane().add(btnAtras);
		
		
	}

}
