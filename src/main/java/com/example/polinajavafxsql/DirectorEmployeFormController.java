package com.example.polinajavafxsql;

import com.example.polinajavafxsql.entity.Client;
import com.example.polinajavafxsql.entity.Employee;
import com.example.polinajavafxsql.jdbc.ConnectionDb;
import com.example.polinajavafxsql.jdbc.InsertEntityInDb;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class DirectorEmployeFormController {
    @FXML
    private TextField birthDate;

    @FXML
    private Button button;

    @FXML
    private TextField email;

    @FXML
    private TextField fio;

    @FXML
    private TextField gen;

    @FXML
    private TextField id;

    @FXML
    private TextField idSubdivision;

    @FXML
    private TextField issuedBy;

    @FXML
    private TextField pasportNumber;

    @FXML
    private TextField passportSeries;

    @FXML
    private TextField phoneNumber;

    @FXML
    private TextField whenIssued;
    private Connection connection;
    private Employee employee;
    @FXML
    private TextField idOrganization;


    @FXML
    private TextField inPosition;

    @FXML
    void send(ActionEvent event) throws SQLException {
        employee = new Employee(
                LocalDate.parse(birthDate.getText()),
                email.getText(),
                fio.getText(),
                gen.getText(),
                Integer.parseInt(id.getText()),
                idSubdivision.getText(),
                issuedBy.getText(),
                Integer.parseInt(pasportNumber.getText()),
                Integer.parseInt(passportSeries.getText()),
                phoneNumber.getText(),
                LocalDate.parse(whenIssued.getText()),
                Integer.parseInt(idOrganization.getText()),
                Integer.parseInt(inPosition.getText())



        );
        connection = ConnectionDb.connectingToDatabase();
        InsertEntityInDb.insertEmployeeInDb(connection, employee);
        InsertEntityInDb.insertPDSInDb(connection, employee);
        button.getScene().getWindow().hide();

    }
}
