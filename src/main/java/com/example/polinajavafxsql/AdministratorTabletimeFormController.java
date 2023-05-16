package com.example.polinajavafxsql;

import com.example.polinajavafxsql.entity.Receipt;
import com.example.polinajavafxsql.entity.Tabletime;
import com.example.polinajavafxsql.jdbc.ConnectionDb;
import com.example.polinajavafxsql.jdbc.InsertEntityInDb;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class AdministratorTabletimeFormController {
    @FXML
    private Button button;

    @FXML
    private TextField data;

    @FXML
    private TextField dayOfWeek;

    @FXML
    private TextField id;

    @FXML
    private TextField idOrganization;

    @FXML
    private TextField idService;

    @FXML
    private TextField time;

    private Connection connection;
    private Tabletime tabletime;

    @FXML
    void send(ActionEvent event) throws SQLException {
        tabletime = new Tabletime(
                LocalDate.parse(data.getText()),
                dayOfWeek.getText(),
                Integer.parseInt(id.getText()),
                Integer.parseInt(idService.getText()),
                Integer.parseInt(idOrganization.getText()),
                time.getText()

        );
        connection = ConnectionDb.connectingToDatabase();
        InsertEntityInDb.insertTabletimeInDb(connection, tabletime);
        button.getScene().getWindow().hide();
    }
}
