package DessertShop;

import java.util.Objects;

/**
* File: Cookie.java
* Description: class in the Dessert shop project.
* Lessons Learned: 
* 		SpiderMan
* 		Default Constructor
* 		Constructor with Parameters
* 		private variables
* 		getters and setters
* 		inheritance
* Instructor's Name: Jeff Light
*
* @author: Sofia Silva
* @since: 5/9/2024
*/

public class Cookie extends DessertItem implements SameItem<Cookie> {
	//attributes
	private int cookieQty;
	private double pricePerDozen;
	
	//constructors
	public Cookie() {
		super();
		cookieQty = 0;
		pricePerDozen = 0.0;
		setPackaging("");
	}
	
	public Cookie(String n, int cq, double ppd) {
		super(n);
		cookieQty = cq;
		pricePerDozen = ppd;
		setPackaging("Box");
	}
	
	
	//methods
	public int getCookieQty() {
		return cookieQty;
	}
	
	public void setCookieQty(int cq) {
		cookieQty = cq;
	}
	
	public double getPricePerDozen() {
		return pricePerDozen;
	}
	
	public void setPricePerDozen(double ppd) {
		pricePerDozen = ppd;
	}
	
	@Override public double calculateCost() {
		double pricePerCookie = pricePerDozen / 12;
		return pricePerCookie * cookieQty;
	}

	@Override
	public String toString() {
		String line1 = String.format("%n%s Cookies (%s)%n", getName(), getPackaging());
		String line2_1 = String.format("\t%d cookies @ %,.2f/dozen", getCookieQty() ,getPricePerDozen());
		String line2_2 = String.format("$%,.2f", calculateCost());
		String line2_3 = String.format("[Tax: $%,.2f]", calculateTax());
		String outputVar = String.format("%s%-45s%-10s%s", line1, line2_1, line2_2, line2_3);
		return outputVar;
	}

	public boolean isSameAs(Cookie other) {
		return this.getName().equals(other.getName()) && this.getPricePerDozen() == other.getPricePerDozen();
	}
	
	
}//end of class Cookie
