package org.vk.commons.utils.string;

public final class StringUtils {

	private StringUtils() {

	}

	private static final String PARAM = "{%PARAM}";
	private static final String PARAM_REPLACE = "%PARAM";

	public static String concatenate(String... strings) {
		StringBuilder builder = new StringBuilder();
		for (String iterator : strings) {
			builder.append(iterator);
		}
		return builder.toString();
	}

	public static String concatenate(Object... objects) {
		StringBuilder builder = new StringBuilder();
		for (Object iterator : objects) {
			builder.append(iterator.toString());
		}
		return builder.toString();
	}

	public static String fillWithCharacter(String anString, String character, int quantity) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < quantity; i++) {
			builder.append(character);
		}
		builder.append(anString);
		return builder.toString();
	}

	public static String replace(String anString, String stringToReplace, String newString) {
		String theNewString = anString;
		theNewString.replaceAll(stringToReplace, newString);
		return theNewString;
	}

	public static String buildString(String theString, String... args) {

		String theNewString = theString;
		int param = 0;
		for (String iterator : args) {

			theNewString.replace(replace(PARAM, PARAM_REPLACE, String.valueOf(param)), iterator);
			param++;
		}
		return theNewString;
	}

}