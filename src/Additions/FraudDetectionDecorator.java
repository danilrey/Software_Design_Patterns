package Additions;

import Payment.Payment;

public class FraudDetectionDecorator extends MoneyAdditions {

    public FraudDetectionDecorator(Payment payment) {
        super(payment);
    }

    @Override
    public boolean pay(double amount) {
        if (amount > 100000) {
            System.out.println("Fraud behaviour detected, operation failed");
            return false;
        } else {
            System.out.println("Fraud behaviour doesn't detected, operation succeeded");
            return super.pay(amount);
        }
    }

    @Override
    public void addMoney(double amount) {
        if (amount > 100000) {
            System.out.println("Fraud behaviour detected, operation failed");
        } else {
            System.out.println("Fraud behaviour doesn't detected, operation succeeded");
            super.addMoney(amount);
        }
    }
}
