package validaciones;

import javax.swing.JOptionPane;

public class Mensajes {
	// Muestro un Error.
	public static void MostrarError(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Operacion Fallida", JOptionPane.ERROR_MESSAGE);
	}

	// Muestro un Exito.
	public static void MostrarExito(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Operacion Exitosa", JOptionPane.INFORMATION_MESSAGE);
	}
}
