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
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ListaAuxConstancia {

	//Atributo
	JFrame frame = new JFrame();
	JLabel lblTitLista = new JLabel("Listado de Constancias");
	JLabel lblLogoUtec = new JLabel("");
	JButton btnNuevaConst = new JButton("Nueva Constancia");
	JButton btnModificar = new JButton("Modificar");
	JButton btnAtras = new JButton("Atrás");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaAuxConstancia window = new ListaAuxConstancia();
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
	public ListaAuxConstancia() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 10));
		frame.getContentPane().setBackground(Color.decode("#f9fafb"));
		frame.setBounds(100, 100, 561, 431);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		

		//Imagen
		lblLogoUtec.setIcon(new ImageIcon(AgregarITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 0, 107, 50);
		frame.getContentPane().add(lblLogoUtec);
		
		//Titulo listado de constancias
		lblTitLista.setForeground(Color.decode("#08ACEC"));
		lblTitLista.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblTitLista.setBounds(123, 10, 356, 20);
		frame.getContentPane().add(lblTitLista);
		
		// Tabla
				Object[][] datosCons = {

				};

				String[] columnasCons  = {"Constancia", "Dado de Baja"};

				JTable tablaCons = new JTable(datosCons , columnasCons );
				JScrollPane scrollPaneCons = new JScrollPane(tablaCons );
				scrollPaneCons.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
				scrollPaneCons.setBackground(Color.decode("#f3f4f6"));
				scrollPaneCons.setBounds(25, 107, 468, 203);
				frame.getContentPane().add(scrollPaneCons);
				
		
		//Botones
			//Nueva constancia
		btnNuevaConst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarConstancia.main(null);
				frame.dispose();
			}
		});
		btnNuevaConst.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNuevaConst.setForeground(Color.decode("#f0f9ff"));
		btnNuevaConst.setBackground(Color.decode("#0284c7"));
		btnNuevaConst.setBounds(377, 342, 143, 28);
		frame.getContentPane().add(btnNuevaConst);
		
			//Modificar
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarConstancia.main(null);
				frame.dispose();
			}
		});
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnModificar.setForeground(Color.decode("#f0f9ff"));
		btnModificar.setBackground(Color.decode("#0284c7"));
		btnModificar.setBounds(248, 342, 107, 28);
		frame.getContentPane().add(btnModificar);
		
			
			//Atras
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnAtras.setForeground(Color.decode("#f0f9ff"));
		btnAtras.setBackground(Color.decode("#0284c7"));
		btnAtras.setBounds(45, 342, 107, 28);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnAtras);
		
		
	
		
		JCheckBox chBoxBaja = new JCheckBox("Baja");
		chBoxBaja.setBounds(399, 64, 93, 21);
		frame.getContentPane().add(chBoxBaja);
		
		
	}

}
