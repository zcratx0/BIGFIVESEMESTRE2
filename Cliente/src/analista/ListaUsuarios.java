package analista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.bigfive.entities.Analista;
import com.bigfive.entities.Estudiante;
import com.bigfive.entities.Tutor;

import estudiante.ListaReclamoEstu;
import funcionalidades.DAOAnalista;
import funcionalidades.DAOEstudiante;
import funcionalidades.DAOITR;
import funcionalidades.DAOTutor;
import utils.TBFTable;
import validaciones.Mensajes;

public class ListaUsuarios {

	//Atributos
	JFrame frame = new JFrame();
	JLabel lblTitListUsua = new JLabel("Lista de Usuarios");
	JLabel lblGeneracion = new JLabel("Generación");
	JTextField tfGeneracion = new JTextField();
	JLabel lblTipoUsu = new JLabel("Tipo de usuario");
	JLabel lblItrFil = new JLabel("ITR");
	JComboBox cBoxItr = new JComboBox();
	JLabel lblEstadoFil = new JLabel("Estado");
	JComboBox cBoxEstado = new JComboBox();
	JButton btnFiltrar = new JButton("Filtrar");
	JButton btnLimpiarF = new JButton("Limpiar Filtro");
	JButton btnAtras = new JButton("Atrás");
	JButton btnModificar = new JButton("Modificar");
	TBFTable tablaUsu;
	ListaUsuarios listaUsuarios;
	Analista analista = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaUsuarios window = new ListaUsuarios();
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
					ListaUsuarios window = new ListaUsuarios();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void main(Analista analista) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaUsuarios window = new ListaUsuarios();
					window.analista = analista;
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
	public ListaUsuarios() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		listaUsuarios = this;
		frame.getContentPane().setBackground(Color.decode("#f9fafb")); 
		frame.setBounds(100, 100, 1031, 506);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		// Imagen
		JLabel lblLogoUtec = new JLabel("");
		lblLogoUtec.setIcon(new ImageIcon(ListaAuxITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 1, 107, 50);
		frame.getContentPane().add(lblLogoUtec);
		
		
		//Titulo Lista de Usuarios
		lblTitListUsua.setForeground(Color.decode("#08ACEC"));  
		lblTitListUsua.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblTitListUsua.setBounds(343, 10, 259, 31);
		frame.getContentPane().add(lblTitListUsua);
		
		//*Filtro
		
		// Generacion
		lblGeneracion.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblGeneracion.setBounds(565, 88, 73, 13);
		// frame.getContentPane().add(lblGeneracion);


		tfGeneracion.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		tfGeneracion.setBounds(630, 84, 107, 21);
		// frame.getContentPane().add(tfGeneracion);
		
		//Tipo de usuario
		lblTipoUsu.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblTipoUsu.setBounds(10, 88, 96, 13);
		frame.getContentPane().add(lblTipoUsu);
		
		JComboBox cBoxTipoUsu = new JComboBox(new String[] {"SIN FILTRO", "Analista", "Estudiante", "Tutor" });
		cBoxTipoUsu.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		cBoxTipoUsu.setBounds(109, 84, 107, 21);
		cBoxTipoUsu.addActionListener(e -> {
			String selected = cBoxTipoUsu.getSelectedItem().toString();
			if (selected.equals("Estudiante")) {
				frame.getContentPane().add(lblGeneracion);
				frame.getContentPane().add(tfGeneracion);
			} else if (selected.equals("Tutor")) {
				frame.getContentPane().remove(lblGeneracion);
				frame.getContentPane().remove(tfGeneracion);
			} else if (selected.equals("Analista")) {
				frame.getContentPane().remove(lblGeneracion);
				frame.getContentPane().remove(tfGeneracion);
			}

			frame.getContentPane().revalidate();
			frame.getContentPane().repaint();
		});
		frame.getContentPane().add(cBoxTipoUsu);
		
		//ITR
		lblItrFil.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblItrFil.setBounds(10, 110, 45, 13);
		frame.getContentPane().add(lblItrFil);
		
		
		cBoxItr.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		cBoxItr.setBounds(60, 110, 265, 21);
		frame.getContentPane().add(cBoxItr);
		cBoxItr.addItem("SIN FILTRO");
		//Estado
		lblEstadoFil.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblEstadoFil.setBounds(400, 88, 45, 13);
		frame.getContentPane().add(lblEstadoFil);
		

		cBoxEstado.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		cBoxEstado.setBounds(435, 84, 107, 21);
		frame.getContentPane().add(cBoxEstado);
		cBoxEstado.addItem("SIN FILTRO");
		cBoxEstado.addItem("SIN VALOR");
		cBoxEstado.addItem("ACTIVADO");
		cBoxEstado.addItem("ELIMINADO");

		
		//Botones
			//Filtrar
		btnFiltrar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnFiltrar.setForeground(Color.decode("#f0f9ff"));
		btnFiltrar.setBackground(Color.decode("#0ea5e9"));
		btnFiltrar.setBounds(773, 84, 85, 21);
		btnFiltrar.addActionListener(e -> {
			//	FILTRO
			DefaultTableModel dtm = (DefaultTableModel) tablaUsu.getModel();
			TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(dtm);
			tablaUsu.setRowSorter(sorter);
			
			List<RowFilter<Object, Object>> filtros = new ArrayList<>();
			
			if (!cBoxEstado.getSelectedItem().toString().equalsIgnoreCase("SIN FILTRO")) filtros.add(RowFilter.regexFilter(cBoxEstado.getSelectedItem().toString(), 6));
			if (!cBoxItr.getSelectedItem().toString().equalsIgnoreCase("SIN FILTRO")) filtros.add(RowFilter.regexFilter(cBoxItr.getSelectedItem().toString(), 5));
			if (!cBoxTipoUsu.getSelectedItem().toString().equalsIgnoreCase("SIN FILTRO")) filtros.add(RowFilter.regexFilter(cBoxTipoUsu.getSelectedItem().toString().toUpperCase(), 4));
			if (cBoxTipoUsu.getSelectedItem().toString().equalsIgnoreCase("ESTUDIANTE") && !tfGeneracion.getText().isEmpty()) filtros.add(RowFilter.regexFilter(tfGeneracion.getText(), 7));
			
			sorter.setRowFilter((RowFilter<Object, Object>) RowFilter.andFilter(filtros));
		});
		
		frame.getContentPane().add(btnFiltrar);
			//Limpiar Filtro
		btnLimpiarF.setFont(new Font("Tahona", Font.BOLD, 10));
		btnLimpiarF.setForeground(Color.decode("#f0f9ff"));
		btnLimpiarF.setBackground(Color.decode("#0ea5e9"));
		btnLimpiarF.setBounds(868, 84, 139, 21);
		btnLimpiarF.addActionListener(e -> {
			DefaultTableModel dtm = (DefaultTableModel) tablaUsu.getModel();
			TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(dtm);
			tablaUsu.setRowSorter(sorter);
			sorter.setRowFilter(RowFilter.regexFilter(""));

		});
		frame.getContentPane().add(btnLimpiarF);
		
		
		// Tabla
		Object[][] datosUsu = {};
		String[] columnasUsu  = {"Usuario","TIPO", "ITR", "Estado"};
		tablaUsu = new TBFTable(datosUsu , columnasUsu );
		JScrollPane scrollPaneUsu  = new JScrollPane(tablaUsu );
		scrollPaneUsu.setBackground(Color.decode("#f3f4f6"));
		scrollPaneUsu.setBounds(25, 140, 955, 248);
		frame.getContentPane().add(scrollPaneUsu);

		
		
		
		//BOTONES
		
		
		//Atras
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					HabilitacionUsuario.mostrar();
					frame.dispose();
				
			}
		});
		btnAtras.setFont(new Font("Tahona", Font.BOLD, 10));
		btnAtras.setForeground(Color.decode("#f0f9ff"));
		btnAtras.setBackground(Color.decode("#0284c7"));
		btnAtras.setBounds(754, 410, 96, 31);
		frame.getContentPane().add(btnAtras);
		btnModificar.setToolTipText("Seleccionar usuario a modificar");
		
		
		//Modificar
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tablaUsu.getSelectedRow() > -1) {
					if (tablaUsu.getModel().getValueAt(tablaUsu.getSelectedRow(), 0) instanceof Estudiante) DatosUsuario.loadDatosUsuario(((Estudiante) tablaUsu.getModel().getValueAt(tablaUsu.getSelectedRow(), 0)).getUsuario(), listaUsuarios);
					else if (tablaUsu.getModel().getValueAt(tablaUsu.getSelectedRow(), 0) instanceof Analista) DatosUsuario.loadDatosUsuario(((Analista) tablaUsu.getModel().getValueAt(tablaUsu.getSelectedRow(), 0)).getUsuario(), listaUsuarios);
					else if (tablaUsu.getModel().getValueAt(tablaUsu.getSelectedRow(), 0) instanceof Tutor) DatosUsuario.loadDatosUsuario(((Tutor) tablaUsu.getModel().getValueAt(tablaUsu.getSelectedRow(), 0)).getUsuario(), listaUsuarios);
				}
			}
		});
		btnModificar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnModificar.setForeground(Color.decode("#f0f9ff"));
		btnModificar.setBackground(Color.decode("#0284c7"));
		btnModificar.setBounds(884, 410, 96, 31);
		btnModificar.setEnabled(false);
		frame.getContentPane().add(btnModificar);
		
		// Historial
		JButton btnHistorial = new JButton("Historial");
		btnHistorial.setFont(new Font("Tahona", Font.BOLD, 10));
		btnHistorial.setForeground(Color.decode("#f0f9ff"));
		btnHistorial.setBackground(Color.decode("#0ea5e9"));
		btnHistorial.setBounds(25, 415, 85, 21);
		btnHistorial.addActionListener(e -> {
			if (tablaUsu.getSelectedRow() > -1) {
				if (tablaUsu.getModel().getValueAt(tablaUsu.getSelectedRow(), 0) instanceof Estudiante) ListaReclamo.main((Estudiante) tablaUsu.getModel().getValueAt(tablaUsu.getSelectedRow(), 0));
				else Mensajes.MostrarError("Por favor seleccionar un estudiante de la lista.");
				System.out.println("");
			} else {
				Mensajes.MostrarError("Por favor seleccionar un estudiante de la lista.");
			}
		} );
		
		
		
		frame.getContentPane().add(btnHistorial);
		
		//	FUNCIONALIDAD
		cargarTabla();
		DAOITR.getInstance().cargarComboBox(cBoxItr);
		
	}
	
	public void cargarTabla() {
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("Entidad");
		tableModel.addColumn("Usuario");
		tableModel.addColumn("Documento");
		tableModel.addColumn("Nombre");
		tableModel.addColumn("TIPO");
		tableModel.addColumn("ITR");
		tableModel.addColumn("ESTADO");
		tableModel.addColumn("GENERACION");
		DAOAnalista.getInstance().getBean().listarElementos().forEach(t -> {
			String valor = "";
			int estado = t.getUsuario().getEstado();
			if (estado == 0) valor = "SIN VALOR";
			else if (estado == 1)valor = "ACTIVADO";
			else if (estado == 2) valor = "ELIMINADO";
			Object[] row = {t, t.getUsuario().getMailInstitucional(), t.getUsuario().getDocumento(), t.getUsuario().getNombre() + " " + t.getUsuario().getApellido(),  "ANALISTA" , t.getUsuario().getItr(), valor};
			tableModel.addRow(row);
		});
		DAOEstudiante.getInstance().getBean().listarElementos().forEach(t -> {
			String valor = "";
			int estado = t.getUsuario().getEstado();
			if (estado == 0) valor = "SIN VALOR";
			else if (estado == 1)valor = "ACTIVADO";
			else if (estado == 2) valor = "ELIMINADO";
			Object[] row = {t, t.getUsuario().getMailInstitucional(), t.getUsuario().getDocumento(), t.getUsuario().getNombre() + " " + t.getUsuario().getApellido(), "ESTUDIANTE", t.getUsuario().getItr(), valor, t.getGeneracion()};
			tableModel.addRow(row);
		});
		DAOTutor.getInstance().getBean().listarElementos().forEach(t -> {
			String valor = "";
			int estado = t.getUsuario().getEstado();
			if (estado == 0) valor = "SIN VALOR";
			else if (estado == 1)valor = "ACTIVADO";
			else if (estado == 2) valor = "ELIMINADO";
			Object[] row = {t, t.getUsuario().getMailInstitucional(), t.getUsuario().getDocumento(), t.getUsuario().getNombre() + " " + t.getUsuario().getApellido(), "TUTOR", t.getUsuario().getItr(), valor};
			tableModel.addRow(row);
		});
		
		tablaUsu.setModel(tableModel);
		tablaUsu.getSelectionModel().addListSelectionListener(e -> {
			btnModificar.setEnabled(true);
		});
		
		for (int i = 0; i < tableModel.getColumnCount(); i++) {
			JTextField x = new JTextField();
			x.setEnabled(false);
			tablaUsu.getColumnModel().getColumn(i).setCellEditor(new DefaultCellEditor(x));
		}
		tablaUsu.removeColumn(tablaUsu.getColumnModel().getColumn(0));

	}
	
}
