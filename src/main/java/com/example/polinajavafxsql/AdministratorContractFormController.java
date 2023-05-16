package com.example.polinajavafxsql;

import com.example.polinajavafxsql.entity.Contract;
import com.example.polinajavafxsql.jdbc.ConnectionDb;
import com.example.polinajavafxsql.jdbc.InsertEntityInDb;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class AdministratorContractFormController {

    @FXML
    private Button button;

    @FXML
    private TextField contractData;

    @FXML
    private TextField dateOfPayment;

    @FXML
    private TextField id;

    @FXML
    private TextField idClient;

    @FXML
    private TextField idOrganization;

    private Connection connection;
    private Contract contract;

    @FXML
    void send(ActionEvent event) throws SQLException {
        contract = new Contract(
            LocalDate.parse(contractData.getText()),
                LocalDate.parse(dateOfPayment.getText()),
                Integer.parseInt(id.getText()),
                Integer.parseInt(idClient.getText()),
                Integer.parseInt(idOrganization.getText())
        );
        connection = ConnectionDb.connectingToDatabase();
        InsertEntityInDb.insertContractInDb(connection, contract);
        button.getScene().getWindow().hide();
    }
}
