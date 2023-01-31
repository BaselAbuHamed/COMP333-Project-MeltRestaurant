package com.example.melt;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

import static com.example.melt.HelloApplication.itemListArrayList;
import static com.example.melt.HelloApplication.itemsArrayList;


public class MeltOrderController implements Initializable {

    @FXML
    private VBox vBoxForItemList;

    @FXML
    private TextField TextFieldNum;

    @FXML
    private BorderPane borderPane;

    @FXML
    private VBox vBoxOrder;

    @FXML
    private Button zero;

    @FXML
    private Button one;

    @FXML
    private Button two;

    @FXML
    private Button three;

    @FXML
    private Button four;

    @FXML
    private Button five;

    @FXML
    private Button six;

    @FXML
    private Button seven;

    @FXML
    private Button eight;

    @FXML
    private Button nine;

    @FXML
    private Button ClearAll;

    @FXML
    private Button Clear;

    @FXML
    private Button Pay;

    @FXML
    private Text textT;

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

    ObservableList<ItemList> itemList= FXCollections.observableArrayList(itemListArrayList);
    ObservableList<Items> items= FXCollections.observableArrayList(itemsArrayList);
    HBox hBoxForItems = new HBox();
    VBox vBoxForItems = new VBox();
    AtomicInteger countItems = new AtomicInteger();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        vBoxForItems.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        hBoxForItems.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        vBoxForItems.setSpacing(10);
        for (int i = 0; i < itemList.size(); i++) {

            Button button = new Button(itemList.get(i).getMenuTitle());
            button.setPrefWidth(100);
            button.setPrefHeight(50);
//            borderPane=new BorderPane();

            int finalI=i;
            button.setOnAction(event -> {

                vBoxForItems.getChildren().clear();
                hBoxForItems=new HBox();
                hBoxForItems.setSpacing(10);
                textT.setText(itemList.get(finalI).getMenuTitle());
                System.out.println(itemList.get(finalI).getMenuTitle()+ " clicked");

                for (int j = 0; j < items.size(); j++) {

                    int finalJ = j;
                    if(itemList.get(finalI).getMenuId()==items.get(finalJ).getMenuId()){

                        Button b1 = new Button(items.get(finalJ).getItemTitle());
                        b1.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
                        b1.setPrefHeight(50);
                        b1.setWrapText(true);
                        b1.setOnAction(actionEvent -> System.out.println(items.get(finalJ).getItemTitle()+ " clicked"));

                        countItems.getAndIncrement();
                        hBoxForItems.getChildren().add(b1);

                        if (countItems.get() == 5) {
                            vBoxForItems.getChildren().add(hBoxForItems);
                            hBoxForItems =new HBox();
                            hBoxForItems.setSpacing(10);
                            countItems.set(0);
                        }
                    }
                }

                if (hBoxForItems.getChildren().size() > 0){
                    vBoxForItems.getChildren().add(hBoxForItems);
                    countItems.set(0);
                }

                borderPane.setCenter(vBoxForItems);
            });
            vBoxForItemList.getChildren().add(button);
        }
    }
}
