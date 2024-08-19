package com.bloodbank;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Încarcă fișierul FXML
        Parent root = FXMLLoader.load(getClass().getResource("/main_view.fxml"));

        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("Blood Bank Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
