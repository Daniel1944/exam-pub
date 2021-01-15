package com.exam.tavern_exam.model;

public class User {
    // model class for mapping user table
    private int id;
    private String name;
    private boolean isAdult;
    private boolean isActive;
    private double money;

    public User(int id, String name, boolean isAdult, boolean isActive, double money) {
        this.id = id;
        this.name = name;
        this.isAdult = isAdult;
        this.isActive = isActive;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsAdult() {
        return isAdult;
    }

    public void setIsAdult(boolean isAdult) {
        this.isAdult = isAdult;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isAdult=" + isAdult +
                ", isActive=" + isActive +
                ", money=" + money +
                '}';
    }
}
