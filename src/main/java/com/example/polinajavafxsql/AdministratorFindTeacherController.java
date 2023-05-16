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
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.util.stream.Collectors;

public class AdministratorFindTeacherController {
    @FXML
    private Button button;

    @FXML
    private TextField fio;

    private Connection connection;
    private ObservableList<Employee> employeeList,result;
    @FXML
    void send(ActionEvent event) throws IOException {
        connection = ConnectionDb.connectingToDatabase();
        employeeList = DataEntityFromDb.getEmployeeFromDb(connection);
        result = employeeList.stream().filter(e ->
                        e.getFio().equals(fio.getText()) && e.getIdPosition() == 3)
                .collect(Collectors.toCollection(FXCollections::observableArrayList));
        AdministratorEmployeController.changeListEmploye(result);
        button.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("administrator/employeeTable.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
