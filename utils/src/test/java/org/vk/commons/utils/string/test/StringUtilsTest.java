package org.vk.commons.utils.string.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.vk.commons.utils.string.StringUtils;

import junit.framework.TestCase;

public class StringUtilsTest extends TestCase {

	private static final Logger LOGGER = Logger.getLogger(StringUtilsTest.class);

	@Test
	public void testConcatenateStringArray() {
		String salida;
		salida = StringUtils.concatenate("Esto es", " un ejemplo", " de concatenacion.");
		LOGGER.info("Texto generado: " + salida);
		assertEquals("Esto es un ejemplo de concatenacion.", salida);
	}
	@Test
	public void testConcatenateObjectArray() {
		Integer aInt = 0;
		Long aLong = 1L;
		String salida = StringUtils.concatenate(aInt, " ", aLong);
		LOGGER.info("Texto generado: " + salida);
		assertEquals("0 1", salida);
	}
	@Test
	public void testFillWithCharacter() {
		String salida = StringUtils.fillWithCharacter("123", "x", 5);
		LOGGER.info("Texto generado: " + salida);
		assertEquals("xx123", salida);
	}
	@Test
	public void testReplace() {
		String salida = StringUtils.replace("This is a fucking String in a fucking ugly method", "fucking",
				"beautiful");
		LOGGER.info("Texto generado: " + salida);
		salida = StringUtils.replace(salida, "ugly", "new");
		LOGGER.info("Texto generado: " + salida);
		assertEquals("This is a beautiful String in a beautiful new method", salida);
	}
	@Test
	public void testBuildString() {
		String salida = StringUtils.buildString("This is an {0} for a building {1} also in {3} it is {2}", "example",
				"String", "created", "desorder");
		LOGGER.info("Texto generado: " + salida);
		assertEquals("This is an example for a building String also in desorder it is created", salida);
	}
	@Test
	public void testIsEmptyString() {
		assertEquals(true, StringUtils.isEmpty("          "));
	}
	@Test
	public void testIsEmptyString2() {
		assertEquals(true, StringUtils.isEmpty(null));
	}
	@Test
	public void testIsEmptyString3() {
		assertEquals(true, StringUtils.isEmpty(""));
	}
	@Test
	public void testIsEmptyString4() {
		assertEquals(false, StringUtils.isEmpty("    a      "));
	}
	@Test
	public void testIsEmptyString5() {
		assertEquals(true, StringUtils.isEmpty(" "));
	}
	@Test
	public void testgetWithCapitalLetter() {
		String salida=StringUtils.getWithCapitalLetter(" a ordinal String");
		LOGGER.info("Texto generado: " + salida);
		assertEquals("A ordinal string", salida);
	}
	@Test
	public void testgetWithCapitalLetter2() {
		String salida=StringUtils.getWithCapitalLetter("a other String");
		LOGGER.info("Texto generado: " + salida);
		assertEquals("A other string",salida);
	}
	@Test
	public void testgetWithCapitalLetter3() {
		String salida=StringUtils.getWithCapitalLetter("OTHER STRING");
		LOGGER.info("Texto generado: " + salida);
		assertEquals("Other string",salida);
	}
	@Test
	public void testgetWithCapitalLetterArgs() {
		String salida=StringUtils.getWithCapitalLetter("Other","String","TO");
		LOGGER.info("Texto generado: " + salida);
		assertEquals("Other String To",salida);
	}
	@Test
	public void testgetWithCapitalLetterArgs2() {
		String salida=StringUtils.getWithCapitalLetter("Other "," String"," TO ");
		LOGGER.info("Texto generado: " + salida);
		assertEquals("Other String To",salida);
	}
	@Test
	public void testgetWithCapitalLetterArgs3() {
		String salida=StringUtils.getWithCapitalLetter("   Other","String    ","  TO");
		LOGGER.info("Texto generado: " + salida);
		assertEquals("Other String To",salida);
	}
}
