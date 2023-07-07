package analista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import com.bigfive.entities.Estado;
import com.bigfive.entities.Usuario;

import funcionalidades.DAOArea;
import funcionalidades.DAOEstado;
import funcionalidades.DAOEstudiante;
import funcionalidades.DAOUsuario;
import utils.Escolaridad;
import validaciones.Mensajes;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class ListaAuxEstados {
	
	//Atributos
	JFrame frame = new JFrame();
	JLabel lblTitLista = new JLabel("Listado de Estados de reclamos,");
	JLabel lblTitLista2 = new JLabel(" constancias y justificaciones ");
	JCheckBox chBoxBaja = new JCheckBox("Filtrar por DESHABILITADOS");
	JButton btnNuevoEst = new JButton("Nuevo estado");
	JButton btnAtras = new JButton("Atrás");
	JButton btnModificar = new JButton("Modificar");
	JTable tablaEst;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaAuxEstados window = new ListaAuxEstados();
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
	public ListaAuxEstados() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 10));
		frame.getContentPane().setBackground(Color.decode("#f9fafb"));
		frame.setBounds(100, 100, 561, 431);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		

		//Imagen
		JLabel lblLogoUtec = new JLabel("");
		lblLogoUtec.setIcon(new ImageIcon(AgregarITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 0, 107, 50);
		frame.getContentPane().add(lblLogoUtec);
		
		//Titulo listado de r,c y j
		lblTitLista.setForeground(Color.decode("#08ACEC"));
		lblTitLista.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblTitLista.setBounds(123, 10, 356, 20);
		frame.getContentPane().add(lblTitLista);
		
	
		lblTitLista2.setForeground(Color.decode("#08ACEC"));
		lblTitLista2.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblTitLista2.setBounds(123, 40, 326, 20);
		frame.getContentPane().add(lblTitLista2);
		chBoxBaja.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		
		
		chBoxBaja.setBounds(290, 77, 203, 21);
		frame.getContentPane().add(chBoxBaja);
		chBoxBaja.addActionListener(e -> {
			cargarEstados();
		});
		
		// Tabla
		Object[][] datosEst = {

		};

		String[] columnasEst  = {"Estado", "Dado de Baja"};

		tablaEst = new JTable(datosEst , columnasEst );
		JScrollPane scrollPaneEst  = new JScrollPane(tablaEst );
		scrollPaneEst.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		scrollPaneEst.setBackground(Color.decode("#f3f4f6"));
		scrollPaneEst.setBounds(25, 107, 468, 203);
		frame.getContentPane().add(scrollPaneEst);
		
		
		//Botones
			//Nuevo estado
		btnNuevoEst.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNuevoEst.setForeground(Color.decode("#f0f9ff"));
		btnNuevoEst.setBackground(Color.decode("#0284c7"));
		btnNuevoEst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarEstado.main(null);
				frame.dispose();
			}
		});
		btnNuevoEst.setBounds(371, 342, 122, 28);
		frame.getContentPane().add(btnNuevoEst);
			
			//Atras
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnAtras.setForeground(Color.decode("#f0f9ff"));
		btnAtras.setBackground(Color.decode("#0284c7"));
		btnAtras.setBounds(25, 342, 107, 28);
		frame.getContentPane().add(btnAtras);
		
			//Modificar
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarEstado.main(null);
				frame.dispose();
			}
		});
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnModificar.setForeground(Color.decode("#f0f9ff"));
		btnModificar.setBackground(Color.decode("#0284c7"));
		btnModificar.setBounds(249, 342, 112, 28);
		frame.getContentPane().add(btnModificar);
		
		
		
		//	Cargar Datos
		
		cargarEstados();
	}
	
	

	public void cargarEstados() {
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("Estado");
		tableModel.addColumn("Nombre");
		tableModel.addColumn("Estado");
		tablaEst.setModel(tableModel);

		JComboBox cbEstado = new JComboBox<>();
		cbEstado.addItem("DESHABILITADO");
		cbEstado.addItem("HABILITADO");
		
		tablaEst.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(cbEstado));
		
		DAOEstado.getInstance().getBean().listarElementos().forEach(e -> {
			int est = 0;
			if (e.getEstado() == true) est = 1;
			Object[] row = {e,  e.getNombre(), cbEstado.getItemAt(est)};
			if (!chBoxBaja.isSelected()) tableModel.addRow(row);
			else {
				if (!e.getEstado()) tableModel.addRow(row);
			}
		});
		
		
		tablaEst.getSelectionModel().addListSelectionListener(e -> {
			btnModificar.setEnabled(true);
		});
		tablaEst.removeColumn(tablaEst.getColumnModel().getColumn(0));
		
		
		
		tableModel.addTableModelListener(e -> {
			if (e.getType() == 0) {
				String value = (String)tableModel.getValueAt(e.getFirstRow(), e.getColumn());
				System.out.println(value);
				Estado estado = (Estado)tablaEst.getModel().getValueAt(e.getFirstRow(), 0);
				int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de cambiar el Estado?", "Cambio de estado", JOptionPane.YES_NO_OPTION);
				 if (confirmacion == JOptionPane.YES_OPTION  ) {
					if (value.equalsIgnoreCase("habilitado")) {
						estado.setEstado(true);
					}
					else {
						if (DAOEstado.getInstance().getBean().estaUtilizado(estado)) Mensajes.MostrarError("ESTADO UTILIZADO");
						else {
							estado.setEstado(false);
							Mensajes.MostrarExito("ESTADO ACTUALIZADO");
						}
					}
					DAOEstado.getInstance().getBean().modificar(estado);
					DAOEstado.getInstance().getBean().actualizar();
				}
				 cargarEstados();
				
			}
		} );
	}
	
	
}
