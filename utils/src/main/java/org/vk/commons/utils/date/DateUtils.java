package org.vk.commons.utils.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.vk.commons.utils.string.StringUtils;

/**
 * Clase de utilerias para objetos del tipo Date
 * 
 * @author viko
 * @version 0.1
 */
public final class DateUtils {

	private static final String DATE_DD_MM_YYYY_FORMAT = "dd/MM/yyyy";
	private static final String DATE_MM_DD_YYYY_FORMAT = "MM/dd/yyyy";
	private static final String DATE_YYYY_MM_DD_FORMAT = "yyyy/MM/dd";
	private static final Calendar CALENDAR_INSTANCE = Calendar.getInstance();

	private DateUtils() {

	}

	/**
	 * Metodo para formatear un objeto tipo Date a DD/MM/YYYY
	 * 
	 * @param date
	 * @return fecha en formato DD/MM/YYYY
	 */
	public static String formatDateToDDMMYYYY(Date date) {
		String dateFormat = null;
		if (date != null) {
			SimpleDateFormat formater = new SimpleDateFormat(DATE_DD_MM_YYYY_FORMAT);
			dateFormat = formater.format(date);
		}
		return dateFormat;
	}

	/**
	 * Metodo para formatear un objeto tipo Date a MM/DD/YYYY
	 * 
	 * @param date
	 * @return fecha en formato MM/DD/YYYY
	 */
	public static String formatDateToMMDDYYYY(Date date) {
		String dateFormat = null;
		if (date != null) {
			SimpleDateFormat formater = new SimpleDateFormat(DATE_MM_DD_YYYY_FORMAT);
			dateFormat = formater.format(date);
		}
		return dateFormat;
	}

	public static String formatDateToYYYYMMDD(Date date) {
		String dateFormat = null;
		if (date != null) {
			SimpleDateFormat formater = new SimpleDateFormat(DATE_YYYY_MM_DD_FORMAT);
			dateFormat = formater.format(date);
		}
		return dateFormat;
	}

	public static String formatDateToCustomPattern(Date date, String pattern) {
		String dateFormat = null;
		if (date != null && StringUtils.isEmpty(pattern)) {
			SimpleDateFormat formater = new SimpleDateFormat(pattern);
			dateFormat = formater.format(date);
		}
		return dateFormat;
	}

	private static Date rollCalendar(int field, int amount) {
		CALENDAR_INSTANCE.add(field, amount);
		return CALENDAR_INSTANCE.getTime();
	}

	public static Date rollMiliSecond(Date date, int miliSecond) {
		CALENDAR_INSTANCE.setTime(date);
		return rollCalendar(Calendar.MILLISECOND, miliSecond);
	}

	public static Date rollSecond(Date date, int seconds) {
		CALENDAR_INSTANCE.setTime(date);
		return rollCalendar(Calendar.SECOND, seconds);
	}

	public static Date rollMinutes(Date date, int minutes) {
		CALENDAR_INSTANCE.setTime(date);
		return rollCalendar(Calendar.MINUTE, minutes);
	}

	public static Date rollHours(Date date, int hours) {
		CALENDAR_INSTANCE.setTime(date);
		return rollCalendar(Calendar.HOUR_OF_DAY, hours);
	}

	public static Date rollDays(Date date, int days) {
		CALENDAR_INSTANCE.setTime(date);
		return rollCalendar(Calendar.DAY_OF_YEAR, days);
	}

	public static Date rollWeeks(Date date, int weeks) {
		CALENDAR_INSTANCE.setTime(date);
		return rollCalendar(Calendar.WEEK_OF_YEAR, weeks);
	}

	public static Date rollMonths(Date date, int months) {
		CALENDAR_INSTANCE.setTime(date);
		return rollCalendar(Calendar.MONTH, months);
	}

	public static Date rollYears(Date date, int years) {
		CALENDAR_INSTANCE.setTime(date);
		return rollCalendar(Calendar.YEAR, years);
	}

}
