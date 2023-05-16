package com.example.polinajavafxsql;

import com.example.polinajavafxsql.entity.Employee;
import com.example.polinajavafxsql.jdbc.ConnectionDb;
import com.example.polinajavafxsql.jdbc.DataEntityFromDb;
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
import java.sql.SQLException;

public class MainLogInController {

    @FXML
    private Button btn;

    @FXML
    private TextField password;

    @FXML
    private TextField username;

    private ObservableList<Employee> employeeList;
    private Connection connection;
    private String path;

    @FXML
    void logIn(ActionEvent event) throws IOException {
        connection = ConnectionDb.connectingToDatabase();
        employeeList = DataEntityFromDb.getEmployeeFromDb(connection);
        Employee employee = employeeList.stream().filter(employe -> employe.getEmail().equals(username.getText())
                        && employe.getPhoneNumber().equals(password.getText()))
                .findFirst().orElse(null);
        if(employee != null){
            if(employee.getIdPosition() == 3){
                path = "teacher/teacher.fxml";
            } else if (employee.getIdPosition() == 2) {
                path = "administrator/administrator.fxml";
            } else if (employee.getIdPosition() == 1) {
                path = "director/director.fxml";
            }
            btn.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource(path));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

}
