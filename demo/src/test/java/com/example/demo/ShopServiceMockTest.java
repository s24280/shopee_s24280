package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ShopServiceMockTest {

    @Mock
    private ItemStorage itemStorage;

    @InjectMocks
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
