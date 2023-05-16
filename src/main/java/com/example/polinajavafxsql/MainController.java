package com.example.polinajavafxsql;

import com.example.polinajavafxsql.jdbc.DownloadTables;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        //DownloadTables.downloadTables();
        Parent root = FXMLLoader.load(getClass().getResource("mainMenu/mainMenu.fxml"));
        primaryStage.setTitle("MainMenu");
        primaryStage.setScene(new Scene(root, 283, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}