package dario.lectorfecha;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LectorFecha {
	private String day;
	private String month;
	private String year;

	public LectorFecha(String fecha) {
		Pattern pattern = Pattern.compile("^\\d{2}\\/\\d{2}\\/\\d{4}$");
		Matcher matcher = pattern.matcher(fecha);
		Boolean fechaMatch = matcher.find();
		
		if (fechaMatch) {
			String[] splitted = fecha.split("/");
			setYear(splitted[2]);
			setMonth(splitted[1]);
			setDay(splitted[0]);
		}
		else {
			throw new IllegalArgumentException("El String de fecha debe tener formato dd/MM/YYYY");
		}
	}

	public String getDay() {
		return day;
	}

	private void setDay(String day) {
		//TODO: Revisar la logica de los dias porque permite algunas fechas incorrectas
		
		Integer intday = Integer.parseInt(day);
		Integer intmonth = Integer.parseInt(getMonth());
		
		if (intday < 1 || intday > 31) {
			throw new IllegalArgumentException("Los dias son de 01 hasta 31");
		}
		else if (intmonth == 2 && intday > 29) {
			throw new IllegalArgumentException("Febrero tiene maximo 29 dias");
		}
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	private void setMonth(String month) {
		if (Integer.parseInt(month) > 12 || Integer.parseInt(month) < 1) {
			throw new IllegalArgumentException("Los meses son de 01 hasta 12");
		}
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	private void setYear(String year) {
		this.year = year;
	}

}
