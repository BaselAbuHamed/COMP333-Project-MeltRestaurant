module com.example.melt {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example.melt to javafx.fxml;
    exports com.example.melt;
}