package com.example.melt;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

import static com.example.melt.HelloApplication.itemListArrayList;
import static com.example.melt.HelloApplication.itemsArrayList;
import static com.example.melt.MeltLogInController.currentUserName;

public class MeltOrderController implements Initializable {

    ArrayList<NewOrder> newOrders=new ArrayList<>();
    ObservableList<NewOrder> observableListNewOrders= FXCollections.observableArrayList(newOrders);

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
    private Button saveAs;

    @FXML
    private Text textT;

    @FXML
    public TableColumn<NewOrder, String> columnItemName;

    @FXML
    public TableColumn<NewOrder, Integer> columnPrice;

    @FXML
    public TableColumn<NewOrder, Integer> columnQuantity;

    @FXML
    public TableView<NewOrder> tableViewForOrder;

    @FXML
    private TextField textFieldForTotalPrice;

    @FXML
    private ComboBox <String> orderType;

    @FXML
    private ComboBox <String >paymentMethod;

    @FXML
    private Button buttonRemove;

    @FXML
    private Button back;

    @FXML
    private Label labelNameUser;

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

    @FXML
    void removeOnAction(ActionEvent event) {

        int index = tableViewForOrder.getSelectionModel().getSelectedIndex();
        int requiredId= observableListNewOrders.get(index).getItemId();

        textFieldForTotalPrice.setText(String.valueOf(Double.parseDouble(textFieldForTotalPrice.getText())-
                observableListNewOrders.get(requiredId).getPrice()));
        tableViewForOrder.getItems().remove(index);

    }


    @FXML
    void backOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MeltView.fxml")));
        Scene scene=new Scene(root);
        Stage primaryStage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    @FXML
    void tableViewONMouseClicked(MouseEvent event) {

        NewOrder e =tableViewForOrder.getSelectionModel().getSelectedItem();
        int index = tableViewForOrder.getSelectionModel().getSelectedIndex();

        TextFieldNum.setText(String.valueOf(e.getQuantity()));

        saveAs.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                if(!TextFieldNum.getText().equals("0")){
                    String s="";
                    s+=TextFieldNum.getText();
                    e.setQuantity(Integer.parseInt(s));
                    int sum = (int) (Double.parseDouble(textFieldForTotalPrice.getText())-e.getPrice());
                    e.setPrice(e.getPrice()*e.getQuantity());

                    observableListNewOrders.set(index,e);

                    textFieldForTotalPrice.setText(String.valueOf(sum+e.getPrice()));
                    tableViewForOrder.refresh();
                }
                else
                    TextFieldNum.setText("1");
            }
        });
    }

    @FXML
    void payOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String SQL;

        Date date=new Date();
        Order o=new Order(date);

        String s = String.valueOf((o.getOrder_date().getYear()+230000)+
                '-' + o.getOrder_date().getMonth()+
                '-' + (o.getOrder_date().getDay()-16));

        System.out.println(s);

        if(orderType.getValue().equals("OUT")) {
            SQL= "insert into orders(orderType,totalPrice,paymentMethod,address,phoneNumber,order_date,userId) values('" +
                    orderType.getValue() +
                    "'," + Double.parseDouble(textFieldForTotalPrice.getText()) +
                    ",'" + paymentMethod.getValue() +
                    "','" + "aaa" +
                    "'," + Integer.parseInt("0000") +
                    ","+s +
                    "," + 1 + ");";
        }

        else {
            SQL= "insert into orders(orderType,totalPrice,paymentMethod,address,phoneNumber,order_date,userId) values('" +
                    orderType.getValue() +
                    "'," + Double.parseDouble(textFieldForTotalPrice.getText()) +
                    ",'" + paymentMethod.getValue() +
                    "','" + " " +
                    "'," + Integer.parseInt("111") +
                    ","+s +
                    "," + 1 + ");";
        }
        Connector.a.connectDB();
        textFieldForTotalPrice.setText("00");
        Statement stmt = Connector.a.connectDB().createStatement();
        stmt.executeUpdate(SQL);
        stmt.close();
        Connector.a.connectDB().close();

