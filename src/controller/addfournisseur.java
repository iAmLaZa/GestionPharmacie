package controller;


import classes.Fournisseur;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sql.impfournisseur;

import java.sql.SQLException;

public class addfournisseur {

    ObservableList<Fournisseur> list;
    public void showinformation (ObservableList<Fournisseur> liste){
        list=liste;
    }

    @FXML
    TextField nom;
    @FXML
    TextField num;


    @FXML
    Button ajouter;

    public void ajouter() throws SQLException {
        impfournisseur impfournisseur=new impfournisseur();

            impfournisseur.ajouterfournisseur(num.getText(),nom.getText());
            list.add(new Fournisseur(impfournisseur.getid(num.getText()),num.getText(),nom.getText()));
            Stage stage=(Stage) ajouter.getScene().getWindow();
            stage.close();
    }
    @FXML
    Button anu;

    public void anu(){
        Stage stage=(Stage) anu.getScene().getWindow();
        stage.close();
    }
}
