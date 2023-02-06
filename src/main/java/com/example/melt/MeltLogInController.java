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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;

import static com.example.melt.HelloApplication.logInArrayList;
import static com.example.melt.HelloApplication.usersArrayList;


public class MeltLogInController {

    public static int currentUserId =0;
    public static int currentUserRole=0;
    public static String currentUserName ="";

    public static ObservableList<com.example.melt.LogIn> logIns= FXCollections.observableArrayList(logInArrayList);

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

                String s = String.valueOf(tm.getLoginDate().getYear()+'-' + tm.getLoginDate().getMonth()+'-' + tm.getLoginDate().getDay());
                String SQL="insert into Login values("+loginIdAutoIncreament+","+s+","+tm.getUserId()+");";

                Connector.a.connectDB();
                PreparedStatement preparedStatement= Connector.a.connectDB().prepareStatement(SQL);
                preparedStatement.execute();
                preparedStatement.close();
                Connector.a.connectDB().close();
                break;

            }
        }
        if(flag==0){
            loginDetection.setVisible(true);
            loginDetection.setText("invalid user name or password");
        }

    }

    @FXML
    void createAccountOnAction(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MeltCreateAccount.fxml")));
        Scene scene=new Scene(root);
        Stage primaryStage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}