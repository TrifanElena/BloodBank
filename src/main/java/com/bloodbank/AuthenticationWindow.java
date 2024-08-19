package com.bloodbank;

import com.bloodbank.service.UtilizatorService;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AuthenticationWindow extends Application {

    private UtilizatorService utilizatorService;

    public AuthenticationWindow() {
        this.utilizatorService = new UtilizatorService();
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login");

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

        Button loginButton = new Button("Login");
        grid.add(loginButton, 1, 2);

        loginButton.setOnAction(e -> {
            if (authenticate(userTextField.getText(), pwBox.getText())) {
                CRUDWindow crudWindow = new CRUDWindow();
                crudWindow.start(new Stage());
                primaryStage.close();
            } else {
                System.out.println("Authentication failed");
            }
        });

        Scene scene = new Scene(grid, 300, 200);
        scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private boolean authenticate(String username, String password) {
        return utilizatorService.autentificareUtilizator(username, password);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
