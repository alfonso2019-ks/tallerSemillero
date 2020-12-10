package com.clearminds.acb.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static final String FORMATO_COMPLETO = "yyyy-MM--dd HH:mm:ss";

	public static String obtenerFecha(Date fecha) {
		SimpleDateFormat conversion = new SimpleDateFormat(FORMATO_COMPLETO);
		String fechaString = conversion.format(fecha);
		return fechaString;
	}
}
