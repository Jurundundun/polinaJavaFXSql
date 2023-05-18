package com.example.polinajavafxsql;

import com.example.polinajavafxsql.entity.Service;
import com.example.polinajavafxsql.jdbc.ConnectionDb;
import com.example.polinajavafxsql.jdbc.DataEntityFromDb;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.util.stream.Collectors;

public class DirectorServiceExpensivePriceController {
    @FXML
    private Button button;

    @FXML
    private TextField price;

    private Connection connection;
    private ObservableList<Service> serviceList;



    @FXML
    void send(ActionEvent event) throws IOException {
        connection = ConnectionDb.connectingToDatabase();
        serviceList = DataEntityFromDb.getServiceFromDb(connection);
        TeacherServiceClientController.changeListService(serviceList.stream().filter(s ->
                        Double.parseDouble(s.getPrice()) > Double.parseDouble(price.getText()))
                .collect(Collectors.toCollection(FXCollections::observableArrayList)));
        button.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("teacher/serviceClient.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
