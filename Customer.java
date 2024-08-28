package DessertShop;

import java.util.ArrayList;

public class Customer {

    //attributes
    private String custName;
    private ArrayList<Order> orderHistory = new ArrayList<>();
    private int custID;
    private static int nextCustID = 1000;

    //constructors
    Customer(String custName) {
        this.custName = custName;
        custID = nextCustID++;
    }

    //methods
    public String getName() {
        return custName;
    }

    public void setName(String n) {
        custName = n;
    }

    public ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }

    public void addToHistory(Order o) {
        orderHistory.add(o);
    }

    public int getID() {
        return custID;
    }

}
