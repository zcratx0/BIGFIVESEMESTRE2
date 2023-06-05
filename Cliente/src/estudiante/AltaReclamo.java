package estudiante;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import analista.ListaAuxITR;
import analista.ListaReclamo;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaReclamo {

	//Atributos
	JFrame frame = new JFrame();
	JLabel lblTitR = new JLabel("Ingresar Nuevo Reclamo");
	JLabel lblTitReclamo = new JLabel("Título *");
	JTextField tfTitReclamo = new JTextField();
	JLabel lblDescrip = new JLabel("Descripción *");
	JTextArea taDescrip = new JTextArea();
	JLabel lblNomEvento = new JLabel("Nombre del evento");
	JTextField tfNombEvento = new JTextField();
	JLabel lblNombAct = new JLabel("Nombre de la actividad");
	JTextField tfNombAct = new JTextField();
	JLabel lblSemestre = new JLabel("Semestre *");
	JTextField tfSemestre = new JTextField();
	JLabel lblFecha = new JLabel("Fecha *");
	JLabel lblDocente = new JLabel("Docente *");
	JTextField tfDocente = new JTextField();
	JLabel lblCredito = new JLabel("Crédito *");
	JTextField tfCredito = new JTextField();
	JButton btnConfirmar = new JButton("Confirmar");
	JButton btnCancelar = new JButton("Cancelar");
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaReclamo window = new AltaReclamo();
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
	public AltaReclamo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.getContentPane().setBackground(Color.decode("#f9fafb"));
		frame.setBounds(100, 100, 515, 552);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		
		//Titulo
		lblTitR.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblTitR.setForeground(Color.decode("#08ACEC"));
		lblTitR.setBounds(136, 10, 282, 25);
		frame.getContentPane().add(lblTitR);
		
		//Titulo de Reclamo
		lblTitReclamo.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblTitReclamo.setBounds(40, 62, 112, 13);
		frame.getContentPane().add(lblTitReclamo);
		
		tfTitReclamo.setBounds(200, 60, 227, 19);
		frame.getContentPane().add(tfTitReclamo);
		tfTitReclamo.setColumns(10);
		
		
		//Descripcion de Reclamo
		lblDescrip.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblDescrip.setBounds(40, 104, 112, 13);
		frame.getContentPane().add(lblDescrip);
		

		taDescrip.setBackground(Color.WHITE);
		taDescrip.setBounds(200, 100, 227, 60);
		frame.getContentPane().add(taDescrip);
		
		
		//Nombre del evento
		lblNomEvento.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblNomEvento.setBounds(40, 180, 128, 13);
		frame.getContentPane().add(lblNomEvento);
		
		tfNombEvento.setBounds(200, 182, 227, 19);
		frame.getContentPane().add(tfNombEvento);
		tfNombEvento.setColumns(10);
		
		//Nombre de la actividad
		lblNombAct.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblNombAct.setBounds(40, 220, 144, 13);
		frame.getContentPane().add(lblNombAct);
		
	
		tfNombAct.setBounds(200, 222, 227, 19);
		frame.getContentPane().add(tfNombAct);
		tfNombAct.setColumns(10);
		
		
		//Semestre
		lblSemestre.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblSemestre.setBounds(40, 260, 90, 13);
		frame.getContentPane().add(lblSemestre);
		
		tfSemestre.setBounds(200, 262, 227, 19);
		frame.getContentPane().add(tfSemestre);
		tfSemestre.setColumns(10);
		
		
		//Fecha
		lblFecha.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblFecha.setBounds(40, 300, 45, 13);
		frame.getContentPane().add(lblFecha);
		
		
		//Docente
		lblDocente.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblDocente.setBounds(40, 340, 77, 13);
		frame.getContentPane().add(lblDocente);
		
		tfDocente.setBounds(200, 342, 227, 19);
		frame.getContentPane().add(tfDocente);
		tfDocente.setColumns(10);
		
		
		//Crédito
		lblCredito.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblCredito.setBounds(40, 380, 66, 13);
		frame.getContentPane().add(lblCredito);
		
		tfCredito.setBounds(200, 382, 227, 19);
		frame.getContentPane().add(tfCredito);
		tfCredito.setColumns(10);
		
		//Botón Confirmar
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConfirmar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnConfirmar.setBackground(Color.decode("#0284c7")); 
		btnConfirmar.setForeground(Color.decode("#f0f9ff"));
		btnConfirmar.setBounds(362, 446, 104, 38);
		frame.getContentPane().add(btnConfirmar);
		
		
		//Boton Cancelar
		btnCancelar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnCancelar.setBackground(Color.decode("#0284c7"));  
		btnCancelar.setForeground(Color.decode("#f0f9ff"));
		btnCancelar.setBounds(210, 446, 104, 38);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaReclamoEstu.main(null);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnCancelar);
		
		// Imagen
		JLabel lblLogoUtec = new JLabel("");
		lblLogoUtec.setIcon(new ImageIcon(ListaAuxITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 1, 107, 50);
		frame.getContentPane().add(lblLogoUtec);
	}
}
