package Product;

public class PhoneCreator implements ProductCreator {
    @Override
    public Product createProduct(String name, double price) {
        return new Phone(name, price);
    }
}
