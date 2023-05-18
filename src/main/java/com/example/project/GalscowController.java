package com.example.project;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

import java.io.IOException;

public class GalscowController {

    @FXML
    private Label gcsResultado;

    @FXML
    private Label gcsValores;

    @FXML
    private Button voltarButton;

    @FXML
    private Button AOButton;

    @FXML
    private ToggleGroup respostaVerbal;

    @FXML
    private ToggleGroup aberturaOcular;

    @FXML
    private ToggleGroup respostaMotora;


    @FXML
    public boolean opcoesEstaoVazia(RadioButton r1, RadioButton r2, RadioButton r3) {
        return r1 == null || r2 == null || r3 == null;
    }

    @FXML
    public void pegaSelecionado() {
        RadioButton r1 = (RadioButton) aberturaOcular.getSelectedToggle();
        RadioButton r2 = (RadioButton) respostaVerbal.getSelectedToggle();
        RadioButton r3 = (RadioButton) respostaMotora.getSelectedToggle();

        if (opcoesEstaoVazia(r1, r2, r3)) {
            return;
        }

        int valorAberturaOcular = 0;
        switch (r1.getText()) {
            case "Espontânea" -> valorAberturaOcular = 4;
            case "Ao chamado" -> valorAberturaOcular = 3;
            case "À dor" -> valorAberturaOcular = 2;
            case "Ausente" -> valorAberturaOcular = 1;
        }

        int valorRespostaVerbal = 0;
        switch (r2.getText()) {
            case "Orientado" -> valorRespostaVerbal = 5;
            case "Confuso" -> valorRespostaVerbal = 4;
            case "Palavras" -> valorRespostaVerbal = 3;
            case "Sons" -> valorRespostaVerbal = 2;
            case "Ausente" -> valorRespostaVerbal = 1;
        }

        int valorRespostaMotora = 0;
        switch (r3.getText()) {
            case "Obedece" -> valorRespostaMotora = 6;
            case "Localiza dor" -> valorRespostaMotora = 5;
            case "Movimento de retirada" -> valorRespostaMotora = 4;
            case "Flexão Anormal" -> valorRespostaMotora = 3;
            case "Extensão Anormal" -> valorRespostaMotora = 2;
            case "Ausente" -> valorRespostaMotora = 1;
        }

        int somaCriterios = valorRespostaVerbal + valorRespostaMotora + valorAberturaOcular;

        String mensagemResultado;
        mensagemResultado = somaCriterios + " Pontos.";

        gcsResultado.setText(mensagemResultado);

        String mensagemValores = "O(" + valorAberturaOcular + ")V(" + valorRespostaVerbal + ")M(" + valorRespostaMotora + ")";
        gcsValores.setText(mensagemValores);
    }

    @FXML
    public void voltarMenu() throws IOException {
        Application.setRoot("login");
    }
}
