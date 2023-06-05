package analista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import analista.RegistroAccConstancias;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ListaSoliConstancias {

	private JFrame frame;
	private JTextField tfNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaSoliConstancias window = new ListaSoliConstancias();
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
	public ListaSoliConstancias() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.decode("#f9fafb"));
		frame.setBounds(100, 100, 531, 572);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		
		//Titulo
		JLabel lblTitSoliConst = new JLabel("Solicitudes de Constancias");
		lblTitSoliConst.setForeground(Color.decode("#08ACEC")); 
		lblTitSoliConst.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblTitSoliConst.setBounds(111, 23, 354, 21);
		frame.getContentPane().add(lblTitSoliConst);
		
		//Nombre
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblNombre.setBounds(34, 85, 45, 13);
		frame.getContentPane().add(lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(114, 82, 322, 19);
		frame.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		//Estado
		JLabel lblEstadoFil = new JLabel("Estado");
		lblEstadoFil.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblEstadoFil.setBounds(34, 131, 45, 13);
		frame.getContentPane().add(lblEstadoFil);
		
		JComboBox cBoxEstado = new JComboBox();
		cBoxEstado.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		cBoxEstado.setBackground(Color.decode("#e5e7eb"));
		cBoxEstado.setBounds(114, 127, 102, 21);
		frame.getContentPane().add(cBoxEstado);
		
		//Filtros
			//Filtrar
		JButton btnFiltro = new JButton("Filtrar");
		btnFiltro.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		btnFiltro.setBackground(Color.decode("#0ea5e9"));
		btnFiltro.setForeground(Color.decode("#f0f9ff"));
		btnFiltro.setBounds(226, 127, 85, 21);
		frame.getContentPane().add(btnFiltro);
			//Limpiar Filtro
		JButton btnLimpiarF = new JButton("Limpiar Filtro");
		btnLimpiarF.setBackground(Color.decode("#0ea5e9"));
		btnLimpiarF.setForeground(Color.decode("#f0f9ff"));
		btnLimpiarF.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		btnLimpiarF.setBounds(321, 127, 115, 21);
		frame.getContentPane().add(btnLimpiarF);

		//Tabla 
		Object[][] datosCO = {
			   
			};
		
		String[] columnasCO = {"Usuario", "Fecha", "Estado"};
		
		JTable tablaCO = new JTable(datosCO, columnasCO);
		JScrollPane scrollPaneCO = new JScrollPane(tablaCO);
		scrollPaneCO.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		scrollPaneCO.setBounds(25, 202, 482, 248);
		frame.getContentPane().add(scrollPaneCO);
			//Dar de Baja
		JButton btnBaja = new JButton("Dar de Baja");
		btnBaja.setBackground(Color.decode("#0284c7"));  
		btnBaja.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		btnBaja.setForeground(Color.decode("#f0f9ff"));
		btnBaja.setBounds(131, 485, 112, 21);
		frame.getContentPane().add(btnBaja);
			//Registrar acciones
		JButton btnRegAcc = new JButton("Registrar Acciones");
		btnRegAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroAccConstancias.main(null);
			}
		});
		btnRegAcc.setBackground(Color.decode("#0284c7")); 
		btnRegAcc.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		btnRegAcc.setForeground(Color.decode("#f0f9ff"));
		btnRegAcc.setBounds(321, 485, 144, 21);
		frame.getContentPane().add(btnRegAcc);
		
		// Imagen
		JLabel lblLogoUtec = new JLabel("");
		lblLogoUtec.setIcon(new ImageIcon(ListaAuxITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 1, 107, 50);
		frame.getContentPane().add(lblLogoUtec);
		
	}
}
