module com.example.addtocart {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javax.mail;


    opens com.example.addtocart to javafx.fxml;
    exports com.example.addtocart;
}