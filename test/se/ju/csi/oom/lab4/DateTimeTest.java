package se.ju.csi.oom.lab4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DateTimeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testToString() {
		DateTime dateTime = new DateTime(2016, 01, 01, 14, 10, 5);
		String expectedString = "2016-01-01 14:10:05";
		assertEquals(expectedString, dateTime.toString());
	}

	@Test
	public void testDateTimeString() {
		DateTime dateTime = new DateTime("2016-01-01 14:10:05");
		String expectedString = "2016-01-01 14:10:05";
		assertEquals(expectedString, dateTime.toString());
	}

}
