//package com.example.database2try;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.ChoiceBox;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.control.cell.TextFieldTableCell;
//import javafx.util.converter.IntegerStringConverter;
//import java.net.URL;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.Properties;
//import java.util.ResourceBundle;
//import static com.example.database2try.MeltBurgerController.orderN;
//public class TableViewController implements Initializable {
//    private static Connection con;
//    double sum;
//    @FXML
//    private TextField cityTextField;
//    ObservableList<NewOrder> observableList2= FXCollections.observableArrayList(orderN);
//    @FXML
//    private TableColumn<NewOrder, Integer> Quantity;
//    @FXML
//    private TableColumn<NewOrder, Integer> itemId;
//
//    @FXML
//    private TableColumn<NewOrder, String> itemName;
//
//    @FXML
//    private TableColumn<NewOrder, Double> itemPrice;
//    @FXML
//    private TextField phoneNumberTF;
//    @FXML
//
//    private TextField TotalTF;
//    @FXML
//    private ChoiceBox<String> orderType;
//
//    @FXML
//    private ChoiceBox<String> paymentMethod;
//
//    @FXML
//    protected   TableView<NewOrder> tableView2=new TableView<>();
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        //   cityTextField.setDisable(true);
//        itemName.setCellValueFactory(new PropertyValueFactory<NewOrder,String>("Title"));
//        itemPrice.setCellValueFactory(new PropertyValueFactory<NewOrder,Double>("Price"));
//        Quantity.setCellValueFactory(new PropertyValueFactory<NewOrder,Integer>("quantity"));
//        itemId.setCellValueFactory(new PropertyValueFactory<NewOrder,Integer>("itemId"));
//        tableView2.setEditable(true);
//        tableView2.setItems(observableList2);
//        Quantity.setCellFactory(TextFieldTableCell.<NewOrder,Integer>forTableColumn(new IntegerStringConverter()));//to make the quantity editable
//
//
//        Quantity.setOnEditCommit((TableColumn.CellEditEvent<NewOrder, Integer> t) -> {
//            ((NewOrder) t.getTableView().getItems().get(t.getTablePosition().getRow())).setQuantity(t.getNewValue());
//        });
//
//
//        sum=0.0;
//        for(int i=0;i<orderN.size();i++){
//            sum+=orderN.get(i).getPrice()*orderN.get(i).getQuantity();
//        }
//        TotalTF.setText(String.valueOf(sum));
//
//
//        orderType.getItems().add("In");
//        orderType.getItems().add("Out");
//        paymentMethod.getItems().add("Cash");
//        paymentMethod.getItems().add("Visa");
//    }
//
//
//
//    @FXML
//    void sumOnActions(ActionEvent event) {
//        sum=0.0;
//        for(int i=0;i<orderN.size();i++){
//            sum+=orderN.get(i).getPrice()*orderN.get(i).getQuantity();
//        }
//        TotalTF.setText(String.valueOf(sum));
//    }
//
//    @FXML
//    void QuantityOnEdit(ActionEvent event) {
//
//    }
//
//    @FXML
//    void deleteOnAction(ActionEvent event) {
//        int index=tableView2.getSelectionModel().getSelectedIndex();
//        String requiredTitle=observableList2.get(index).getTitle();
//        sum-=(tableView2.getItems().get(index).getPrice()*tableView2.getItems().get(index).getQuantity());
//        TotalTF.setText(String.valueOf(sum));
//        tableView2.getItems().remove(index);
//        orderN.remove(index);
//    }
//
//
//    @FXML
//    void deleteAllOnAction(ActionEvent event) {
//        orderN.clear();
//        observableList2.clear();
//        // tableView2.getItems().clear();
//
//
//    }
//
//    @FXML
//    void payOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
//        String SQL;
//        if(orderType.getValue().equals("Out")) {
//            SQL= "insert into orders(orderType,totalPrice,paymentMethod,address,phoneNumber,userId) values('" + orderType.getValue() + "'," + sum + ",'" + paymentMethod.getValue() +
//                    "','" + cityTextField.getText() + "'," + Integer.parseInt(phoneNumberTF.getText()) + "," + 1 + ");";
//        }
//
//        else {
//            SQL= "insert into orders(orderType,totalPrice,paymentMethod,address,phoneNumber,userId) values('" + orderType.getValue() + "'," + sum + ",'" + paymentMethod.getValue() +
//                    "','" + " " + "'," + Integer.parseInt(phoneNumberTF.getText()) + "," + 1 + ");";
//        }
//        connectDB();
//        Statement stmt = con.createStatement();
//        stmt.executeUpdate(SQL);
//        stmt.close();
//        con.close();
//////////////////////////////////////////////////////
//        connectDB();
//        ArrayList<Order> tmpForOrders=new ArrayList<Order>();
//        //now i want to tke order id, item id, quantity, how to get the first two???????????????????
//        SQL = "select * from orders";
//        stmt = con.createStatement();
//        ResultSet rs = stmt.executeQuery(SQL);
//        while ( rs.next() )  {
//            tmpForOrders.add(new Order(rs.getInt(1),rs.getString(2),
//                    rs.getDouble(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7)));
//        }
//        rs.close();
//        stmt.close();
//        con.close();
/////////////////////////////////////////////////////////
//
//        connectDB();
//        //now it's time to add the orderid itemId and quantity to (orders_items)
//        for(int i=0;i<observableList2.size();i++){
//            SQL= "insert into orders_items values("+tmpForOrders.get(tmpForOrders.size()-1).getOrderId() + "," +observableList2.get(i).getItemId()+"," +observableList2.get(i).getQuantity()+","+observableList2.get(i).getPrice()+");";
//
//            stmt = con.createStatement();
//            stmt.executeUpdate(SQL);
//        }
//        stmt.close();
//        con.close();        orderN.clear();
//        observableList2.clear();
//    }
//
//    public static void connectDB() throws ClassNotFoundException, SQLException {
//        String URL = "127.0.0.1";
//        String port = "3306";
//        String dbName = "melt2";
//        String dbURL = "jdbc:mysql://" + URL + ":" + port + "/" + dbName + "?verifyServerCertificate=false";
//        Properties p = new Properties();
//        String dbUsername = "root";
//        p.setProperty("user", dbUsername);
//        String dbPassword = "jj137157177jj";
//        p.setProperty("password", dbPassword);
//        p.setProperty("useSSL", "false");
//        p.setProperty("autoReconnect", "true");
//        Class.forName("com.mysql.jdbc.Driver");
//
//        con = DriverManager.getConnection(dbURL, p);
//
//    }
//
//}