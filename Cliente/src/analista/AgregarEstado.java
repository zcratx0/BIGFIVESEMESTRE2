package analista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.bigfive.entities.Estado;

import funcionalidades.DAOEstado;
import validaciones.Mensajes;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarEstado {
	//Atributos
	JFrame frame = new JFrame();
	JLabel lblTitAgreEstado = new JLabel("Estado");
	JLabel lblNombre = new JLabel("Nombre");
	JTextField tfNombre = new JTextField();
	JButton btnGuardar = new JButton("Guardar");
	JButton btnCancelar = new JButton("Cancelar");
	Estado est = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarEstado window = new AgregarEstado();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarEstado window = new AgregarEstado();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public static void main(Estado estado) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarEstado window = new AgregarEstado(estado);
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
	public AgregarEstado() {
		initialize();
	}
	

	public AgregarEstado(Estado estado) {
		this.est = estado;
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
		
		
		//Titulo Agregar Estado
		lblTitAgreEstado.setForeground(Color.decode("#08ACEC"));
		lblTitAgreEstado.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblTitAgreEstado.setBounds(97, 10, 227, 24);
		frame.getContentPane().add(lblTitAgreEstado);
		
		//Nombre
		lblNombre.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblNombre.setBounds(25, 87, 45, 13);
		frame.getContentPane().add(lblNombre);
		
		
		tfNombre.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		tfNombre.setBounds(96, 84, 215, 19);
		frame.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		if (this.est != null) tfNombre.setText(this.est.getNombre());
		
		
		//Botones
		//Guardar
		btnGuardar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnGuardar.setForeground(Color.decode("#f0f9ff"));
		btnGuardar.setBackground(Color.decode("#0284c7"));
		btnGuardar.setBounds(226, 140, 85, 21);
		frame.getContentPane().add(btnGuardar);
		
		btnGuardar.addActionListener(e -> {
			int confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea crear el Estado " + tfNombre.getText() + "? ",
					"Confirmación de Agregar Estado", JOptionPane.YES_NO_OPTION);
			if (confirmacion == JOptionPane.YES_OPTION) {
				if (crearEstado()) {
					Mensajes.MostrarExito("ESTADO CREADO!");
					frame.dispose();
				}
			}
		});
		
				
			//Cancelar
		btnCancelar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnCancelar.setForeground(Color.decode("#f0f9ff"));
		btnCancelar.setBackground(Color.decode("#0284c7"));
		btnCancelar.setBounds(120, 140, 85, 21);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaAuxEstados.main(null);
				frame.dispose();
			}
		});

		frame.getContentPane().add(btnCancelar);
		
		
	}
	
	
	private boolean crearEstado() {
		DAOEstado.getInstance().getBean().actualizar();
		for (Estado estado : DAOEstado.getInstance().getBean().listarElementos()) {
			if (estado.getNombre().equalsIgnoreCase(tfNombre.getText())) { Mensajes.MostrarError("YA EXISTE EL ESTADO"); return false;}
		}

		Estado estado = new Estado();
		if (this.est != null) estado = this.est;		
		estado.setNombre(tfNombre.getText());
		estado.setEstado(true);
		if (this.est != null) DAOEstado.getInstance().getBean().crear(estado);
		else {
			DAOEstado.getInstance().getBean().modificar(estado);
		}
		
		DAOEstado.getInstance().getBean().actualizar();
		return true;
	}
	
}
