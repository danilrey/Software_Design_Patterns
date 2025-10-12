package Checkout;

import Additions.*;
import Payment.*;

public class CheckoutFacade {

    public void payWithReceipt(Payment payment, double amount) {
        Receipt receipt = new Receipt();
        payment.pay(amount);
        receipt.takeReceipt(amount, payment);
    }

    public void doubleCashback(Payment payment, double amount) {
        CashbackDecorator cashback = new CashbackDecorator(payment);
        cashback.pay(amount);
        cashback.addCashback(amount);
        System.out.println("Cashback applied two times");
    }

    public void doubleDiscount(Payment payment, double amount) {
        DiscountDecorator discount = new DiscountDecorator(payment);
        discount.addDiscount();
        discount.pay(amount);
        System.out.println("Discount applied two times");
    }

    public void paySafelyWithDiscounts(Payment payment, double amount) {
        DiscountDecorator discount = new DiscountDecorator(payment);
        CashbackDecorator cashback = new CashbackDecorator(payment);
        FraudDetectionDecorator detection = new FraudDetectionDecorator(payment);
        amount = discount.discountAmount(amount);
        cashback.addCashback(amount);
        detection.pay(amount);
    }

    public void paySafelyWithDiscountsReceipt(Payment payment, double amount) {
        Receipt receipt = new Receipt();
        DiscountDecorator discount = new DiscountDecorator(payment);
        CashbackDecorator cashback = new CashbackDecorator(payment);
        FraudDetectionDecorator detection = new FraudDetectionDecorator(payment);
        amount = discount.discountAmount(amount);
        cashback.addCashback(amount);
        detection.pay(amount);
        receipt.takeReceipt(amount,payment);
    }

    public void addSafely(Payment payment, double amount) {
        FraudDetectionDecorator detection = new FraudDetectionDecorator(payment);
        detection.addMoney(amount);
    }

    public void checkSum(Payment payment) {
        System.out.println("Now you have:" + payment.getSum());
    }
}
