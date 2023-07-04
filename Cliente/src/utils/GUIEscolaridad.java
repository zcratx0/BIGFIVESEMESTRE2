package utils;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.bigfive.entities.EnumDepartamentos;
import com.bigfive.entities.Estudiante;
import com.bigfive.entities.Itr;
import com.bigfive.entities.Usuario;

import analista.ListaAuxITR;
import estudiante.DescargarEscolaridad;
import estudiante.PrincipalEstudiante;
import funcionalidades.DAOArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GUIEscolaridad {
	boolean debug = true;
	// Atributo
	JFrame frame = new JFrame();
	JLabel lblEsco = new JLabel("Escolaridad");
	JButton btnDes = new JButton("Descargar");
	JButton btnAtras = new JButton("Atrás");
	JLabel lblLogoUtec = new JLabel("");
	List<Escolaridad> escoList = new ArrayList<>();
	Estudiante estudiante = null;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIEscolaridad window = new GUIEscolaridad();
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
					GUIEscolaridad window = new GUIEscolaridad();
					window.estudiante = estudiante;
					window.debug = false;
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUIEscolaridad() {
		initialize();
	}

	private void initialize() {
		frame.getContentPane().setBackground(Color.decode("#f9fafb"));
		frame.setBounds(100, 100, 656, 475);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// Titulo Escolariad
		lblEsco.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblEsco.setForeground(Color.decode("#08ACEC"));
		lblEsco.setBounds(145, 24, 152, 13);
		frame.getContentPane().add(lblEsco);

		// Boton
		// Descargar
		btnDes.setBackground(Color.decode("#0284c7"));
		btnDes.setFont(new Font("Tahona", Font.BOLD, 10));
		btnDes.setForeground(Color.decode("#f0f9ff"));
		btnDes.setBounds(158, 402, 100, 23);
		btnDes.addActionListener(e -> {
			// Guardar Archivo
			JFileChooser fileSelector = new JFileChooser();
			int fc = fileSelector.showSaveDialog(frame);
			if (fc == JFileChooser.APPROVE_OPTION) {
				File file = fileSelector.getSelectedFile();
				if (debug)
					escolaridad(file.getAbsolutePath()); // Si no hay estudiante cargado, vamos a crear uno, esto se
															// supone es para debug
				else
					escolaridad(file.getAbsolutePath(), estudiante); // Al cargar el estudiante lo usamos
				JOptionPane.showMessageDialog(null, "Descarga Completa");
			}

		});
		frame.getContentPane().add(btnDes);

		// Atras
		btnAtras.setBackground(Color.decode("#0284c7"));
		btnAtras.setFont(new Font("Tahona", Font.BOLD, 10));
		btnAtras.setForeground(Color.decode("#f0f9ff"));
		btnAtras.setBounds(25, 402, 100, 23);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIListaEscolaridad.main(null);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnAtras);

		// Imagen
		lblLogoUtec.setIcon(new ImageIcon(ListaAuxITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 1, 107, 50);
		frame.getContentPane().add(lblLogoUtec);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 620, 319);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		DefaultTableModel tableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "UNIDAD CURRICULAR", "Créd", "Duración", "Tipo", "Año", "Conv", "Calificación" });
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(128);
		scrollPane.setViewportView(table);

		// CARGAR DATOS
		cargarListaDeEscolairdad();

		escoList.forEach(t -> {
			Object[] row = { t.getUnidadCurricular(), t.getCredito(), t.getDuracion(), t.getTipo(), t.getAnio(),
					t.getConv(), t.getCalificacion() };
			tableModel.addRow(row);

		});

	}

	public void escolaridad(String path) {
		Estudiante est = new Estudiante(); // Crear estudiante Falso
		Usuario usuario = new Usuario(); // Crear Usuario Falso
		Itr itr = new Itr(); // Crear Itr Falso

		itr.setDepartamento(EnumDepartamentos.CERRO_LARGO);
		itr.setNombre("MELO");

		usuario.setNombre(DatosFalsos.getInstance.name().firstName());
		usuario.setApellido(DatosFalsos.getInstance.name().lastName());
		usuario.setDocumento(DatosFalsos.getInstance.number().numberBetween(11111111, 99999999) + "");
		usuario.setItr(itr);

		est.setUsuario(usuario);
		est.setGeneracion(DatosFalsos.getInstance.number().numberBetween(1970, 2023) + "");

		try {
			TBFDownload.getInstance().generarPDF(path, est, escoList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void escolaridad(String path, Estudiante estudiante) {
		try {
			TBFDownload.getInstance().generarPDF(path, estudiante, escoList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void cargarListaDeEscolairdad() {
		DAOArea.getInstance().getBean().listarElementos().forEach(t -> {
			Escolaridad esco = new Escolaridad();
			esco.setUnidadCurricular(t.getArea());
			esco.setCredito((new Random().nextInt(4) + 1) + "");
			esco.setDuracion((new Random().nextInt(4)+1) + "S");
			esco.setTipo("B");
			esco.setAnio("2022");
			esco.setConv("CUR");
			esco.setCalificacion(new Random().nextInt(100) + "");
			escoList.add(esco);
		});
	}

	public JButton getBtnAtras() {
		return btnAtras;
	}

	public void setBtnAtras(JButton btnAtras) {
		this.btnAtras = btnAtras;
	}

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JLabel getLblEsco() {
		return lblEsco;
	}

	public void setLblEsco(JLabel lblEsco) {
		this.lblEsco = lblEsco;
	}

	public JButton getBtnDes() {
		return btnDes;
	}

	public void setBtnDes(JButton btnDes) {
		this.btnDes = btnDes;
	}

	public JLabel getLblLogoUtec() {
		return lblLogoUtec;
	}

	public void setLblLogoUtec(JLabel lblLogoUtec) {
		this.lblLogoUtec = lblLogoUtec;
	}

	public List<Escolaridad> getEscoList() {
		return escoList;
	}

	public void setEscoList(List<Escolaridad> escoList) {
		this.escoList = escoList;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
}
