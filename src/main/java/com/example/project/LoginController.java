package com.example.project;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class LoginController {

    @FXML
    private Button loginButton;

    @FXML
    private Label loginError;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    protected void userLogin() throws IOException {
        checkLogin();
    }

    private void checkLogin() throws IOException {
        if (username.getText().equals("dino") && password.getText().equals("123")) {
            loginError.setText("Success!");
            Application.setRoot("glascow");


        } else {
            if (username.getText().isEmpty() || password.getText().isEmpty()) {
                loginError.setText("Preencha os campos vazios!");
            } else {
                loginError.setText("Login ou senha inválidos!");
            }
        }
    }
}

