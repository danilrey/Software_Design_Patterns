package Additions;

import Payment.Payment;

public class CashbackDecorator extends MoneyAdditions {

    public CashbackDecorator(Payment payment) {
        super(payment);
    }

    @Override
    public boolean pay(double amount) {
        System.out.print("Cashback: ");
        return addCashback(amount, super.pay(amount));
    }

    public boolean addCashback(double amount, boolean validation) {
        if (validation) {
            super.addMoney(amount*0.03);
            return true;
        } else {
            System.out.println("Cashback could not be added");
            return false;
        }
    }
}
