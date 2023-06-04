package estudiante;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.UIManager;

import analista.ListaAuxITR;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaReclamoEstu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaReclamoEstu window = new ListaReclamoEstu();
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
	public ListaReclamoEstu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.decode("#f9fafb")); 
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		//Lista de Reclamo
		JLabel lblListaReclamo = new JLabel("Lista de Reclamos");
		lblListaReclamo.setForeground(new Color(51, 204, 255));
		lblListaReclamo.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		lblListaReclamo.setHorizontalAlignment(SwingConstants.LEFT);
		lblListaReclamo.setBounds(123, 10, 161, 28);
		frame.getContentPane().add(lblListaReclamo);
		frame.setBounds(100, 100, 404, 489);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Filtro Estado
		JLabel lblEstado = new JLabel("Estado");
		//lblEstado.setBackground(Color.decode("#EEFCFF"));
		lblEstado.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblEstado.setBounds(10, 65, 45, 13);
		frame.getContentPane().add(lblEstado);
		
		JComboBox cboxEstado = new JComboBox();
		cboxEstado.setBackground(Color.decode("#e5e7eb"));
		cboxEstado.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		cboxEstado.setBounds(51, 65, 119, 17);
		frame.getContentPane().add(cboxEstado);
		
			//filtro
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBackground(Color.decode("#0ea5e9"));
		btnFiltrar.setForeground(Color.decode("#f0f9ff"));
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFiltrar.setFont(new Font("Bookman Old Style", Font.PLAIN, 8));
		btnFiltrar.setBounds(182, 62, 85, 21);
		frame.getContentPane().add(btnFiltrar);
		
			//limpiar filtro
		JButton btnLimpFiltro = new JButton("Limpiar Filtro");
		btnLimpFiltro.setBackground(Color.decode("#0ea5e9"));
		btnLimpFiltro.setFont(new Font("Bookman Old Style", Font.PLAIN, 8));
		btnLimpFiltro.setForeground(Color.decode("#f0f9ff"));
		btnLimpFiltro.setBounds(277, 62, 103, 21);
		frame.getContentPane().add(btnLimpFiltro);
		
		//Lista reclamo
		JLabel lblReclamo = new JLabel("Reclamo");
		lblReclamo.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		lblReclamo.setBounds(64, 102, 100, 13);
		frame.getContentPane().add(lblReclamo);
		
		JLabel lblNewLabel = new JLabel("Estado");
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		lblNewLabel.setBounds(250, 102, 45, 13);
		frame.getContentPane().add(lblNewLabel);
		
		
		//BOTONES
			//Modificar
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBackground(Color.decode("#0284c7"));  
		btnModificar.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		btnModificar.setForeground(Color.decode("#f0f9ff"));
		btnModificar.setBounds(10, 402, 104, 40);
		frame.getContentPane().add(btnModificar);
			//Eliminar
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(Color.decode("#0284c7"));  
		btnEliminar.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		btnEliminar.setForeground(Color.decode("#f0f9ff"));
		btnEliminar.setBounds(135, 402, 104, 40);
		frame.getContentPane().add(btnEliminar);
			//Agregar
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBackground(Color.decode("#0284c7"));  
		btnAgregar.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		btnAgregar.setForeground(Color.decode("#f0f9ff"));
		btnAgregar.setBounds(265, 402, 104, 40);
		frame.getContentPane().add(btnAgregar);
		
		// Imagen
		JLabel lblLogoUtec = new JLabel("");
		lblLogoUtec.setIcon(new ImageIcon(ListaAuxITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 1, 107, 50);
		frame.getContentPane().add(lblLogoUtec);
		
		
	}
}
