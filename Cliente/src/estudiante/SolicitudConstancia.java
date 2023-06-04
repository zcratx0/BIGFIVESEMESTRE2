package estudiante;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

import analista.ListaAuxITR;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;

public class SolicitudConstancia {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SolicitudConstancia window = new SolicitudConstancia();
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
	public SolicitudConstancia() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.decode("#f9fafb"));  
		frame.setBounds(100, 100, 554, 356);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		//Titulo
		JLabel lblTitSoliConst = new JLabel("Solicitud de Constancia");
		lblTitSoliConst.setForeground(Color.decode("#08ACEC"));
		lblTitSoliConst.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblTitSoliConst.setBounds(107, 10, 308, 21);
		frame.getContentPane().add(lblTitSoliConst);
		
		
		// Tipo
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblTipo.setBounds(33, 60, 45, 13);
		frame.getContentPane().add(lblTipo);

		JComboBox cBoxTipo = new JComboBox();
		cBoxTipo.setBounds(128, 56, 144, 21);
		cBoxTipo.setBackground(Color.decode("#e5e7eb"));
		frame.getContentPane().add(cBoxTipo);

		// Evento
		JLabel lblEvento = new JLabel("Evento");
		lblEvento.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblEvento.setBounds(33, 105, 45, 13);
		frame.getContentPane().add(lblEvento);

		JComboBox cBoxEvento = new JComboBox();
		cBoxEvento.setBounds(128, 101, 144, 21);
		cBoxEvento.setBackground(Color.decode("#e5e7eb"));
		frame.getContentPane().add(cBoxEvento);

		// Info Adicional
		JLabel lblInfoAd = new JLabel("Información Adicional");
		lblInfoAd.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblInfoAd.setBounds(33, 151, 132, 13);
		frame.getContentPane().add(lblInfoAd);

		JTextArea taInfoAd = new JTextArea();
		taInfoAd.setToolTipText("");
		taInfoAd.setBackground(SystemColor.inactiveCaptionBorder);
		taInfoAd.setBounds(55, 174, 432, 84);
		frame.getContentPane().add(taInfoAd);

		//Botones
			//Guardar
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(Color.decode("#0284c7"));  
		btnGuardar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnGuardar.setForeground(Color.decode("#f0f9ff"));
		btnGuardar.setBounds(423, 280, 90, 29);
		frame.getContentPane().add(btnGuardar);
		
			//Cancelar
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(Color.decode("#0284c7"));  
		btnCancelar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnCancelar.setForeground(Color.decode("#f0f9ff"));
		btnCancelar.setBounds(298, 280, 90, 29);
		frame.getContentPane().add(btnCancelar);
		
			//Adjuntar Archivo
		JButton btnAdjuntar = new JButton("Adjuntar Archivo");
		btnAdjuntar.setBackground(Color.decode("#0284c7"));  
		btnAdjuntar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnAdjuntar.setForeground(Color.decode("#f0f9ff"));
		btnAdjuntar.setBounds(107, 280, 132, 29);
		frame.getContentPane().add(btnAdjuntar);

		//Imagen
		JLabel lblLogoUtec = new JLabel("");
		lblLogoUtec.setIcon(new ImageIcon(ListaAuxITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 1, 107, 50);
		frame.getContentPane().add(lblLogoUtec);
		
		
	}
}
