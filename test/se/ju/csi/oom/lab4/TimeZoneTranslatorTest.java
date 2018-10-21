package se.ju.csi.oom.lab4;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import org.junit.Before;
import org.junit.Test;


public class TimeZoneTranslatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testShiftTimeZone() {
		TimeZoneTranslator timeZoneTranslator = new TimeZoneTranslator();
		DateTime LectureStart = new DateTime(2016, 1, 1, 6, 0, 0);
		DateTime expectedTime = new DateTime(2015, 12, 31, 21, 0, 0);
		
		DateTime translatedTime = timeZoneTranslator.shiftTimeZone(LectureStart, TimeZone.CENTRAL_EUROPEAN_TIME.getOffset(), TimeZone.US_PACIFIC.getOffset());
		
		assertEquals(expectedTime.toString(), translatedTime.toString());
		System.out.println(translatedTime.toString());
	}
	
	@Test
	public void testShiftEventTimeZone() {
		DateTime LectureStart = new DateTime(2018, 8, 27, 8, 0, 0);
		DateTime LectureEnd = new DateTime(2018, 8, 27, 9, 45, 0);
		Person johannes = new Person("Johannes Schmidt");
		Person ragnar = new Person("Ragnar Nohre");
		Place HC218 = new Place("Hc218",57.7785672,14.1614833,20.0);
		
		Event firstOomLecture = new Event("OOM 2018 Lecture 1",
				LectureStart,
				LectureEnd,
				new HashSet<>(Arrays.asList(johannes, ragnar)),
				HC218);
		
		Event bostonFirstOomLecture = TimeZoneTranslator.shiftEventTimeZone(firstOomLecture, TimeZone.CENTRAL_EUROPEAN_TIME, TimeZone.US_EASTERN);
		
		DateTime bostonLectureStart = new DateTime(2018, 8, 27, 2, 0, 0);
		DateTime bostonLectureEnd = new DateTime(2018, 8, 27, 3, 45, 0);
		
		Event expectedBostonTime = new Event("Boston OOM 2018 Lecture 1",
				bostonLectureStart,
				bostonLectureEnd,
				new HashSet<>(Arrays.asList(johannes, ragnar)),
				HC218);
		
		assertEquals(bostonFirstOomLecture.getStartDate().toString(), expectedBostonTime.getStartDate().toString());
		assertEquals(bostonFirstOomLecture.getEndDate().toString(), expectedBostonTime.getEndDate().toString());
	}

}