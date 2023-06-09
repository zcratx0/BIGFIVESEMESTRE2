package analista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarConstancia {
	
	//Atributos
	JFrame frame = new JFrame();
	JTextField tfNombre = new JTextField();
	JLabel lblNombre = new JLabel("Nombre");
	JLabel lblTitAgreConst = new JLabel("Constancia");
	JButton btnGuardar = new JButton("Guardar");
	JButton btnCancelar = new JButton("Cancelar");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarConstancia window = new AgregarConstancia();
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
	public AgregarConstancia() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.getContentPane().setBackground(Color.decode("#f9fafb"));
		frame.setBounds(100, 100, 368, 222);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false); 
		
		// Imagen
		JLabel lblLogoUtec = new JLabel("");
		lblLogoUtec.setIcon(new ImageIcon(AgregarITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 0, 107, 50);
		frame.getContentPane().add(lblLogoUtec);
		
		
		//Titulo Agregar Constancia
		lblTitAgreConst.setForeground(Color.decode("#08ACEC"));
		lblTitAgreConst.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblTitAgreConst.setBounds(88, 10, 236, 24);
		frame.getContentPane().add(lblTitAgreConst);
		
		//Nombre
		lblNombre.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblNombre.setBounds(25, 87, 45, 13);
		frame.getContentPane().add(lblNombre);
		
		
		tfNombre.setBounds(88, 84, 236, 19);
		frame.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		//Botones
			//Guardar
		btnGuardar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnGuardar.setForeground(Color.decode("#f0f9ff"));
		btnGuardar.setBackground(Color.decode("#0284c7"));
		btnGuardar.setBounds(226, 140, 85, 21);
		frame.getContentPane().add(btnGuardar);

		
			//Cancelar
		btnCancelar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnCancelar.setForeground(Color.decode("#f0f9ff"));
		btnCancelar.setBackground(Color.decode("#0284c7"));
		btnCancelar.setBounds(120, 140, 85, 21);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaAuxConstancia.main(null);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnCancelar);
		
		
		
		
	}
}
