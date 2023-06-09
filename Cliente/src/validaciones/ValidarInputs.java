package validaciones;

import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ValidarInputs {
	// M�todo para validar solo Letras.
	public static void ValidarSoloLetras(KeyEvent e) {
		if (!Character.isLetter(e.getKeyChar()) && e.getKeyChar() != KeyEvent.VK_SPACE
				&& e.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
			e.consume();
			Mensajes.MostrarError("En este campo solo se pueden ingresar letras");
			return;
		}
	}

	// M�todo para validar solo N�meros.
	public static void ValidarSoloNumeros(KeyEvent e) {
		if (!Character.isDigit(e.getKeyChar()) && e.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
			e.consume();
			Mensajes.MostrarError("En este campo solo se pueden ingresar numeros");
			return;
		}
	}

	// M�todo para validar N�meros y Letras.
	public static void ValidarNumerosYLetras(KeyEvent e) {
		if (!Character.isLetterOrDigit(e.getKeyChar()) && e.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
			e.consume();
			Mensajes.MostrarError("En este campo solo se pueden ingresar letras y numeros, no simbolos");
			return;
		}
	}

	// M�todo para validar Fechas.
	public static void ValidarFechas(KeyEvent e) {
		if (!Character.isDigit(e.getKeyChar()) && e.getKeyChar() != '-' && e.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
			e.consume();
			Mensajes.MostrarError("En este campo solo se puede ingresar numeros y \"-\"");
			return;
		}
	}
	
	public static boolean validacionFechaBd(String fecha) {
	    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
	    formato.setLenient(false);
	    try {
	        formato.parse(fecha);
	        return true;
	    } catch (ParseException e) {
	    	Mensajes.MostrarError("La fecha de nacimiento no es una fecha válida: " + e.getMessage());
	        return false;
	    }
	}
	
	
}
