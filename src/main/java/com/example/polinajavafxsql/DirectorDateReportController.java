package com.example.polinajavafxsql;

import com.example.polinajavafxsql.entity.Report;
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

public class DirectorDateReportController implements Initializable {
    @FXML
    private TableColumn<Report, LocalDate> data;

    @FXML
    private TableColumn<Report, Integer> id;

    @FXML
    private TableColumn<Report, Integer> idEmployee;

    @FXML
    private TableColumn<Report, Integer> idContract;

    @FXML
    private TableColumn<Report, Integer> idService;

    @FXML
    private TableView<Report> reportTable;

    private static ObservableList<Report> repostList;
    private static Connection connection;
    private static int pass;
    public static void changeListReport(ObservableList<Report> newReportList){
        repostList = newReportList;
        pass = 1;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        data.setCellValueFactory(new PropertyValueFactory<>("data"));
        idService.setCellValueFactory(new PropertyValueFactory<>("idService"));
        idContract.setCellValueFactory(new PropertyValueFactory<>("idContract"));
        idEmployee.setCellValueFactory(new PropertyValueFactory<>("idEmployee"));



        connection = ConnectionDb.connectingToDatabase();
        if(pass == 1){
            pass = 0;
        }else {
            repostList = DataEntityFromDb.getReportFromDb(connection);
        }
        reportTable.setItems(repostList);
    }
}
