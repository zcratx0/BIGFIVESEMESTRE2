
package analista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import com.bigfive.entities.Departamento;
import com.bigfive.entities.Itr;

import funcionalidades.DAODepartamento;
import funcionalidades.DAOITR;

import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

public class AgregarITR {

	//Atributo
	JFrame frame = new JFrame();
	JLabel lblAgregarITR = new JLabel("ITR");
	JLabel lblNombre = new JLabel("Nombre");
	JTextField tfNombre = new JTextField();
	JLabel lblDepa = new JLabel("Departamento");
	JComboBox<Departamento> cbDepa = new JComboBox<Departamento>();
	JButton btnConfirmar = new JButton("Confirmar");
	JButton btnCancelar = new JButton("Cancelar");
	private Itr itr = new Itr();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarITR window = new AgregarITR(0);
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
	public static void crear(Itr itr) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int type = 0;
					AgregarITR window = new AgregarITR(type);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void modificar(Itr itr) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int type = 1;
					AgregarITR window = new AgregarITR(type);
					window.setItr(itr);
					if (itr.getNombre() != null )window.getTfNombre().setText(itr.getNombre().toString());
					window.cbDepa.setSelectedIndex((int)itr.getDepartamento().getIdDepartamento());
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	
	public AgregarITR(int type) {
		initialize(type);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int type) {
		frame.getContentPane().setBackground(Color.decode("#f9fafb"));
		frame.setBounds(100, 100, 469, 281);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false); //TODO bloquear tamaño. Agregar a los demás
		
		//Titulo Agregar ITR
		lblAgregarITR.setForeground(Color.decode("#08ACEC"));
		lblAgregarITR.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblAgregarITR.setBounds(142, 10, 169, 25);
		frame.getContentPane().add(lblAgregarITR);
		
		
		//Nombre
		lblNombre.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblNombre.setBounds(25, 79, 45, 13);
		frame.getContentPane().add(lblNombre);
		
		tfNombre.setBounds(142, 76, 274, 19);
		frame.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		
		//Departamento
		lblDepa.setFont(new Font("Bookman Old Style", Font.PLAIN, 10));
		lblDepa.setBounds(25, 120, 105, 13);
		frame.getContentPane().add(lblDepa);
		
		cbDepa.setBounds(142, 117, 274, 19);
		frame.getContentPane().add(cbDepa);
		
		
		//Boton Agregar
		btnConfirmar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnConfirmar.setForeground(Color.decode("#f0f9ff"));
		btnConfirmar.setBackground(Color.decode("#0284c7"));
		btnConfirmar.setBounds(311, 184, 105, 33);
		frame.getContentPane().add(btnConfirmar);
		btnConfirmar.addActionListener(e -> {
			this.itr.setDepartamento((Departamento) cbDepa.getSelectedItem());
			this.itr.setNombre(tfNombre.getText());
			System.out.println(this.itr.getNombre() + "-" +this.itr.getDepartamento());			
			boolean resultado = false;
			if (type == 0) {
				this.itr.setEstado(1);
				resultado = DAOITR.getInstance().getItrBean().crear(itr);
				}
			else if (type == 1) resultado = DAOITR.getInstance().getItrBean().modificar(itr);
			if (resultado) {
				System.out.println("ITR CREADO");
				JOptionPane.showMessageDialog(frame, "ITR Agregado\n"+this.itr.getNombre() + " - " +this.itr.getDepartamento());
			} else {
				System.out.println("ERROR AL CREAR ITR" + itr.toString());
				JOptionPane.showMessageDialog(frame, "HUBO UN ERROR AL AGREGAR EL ITR");
			}
		});
		
		//Boton Cancelar
		btnCancelar.setFont(new Font("Tahona", Font.BOLD, 10));
		btnCancelar.setForeground(Color.decode("#f0f9ff"));
		btnCancelar.setBackground(Color.decode("#0284c7"));
		btnCancelar.setBounds(184, 184, 106, 33);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaAuxITR.main(null);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnCancelar);
		
		//Imagen
		JLabel lblLogoUtec = new JLabel("");
		lblLogoUtec.setIcon(new ImageIcon(AgregarITR.class.getResource("/img/LogoUTEC30x30.png")));
		lblLogoUtec.setBounds(25, 0, 107, 50);
		frame.getContentPane().add(lblLogoUtec);
		
		
		//	FUNCIONALIDADES
		DAODepartamento.getInstance().cargarComboBox(cbDepa);
	}

	public Itr getItr() {
		return itr;
		
	}

	public void setItr(Itr itr) {
		this.itr = itr;
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JLabel getLblAgregarITR() {
		return lblAgregarITR;
	}

	public void setLblAgregarITR(JLabel lblAgregarITR) {
		this.lblAgregarITR = lblAgregarITR;
	}

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	public JTextField getTfNombre() {
		return tfNombre;
	}

	public void setTfNombre(JTextField tfNombre) {
		this.tfNombre = tfNombre;
	}

	public JLabel getLblDepa() {
		return lblDepa;
	}

	public void setLblDepa(JLabel lblDepa) {
		this.lblDepa = lblDepa;
	}

	public JComboBox<Departamento> getCbDepa() {
		return cbDepa;
	}

	public void setCbDepa(JComboBox<Departamento> cbDepa) {
		this.cbDepa = cbDepa;
	}

	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}

	public void setBtnConfirmar(JButton btnConfirmar) {
		this.btnConfirmar = btnConfirmar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

}
