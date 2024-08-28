package DessertShop;

/**
* File: DessertShop.java
* Description: Main class in the DessertShop, user interface
* Lessons Learned: 
* 		SpiderMan
* 		Using classes in the main method
* 		Constructor with Parameters
* 		prinf
* 		String.format
 * 		loops
* Instructor's Name: Jeff Light
*
* @author: Sofia Silva
* @since: 5/30/2024
*/

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DessertShop {

	//attributes
	private static HashMap<String, Customer> customerDB = new HashMap<String, Customer>();
	

	//main method
	public static void main(String[] args) {

		boolean closed = false;
		while(!closed) {

				//creating a new order
				Order order1 = new Order();
				String paymentMethod;


				//this comment was for one of the first assignments
			/*for (DessertItem item : o1.getOrderList()) {
				System.out.println(item.getName());
			}
			System.out.println("\nTotal number of items in order: " + o1.itemCount() + "\n");
			*/


				//user output and options
				Scanner sIn = new Scanner(System.in);
				String choice;
				DessertItem orderItem;

				boolean done = false;
				while (!done) {
					System.out.println("\n1: Candy");
					System.out.println("2: Cookie");
					System.out.println("3: Ice Cream");
					System.out.println("4: Sunday");
					System.out.println("5: Admin Module");

					System.out.print("\nWhat would you like to add to the order? (1-5, Enter for done): ");
					choice = sIn.nextLine();

					if (choice.equals("")) {
						done = true;
					} else {
						switch (choice) {
							case "1":
								orderItem = userPromptCandy();
								order1.add(orderItem);
								break;
							case "2":
								orderItem = userPromptCookie();
								order1.add(orderItem);
								break;
							case "3":
								orderItem = userPromptIceCream();
								order1.add(orderItem);
								break;
							case "4":
								orderItem = userPromptSundae();
								order1.add(orderItem);
								break;
							case "5":
								adminModule();
								break;
						}//end of switch (choice)
					}//end of if (choice.equals(""))
				}//end of while (!done)
				System.out.println("\n");


				//adding things to the order
				order1.add(new Candy("Candy Corn", 1.5, .25));

				order1.add(new Candy("Gummy Bears", .25, .35));

				order1.add(new Cookie("Chocolate Chip", 6, 3.99));

				order1.add(new IceCream("Pistachio", 2, .79));

				order1.add(new Sundae("Vanilla", 3, .69, "Hot Fudge", 1.29));

				order1.add(new Cookie("Oatmeal Raisin", 2, 3.45));


				//customer name
				System.out.print("Enter the customer name: ");
				String custName = sIn.nextLine();

				//checking if customer already exists
				if (!customerDB.containsKey(custName)) {
					Customer customer = new Customer(custName);
					customerDB.put(custName, customer);
				}

				//adding order to the Customer's history
				Customer c = customerDB.get(custName);
				c.addToHistory(order1);


				//payment method
				boolean valid = false;
				while (!valid) {
					System.out.print("What form of payment will be used? (CASH, CARD, PHONE): ");
					String answer = sIn.nextLine().toUpperCase();

					for (Payable.PayType type : Payable.PayType.values()) {
						if (answer.equals(type.name())) {
							paymentMethod = type.name();
							valid = true;
							switch (paymentMethod) {
								case "CASH":
									order1.payMethod = Payable.PayType.CASH;
									break;
								case "CARD":
									order1.payMethod = Payable.PayType.CARD;
									break;
								case "PHONE":
									order1.payMethod = Payable.PayType.PHONE;
									break;
							}
							break;
						}
					}
					if (!valid) {
						System.out.println("That's not a valid form of payment.\n");
					}
				}


				//sorting items in the order of price
				Collections.sort(order1.getOrderList());

				//invoice
				System.out.println(order1);
				System.out.println("------------------------------------------------------------------------");
				System.out.printf("%-25s%-20s%-30s%n", ("Customer Name: " + c.getName()), ("Customer ID: " + c.getID()), ("Total Orders: " + c.getOrderHistory().size()));
				System.out.print("\nHit enter to start a new order.");
				sIn.nextLine();


				//invoice lab 3
			/*
			for (DessertItem item : order1.getOrderList()) {
				String name = item.getName() + ":";
				double priceItem = item.calculateCost();
				double taxItem = item.calculateTax();

				String invoice = String.format("%-25s$%-8.2f[Tax: $%.2f]\n", name, priceItem, taxItem);
				System.out.println(invoice);
			}

			double subtotal = order1.orderCost();
			double totalTax = order1.orderTax();
			double totalCost = subtotal + totalTax;
			int numberItems = order1.itemCount();

			System.out.println("------------------------------------------------------");
			System.out.printf("%-25s$%-10.2f[Tax:$%.2f]\n", "Order Subtotals: ", subtotal, totalTax);
			System.out.printf("%-25s$%-10.2f\n", "Order Total: ", totalCost);
			System.out.println("Total items in the order: " + numberItems);
			*/
		}//end of closed! while
	}//end of main

	
	//methods to user prompts
	private static void adminModule() {

		Scanner sIn = new Scanner(System.in);

		boolean done = false;
		while (!done) {
			System.out.println("\n1: Shop Customer List");
			System.out.println("2: Customer Order History");
			System.out.println("3: Best Customer");
			System.out.println("4: Exit Admin Module");

			System.out.print("\nWhat would you like to do? (1-4): ");
			String choice = sIn.nextLine();

			switch (choice) {
				case "1":
					shopCustomerList();
					break;
				case "2":
					System.out.print("Enter the name of the customer: ");
					String custName = sIn.nextLine();
					customerOrderHistory(custName);
					break;
				case "3":
					bestCustomer();
					break;
				case "4":
					done = true;
					break;
			}
		}
	}

	private static void shopCustomerList() {
		//show a listing of all Dessert Shop customers + their Customer IDs
		for (String customer : customerDB.keySet()) {
			System.out.printf("%-30s%s%n", ("Costumer Name: " + customer), ("Costumer ID: " + customerDB.get(customer).getID()));
		}
	}

	private static void customerOrderHistory(String custName) {
		//ask the user for a customer name and then
		// print out all orders (receipts) for that customer
		if (customerDB.containsKey(custName)) {

			int indexOrder = 1;
			System.out.printf("%-30s%s%n", ("Costumer Name: " + custName), ("Costumer ID: " + customerDB.get(custName).getID()));
			System.out.println("------------------------------------------------------------------------");
			for (Order o : customerDB.get(custName).getOrderHistory()) {
				System.out.println("Order #: " + indexOrder);
				System.out.println(o);
				System.out.println();
				indexOrder++;
			}

		} else {
			System.out.println(custName + " is not a customer yet.");
		}
	}

	private static void bestCustomer() {
		//display a banner exclaiming who the best customer is based on the number
		// of orders each customer has made.
		Customer bestCustomer = null;
		int maxOrders = 0;
		for (Customer c : customerDB.values()) {
			int numOrders = c.getOrderHistory().size();
			if (numOrders > maxOrders) {
				maxOrders = numOrders;
				bestCustomer = c;
			}
		}

		System.out.println("------------------------------------------------------------------------");
		System.out.println("The Dessert Shop's most valued customer is: " + bestCustomer.getName() + "!");
		System.out.println("------------------------------------------------------------------------");


	}

	private static DessertItem userPromptCandy() {
		Scanner scanner = new Scanner(System.in);
		double weight = 0.0;
		double price = 0.0;

		System.out.print("Enter the type of candy: ");
		String type = scanner.nextLine();

		weight = doubleInputValidation(scanner, "Enter the weight: ", "Please enter a valid decimal number. ");

		price = doubleInputValidation(scanner, "Enter the price per pound: ", "Please enter a valid decimal number. ");

		//creating the candy
		Candy item = new Candy(type, weight, price);
		return item;

	}//end of Candy method

	private static DessertItem userPromptCookie() {
		Scanner scanner = new Scanner(System.in);
		
		int qty = 0;
		double price = 0.0;
		
		System.out.print("Enter the type of cookie: ");
		String type = scanner.nextLine();

		qty = intInputValidation(scanner, "Enter the quantity purchased: ", "Please enter a valid whole number. ");

		price = doubleInputValidation(scanner, "Enter the price per dozen: ", "Please enter a valid decimal number. ");

		//creating the cookie
		Cookie item = new Cookie(type, qty, price);
		return item;
	
	}//end of Cookie method

	private static DessertItem userPromptIceCream() {
		Scanner scanner = new Scanner(System.in);
		
		int qty = 0;
		double price = 0.0;
		
		System.out.print("Enter the type of Ice Cream used: ");
		String type = scanner.nextLine();

		qty = intInputValidation(scanner, "Enter the number of scoops: ", "Please enter a valid whole number. ");

		price = doubleInputValidation(scanner, "Enter the price per scoop: ", "Please enter a valid decimal number. ");

		//creating the icecream
		IceCream item = new IceCream(type, qty, price);
		
		return item;
	}//end of icecream method

	private static DessertItem userPromptSundae() {
	
		Scanner scanner = new Scanner(System.in);
		
		int qty = 0;
		double price = 0.0;
		double priceTopping = 0.0;
		
		System.out.print("Enter the type of Ice Cream used: ");
		String type = scanner.nextLine();

		qty = intInputValidation(scanner, "Enter the number of scoops: ", "Please enter a valid whole number. ");

		price = doubleInputValidation(scanner, "Enter the price per scoop: ", "Please enter a valid decimal number. ");
		
		System.out.print("Enter the type of topping used: ");
		String typeTopping = scanner.nextLine();
		
		priceTopping = doubleInputValidation(scanner, "Enter the price of the topping: ", "Please enter a valid decimal number. ");
		
		//creating the sundae
		Sundae item = new Sundae(type, qty, price, typeTopping, priceTopping);
		return item;
	}// end of sundae method

	//methods for input validation

	private static double doubleInputValidation(Scanner sIn, String question,String exceptionMessage) {

		double userInput = (double) 0;
		boolean done = false;

		do {

			System.out.print(question);
			String input = sIn.nextLine();

			try {
				userInput = Double.parseDouble(input);
				done = true;

			} catch (NumberFormatException e) {
				System.out.print(exceptionMessage);

			} //end of try catch
		} while (!done);
		return userInput;
	}

	private static int intInputValidation(Scanner sIn, String question, String exceptionMessage) {

		int userInput = 0;
		boolean done = false;

		do {

			System.out.print(question);
			String input = sIn.nextLine();

			try {
				userInput = Integer.parseInt(input);
				done = true;

			} catch (NumberFormatException e) {
				System.out.print(exceptionMessage);

			} //end of try catch
		} while (!done);
		return userInput;
	}

}
