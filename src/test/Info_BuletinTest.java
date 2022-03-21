package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Proiect_CI.GUI.Info_Buletin;

class Info_BuletinTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testInfo_Buletin() {
		String temp = Info_Buletin.getCNP();
		if(!temp.matches("[0-9]+")) {
			fail("Nu sunt doar cifre");
		}
		
	}
	
	@Test
	void testInfo_Buletin_Null() {
		String temp = Info_Buletin.getCNP();
		assertNotNull(temp);
	}

	@Test
	void testFocus() {
		//fail("Not yet implemented");
	}

}
