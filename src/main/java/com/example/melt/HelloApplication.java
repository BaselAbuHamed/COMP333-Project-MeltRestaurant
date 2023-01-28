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

        connectDB();
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

    public static void connectDB() throws ClassNotFoundException, SQLException {

        String URL = "127.0.0.1";
        String port = "3306";
        String dbName = "melt2";
        String dbURL = "jdbc:mysql://" + URL + ":" + port + "/" + dbName + "?verifyServerCertificate=false";
        Properties p = new Properties();
        String dbUsername = "root";
        p.setProperty("user", dbUsername);
        String dbPassword = "1232002";
        p.setProperty("password", dbPassword);
        p.setProperty("useSSL", "false");
        p.setProperty("autoReconnect", "true");
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection (dbURL, p);
    }

    private static void getData() throws SQLException, ClassNotFoundException {

        String SQL;
        employees = new ArrayList<>();

        connectDB();
        System.out.println("Connection established");

        SQL = "select * from Employees";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);


        while ( rs.next() )  {
            employees.add(new Employees(rs.getInt(1),rs.getString(2),
                    rs.getString(3),rs.getDouble(4), rs.getInt(5),rs.getInt(6)));
        }
        System.out.println(employees.toString());
        rs.close();
        stmt.close();

        con.close();
        System.out.println("Connection closed" + employees.size());

    }

    private static void getUsers() throws SQLException, ClassNotFoundException {

        String SQL;
        usersArrayList=new ArrayList<>();

        connectDB();
        System.out.println("Connection established");

        SQL = "select * from Users";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while ( rs.next() )  {
            usersArrayList.add(new Users(rs.getInt(1),rs.getString(2),
                    rs.getString(3),rs.getInt(4)));
        }
        rs.close();
        stmt.close();
        con.close();
    }

    private static void getRules() throws SQLException, ClassNotFoundException {

        String SQL;
        rulesArrayList=new ArrayList<>();

        connectDB();
        System.out.println("Connection established");

        SQL = "select * from roles";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while ( rs.next() )  {
            rulesArrayList.add(new Rules(rs.getInt(1),rs.getString(2)));
        }
        rs.close();
        stmt.close();
        con.close();
    }

    private static void getLogin() throws SQLException, ClassNotFoundException {

        String SQL;
        logInArrayList=new ArrayList<>();

        connectDB();
        System.out.println("Connection established");

        SQL = "select * from Login";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);


        while ( rs.next() )  {
            logInArrayList.add(new LogIn(rs.getInt(1),rs.getDate(2),
                    rs.getInt(3)));
        }
        // System.out.println(usersArrayList.toString());
        rs.close();
        stmt.close();

        con.close();
        // System.out.println("Connection closed" + employees.size());

    }

    private static void getItemList() throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub

        String SQL;
        itemListArrayList=new ArrayList<>();

        connectDB();
        System.out.println("Connection established");

        SQL = "select * from ItemList";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);


        while ( rs.next() )  {
            itemListArrayList.add(new ItemList(rs.getInt(1),rs.getString(2)));
        }
        System.out.println(itemListArrayList.toString());
        rs.close();
        stmt.close();

        con.close();
        System.out.println("Connection closed" + employees.size());

    }

    private static void getFoodInfo() throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub

        String SQL;
        foodInfoArrayList=new ArrayList<>();

        connectDB();
        System.out.println("Connection established");

        SQL = "select * from foodInfo";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);


        while ( rs.next() )  {
            foodInfoArrayList.add(new FoodInfo(rs.getInt(1),rs.getString(2)));
        }
        System.out.println(foodInfoArrayList.toString());
        rs.close();
        stmt.close();

        con.close();
        System.out.println("Connection closed" + employees.size());

    }

    private static void getItems() throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub

        String SQL;
        itemsArrayList=new ArrayList<>();

        connectDB();
        System.out.println("Connection established");

        SQL = "select * from Items";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);


        while ( rs.next() )  {
            itemsArrayList.add(new Items(rs.getInt(1),rs.getString(2),
                    rs.getInt(3),rs.getInt(4),rs.getInt(5)));
        }
        System.out.println(itemsArrayList.toString());
        rs.close();
        stmt.close();

        con.close();
        // System.out.println("Connection closed" + employees.size());

    }

    private static void getOrders() throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub

        String SQL;
        orderArrayList=new ArrayList<>();

        connectDB();
        System.out.println("Connection established");

        SQL = "select * from Orders";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);


        while ( rs.next() )  {
            orderArrayList.add(new Order(rs.getInt(1),rs.getString(2),
                    rs.getDouble(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7)));
        }
        System.out.println("printing odredrs arrray listtttttttttttttt");
        System.out.println(orderArrayList.toString());
        rs.close();
        stmt.close();

        con.close();
        // System.out.println("Connection closed" + employees.size());

    }

}