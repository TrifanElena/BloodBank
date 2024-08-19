package com.bloodbank;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CRUDWindow extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("CRUD Operations");

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);

        Label userLabel = new Label("User:");
        grid.add(userLabel, 0, 0);
        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 0);

        Label pwLabel = new Label("Password:");
        grid.add(pwLabel, 0, 1);
        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 1);

        Button addButton = new Button("Add");
        grid.add(addButton, 0, 2);

        Button updateButton = new Button("Update");
        grid.add(updateButton, 1, 2);

        Button deleteButton = new Button("Delete");
        grid.add(deleteButton, 2, 2);

        Scene scene = new Scene(grid, 400, 200);
        scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
