package com.example.polinajavafxsql;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuTeacherController {
    @FXML
    private Button client;

    @FXML
    private Button data;

    @FXML
    private Button employment;

    @FXML
    private Button qualification;

    @FXML
    private Button services;

    @FXML
    void clientInformation(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("teacher/infoClient.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void dateForm(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("teacher/dateForm.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void employmentReport(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("teacher/reportForm.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void servicesClient(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("teacher/serviceClient.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void training(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("teacher/trainingForm.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
