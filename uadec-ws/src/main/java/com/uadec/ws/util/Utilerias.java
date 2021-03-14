package com.uadec.ws.util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.jboss.logging.Logger;

public class Utilerias {
	
	private static final Logger logger = Logger.getLogger(Class.class.getClass());
	
	public static final String getRandomNum(){
		
		String num = "0";
		Random r = new Random();
		Integer n = r.nextInt(150) + 1;
		num = n.toString();
		return num;
		
	}
	
	public static Date parserSqlDate(String strDate) {
		strDate = strDate.replaceAll("/", "-");
		Date date = java.sql.Date.valueOf(strDate);
		return date;
	}

	public static Integer convertToInteger(String cadena) throws NumberFormatException {
		Integer numero = new Integer(cadena);
		return numero;
	}

	public static BigDecimal convertToBigDecimal(String cadena) throws NumberFormatException {
		BigDecimal numero = new BigDecimal(cadena);
		return numero;
	}
	
	public static String replaceComillas (String cadena){
		cadena= cadena.replace("\"", "");
		return cadena;
	}
	
	public static String convertDateFormat(Date fecha){
		DateFormat fechaF = new SimpleDateFormat("dd/MM/yyyy");
		return fecha != null? fechaF.format(fecha).toString() : "";
	}
	
	
	public static Date parseDate(String date, String format) throws ParseException{
		Date date2 = new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat(format);
		try {
			date2 = formatter.parse(date);
		} catch (ParseException e) {
			logger.info("Error al formatear String a Date");
			e.printStackTrace();
		}
		
		return date2;
	}
	
	public static BigDecimal convertStringToBigDecimal (String number){
		if(number != null && number.isEmpty()== false ){
			number = number.replace(",", "");
			number.trim();
			return new BigDecimal(number);
		}else
			return new BigDecimal(0).setScale(2);		
	}
	  
	  // Para comparaciones de fechas en Hibernate
	  // Posiciona una fecha al inicio del día
	public static Date getFormattedFromDateTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	// Posiciona una fecha en el final del día
	public static Date getFormattedToDateTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}
	
}
