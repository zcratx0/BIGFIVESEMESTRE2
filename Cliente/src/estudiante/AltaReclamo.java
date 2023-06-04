package estudiante;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import analista.ListaAuxITR;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaReclamo {

	private JFrame frame;
	private JTextField tfTitReclamo;
	private JLabel lblDescrip;
	private JLabel lblNomEvento;
	private JTextField tfNombEvento;
	private JLabel lblNombAct;
	private JTextField tfNombAct;
	private JLabel lblTitR;
	private JLabel lblSemestre;
	private JTextField tfSemestre;
	private JLabel lblFecha;
	private JLabel lblDocente;
	private JTextField tfDocente;
	private JLabel lblCredito;
	private JTextField tfCredito;

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
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.decode("#f9fafb"));
		frame.setBounds(100, 100, 515, 552);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		
		//Titulo
		lblTitR = new JLabel("Ingresar Nuevo Reclamo");
		lblTitR.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblTitR.setForeground(Color.decode("#08ACEC"));
		lblTitR.setBounds(136, 10, 282, 25);
		frame.getContentPane().add(lblTitR);
		
		//Titulo de Reclamo
		JLabel lblTitReclamo = new JLabel("Título *");
		lblTitReclamo.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblTitReclamo.setBounds(40, 62, 112, 13);
		frame.getContentPane().add(lblTitReclamo);
		
		
		tfTitReclamo = new JTextField();
		tfTitReclamo.setBounds(200, 60, 227, 19);
		frame.getContentPane().add(tfTitReclamo);
		tfTitReclamo.setColumns(10);
		
		
		//Descripcion de Reclamo
		lblDescrip = new JLabel("Descripción *");
		lblDescrip.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblDescrip.setBounds(40, 104, 112, 13);
		frame.getContentPane().add(lblDescrip);
		
		JTextArea taDescrip = new JTextArea();
		taDescrip.setBackground(Color.WHITE);
		taDescrip.setBounds(200, 100, 227, 60);
		frame.getContentPane().add(taDescrip);
		
		
		//Nombre del evento
		lblNomEvento = new JLabel("Nombre del evento");
		lblNomEvento.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblNomEvento.setBounds(40, 180, 128, 13);
		frame.getContentPane().add(lblNomEvento);
		
		tfNombEvento = new JTextField();
		tfNombEvento.setBounds(200, 182, 227, 19);
		frame.getContentPane().add(tfNombEvento);
		tfNombEvento.setColumns(10);
		
		//Nombre de la actividad
		lblNombAct = new JLabel("Nombre de la actividad");
		lblNombAct.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblNombAct.setBounds(40, 220, 144, 13);
		frame.getContentPane().add(lblNombAct);
		
		tfNombAct = new JTextField();
		tfNombAct.setBounds(200, 222, 227, 19);
		frame.getContentPane().add(tfNombAct);
		tfNombAct.setColumns(10);
		
		
		//Semestre
		lblSemestre = new JLabel("Semestre *");
		lblSemestre.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblSemestre.setBounds(40, 260, 90, 13);
		frame.getContentPane().add(lblSemestre);
		
		tfSemestre = new JTextField();
		tfSemestre.setBounds(200, 262, 227, 19);
		frame.getContentPane().add(tfSemestre);
		tfSemestre.setColumns(10);
		
		
		//Fecha
		lblFecha = new JLabel("Fecha *");
		lblFecha.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblFecha.setBounds(40, 300, 45, 13);
		frame.getContentPane().add(lblFecha);
		
		
		//Docente
		lblDocente = new JLabel("Docente *");
		lblDocente.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblDocente.setBounds(40, 340, 77, 13);
		frame.getContentPane().add(lblDocente);
		
		tfDocente = new JTextField();
		tfDocente.setBounds(200, 342, 227, 19);
		frame.getContentPane().add(tfDocente);
		tfDocente.setColumns(10);
		
		
		//Crédito
		lblCredito = new JLabel("Crédito *");
		lblCredito.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblCredito.setBounds(40, 380, 66, 13);
		frame.getContentPane().add(lblCredito);
		
		tfCredito = new JTextField();
		tfCredito.setBounds(200, 382, 227, 19);
		frame.getContentPane().add(tfCredito);
		tfCredito.setColumns(10);
		
		//Botón Confirmar
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConfirmar.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		btnConfirmar.setBackground(Color.decode("#0284c7")); 
		btnConfirmar.setForeground(Color.decode("#f0f9ff"));
		btnConfirmar.setBounds(362, 446, 104, 38);
		frame.getContentPane().add(btnConfirmar);
		
		//Boton Cancelar
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		btnCancelar.setBackground(Color.decode("#0284c7"));  
		btnCancelar.setForeground(Color.decode("#f0f9ff"));
		btnCancelar.setBounds(210, 446, 104, 38);
		frame.getContentPane().add(btnCancelar);
		
		// Imagen
		JLabel lblLogoUtec = new JLabel("");
		lblLogoUtec.setIcon(new ImageIcon(ListaAuxITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 1, 107, 50);
		frame.getContentPane().add(lblLogoUtec);
	}
}
