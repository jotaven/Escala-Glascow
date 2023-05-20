package com.example.project;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class MenuController {
    @FXML
    public Button adultoButton;
    @FXML
    public Button pediatricoButton;

    @FXML
    public void irGlasgowAdulto() throws IOException {
        Application.setRoot("glasgow");
    }

    @FXML
    public void irGlasgowPediatrico() throws IOException {
        Application.setRoot("perguntaIdadeCrianca");
    }
}
