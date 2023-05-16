package com.example.polinajavafxsql;

import com.example.polinajavafxsql.entity.Receipt;
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
import java.util.ResourceBundle;

public class AdministratorReceiptController implements Initializable {
    @FXML
    private TableColumn<Receipt, Integer> id;

    @FXML
    private TableColumn<Receipt, Integer> idContract;

    @FXML
    private TableView<Receipt> receiptTable;

    private ObservableList<Receipt> receiptList;
    private Connection connection;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        idContract.setCellValueFactory(new PropertyValueFactory<>("idContract"));



        connection = ConnectionDb.connectingToDatabase();
        receiptList = DataEntityFromDb.getReceiptFromDb(connection);
        receiptTable.setItems(receiptList);
    }
}
