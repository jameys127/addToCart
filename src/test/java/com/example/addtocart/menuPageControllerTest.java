package com.example.addtocart;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class menuPageControllerTest {
    @Test
    void menuPageTest(){
        Product product1 = new Product("donut", 3, "path", 2);
        Product product2 = new Product("drink", 3, "path", 2);
        List<Product> productlist = new ArrayList<>();
        Collections.addAll(productlist, product1, product2);
        menuPageController page = new menuPageController();
        List<String> expected = Arrays.asList("donut");
        assertEquals(expected, page.searchProducts("donut", productlist));
    }
  
}