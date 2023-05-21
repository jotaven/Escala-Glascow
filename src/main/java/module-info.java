module com.example.project {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires mysql.connector.j;
    requires java.sql;

    opens com.example.project to javafx.fxml;
    exports com.example.project;
}