package Customer;

import Payment.*;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private PayPalPayment currentPaypal;
    private CreditCardPayment currentCreditCard;
    private final List<PayPalPayment> listPaypal;
    private final List<CreditCardPayment> listCreditCard;
    private String email;

    public Customer(String email) {
        currentPaypal = new PayPalPayment();
        currentCreditCard = new CreditCardPayment();
        listPaypal = new ArrayList<>();
        listCreditCard = new ArrayList<>();
        listPaypal.add(currentPaypal);
        listCreditCard.add(currentCreditCard);
        this.email = email;
    }


    public PayPalPayment getCurrentPaypal() {
        return currentPaypal;
    }

    public CreditCardPayment getCurrentCreditCard() {
        return currentCreditCard;
    }

    public void checkCurrentPaypal() {
        for (int i = 0; i < listPaypal.size(); i++) {
            if (listPaypal.get(i) == currentPaypal) {
                System.out.println("Paypal, number " + (i+1) + " -current");
            } else {
                System.out.println("Paypal, number " + (i+1));
            }
        }
    }

    public void checkCurrentCreditCard() {
        for (int i = 0; i < listCreditCard.size(); i++) {
            if (listCreditCard.get(i) == currentCreditCard) {
                System.out.println("Credit card, number " + (i+1) + " -current");
            } else {
                System.out.println("Credit card, number " + (i+1));
            }
        }
    }

    public void setCurrentPaypal(int order) {
        if (order <= listPaypal.size()) {
            currentPaypal = listPaypal.get(order - 1);
            System.out.println("Paypal, number " + (order) + " set");
        } else {
            System.out.println("Invalid order");
        }
    }

    public void setCurrentCreditCard(int order) {
        if (order <= listCreditCard.size()) {
            currentCreditCard = listCreditCard.get(order - 1);
            System.out.println("Credit card, number " + (order) + " set");
        } else {
            System.out.println("Invalid order");
        }
    }

    public void addPaypal(PayPalPayment paypal) {
        listPaypal.add(paypal);
        System.out.println("Paypal, number " + (listPaypal.size()) + " added");
    }

    public void addCreditCard(CreditCardPayment creditCard) {
        listCreditCard.add(creditCard);
        System.out.println("Credit card, number " + (listCreditCard.size()) + " added");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
