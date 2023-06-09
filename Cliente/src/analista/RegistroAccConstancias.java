package analista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class RegistroAccConstancias {

	//Atributos
	JFrame frame = new JFrame();
	JLabel lblTitRegAcc = new JLabel("Registro de Acción");
	JLabel lblTitConstancia = new JLabel("Constancia");
	JLabel lblFechaHora = new JLabel("Fecha y hora");
	JLabel lblAnalista = new JLabel("Analista");
	JLabel lblEstado = new JLabel("Estado");
	JComboBox cBoxEstado = new JComboBox();
	JLabel lblAgregarCom = new JLabel("Agregar comentario");
	JTextArea tAreaAgregarCom = new JTextArea();
	JButton btnGuardar = new JButton("Guardar");
	JButton btnCancelar = new JButton("Cancelar");
	JTextField tfFechHora = new JTextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroAccConstancias window = new RegistroAccConstancias();
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
	public RegistroAccConstancias() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.getContentPane().setBackground(Color.decode("#f9fafb"));
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 467, 342);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		
		// Imagen
		JLabel lblLogoUtec = new JLabel("");
		lblLogoUtec.setIcon(new ImageIcon(AgregarITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 0, 107, 50);
		frame.getContentPane().add(lblLogoUtec);
		
		
		//Titulo registro de acciones
		lblTitRegAcc.setForeground(Color.decode("#08ACEC"));
		lblTitRegAcc.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblTitRegAcc.setBounds(124, 10, 211, 29);
		frame.getContentPane().add(lblTitRegAcc);
	
		
		lblTitConstancia .setForeground(Color.decode("#08ACEC"));
		lblTitConstancia .setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblTitConstancia.setBounds(124, 37, 122, 29);
		frame.getContentPane().add(lblTitConstancia);
		
		
		//Fecha y hora
		lblFechaHora.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblFechaHora.setBounds(41, 76, 91, 13);
		frame.getContentPane().add(lblFechaHora);
		
		tfFechHora.setBounds(188, 73, 198, 19);
		tfFechHora.setColumns(10);
		frame.getContentPane().add(tfFechHora);
		
		
		//Analista
		lblAnalista.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblAnalista.setBounds(41, 114, 45, 13);
		frame.getContentPane().add(lblAnalista);
		
		
		//Estado
		lblEstado.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblEstado.setBounds(41, 152, 45, 13);
		frame.getContentPane().add(lblEstado);
		
		
		cBoxEstado.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		cBoxEstado.setBackground(Color.decode("#e5e7eb"));
		cBoxEstado.setBounds(188, 148, 198, 21);
		frame.getContentPane().add(cBoxEstado);
		
		//Agregar Comentario
		lblAgregarCom.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblAgregarCom.setBounds(41, 191, 156, 13);
		frame.getContentPane().add(lblAgregarCom);
		
		tAreaAgregarCom.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		tAreaAgregarCom.setBounds(51, 211, 368, 38);
		frame.getContentPane().add(tAreaAgregarCom);
		
		
		//Boton
			//Guardar
		btnGuardar.setBackground(Color.decode("#0284c7"));
		btnGuardar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnGuardar.setForeground(Color.decode("#f0f9ff"));
		btnGuardar.setBounds(334, 257, 86, 29);
		frame.getContentPane().add(btnGuardar);
		
		
			//Cancelar
		btnCancelar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnCancelar.setForeground(Color.decode("#f0f9ff"));
		btnCancelar.setBackground(Color.decode("#0284c7"));
		btnCancelar.setBounds(217, 259, 86, 27);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaSoliConstancias.main(null);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnCancelar);
		
		
		
		
		
		
	}
}
