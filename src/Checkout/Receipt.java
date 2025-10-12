package Checkout;

import Payment.*;

public class Receipt {

    public void takeReceipt(double amount, Payment payment) {
        String paymentType = checkType(payment);

        System.out.println(
                "-----------------------------------\n"
                        + "|            RECEIPT             \n"
                        + "|                                \n"
                        + "|    Paid with:      " + paymentType + "\n"
                        + "|                                \n"
                        + "|    Total cost:     " + amount + "$\n"
                        + "|                                \n"
                        + "-----------------------------------\n"

        );
    }

    private String checkType(Payment payment) {
        String payer = "";
        if (payment instanceof PayPalPayment) {
            payer = "Paypal";
        } else if (payment instanceof CreditCardPayment) {
            payer = "Credit Card";
        }
        return payer;
    }
}
