package kumar.deeraj.peopledbweb;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PeopledbWebApplicationTests {

	private int res;

	@Test
	void contextLoads() {
	}

	@BeforeEach
	void setUp() {
		res = 2 + 3;
	}

	@Test
	@DisplayName("Does 5 equals 5")
	public void testFiveNumber() {
		assertEquals(5, res);
	}
	@Disabled
	@Test
	public void testTwoStrings() {
		String a = "hello";
		String b = "hellok";
		assertEquals(a, b);
	}

	@Test
	public void testStringEqual() {
		String a = "abcd";
		String b = new String("abcd");
		assertEquals(a, b);
	}
	@Test
	public void testTwoNumbers() {
		int num1 = 5;
		int num2 = 10;
		assertTrue(num1 < num2);
		assertFalse(num1 > num1);
	}
	@Test
	public void testNull() {
		Long tmp = null;
		assertNull(tmp);
	}
	@Test
	public void testNotNull() {
		Boolean flag = true;
		assertNotNull(flag);
	}
}
