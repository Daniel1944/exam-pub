package com.exam.tavern_exam.model;

public class Validation {
    private int userId;
    private int drinkId;
    private double price;
    private String canOrder;

    public Validation(int userId, int drinkId, double price, String canOrder) {
        this.userId = userId;
        this.drinkId = drinkId;
        this.price = price;
        this.canOrder = canOrder;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(int drinkId) {
        this.drinkId = drinkId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCanOrder() {
        return canOrder;
    }

    public void setCanOrder(String canOrder) {
        this.canOrder = canOrder;
    }

    @Override
    public String toString() {
        return "Validation{" +
                "userId=" + userId +
                ", drinkId=" + drinkId +
                ", price=" + price +
                ", canOrder='" + canOrder + '\'' +
                '}';
    }
}
