package Customer;

import Product.*;

import java.util.ArrayList;
import java.util.List;

public class ShoppingNet {
    private final List<Product> productList;
    ProductCreator laptopCreator = new LaptopCreator();
    ProductCreator phoneCreator = new PhoneCreator();
    private double total = 0;

    public ShoppingNet() {
        productList = new ArrayList<>();

        productList.add(laptopCreator.createProduct("MacBook Air 15",1200.6));
        productList.add(laptopCreator.createProduct("MacBook Air 13",1100.34));
        productList.add(laptopCreator.createProduct("MacBook Pro 14",1500.29));
        productList.add(laptopCreator.createProduct("MacBook Pro 16",1800.7));
        productList.add(laptopCreator.createProduct("Asus VivoBook 16",800.3));
        productList.add(laptopCreator.createProduct("Asus VivoBook 14",700.83));
        productList.add(laptopCreator.createProduct("Huawei MateBook 16",1000.45));
        productList.add(phoneCreator.createProduct("Iphone 16",800.4));
        productList.add(phoneCreator.createProduct("Iphone 16E",500.5));
        productList.add(phoneCreator.createProduct("Iphone 17",800.88));
        productList.add(phoneCreator.createProduct("Iphone 17 Pro",1000.92));
        productList.add(phoneCreator.createProduct("Iphone 17 Pro Max",1200.98));

    }

    public void seeProductList() {
        System.out.println("See the list of products in the Shopping Net");
        for (int i = 0; i<productList.size();i++) {
            System.out.println((i+1) + " " + productList.get(i).getName() + "    " + productList.get(i).getPrice() + "   " + productList.get(i).getQuantity());
        }
    }

    public void addProduct(int number) {
        if (productList.size() >= number && number > 0) {
            productList.get(number - 1).increaseQuantity();
        } else {
            System.out.println("Please enter a number between 1 and " + productList.size());
        }
    }

    public void removeProduct(int number) {
        if (productList.size() >= number && number > 0) {
            productList.get(number - 1).decreaseQuantity();
        } else {
            System.out.println("Please enter a number between 1 and " + productList.size());
        }
    }

    public double countTotal() {
        for (Product product : productList) {
            total += product.getPrice() * product.getQuantity();
        }
        return total;
    }

    public void updateTotal() {
        for (Product product : productList) {
            product.setQuantity(0);
        }
        total = 0;
    }
}