////////////////////////////////////////////////////
        Connector.a.connectDB();
        ArrayList<Order> tmpForOrders=new ArrayList<>();
        //now i want to tke order id, item id, quantity, how to get the first two???????????????????
        SQL = "select * from orders";
        stmt = Connector.a.connectDB().createStatement();
        ResultSet rs = stmt.executeQuery(SQL);
        while ( rs.next() )  {
            tmpForOrders.add(new Order(rs.getInt(1),rs.getString(2),
                    rs.getDouble(3),rs.getString(4),rs.getString(5),
                    rs.getInt(6),rs.getDate(7),rs.getInt(8)));
        }
        rs.close();
        stmt.close();
        Connector.a.connectDB().close();
///////////////////////////////////////////////////////

        Connector.a.connectDB();
        //now it's time to add the orderid itemId and quantity to (orders_items)
        for(int i=0;i<observableListNewOrders.size();i++){
            SQL= "insert into orders_items values("+
                    tmpForOrders.get(tmpForOrders.size()-1).getOrderId() +
                    "," +observableListNewOrders.get(i).getItemId()+
                    "," +observableListNewOrders.get(i).getQuantity()+
                    ","+observableListNewOrders.get(i).getPrice()+
                    ");";

            stmt = Connector.a.connectDB().createStatement();
            stmt.executeUpdate(SQL);
        }
        stmt.close();
        Connector.a.connectDB().close();
        observableListNewOrders.clear();
    }

    ObservableList<ItemList> itemList= FXCollections.observableArrayList(itemListArrayList);
    ObservableList<Items> items= FXCollections.observableArrayList(itemsArrayList);
    HBox hBoxForItems = new HBox();
    VBox vBoxForItems = new VBox();
    HBox hBoxForItemList = new HBox();
    AtomicInteger countItems = new AtomicInteger();
    AtomicInteger countItemList = new AtomicInteger();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        labelNameUser.setText(currentUserName);
        orderType.getItems().addAll("IN","OUT","Delivery");
        paymentMethod.getItems().addAll("Visa","Cash");

        columnItemName.setCellValueFactory(new PropertyValueFactory<>("Title"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        columnQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        columnQuantity.setCellFactory(TextFieldTableCell.<NewOrder,Integer>forTableColumn(new IntegerStringConverter()));

        hBoxForItemList.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        hBoxForItemList.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        hBoxForItemList.setAlignment(Pos.CENTER);
        hBoxForItemList.setSpacing(10);
        vBoxForItems.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        hBoxForItems.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        vBoxForItems.setSpacing(10);

        for (int i = 0; i < itemList.size(); i++) {

            countItemList.getAndIncrement();
            Button button = new Button(itemList.get(i).getMenuTitle());
            button.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
            button.setCursor(Cursor.HAND);
            button.setFont(new Font(15));
            button.setStyle("-fx-background-radius:15 15 15 15");
            button.setPrefHeight(50);
            button.setWrapText(true);

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

                        Button b1 = new Button(items.get(finalJ).getItemTitle()+
                                "\n" + items.get(finalJ).getItemPrice() + "₪");
                        b1.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
//                        b1.setPrefHeight(70);
//                        b1.setPrefWidth(120);
                        b1.setCursor(Cursor.HAND);
                        b1.setFont(new Font(15));
                        b1.setStyle("-fx-background-radius:20 20 20 20");
                        b1.setWrapText(true);
                        b1.setOnAction(actionEvent -> {

                            observableListNewOrders.add(new NewOrder(items.get(finalJ).getItemTitle(),
                                    items.get(finalJ).getItemPrice(),1,
                                    items.get(finalJ).getItemId()));

                            tableViewForOrder.setItems(observableListNewOrders);
                            tableViewForOrder.refresh();

                            textFieldForTotalPrice.setText(String.valueOf(items.get(finalJ).getItemPrice()+
                                    Double.parseDouble(textFieldForTotalPrice.getText())));

                            System.out.println(items.get(finalJ).getItemTitle()+ " clicked");
                        });


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

            hBoxForItemList.getChildren().add(button);

            if(countItemList.get() == 5){
                vBoxForItemList.getChildren().add(hBoxForItemList);
                hBoxForItemList=new HBox();
                hBoxForItemList.setAlignment(Pos.CENTER);
                hBoxForItemList.setSpacing(10);
                countItemList.set(0);
            }
        }
        if (countItemList.get() > 0){
            vBoxForItemList.getChildren().add(hBoxForItemList);
            countItemList.set(0);
        }
    }
}
