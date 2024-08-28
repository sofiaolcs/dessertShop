package DessertShop;

import java.util.Objects;

/**
* File: Candy.java
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

public class Candy extends DessertItem implements SameItem<Candy> {
	//attributes
	private double candyWeight;
	private double pricePerPound;
	
	//constructors
	public Candy() {
		super();
		candyWeight = 0.0;
		pricePerPound = 0.0;
		setPackaging("");
	}
	
	public Candy(String n, double cw, double ppp) {
		super(n);
		candyWeight = cw;
		pricePerPound = ppp;
		setPackaging("Bag");
	}
	
	//methods
	public double getCandyWeight() {
		return candyWeight;
	}
	
	public void setCandyWeight(double cw) {
		candyWeight = cw;
	}
	
	public double getPricePerPound() {
		return pricePerPound;
	}
	
	public void setPricePerPound(double ppp) {
		pricePerPound = ppp;
	}
	
	@Override public double calculateCost() {
		return candyWeight * pricePerPound;
	}
	
	@Override
	public String toString() {
		String line1 = String.format("%n%s (%s)%n", getName(), getPackaging());
		String line2_1 = String.format("\t%.2f lbs. @ $%,.2f/lb.:", getCandyWeight() ,getPricePerPound());
		String line2_2 = String.format("$%,.2f", calculateCost());
		String line2_3 = String.format("[Tax: $%,.2f]", calculateTax());
		String outputVar = String.format("%s%-45s%-10s%s", line1, line2_1, line2_2, line2_3);
		return outputVar;
	}

	public boolean isSameAs(Candy other) {
        return this.getName().equals(other.getName()) && this.getPricePerPound() == other.getPricePerPound();
	}

}//end of class Candy
