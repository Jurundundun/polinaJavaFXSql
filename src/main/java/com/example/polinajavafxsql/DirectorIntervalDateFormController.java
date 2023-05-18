package com.example.polinajavafxsql;

import com.example.polinajavafxsql.entity.Report;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.stream.Collectors;

public class DirectorIntervalDateFormController {
    @FXML
    private Button button;

    @FXML
    private TextField firstDate;

    @FXML
    private TextField secondDate;
    private Connection connection;
    private ObservableList<Report> reportList;

    @FXML
    void send(ActionEvent event) throws IOException {
        connection = ConnectionDb.connectingToDatabase();
        reportList = DataEntityFromDb.getReportFromDb(connection);
        DirectorDateReportController.changeListReport(
                reportList.stream().filter(r ->
                        r.getData().getYear() <= LocalDate.parse(secondDate.getText()).getYear() &&
                                r.getData().getYear() >= LocalDate.parse(firstDate.getText()).getYear() &&

                                r.getData().getMonthValue() <= LocalDate.parse(secondDate.getText()).getMonthValue() &&
                                r.getData().getMonthValue() >= LocalDate.parse(firstDate.getText()).getMonthValue() &&

                                r.getData().getDayOfMonth() <= LocalDate.parse(secondDate.getText()).getDayOfMonth() &&
                                r.getData().getDayOfMonth() >= LocalDate.parse(firstDate.getText()).getDayOfMonth())
                .collect(Collectors.toCollection(FXCollections::observableArrayList)));
        button.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("director/report.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
