package com.example.melt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

import static com.example.melt.HelloApplication.employees;
import static com.example.melt.MeltLogInController.currentUserId;

public class EditEmployeeController {

    @FXML
    private Button addButton;
    @FXML
    private Button deleteButton;

    @FXML
    private TextField deptTF;

    @FXML
    private TextField emailTF;

    @FXML
    private TextField empNameTF;

    @FXML
    private TextField phoneNumberTF;

    @FXML
    private Button updateButton;
    @FXML
    private Text checkUpdates;

    @FXML
    private TextField newNameTF;

    @FXML
    void addOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        Employees tmpEmp = new Employees(empNameTF.getText(),
                emailTF.getText(),
                Double.parseDouble(deptTF.getText()),
                Integer.parseInt(phoneNumberTF.getText()),
                1);
        //add to database

        //updating database
        String SQL = "insert into employees(employeeName,email,dept,phoneNumber,userId) values('"
                + empNameTF.getText() + "','"
                + emailTF.getText() + "',"
                + Double.parseDouble(deptTF.getText())
                + "," + Integer.parseInt(phoneNumberTF.getText()) + "," + currentUserId + ");";

        Connector.a.connectDB();
        Statement stmt = Connector.a.connectDB().createStatement();
        stmt.executeUpdate(SQL);
        stmt.close();
        Connector.a.connectDB().close();

        empNameTF.clear();
        phoneNumberTF.clear();
        deptTF.clear();
        emailTF.clear();
        employees.clear();
        checkUpdates.setText("Employee has been added successfully");

        getData();
    }

    @FXML
    void backOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MeltView.fxml")));
        Scene scene = new Scene(root, 1380, 750);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    @FXML
    void deleteOnAction(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        //remove it first from the array list:
        //search for the employee:
        int tmpEmpId = 0;
        int exist = 0;
        for (int k = 0; k < employees.size(); k++) {
            if (employees.get(k).getName().equalsIgnoreCase(empNameTF.getText())) {
                tmpEmpId = employees.get(k).getId();
                employees.remove(k);
                System.out.println(tmpEmpId);
                exist = 1;
                break;
            }
        }
        //remove from database
        Connector.a.connectDB();
        String Sql = "delete from Employees where employeeId=" + tmpEmpId + ";";
        Statement stmt = Connector.a.connectDB().createStatement();
        stmt.executeUpdate(Sql);
        stmt.close();
        Connector.a.connectDB().close();

        checkUpdates.setVisible(true);
        if (exist == 1) {
            checkUpdates.setText("employee has been deleted");
        } else
            checkUpdates.setText("Employee not found");
    }

    @FXML
    void onKeyPressedOnName(KeyEvent event) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getName().equalsIgnoreCase(empNameTF.getText())) {
                emailTF.setText(employees.get(i).getEmail());
                deptTF.setText(String.valueOf(employees.get(i).getDept()));
                phoneNumberTF.setText(String.valueOf(employees.get(i).getPhoneNumber()));
            }
        }
    }

    @FXML
    void updateOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        //update email:
        int tmpEmpId = 0;
        int index = 0;
        int exist = 0;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getName().equalsIgnoreCase(empNameTF.getText())) {
                exist = 1;
                tmpEmpId = employees.get(i).getId();
                employees.get(i).setEmail(emailTF.getText());
                employees.get(i).setDept(Double.parseDouble(deptTF.getText()));
                employees.get(i).setPhoneNumber(Integer.parseInt(phoneNumberTF.getText()));

                index = i;
                break;
            }
        }
        if (exist == 1) {
            checkUpdates.setVisible(true);
            checkUpdates.setText("Employee has been updated successfully");
            //update database
            Connector.a.connectDB();

            String Sql = "update Employees" +
                    " set email = '" + employees.get(index).getEmail() +
                    "' where employeeId = " + tmpEmpId + ";";

            Statement stmt = Connector.a.connectDB().createStatement();
            stmt.executeUpdate(Sql);
            stmt.close();
            Connector.a.connectDB().close();
            ////////////////////////////////////
            //update dept
            Connector.a.connectDB();

            Sql = "update Employees" +
                    " set dept = " + employees.get(index).getDept() + " " +
                    "where employeeId = " + tmpEmpId + ";";

            stmt = Connector.a.connectDB().createStatement();
            stmt.executeUpdate(Sql);
            stmt.close();
            Connector.a.connectDB().close();
            //////////////////////////////////
            //update phone Number
            Connector.a.connectDB();

            Sql = "update Employees" +
                    " set phoneNumber = " + employees.get(index).getPhoneNumber() + " " +
                    "where employeeId = " + tmpEmpId + ";";

            stmt = Connector.a.connectDB().createStatement();
            stmt.executeUpdate(Sql);
            stmt.close();
            Connector.a.connectDB().close();
            ///////////////////////////////
            if (!newNameTF.getText().isEmpty()) {
                //update name
                Connector.a.connectDB();

                Sql = "update Employees" +
                        " set employeeName = '" + newNameTF.getText() +
                        "' where employeeId = " + tmpEmpId + ";";

                stmt = Connector.a.connectDB().createStatement();
                stmt.executeUpdate(Sql);
                stmt.close();

                Connector.a.connectDB().close();

                empNameTF.clear();
                phoneNumberTF.clear();
                deptTF.clear();
                emailTF.clear();
                employees.clear();
            }
        } else {
            checkUpdates.setVisible(true);
            checkUpdates.setText("Employee not found");
        }


    }

    private void getData() throws SQLException, ClassNotFoundException {//get d

        String SQL;
        Connector.a.connectDB();
        SQL = "select * from Employees";

        Statement stmt = Connector.a.connectDB().createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while (rs.next()) {
            employees.add(new Employees(rs.getInt(1), rs.getString(2),
                    rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6)));
        }
        rs.close();
        stmt.close();
        Connector.a.connectDB().createStatement();
    }


    @FXML
    void toUpdateNameOnAction(MouseEvent event) {
        newNameTF.setVisible(true);
    }

}
