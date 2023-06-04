package analista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JScrollPane;

public class ListaReclamoAnalista {

	private JFrame frame;
	private JTextField tfNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaReclamoAnalista window = new ListaReclamoAnalista();
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
	public ListaReclamoAnalista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.decode("#f9fafb")); 
		frame.setBounds(100, 100, 536, 519);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		//Titulo
		JLabel lblTitListRec = new JLabel("Lista de Reclamos");
		lblTitListRec.setForeground(Color.decode("#08ACEC"));
		lblTitListRec.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblTitListRec.setBounds(129, 10, 268, 13);
		frame.getContentPane().add(lblTitListRec);
		
		
		//Nombre
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(26, 50, 73, 19);
		lblNombre.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		frame.getContentPane().add(lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(86, 50, 356, 19);
		frame.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		
		//Estado
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(26, 96, 45, 13);
		lblEstado.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		frame.getContentPane().add(lblEstado);
		
		JComboBox cBoxEstado = new JComboBox();
		cBoxEstado.setBackground(Color.decode("#e5e7eb"));
		cBoxEstado.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		cBoxEstado.setBounds(86, 92, 98, 21);
		frame.getContentPane().add(cBoxEstado);
		
		
		//Filtro
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBackground(Color.decode("#0ea5e9"));
		btnFiltrar.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		btnFiltrar.setForeground(Color.decode("#f0f9ff"));
		btnFiltrar.setBounds(194, 92, 105, 21);
		frame.getContentPane().add(btnFiltrar);
		
		//Limpiar filtro 
		JButton btnLimpiarF = new JButton("Limpiar Filtro");
		btnLimpiarF.setBackground(Color.decode("#0ea5e9"));
		btnLimpiarF.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		btnLimpiarF.setForeground(Color.decode("#f0f9ff"));
		btnLimpiarF.setBounds(309, 92, 133, 21);
		frame.getContentPane().add(btnLimpiarF);
		
		
		//Usuario
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblUsuario.setBounds(26, 154, 45, 13);
		frame.getContentPane().add(lblUsuario);
		
		
		//Estado
		JLabel lblEstadoTit = new JLabel("Estado");
		lblEstadoTit.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblEstadoTit.setBounds(218, 154, 45, 13);
		frame.getContentPane().add(lblEstadoTit);
		
		//Scroll Usuario y Estado
		JScrollPane spUsuarioEstado = new JScrollPane();
		spUsuarioEstado.setBounds(23, 177, 256, 259);
		frame.getContentPane().add(spUsuarioEstado);
		
		//Combo modificar Estado
		JComboBox cBoxEstados = new JComboBox();
		cBoxEstados.setBounds(289, 183, 93, 21);
		cBoxEstados.setBackground(Color.decode("#e5e7eb"));
		frame.getContentPane().add(cBoxEstados);
			//Botón Guardar
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		btnGuardar.setForeground(Color.decode("#f0f9ff"));
		btnGuardar.setBackground(Color.decode("#0ea5e9"));
		btnGuardar.setBounds(409, 183, 88, 21);
		frame.getContentPane().add(btnGuardar);
			//Boton Registrar Accion
		JButton btnRegAcc = new JButton("Registrar Acción");
		btnRegAcc.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		btnRegAcc.setForeground(Color.decode("#f0f9ff"));
		btnRegAcc.setBackground(Color.decode("#0284c7"));   
		btnRegAcc.setBounds(345, 445, 152, 27);
		frame.getContentPane().add(btnRegAcc);
		
		//Imagen
		JLabel lblLogoUtec = new JLabel("");
		lblLogoUtec.setIcon(new ImageIcon(ListaAuxITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 1, 107, 50);
		frame.getContentPane().add(lblLogoUtec);
	}
}
