package Additions;

import Payment.Payment;

public class CashbackDecorator extends MoneyAdditions {

    public CashbackDecorator(Payment payment) {
        super(payment);
    }

    @Override
    public void pay(double amount) {
        super.pay(amount);
        System.out.print("Cashback: ");
        addCashback(amount);
    }

    public void addCashback(double amount) {
        super.addMoney(amount*0.03);
    }
}
