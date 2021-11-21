package controller;

import classes.Client;
import com.jfoenix.controls.JFXToggleButton;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sql.impclient;

import java.sql.SQLException;

public class Addclient {
    ObservableList<Client> list;
    public void showinformation (ObservableList<Client> liste){
        list=liste;
    }

    @FXML
    TextField nom;
    @FXML
    TextField prenom;
    @FXML
    TextField numsocial;
    @FXML
    TextField age;
    @FXML
    JFXToggleButton maladie;

    @FXML
    Button ajouter;

    public void ajou() throws SQLException {
        impclient impclient=new impclient();
        if(maladie.isSelected()==true){
            impclient.ajouterclient(nom.getText(),prenom.getText(),numsocial.getText(),true,Integer.valueOf(age.getText()));
            list.add(new Client(nom.getText(),prenom.getText(),impclient.getid((numsocial.getText())),numsocial.getText(),true,Integer.valueOf(age.getText())));
        }
        else {
                impclient.ajouterclient(nom.getText(),prenom.getText(),numsocial.getText(),false,Integer.valueOf(age.getText()));
                list.add(new Client(nom.getText(),prenom.getText(),impclient.getid((numsocial.getText())),numsocial.getText(),false,Integer.valueOf(age.getText())));
            }

        Stage stage=(Stage) ajouter.getScene().getWindow();
        stage.close();
    }
    @FXML
    Button an;

    public void an(){
        Stage stage=(Stage) an.getScene().getWindow();
        stage.close();
    }

}
