package com.example.melt;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Driver extends Application {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        getItemList();
        getItems();
        launch(args);
    }

    public static ArrayList<ItemList> itemListArrayList;
    public static ArrayList<Items> itemsArrayList;

    @Override
    public void start(Stage primaryStage) {

        Group group = new Group();
        Scene scene = new Scene(group,600 , 400);

        AnchorPane anchorPane = new AnchorPane();
        Scene sceneForAP = new Scene(anchorPane);
        AtomicReference<HBox> hBox = new AtomicReference<>(new HBox());
        HBox hBox1 = new HBox();
        VBox vBoxForPrimaryScene = new VBox();
        AtomicReference<VBox> vBoxForAP = new AtomicReference<>(new VBox());

        ObservableList<ItemList> itemList= FXCollections.observableArrayList(itemListArrayList);
        ObservableList<Items> items= FXCollections.observableArrayList(itemsArrayList);
        AtomicInteger buttonCount = new AtomicInteger();
        AtomicInteger buttonF = new AtomicInteger();

        for (int i = 0; i < itemList.size(); i++) {

            Button button = new Button(itemList.get(i).getMenuTitle());
            button.setPrefWidth(100);
            button.setPrefHeight(50);
            int finalI = i;

            button.setOnAction(event -> {
                anchorPane.getChildren().clear();
                hBox.set(new HBox());
                System.out.println(itemList.get(finalI).getMenuTitle()+ " clicked");

                for (int j = 0; j < items.size(); j++) {

                    int finalJ = j;
                    if(itemList.get(finalI).getMenuId()==items.get(finalJ).getMenuId()){

                        Button b1 = new Button(items.get(finalJ).getItemTitle());
                        b1.setPrefWidth(200);
                        b1.setPrefHeight(50);
                        b1.setOnAction(actionEvent -> System.out.println(items.get(finalJ).getItemTitle()+ " clicked"));

                        buttonCount.getAndIncrement();
                        hBox.get().getChildren().add(b1);

                        if (buttonCount.get() == 5) {
                            vBoxForAP.get().getChildren().add(hBox.get());
                            hBox.set(new HBox());
                            buttonCount.set(0);
                        }
                    }
                }

                if (hBox.get().getChildren().size() > 0){
                    vBoxForAP.get().getChildren().add(hBox.get());
                    buttonCount.set(0);
                }

                Button back = new Button("back");
                back.setPrefWidth(200);
                back.setPrefHeight(50);
                vBoxForAP.get().getChildren().add(back);

                back.setOnAction(actionEvent -> {

                    vBoxForAP.set(new VBox());
                    primaryStage.setScene(scene);
                    primaryStage.show();
                });

                anchorPane.getChildren().add(vBoxForAP.get());
                primaryStage.setTitle("Basel Application");
                primaryStage.setScene(sceneForAP);
                primaryStage.show();

            });

            vBoxForPrimaryScene.getChildren().add(button);
        }

        group.getChildren().add(vBoxForPrimaryScene);
        primaryStage.setTitle("Basel Application");
        primaryStage.setScene(scene);
        primaryStage.show();
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
    }
    private static void getItems() throws SQLException, ClassNotFoundException {

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
}
