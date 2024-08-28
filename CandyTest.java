package DessertShop;

/**
* File: CandyTest.java
* Description: Test class for the Candy class in the Dessert shop project.
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

class CandyTest {

	@Test
	void testGetCandyWeight() {
		Candy c = new Candy("Lollipop", 0.3, 10);
		double cw = c.getCandyWeight();
		assertEquals(cw, 0.3);
	}

	@Test
	void testSetCandyWeight() {
		Candy c = new Candy("Lollipop", 0.3, 10);
		c.setCandyWeight(0.5);
		assertEquals(c.getCandyWeight(), 0.5);
	}

	@Test
	void testGetPricePerPound() {
		Candy c = new Candy("Lollipop", 0.3, 10);
		double ppp = c.getPricePerPound();
		assertEquals(ppp, 10);
	}

	@Test
	void testSetPricePerPound() {
		Candy c = new Candy("Lollipop", 0.3, 10);
		c.setPricePerPound(15);
		assertEquals(c.getPricePerPound(), 15);
	}
	
	@Test 
	void testCalculateCost() {
		Candy c = new Candy("Lollipop", 0.3, 10);
		assertEquals(c.calculateCost(), 0.3*10);
	}
	
	@Test 
	void testCalculateTax() {
		Candy c = new Candy("Lollipop", 0.3, 10);
		double cost = c.calculateCost();
		assertEquals(c.calculateTax(), cost*0.0725);
	}

	@Test
	void testGetPackaging(){
		Candy d = new Candy("Brownie", 2, 15);
		assertEquals(d.getPackaging(), "Bag");
	}

	//true
	@Test
	void isSameAsTrue() {
		Candy d = new Candy("Brownie", .5, 15);
		Candy d1 = new Candy("Brownie", 2, 15);
		assertTrue(d.isSameAs(d1));
	}

	//false
	@Test
	void isSameAsFalse() {
		Candy d = new Candy("Brownie", 2, 10);
		Candy d1 = new Candy("Brownie", 2, 15);
		assertFalse(d.isSameAs(d1));
	}

}
