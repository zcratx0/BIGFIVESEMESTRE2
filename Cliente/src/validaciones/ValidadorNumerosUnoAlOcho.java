package validaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ValidadorNumerosUnoAlOcho {
    
    public static boolean validar(JTextField textField) {
        String texto = textField.getText();
        String patron = "^[1-8]*$"; // Expresión regular que solo permite números del 1 al 8
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(texto);

        if (matcher.matches()) {
            return true; // El texto ingresado cumple con el patrón
        } else {
            JOptionPane.showMessageDialog(null, "El campo solo puede contener números del 1 al 8");
            return false; // El texto ingresado no cumple con el patrón
        }
    }
    
}
