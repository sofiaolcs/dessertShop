package DessertShop;

/**
* File: IceCreamTest.java
* Description: Test class for the IceCream class in the Dessert shop project.
* Lessons Learned: 
* 		test getter and setter
* 		test methods
* Instructor's Name: Jeff Light
*
* @author: Sofia Silva
* @since: 5/17/2024
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IceCreamTest {

	@Test
	void testGetScoopCount() {
		IceCream s = new IceCream("strawberry", 3, 2.25);
		int sc = s.getScoopCount();
		assertEquals(sc, 3);
	}

	@Test
	void testSetScoopCount() {
		IceCream s = new IceCream("strawberry", 3, 2.25);
		s.setScoopCount(2);
		assertEquals(s.getScoopCount(), 2);
	}

	@Test
	void testGetPricePerScoop() {
		IceCream s = new IceCream("strawberry", 3, 2.25);
		double price = s.getPricePerScoop();
		assertEquals(price, 2.25);
	}

	@Test
	void testSetPricePerScoop() {
		IceCream s = new IceCream("strawberry", 3, 2.25);
		s.setPricePerScoop(3);
		assertEquals(s.getPricePerScoop(), 3);
	}
	
	@Test 
	void testCalculateCost() {
		IceCream s = new IceCream("strawberry", 3, 2.25);
		assertEquals(s.calculateCost(), 3*2.25);
	}
	
	@Test 
	void testCalculateTax() {
		IceCream s = new IceCream("strawberry", 3, 2.25);
		double cost = s.calculateCost();
		assertEquals(s.calculateTax(), cost*0.0725);
	}

	@Test
	void testGetPackaging(){
		IceCream s = new IceCream("strawberry", 3, 2.25);
		assertEquals(s.getPackaging(), "Bowl");
	}
	

}
