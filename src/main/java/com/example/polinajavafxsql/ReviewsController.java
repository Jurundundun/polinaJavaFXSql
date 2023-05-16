package com.example.polinajavafxsql;

import com.example.polinajavafxsql.entity.Reviews;
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

public class ReviewsController implements Initializable {
    @FXML
    private TableColumn<Reviews, Integer> id;

    @FXML
    private TableColumn<Reviews, Integer> idClient;

    @FXML
    private TableColumn<Reviews, String> reviews;

    @FXML
    private TableView<Reviews> tableReviews;

    ObservableList<Reviews> reviewsList;
    Connection connection;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<Reviews, Integer>("id"));
        idClient.setCellValueFactory(new PropertyValueFactory<Reviews, Integer>("idClient"));
        reviews.setCellValueFactory(new PropertyValueFactory<Reviews, String> ("reviews"));

        connection = ConnectionDb.connectingToDatabase();
        reviewsList = DataEntityFromDb.getReviewsFromDb(connection);
        tableReviews.setItems(reviewsList);
    }
}
