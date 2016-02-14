package org.vk.commons.utils.string;

/**
 * Clase de utilerias para objectos del tipo String.<br />
 * 
 * @author viko
 * @version 0.1
 */
public final class StringUtils {

	private StringUtils() {

	}

	private static final String PARAM = "\\{%PARAM\\}";
	private static final String PARAM_REPLACE = "%PARAM";
	private static final String STRING_SEPARATOR = " ";
	private static final int FIRST_INDEX = 0;

	/**
	 * El metodo concatena una secuencia de objectos del tipo String. Debe
	 * tambiém ser añadido el seperador si es que se desea como parametro cada
	 * vez que sea necesario.
	 * 
	 * @param strings
	 *            - Secuencia de cadenas para concatenar
	 * @return La cadena ya concatenada.
	 */
	public static String concatenate(String... strings) {
		StringBuilder builder = new StringBuilder();
		for (String iterator : strings) {
			builder.append(iterator);
		}
		return builder.toString();
	}

	/**
	 * El método concatena una secuencia de objectos con su valor del metodo
	 * toString(). Así que probablemente quieras hacer un Override a ese metodo
	 * si es que declaraste tu objeto ;)
	 * 
	 * @param objects
	 *            - lista de objectos para concatenar en una cadena
	 * @return La cadena concatenada
	 */
	public static String concatenate(Object... objects) {
		StringBuilder builder = new StringBuilder();
		for (Object iterator : objects) {
			builder.append(iterator.toString());
		}
		return builder.toString();
	}

	/**
	 * Este método rellena una cadena con un valor. Util cuando quieres que una
	 * cadena tenga 0's antes. <br />
	 * Ejemplo: <br />
	 * Si llamamos al metodo con lo siguiente: fillWithCharacter("123","0",6) lo
	 * que nos regresara será: "000123"
	 * 
	 * @param anString
	 *            La cadena la cual llenaremos
	 * @param character
	 *            El caracter con el que la vamos a rellenar.
	 * @param quantity
	 *            Cuantos caracteres pondremos
	 * @return La cadena con la cantidad de caracteres que se tenia que
	 *         rellenar.
	 */
	public static String fillWithCharacter(String anString, String character, int quantity) {
		StringBuilder builder = new StringBuilder();
		for (int i = anString.length(); i < quantity; i++) {
			builder.append(character);
		}
		builder.append(anString);
		return builder.toString();
	}

	/**
	 * Remplaza una incidencia de texto o mas en una cadena.
	 * 
	 * @param anString
	 *            la cadena en la que se reemplazara el texto
	 * @param stringToReplace
	 *            el texto a remplazar
	 * @param newString
	 *            el texto con el que se remplazaria
	 * @return la cadena con los nuevos valores.
	 */
	public static String replace(String anString, String stringToReplace, String newString) {
		String theNewString;
		theNewString = anString.replaceAll(stringToReplace, newString);
		return theNewString;
	}

	/**
	 * Este metodo remplaza el criterio de {N} sobre una cadena.
	 * 
	 * @param theString
	 *            la cadena que contiene los criterios.
	 * @param args
	 *            la lista de argumentos que se remplazaran
	 * @return la nueva cadena
	 */
	public static String buildString(String theString, String... args) {

		String theNewString = theString;
		int param = 0;
		for (String iterator : args) {

			theNewString = replace(theNewString, replace(PARAM, PARAM_REPLACE, String.valueOf(param)), iterator);
			param++;
		}
		return theNewString;
	}

	/**
	 * Valida si una cadena esta vacia. Considere lo siguiente: <br />
	 * *Si la cadena es igual a "         " la considera como vacia. *Si la
	 * cadena es igual a " " la considera como vacia. *Si la cadena es
	 * <b>null</b> la considera como vacia.
	 * 
	 * @param anString
	 * @return
	 */
	public static boolean isEmpty(String anString) {
		if (anString == null || anString.isEmpty()) {
			return true;
		} else {
			anString = anString.trim();
			if (anString.isEmpty() || anString.length() <= 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Metodo para obtener una cadena con su letra capital.
	 * 
	 * @param anString
	 * @return
	 */
	public static String getWithCapitalLetter(String anString) {
		StringBuilder builder = new StringBuilder();
		String anStringCopy = anString.trim();
		String upperCase = anStringCopy.toUpperCase();
		String lowerCase = anStringCopy.toLowerCase();

		builder.append(upperCase.charAt(FIRST_INDEX));
		builder.append(lowerCase.substring(FIRST_INDEX + 1, anStringCopy.length()));

		return builder.toString();
	}

	/**
	 * Concatena una serie de cadenas en una sola convirtiendo la primera letra de cada cadena en letra capaital.
	 * @param strings
	 * @return
	 */
	public static String getWithCapitalLetter(String... strings) {
		StringBuilder builder = new StringBuilder();
		int rounds = 0;
		for (String iterator : strings) {
			if (rounds != 0) {
				builder.append(STRING_SEPARATOR);
			}
			builder.append(getWithCapitalLetter(iterator));
			rounds++;
		}
		return builder.toString();
	}

}