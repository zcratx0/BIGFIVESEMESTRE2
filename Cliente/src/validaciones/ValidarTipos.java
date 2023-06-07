package validaciones;

import java.time.LocalDate;

import javax.swing.JTextField;

public class ValidarTipos {
	// M�todo para validar String.
	public static boolean ValidarString(String campo, String s) {
		if (s.isBlank()) {
			Mensajes.MostrarError("El campo " + campo + " no puede estar vacio");
			return false;
		}
		return true;
	}

	// M�todo para validar Number.
	public static boolean ValidarNumber(String campo, String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (Exception e) {
			Mensajes.MostrarError("El campo " + campo + " no es un numero valido");
			return false;
		}
	}

	// Metodo para validar Fecha
	public static boolean ValidarFecha(String campo, JTextField textField) {
		String s = textField.getText();
		try {
			LocalDate d = LocalDate.parse(s);
			if (d.isAfter(LocalDate.now())) {
				throw new Exception("La fecha ingresada debe ser anterior a la de hoy");
			}
			return true;
		} catch (Exception e) {
			Mensajes.MostrarError("El campo " + campo + " no es una fecha válida: " + e.getMessage());
			return false;
		}
	}
}
