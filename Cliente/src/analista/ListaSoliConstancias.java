package analista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ListaSoliConstancias {

	//Atributos
	JFrame frame = new JFrame();
	JLabel lblTitSoliConst = new JLabel("Solicitudes de Constancias");
	JTextField tfNombre = new JTextField();
	JLabel lblNombre = new JLabel("Nombre");
	JLabel lblEstadoFil = new JLabel("Estado");
	JComboBox cBoxEstado = new JComboBox();
	JButton btnFiltro = new JButton("Filtrar");
	JButton btnLimpiarF = new JButton("Limpiar Filtro");
	JButton btnBaja = new JButton("Dar de Baja");
	JButton btnRegAcc = new JButton("Registrar Acciones");
	JButton btnAtras = new JButton("Atrás");

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
		frame.getContentPane().setBackground(Color.decode("#f9fafb"));
		frame.setBounds(100, 100, 531, 572);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		
		//Titulo
		lblTitSoliConst.setForeground(Color.decode("#08ACEC")); 
		lblTitSoliConst.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblTitSoliConst.setBounds(111, 23, 354, 21);
		frame.getContentPane().add(lblTitSoliConst);
		
		//Nombre
		lblNombre.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblNombre.setBounds(34, 85, 45, 13);
		frame.getContentPane().add(lblNombre);
		
	
		tfNombre.setBounds(114, 82, 322, 19);
		frame.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		//Estado
		lblEstadoFil.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblEstadoFil.setBounds(34, 131, 45, 13);
		frame.getContentPane().add(lblEstadoFil);
		
	
		cBoxEstado.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		cBoxEstado.setBackground(Color.decode("#e5e7eb"));
		cBoxEstado.setBounds(114, 127, 102, 21);
		frame.getContentPane().add(cBoxEstado);
		
		//Filtros
			//Filtrar
		btnFiltro.setFont(new Font("Tahona", Font.BOLD, 10));
		btnFiltro.setBackground(Color.decode("#0ea5e9"));
		btnFiltro.setForeground(Color.decode("#f0f9ff"));
		btnFiltro.setBounds(226, 127, 85, 21);
		frame.getContentPane().add(btnFiltro);
			//Limpiar Filtro
		btnLimpiarF.setBackground(Color.decode("#0ea5e9"));
		btnLimpiarF.setForeground(Color.decode("#f0f9ff"));
		btnLimpiarF.setFont(new Font("Tahona", Font.BOLD, 10));
		btnLimpiarF.setBounds(321, 127, 115, 21);
		frame.getContentPane().add(btnLimpiarF);

		// Tabla
		Object[][] datosSoliCons = {

		};

		String[] columnasSC = { "Usuario", "Fecha", "Estado" };

		JTable tablaSC = new JTable(datosSoliCons, columnasSC);
		JScrollPane scrollPaneSC = new JScrollPane(tablaSC);
		scrollPaneSC.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		scrollPaneSC.setBackground(Color.decode("#f3f4f6"));
		scrollPaneSC.setBounds(25, 195, 464, 255);
		frame.getContentPane().add(scrollPaneSC);

		// Dar de Baja
		btnBaja.setBackground(Color.decode("#0284c7"));  
		btnBaja.setFont(new Font("Tahona", Font.BOLD, 10));
		btnBaja.setForeground(Color.decode("#f0f9ff"));
		btnBaja.setBounds(25, 485, 112, 21);
		frame.getContentPane().add(btnBaja);
			//Registrar acciones
		btnRegAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroAccConstancias.main(null);
				frame.dispose();
			}
		});
		btnRegAcc.setBackground(Color.decode("#0284c7")); 
		btnRegAcc.setFont(new Font("Tahona", Font.BOLD, 10));
		btnRegAcc.setForeground(Color.decode("#f0f9ff"));
		btnRegAcc.setBounds(345, 485, 144, 21);
		frame.getContentPane().add(btnRegAcc);
		
			//Atras
		btnAtras.setBackground(Color.decode("#0284c7"));  
		btnAtras.setFont(new Font("Tahona", Font.BOLD, 10));
		btnAtras.setForeground(Color.decode("#f0f9ff"));
		btnAtras.setBounds(239, 485, 85, 21);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
