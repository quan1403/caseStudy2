package Models;

import java.io.Serializable;

public class Product implements Serializable {
    private int idCaterory;
    private String nameCaterory;

    private int idProduct;
    private String nameProduct;
    private double price;
    private int amount;

    private String describe;

    public Product(String nameProduct, double price, int amount) {
    }

    public Product(int idCaterory, String nameCaterory, int idProduct, String nameProduct, double price, int amount,  String describe) {
        this.idCaterory = idCaterory;
        this.nameCaterory = nameCaterory;
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.amount = amount;

        this.describe = describe;
    }

    public int getIdCaterory() {
        return idCaterory;
    }

    public void setIdCaterory(int idCaterory) {
        this.idCaterory = idCaterory;
    }

    public String getNameCaterory() {
        return nameCaterory;
    }

    public void setNameCaterory(String nameCaterory) {
        this.nameCaterory = nameCaterory;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idCaterory=" + idCaterory +
                ", nameCaterory='" + nameCaterory + '\'' +
                ", idProduct=" + idProduct +
                ", nameProduct='" + nameProduct + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", describe='" + describe + '\'' +
                '}';
    }

    public String showSp(){
        return " idProduct=" + idProduct +
                ", nameProduct='" + nameProduct + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", describe='" + describe ;
    }
}
