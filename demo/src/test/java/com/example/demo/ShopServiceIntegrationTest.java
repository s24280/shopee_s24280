package com.example.demo;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ShopServiceIntegrationTest {

    @MockBean
    private ItemStorage itemStorage;

    @Autowired
    private ShopService shopService;

    @Test
    void itemDoesntExistInDatabase() {
        when(shopService.findItemByName("water").getName()).thenReturn(String.valueOf(new Item("water", 1)));
        Item testItem = shopService.findItemByName("vodka");
        assertThat(testItem).isNull();
    }

    @Test
    void succesfullyAddedItemToCart() {
        ArrayList<Item> testList = new ArrayList<>();
        testList.add(new Item("test", 1));
        when(shopService.addItemToCart("milk")).thenReturn(new Item("milk", 1.5));
    }
}
