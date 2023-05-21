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

public class GlasgowController {
    @FXML
    public Button resetButton;

    @FXML
    private Label gcsResultado;

    @FXML
    private Label gcsValores;

    @FXML
    private Label resultadoDesfavoravelLabel;

    @FXML
    private Label resultadoMortalidadeLabel;

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
            case "Orientado" -> valorRespostaVerbal = 5;
            case "Confuso" -> valorRespostaVerbal = 4;
            case "Palavras ininteligíveis" -> valorRespostaVerbal = 3;
            case "Sons incompreensiveis" -> valorRespostaVerbal = 2;
            case "Ausente" -> valorRespostaVerbal = 1;
            default -> valorRespostaVerbal = 0;
        }

        int valorRespostaMotora;
        switch (r3.getText()) {
            case "Obedece" -> valorRespostaMotora = 6;
            case "Localiza dor" -> valorRespostaMotora = 5;
            case "Movimento de retirada" -> valorRespostaMotora = 4;
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

        double porcentagemMortalidade = 0;
        double porcentagemDesfavoravel = 0;

        switch (somaCriterios) {
            case 1 -> {
                porcentagemMortalidade = 74.45;
                porcentagemDesfavoravel = 89.59;
            }
            case 2 -> {
                porcentagemMortalidade = 64.62;
                porcentagemDesfavoravel = 85.22;
            }
            case 3 -> {
                porcentagemMortalidade = 40.92;
                porcentagemDesfavoravel = 65.53;
            }
            case 4 -> {
                porcentagemMortalidade = 39.47;
                porcentagemDesfavoravel = 68.90;
            }
            case 5 -> {
                porcentagemMortalidade = 32.57;
                porcentagemDesfavoravel = 57.75;
            }
            case 6 -> {
                porcentagemMortalidade = 24.97;
                porcentagemDesfavoravel = 46.26;
            }
            case 7 -> {
                porcentagemMortalidade = 19.17;
                porcentagemDesfavoravel = 37.20;
            }
            case 8 -> {
                porcentagemMortalidade = 20.04;
                porcentagemDesfavoravel = 33.55;
            }
            case 9 -> {
                porcentagemMortalidade = 18.75;
                porcentagemDesfavoravel = 30.32;
            }
            case 10 -> {
                porcentagemMortalidade = 17.35;
                porcentagemDesfavoravel = 28.88;
            }
            case 11 -> {
                porcentagemMortalidade = 11.60;
                porcentagemDesfavoravel = 21.81;
            }
            case 12 -> {
                porcentagemMortalidade = 9.43;
                porcentagemDesfavoravel = 19.92;
            }
            case 13 -> {
                porcentagemMortalidade = 7.07;
                porcentagemDesfavoravel = 15.58;
            }
            case 14 -> {
                porcentagemMortalidade = 5.64;
                porcentagemDesfavoravel = 14.39;
            }
            case 15 -> {
                porcentagemMortalidade = 2.54;
                porcentagemDesfavoravel = 11.75;
            }
        }

        resultadoDesfavoravelLabel.setText(porcentagemDesfavoravel + "%");
        resultadoMortalidadeLabel.setText(porcentagemMortalidade + "%");

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
        resultadoMortalidadeLabel.setText("");
        resultadoDesfavoravelLabel.setText("");
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
            Scene scene = new Scene(fxmlLoader.load(), 700, 700);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setTitle("Informações");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void voltarMenu() throws IOException {
        Application.setRoot("menu");
    }
}
