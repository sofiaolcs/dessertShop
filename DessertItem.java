package DessertShop;

/**
* File: DessertItem.java
* Description: Superclass in the Dessert shop project.
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

public abstract class DessertItem implements Packaging, Comparable<DessertItem> {
	//attributes
	private String name;
	private double taxPercent = 7.25;
	private String packaging;
	
	//constructors
	public DessertItem(){
		name = "";
	}
	
	public DessertItem(String n){
		name = n;
	}
	
	//methods

	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public double getTaxPercent() {
		return taxPercent;
	}
	
	public void setTaxPercent(double taxPercent) {
		this.taxPercent = taxPercent;
	}
	
	public abstract double calculateCost();
	
	public double calculateTax() {
		double tax = taxPercent / 100 * calculateCost();
		return tax;
	}

	//interface Packaging implementation
	public String getPackaging(){
		return packaging;
	}

	public void setPackaging(String p){
		packaging = p;
	}

    //interface Comparable implementation
    public int compareTo(DessertItem other) {
		if (this.calculateCost() == other.calculateCost()) {
			return 0; //0 if equal
		} else if (this.calculateCost() < other.calculateCost()) {
			return -1; //-1 if smaller than the other item
		} else {
			return 1; //1 if greater than the other item
		}
    }

}//end of class DessertItem
