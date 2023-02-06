package com.example.melt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

import static com.example.melt.HelloApplication.employees;

public class MeltEmployeesController implements Initializable {

    HBox hBoxForEmployees = new HBox();
    AtomicInteger countEmployees = new AtomicInteger();
    @FXML
    private VBox VBoxforEmployees;
    @FXML
    private TextField deptTF;

    @FXML
    private TextField emailTF;

    @FXML
    private TextField empNameTF;

    @FXML
    private TextField phoneNumberTF;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hBoxForEmployees.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        hBoxForEmployees.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        hBoxForEmployees.setAlignment(Pos.CENTER);
        hBoxForEmployees.setSpacing(10);

        for (int i = 0; i < employees.size(); i++) {
            countEmployees.getAndIncrement();
            Button button = new Button(employees.get(i).getName() + "\n" + employees.get(i).getEmail()
                    + "\n" + employees.get(i).getDept()
                    + "\n" + employees.get(i).getPhoneNumber());
            button.setCursor(Cursor.HAND);
            button.setStyle("-fx-background-radius:15 15 15 15");
            button.setWrapText(true);
            AtomicInteger finalI = new AtomicInteger(i);
            button.setOnAction(actionEvent ->
            {
                empNameTF.setText(employees.get(finalI.get()).getName());
                emailTF.setText(employees.get(finalI.get()).getEmail());
                deptTF.setText(String.valueOf(employees.get(finalI.get()).getDept()));
                phoneNumberTF.setText(String.valueOf(employees.get(finalI.get()).getPhoneNumber()));
            });
            hBoxForEmployees.getChildren().add(button);
            if (countEmployees.get() == 5) {
                VBoxforEmployees.getChildren().add(hBoxForEmployees);
                hBoxForEmployees = new HBox();
                hBoxForEmployees.setAlignment(Pos.CENTER);
                hBoxForEmployees.setSpacing(10);
                countEmployees.set(0);
            }
        }


        if (countEmployees.get() > 0) {
            VBoxforEmployees.getChildren().add(hBoxForEmployees);
            countEmployees.set(0);
        }
    }


    @FXML
    void backOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MeltView.fxml")));
        Scene scene = new Scene(root, 1380, 750);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}


