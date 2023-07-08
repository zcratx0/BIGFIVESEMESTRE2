package analista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.bigfive.entities.Analista;
import com.bigfive.entities.Estudiante;
import com.bigfive.entities.Reclamo;

import funcionalidades.DAOEstado;
import funcionalidades.DAOReclamo;
import utils.GUIEscolaridad;
import utils.TBFTable;

import javax.swing.JComboBox;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class ListaReclamo {
	
	ListaReclamo instane;
	// Atributos
	JFrame frame = new JFrame();
	JLabel lblTitListRec = new JLabel("Lista de Reclamos");
	JLabel lblNombre = new JLabel("Nombre");
	JTextField tfNombre = new JTextField();
	JLabel lblEstado = new JLabel("Estado");
	JComboBox cBoxEstado = new JComboBox();
	JButton btnFiltrar = new JButton("Filtrar");
	JButton btnLimpiarF = new JButton("Limpiar Filtro");
	JButton btnRegAcc = new JButton("Registrar Acción");
	JButton btnAtras = new JButton("Atrás");
	JButton btnVer = new JButton("Ver");
	TBFTable tablaRe;
	Analista analista = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaReclamo window = new ListaReclamo();
					window.cargarTabla();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Cargar reclamos de todos los estudiantes
	 */
	public static void main(Analista analista) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaReclamo window = new ListaReclamo();
					window.cargarTabla();
					window.analista = analista;
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Cargar reclamos de un estudiante
	 */
	public static void main(Estudiante estudiante, Analista analista) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaReclamo window = new ListaReclamo();
					window.cargarTablaEstudiante(estudiante);
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
	public ListaReclamo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.getContentPane().setBackground(Color.decode("#f9fafb"));
		frame.setBounds(100, 100, 536, 519);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		// Titulo
		lblTitListRec.setForeground(Color.decode("#08ACEC"));
		lblTitListRec.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblTitListRec.setBounds(129, 10, 268, 13);
		frame.getContentPane().add(lblTitListRec);

		// Nombre
		lblNombre.setBounds(26, 50, 73, 19);
		lblNombre.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		frame.getContentPane().add(lblNombre);

		tfNombre.setBounds(86, 50, 356, 19);
		frame.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);

		// Estado
		lblEstado.setBounds(26, 96, 45, 13);
		lblEstado.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		frame.getContentPane().add(lblEstado);

		cBoxEstado.setBackground(Color.decode("#e5e7eb"));
		cBoxEstado.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		cBoxEstado.setBounds(86, 92, 98, 21);
		frame.getContentPane().add(cBoxEstado);

		// Filtro
		btnFiltrar.setBackground(Color.decode("#0ea5e9"));
		btnFiltrar.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		btnFiltrar.setForeground(Color.decode("#f0f9ff"));
		btnFiltrar.setBounds(194, 92, 105, 21);
		frame.getContentPane().add(btnFiltrar);
		btnFiltrar.addActionListener(e -> {
			// FILTRO
			DefaultTableModel dtm = (DefaultTableModel) tablaRe.getModel();
			TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(dtm);
			tablaRe.setRowSorter(sorter);
			List<RowFilter<Object, Object>> filtros = new ArrayList<>();

			if (!cBoxEstado.getSelectedItem().toString().equalsIgnoreCase("SIN FILTRO"))
				filtros.add(RowFilter.regexFilter(cBoxEstado.getSelectedItem().toString(), 4));
			if (!tfNombre.getText().isEmpty())
				filtros.add(RowFilter.regexFilter("(?i)" + Pattern.quote(tfNombre.getText()), 2));

			sorter.setRowFilter((RowFilter<Object, Object>) RowFilter.andFilter(filtros));

		});

		// Limpiar filtro
		btnLimpiarF.setBackground(Color.decode("#0ea5e9"));
		btnLimpiarF.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		btnLimpiarF.setForeground(Color.decode("#f0f9ff"));
		btnLimpiarF.setBounds(309, 92, 133, 21);
		frame.getContentPane().add(btnLimpiarF);
		btnLimpiarF.addActionListener(e -> {
			DefaultTableModel dtm = (DefaultTableModel) tablaRe.getModel();
			TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(dtm);
			tablaRe.setRowSorter(sorter);
			sorter.setRowFilter(RowFilter.regexFilter(""));

		});
		// Tabla
		Object[][] datosReclamo = {

		};

		String[] columnasRe = { "Usuario", "Estado" };

		tablaRe = new TBFTable(datosReclamo, columnasRe);
		JScrollPane scrollPaneRe = new JScrollPane(tablaRe);
		scrollPaneRe.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		scrollPaneRe.setBackground(Color.decode("#f3f4f6"));
		scrollPaneRe.setBounds(26, 157, 482, 255);
		frame.getContentPane().add(scrollPaneRe);

		// Botones

		// Registrar Accion
		btnRegAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tablaRe.getSelectedRow() > -1) {
					if (tablaRe.getModel().getValueAt(tablaRe.getSelectedRow(), 0) instanceof Reclamo) {
						Reclamo reclamo = (Reclamo) tablaRe.getModel().getValueAt(tablaRe.getSelectedRow(), 0);
						if (analista != null)
							RegistroAccReclamo.main(analista, reclamo);
						else
							RegistroAccConstancias.main(null);
					}
				}
			}
		});
		btnRegAcc.setFont(new Font("Tahona", Font.BOLD, 10));
		btnRegAcc.setForeground(Color.decode("#f0f9ff"));
		btnRegAcc.setBackground(Color.decode("#0284c7"));
		btnRegAcc.setBounds(345, 445, 152, 27);
		frame.getContentPane().add(btnRegAcc);

		// Atras
		btnAtras.setFont(new Font("Tahona", Font.BOLD, 10));
		btnAtras.setForeground(Color.decode("#f0f9ff"));
		btnAtras.setBackground(Color.decode("#0284c7"));
		btnAtras.setBounds(224, 445, 85, 27);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// PrincipalAnalista.main(null);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnAtras);

		// Imagen
		JLabel lblLogoUtec = new JLabel("");
		lblLogoUtec.setIcon(new ImageIcon(ListaAuxITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 1, 107, 50);
		frame.getContentPane().add(lblLogoUtec);

		// Botón Ver Reclamo
		btnVer = new JButton("Ver");
		btnVer.setForeground(new Color(240, 249, 255));
		btnVer.setFont(new Font("Dialog", Font.BOLD, 10));
		btnVer.setBackground(new Color(2, 132, 199));
		btnVer.setBounds(26, 445, 85, 27);
		frame.getContentPane().add(btnVer);

		btnVer.addActionListener(e -> {
			if (tablaRe.getSelectedRow() > -1) {
				if (tablaRe.getModel().getValueAt(tablaRe.getSelectedRow(), 0) instanceof Reclamo) {
					Reclamo reclamo = (Reclamo) tablaRe.getModel().getValueAt(tablaRe.getSelectedRow(), 0);
					mostrarReclamo(reclamo);
				}
			}
		});

		// CARGAR DATOS
		cBoxEstado.addItem("SIN FILTRO");
		cBoxEstado.addItem("INGRESADO");
		DAOEstado.getInstance().cargarComboBox(cBoxEstado);

	}

	public void cargarTabla() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Reclamo");
		model.addColumn("Titulo");
		model.addColumn("Estudiante");
		model.addColumn("Fecha");
		model.addColumn("Estado");

		DAOReclamo.getInstance().getBean().listarElementos().forEach(r -> {
			String fecha = r.getFechaHora() != null ? new SimpleDateFormat("dd/MM/yyyy HH:mm").format(r.getFechaHora())
					: "FECHA";
			String titulo = r.getTitulo() != null ? r.getTitulo() : "TITULO";
			String estu = r.getEstudiante().getUsuario().getNombre() + " "
					+ r.getEstudiante().getUsuario().getApellido();
			String estado = "INGRESADO";
			if (r.getEstado() != null)
				estado = r.getEstado().getNombre();
			Object[] row = { r, titulo, estu, fecha, estado };
			model.addRow(row);
		});
		tablaRe.setModel(model);
		tablaRe.getSelectionModel().addListSelectionListener(e -> {
			btnRegAcc.setEnabled(true);
		});

		for (int i = 0; i < model.getColumnCount(); i++) {
			JTextField x = new JTextField();
			x.setEnabled(false);
			tablaRe.getColumnModel().getColumn(i).setCellEditor(new DefaultCellEditor(x));
		}
		tablaRe.removeColumn(tablaRe.getColumnModel().getColumn(0));
	}

	public void cargarTablaEstudiante(Estudiante estudiante) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Reclamo");
		model.addColumn("Titulo");
		model.addColumn("Estudiante");
		model.addColumn("Fecha");
		model.addColumn("Estado");
		DAOReclamo.getInstance().getBean().reclamosDelEstudiante(estudiante).forEach(t -> {
			String fecha = t.getFechaHora() != null ? new SimpleDateFormat("dd/MM/yyyy HH:mm").format(t.getFechaHora())
					: "FECHA";
			String titulo = t.getTitulo() != null ? t.getTitulo() : "TITULO";
			String estu = t.getEstudiante().getUsuario().getNombre() + " "
					+ t.getEstudiante().getUsuario().getApellido();

			String estado = "EN PROCESO";
			if (t.getEstado() != null)
				estado = t.getEstado().getNombre();
			Object[] row = { t, titulo, estu, fecha, estado };
			model.addRow(row);
		});
		tablaRe.setModel(model);
		tablaRe.getSelectionModel().addListSelectionListener(e -> {
			btnRegAcc.setEnabled(true);
		});

		for (int i = 0; i < model.getColumnCount(); i++) {
			JTextField x = new JTextField();
			x.setEnabled(false);
			tablaRe.getColumnModel().getColumn(i).setCellEditor(new DefaultCellEditor(x));
		}
		tablaRe.removeColumn(tablaRe.getColumnModel().getColumn(0));
	}

	private void mostrarReclamo(Reclamo reclamo) {
		JPanel panel = new JPanel(new GridLayout(0, 1, 5, 5));
		JLabel estudiante = new JLabel("Estudiante: " + reclamo.getEstudiante().getUsuario().getNombre() + " "
				+ reclamo.getEstudiante().getUsuario().getApellido());
		panel.add(estudiante);
		JLabel cedula = new JLabel("Documento: " + reclamo.getEstudiante().getUsuario().getDocumento());
		panel.add(cedula);

		JLabel mail = new JLabel("Mail: " + reclamo.getEstudiante().getUsuario().getMailInstitucional());
		panel.add(mail);

		JLabel titulo = new JLabel("Titulo: " + reclamo.getTitulo());
		panel.add(titulo);

		JLabel fecha = new JLabel("Fecha registro: " + reclamo.getFechaRegistro());
		panel.add(fecha);
		JLabel fechaActividad = new JLabel("Fecha actividad: " + reclamo.getFechaHora());
		panel.add(fechaActividad);
		if (reclamo.getNombreActividad() == null || reclamo.getNombreActividad().isEmpty()) {
			JLabel evento = new JLabel("Evento: " + reclamo.getEvento().getTitulo());
			panel.add(evento);

			JLabel fechaEvento = new JLabel("Evento: " + reclamo.getEvento().getFechaHoraIncio());
			panel.add(fechaEvento);

			JLabel fechaEventoFinal = new JLabel("Evento: " + reclamo.getEvento().getFechaHoraFinal());
			panel.add(fechaEventoFinal);

		} else {
			JLabel actividad = new JLabel("Evento: " + reclamo.getNombreActividad());
			panel.add(actividad);
		}
		JLabel semestre = new JLabel("Semestre: " + reclamo.getSemestre());
		panel.add(semestre);

		JLabel credito = new JLabel("Credito: " + reclamo.getCredito());
		panel.add(credito);

		JLabel descr = new JLabel("Descripción: " + reclamo.getDetalle());
		panel.add(descr);

		JOptionPane.showMessageDialog(null, panel);
	}

}
