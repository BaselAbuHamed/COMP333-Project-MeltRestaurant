package com.example.melt;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Properties;

public class HelloApplication extends Application {

    @FXML
    private static Connection con;
    public static ArrayList<Employees> employees;
    public static ArrayList<LogIn> logInArrayList;
    public static ArrayList<Users> usersArrayList;
    public static ArrayList<Rules> rulesArrayList;
    public static ArrayList<Items> itemsArrayList;
    public static ArrayList<ItemList> itemListArrayList;
    public static ArrayList<FoodInfo> foodInfoArrayList;
    public static ArrayList<Order> orderArrayList;

    @Override
    public void start(Stage stage) throws IOException {

        Parent root=FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MeltOrder.fxml")));
        Scene scene = new Scene(root);
        stage.setTitle("Hello!");
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        getData();
        getItemList();
        getFoodInfo();
        getItems();
        getRules();
        getUsers();
        getLogin();
        getOrders();
        launch();
    }

    private static void getData() throws SQLException, ClassNotFoundException {

        String SQL;
        employees = new ArrayList<>();

        Connector.a.connectDB();
        System.out.println("Connection established");

        SQL = "select * from Employees";
        Statement stmt = Connector.a.connectDB().createStatement();
        ResultSet rs = stmt.executeQuery(SQL);


        while ( rs.next() )  {
            employees.add(new Employees(rs.getInt(1),rs.getString(2),
                    rs.getString(3),rs.getDouble(4), rs.getInt(5),rs.getInt(6)));
        }
        System.out.println(employees.toString());
        rs.close();
        stmt.close();

        Connector.a.connectDB().close();
        System.out.println("Connection closed" + employees.size());

    }

    private static void getUsers() throws SQLException, ClassNotFoundException {

        String SQL;
        usersArrayList=new ArrayList<>();

        Connector.a.connectDB();
        System.out.println("Connection established");

        SQL = "select * from Users";
        Statement stmt = Connector.a.connectDB().createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while ( rs.next() )  {
            usersArrayList.add(new Users(rs.getInt(1),rs.getString(2),
                    rs.getString(3),rs.getInt(4)));
        }
        rs.close();
        stmt.close();
        Connector.a.connectDB().close();
    }

    private static void getRules() throws SQLException, ClassNotFoundException {

        String SQL;
        rulesArrayList=new ArrayList<>();

        Connector.a.connectDB();
        System.out.println("Connection established");

        SQL = "select * from roles";
        Statement stmt = Connector.a.connectDB().createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while ( rs.next() )  {
            rulesArrayList.add(new Rules(rs.getInt(1),rs.getString(2)));
        }
        rs.close();
        stmt.close();
        Connector.a.connectDB().close();
    }

    private static void getLogin() throws SQLException, ClassNotFoundException {

        String SQL;
        logInArrayList=new ArrayList<>();

        Connector.a.connectDB();
        System.out.println("Connection established");

        SQL = "select * from Login";
        Statement stmt = Connector.a.connectDB().createStatement();
        ResultSet rs = stmt.executeQuery(SQL);


        while ( rs.next() )  {
            logInArrayList.add(new LogIn(rs.getInt(1),rs.getDate(2),
                    rs.getInt(3)));
        }
        // System.out.println(usersArrayList.toString());
        rs.close();
        stmt.close();

        Connector.a.connectDB().close();
        // System.out.println("Connection closed" + employees.size());

    }

    private static void getItemList() throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub

        String SQL;
        itemListArrayList=new ArrayList<>();

        Connector.a.connectDB();
        System.out.println("Connection established");

        SQL = "select * from ItemList";
        Statement stmt = Connector.a.connectDB().createStatement();
        ResultSet rs = stmt.executeQuery(SQL);


        while ( rs.next() )  {
            itemListArrayList.add(new ItemList(rs.getInt(1),rs.getString(2)));
        }
        System.out.println(itemListArrayList.toString());
        rs.close();
        stmt.close();

        Connector.a.connectDB().close();
        System.out.println("Connection closed" + employees.size());

    }

    private static void getFoodInfo() throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub

        String SQL;
        foodInfoArrayList=new ArrayList<>();

        Connector.a.connectDB();
        System.out.println("Connection established");

        SQL = "select * from foodInfo";
        Statement stmt =Connector.a.connectDB().createStatement();
        ResultSet rs = stmt.executeQuery(SQL);


        while ( rs.next() )  {
            foodInfoArrayList.add(new FoodInfo(rs.getInt(1),rs.getString(2)));
        }
        System.out.println(foodInfoArrayList.toString());
        rs.close();
        stmt.close();

        Connector.a.connectDB().close();
        System.out.println("Connection closed" + employees.size());

    }

    private static void getItems() throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub

        String SQL;
        itemsArrayList=new ArrayList<>();

        Connector.a.connectDB();
        System.out.println("Connection established");

        SQL = "select * from Items";
        Statement stmt = Connector.a.connectDB().createStatement();
        ResultSet rs = stmt.executeQuery(SQL);


        while ( rs.next() )  {
            itemsArrayList.add(new Items(rs.getInt(1),rs.getString(2),
                    rs.getInt(3),rs.getInt(4),rs.getInt(5)));
        }
        System.out.println(itemsArrayList.toString());
        rs.close();
        stmt.close();

        Connector.a.connectDB().close();
        // System.out.println("Connection closed" + employees.size());

    }

    private static void getOrders() throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub

        String SQL;
        orderArrayList=new ArrayList<>();

        Connector.a.connectDB();
        System.out.println("Connection established");

        SQL = "select * from Orders";
        Statement stmt = Connector.a.connectDB().createStatement();
        ResultSet rs = stmt.executeQuery(SQL);


        while ( rs.next() )  {
            orderArrayList.add(new Order(rs.getInt(1),rs.getString(2),
                    rs.getDouble(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7)));
        }
        System.out.println("printing odredrs arrray listtttttttttttttt");
        System.out.println(orderArrayList.toString());
        rs.close();
        stmt.close();

        Connector.a.connectDB().close();
        // System.out.println("Connection closed" + employees.size());

    }

}