package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemStorage {

    private final List<Item> itemList = new ArrayList<>();

    public ItemStorage() {
        itemList.add(new Item("milk", 1.50));
        itemList.add(new Item("water", 1));
        itemList.add(new Item("beer", 2.50));
    }

    public List<Item> getItemList() {
        return itemList;
    }

    @Override
    public String toString() {
        return "ItemStorage{" +
                "itemList=" + itemList +
                '}';
    }
}
