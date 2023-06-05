package analista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HabilitacionUsuario {

	//Atributos
	JFrame frame = new JFrame();
	JLabel lblTitHabUsu = new JLabel("Habilitación de Usuarios");
	JLabel lblVerMas = new JLabel("Ver Más");
	JButton btnAtras = new JButton("Atrás");
	JButton btnListUsu = new JButton("Lista de Usuarios");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HabilitacionUsuario window = new HabilitacionUsuario();
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
	public HabilitacionUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.getContentPane().setBackground(Color.decode("#f9fafb"));
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 753, 423);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		// Imagen
		JLabel lblLogoUtec = new JLabel("");
		lblLogoUtec.setIcon(new ImageIcon(AgregarITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 0, 107, 50);
		frame.getContentPane().add(lblLogoUtec);
		
		
		//Titulo Habilitación de Usuarios
		lblTitHabUsu.setForeground(Color.decode("#08ACEC"));
		lblTitHabUsu.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblTitHabUsu.setBounds(201, 10, 411, 29);
		frame.getContentPane().add(lblTitHabUsu);
	
		//Ver mas
		lblVerMas.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblVerMas.setBounds(554, 10, 65, 13);
		
		// Tabla
				Object[][] datosEst = {

				};

				String[] columnasEst  = {"Tipo de Usuarios", "ITR", "Generación", "Estado", "Información" };

				JTable tablaEst = new JTable(datosEst , columnasEst );
				JScrollPane scrollPaneEst  = new JScrollPane(tablaEst );
				scrollPaneEst.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
				scrollPaneEst.setBackground(Color.decode("#f3f4f6"));
				scrollPaneEst.setBounds(34, 77, 667, 236);
				frame.getContentPane().add(scrollPaneEst);

		
		//Botones
			//Atras
		btnAtras.setFont(new Font("Tahona", Font.BOLD, 10));
		btnAtras.setForeground(Color.decode("#f0f9ff"));
		btnAtras.setBackground(Color.decode("#0284c7"));
		btnAtras.setBounds(434, 333, 89, 29);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnAtras);
		
			//Lista de Usuarios
		btnListUsu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaUsuarios.main(null);
				frame.dispose();
			}
		});
		btnListUsu.setFont(new Font("Tahona", Font.BOLD, 10));
		btnListUsu.setForeground(Color.decode("#f0f9ff"));
		btnListUsu.setBackground(Color.decode("#0284c7"));
		btnListUsu.setBounds(562, 333, 139, 29);
		frame.getContentPane().add(btnListUsu);
	}
}
