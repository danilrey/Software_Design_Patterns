package Additions;

import Payment.Payment;

public class DiscountDecorator extends MoneyAdditions{
    private double discount = 0.05;

    public DiscountDecorator(Payment payment) {
        super(payment);
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Payment discount " + discount*100 + "%");
        return super.pay(discountAmount(amount));
    }

    public void addDiscount() {
        discount += 0.05;
    }

    public double discountAmount(double amount) {
        amount = amount - (amount * discount);
        return amount;
    }
}
