package com.example.polinajavafxsql;

import com.example.polinajavafxsql.entity.Client;
import com.example.polinajavafxsql.entity.Report;
import com.example.polinajavafxsql.jdbc.ConnectionDb;
import com.example.polinajavafxsql.jdbc.InsertEntityInDb;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class AdministratorClientFormController {

    @FXML
    private TextField birthDateChild;

    @FXML
    private Button button;

    @FXML
    private TextField email;

    @FXML
    private TextField fioChild;

    @FXML
    private TextField fioParent;

    @FXML
    private TextField id;

    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField idSubdivision;

    @FXML
    private TextField issuedBy;

    @FXML
    private TextField pasportNumber;

    @FXML
    private TextField passportSeries;


    @FXML
    private TextField whenIssued;

    private Connection connection;
    private Client client;

    @FXML
    void send(ActionEvent event) throws SQLException {
        client = new Client(
            LocalDate.parse(birthDateChild.getText()),
            email.getText(),
            fioChild.getText(),
            fioParent.getText(),
            Integer.parseInt(id.getText()),
            phoneNumber.getText(),
            idSubdivision.getText(),
            issuedBy.getText(),
            Integer.parseInt(pasportNumber.getText()),
            Integer.parseInt(passportSeries.getText()),
            LocalDate.parse(whenIssued.getText())



        );
        connection = ConnectionDb.connectingToDatabase();
        InsertEntityInDb.insertClientInDb(connection, client);
        InsertEntityInDb.insertPDKInDb(connection, client);
        button.getScene().getWindow().hide();
    }
}
