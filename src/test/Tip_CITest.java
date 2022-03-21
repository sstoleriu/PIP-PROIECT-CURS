package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Proiect_CI.Tip_CI;

class Tip_CITest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testTip_CI_bul() {
		String temp = Tip_CI.getCI();
		assertEquals(temp, "Buletin");
	}
	
	@Test
	void testTip_CI_viza() {
		String temp = Tip_CI.getCI();
		assertEquals(temp, "Viza");
	}
	
	@Test
	void testTip_CI_pas() {
		String temp = Tip_CI.getCI();
		assertEquals(temp, "Pasaport");

	}

	@Test
	void testValidare() {
		//fail("Not yet implemented");
	}

}
