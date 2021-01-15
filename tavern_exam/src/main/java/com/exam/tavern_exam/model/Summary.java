package com.exam.tavern_exam.model;

public class Summary {
    private int userID;
    private String product;
    private int amount;
    private double price;
    private double unitPrice;
    private double summaryPrice;

    public Summary(String product, int amount, double unitPrice, double summaryPrice) {
        this.product = product;
        this.amount = amount;
        this.unitPrice = unitPrice;
        this.summaryPrice = summaryPrice;
    }

    public Summary(int userID, int amount, double price) {
        this.userID = userID;
        this.amount = amount;
        this.price = price;
    }

    public Summary(int userID, String product, double price) {
        this.userID = userID;
        this.product = product;
        this.price = price;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getSummaryPrice() {
        return summaryPrice;
    }

    public void setSummaryPrice(double summaryPrice) {
        this.summaryPrice = summaryPrice;
    }

    @Override
    public String toString() {
        return "Summary{" +
                "userID=" + userID +
                ", product='" + product + '\'' +
                ", ammount=" + amount +
                ", price=" + price +
                ", unitPrice=" + unitPrice +
                ", summaryPrice=" + summaryPrice +
                '}';
    }
}
