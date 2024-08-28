package DessertShop;

/**
* File: IceCream.java
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

public class IceCream extends DessertItem {
	//attributes
	private int scoopCount;
	private double pricePerScoop;
	
	//constructors
	public IceCream() {
		super();
		scoopCount = 0;
		pricePerScoop = 0.0;
		setPackaging("");
	}
	
	public IceCream(String n, int sc, double pps) {
		super(n);
		scoopCount = sc;
		pricePerScoop = pps;
		setPackaging("Bowl");
	}
	
	//methods
	public int getScoopCount() {
		return scoopCount;
	}
	
	public void setScoopCount(int sc) {
		scoopCount = sc;
	}
	
	public double getPricePerScoop() {
		return pricePerScoop;
	}
	
	public void setPricePerScoop(double pps) {
		pricePerScoop = pps;
	}
	
	@Override public double calculateCost() {
		return scoopCount * pricePerScoop;
	}

	@Override
	public String toString() {
		String line1 = String.format("%n%s Ice Cream (%s)%n", getName(), getPackaging());
		String line2_1 = String.format("\t%d scoops @ %,.2f/scoop", getScoopCount(), getPricePerScoop());
		String line2_2 = String.format("$%,.2f", calculateCost());
		String line2_3 = String.format("[Tax: $%,.2f]", calculateTax());
		String outputVar = String.format("%s%-45s%-10s%s", line1, line2_1, line2_2, line2_3);
		return outputVar;
	}
	
}//end of class IceCream

