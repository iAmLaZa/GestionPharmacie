package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import manipulation.outils;
import sample.BD;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class login {
    private static Connection con = BD.connect();
    private static Statement statement;

    static {
        try {
            statement = con.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static ResultSet rs = null;
    @FXML
    private Label error;
    @FXML
    private TextField usernametxt;
    @FXML
    private PasswordField passwordtxt;


    public void getlogin(ActionEvent actionEvent) throws SQLException, IOException {
        error.setText("");


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Message");

        String username = usernametxt.getText();
        String password = passwordtxt.getText();


        String sql = "select * from chefpharmacie";
        rs = statement.executeQuery(sql);

        while (rs.next()) {
            if (!rs.getString("email").equals(username)) {
                error.setText("user n'existe pas");
            } else {
                sql = "select * from chefpharmacie";
                rs = statement.executeQuery(sql);
                while (rs.next()) {
                    if (!rs.getString("password").equals(password)) {
                        error.setText("password incorret");
                    } else {

                            outils.loadp(actionEvent, "Accueil", "/sample/menu1.fxml");


                    }
                }
            }
        }
    }
}
