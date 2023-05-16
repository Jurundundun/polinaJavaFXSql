package com.example.polinajavafxsql;

import com.example.polinajavafxsql.entity.Tabletime;
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
import java.util.stream.Collectors;

public class TeacherTimetableDateController {
    @FXML
    private Button button;

    @FXML
    private TextField data;
    private Connection connection;
    private ObservableList<Tabletime> tabletimeList,result;
    @FXML
    void get(ActionEvent event) throws IOException {
        connection = ConnectionDb.connectingToDatabase();
        tabletimeList = DataEntityFromDb.getTabletimesFromDb(connection);
        result = tabletimeList.stream().filter(tt ->
                        tt.getData().toString().equals(data.getText()))
                .collect(Collectors.toCollection(FXCollections::observableArrayList));
        TabletimeController.changeListTabletime(result);
        button.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("mainMenu/tabletime.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
