package analista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.bigfive.entities.Itr;

import funcionalidades.DAOITR;

public class ListaAuxITR {
	
	//Atributo
	JFrame frame = new JFrame();
	JLabel lblTitListITR = new JLabel("Lista de ITR");
	JButton btnModificar = new JButton("Modificar");
	JButton btnEliminar = new JButton("Eliminar");
	JButton btnHabilitar = new JButton("Habilitar");
	JButton btnAgregar = new JButton("Agregar");
	JButton btnAtras = new JButton("Atrás");
	JTable tablaItr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaAuxITR window = new ListaAuxITR();
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
	public ListaAuxITR() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.getContentPane().setBackground(Color.decode("#f9fafb")); 
		frame.setBounds(100, 100, 465, 507);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		//Titulo 
		lblTitListITR.setForeground(Color.decode("#08ACEC"));  
		lblTitListITR.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblTitListITR.setBounds(116, 10, 142, 25);
		frame.getContentPane().add(lblTitListITR);
		
		
		// Tabla
		Object[][] datosItr = {

		};

		String[] columnasItr  = { "ITR", "Nombre"};

		tablaItr = new JTable(datosItr , columnasItr );
		JScrollPane scrollPaneItr  = new JScrollPane(tablaItr );
		scrollPaneItr.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		scrollPaneItr.setBackground(Color.decode("#f3f4f6"));
		scrollPaneItr.setBounds(35, 61, 388, 285);
		frame.getContentPane().add(scrollPaneItr);
		
		//Boton 
			//Modificar
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tablaItr.getSelectedRow() > -1) {
					AgregarITR.modificar((Itr) tablaItr.getValueAt(tablaItr.getSelectedRow(), 0));
					frame.dispose();
				};
			}
		});
		btnModificar.setBounds(241, 406, 95, 25);
		btnModificar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnModificar.setForeground(Color.decode("#f0f9ff"));
		btnModificar.setBackground(Color.decode("#0284c7"));  
		frame.getContentPane().add(btnModificar);
		
			//Eliminar
		btnEliminar.setBounds(10, 406, 85, 25);
		btnEliminar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnEliminar.setForeground(Color.decode("#f0f9ff"));
		btnEliminar.setBackground(Color.decode("#0284c7"));
		btnEliminar.addActionListener(e -> {
			Itr itr = (Itr) tablaItr.getValueAt(tablaItr.getSelectedRow(), 0);
			itr.setEstado((0));
			DAOITR.getInstance().getItrBean().modificar(itr);
			cargarTabla();
		});
		frame.getContentPane().add(btnEliminar);
			// HABILITAR
		btnHabilitar.setBounds(10, 436, 85, 25);
		btnHabilitar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnHabilitar.setForeground(Color.decode("#f0f9ff"));
		btnHabilitar.setBackground(Color.decode("#0284c7"));
		btnHabilitar.addActionListener(e -> {
			Itr itr = (Itr) tablaItr.getValueAt(tablaItr.getSelectedRow(), 0);
			itr.setEstado((1));
			DAOITR.getInstance().getItrBean().modificar(itr);
			cargarTabla();
		});
		frame.getContentPane().add(btnHabilitar);
		
		
			//Agregar
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarITR.main(null);
				frame.dispose();
			}
		});
		btnAgregar.setBounds(346, 406, 95, 25);
		btnAgregar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnAgregar.setForeground(Color.decode("#f0f9ff"));
		btnAgregar.setBackground(Color.decode("#0284c7"));  
		frame.getContentPane().add(btnAgregar);
		
		
			//Atras
		btnAtras.setFont(new Font("Tahona", Font.BOLD, 10));
		btnAtras.setForeground(Color.decode("#f0f9ff"));
		btnAtras.setBackground(Color.decode("#0284c7"));  
		btnAtras.setBounds(105, 406, 85, 25);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnAtras);
		
		//Imagen
		JLabel lblLogoUtec = new JLabel("");
		lblLogoUtec.setIcon(new ImageIcon(ListaAuxITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 1, 107, 50);
		frame.getContentPane().add(lblLogoUtec);
		
		//	FUNCIONALIDAD
		cargarTabla();
		
	}
	
	public void cargarTabla() {
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("ITR");
		tableModel.addColumn("NOMBRE");
		tableModel.addColumn("ESTADO");
		
		JComboBox cbEstado = new JComboBox<>();
		cbEstado.addItem("DESACTIVADO");
		cbEstado.addItem("ACTIVADO");
		DAOITR.getInstance().getItrBean().listarElementos().forEach(t -> {
			String value = "";
			if (t.getEstado() == 1) {value = "ACTIVADO";}
			else {value = "DESACTIVADO";}
			Object[] tabla = {(Itr) t, t.getDepartamento(), value};
			tableModel.addRow(tabla);
		});
		tablaItr.setModel(tableModel);
	}
	
	
}
