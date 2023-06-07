package validaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ValidacionEmailInsti extends InputVerifier {
	private static final Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)?utec\\.edu\\.uy$");

	@Override
	public boolean verify(JComponent input) {
		JTextField textField = (JTextField) input;
		String text = textField.getText().trim();
		
		if (text.isEmpty()) {
            return true;
        }
		Matcher matcher = pattern.matcher(text);
		if (!matcher.matches()) {
			JOptionPane.showMessageDialog(input,
					"Por favor, ingrese un correo electrónico válido con el dominio utec.edu.uy.");
			return false;
		}
		return true;
	}
}
