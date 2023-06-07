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
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaReclamo {

	//Atributos
	JFrame frame = new JFrame();
	JLabel lblTitListRec = new JLabel("Lista de Reclamos");
	JLabel lblNombre = new JLabel("Nombre");
	JTextField tfNombre = new JTextField();
	JLabel lblEstado = new JLabel("Estado");
	JComboBox cBoxEstado = new JComboBox();
	JButton btnFiltrar = new JButton("Filtrar");
	JButton btnLimpiarF = new JButton("Limpiar Filtro");
	JButton btnRegAcc = new JButton("Registrar Acción");
	JButton btnAtras = new JButton("Atrás");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaReclamo window = new ListaReclamo();
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
	public ListaReclamo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.getContentPane().setBackground(Color.decode("#f9fafb")); 
		frame.setBounds(100, 100, 536, 519);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		//Titulo
		lblTitListRec.setForeground(Color.decode("#08ACEC"));
		lblTitListRec.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblTitListRec.setBounds(129, 10, 268, 13);
		frame.getContentPane().add(lblTitListRec);
		
		
		//Nombre
		lblNombre.setBounds(26, 50, 73, 19);
		lblNombre.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		frame.getContentPane().add(lblNombre);
		
		
		tfNombre.setBounds(86, 50, 356, 19);
		frame.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		
		//Estado
		lblEstado.setBounds(26, 96, 45, 13);
		lblEstado.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		frame.getContentPane().add(lblEstado);
		
		
		cBoxEstado.setBackground(Color.decode("#e5e7eb"));
		cBoxEstado.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		cBoxEstado.setBounds(86, 92, 98, 21);
		frame.getContentPane().add(cBoxEstado);
		
		
		//Filtro
		btnFiltrar.setBackground(Color.decode("#0ea5e9"));
		btnFiltrar.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		btnFiltrar.setForeground(Color.decode("#f0f9ff"));
		btnFiltrar.setBounds(194, 92, 105, 21);
		frame.getContentPane().add(btnFiltrar);
		
		//Limpiar filtro 
		btnLimpiarF.setBackground(Color.decode("#0ea5e9"));
		btnLimpiarF.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		btnLimpiarF.setForeground(Color.decode("#f0f9ff"));
		btnLimpiarF.setBounds(309, 92, 133, 21);
		frame.getContentPane().add(btnLimpiarF);
		
		// Tabla
				Object[][] datosReclamo = {

				};

				String[] columnasRe = { "Usuario", "Estado"};

				JTable tablaRe = new JTable(datosReclamo, columnasRe);
				JScrollPane scrollPaneRe = new JScrollPane(tablaRe);
				scrollPaneRe.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
				scrollPaneRe.setBackground(Color.decode("#f3f4f6"));
				scrollPaneRe.setBounds(26, 157, 482, 255);
				frame.getContentPane().add(scrollPaneRe);
			
		//Botones
				//Registrar Accion
		btnRegAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroAccReclamo.main(null);
				frame.dispose();
			}
		});
		btnRegAcc.setFont(new Font("Tahona", Font.BOLD, 10));
		btnRegAcc.setForeground(Color.decode("#f0f9ff"));
		btnRegAcc.setBackground(Color.decode("#0284c7"));   
		btnRegAcc.setBounds(345, 445, 152, 27);
		frame.getContentPane().add(btnRegAcc);
		
				//Atras
		btnAtras.setFont(new Font("Tahona", Font.BOLD, 10));
		btnAtras.setForeground(Color.decode("#f0f9ff"));
		btnAtras.setBackground(Color.decode("#0284c7"));   
		btnAtras.setBounds(224,445, 85, 27);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PrincipalAnalista.main(null);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnAtras);
		
		//Imagen
		JLabel lblLogoUtec = new JLabel("");
		lblLogoUtec.setIcon(new ImageIcon(ListaAuxITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 1, 107, 50);
		frame.getContentPane().add(lblLogoUtec);
		
		
	}
}
