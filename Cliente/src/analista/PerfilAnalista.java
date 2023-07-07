package analista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.bigfive.entities.EnumDepartamentos;
import com.bigfive.entities.Genero;
import com.bigfive.entities.Itr;
import com.bigfive.entities.Usuario;

import funcionalidades.DAODepartamento;
import funcionalidades.DAOGenero;
import funcionalidades.DAOITR;
import funcionalidades.DAOUsuario;
import validaciones.ValidacionContrasenia;
import validaciones.ValidacionEmailInsti;
import validaciones.ValidacionEmailPersonal;
import validaciones.ValidacionFecha;
import validaciones.ValidacionMaxyMin;
import validaciones.ValidacionTelefono;
import validaciones.ValidarInputs;

public class PerfilAnalista extends JPanel {

	JFrame frame = new JFrame();
	JLabel lblTitPerfil = new JLabel("Perfil");
	JLabel lblNombre = new JLabel("Nombres");
	JTextField tfNombre = new JTextField();
	JLabel lblApellido = new JLabel("Apellidos");
	JTextField tfApellido = new JTextField();
	JLabel lblCI = new JLabel("Cédula");
	JLabel lblFecNac = new JLabel("Fecha de Nacimiento");
	JTextField tfDocumento = new JTextField();
	JTextField tfMailPer = new JTextField();
	JLabel lblMailP = new JLabel("Email Personal");
	JLabel lblTel = new JLabel("Teléfono");
	JLabel lblLoc = new JLabel("Localidad");
	JTextField tfLoca = new JTextField();
	JLabel lblDepa = new JLabel("Departamento");
	JComboBox cBoxDepa = new JComboBox();
	JLabel lblMailIns = new JLabel("Email Institucional");
	JTextField tfMailInst = new JTextField();
	JLabel lblContra = new JLabel("Contraseña");
	JPasswordField pasFContra = new JPasswordField();
	JLabel lblITR = new JLabel("ITR");
	JComboBox cBoxITR = new JComboBox();
	JButton btnConfirmar = new JButton("Confirmar");
	JButton btnCancelar = new JButton("Cancelar");
	JTextField tfTel = new JTextField();
	private final JTextField tfFechaNac = new JTextField();
	private final JLabel lblGenero = new JLabel("Genero");
	JComboBox cBoxGenero = new JComboBox();
	Usuario usuario = null;
	private Date nac;
	private SimpleDateFormat format;




public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				PerfilAnalista window = new PerfilAnalista();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}

public static void mostrarPerfilAnalista(Usuario usuario) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				PerfilAnalista window = new PerfilAnalista();
				window.cargarDatosAnalista(usuario);
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
public PerfilAnalista() {
	
	initialize();
}

/**
 * Initialize the contents of the frame.
 */
