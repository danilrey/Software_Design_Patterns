package Payment;

public class CreditCardPayment implements Payment {
    private double amount;

    public CreditCardPayment() {
        amount = 0;
    }

    @Override
    public double getSum() {
        return amount;
    }

    @Override
    public void addMoney(double sum) {
        if (sum < 0) {
            System.out.println("We can't add negative amount");
        } else {
            amount += sum;
            System.out.println("Added amount " + sum + " by card");
        }
    }

    @Override
    public void pay(double sum) {
        if (sum < 0 || amount < sum) {
            System.out.println("We can't pay negative amount");
        } else {
            amount -= sum;
            System.out.println("Payed amount " + sum + " by card");
        }
    }
}
