package com.example.melt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

import static com.example.melt.HelloApplication.rulesArrayList;
import static com.example.melt.HelloApplication.usersArrayList;

public class MeltCreateAccountController {

    @FXML
    private ToggleGroup accessLevel;

    @FXML
    private RadioButton adminAL;

    @FXML
    private RadioButton employeeAL;
    @FXML
    private Button createAccount;

    @FXML
    private TextField passward;

    @FXML
    private Button back;

    @FXML
    private TextField userName;

    @FXML
    void createAccountOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {

        int accessLevel = 0;

        if(adminAL.isSelected())
            accessLevel=1;

        else if(employeeAL.isSelected())
            accessLevel=2;

        Users tmp=new Users(userName.getText(),passward.getText(),accessLevel);

        //check the password:
        int check=0;

        for (Users users : usersArrayList) {
            if ((tmp.getPassword().equals(users.getPassword()))) {
                check = 1;
                break;
            }
        }

        //make sure that rule id exist:
        int flag=0;
        for (Rules rules : rulesArrayList) {
            if (tmp.getUserRuleId() == rules.getRuleId()) {
                flag = 1;
                if (check == 0) {
                    //   check=1;
                    usersArrayList.add(tmp);//you added with out id, so re read from data base
                    //you have to add the user to the database

                    //updating database
                    String SQL = "insert into Users(userName,userPassword,userRoleId) values('"
                            + userName.getText() +
                            "','" + passward.getText() +
                            "'," + accessLevel + ");";

                    Connector.a.connectDB();
                    Statement stmt =Connector.a.connectDB().createStatement();
                    stmt.executeUpdate(SQL);
                    stmt.close();
                    Connector.a.connectDB().close();
                    userName.clear();
                    passward.clear();
                    adminAL.setSelected(false);
                    employeeAL.setSelected(false);
                    usersArrayList.clear();
                    break;
                }
            }
        }
    }

    @FXML
    void backOnAction(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MeltLogIn.fxml")));
        Scene scene=new Scene(root);
        Stage primaryStage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
