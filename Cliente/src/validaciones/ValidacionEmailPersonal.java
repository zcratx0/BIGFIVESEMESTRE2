package validaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ValidacionEmailPersonal extends InputVerifier {
	//Acepta paréntesis al inicio y puntos y guiones como separadores
	private static final Pattern pattern = Pattern.compile("^[\\w._]+@[\\w-]+(?:\\.[\\w-]+)*$");

	@Override
	public boolean verify(JComponent input) {
		JTextField textField = (JTextField) input;
		String text = textField.getText().trim();
		if (text.isEmpty()) {
			return true;
		}
		Matcher matcher = pattern.matcher(text);
		if (!matcher.matches()) {
			JOptionPane.showMessageDialog(input, "Por favor, ingrese un correo electrónico válido");
			return false;
		}
		return true;
	}
}
