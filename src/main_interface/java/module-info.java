module com.example.projet_java {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.unsupported;


    opens com.example.projet_java to javafx.fxml;
    exports com.example.projet_java;
}