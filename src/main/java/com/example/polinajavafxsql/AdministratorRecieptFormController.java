package com.example.polinajavafxsql;

import com.example.polinajavafxsql.entity.Contract;
import com.example.polinajavafxsql.entity.Receipt;
import com.example.polinajavafxsql.jdbc.ConnectionDb;
import com.example.polinajavafxsql.jdbc.InsertEntityInDb;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class AdministratorRecieptFormController {
    @FXML
    private Button button;

    @FXML
    private TextField id;

    @FXML
    private TextField idContract;

    private Connection connection;
    private Receipt receipt;

    @FXML
    void send(ActionEvent event) throws SQLException {
        receipt = new Receipt(
                Integer.parseInt(id.getText()),
                Integer.parseInt(idContract.getText())
        );
        connection = ConnectionDb.connectingToDatabase();
        InsertEntityInDb.insertReceiptInDb(connection, receipt);
        button.getScene().getWindow().hide();
    }
}
