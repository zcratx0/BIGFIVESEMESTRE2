package validaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ValidacionTelefono extends InputVerifier {

	//Acepta paréntesis y signo de + al inicio además de puntos y guiones como separadores, minimo 8 caracteres
	private static final Pattern pattern = Pattern.compile("^\\(?\\+?\\d{1,3}\\)?[- .]?\\d[- .]?\\d{1,8}[- .]?\\d$");
	
	
    @Override
    public boolean verify(JComponent input) {
        JTextField textField = (JTextField) input;
        String text = textField.getText().trim();
        if (text.isEmpty()) {
            return true;
        }
        if (text.length()<8) {
        	JOptionPane.showMessageDialog(input, "Por favor, ingrese un número de teléfono válido");
            return false;
        }
        
        Matcher matcher = pattern.matcher(text);
        if (!matcher.matches()) {
            JOptionPane.showMessageDialog(input, "Por favor, ingrese un número de teléfono válido");
            return false;
        }
        return true;
    }
}