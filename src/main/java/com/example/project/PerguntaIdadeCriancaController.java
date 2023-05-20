package com.example.project;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class PerguntaIdadeCriancaController {

    @FXML
    public Button bebeButton;
    @FXML
    public Button criancaButton;

    @FXML Button voltarButton;

    public void irEscalaBebe() throws IOException {
        Application.setRoot("glasgowBebe");
    }

    public void irEscalaCrianca() throws IOException {
        Application.setRoot("glasgowCrianca");
    }

    public void voltarMenu() throws IOException {
        Application.setRoot("menu");
    }
}
