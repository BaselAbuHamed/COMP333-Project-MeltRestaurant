package com.example.melt;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Driver implements Initializable {

    @FXML
    private PieChart pieChart;

    public static ArrayList<ItemsQuantity> itemsQuantitiesArrayList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        try {
            getItemsQuantity();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for (int i = 0; i < itemsQuantitiesArrayList.size(); i++) {

            pieChartData.add(new PieChart.Data(itemsQuantitiesArrayList.get(i).getItemTitle(),
                    itemsQuantitiesArrayList.get(i).getQuantity()));
        }

        pieChartData.forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName(), " \namount: ", data.pieValueProperty()
                        )
                )
        );

        pieChart.getData().addAll(pieChartData);
    }

    private static void getItemsQuantity() throws SQLException, ClassNotFoundException {
        itemsQuantitiesArrayList=new ArrayList<>();
        String SQL = "select p.itemTitle, sum(quantity)\n" +
                "from orders_items I, items p\n" +
                "where I.itemId=p.itemId\n" +
                "group by I.itemId;" ;

        Connector.a.connectDB();
        Statement stmt = Connector.a.connectDB().createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while ( rs.next() )  {
            itemsQuantitiesArrayList.add(new ItemsQuantity(rs.getString(1),rs.getInt(2)));
        }

        System.out.println(itemsQuantitiesArrayList.toString());
        rs.close();
        stmt.close();
        Connector.a.connectDB().close();
    }
}


