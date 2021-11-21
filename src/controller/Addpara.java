package controller;

import classes.ProduitParapharmacetique;
import classes.typeProd;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sql.impproduitpharmacetique;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Addpara  implements Initializable {

    ObservableList<ProduitParapharmacetique> list;
    public void showinformation (ObservableList<ProduitParapharmacetique> liste){
        list=liste;
    }

    @FXML
    TextField nom;
    @FXML
    TextField qte;
    @FXML
    TextField prix;
    @FXML
    ChoiceBox typeprod;




    @FXML
    Button Ajouter;

    public void ajouter() throws SQLException {
        impproduitpharmacetique imppara=new impproduitpharmacetique();

        imppara.ajouterproduitpharmacetique(Integer.valueOf(prix.getText()),Integer.valueOf(qte.getText()),nom.getText(),typeprod.getValue().toString());
        list.add(new ProduitParapharmacetique(imppara.getid(),Integer.valueOf(prix.getText()),Integer.valueOf(qte.getText()),nom.getText(), typeProd.valueOf(typeprod.getValue().toString())));
        Stage stage=(Stage) Ajouter.getScene().getWindow();
        stage.close();
    }
    @FXML
    Button anuller;

    public void anulle(){
        Stage stage=(Stage) anuller.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList liste= FXCollections.observableArrayList("ComplémentAlimentaire" , "Cosmétique" , "Hygienique");
        typeprod.setItems(liste);
    }
}
