package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TBFFecha {
	public static String getFechaDDYYMMMM(Date date) {
		return new SimpleDateFormat("dd/MM/yyyy").format(date).toString();
	}
	
	public static String getFechaDDYYMMHHMM(Date date) {
		return new SimpleDateFormat("dd/MM/yyyy HH:mm").format(date).toString();
	}
	
	public static Date setFechaDDYYMMMM(String texto) {
		try {
			return (Date) new SimpleDateFormat("dd/mm/yyyy").parse(texto);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		return null;
	}
}
