package analista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.bigfive.entities.Usuario;

import funcionalidades.DAOAnalista;
import funcionalidades.DAOEstudiante;
import funcionalidades.DAOTutor;
import funcionalidades.DAOUsuario;

public class HabilitacionUsuario {

	// Atributos
	JFrame frame = new JFrame();
	JLabel lblTitHabUsu = new JLabel("Habilitación de Usuarios");
	JLabel lblVerMas = new JLabel("Ver Más");
	JButton btnAtras = new JButton("Atrás");
	JButton btnListUsu = new JButton("Lista de Usuarios");
	JTable tablaEst;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HabilitacionUsuario window = new HabilitacionUsuario();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void mostrar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HabilitacionUsuario window = new HabilitacionUsuario();
					window.cargarListaDeUsuarios();
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
	public HabilitacionUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.getContentPane().setBackground(Color.decode("#f9fafb"));
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 753, 423);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);

		// Imagen
		JLabel lblLogoUtec = new JLabel("");
		lblLogoUtec.setIcon(new ImageIcon(AgregarITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 0, 107, 50);
		frame.getContentPane().add(lblLogoUtec);

		// Titulo Habilitación de Usuarios
		lblTitHabUsu.setForeground(Color.decode("#08ACEC"));
		lblTitHabUsu.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblTitHabUsu.setBounds(201, 10, 411, 29);
		frame.getContentPane().add(lblTitHabUsu);

		// Ver mas
		lblVerMas.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblVerMas.setBounds(554, 10, 65, 13);

		// Tabla
		Object[][] datosEst = {

		};

		String[] columnasEst = { "Usuario", "Tipo de Usuarios", "ITR", "Generación", "Estado", "Información" };

		tablaEst = new JTable(datosEst, columnasEst);
		JScrollPane scrollPaneEst = new JScrollPane(tablaEst);
		scrollPaneEst.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		scrollPaneEst.setBackground(Color.decode("#f3f4f6"));
		scrollPaneEst.setBounds(34, 77, 667, 236);
		frame.getContentPane().add(scrollPaneEst);

		// Botones
		// Atras
		btnAtras.setFont(new Font("Tahona", Font.BOLD, 10));
		btnAtras.setForeground(Color.decode("#f0f9ff"));
		btnAtras.setBackground(Color.decode("#0284c7"));
		btnAtras.setBounds(434, 333, 89, 29);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// PrincipalAnalista.main(null);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnAtras);

		// Lista de Usuarios
		btnListUsu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaUsuarios.main();
				frame.dispose();
			}
		});
		btnListUsu.setFont(new Font("Tahona", Font.BOLD, 10));
		btnListUsu.setForeground(Color.decode("#f0f9ff"));
		btnListUsu.setBackground(Color.decode("#0284c7"));
		btnListUsu.setBounds(562, 333, 139, 29);
		frame.getContentPane().add(btnListUsu);
	}

	public void cargarListaDeUsuarios() {

		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("Usuario");
		tableModel.addColumn("Tipo de Usuarios");
		tableModel.addColumn("ITR");
		tableModel.addColumn("Generación");
		tableModel.addColumn("Estado");
		tableModel.addColumn("Información");
		tablaEst.setModel(tableModel);

		JComboBox cbEstado = new JComboBox<>();
		cbEstado.addItem("SIN VALOR");
		cbEstado.addItem("ACTIVADO");
		cbEstado.addItem("ELIMINADO");
		
		
		
		tableModel.addTableModelListener(e -> {
			if (e.getType() == 0) {
				System.out.println(e.getColumn() + " "+ e.getFirstRow());
				System.out.println();
				String value = (String)tableModel.getValueAt(e.getFirstRow(), e.getColumn());
				Usuario usuario = (Usuario)tablaEst.getValueAt(e.getFirstRow(), 0);
				int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de cambiar el Estado?", "Cambio de estado", JOptionPane.YES_NO_OPTION);
				 if (confirmacion == JOptionPane.YES_OPTION  ) {
					if (value.equalsIgnoreCase("SIN VALOR")) {
						usuario.setEstado(0);
					}
					else if (value.equalsIgnoreCase("ACTIVADO")) {
						usuario.setEstado(1);
					}
					else if (value.equalsIgnoreCase("ELIMINADO")) {
						usuario.setEstado(2);
					}else {
						tablaEst.setValueAt("SIN VALOR",e.getFirstRow(), 4);
					}
					DAOUsuario.getInstance().getBean().habilitarUsuario(usuario);
				}
				 cargarListaDeUsuarios();
				
			}
		} );
		
		tablaEst.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(cbEstado));
		DAOEstudiante.getInstance().getBean().listarElementos().forEach(t -> {
			if (t.getUsuario().getEstado() == 0) {
				Object[] row = { t.getUsuario(), "ESTUDIANTE", t.getUsuario().getItr(), t.getGeneracion(),
						 cbEstado.getItemAt(0), "INFORMACION" };
				tableModel.addRow(row);
			}
		});
		DAOAnalista.getInstance().getBean().listarElementos().forEach(t -> {

			if (t.getUsuario().getEstado() == 0) {
				Object[] row = { t.getUsuario(), "ANALISTA", "", "GENERACION", "SIN VALOR",
						"INFORMACION" };
				tableModel.addRow(row);
			}
		});

		DAOTutor.getInstance().getBean().listarElementos().forEach(t -> {

			if (t.getUsuario().getEstado() == 0) {
				Object[] row = { t.getUsuario(), "TUTOR", "", "GENERACION", "SIN VALOR",
						"INFORMACION" };
				tableModel.addRow(row);
			}
		});
	}
}
