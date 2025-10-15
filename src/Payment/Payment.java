package Payment;

public interface Payment {
    double getSum();
    void addMoney(double sum);
    boolean pay(double sum);
}
