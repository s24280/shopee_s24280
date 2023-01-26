package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {
    Customer customer;
    private List<Item> itemList;

    public Cart(Customer customer) {
        this.customer = customer;
        itemList = new ArrayList<>();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "customer=" + customer +
                ", itemList=" + itemList +
                '}';
    }
}
