import java.util.ArrayList;
import java.util.List;

class Product<T> {
    private String name;
    private T price;

    public Product(String name, T price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public T getPrice() {
        return price;
    }
}

class Shopkeeper<T> {
    private List<Product<T>> products;

    public Shopkeeper() {
        products = new ArrayList<>();
    }

    public void addProduct(Product<T> product) {
        products.add(product);
        System.out.println("Product added: " + product.getName());
    }

    public List<Product<T>> getProducts() {
        return products;
    }
}

class Consumer<T> {
    private List<Product<T>> cart;

    public Consumer() {
        cart = new ArrayList<>();
    }

    public void buyProduct(Product<T> product) {
        cart.add(product);
        System.out.println("Product bought: " + product.getName());
    }

    public List<Product<T>> getCart() {
        return cart;
    }
}

public class ShoppingApp {
    public static void main(String[] args) {
        Shopkeeper<Double> shopkeeper = new Shopkeeper<>();

        Product<Double> product1 = new Product<>("Phone", 999.99);
        Product<Double> product2 = new Product<>("Laptop", 1499.99);
        shopkeeper.addProduct(product1);
        shopkeeper.addProduct(product2);

        Consumer<Double> consumer = new Consumer<>();

        consumer.buyProduct(product1);
        consumer.buyProduct(product2);

        List<Product<Double>> cart = consumer.getCart();

        System.out.println("Products in the cart:");
        for (Product<Double> product : cart) {
            System.out.println(product.getName() + " - rs" + product.getPrice());
        }
    }
}
