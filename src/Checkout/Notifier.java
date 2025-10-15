package Checkout;

import Payment.Payment;

public class Notifier {
    private final String email;

    public Notifier(String email) {
        this.email = email;
    }

    public void sendMsg(double amount) {
        System.out.println("Payment: " + amount + "$ \n" + "Sent to " + email);
    }

    public void sendMsgWithReceipt(double amount, Payment payment) {
        Receipt receipt = new Receipt();
        this.sendMsg(amount);
        System.out.println("Receipt: ");
        receipt.takeReceipt(amount, payment);
    }
}
