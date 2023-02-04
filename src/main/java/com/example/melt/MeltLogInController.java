package com.example.melt;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;
import java.util.Properties;

import static com.example.melt.HelloApplication.logInArrayList;
import static com.example.melt.HelloApplication.usersArrayList;


public class MeltLogInController {

    public static int currentUserId =0;
    public static int currentUserRole=0;
    public static String currentUserName ="";

    public static ObservableList<LogIn> logIns= FXCollections.observableArrayList(logInArrayList);

    @FXML
    private Hyperlink CreateNewAccount;

    @FXML
    private Button LogIn;

    @FXML
    private Text loginDetection;

    @FXML
    private PasswordField Passward;

    @FXML
    private TextField UserName;
    private static int loginIdAutoIncreament=0;
    LogIn tm;
    @FXML
    private static Connection con;

    @FXML
    void LogIn(ActionEvent event) throws ClassNotFoundException, IOException, SQLException {

        loginDetection.setDisable(true);
        loginDetection.setVisible(false);

        String tmpName=UserName.getText();
        String tmpPassword=Passward.getText();

        int tmpUserId=0;
        int flag=0;

        //searching at database
        for(int i=0;i<usersArrayList.size();i++){
            if(usersArrayList.get(i).getUserName().equals(tmpName)&&usersArrayList.get(i).getPassword().equals(tmpPassword)){
                flag=1;
                if(logInArrayList.size()!=0) {
                    loginIdAutoIncreament = logInArrayList.size();
                }
                loginIdAutoIncreament++;

                currentUserId=usersArrayList.get(i).getUserId();
                currentUserRole=usersArrayList.get(i).getUserRuleId();
                currentUserName=usersArrayList.get(i).getUserName();

                Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MeltView.fxml")));
                Scene scene=new Scene(root);
                Stage primaryStage=(Stage) ((Node) event.getSource()).getScene().getWindow();
                primaryStage.setScene(scene);
                primaryStage.setMaximized(true);
                primaryStage.show();

                for (Users users : usersArrayList) {
                    if (tmpName.equals(users.getUserName()))
                        tmpUserId = users.getUserId();
                }

                //sending log in data to database
                tm=new LogIn(loginIdAutoIncreament,new Date(),tmpUserId);//here we need use id
                logInArrayList.add(tm);
                //  System.out.println(logInArrayList.toString());

                String s = String.valueOf(tm.getLoginDate().getYear()+'-' + tm.getLoginDate().getMonth()+'-' + tm.getLoginDate().getDay());
                String SQL="insert into Login values("+loginIdAutoIncreament+","+s+","+tm.getUserId()+");";

                connectDB();
                System.out.println("Connection established");
                PreparedStatement preparedStatement=con.prepareStatement(SQL);
                preparedStatement.execute();preparedStatement.close();
                con.close();
                System.out.println("Connection closed");
                break;

            }
        }
        if(flag==0){
            loginDetection.setVisible(true);
            loginDetection.setText("invalid user name or password");
        }

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
}