package Additions;

import Payment.Payment;

abstract class MoneyAdditions implements Payment {
    private final Payment payment;

    public MoneyAdditions(Payment payment) {
        this.payment = payment;
    }

    @Override
    public double getSum() {
        return payment.getSum();
    }

    @Override
    public void addMoney(double money) {
        payment.addMoney(money);
    }

    @Override
    public void pay(double amount) {
        payment.pay(amount);
    }
}
