package DessertShop;

/**
* File: Order.java
* Description: SpiderMan in the DessertShop package
* Lessons Learned: 
* 		SpiderMan
* 		Default Constructor
* 		methods
* Instructor's Name: Jeff Light
*
* @author: Sofia Silva
* @since: 5/30/2024
*/

import java.util.ArrayList;

public class Order implements Payable {
	//Attributes
	private ArrayList<DessertItem> order;
	PayType payMethod;
	
	//Constructors
	Order () {
		order = new ArrayList<DessertItem>();
		payMethod = PayType.CASH;
	}
	
	//Methods
	public ArrayList<DessertItem> getOrderList() {
		return order;
	}
	
	public void add(DessertItem newItem) {
		//candy
		if (newItem instanceof Candy) {
			for (DessertItem item : order) {
				if (item instanceof Candy) {
					if (((Candy)newItem).isSameAs((Candy)item)) {
						((Candy)item).setCandyWeight(((Candy)item).getCandyWeight() + ((Candy)newItem).getCandyWeight());
						return;
					}

				}
			}
		}//end of candy comparison

		//cookie
		if (newItem instanceof Cookie) {
			for (DessertItem item : order) {
				if (item instanceof Cookie) {
					if (((Cookie)newItem).isSameAs((Cookie)item)) {
						((Cookie)item).setCookieQty(((Cookie)item).getCookieQty() + ((Cookie)newItem).getCookieQty());
						return;
					}

				}
			}
		}//end of cookie comparison

		//it only adds if the item is not cookie or candy that is duplicated
		order.add(newItem);

	}//end of add method

	//PayType
	public PayType getPayType() {
		return payMethod;
	}

	public void setPayType(PayType payMethod) {
		this.payMethod = payMethod;
	}
	
	public int itemCount() {
		return order.size();
	}
	
	//calculates total price of the order
	public double orderCost() {
		double finalCost = 0.0;
		for(DessertItem item : order) {
			finalCost += item.calculateCost();
		} //end of for	
		return finalCost;
	}//end of method
	
	//calculates tax of the order
	public double orderTax() {
		double finalTax = 0.0;
		for(DessertItem item : order) {
			finalTax += item.calculateTax();
		} //end of for
		return finalTax;
	}//end of method

	@Override
	public String toString(){
		String finalOutput = "";
		finalOutput += "------------------------Receipt-----------------------------------------";
		for(DessertItem item : order) {
			finalOutput += item.toString();
		}
		finalOutput += "\n------------------------------------------------------------------------\n";

		double subtotal = orderCost();
		double totalTax = orderTax();
		double totalCost = subtotal + totalTax;
		int numberItems = itemCount();
		String line1_1 = String.format("$%.2f", subtotal);
		String line1_2 = String.format("[Tax: $%.2f]\n", totalTax);
		String line1_3 = String.format("$%.2f\n", totalCost);
		String line2 = "Total items in the order: " + numberItems;
		String finalLine = String.format(("%s%36s%18s%s%41s%s"), "Order Subtotals: ", line1_1, line1_2, "Order Total: ", line1_3, line2);

		finalOutput += finalLine;
		finalOutput += "\n------------------------------------------------------------------------\n";
		finalOutput += String.format("%s %s", "Paid for with", payMethod.name());
		return finalOutput;
	}
	
} //end of class Order
