package DessertShop;

/**
* File: DessertItemTest.java
* Description: Test class for the DessertItem class in the Dessert shop project.
* Lessons Learned: 
* 		test getter and setter
* Instructor's Name: Jeff Light
*
* @author: Sofia Silva
* @since: 5/9/2024
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Collections;

class DessertItemTest {

	@Test
	void testGetName() {
		Candy d = new Candy("Brownie", 2, 15);
		String name = d.getName();
		assertEquals(name, "Brownie");
	}

	@Test
	void testSetName() {
		Candy d = new Candy("Brownie", 2, 15);
		d.setName("IceCream");
		assertEquals(d.getName(), "IceCream");	
	}
	
	@Test
	void testGetTaxPercent() {
		Candy d = new Candy("Brownie", 2, 15);
		assertEquals(d.getTaxPercent(), 7.25);
	}

	@Test
	void testSetTaxPercent() {
		Candy d = new Candy("Brownie", 2, 15);
		d.setTaxPercent(6);
		assertEquals(d.getTaxPercent(), 6);	
	}

	@Test
    void testSetPackaging(){
		Candy d = new Candy("Brownie", 2, 15);
		d.setPackaging("Plastic bag");
		assertEquals(d.getPackaging(), "Plastic bag");
	}

	@Test
	void testCompareTo_EqualTo() {
		DessertItem s1 = new Sundae("Dark chocolate", 1, 5, "Vanilla", 2);
		DessertItem s2 = new Sundae("Reese's", 1, 5, "Chocolate", 2);

		assertEquals(s1.compareTo(s2), 0);

	}

	@Test
	void testCompareTo_LessThan() {
		DessertItem s1 = new Sundae("Dark chocolate", 1, 4.5, "Vanilla", 2);
		DessertItem s2 = new Sundae("Reese's", 1, 5, "Chocolate", 2);

		assertEquals(s1.compareTo(s2), -1);

	}

	@Test
	void testCompareTo_GreaterThan() {
		DessertItem s1 = new Sundae("Dark chocolate", 1, 5, "Vanilla", 2);
		DessertItem s2 = new Sundae("Reese's", 1, 3, "Chocolate", 2);

		assertEquals(s1.compareTo(s2), 1);

	}

}
