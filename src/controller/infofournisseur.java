package controller;

import classes.Fournisseur;
import classes.Livraison;
import classes.medlivraison;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sql.impfournisseur;
import sql.implivraison;

import java.io.IOException;
import java.sql.SQLException;

public class infofournisseur {


    @FXML
    Label idf;
    @FXML
    TextField nomf;
    @FXML
    TextField numtelf;
    int i;
    ObservableList<Fournisseur> listf;


    public void showinformation(int index,int id,String nom,String numtel,ObservableList<Fournisseur> listef){
        i=index;
        idf.setText(String.valueOf(id));
        nomf.setText(nom);
        numtelf.setText(numtel);
        listf=listef;

    }

    @FXML
    TableView<Livraison> tablelivraison;
    @FXML
    TableColumn<Livraison,Integer> idlivraisonf;

    ObservableList<Livraison> listelivraison;

    @FXML
    Button afficherlivraison;

    public void afficherlivraison(){
        afficherlivraison.setVisible(false);

        idlivraisonf.setCellValueFactory(new PropertyValueFactory<Livraison,Integer>("idlivraison"));

        impfournisseur impfournisseur=new impfournisseur();
        try {
            listelivraison=impfournisseur.listelivraison(Integer.valueOf(idf.getText()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        tablelivraison.setItems(listelivraison);

        tablelivraison.setVisible(true);
    }
    @FXML
    Button updatef;
    public void updatefournisseur() {

        impfournisseur impfournisseur=new impfournisseur();
        impfournisseur.update(Integer.valueOf(idf.getText()),numtelf.getText(),nomf.getText());

        listf.set(i,new Fournisseur(Integer.valueOf(idf.getText()),numtelf.getText(),nomf.getText()));
        Stage stage=(Stage) updatef.getScene().getWindow();
        stage.close();


    }

    @FXML
    TableView<medlivraison> detaillivraison;
    @FXML
    TableColumn<medlivraison,Integer> idmed;
    @FXML
    TableColumn<medlivraison,String> nommed;
    @FXML
    TableColumn<medlivraison,Integer> qte;

    ObservableList<medlivraison> listemedlivraison;

    public void detaillivraison() {
        int index = tablelivraison.getSelectionModel().getSelectedIndex();
        if (index > -1) {
            idmed.setCellValueFactory(new PropertyValueFactory<medlivraison,Integer>("idmed"));
            qte.setCellValueFactory(new PropertyValueFactory<medlivraison,Integer>("qteliv"));
            nommed.setCellValueFactory(new PropertyValueFactory<medlivraison,String>("nom"));

            implivraison implivraison=new implivraison();
            try {
                listemedlivraison=implivraison.listemedlivraison(idlivraisonf.getCellData(index));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            detaillivraison.setItems(listemedlivraison);

            detaillivraison.setVisible(true);

        }else return;
    }


    @FXML
    Button livraison;


    public void affecterlivraison() throws IOException, SQLException {

        implivraison implivraison=new implivraison();
        implivraison.ajouterlivraison(Integer.valueOf(idf.getText()));

        FXMLLoader loader=new FXMLLoader(getClass().getResource("/sample/addlivraison.fxml"));
        Parent root= loader.load();
        Addlivraison addlivraison=loader.getController();
        addlivraison.showinformation(Integer.valueOf(idf.getText()),implivraison.getid());
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setTitle("Recevoire Livraison");

        Stage stag=(Stage) livraison.getScene().getWindow();
        stag.close();


        stage.show();
    }
}
