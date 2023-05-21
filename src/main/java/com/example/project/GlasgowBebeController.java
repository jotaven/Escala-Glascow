package com.example.project;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Toggle;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class GlasgowBebeController {
    @FXML
    public Button resetButton;

    @FXML
    private Label gcsResultado;

    @FXML
    private Label gcsValores;

    @FXML
    private Button voltarButton;


    @FXML
    private Button infoEscala;

    @FXML
    private Button infoGlascow;

    @FXML
    private ToggleGroup respostaVerbal;

    @FXML
    private ToggleGroup aberturaOcular;

    @FXML
    private ToggleGroup respostaMotora;

    @FXML
    private ToggleGroup respostaPupilar;




    @FXML
    public void pegaSelecionado() {
        RadioButton r1 = (RadioButton) aberturaOcular.getSelectedToggle();
        if (r1==null)
            return;

        RadioButton r2 = (RadioButton) respostaVerbal.getSelectedToggle();
        if (r2==null)
            return;

        RadioButton r3 = (RadioButton) respostaMotora.getSelectedToggle();
        if (r3==null)
            return;

        RadioButton r4 = (RadioButton) respostaPupilar.getSelectedToggle();
        if (r4==null)
            return;


        int valorAberturaOcular;
        switch (r1.getText()) {
            case "Espontânea" -> valorAberturaOcular = 4;
            case "Ao chamado" -> valorAberturaOcular = 3;
            case "À dor" -> valorAberturaOcular = 2;
            case "Ausente" -> valorAberturaOcular = 1;
            default -> valorAberturaOcular = 0;
        }

        int valorRespostaVerbal;
        switch (r2.getText()) {
            case "Murmúrio, balbucia" -> valorRespostaVerbal = 5;
            case "Choro, irritação" -> valorRespostaVerbal = 4;
            case "Choro à dor" -> valorRespostaVerbal = 3;
            case "Gemido à dor" -> valorRespostaVerbal = 2;
            case "Ausente" -> valorRespostaVerbal = 1;
            default -> valorRespostaVerbal = 0;
        }

        int valorRespostaMotora;
        switch (r3.getText()) {
            case "Movimentos espontâneos" -> valorRespostaMotora = 6;
            case "Retira ao toque" -> valorRespostaMotora = 5;
            case "Retira à dor" -> valorRespostaMotora = 4;
            case "Flexão anormal" -> valorRespostaMotora = 3;
            case "Extensão anormal" -> valorRespostaMotora = 2;
            case "Ausente" -> valorRespostaMotora = 1;
            default -> valorRespostaMotora = 0;
        }

        int valorRespostaPupilar;
        switch (r4.getText()) {
            case "Unilateral" -> valorRespostaPupilar = 1;
            case "Ausente" -> valorRespostaPupilar = 2;
            default -> valorRespostaPupilar = 0;
        }

        int somaCriterios = valorAberturaOcular + valorRespostaVerbal + valorRespostaMotora - valorRespostaPupilar;

        String mensagemResultado;
        mensagemResultado = somaCriterios + " Pontos.";

        gcsResultado.setText(mensagemResultado);

        String mensagemValores = "O(" + valorAberturaOcular + ")V(" + valorRespostaVerbal + ")M(" + valorRespostaMotora + ") - P(" + valorRespostaPupilar + ")";
        gcsValores.setText(mensagemValores);
    }

    @FXML
    public void resetButtonOnAction() {
        Toggle ocularCheckBox = aberturaOcular.getSelectedToggle();
        Toggle motoraCheckBox = respostaMotora.getSelectedToggle();
        Toggle verbalCheckBox = respostaVerbal.getSelectedToggle();
        Toggle pupilarCheckBox = respostaPupilar.getSelectedToggle();
        if (ocularCheckBox != null)
            ocularCheckBox.setSelected(false);
        if (motoraCheckBox != null)
            motoraCheckBox.setSelected(false);
        if (verbalCheckBox != null)
            verbalCheckBox.setSelected(false);
        if (pupilarCheckBox != null)
            pupilarCheckBox.setSelected(false);

        gcsResultado.setText("Preencha os dados!");
        gcsValores.setText("");
    }

    @FXML
    public void mostrarDetalhesEscala() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("infoEscala.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 500, 500);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Informações");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void mostrarDetalhesGlasgow() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("infoGlasgow.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 500, 500);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Informações");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void voltarMenu() throws IOException {
        Application.setRoot("PerguntaIdadeCrianca");
    }
}
