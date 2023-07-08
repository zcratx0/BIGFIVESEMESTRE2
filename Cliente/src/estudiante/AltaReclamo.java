package estudiante;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import org.jdatepicker.JDatePanel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.bigfive.entities.Estudiante;
import com.bigfive.entities.Evento;
import com.bigfive.entities.Reclamo;
import com.bigfive.entities.Tutor;
import com.bigfive.entities.Usuario;

import analista.ListaAuxITR;
import analista.ListaReclamo;
import funcionalidades.DAOEvento;
import funcionalidades.DAOReclamo;
import funcionalidades.DAOTutor;
import utils.DateLabelFormatter;
import utils.TBFFecha;
import validaciones.Mensajes;
import validaciones.ValidacionFecha;
import validaciones.ValidacionMaxyMin;
import validaciones.ValidarInputs;
import validaciones.ValidarTipos;
import validaciones.validacionMINMAXTEXT;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.SpinnerNumberModel;

public class AltaReclamo {

	// Atributos
	JFrame frame = new JFrame();
	JLabel lblTitR = new JLabel("Reclamo");
	JLabel lblTitReclamo = new JLabel("Título *");
	JTextField tfTitReclamo = new JTextField();
	JLabel lblDescrip = new JLabel("Descripción *");
	JTextArea taDescrip = new JTextArea();
	JLabel lblNomEvento = new JLabel("Nombre del evento");
	JTextField tfNombEvento = new JTextField();
	JComboBox cBoxEvento = new JComboBox();

	JLabel lblNombAct = new JLabel("Nombre de la actividad");
	JTextField tfNombAct = new JTextField();
	JLabel lblSemestre = new JLabel("Semestre *");
	JSpinner tfSemestre = new JSpinner();
	JLabel lblFecha = new JLabel("Fecha *");
	JLabel lblDocente = new JLabel("Docente *");
	JComboBox<Tutor> cBoxDocente = new JComboBox<>();
	JLabel lblCredito = new JLabel("Crédito *");
	JSpinner tfCredito = new JSpinner();

	JButton btnConfirmar = new JButton("Confirmar");
	JButton btnCancelar = new JButton("Cancelar");
	JDatePickerImpl datePicker;
	JSpinner timeSpinner;
	boolean modificar = false;
	private final JTextField tfFech = new JTextField();
	private Reclamo reclamo;
	private Estudiante estudiante;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaReclamo window = new AltaReclamo();
					window.frame.setVisible(true);
					window.reclamo = new Reclamo();
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
					AltaReclamo window = new AltaReclamo();
					window.reclamo = new Reclamo();
					window.estudiante = estudiante;
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// MODIFICAR EL RECLAMO
	public static void main(Estudiante estudiante, Reclamo reclamo) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaReclamo window = new AltaReclamo();
					window.reclamo = reclamo;
					window.estudiante = estudiante;
					window.cargarDatos();
					window.modificar = true;
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
	public AltaReclamo() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.getContentPane().setBackground(Color.decode("#f9fafb"));
		frame.setBounds(100, 100, 515, 552);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		// Titulo
		lblTitR.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblTitR.setForeground(Color.decode("#08ACEC"));
		lblTitR.setBounds(136, 10, 282, 25);
		frame.getContentPane().add(lblTitR);

		// Titulo de Reclamo
		lblTitReclamo.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblTitReclamo.setBounds(40, 62, 112, 13);
		frame.getContentPane().add(lblTitReclamo);

