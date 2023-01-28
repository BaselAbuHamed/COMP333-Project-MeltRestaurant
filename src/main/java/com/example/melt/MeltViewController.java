package com.example.melt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MeltViewController {

    @FXML
    private Button Cash;

    @FXML
    private Button Day;

    @FXML
    private Button Employee;

    @FXML
    private Button Menu;

    @FXML
    private Button Month;

    @FXML
    private Button Total;

    @FXML
    private Button Year;

    @FXML
    void CashOnAction(ActionEvent event) throws IOException {

        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MeltOrder.fxml")));
        Scene scene=new Scene(root);
        Stage primaryStage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}
