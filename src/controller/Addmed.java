package controller;

import classes.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import manipulation.outils;
import sql.impmed;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Addmed  implements Initializable {
    ObservableList<MédicamentProduitEnInterne> listmedint;
    ObservableList<MédicamentProduitEnExterne> listmedext;

    public void showinformation(ObservableList<MédicamentProduitEnInterne> l1, ObservableList<MédicamentProduitEnExterne> l2){
        listmedint=l1;
        listmedext=l2;
    }

    @FXML
    TextField nom;
    @FXML
    TextField qtemin;
    @FXML
    TextField Qte;
    @FXML
    TextField prix;
    @FXML
    TextField remise;
    @FXML
    ChoiceBox typemed;
    @FXML
    ChoiceBox modeprise;

    @FXML
    ToggleButton ord;



    @FXML
    Button suivant;

    public void suivant(ActionEvent event) throws IOException {

        impmed impmed=new impmed();
        if(!nom.getText().isEmpty() && !qtemin.getText().isEmpty()&&!prix.getText().isEmpty()&&!Qte.getText().isEmpty()&&!ord.getText().isEmpty()
        &&!modeprise.getValue().toString().isEmpty() && !typemed.getValue().toString().isEmpty()){
            Médicament med=new Médicament(0,Integer.valueOf(prix.getText()),Integer.valueOf(Qte.getText()),nom.getText(), typeMed.valueOf(typemed.getValue().toString()), modePrise.valueOf(modeprise.getValue().toString()),ord.isSelected(),
                    Integer.valueOf(qtemin.getText()),Double.valueOf(remise.getText()));
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/sample/detailmed.fxml"));
            Parent root= loader.load();

            Detailmed detailmed=loader.getController();
            detailmed.showinformation(listmedint,listmedext,med);
            Scene scene=new Scene(root);
            Stage stage=new Stage();
            stage.setScene(scene);
            stage.setTitle("Ajouter un Medicament");
            stage.show();


            Stage stag=(Stage) suivant.getScene().getWindow();
            stag.close();

    }
        else {
            outils.showerroronmessage("erruer","remplire tout les champs");
        }
    }
    @FXML
    Button anuller;
    public void anuller(){
        Stage stage=(Stage) anuller.getScene().getWindow();
        stage.close();
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList liste= FXCollections.observableArrayList("Antibiothique", "Antihistaminique", "analgersique");
        typemed.setItems(liste);
        ObservableList list= FXCollections.observableArrayList( "Orale", "Nasale", "Injectable", "ApplicationCutanée");
        modeprise.setItems(list);
    }
}
