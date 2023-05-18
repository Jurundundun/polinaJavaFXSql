package com.example.polinajavafxsql;

import com.example.polinajavafxsql.entity.Employee;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class DirectorGenFormController {
    @FXML
    private Button button;

    @FXML
    private TextField gen;


    private Connection connection;
    private ObservableList<Employee> employeeList;



    @FXML
    void send(ActionEvent event) throws IOException {
        connection = ConnectionDb.connectingToDatabase();
        employeeList = DataEntityFromDb.getInfoEmployeeFromDb(connection);
        AdministratorEmployeController.changeListEmploye(employeeList.stream().filter(e ->
                        e.getGen().equals(gen.getText()))
                .collect(Collectors.toCollection(FXCollections::observableArrayList)));
        button.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("administrator/employeeTable.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
