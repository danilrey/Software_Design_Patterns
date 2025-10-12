package Payment;

public class PayPalPayment implements Payment {
    public double amount;

    public PayPalPayment() {
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
            System.out.println("Added amount " + sum + " to pay pal payment");
        }
    }

    @Override
    public void pay(double sum) {
        if (sum < 0 || amount < sum) {
            System.out.println("We can't pay negative amount");
        } else {
            amount -= sum;
            System.out.println("Payed amount " + sum + " by paypal payment");
        }
    }

    public void sendMoneyTo(double sum, int id) {
        if (sum > amount ) {
            System.out.println("You don't have enough money, operation failed");
        } else {
            amount -= sum;
            System.out.println("You send " + sum + "$ to " + id);
        }
    }
}
