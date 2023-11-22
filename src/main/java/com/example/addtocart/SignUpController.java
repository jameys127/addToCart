package com.example.addtocart;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
    @FXML
    private Button button_signup;

    @FXML
    private Button button_log_in;

    @FXML
    private RadioButton rb_bigbitedonuts;

    @FXML RadioButton rb_none;
    @FXML
    private TextField tf_username;

    @FXML
    private PasswordField tf_password;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ToggleGroup toggleGroup = new ToggleGroup();
        rb_bigbitedonuts.setToggleGroup(toggleGroup);
        rb_none.setToggleGroup(toggleGroup);

        rb_bigbitedonuts.setSelected(true);

        button_signup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String toggleName = ((RadioButton) toggleGroup.getSelectedToggle()).getText();


                if (!tf_username.getText().trim().isEmpty() && !tf_password.getText().trim().isEmpty()) {
                    DBUtils.signUpUser(event, tf_username.getText(), tf_password.getText(), toggleName);
                } else {
                    System.out.println("Please fill in all information");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please fill in all information to sign up!");
                    alert.show();
                }
            }
        });

        button_log_in.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                DBUtils.changeScene(event, "Sample.fxml", "Log in!", null, null);
            }
        });

    }
}
