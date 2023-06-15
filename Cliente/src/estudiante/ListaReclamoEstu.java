package estudiante;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.bigfive.entities.Estudiante;
import com.bigfive.entities.Reclamo;
import com.bigfive.entities.Usuario;

import analista.DatosUsuario;
import analista.ListaAuxITR;
import funcionalidades.FuncionalidadesReclamo;
import utils.TBFTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaReclamoEstu {

	//Atributos
	JFrame frame = new JFrame();
	JButton btnModificar;
	JLabel lblListaReclamo = new JLabel("Lista de Reclamos");
	JLabel lblEstado = new JLabel("Estado");
	JComboBox cboxEstado = new JComboBox();
	JButton btnFiltrar = new JButton("Filtrar");
	JButton btnLimpFiltro = new JButton("Limpiar Filtro");
	TBFTable tablaRe;
	Estudiante estudiante;

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
	public static void main(Estudiante estudiante) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaReclamoEstu window = new ListaReclamoEstu();
					window.estudiante = estudiante;
					window.cargarTabla();
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
		frame.getContentPane().setBackground(Color.decode("#f9fafb")); 
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		//Lista de Reclamo
		lblListaReclamo.setForeground(new Color(51, 204, 255));
		lblListaReclamo.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		lblListaReclamo.setHorizontalAlignment(SwingConstants.LEFT);
		lblListaReclamo.setBounds(123, 10, 161, 28);
		frame.getContentPane().add(lblListaReclamo);
		frame.setBounds(100, 100, 489, 512);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//Filtro Estado
		lblEstado.setBackground(Color.decode("#EEFCFF"));
		lblEstado.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblEstado.setBounds(10, 65, 45, 13);
		frame.getContentPane().add(lblEstado);
		
		
		
		cboxEstado.setBackground(Color.decode("#e5e7eb"));
		cboxEstado.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		cboxEstado.setBounds(51, 65, 119, 17);
		frame.getContentPane().add(cboxEstado);

		cboxEstado.addItem("SIN FILTRO");
		cboxEstado.addItem("SIN VALOR");
		cboxEstado.addItem("ACTIVADO");
		cboxEstado.addItem("ELIMINADO");
		
		
			//filtro
		btnFiltrar.setBackground(Color.decode("#0ea5e9"));
		btnFiltrar.setForeground(Color.decode("#f0f9ff"));
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFiltrar.setFont(new Font("Tahona", Font.BOLD, 8));
		btnFiltrar.setBounds(182, 62, 85, 21);
		frame.getContentPane().add(btnFiltrar);
		
			//limpiar filtro
		btnLimpFiltro.setBackground(Color.decode("#0ea5e9"));
		btnLimpFiltro.setFont(new Font("Tahona", Font.BOLD, 8));
		btnLimpFiltro.setForeground(Color.decode("#f0f9ff"));
		btnLimpFiltro.setBounds(277, 62, 103, 21);
		frame.getContentPane().add(btnLimpFiltro);
		btnLimpFiltro.addActionListener(e -> {
			cboxEstado.setSelectedIndex(0);
			tablaRe.limpiarFiltro();
		});
		
		
		// Tabla
		Object[][] datosReclamo = {

		};

		String[] columnasRe = { "Reclamo", "Estado"};

		tablaRe = new TBFTable(datosReclamo, columnasRe);
		
		JScrollPane scrollPaneRe = new JScrollPane(tablaRe);
		scrollPaneRe.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		scrollPaneRe.setBackground(Color.decode("#f3f4f6"));
		scrollPaneRe.setBounds(20, 97, 423, 271);
		frame.getContentPane().add(scrollPaneRe);
		
		//BOTONES
		
		//Modificar
		btnModificar = new JButton("Modificar");
		btnModificar.setEnabled(false);
		btnModificar.setToolTipText("Seleccionar usuario a modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tablaRe.getSelectedRow() > -1) {
					System.out.println(tablaRe.getValueAt(tablaRe.getSelectedRow(), 0));
					AltaReclamo.main(estudiante, (Reclamo) tablaRe.getValueAt(tablaRe.getSelectedRow(), 0));
					frame.dispose();
				}
			}
		});
		btnModificar.setBackground(Color.decode("#0284c7"));  
		btnModificar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnModificar.setForeground(Color.decode("#f0f9ff"));
		btnModificar.setBounds(261, 402, 100, 28);
		frame.getContentPane().add(btnModificar);
		
		//Eliminar
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(Color.decode("#0284c7"));  
		btnEliminar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnEliminar.setForeground(Color.decode("#f0f9ff"));
		btnEliminar.setBounds(10, 402, 100, 28);
		frame.getContentPane().add(btnEliminar);
		
		//Agregar
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AltaReclamo.main(estudiante);
			}
		});
		btnAgregar.setBackground(Color.decode("#0284c7"));  
		btnAgregar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnAgregar.setForeground(Color.decode("#f0f9ff"));
		btnAgregar.setBounds(365, 402, 100, 28);
		frame.getContentPane().add(btnAgregar);
		
		//Atras
		JButton btnAtras = new JButton("Atrás");
		btnAtras.setBackground(Color.decode("#0284c7"));  
		btnAtras.setFont(new Font("Tahona", Font.BOLD, 10));
		btnAtras.setForeground(Color.decode("#f0f9ff"));
		btnAtras.setBounds(116, 402, 100, 28);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnAtras);
		
		// Imagen
		JLabel lblLogoUtec = new JLabel("");
		lblLogoUtec.setIcon(new ImageIcon(ListaAuxITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 1, 100, 50);
		frame.getContentPane().add(lblLogoUtec);
	}

	
	public void cargarTabla() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Reclamo");
		model.addColumn("Estado");
		FuncionalidadesReclamo.getInstance().getBean().reclamosDelEstudiante(estudiante).forEach(t -> {
			Object[] row  = {t, 0};
			model.addRow(row);
		});
		tablaRe.setModel(model);
		tablaRe.getSelectionModel().addListSelectionListener(e -> {
			btnModificar.setEnabled(true);
		});
	}
}
