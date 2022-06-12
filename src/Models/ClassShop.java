package Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ClassShop  implements Serializable {
    private List<Product> products = new ArrayList<>();
    private double prices;
    private String user;

    public ClassShop() {
    }

    public ClassShop(List<Product> products, double prices, String user) {
        this.products = products;
        this.prices = prices;
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getPrices() {
        return prices;
    }

    public void setPrices(double prices) {
        this.prices = prices;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        String str = "";
        for (Product p:products) {
            str += p.toString();
            str += "\n";
        }
        return "Giỏ hàng của : " + user + "\n" + str;
    }
}
