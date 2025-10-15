package Product;

public abstract class Product {
    private final String name;
    private final double price;
    private int quantity = 0;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity() {
        this.quantity++;
        System.out.println("Quantity set to " + quantity);
    }

    public void decreaseQuantity() {
        if (quantity > 0){
            this.quantity--;
            System.out.println("Quantity set to " + quantity);
        } else {
            System.out.println("Quantity is 0");
        }
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
