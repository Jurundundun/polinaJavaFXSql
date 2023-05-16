package com.example.polinajavafxsql;

import com.example.polinajavafxsql.entity.Tabletime;
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
import java.time.LocalDate;
import java.util.ResourceBundle;

public class TabletimeController implements Initializable {
    @FXML
    private TableColumn<Tabletime, LocalDate> data;

    @FXML
    private TableColumn<Tabletime, String> dayOfTheWeek;

    @FXML
    private TableColumn<Tabletime, Integer> id;

    @FXML
    private TableColumn<Tabletime, Integer> idOrganization;

    @FXML
    private TableView<Tabletime> tabletimeTableView;

    @FXML
    private TableColumn<Tabletime, String> time;
    @FXML
    private TableColumn<Tabletime, Integer> idService;
    private static ObservableList<Tabletime> tabletimesList;
    private Connection connection;
    private static int pass;

    public static void changeListTabletime(ObservableList<Tabletime> newTabletimesList){
        tabletimesList = newTabletimesList;
        pass = 1;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        data.setCellValueFactory(new PropertyValueFactory<Tabletime,LocalDate>("data"));
        dayOfTheWeek.setCellValueFactory(new PropertyValueFactory<Tabletime,String>("dayOfTheWeek"));
        id.setCellValueFactory(new PropertyValueFactory<Tabletime,Integer>("id"));
        idOrganization.setCellValueFactory(new PropertyValueFactory<Tabletime,Integer>("idOrganization"));
        time.setCellValueFactory(new PropertyValueFactory<Tabletime,String>("time"));
        idService.setCellValueFactory(new PropertyValueFactory<Tabletime,Integer>("idService"));

        connection = ConnectionDb.connectingToDatabase();
        if(pass == 1){
            pass = 0;
        }else {
            tabletimesList = DataEntityFromDb.getTabletimesFromDb(connection);
        }
        tabletimeTableView.setItems(tabletimesList);
    }
}
