package validaciones;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ValidacionMaxyMin extends InputVerifier {
	private int minLength;
	private int maxLength;

	public ValidacionMaxyMin(int minLength, int maxLength) {
		this.minLength = minLength;
		this.maxLength = maxLength;
	}

	@Override
	public boolean verify(JComponent input) {
		JTextField textField = (JTextField) input;
		String text = textField.getText().trim();
		int length = text.length();
		 if (text.isEmpty()) {
	            return true;
	        }
		if (length < minLength || length > maxLength) {
			JOptionPane.showMessageDialog(input,
					"El campo debe tener entre " + minLength + " y " + maxLength + " caracteres.");
			return false;
		}
		return true;
	}

}
