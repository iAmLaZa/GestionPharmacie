package controller;

import classes.MédcinConvetionné;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sql.impmedcin;

import java.sql.SQLException;

public class addmedcin {

    ObservableList<MédcinConvetionné> list;
    public void showinformation (ObservableList<MédcinConvetionné> liste){
        list=liste;
    }

    @FXML
    TextField nom;
    @FXML
    TextField prenom;
    @FXML
    TextField age;
    @FXML
    TextField adresse;
    @FXML
    TextField specialite;

    @FXML
    Button ajouter;

    public void ajou() throws SQLException {
        impmedcin impmedcin=new impmedcin();
        impmedcin.ajoutermedcin(nom.getText(),prenom.getText(),Integer.valueOf(age.getText()),adresse.getText(),specialite.getText());
        list.add(new MédcinConvetionné(nom.getText(),prenom.getText(),Integer.valueOf(age.getText()),impmedcin.getidmedcin(),adresse.getText(),specialite.getText()));
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
