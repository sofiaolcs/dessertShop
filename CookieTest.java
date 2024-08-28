package DessertShop;

/**
* File: CookieTest.java
* Description: Test class for the Cookie class in the Dessert shop project.
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

class CookieTest {

	@Test
	void testGetCookieQty() {
		Cookie c = new Cookie("chocolate", 2, 25.50);
		int qty = c.getCookieQty();
		assertEquals(qty, 2);
	}

	@Test
	void testSetCookieQty() {
		Cookie c = new Cookie("chocolate", 2, 25.50);
		c.setCookieQty(5);
		assertEquals(c.getCookieQty(), 5);
	}

	@Test
	void testGetPricePerDozen() {
		Cookie c = new Cookie("chocolate", 2, 25.50);
		double price = c.getPricePerDozen();
		assertEquals(price, 25.50);
	}

	@Test
	void testSetPricePerDozen() {
		Cookie c = new Cookie("chocolate", 2, 25.50);
		c.setPricePerDozen(30);
		assertEquals(c.getPricePerDozen(), 30);
	}
	
	@Test 
	void testCalculateCost() {
		Cookie c = new Cookie("chocolate", 2, 25.50);
		double pricePerCookie = 25.50/12;
		assertEquals(c.calculateCost(), pricePerCookie * 2);
	}
	
	@Test 
	void testCalculateTax() {
		Cookie c = new Cookie("chocolate", 2, 25.50);
		double cost = c.calculateCost();
		assertEquals(c.calculateTax(), cost*0.0725);
	}

	@Test
	void testGetPackaging(){
		Cookie c = new Cookie("chocolate", 2, 25.50);
		assertEquals(c.getPackaging(), "Box");
	}

	//true
	@Test
	void isSameAsTrue() {
		Cookie c = new Cookie("chocolate", 4, 25.50);
		Cookie c1 = new Cookie("chocolate", 2, 25.50);
        assertTrue(c.isSameAs(c1));
	}

	//false
	@Test
	void isSameAsFalse() {
		Cookie c = new Cookie("chocolate", 2, 15);
		Cookie c1 = new Cookie("chocolate", 2, 25.50);
		assertFalse(c.isSameAs(c1));
	}
}
