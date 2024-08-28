package DessertShop;

/**
* File: Sundae.java
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

public class Sundae extends IceCream {
	//attributes
	private String toppingName;
	private double toppingPrice;
	
	//constructors
	public Sundae() {
		super();
		toppingName = "";
		toppingPrice = 0.0;
		setPackaging("");
	}
	
	public Sundae(String n, int sc, double pps, String tn, double tp) {
		super(n, sc, pps);
		toppingName = tn;
		toppingPrice = tp;
		setPackaging("Boat");
	}
	
	//methods
	public String getToppingName() {
		return toppingName;
	}
	
	public void setToppingName(String tn) {
		toppingName = tn;
	}
	
	public double getTopppingPrice() {
		return toppingPrice;
	}
	
	public void setToppingPrice(double tp) {
		toppingPrice = tp;
	}
	
	public double calculateCost() {
		return super.calculateCost() + toppingPrice;
	}

	@Override
	public String toString() {
		String line1 = String.format("%n%s Sundae (%s)%n", getName(), getPackaging());
		String line2 = String.format("\t%d scoops of %s @ %,.2f/scoop%n", getScoopCount() , getName(), getPricePerScoop());
		String line3_1 = String.format("\t%s topping @ $%,.2f", getToppingName(), getTopppingPrice());
		String line3_2 = String.format("$%,.2f", calculateCost());
		String line3_3 = String.format("[Tax: $%,.2f]", calculateTax());
		String outputVar = String.format("%s%-20s%-45s%-10s%s", line1, line2, line3_1, line3_2, line3_3);
		return outputVar;
	}

}//end of class Sundae
