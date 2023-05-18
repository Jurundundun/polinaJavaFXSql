package com.example.polinajavafxsql;

import com.example.polinajavafxsql.entity.Client;
import com.example.polinajavafxsql.entity.Service;
import com.example.polinajavafxsql.jdbc.ConnectionDb;
import com.example.polinajavafxsql.jdbc.InsertEntityInDb;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class DirectorServiceFormController {

    @FXML
    private Button button;

    @FXML
    private TextField id;

    @FXML
    private TextField idOrganization;

    @FXML
    private TextField name;

    @FXML
    private TextField price;

    private Connection connection;
    private Service service;

    @FXML
    void send(ActionEvent event) throws SQLException {
        service = new Service(
                Integer.parseInt(id.getText()),
                name.getText(),
                price.getText(),
                Integer.parseInt(idOrganization.getText())





        );
        connection = ConnectionDb.connectingToDatabase();
        InsertEntityInDb.insertServiceInDb(connection, service);
        button.getScene().getWindow().hide();
    }
}
