package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Customer {

    int id;
    double balance;

    public Customer(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }
}
