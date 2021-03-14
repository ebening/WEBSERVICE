package com.uadec.core.json;

import java.util.Date;

import org.springframework.core.convert.converter.Converter;

import com.uadec.core.util.CoreUtil;

/**
 * Clase utilizada para parsear un string de fecha en formato iso8601 a un objeto Date.
 * @author Carlos Guzm&aacute;n.
 * @since 2013-08-12
 *
 */
public class StringToDateConverter implements Converter<String, Date> {
	
	/**
	 * Parsear un string de fecha en formato iso8601 a un objeto Date.
	 * @param source La fecha en formato iso.
	 * @return La fecha como objeto Date.
	 */
	@Override
	public Date convert(String source) {
		return (Date) CoreUtil.convertValue(source, Date.class);
	}
}
