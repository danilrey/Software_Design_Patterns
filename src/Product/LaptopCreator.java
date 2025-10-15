package Product;

public class LaptopCreator implements ProductCreator{

    @Override
    public Product createProduct(String name, double price) {
        return new Laptop(name, price);
    }
}
