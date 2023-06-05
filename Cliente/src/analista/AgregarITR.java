
package analista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;


import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarITR {

	//Atributo
	JFrame frame = new JFrame();
	JLabel lblAgregarITR = new JLabel("ITR");
	JLabel lblNombre = new JLabel("Nombre");
	JTextField tfNombre = new JTextField();
	JLabel lblDepa = new JLabel("Departamento");
	JTextField tfDepa = new JTextField();
	JButton btnConfirmar = new JButton("Confirmar");
	JButton btnCancelar = new JButton("Cancelar");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarITR window = new AgregarITR();
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
	public AgregarITR() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.getContentPane().setBackground(Color.decode("#f9fafb"));
		frame.setBounds(100, 100, 469, 281);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false); //TODO bloquear tamaño. Agregar a los demás
		
		//Titulo Agregar ITR
		lblAgregarITR.setForeground(Color.decode("#08ACEC"));
		lblAgregarITR.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblAgregarITR.setBounds(142, 10, 169, 25);
		frame.getContentPane().add(lblAgregarITR);
		
		
		//Nombre
		lblNombre.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblNombre.setBounds(25, 79, 45, 13);
		frame.getContentPane().add(lblNombre);
		
		tfNombre.setBounds(142, 76, 274, 19);
		frame.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		
		//Departamento
		lblDepa.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblDepa.setBounds(25, 120, 105, 13);
		frame.getContentPane().add(lblDepa);
		
		tfDepa.setBounds(142, 117, 274, 19);
		frame.getContentPane().add(tfDepa);
		tfDepa.setColumns(10);
		
		
		//Boton Agregar
		btnConfirmar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnConfirmar.setForeground(Color.decode("#f0f9ff"));
		btnConfirmar.setBackground(Color.decode("#0284c7"));
		btnConfirmar.setBounds(311, 184, 105, 33);
		frame.getContentPane().add(btnConfirmar);
		
		
		
		//Boton Cancelar
		btnCancelar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnCancelar.setForeground(Color.decode("#f0f9ff"));
		btnCancelar.setBackground(Color.decode("#0284c7"));
		btnCancelar.setBounds(184, 184, 106, 33);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaAuxITR.main(null);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnCancelar);
		
		//Imagen
		JLabel lblLogoUtec = new JLabel("");
		lblLogoUtec.setIcon(new ImageIcon(AgregarITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 0, 107, 50);
		frame.getContentPane().add(lblLogoUtec);
		
	}

}
