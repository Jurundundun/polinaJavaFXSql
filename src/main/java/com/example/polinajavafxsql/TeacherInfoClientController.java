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

    @FXML
    private TableColumn<Client, LocalDate> dataContract;

    @FXML
    private TableColumn<Client, LocalDate> dateOfPayment;


    @FXML
    private TableColumn<Client, Integer> idContract;

    @FXML
    private TableColumn<Client, Integer> idReciept;

    @FXML
    private TableColumn<Client, String> idSubdivision;

    @FXML
    private TableColumn<Client, String> issuedBy;

    @FXML
    private TableColumn<Client, Integer> pasportNumber;

    @FXML
    private TableColumn<Client, Integer> passportSeries;


    @FXML
    private TableColumn<Client, String> review;


    @FXML
    private TableColumn<Client, LocalDate> whenIssued;
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
        dataContract.setCellValueFactory(new PropertyValueFactory<>("dataContract"));
        dateOfPayment.setCellValueFactory(new PropertyValueFactory<>("dateOfPayment"));
        idContract.setCellValueFactory(new PropertyValueFactory<>("idContract"));
        idReciept.setCellValueFactory(new PropertyValueFactory<>("idReciept"));
        idSubdivision.setCellValueFactory(new PropertyValueFactory<>("idSubdivision"));
        issuedBy.setCellValueFactory(new PropertyValueFactory<>("issuedBy"));
        pasportNumber.setCellValueFactory(new PropertyValueFactory<>("pasportNumber"));
        passportSeries.setCellValueFactory(new PropertyValueFactory<>("passportSeries"));
        review.setCellValueFactory(new PropertyValueFactory<>("review"));
        whenIssued.setCellValueFactory(new PropertyValueFactory<>("whenIssued"));


        connection = ConnectionDb.connectingToDatabase();
        clientList = DataEntityFromDb.getClientFromDb(connection);
        tableClient.setItems(clientList);
    }
}
