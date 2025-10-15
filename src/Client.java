import Additions.*;
import Checkout.*;
import Customer.*;
import Payment.*;

import java.util.Scanner;

class Client {
    private static final Scanner input = new Scanner(System.in);
    private static Customer customer;
    private final static ShoppingNet shoppingNet =  new ShoppingNet();

    public void run() {
        System.out.println("Welcome to app, please enter your email for sending notifications:");
        String email = readString();
        customer = new Customer(email);
        runCustomer();
    }

    private void runCustomer() {
        while (true) {
            System.out.println("Welcome to E-commerce app choose your action:");
            System.out.println("0. exit");
            System.out.println("1. See List of PayPal accounts");
            System.out.println("2. See List of Credit Cards");
            System.out.println("3. Add PayPal account");
            System.out.println("4. Add Credit Card");
            System.out.println("5. Set another PayPal account");
            System.out.println("6. Set another Credit Card");
            System.out.println("7. Set email");
            System.out.println("8. Shop");
            System.out.println("9. Run Bank app");

            int number = readInt();

            switch (number) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    customer.checkCurrentPaypal();
                    break;
                case 2:
                    customer.checkCurrentCreditCard();
                    break;
                case 3:
                    customer.addPaypal(new PayPalPayment());
                    break;
                case 4:
                    customer.addCreditCard(new CreditCardPayment());
                    break;
                case 5:
                    System.out.println("Enter number of account:");
                    int paypalNumber = readInt();
                    customer.setCurrentPaypal(paypalNumber);
                    break;
                case 6:
                    System.out.println("Enter number of Credit Card:");
                    int creditCardNumber = readInt();
                    customer.setCurrentCreditCard(creditCardNumber);
                    break;
                case 7:
                    System.out.println("Enter new email:");
                    String email = readString();
                    customer.setEmail(email);
                    break;
                case 8:
                    runShop();
                    break;
                case 9:
                    runPaySys();
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    private void runShop() {
        while (true) {
            System.out.println("Welcome to Shop, choose your action:");
            System.out.println("0. exit");
            System.out.println("1. See List of Products");
            System.out.println("2. Add Product");
            System.out.println("3. Remove Product");

            int number = readInt();

            switch (number) {
                case 0:
                    runCustomer();
                    break;
                case 1:
                    shoppingNet.seeProductList();
                    break;
                case 2:
                    System.out.println("Enter number of product:");
                    int addNumber = readInt();
                    shoppingNet.addProduct(addNumber);
                    break;
                case 3:
                    System.out.println("Enter number of product:");
                    int rmNumber = readInt();
                    shoppingNet.removeProduct(rmNumber);
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    private void runPaySys() {
        while (true) {
            System.out.println("Payment app, please choose payment method:");
            System.out.println("0. exit");
            System.out.println("1. Credit card");
            System.out.println("2. PayPal");

            int number = readInt();

            switch (number) {
                case 0:
                    runCustomer();
                    break;
                case 1:
                    runPayment(customer.getCurrentCreditCard());
                    break;
                case 2:
                    runPayment(customer.getCurrentPaypal());
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
            System.out.println("4. Pay with detection,cashback,discount and receipt");
            System.out.println("5. Pay with detection,cashback,discount and notification");
            System.out.println("6. Add money safely");
            System.out.println("7. Check for sum");
            System.out.println("8. Process Order");

            int number = readInt();
            CheckoutFacade checkout = new CheckoutFacade();
            double amount;

            switch (number) {
                case 0:
                    runPayment(payment);
                    break;
                case 1:
                    amount = shoppingNet.countTotal();
                    checkout.payWithReceipt(payment, amount);
                    shoppingNet.updateTotal();
                    break;
                case 2:
                    amount = shoppingNet.countTotal();
                    checkout.doubleCashback(payment, amount);
                    shoppingNet.updateTotal();
                    break;
                case 3:
                    amount = shoppingNet.countTotal();
                    checkout.doubleDiscount(payment, amount);
                    shoppingNet.updateTotal();
                    break;
                case 4:
                    amount = shoppingNet.countTotal();
                    checkout.paySafelyWithDiscounts(payment, amount);
                    shoppingNet.updateTotal();
                    break;
                case 5:
                    amount = shoppingNet.countTotal();
                    checkout.paySafelyWithNotifier(payment, amount, customer.getEmail());
                    shoppingNet.updateTotal();
                    break;
                case 6:
                    System.out.println("Enter amount:");
                    double add = readDouble();
                    checkout.addSafely(payment, add);
                    break;
                case 7:
                    checkout.checkSum(payment);
                    break;
                case 8:
                    amount = shoppingNet.countTotal();
                    checkout.processOrder(payment, amount, customer.getEmail());
                    shoppingNet.updateTotal();
                    break;
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
            System.out.println("4. Operations through facade");
            System.out.println("5. Choose Addition");
            if (payment instanceof PayPalPayment) {
                System.out.println("6. Send money");
            }
            int number = readInt();
            double amount;

            switch (number) {
                case 0:
                    runPaySys();
                    break;
                case 1:
                    System.out.println("Now you have:" + payment.getSum());
                    break;
                case 2:
                    System.out.println("Enter amount:");
                    double add = readDouble();
                    payment.addMoney(add);
                    break;
                case 3:
                    amount = shoppingNet.countTotal();
                    payment.pay(amount);
                    shoppingNet.updateTotal();
                    break;
                case 4:
                    runFacade(payment);
                    break;
                case 5:
                    runDecorators(payment);
                    break;
                case 6:
                    if (payment instanceof PayPalPayment) {
                        System.out.println("Enter amount:");
                        double send = readDouble();
                        System.out.println("Enter ID to send:");
                        int id = readInt();
                        ((PayPalPayment) payment).sendMoneyTo(send, id);
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
            double amount;

            switch (number) {
                case 0:
                    runPayment(payment);
                    break;
                case 1:
                    amount = shoppingNet.countTotal();
                    cashback.pay(amount);
                    shoppingNet.updateTotal();
                    break;
                case 2:
                    amount = shoppingNet.countTotal();
                    discount.pay(amount);
                    shoppingNet.updateTotal();
                    break;
                case 3:
                    amount = shoppingNet.countTotal();
                    detection.pay(amount);
                    shoppingNet.updateTotal();
                    break;
                case 4:
                    System.out.println("Enter amount:");
                    double add = readDouble();
                    detection.addMoney(add);
                    break;
                case 5:
                    amount = shoppingNet.countTotal();
                    cashback.pay(discount.discountAmount(amount));
                    shoppingNet.updateTotal();
                    break;
                case 6:
                    amount = shoppingNet.countTotal();
                    detection.pay(discount.discountAmount(amount));
                    shoppingNet.updateTotal();
                    break;
                case 7:
                    amount = shoppingNet.countTotal();
                    cashback.addCashback(amount, detection.pay(amount));
                    shoppingNet.updateTotal();
                    break;
                case 8:
                    amount = shoppingNet.countTotal();
                    amount = discount.discountAmount(amount);
                    cashback.addCashback(amount, detection.pay(amount));
                    shoppingNet.updateTotal();
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

    private String readString() {
        while (true) {
            String line = input.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println("Enter a string: ");
                continue;
            }
            return line;
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
