//	lblTITULO.setForeground(Color.decode("#08ACEC"));                  ******COLOOOOR TITULOS

//  frame.getContentPane().setBackground(Color.decode("#f9fafb"));                     ******COLOR FONDO

//  btn.setBackground(Color.decode("#0284c7"));             ******COLOR BOTONES
//  btnLetras.setForeground(Color.decode("#f0f9ff"));
//  btnFiltrar.setBackground(Color.decode("#0ea5e9"));


//cBoxEstado.setBackground(Color.decode("#e5e7eb"));


//  TxtNormal.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));   *******LETRA TEXTO NORMAL
//  TxtTitulo.setFont(new Font("Bookman Old Style", Font.BOLD, 20));  *******LETRA TÍTULO
// btnFiltrar.setBackground(Color.decode("#EEFCFF"));

// frame.setResizable(false);
package analista;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;


import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class AgregarITR {

	private JFrame frame;
	private JTextField tfNombre;
	private JTextField tfDepa;

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
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.decode("#f9fafb"));
		frame.setBounds(100, 100, 469, 281);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false); //TODO bloquear tamaño. Agregar a los demás
		
		//Titulo Agregar ITR
		JLabel lblAgregarITR = new JLabel("ITR");
		lblAgregarITR.setForeground(Color.decode("#08ACEC"));
		lblAgregarITR.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblAgregarITR.setBounds(142, 10, 169, 25);
		frame.getContentPane().add(lblAgregarITR);
		
		
		//Nombre
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblNombre.setBounds(25, 79, 45, 13);
		frame.getContentPane().add(lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(142, 76, 274, 19);
		frame.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		
		//Departamento
		JLabel lblDepa = new JLabel("Departamento");
		lblDepa.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblDepa.setBounds(25, 120, 105, 13);
		frame.getContentPane().add(lblDepa);
		
		tfDepa = new JTextField();
		tfDepa.setBounds(142, 117, 274, 19);
		frame.getContentPane().add(tfDepa);
		tfDepa.setColumns(10);
		
		
		//Boton Agregar
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnAgregar.setForeground(Color.decode("#f0f9ff"));
		btnAgregar.setBackground(Color.decode("#0284c7"));
		btnAgregar.setBounds(168, 184, 105, 33);
		frame.getContentPane().add(btnAgregar);
		
		
		//Boton Cancelar
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnCancelar.setForeground(Color.decode("#f0f9ff"));
		btnCancelar.setBackground(Color.decode("#0284c7"));
		btnCancelar.setBounds(310, 184, 106, 33);
		frame.getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		//Imagen
		JLabel lblLogoUtec = new JLabel("");
		lblLogoUtec.setIcon(new ImageIcon(AgregarITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 0, 107, 50);
		frame.getContentPane().add(lblLogoUtec);
		
	}

}
