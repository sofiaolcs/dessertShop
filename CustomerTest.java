package DessertShop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void getID() {
        Customer c1 = new Customer("Lucas");
        assertEquals(c1.getID(), 1003);
    }

    @Test
    void getName() {
        Customer c1 = new Customer("Lucas");
        assertEquals(c1.getName(), "Lucas");
    }

    @Test
    void setName() {
        Customer c1 = new Customer("Lucas");
        c1.setName("Lucas Texeira");
        assertEquals(c1.getName(), "Lucas Texeira");
    }

    @Test
    void getOrderHistory() {
        ArrayList<Order> order = new ArrayList<>();
        Customer c1 = new Customer("Lucas");
        assertEquals(c1.getOrderHistory(), order);
    }

    @Test
    void addToHistory() {
        Customer c1 = new Customer("Lucas");
        c1.addToHistory(new Order());
        assertEquals((c1.getOrderHistory()).size(), 1);
    }

}