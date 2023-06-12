package validaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ValidacionFecha extends InputVerifier {
	private static final Pattern pattern = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/\\d{4}$");

	@Override
	public boolean verify(JComponent input) {
		JTextField textField = (JTextField) input;
		String text = textField.getText().trim();
		if (text.isEmpty()) {
			return true;
		}
		Matcher matcher = pattern.matcher(text);
		if (!matcher.matches()) {
			JOptionPane.showMessageDialog(input, "Por favor, ingrese una fecha válida en formato dd/mm/yyyy");
			return false;
		}
		return true;
	}
}