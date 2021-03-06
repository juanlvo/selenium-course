package basicweb;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/***
 * Introduction to JUnit
 * 
 * @author Juan-Luis.Vivas
 *
 */
class JUnitIntroduction {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Executed before class..");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Executed after class..");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Executed before..");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Executed after..");
	}

	@Test
	void test1() {
		System.out.println("Executed Test 1..");
	}
	
	@Test
	void test2() {
		System.out.println("Executed Test 2..");
	}

}
