package com.example.melt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.example.melt.MeltLogInController.currentUserId;

public class MeltViewController implements Initializable {

    @FXML
    private Button Cash;

    @FXML
    private Button Day;

    @FXML
    private Button Employee;

    @FXML
    private Button Menu;

    @FXML
    private Button Month;

    @FXML
    private Button Total;

    @FXML
    private Button Year;

    @FXML
    void CashOnAction(ActionEvent event) throws IOException {

        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MeltOrder.fxml")));
        Scene scene=new Scene(root);
        Stage primaryStage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    @FXML
    void totalOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MeltFinancialReportTotal.fxml")));
        Scene scene=new Scene(root);
        Stage primaryStage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
    @FXML
    void monthlyOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MeltFinancialReportMonthly.fxml")));
        Scene scene=new Scene(root);
        Stage primaryStage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
    @FXML
    void dailyOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MeltFinancialReportDaily.fxml")));
        Scene scene=new Scene(root);
        Stage primaryStage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    @FXML
    void yearlyOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MeltFinancialReportYearly.fxml")));
        Scene scene=new Scene(root);
        Stage primaryStage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    @FXML
    void logOutOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MeltLogIn.fxml")));
        Scene scene=new Scene(root);
        Stage primaryStage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ArrayList<Users> tmp=new ArrayList<>();
        String SQL;

        try {
            Connector.a.connectDB();
            SQL = "select * from users";
            Statement stmt = null;
            stmt = Connector.a.connectDB().createStatement();
            ResultSet rs = null;
            rs = stmt.executeQuery(SQL);

            while (true){
                try {
                    if (!rs.next()) break;
                    tmp.add(new Users(rs.getString(1),rs.getString(2),
                            rs.getInt(3)));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            rs.close();
            stmt.close();
            Connector.a.connectDB().close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        int userCurrentRuleId=0;

        for (Users users : tmp) {
            if (users.getUserId() == currentUserId) {
                userCurrentRuleId = users.getUserRuleId();
            }
        }

        if(userCurrentRuleId==2){
            Menu.setDisable(true);
            Month.setDisable(true);
            Total.setDisable(true);
            Year.setDisable(true);
            Employee.setDisable(true);
        }
    }
}
