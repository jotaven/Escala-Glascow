package com.example.project;

import java.sql.*;

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
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    @FXML
    protected void userLogin() throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            loginError.setText("Preencha os campos vazios!");
            return;
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/loginfx", "root", "1234");

            pst = con.prepareStatement("SELECT * FROM usuarios WHERE login = ? and senha = ?");
            pst.setString(1, username);
            pst.setString(2, password);

            rs = pst.executeQuery();

            if (rs.next()) {
                Application.setRoot("menu");
            } else {
                loginError.setText("Login ou senha inválidos!");
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            loginError.setText("Falha ao conectar com a database");
        }
    }
}

