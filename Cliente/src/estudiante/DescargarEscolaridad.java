package estudiante;

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

import com.bigfive.entities.EnumDepartamentos;
import com.bigfive.entities.Estudiante;
import com.bigfive.entities.Itr;
import com.bigfive.entities.Usuario;

import analista.ListaAuxITR;
import funcionalidades.DAOArea;
import utils.DatosFalsos;
import utils.Escolaridad;
import utils.TBFDownload;

public class DescargarEscolaridad {

	//Atributo
		JFrame frame = new JFrame();
		JLabel lblEsco = new JLabel("Escolaridad");
		JButton btnDes = new JButton("Descargar");
		JButton btnAtras = new JButton("Atrás");
		JLabel lblLogoUtec = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DescargarEscolaridad window = new DescargarEscolaridad();
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
	public DescargarEscolaridad() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.getContentPane().setBackground(Color.decode("#f9fafb"));  
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		//Titulo Escolariad
		lblEsco.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblEsco.setForeground(Color.decode("#08ACEC")); 
		lblEsco.setBounds(145, 24, 152, 13);
		frame.getContentPane().add(lblEsco);
		
		
		//Boton
			//Descargar
		btnDes.setBackground(Color.decode("#0284c7"));   
		btnDes.setFont(new Font("Tahona", Font.BOLD, 10));
		btnDes.setForeground(Color.decode("#f0f9ff"));
		btnDes.setBounds(197, 230, 100, 23);
		btnDes.addActionListener(e -> {
			//	Guardar Archivo
			JFileChooser fileSelector = new JFileChooser();
			int fc = fileSelector.showSaveDialog(frame);
			if (fc == JFileChooser.APPROVE_OPTION) {
				File file = fileSelector.getSelectedFile();
				System.out.println(file.getPath() + file.getName());
				escolaridad(file.getAbsolutePath());
			}

			
		});
		frame.getContentPane().add(btnDes);
		
		
			//Atras
		btnAtras.setBackground(Color.decode("#0284c7")); 
		btnAtras.setFont(new Font("Tahona", Font.BOLD, 10));
		btnAtras.setForeground(Color.decode("#f0f9ff"));
		btnAtras.setBounds(10, 230, 100, 23);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrincipalEstudiante.main(null);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnAtras);
		
		// Imagen
		lblLogoUtec.setIcon(new ImageIcon(ListaAuxITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 1, 107, 50);
		frame.getContentPane().add(lblLogoUtec);
	}
	
	
	public void escolaridad(String path) {
		Estudiante estudiante = new Estudiante();
		Usuario usuario = new Usuario();
		Itr itr = new Itr();
		
		itr.setDepartamento(EnumDepartamentos.CERRO_LARGO);
		itr.setNombre("MELO");
		
		
		usuario.setNombre(DatosFalsos.getInstance.name().firstName());
		usuario.setApellido(DatosFalsos.getInstance.name().lastName());
		usuario.setDocumento(DatosFalsos.getInstance.number().numberBetween(11111111, 99999999) + "");
		usuario.setItr(itr);
		
		estudiante.setUsuario(usuario);
		estudiante.setGeneracion(DatosFalsos.getInstance.number().numberBetween(1970, 2023) + "");
		List<Escolaridad> escoList = new ArrayList<>();
		
		DAOArea.getInstance().getBean().listarElementos().forEach(t -> {
			Escolaridad esco = new Escolaridad();
			esco.setUnidadCurricular(t.getArea());
			esco.setCredito(new Random().nextInt(4) + "");
			esco.setTipo("B");
			esco.setAnio("2022");
			esco.setConv("CUR");
			esco.setCalificacion(new Random().nextInt(100) + "");
		});
		
		try {
			TBFDownload.getInstance().generarPDF(path, estudiante, escoList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		

}

