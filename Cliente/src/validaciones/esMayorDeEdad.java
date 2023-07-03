package validaciones;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class esMayorDeEdad {

    public static boolean esMayor(String fechaNacimiento) {
    LocalDate fechaNac = LocalDate.parse(fechaNacimiento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    LocalDate fechaActual = LocalDate.now();
    Period periodo = Period.between(fechaNac, fechaActual);
    return (periodo.getYears() >= 18);
}
    
}
