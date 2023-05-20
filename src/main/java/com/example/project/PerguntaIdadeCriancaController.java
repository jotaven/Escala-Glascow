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

    public void irEscalaBebe() {
        //Application.setRoot("");
    }

    public void irEscalaCrianca() {
        //Application.setRoot("");
    }

    public void voltarMenu() throws IOException {
        Application.setRoot("menu");
    }
}
