package validaciones;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class validacionMINMAXTEXT extends InputVerifier {
    
    private int min;
    private int max;
    
    public validacionMINMAXTEXT(int min, int max) {
        this.min = min;
        this.max = max;
    }
    
    @Override
    public boolean shouldYieldFocus(JComponent input) {
        JTextArea textArea = (JTextArea) input;
        String text = textArea.getText();
        int length = text.length();
        
        if (length < min || length > max) {
            JOptionPane.showMessageDialog(null, "El texto debe tener entre " + min + " y " + max + " caracteres.");
            return false;
        }
        
        return true;
    }

    @Override
    public boolean verify(JComponent input) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verify'");
    }
    
}