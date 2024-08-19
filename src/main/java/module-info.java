module com.bloodbank {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;

    opens com.bloodbank to javafx.fxml;
    exports com.bloodbank;
}
