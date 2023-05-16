package com.example.polinajavafxsql;

import com.example.polinajavafxsql.entity.Employee;
import com.example.polinajavafxsql.jdbc.ConnectionDb;
import com.example.polinajavafxsql.jdbc.DataEntityFromDb;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AdministratorEmployeController implements Initializable {
    @FXML
    private TableColumn<Employee, LocalDate> birthDate;

    @FXML
    private TableColumn<Employee, String> email;

    @FXML
    private TableView<Employee> employeeTable;

    @FXML
    private TableColumn<Employee, String> fio;

    @FXML
    private TableColumn<Employee, String> gen;

    @FXML
    private TableColumn<Employee, Integer> id;

    @FXML
    private TableColumn<Employee, Integer> idOrganization;

    @FXML
    private TableColumn<Employee, Integer> idPosition;

    @FXML
    private TableColumn<Employee, String> phoneNumber;

    private Connection connection;
    private static int pass;
    private static ObservableList<Employee> employeesList;

    public static void changeListEmploye(ObservableList<Employee> newEmployeList){
        employeesList = newEmployeList;
        pass = 1;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        birthDate.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        fio.setCellValueFactory(new PropertyValueFactory<>("fio"));
        gen.setCellValueFactory(new PropertyValueFactory<>("gen"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        idOrganization.setCellValueFactory(new PropertyValueFactory<>("idOrganization"));
        idPosition.setCellValueFactory(new PropertyValueFactory<>("idPosition"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));


        connection = ConnectionDb.connectingToDatabase();
        if(pass == 1){
            pass = 0;
        }else {
            employeesList = DataEntityFromDb.getEmployeeFromDb(connection);
        }
        employeeTable.setItems(employeesList);
    }
}
