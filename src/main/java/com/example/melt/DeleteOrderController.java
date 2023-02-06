package com.example.melt;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.example.melt.HelloApplication.orderArrayList;
import static com.example.melt.HelloApplication.usersArrayList;


public class DeleteOrderController implements Initializable {
    public static ObservableList<Order> orders = FXCollections.observableArrayList(orderArrayList);
    @FXML
    private TextField userNameTF;

    @FXML
    private TableColumn<Order, String> address;

    @FXML
    private TableColumn<Order, Integer> orderId;

    @FXML
    private TableColumn<Order, String> orderType;

    @FXML
    private TableColumn<Order, String> paymentMethod;

    @FXML
    private TableColumn<Order, Integer> phoneNumber;

    @FXML
    private TextField phoneNumberTF;

    @FXML
    private TableColumn<Order, Double> totalPrice;

    @FXML
    private TableColumn<Order, Integer> userId;


    @FXML
    private TableView<Order> orderTable;

    @FXML
    private HBox hbox;

    @FXML
    private TableColumn<Order, Date> order_date;

    private static void getOrders() throws SQLException, ClassNotFoundException {

        String SQL;
        orderArrayList = new ArrayList<>();

        Connector.a.connectDB();

        SQL = "select * from Orders";
        Statement stmt = Connector.a.connectDB().createStatement();
        ResultSet rs = stmt.executeQuery(SQL);


        while (rs.next()) {
            orderArrayList.add(new Order(rs.getInt(1), rs.getString(2),
                    rs.getDouble(3),
                    rs.getString(4), rs.getString(5), rs.getInt(6)
                    , rs.getDate(7), rs.getInt(8)));
            System.out.println(rs.getDate(7));
        }
        rs.close();
        stmt.close();
        Connector.a.connectDB().close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //
        orderId.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        orderType.setCellValueFactory(new PropertyValueFactory<>("OrderType"));
        totalPrice.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        paymentMethod.setCellValueFactory(new PropertyValueFactory<>("paymentMethod"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        order_date.setCellValueFactory(new PropertyValueFactory<>("order_date"));
        userId.setCellValueFactory(new PropertyValueFactory<>("userId"));
        orderTable.setEditable(true);

        try {
            getOrders();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        orders = FXCollections.observableArrayList(orderArrayList);
        // System.out.println(orders);
        orderTable.setItems(orders);

        userId.setOnEditStart(EventHandler -> {
            String tmpName = "";
            Order e = orderTable.getSelectionModel().getSelectedItem();//taking object
            int index = orderTable.getSelectionModel().getSelectedIndex();//taking the index of the object
            int requiredId = orders.get(index).getUserId();//taking the id of the employee
            for (Users users : usersArrayList) {

                if (users.getUserId() == requiredId) {
                    tmpName = users.getUserName();
                }
            }
            userNameTF.setText(tmpName);
        });
    }

    @FXML
    void userIdOnEDIT(ActionEvent event) {

    }

    @FXML
    void backOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MeltView.fxml")));
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    @FXML
    void DeleteOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        int index = orderTable.getSelectionModel().getSelectedIndex();
        int requiredId = orders.get(index).getOrderId();
        orderTable.getItems().remove(index);
        //deleting from data base
        Connector.a.connectDB();
        String Sql = "delete from Orders where orderId=" + requiredId + ";";
        Statement stmt = Connector.a.connectDB().createStatement();
        stmt.executeUpdate(Sql);
        stmt.close();
        Connector.a.connectDB().close();
    }

    @FXML
    void searchOnAction(MouseEvent event) {
        ObservableList<Order> tmp = orders;
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getPhoneNumber() == Integer.parseInt(phoneNumberTF.getText())) {
                orderTable.getItems().add(0, orders.get(i));
                orderTable.getItems().remove(i + 1);
            }
        }
        orders = tmp;


    }
}