		tfTitReclamo.setBounds(200, 60, 227, 19);
		tfTitReclamo.setInputVerifier(new ValidacionMaxyMin(1, 62));
		tfTitReclamo.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				ValidarInputs.ValidarSoloLetras(e);
			}
		});
		frame.getContentPane().add(tfTitReclamo);
		tfTitReclamo.setColumns(10);

		// Descripcion de Reclamo
		lblDescrip.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblDescrip.setBounds(40, 104, 112, 13);
		frame.getContentPane().add(lblDescrip);

		taDescrip.setBackground(Color.WHITE);
		taDescrip.setBounds(200, 100, 227, 60);
		taDescrip.setInputVerifier(new ValidacionMaxyMin(8, 200));
		taDescrip.setInputVerifier(new validacionMINMAXTEXT(8, 200));
		taDescrip.setLineWrap(true);

		frame.getContentPane().add(taDescrip);

		// Nombre del evento
		lblNomEvento.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblNomEvento.setBounds(40, 180, 128, 13);
		frame.getContentPane().add(lblNomEvento);

		// ComboBox Evento
		cBoxEvento.setBounds(200, 182, 227, 19);
		frame.getContentPane().add(cBoxEvento);
		cBoxEvento.addActionListener(t-> {
			if (cBoxEvento.getSelectedIndex() != 0) {
				tfNombAct.setEnabled(false);
			}
			else {
				tfNombAct.setEnabled(true);
			}
		});

		// Nombre de la actividad
		lblNombAct.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblNombAct.setBounds(40, 220, 144, 13);
		frame.getContentPane().add(lblNombAct);

		tfNombAct.setBounds(200, 222, 227, 19);
		tfNombAct.setInputVerifier(new ValidacionMaxyMin(0, 62));
		tfNombAct.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				ValidarInputs.ValidarSoloLetras(e);
			}
		});
		tfNombAct.setColumns(10);
		frame.getContentPane().add(tfNombAct);

		// Semestre
		lblSemestre.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblSemestre.setBounds(40, 260, 90, 13);
		frame.getContentPane().add(lblSemestre);
		tfSemestre.setModel(new SpinnerNumberModel(1, 1, 8, 1));

		tfSemestre.setBounds(200, 262, 227, 19);
		frame.getContentPane().add(tfSemestre);

		// Fecha
		lblFecha.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblFecha.setBounds(40, 300, 45, 13);
		frame.getContentPane().add(lblFecha);

		// FECHA
		UtilDateModel model = new UtilDateModel();
		Properties datePickerProperties = new Properties();
		datePickerProperties.put("text.today", "Hoy");
		datePickerProperties.put("text.month", "Month");
		datePickerProperties.put("text.year", "Year");

		JDatePanelImpl datePanel = new JDatePanelImpl(model, datePickerProperties);

		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		// Carga la fecha de hoy
		datePicker.getModel().setDay(LocalDateTime.now().getDayOfMonth());
		datePicker.getModel().setMonth(LocalDateTime.now().getDayOfMonth());
		datePicker.getModel().setYear(LocalDateTime.now().getYear());
		datePicker.getModel().setSelected(true);
		SpringLayout springLayout = (SpringLayout) datePicker.getLayout();
		springLayout.putConstraint(SpringLayout.SOUTH, datePicker.getJFormattedTextField(), 0, SpringLayout.SOUTH,
				datePicker);
		datePicker.setBounds(200, 292, 144, 33);
		frame.getContentPane().add(datePicker);

		// HORA
		SpinnerDateModel timeModel = new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY);
		timeSpinner = new JSpinner(timeModel);
		JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
		timeSpinner.setEditor(timeEditor);

		timeSpinner.setBounds(362, 287, 77, 38);
		frame.getContentPane().add(timeSpinner);

		// Docente
		lblDocente.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblDocente.setBounds(40, 340, 77, 13);
		frame.getContentPane().add(lblDocente);

		cBoxDocente.setBounds(200, 342, 227, 19);
		frame.getContentPane().add(cBoxDocente);
		DAOTutor.getInstance().cargarComboBox(cBoxDocente);

		// Crédito
		lblCredito.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblCredito.setBounds(40, 380, 66, 13);
		frame.getContentPane().add(lblCredito);

		tfCredito.setBounds(200, 382, 227, 19);
		tfCredito.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		frame.getContentPane().add(tfCredito);

		// Botón Confirmar
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date fechaNac;
				if (camposCompletos()) {
					Mensajes.MostrarError("Por favor, complete todos los campos necesarios antes de confirmar.");
				} else {
					Calendar cl = Calendar.getInstance();
					if (LocalDateTime.now().getYear() - datePicker.getModel().getYear() <= 0)
						if (LocalDateTime.now().getMonthValue() - datePicker.getModel().getMonth() <= 0)
							if (LocalDateTime.now().getDayOfMonth() - datePanel.getModel().getDay() <= 0) {
								Mensajes.MostrarError("Elegir una fecha del evento valida!");
								return;
							}
					int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea modificar sus datos?",
							"Confirmación de modificacion", JOptionPane.YES_NO_OPTION);
					if (confirmacion == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null, "Reclamo actualizado!");
						guardarCambios();
					}

				}
			}
		});
		btnConfirmar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnConfirmar.setBackground(Color.decode("#0284c7"));
		btnConfirmar.setForeground(Color.decode("#f0f9ff"));
		btnConfirmar.setBounds(362, 446, 104, 38);
		frame.getContentPane().add(btnConfirmar);

		// Boton Cancelar
		btnCancelar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnCancelar.setBackground(Color.decode("#0284c7"));
		btnCancelar.setForeground(Color.decode("#f0f9ff"));
		btnCancelar.setBounds(210, 446, 104, 38);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea salir sin guardar cambios?",
						"Confirmación de modificacion", JOptionPane.YES_NO_OPTION);
				if (confirmacion == JOptionPane.YES_OPTION) {
					ListaReclamoEstu.main(estudiante);
					frame.dispose();
				}
			}
		});
		frame.getContentPane().add(btnCancelar);

		// Imagen
		JLabel lblLogoUtec = new JLabel("");
		lblLogoUtec.setIcon(new ImageIcon(ListaAuxITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 1, 107, 50);
		frame.getContentPane().add(lblLogoUtec);

		// Cargar Datos
		DAOEvento.getInstance().getBean().actualizar();
		DAOEvento.getInstance().cargarComboBox(cBoxEvento);
		DAOTutor.getInstance().cargarComboBox(cBoxDocente);

	}

	public void guardarCambios() {
		reclamo.setDetalle(taDescrip.getText());
		reclamo.setEstudiante(estudiante);
		reclamo.setTitulo(tfTitReclamo.getText());
		reclamo.setSemestre(tfSemestre.getValue() + "");
		reclamo.setTutor((Tutor) cBoxDocente.getSelectedItem());
		reclamo.setCredito((Integer) tfCredito.getValue());
		if (cBoxEvento.getSelectedIndex() == 0) {
			reclamo.setNombreActividad(tfNombAct.getText());
		}
		else {
			reclamo.setEvento((Evento) cBoxEvento.getSelectedItem());
			DAOEvento.getInstance().getBean().modificar(reclamo.getEvento());
		}

		try {
			// Fecha del registro
			LocalDateTime fechaRegistro = LocalDateTime.now();
			reclamo.setFechaRegistro(
					(Date) new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS").parse(fechaRegistro.toString()));
			System.out.println("Fecha Registro: " + fechaRegistro.toString());

			// Fecha del Reclamo
			Date fechaNac = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(datePicker.getModel().getDay() + "/"
					+ datePicker.getModel().getMonth() + "/" + datePicker.getModel().getYear() + " "
					+ new SimpleDateFormat("HH:mm").format(timeSpinner.getModel().getValue()));
			System.out.println("Fecha Reclamo: " + fechaNac);
			reclamo.setFechaHora(fechaNac);

			// Fecha de Modificación
			System.out.println("Fecha Evento: " + fechaNac);
			Mensajes.MostrarExito("Se ha guardado correctamente");

		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		reclamo.setHabilitado(true);
		if (modificar) {
			DAOReclamo.getInstance().getBean().modificar(reclamo);
		} else {
			if (tfNombAct.getText().isEmpty())
				DAOReclamo.getInstance().getBean().agregarReclamo(reclamo, (Evento) cBoxEvento.getSelectedItem());
			else
				DAOReclamo.getInstance().getBean().crear(reclamo);
		}

		ListaReclamoEstu.main(estudiante);
		frame.dispose();

	}

	public void cargarDatos() {
		if (reclamo.getFechaHora() != null) {
			Calendar calendario = Calendar.getInstance();
			calendario.setTime(reclamo.getFechaHora());
			datePicker.getModel().setDate(calendario.get(Calendar.YEAR), calendario.get(Calendar.MONTH),
					calendario.get(Calendar.DAY_OF_MONTH));
			// TODO Terminar esto timeSpinner.setValue(reclamo.getFechaHora());
		}
		if (reclamo.getTitulo() != null)
			tfTitReclamo.setText(reclamo.getTitulo());
		if (reclamo.getDetalle() != null)
			taDescrip.setText(reclamo.getDetalle());
		if (reclamo.getSemestre() != null)
			tfSemestre.setValue(Integer.parseInt(reclamo.getSemestre()));
		if (reclamo.getNombreActividad() != null)
			tfNombAct.setText(reclamo.getNombreActividad());
		if (reclamo.getCredito() != null)
			tfCredito.setValue(reclamo.getCredito());

	}

	// validar que todos los campos esten llenos antes de guardar
	private boolean camposCompletos() {
		return tfTitReclamo.getText().isEmpty();

	}

	// TODO Modificar esta validacion
	private boolean camposActEven() {
		return (!tfNombAct.getText().isEmpty() && !tfNombEvento.getText().isEmpty())
				|| (tfNombAct.getText().isEmpty() && tfNombEvento.getText().isEmpty());
	}
}
