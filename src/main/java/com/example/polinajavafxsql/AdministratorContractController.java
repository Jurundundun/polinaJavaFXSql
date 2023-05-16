package com.example.polinajavafxsql;

import com.example.polinajavafxsql.entity.Contract;
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

public class AdministratorContractController implements Initializable {

    @FXML
    private TableColumn<Contract, LocalDate> contractData;

    @FXML
    private TableView<Contract> contractTable;

    @FXML
    private TableColumn<Contract, LocalDate> dateOfPayment;

    @FXML
    private TableColumn<Contract, Integer> id;

    @FXML
    private TableColumn<Contract, Integer> idClient;

    @FXML
    private TableColumn<Contract, Integer> idOrganization;

    private static ObservableList<Contract> contractList;
    private static Connection connection;
    private static int pass;
    public static void changeListContract(ObservableList<Contract> newContractList){
        contractList = newContractList;
        pass = 1;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        contractData.setCellValueFactory(new PropertyValueFactory<>("contractData"));
        dateOfPayment.setCellValueFactory(new PropertyValueFactory<>("dateOfPayment"));
        idClient.setCellValueFactory(new PropertyValueFactory<>("idClient"));
        idOrganization.setCellValueFactory(new PropertyValueFactory<>("idOrganization"));



        connection = ConnectionDb.connectingToDatabase();
        if(pass == 1){
            pass = 0;
        }else {
            contractList = DataEntityFromDb.getContractFromDb(connection);
        }
        contractTable.setItems(contractList);
    }
}
