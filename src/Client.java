import Additions.*;
import Checkout.CheckoutFacade;
import Payment.*;

import java.util.Scanner;

class Client {
    private static final Scanner input = new Scanner(System.in);
    private static final Payment creditCard = new CreditCardPayment();
    private static final Payment paypal = new PayPalPayment();
    private static final CheckoutFacade checkout = new CheckoutFacade();

    public void run() {
        while (true) {
            System.out.println("Payment app, please choose payment method:");
            System.out.println("0. exit");
            System.out.println("1. Credit card");
            System.out.println("2. PayPal");

            int number = readInt();

            switch (number) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    runPayment(creditCard);
                    break;
                case 2:
                    runPayment(paypal);
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    private void runFacade(Payment payment) {
        while (true) {
            System.out.println("Choose facade method:");
            System.out.println("0. exit");
            System.out.println("1. Pay with receipt");
            System.out.println("2. Pay with double cashback");
            System.out.println("3. Pay with double discount");
            System.out.println("4. Pay with detection, cashback and discount");
            System.out.println("5. Pay with detection,cashback,discount and receipt");
            System.out.println("6. Add money safely");
            System.out.println("7. Check for sum");

            int number = readInt();
            System.out.println("Enter amount");
            double amount;

            switch (number) {
                case 0:
                    runPayment(payment);
                    break;
                case 1:
                    amount = readDouble();
                    checkout.payWithReceipt(payment, amount);
                    break;
                case 2:
                    amount = readDouble();
                    checkout.doubleCashback(payment, amount);
                    break;
                case 3:
                    amount = readDouble();
                    checkout.doubleDiscount(payment, amount);
                    break;
                case 4:
                    amount = readDouble();
                    checkout.paySafelyWithDiscounts(payment, amount);
                    break;
                case 5:
                    amount = readDouble();
                    checkout.paySafelyWithDiscountsReceipt(payment, amount);
                    break;
                case 6:
                    amount = readDouble();
                    checkout.addSafely(payment, amount);
                    break;
                case 7:
                    checkout.checkSum(payment);
                default:
                    System.out.println("Invalid input");
            }
        }
    }


    public void runPayment(Payment payment) {
        while (true) {
            System.out.println("Choose operation:");
            System.out.println("0. exit");
            System.out.println("1. Check sum");
            System.out.println("2. Add money");
            System.out.println("3. Pay");
            System.out.println("4. Use Facade");
            if (payment instanceof PayPalPayment) {
                System.out.println("10. Send money");
            }
            System.out.println("5. Choose Addition");

            int number = readInt();
            System.out.println("Enter amount:");
            double amount;

            switch (number) {
                case 0:
                    run();
                    break;
                case 1:
                    System.out.println("Now you have:" + payment.getSum());
                    break;
                case 2:
                    amount = readDouble();
                    payment.addMoney(amount);
                    break;
                case 3:
                    amount = readDouble();
                    payment.pay(amount);
                    break;
                case 4:
                    runFacade(payment);
                    break;
                case 5:
                    runDecorators(payment);
                    break;
                case 10:
                    amount = readDouble();
                    System.out.println("Enter ID to send:");
                    int id = readInt();
                    if (payment instanceof PayPalPayment) {
                        ((PayPalPayment) payment).sendMoneyTo(amount, id);
                    }
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    private void runDecorators(Payment payment) {
        CashbackDecorator cashback = new CashbackDecorator(payment);
        DiscountDecorator discount = new DiscountDecorator(payment);
        FraudDetectionDecorator detection = new FraudDetectionDecorator(payment);
        while (true) {
            System.out.println("Choose addition:");
            System.out.println("0. exit");
            System.out.println("1. Pay with cashback");
            System.out.println("2. Pay with discount");
            System.out.println("3. Pay with fraud detection");
            System.out.println("4. Add money with fraud detection");
            System.out.println("5. Pay with discount and cashback");
            System.out.println("6. Pay with discount and fraud detection");
            System.out.println("7. Pay with cashback and fraud detection");
            System.out.println("8. Pay with all decorations");

            int number = readInt();
            System.out.println("Enter amount:");
            double amount;

            switch (number) {
                case 0:
                    runPayment(payment);
                    break;
                case 1:
                    amount = readDouble();
                    cashback.pay(amount);
                    break;
                case 2:
                    amount = readDouble();
                    discount.pay(amount);
                    break;
                case 3:
                    amount = readDouble();
                    detection.pay(amount);
                    break;
                case 4:
                    amount = readDouble();
                    detection.addMoney(amount);
                    break;
                case 5:
                    amount = readDouble();
                    cashback.pay(discount.discountAmount(amount));
                    break;
                case 6:
                    amount = readDouble();
                    detection.pay(discount.discountAmount(amount));
                    break;
                case 7:
                    amount = readDouble();
                    cashback.addCashback(amount);
                    detection.pay(amount);
                    break;
                case 8:
                    amount = readDouble();
                    amount = discount.discountAmount(amount);
                    cashback.addCashback(amount);
                    detection.pay(amount);
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    private int readInt() {
        while (true) {
            String line = input.nextLine().trim();
            if (line.isEmpty()) {
                System.out.print("Enter a number: ");
                continue;
            }
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException ex) {
                System.out.print("Not a number. Try again: ");
            }
        }
    }

    private double readDouble() {
        while (true) {
            String line = input.nextLine().trim();
            if (line.isEmpty()) {
                System.out.print("Enter a number: ");
                continue;
            }
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException ex) {
                System.out.print("Not a valid number. Try again: ");
            }
        }
    }
}
