package _05_intro_to_unit_testing;

import org.junit.Test;
import static org.junit.Assert.*;

import javax.swing.JButton;

public class IntroToUnitTestingTests {

	@Test

	public void testAdd() {
		int a = 15;

		int b = 74;

		assertEquals(IntroToUnitTesting.add(a, b), 89);
	}

	@Test

	public void testSayHello() {

		String answer = "Hello Daniel";

		assertEquals(IntroToUnitTesting.sayHello("Daniel"), answer);
	}

	@Test

	public void testCreateButton() {



		assertTrue(IntroToUnitTesting.createButton() instanceof JButton);
	}

	@Test

	public void testThrowsException() {

		
		
		try {
			IntroToUnitTesting.throwsException();
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
	}

}
