package com.exam.tavern_exam.model;

public class DrinkMenu {
    private int id;
    private String productName;
    private double price;
    private boolean isForAdult;

    public DrinkMenu(int id, String productName, double price, boolean isForAdult) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.isForAdult = isForAdult;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isForAdult() {
        return isForAdult;
    }

    public void setForAdult(boolean forAdult) {
        isForAdult = forAdult;
    }

    @Override
    public String toString() {
        return "DrinkMenu{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", isForAdult=" + isForAdult +
                '}';
    }
}
