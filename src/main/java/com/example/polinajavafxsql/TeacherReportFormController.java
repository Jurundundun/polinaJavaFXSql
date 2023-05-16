package com.example.polinajavafxsql;

import com.example.polinajavafxsql.entity.Report;
import com.example.polinajavafxsql.entity.Training;
import com.example.polinajavafxsql.jdbc.ConnectionDb;
import com.example.polinajavafxsql.jdbc.InsertEntityInDb;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class TeacherReportFormController {
    @FXML
    private Button button;

    @FXML
    private TextField data;

    @FXML
    private TextField id;

    @FXML
    private TextField idContract;

    @FXML
    private TextField idEmployee;

    @FXML
    private TextField idService;
    private Connection connection;
    private Report report;

    @FXML
    void send(ActionEvent event) throws SQLException {
         report= new Report(
            LocalDate.parse(data.getText()),
            Integer.parseInt(id.getText()),
            Integer.parseInt(idContract.getText()),
            Integer.parseInt(idEmployee.getText()),
            Integer.parseInt(idService.getText())

        );
        connection = ConnectionDb.connectingToDatabase();
        InsertEntityInDb.insertReportInDb(connection,report);
        button.getScene().getWindow().hide();
    }
}
