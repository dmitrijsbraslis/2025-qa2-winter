package model.mans.rimi;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Purchase {
    private Shop shop;
    private User user;
    private List<Product> products;
    private LocalDateTime timestamp;

    public Purchase(Shop shop) {
        this.shop = shop;
        this.products = new ArrayList<>();
        this.timestamp = LocalDateTime.now();
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void identifyUser(Card card) {
        user = card.getUser();
    }

    public void printReceipt() {
        System.out.println("-------Receipt Begin--------");
        System.out.println("User: " + user.getFirstName());

        //for (int i = 0; i < products.size(); i++) { // i++ -> i = i + 1
            //Do something with each element from a list
        //}

        for (Product p : products) {
            System.out.println(p.getName() + ": " + p.getPrice());
        }
    }
}
