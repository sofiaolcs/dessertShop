package DessertShop;

/**
* File: SundaeTest.java
* Description: Test class for the Sundae in the Dessert shop project.
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

class SundaeTest {

	@Test
	void testGetToppingName() {
		Sundae cc = new Sundae("caramel", 4, 2.25, "chocolate", 1.15);
		String name = cc.getToppingName();
		assertEquals(name, "chocolate");
	}

	@Test
	void testSetToppingName() {
		Sundae cc = new Sundae("caramel", 4, 2.25, "chocolate", 1.15);
		cc.setToppingName("strawberry");
		assertEquals(cc.getToppingName(), "strawberry");
	
	}

	@Test
	void testGetTopppingPrice() {
		Sundae cc = new Sundae("caramel", 4, 2.25, "chocolate", 1.15);
		double price = cc.getTopppingPrice();
		assertEquals(price, 1.15);
	
	}

	@Test
	void testSetToppingPrice() {
		Sundae cc = new Sundae("caramel", 4, 2.25, "chocolate", 1.15);
		cc.setToppingPrice(2);
		assertEquals(cc.getTopppingPrice(), 2);
	
	}
	
	@Test 
	void testCalculateCost() {
		Sundae cc = new Sundae("caramel", 4, 2.25, "chocolate", 1.15);
		assertEquals(cc.calculateCost(), 4*2.25 + 1.15);
	}
	
	@Test 
	void testCalculateTax() {
		Sundae cc = new Sundae("caramel", 4, 2.25, "chocolate", 1.15);
		double cost = cc.calculateCost();
		assertEquals(cc.calculateTax(), cost*0.0725);
	}

	@Test
	void testGetPackaging(){
		Sundae cc = new Sundae("caramel", 4, 2.25, "chocolate", 1.15);
		assertEquals(cc.getPackaging(), "Boat");
	}
}
