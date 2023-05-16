package com.example.polinajavafxsql;

import com.example.polinajavafxsql.entity.CompaniInfo;
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

public class CompaniInformationController implements Initializable {

    @FXML
    private TableColumn<CompaniInfo, String> actualAddress;

    @FXML
    private TableColumn<CompaniInfo, String> email;

    @FXML
    private TableColumn<CompaniInfo, String> fioDirector;

    @FXML
    private TableColumn<CompaniInfo, Integer> id;

    @FXML
    private TableColumn<CompaniInfo, String> lawAddress;

    @FXML
    private TableColumn<CompaniInfo, String> name;

    @FXML
    private TableColumn<CompaniInfo, String> phoneNumber;

    @FXML
    private TableView<CompaniInfo> infoTableView;
    private ObservableList<CompaniInfo> infoList;
    private Connection connection;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<CompaniInfo, Integer>("id"));
        actualAddress.setCellValueFactory(new PropertyValueFactory<CompaniInfo, String>("actualAddress"));
        email.setCellValueFactory(new PropertyValueFactory<CompaniInfo, String> ("email"));
        fioDirector.setCellValueFactory(new PropertyValueFactory<CompaniInfo, String>("fioDirector"));
        lawAddress.setCellValueFactory(new PropertyValueFactory<CompaniInfo, String>("lawAddress"));
        name.setCellValueFactory(new PropertyValueFactory<CompaniInfo, String> ("name"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<CompaniInfo, String> ("phoneNumber"));

        connection = ConnectionDb.connectingToDatabase();
        infoList = DataEntityFromDb.getInfoCompaniFromDb(connection);
        infoTableView.setItems(infoList);
    }
}
