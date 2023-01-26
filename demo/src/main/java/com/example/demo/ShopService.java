package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class ShopService {

    private Cart cart;
    private Customer customer;

    private ItemStorage itemStorage;

    public ShopService(Customer customer) {
        this.customer = customer;
        this.cart = new Cart(customer);
    }

    public Item findItemByName(String name) {
        for (Item item: itemStorage.getItemList()) {
            if(item.getName().equals(name)) {
                return item;
            }
            return null;
        }
        return null;
    }

    public void addItemToCart(String itemName) {
        if(findItemByName(itemName) == null) {
            return;
        }
        double price = findItemByName(itemName).getPrice();
        String temporaryItem = findItemByName(itemName).getName();
        Cart cart = new Cart(new Customer(4, 150));
        cart.getItemList().add(new Item(temporaryItem, price));
    }

    public TransactionStatus orderItems(Cart cart) {
        double endPrice = 0;
        for (Item item: cart.getItemList()) {
            endPrice += item.getPrice();
        }
        TransactionStatus checkoutEnum = TransactionStatus.SUCCESS;

        if(cart.getItemList().isEmpty()) {
            System.out.println("Cart cannot be empty to finalize transaction");
            checkoutEnum = TransactionStatus.FAIL;
            return checkoutEnum;
        }
        if(cart.getCustomer().getBalance() < endPrice) {
            System.out.println("Not enough money on customers account");
            checkoutEnum = TransactionStatus.FAIL;
            return checkoutEnum;
        }

        double endSaldo = cart.getCustomer().getBalance() - endPrice;
        cart.getItemList().clear();
        cart.getCustomer().setBalance(endSaldo);
        return checkoutEnum;
    }

}
