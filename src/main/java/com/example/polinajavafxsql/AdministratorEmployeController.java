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
    private TableColumn<Employee, LocalDate> data;

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
    private TableColumn<Employee, Integer> idSubdivision;

    @FXML
    private TableColumn<Employee, String> issuedBy;

    @FXML
    private TableColumn<Employee, String> nameOfCourse;

    @FXML
    private TableColumn<Employee, String> pasportNumber;

    @FXML
    private TableColumn<Employee, String> passportSeries;

    @FXML
    private TableColumn<Employee, String> phoneNumber;

    @FXML
    private TableColumn<Employee, LocalDate> whenIssued;

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
        phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        whenIssued.setCellValueFactory(new PropertyValueFactory<>("whenIssued"));
        passportSeries.setCellValueFactory(new PropertyValueFactory<>("passportSeries"));
        pasportNumber.setCellValueFactory(new PropertyValueFactory<>("pasportNumber"));
        nameOfCourse.setCellValueFactory(new PropertyValueFactory<>("nameOfCourse"));
        issuedBy.setCellValueFactory(new PropertyValueFactory<>("issuedBy"));
        idSubdivision.setCellValueFactory(new PropertyValueFactory<>("idSubdivision"));
        data.setCellValueFactory(new PropertyValueFactory<>("data"));



        connection = ConnectionDb.connectingToDatabase();
        if(pass == 1){
            pass = 0;
        }else {
            employeesList = DataEntityFromDb.getInfoEmployeeFromDb(connection);
        }
        employeeTable.setItems(employeesList);
    }
}
