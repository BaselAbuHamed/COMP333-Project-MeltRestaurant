package com.example.melt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MeltOrderController implements Initializable {

    @FXML
    private Button Clear;

    @FXML
    private Button ClearAll;

    @FXML
    private Button MeltAllTheWay;

    @FXML
    private Button MeltBurgers;

    @FXML
    private Button MeltChickenBites;

    @FXML
    private Button MeltDrinks;

    @FXML
    private Button MeltEmployeeMeals;

    @FXML
    private Button MeltExtras;

    @FXML
    private Button MeltFries;

    @FXML
    private Button MeltKidsMeal;

    @FXML
    private Button MeltSauces;

    @FXML
    private Button MeltShakes;

    @FXML
    private Button Pay;

    @FXML
    private TextField TextFieldNum;

    @FXML
    private BorderPane anchorPane;

    @FXML
    private Button eight;

    @FXML
    private Button five;

    @FXML
    private Button four;

    @FXML
    private Button nine;

    @FXML
    private Button one;

    @FXML
    private Button seven;

    @FXML
    private Button six;

    @FXML
    private Button three;

    @FXML
    private Button two;

    @FXML
    private Button zero;

    @FXML
    private Text textT;

    @FXML
    void meltBurgersOnAction(ActionEvent event) throws IOException {

        textT.setText("Melt Burgers");
        VBox view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MeltBurgers.fxml")));
        anchorPane.setCenter(view);
    }

    @FXML
    void meltDrinksOnAction(ActionEvent event) throws IOException {
        textT.setText("Melt Drinks");
        VBox view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MeltDrinks.fxml")));
        anchorPane.setCenter(view);
    }

    @FXML
    void meltFriesOnAction(ActionEvent event) throws IOException {
        textT.setText("Melt Fries");
        VBox view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MeltFries.fxml")));
        anchorPane.setCenter(view);
    }

    @FXML
    void meltAllTheWayOnAction(ActionEvent event) throws IOException {
        textT.setText("Melt All The Way");
        VBox view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MeltAllTheWay.fxml")));
        anchorPane.setCenter(view);
    }

    @FXML
    void meltEmployeeMealsOnAction(ActionEvent event) throws IOException {
        textT.setText("Melt Employee Meals");
        VBox view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MeltEmployeeMeals.fxml")));
        anchorPane.setCenter(view);
    }

    @FXML
    void meltKidsMealOnAction(ActionEvent event) throws IOException {
        textT.setText("Melt Kids Meal");
        VBox view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MeltKidsMeal.fxml")));
        anchorPane.setCenter(view);
    }

    @FXML
    void meltChickenBitesOnAction(ActionEvent event) throws IOException {
        textT.setText("Melt Chicken Bites");
        VBox view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MeltChickenBites.fxml")));
        anchorPane.setCenter(view);
    }

    @FXML
    void oneOnAction(ActionEvent event) {
        TextFieldNum.appendText("1");
    }

    @FXML
    void twoOnAction(ActionEvent event) {
        TextFieldNum.appendText("2");
    }

    @FXML
    void threeOnAction(ActionEvent event) {
        TextFieldNum.appendText("3");
    }

    @FXML
    void fourOnAction(ActionEvent event) {
        TextFieldNum.appendText("4");
    }

    @FXML
    void fiveOnAction(ActionEvent event) {
        TextFieldNum.appendText("5");
    }

    @FXML
    void sixOnAction(ActionEvent event) {
        TextFieldNum.appendText("6");
    }

    @FXML
    void sevenOnAction(ActionEvent event) {
        TextFieldNum.appendText("7");
    }
    @FXML
    void eightOnAction(ActionEvent event) {
        TextFieldNum.appendText("8");
    }

    @FXML
    void nineOnAction(ActionEvent event) {
        TextFieldNum.appendText("9");
    }

    @FXML
    void zeroOnAction(ActionEvent event) {
        TextFieldNum.appendText("0");
    }

    @FXML
    void clearAllOnAction(ActionEvent event) {
        TextFieldNum.clear();
    }
    @FXML
    void clearOnAction(ActionEvent event) {
        TextFieldNum.setText(TextFieldNum.getText(0,TextFieldNum.getText().length()-1));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
