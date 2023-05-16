package com.example.polinajavafxsql;

import com.example.polinajavafxsql.entity.Service;
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

public class TeacherServiceClientController implements Initializable {
    @FXML
    private TableColumn<Service, Integer> id;

    @FXML
    private TableColumn<Service, Integer> idOrganization;

    @FXML
    private TableColumn<Service, String> name;

    @FXML
    private TableColumn<Service, String> price;

    @FXML
    private TableView<Service> tableServices;

    private ObservableList<Service> serviceList;
    private Connection connection;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<Service, Integer>("id"));
        idOrganization.setCellValueFactory(new PropertyValueFactory<Service, Integer>("idOrganization"));
        name.setCellValueFactory(new PropertyValueFactory<Service, String>("name"));
        price.setCellValueFactory(new PropertyValueFactory<Service, String>("price"));

        connection = ConnectionDb.connectingToDatabase();
        serviceList = DataEntityFromDb.getServiceFromDb(connection);
        tableServices.setItems(serviceList);
    }
}
