package com.example.addtocart;

import javafx.scene.input.MouseEvent;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class cardProductControllerTest {
    @Test
    void cardproducttest() throws IOException {
        String name = null;
        double price = 0;
        String image = null;
        int quantity = 0;
        cardProductController card = new cardProductController();
        card.productData("name", 4.21, "path");
        card.addItem();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bigbitedonuts", "root", "dinosaur1234");
            statement = connection.prepareStatement("SELECT * FROM bigbitedonuts.order");
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                name = resultSet.getString("name");
                price = resultSet.getDouble("price");
                quantity = resultSet.getInt("quantity");
                image = resultSet.getString("image");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertEquals("name", name);
        assertEquals(4.21, price);
        assertEquals("path", image);
        assertEquals(2, quantity);
    }
}