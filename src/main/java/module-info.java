module com.example.addtocart {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.addtocart to javafx.fxml;
    exports com.example.addtocart;
}