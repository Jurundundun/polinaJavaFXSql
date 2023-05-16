package com.example.polinajavafxsql;

import com.example.polinajavafxsql.entity.Client;
import com.example.polinajavafxsql.entity.Contract;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.util.stream.Collectors;

public class MenuDirectorController {
    @FXML
    private Button childs;

    @FXML
    private Button contractYear;

    @FXML
    private Button contracts;

    @FXML
    private Button listOfEmploye;
    @FXML
    private Button listOfEmployeByGend;
    @FXML
    private Button numberOfStudents;

    @FXML
    private Button numberOfclasses;

    @FXML
    private Button numberOfsevices;

    @FXML
    private Button qualificationOfEmploye;

    @FXML
    private Button qulificationYear;

    @FXML
    private Button receiptList;

    @FXML
    private Button registration;

    @FXML
    private Button serviceByCondition;

    @FXML
    private Button setServices;

    @FXML
    private Button timetableOfDate;

    @FXML
    private Button timetableOfEmploye;

    @FXML
    private Button viewServices;

    @FXML
    void getClientsQulificationYear(ActionEvent event) throws IOException {

    }

    @FXML
    void getContractsThisYear(ActionEvent event) throws IOException {
        Connection connection = ConnectionDb.connectingToDatabase();
        ObservableList<Contract> contractList,result;
        contractList = DataEntityFromDb.getContractFromDb(connection);
        result = contractList.stream().filter(c ->
                        String.valueOf(c.getContractData().getYear()).equals("2023") )
                .collect(Collectors.toCollection(FXCollections::observableArrayList));
        AdministratorContractController.changeListContract(result);
        Parent root = FXMLLoader.load(getClass().getResource("administrator/contracts.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void getFormOfDate(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("teacher/dateForm.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void getFormOfRegistration(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("administrator/clientForm.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void getFormServices(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("teacher/serviceClient.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void getListOfChilds(ActionEvent event) throws IOException {
        Connection connection = ConnectionDb.connectingToDatabase();
        ObservableList<Client> contractList,result;
        contractList = DataEntityFromDb.getClientFromDb(connection);
        result = contractList.stream().filter(c ->
                        2023 - c.getBirthDateChild().getYear() < 11 )
                .collect(Collectors.toCollection(FXCollections::observableArrayList));
        Parent root = FXMLLoader.load(getClass().getResource("teacher/infoClient.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void getListOfContracts(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("administrator/contracts.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void getListOfEmploye(ActionEvent event) {

    }

    @FXML
    void getListOfServices(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("teacher/serviceClient.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void getListOfqualification(ActionEvent event) {

    }

    @FXML
    void getNumberOfSevices(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("teacher/serviceClient.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void getNumberOfStudents(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("teacher/infoClient.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void getNumberOfclasses(ActionEvent event) {

    }

    @FXML
    void getReciptList(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("administrator/receipt.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void getListOfEmployeByGend(ActionEvent event) {

    }
    @FXML
    void getServiceByCondition(ActionEvent event) {

    }

    @FXML
    void getTimetableOfEmploye(ActionEvent event) {

    }
}
