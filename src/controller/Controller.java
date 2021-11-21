package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import sample.BD;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Controller {

    private static Connection con = BD.connect();
    private static Statement statement;

    static {
        try {
            statement = con.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void entred(ActionEvent event){
        ((Button) event.getSource()).setScaleX(1.1);
        ((Button) event.getSource()).setScaleY(1.1);
    }
    public void exited(ActionEvent event){
        ((Button) event.getSource()).setScaleX(1);
        ((Button) event.getSource()).setScaleY(1);
    }

}
