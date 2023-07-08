package analista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.transaction.Transactional;

import com.bigfive.entities.Accione;
import com.bigfive.entities.Analista;
import com.bigfive.entities.Estado;
import com.bigfive.entities.RecibeReclamo;
import com.bigfive.entities.Reclamo;

import funcionalidades.DAOAccionReclamo;
import funcionalidades.DAOEstado;
import funcionalidades.DAORecibeReclamo;
import funcionalidades.DAOReclamo;
import validaciones.Mensajes;

public class RegistroAccReclamo {

	//Atributos
	JFrame frame = new JFrame();
	JLabel lblTitRegAcc = new JLabel("Registro de Acción");
	JLabel lblTitReclamo = new JLabel("Reclamo");
	JLabel lblFechaHora = new JLabel("Fecha y hora");
	JLabel lblAnalista = new JLabel("Analista");
	JLabel lblEstado = new JLabel("Estado");
	JComboBox cBoxEstado = new JComboBox();
	JLabel lblAgregarCom = new JLabel("Agregar comentario");
	JTextArea tAreaAgregarCom = new JTextArea();
	JButton btnGuardar = new JButton("Guardar");
	JButton btnCancelar = new JButton("Cancelar");
	JTextField tfFechHora = new JTextField();
	Analista analista = new Analista();
	Reclamo reclamo = new Reclamo();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroAccReclamo window = new RegistroAccReclamo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Launch the application.
	 */
	public static void main(Analista analista, Reclamo reclamo) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroAccReclamo window = new RegistroAccReclamo();
					window.analista = analista;
					window.reclamo = reclamo;
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
	public RegistroAccReclamo() {
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
		

		
		lblTitReclamo .setForeground(Color.decode("#08ACEC"));
		lblTitReclamo .setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblTitReclamo.setBounds(124, 37, 122, 29);
		frame.getContentPane().add(lblTitReclamo);
		
		
		//Estado
		lblEstado.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblEstado.setBounds(41, 113, 45, 13);
		frame.getContentPane().add(lblEstado);
		
		cBoxEstado.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		cBoxEstado.setBackground(Color.decode("#e5e7eb"));
		cBoxEstado.setBounds(184, 109, 211, 21);
		frame.getContentPane().add(cBoxEstado);
		
		//Agregar Comentario
		lblAgregarCom.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblAgregarCom.setBounds(41, 155, 156, 13);
		frame.getContentPane().add(lblAgregarCom);
		
	
		tAreaAgregarCom.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		tAreaAgregarCom.setBounds(41, 186, 378, 56);
		frame.getContentPane().add(tAreaAgregarCom);
		
		
		//Boton
			//Guardar
		btnGuardar.setBackground(Color.decode("#0284c7"));
		btnGuardar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnGuardar.setForeground(Color.decode("#f0f9ff"));
		btnGuardar.setBounds(334, 257, 86, 29);
		frame.getContentPane().add(btnGuardar);
		btnGuardar.addActionListener(e -> {
			int confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea realizar la Acción?", "Confirmación de acción", JOptionPane.YES_NO_OPTION);
			 if (confirmacion == JOptionPane.YES_OPTION  ) {
					if (tAreaAgregarCom.getText().isEmpty()) {
						Mensajes.MostrarError("Rellenar los campos");
					} else if (cBoxEstado.getSelectedIndex() == 0) {
						Mensajes.MostrarError("Seleccionar otro estado");
					} else {
						guardarCambios();
						frame.dispose();
					}
			 }
		});
		
		
			//Cancelar
		btnCancelar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnCancelar.setForeground(Color.decode("#f0f9ff"));
		btnCancelar.setBackground(Color.decode("#0284c7"));
		btnCancelar.setBounds(211, 257, 92, 29);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//	ListaReclamo.main(null);
				
				int confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea cancelar Reclamo?", "Confirmación de cancelación", JOptionPane.YES_NO_OPTION);
				 if (confirmacion == JOptionPane.YES_OPTION  ) {
						frame.dispose();
				 }
			}
		});
		frame.getContentPane().add(btnCancelar);
		
		
		//	CARGAR DATOS
		cBoxEstado.addItem("INGRESADO");
		DAOEstado.getInstance().cargarComboBox(cBoxEstado);
		
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void guardarCambios() {
		Estado estado = (Estado) cBoxEstado.getSelectedItem();
		reclamo.setEstado(estado);
		
		try {
			DAOReclamo.getInstance().getBean().modificar(reclamo);
		} catch (Exception e) {
		}
			
		Accione accion = new Accione();
		accion.setDescripcion(tAreaAgregarCom.getText());
		accion.setEstado(estado);
		accion.setAnalista(this.analista);



		
		
		try {
		    DAOAccionReclamo.getInstance().getBean().reportaarAccion(accion, reclamo);
		} catch (Exception e) {
		    System.out.println("Error al crear Accion: " + e.getMessage());
		    e.printStackTrace();
		}

	}
	
}