private void initialize() {
	frame.getContentPane().setBackground(Color.decode("#f9fafb"));  
	frame.setBounds(100, 30, 417, 650);
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	frame.setResizable(false);

	format = new SimpleDateFormat("dd-MM-yyyy");
	
	lblTitPerfil.setForeground(Color.decode("#08ACEC"));  
	lblTitPerfil.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
	lblTitPerfil.setBounds(119, 1, 168, 29);
	frame.getContentPane().add(lblTitPerfil);
	
		
	lblNombre.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	lblNombre.setBounds(10, 52, 80, 13);
	frame.getContentPane().add(lblNombre);
	
	tfNombre.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	tfNombre.setBounds(142, 49, 219, 19);
	frame.getContentPane().add(tfNombre);
	tfNombre.setColumns(10);
	tfNombre.setInputVerifier(new ValidacionMaxyMin(2,32));
	tfNombre.addKeyListener(new KeyAdapter() {
		public void keyTyped(KeyEvent e) {
			ValidarInputs.ValidarSoloLetras(e);
		}
	}); 
	
	
	
	lblApellido.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	lblApellido.setBounds(10, 92, 80, 13);
	frame.getContentPane().add(lblApellido);
	
	
	tfApellido.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	tfApellido.setText("");
	tfApellido.setBounds(142, 89, 219, 19);
	frame.getContentPane().add(tfApellido);
	tfApellido.setColumns(10);
	tfApellido.setInputVerifier(new ValidacionMaxyMin(2,32));
	tfApellido.addKeyListener(new KeyAdapter() {
	public void keyTyped(KeyEvent e) {
			ValidarInputs.ValidarSoloLetras(e);
		}
	}); 
	
	
	lblCI.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	lblCI.setBounds(10, 139, 80, 13);
	frame.getContentPane().add(lblCI);
	
	tfDocumento.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	tfDocumento.setBounds(142, 136, 219, 19);
	frame.getContentPane().add(tfDocumento);
	tfDocumento.setColumns(10);
	tfDocumento.addKeyListener(new KeyAdapter () {
		public void keyTyped(KeyEvent e) {
			ValidarInputs.ValidarSoloNumeros(e);;
		}
	});
	
	
	tfDocumento.setInputVerifier(new ValidacionMaxyMin(8,8));
	
	
	
	
	lblFecNac.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	lblFecNac.setBounds(10, 181, 146, 13);
	frame.getContentPane().add(lblFecNac);
	
	tfFechaNac.setBounds(142, 178, 219, 19);
	tfFechaNac.setColumns(10);
	frame.getContentPane().add(tfFechaNac);
	
	tfFechaNac.setInputVerifier(new ValidacionFecha());
	
	
	lblMailP.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	lblMailP.setBounds(10, 216, 113, 13);
	frame.getContentPane().add(lblMailP);

	tfMailPer.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	tfMailPer.setBounds(142, 213, 219, 19);
	frame.getContentPane().add(tfMailPer);
	tfMailPer.setColumns(10);
	tfMailPer.setInputVerifier(new ValidacionEmailPersonal());
	
	
	lblTel.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	lblTel.setBounds(10, 261, 45, 13);
	frame.getContentPane().add(lblTel);
	
	tfTel.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	tfTel.setBounds(142, 258, 219, 19);
	frame.getContentPane().add(tfTel);
	tfTel.setColumns(10);
	
	tfTel.setInputVerifier(new ValidacionTelefono());
	
	
	lblLoc.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	lblLoc.setBounds(10, 302, 122, 13);
	frame.getContentPane().add(lblLoc);
	
	tfLoca.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	tfLoca.setBounds(142, 299, 219, 19);
	frame.getContentPane().add(tfLoca);
	tfLoca.setColumns(10);
	tfLoca.addKeyListener(new KeyAdapter() {
		public void keyTyped(KeyEvent e) {
			ValidarInputs.ValidarSoloLetras(e);
		}
	}); 
	tfLoca.setInputVerifier(new ValidacionMaxyMin(2,24));
	
	
	
	lblDepa.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	lblDepa.setBounds(10, 344, 113, 13);
	frame.getContentPane().add(lblDepa);
	
	cBoxDepa.setBounds(142, 340, 219, 21);
	cBoxDepa.setBackground(Color.decode("#e5e7eb"));
	frame.getContentPane().add(cBoxDepa);
	
	
	lblMailIns.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	lblMailIns.setBounds(10, 385, 132, 13);
	frame.getContentPane().add(lblMailIns);
	
	tfMailInst.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	tfMailInst.setText("");
	tfMailInst.setBounds(142, 382, 219, 19);
	frame.getContentPane().add(tfMailInst);
	tfMailInst.setColumns(10);
	tfMailInst.setInputVerifier(new ValidacionEmailInsti());
	
	tfMailInst.setEnabled(false);
	
	
	lblContra.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	lblContra.setBounds(10, 430, 113, 13);
	frame.getContentPane().add(lblContra);
	
	pasFContra.setBounds(142, 427, 219, 19);
	pasFContra.setInputVerifier(new ValidacionContrasenia (8));
	frame.getContentPane().add(pasFContra);

	
	
	
	lblITR.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	lblITR.setBounds(10, 476, 45, 13);
	frame.getContentPane().add(lblITR);
	
	cBoxITR.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	cBoxITR.setBackground(Color.decode("#e5e7eb"));
	cBoxITR.setBounds(142, 472, 219, 21);
	frame.getContentPane().add(cBoxITR);
	
	
	lblGenero.setBounds(10, 515, 65, 13);
	lblGenero.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
	frame.getContentPane().add(lblGenero);
	
	cBoxGenero.setBounds(142, 511, 219, 21);
	frame.getContentPane().add(cBoxGenero);

	
	
	btnConfirmar.setBackground(Color.decode("#0284c7")); 
	btnConfirmar.setFont(new Font("Tahona", Font.BOLD, 10)); 
	btnConfirmar.setForeground(Color.decode("#f0f9ff"));
	btnConfirmar.setBounds(249, 563, 112, 40);
	btnConfirmar.addActionListener(e -> {

		if (camposCompletos()) {
			int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea modificar sus datos?",
					"Confirmación de modificacion", JOptionPane.YES_NO_OPTION);
			if (confirmacion == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(null,
						"Los datos se actualizaron correctamente.\nPor favor reinicie la sesión para cargar los datos actualizados.");
				guardarCambios(usuario);
				frame.dispose();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos antes de guardar.");
		}
	});
	frame.getContentPane().add(btnConfirmar);
	
	
	btnCancelar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int opcion = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea cancelar?", "Confirmacion", JOptionPane.YES_NO_OPTION);
			if (opcion == JOptionPane.YES_OPTION) {
				frame.dispose();
			}
			
		}
	});
	btnCancelar.setBackground(Color.decode("#0284c7"));
	btnCancelar.setFont(new Font("Tahona", Font.BOLD, 10)); 
	btnCancelar.setForeground(Color.decode("#f0f9ff"));
	btnCancelar.setBounds(114, 563, 112, 40);
    frame.getContentPane().add(btnCancelar);

	
	
	JLabel lblLogoUtec = new JLabel("");
	lblLogoUtec.setIcon(new ImageIcon(ListaAuxITR.class.getResource("/img/LogoUTEC30x30.png")));
	lblLogoUtec.setBounds(25, 1, 107, 50);
	frame.getContentPane().add(lblLogoUtec);
	
	
	DAODepartamento.getInstance().cargarComboBox(cBoxDepa);
	DAOGenero.getInstance().cargarComboBox(cBoxGenero);
	
}
	public void cargarDatosAnalista(Usuario usuario) {
		this.usuario = usuario;
		DAODepartamento.getInstance().cargarComboBox(cBoxDepa);
		DAOITR.getInstance().cargarComboBoxHabilitado(cBoxITR);
		if (usuario.getNombre() != null) tfNombre.setText(usuario.getNombre());
		if (usuario.getApellido() != null) tfApellido.setText(usuario.getApellido());
		if (usuario.getDocumento() != null) tfDocumento.setText(usuario.getDocumento());
		if (usuario.getFechaNacimiento() != null) tfFechaNac.setText(new SimpleDateFormat("dd/MM/YYYY").format(usuario.getFechaNacimiento()));
		if (usuario.getMail() != null) tfMailPer.setText(usuario.getMail());
		if (usuario.getTelefono() != null) tfTel.setText(usuario.getTelefono());
		if (usuario.getLocalidad() != null) tfLoca.setText(usuario.getLocalidad());
		if (usuario.getDepartamentos() != null) cBoxDepa.setSelectedItem(usuario.getDepartamentos());
		if (usuario.getMailInstitucional() != null) tfMailInst.setText(usuario.getMailInstitucional());
		if (usuario.getContrasenia() != null) pasFContra.setText(usuario.getContrasenia());
		if (usuario.getItr() != null) {
			for (int i = 0; i < cBoxITR.getItemCount(); i++) {
				Itr g = (Itr) cBoxITR.getItemAt(i);
				if (g.getNombre().equalsIgnoreCase(usuario.getItr().getNombre())) {
					cBoxITR.setSelectedIndex(i);
					i = cBoxITR.getItemCount() + 1;
				}
			}
		}
		if (usuario.getGenero() != null) {
			for (int i = 0; i < cBoxGenero.getItemCount(); i++) {
				Genero g = (Genero) cBoxGenero.getItemAt(i);
				if (g.getGenero().equalsIgnoreCase(usuario.getGenero().getGenero())) {
					cBoxGenero.setSelectedIndex(i);
					i = cBoxGenero.getItemCount() + 1;
				}
			}
		}
		
		
	}
	public void guardarCambios(Usuario usuario) {
		try {
			Date fechaNac = new SimpleDateFormat("dd/mm/yyyy").parse(tfFechaNac.getText());
			System.out.println(fechaNac);
			usuario.setFechaNacimiento(fechaNac);
		} catch (ParseException e1) {	e1.printStackTrace();	}
		
		usuario.setNombre(tfNombre.getText());
		usuario.setApellido(tfApellido.getText());
		usuario.setDocumento(tfDocumento.getText());
		usuario.setMail(tfMailPer.getText());
		usuario.setMailInstitucional(tfMailInst.getText());
		usuario.setTelefono(tfTel.getText());
		usuario.setDepartamentos( (EnumDepartamentos)cBoxDepa.getSelectedItem());
		usuario.setLocalidad(tfLoca.getText());
		usuario.setContrasenia(new String(pasFContra.getPassword()));
		usuario.setItr((Itr) cBoxITR.getSelectedItem());
		usuario.setGenero((Genero) cBoxGenero.getSelectedItem());
		
		try {
			DAOGenero.getInstance().getBean().modificar(usuario.getGenero());
			DAOITR.getInstance().getItrBean().modificar(usuario.getItr());
			System.out.println(usuario.getItr() + " " + usuario.getGenero());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		DAOUsuario.getInstance().getBean().modificar(usuario);
		
		
		
	}
	
	
	public boolean camposCompletos() {
	    return !tfNombre.getText().isEmpty()
	            && !tfApellido.getText().isEmpty()
	            && !tfDocumento.getText().isEmpty()
	            && !tfMailPer.getText().isEmpty()
	            && !tfMailInst.getText().isEmpty()
	            && !tfTel.getText().isEmpty()
	            && cBoxDepa.getSelectedItem() != null
	            && !tfLoca.getText().isEmpty()
	            && pasFContra.getPassword().length > 0
	            && cBoxITR.getSelectedItem() != null;
	}
	
}
