package validaciones;

import java.util.regex.Pattern;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

//validar contraseña

	public class ValidacionContrasenia extends InputVerifier {
		private static final Pattern patternUpperCase = Pattern.compile(".*[A-Z].*");
		private static final Pattern patternDigit = Pattern.compile(".*\\d.*");
		private int minLength;

		public ValidacionContrasenia(int minLength) {
			this.minLength = minLength;
		}

		@Override
		public boolean verify(JComponent input) {
			JPasswordField JPassword = (JPasswordField) input;
			String text = JPassword.getText().trim();
			
			if (text.isEmpty()) {
	            return true;
	        }
			if (text.length() < minLength) {
				JOptionPane.showMessageDialog(input, "La contraseña debe tener al menos " + minLength + " caracteres.");
				return false;
			}
			if (!patternUpperCase.matcher(text).matches()) {
				JOptionPane.showMessageDialog(input, "La contraseña debe contener al menos una letra mayúscula.");
				return false;
			}
			if (!patternDigit.matcher(text).matches()) {
				JOptionPane.showMessageDialog(input, "La contraseña debe contener al menos un número.");
				return false;
			}
			return true;
		}
	}