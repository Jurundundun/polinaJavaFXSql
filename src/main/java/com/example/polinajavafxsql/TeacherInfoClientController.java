package com.example.polinajavafxsql;

import com.example.polinajavafxsql.entity.Client;
import com.example.polinajavafxsql.entity.Service;
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

public class TeacherInfoClientController implements Initializable {
    @FXML
    private TableColumn<Client, LocalDate> birthDateChild;

    @FXML
    private TableColumn<Client, String> email;

    @FXML
    private TableColumn<Client, String> fioChild;

    @FXML
    private TableColumn<Client, String> fioParent;

    @FXML
    private TableColumn<Client, Integer> id;

    @FXML
    private TableColumn<Client, String> phoneNumber;

    @FXML
    private TableView<Client> tableClient;
    private ObservableList<Client> clientList;
    private Connection connection;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        birthDateChild.setCellValueFactory(new PropertyValueFactory<>("birthDateChild"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        fioChild.setCellValueFactory(new PropertyValueFactory<>("fioChild"));
        fioParent.setCellValueFactory(new PropertyValueFactory<>("fioParent"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));


        connection = ConnectionDb.connectingToDatabase();
        clientList = DataEntityFromDb.getClientFromDb(connection);
        tableClient.setItems(clientList);
    }
}
