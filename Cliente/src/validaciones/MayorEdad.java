package validaciones;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MayorEdad {
   public static boolean esMayorDeEdad(JTextField tfFech) {
    try {
        // Obtener la fecha de nacimiento como objeto LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(tfFech.getText().trim(), formatter);

        // Obtener la fecha actual como objeto LocalDate
        LocalDate fechaActual = LocalDate.now();

        // Calcular la diferencia entre la fecha de nacimiento y la fecha actual en años
        long edad = ChronoUnit.YEARS.between(fechaNac, fechaActual);

        // Verificar si la persona tiene más de 18 años
        return edad >= 18;
    } catch (DateTimeParseException e) {
        // Si la fecha de nacimiento no tiene el formato esperado, mostrar un mensaje de error
        JOptionPane.showMessageDialog(null, "La fecha de nacimiento no tiene el formato correcto.");
        return false;
    }
}
}
