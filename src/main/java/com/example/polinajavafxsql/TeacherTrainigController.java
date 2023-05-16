package com.example.polinajavafxsql;

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

public class TeacherTrainigController {

    @FXML
    private Button button;

    @FXML
    private TextField data;

    @FXML
    private TextField dateOfReceiving;

    @FXML
    private TextField id;

    @FXML
    private TextField idEmployee;

    @FXML
    private TextField licenseNumber;

    @FXML
    private TextField name;

    @FXML
    private TextField recordingDate;

    private Connection connection;
    private Training training;

    @FXML
    void send(ActionEvent event) throws SQLException {
        training = new Training(
                LocalDate.parse(data.getText()),
                LocalDate.parse(dateOfReceiving.getText()),
                Integer.parseInt(id.getText()),
                Integer.parseInt(idEmployee.getText()),
                licenseNumber.getText(),
                name.getText(),
                LocalDate.parse(recordingDate.getText())
        );
        connection = ConnectionDb.connectingToDatabase();
        InsertEntityInDb.insertTrainingInDb(connection,training);
        button.getScene().getWindow().hide();
    }
}
