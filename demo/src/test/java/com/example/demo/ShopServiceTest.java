package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ShopServiceTest {
    ShopService shopService;
    ItemStorage itemStorage;
    Customer customer;
    @BeforeEach
    void setup() {
        itemStorage = new ItemStorage();
        customer = new Customer(1, 100);
        shopService = new ShopService(customer);
    }

    @Test
    void itemDoesntExistsInDataBase() {
        Item testItem = shopService.findItemByName("vodka");
        assertThat(testItem).isNull();
    }

    @Test
    void succesfullyAddedItemToCart() {
        Cart cart = new Cart(customer);
        shopService.addItemToCart("milk");
        assertThat(cart.getItemList().toString()).isEqualTo("Cart{ customer=, itemList=}");
    }

    @Test
    void succesfulOrderedItems() {
        Customer customer = new Customer(2, 19);
        Cart cart = new Cart(customer);
        shopService.addItemToCart("water");
        TransactionStatus testTransactionStatus = shopService.orderItems(cart);
        assertThat(testTransactionStatus).isEqualTo(TransactionStatus.SUCCESS);
    }

}
