package DessertShop;

/**
 * File: DessertShop.java
 * Description: interface Payable to choose a method of payment.
 * Lessons Learned:
 * 		Interface
 * 	    enum "class"
 * Instructor's Name: Jeff Light
 *
 * @author: Sofia Silva
 * @since: 5/30/2024
 */

public interface Payable {
    enum PayType{
        CASH,
        CARD,
        PHONE
    }

    PayType getPayType();
    void setPayType(PayType payMethod);
}
