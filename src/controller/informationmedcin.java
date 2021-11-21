package controller;

import classes.Commande;
import classes.MédcinConvetionné;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sql.impclient;
import sql.impmedcin;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class informationmedcin implements Initializable {
    int index;
    MédcinConvetionné medcin;
    ObservableList<MédcinConvetionné> list;

    public void showinformation(ObservableList<MédcinConvetionné> liste,int i, MédcinConvetionné m){list=liste;medcin=m;index=i;
    id.setText(String.valueOf(medcin.getIdMed()));
    nom.setText(medcin.getNom());
    prenom.setText(medcin.getPrenom());
    age.setText(String.valueOf(medcin.getAge()));
    adresse.setText(medcin.getAdresse());
    spacialite.setText(medcin.getSpecialite());

    }

    @FXML
    Label id;
    @FXML
    TextField nom;
    @FXML
    TextField prenom;
    @FXML
    TextField age;
    @FXML
    TextField adresse;
    @FXML
    TextField spacialite;


    @FXML
    Button afficherachats;
    @FXML
    Button affichercommandes;

    @FXML
    TableView<Commande> tablecommandemedcin;
    @FXML
    TableColumn<Commande,Integer> idcommande;
    @FXML
    TableColumn<Commande,Integer> prixcommande;

    ObservableList<Commande> listecommande;

    @FXML
    TableView<Commande> tableachatmedcin;
    @FXML
    TableColumn<Commande,Integer> idachat;
    @FXML
    TableColumn<Commande,Integer> prixachat;

    ObservableList<Commande> listeachat;



    public void afficherachats(){
        afficherachats.setVisible(false);

        idachat.setCellValueFactory(new PropertyValueFactory<Commande,Integer>("idcommande"));
        prixachat.setCellValueFactory(new PropertyValueFactory<Commande,Integer>("prix"));


        impclient impclient=new impclient();
        try {
            listeachat=impclient.listeachats(Integer.valueOf(id.getText()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        tableachatmedcin.setItems(listeachat);

        tableachatmedcin.setVisible(true);

    }
    public void affichercommandes(){
        affichercommandes.setVisible(false);


        idcommande.setCellValueFactory(new PropertyValueFactory<Commande,Integer>("idcommande"));
        prixcommande.setCellValueFactory(new PropertyValueFactory<Commande,Integer>("prix"));


        impclient impclient=new impclient();
        try {
            listecommande=impclient.listecomandes(Integer.valueOf(id.getText()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        tablecommandemedcin.setItems(listecommande);

        tablecommandemedcin.setVisible(true);

    }



    @FXML
    Button update;

    public void update() {
        medcin.setAge(Integer.valueOf(age.getText()));
        medcin.setNom(nom.getText());
        medcin.setPrenom(prenom.getText());
        medcin.setAdresse(adresse.getText());
        medcin.setSpecialite(spacialite.getText());
        impmedcin impmedcin=new impmedcin();

            impmedcin.updatemedcin(medcin.getIdMed(),medcin.getNom(),medcin.getPrenom(),medcin.getAge(),medcin.getAdresse(),medcin.getSpecialite());
            list.set(index,medcin);

        Stage stage=(Stage) update.getScene().getWindow();
        stage.close();



    }

    public void detailcommandebtn() throws IOException {

        index=tablecommandemedcin.getSelectionModel().getSelectedIndex();
        if(index>-1){
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/sample/infocommande.fxml"));
            Parent root= loader.load();

            Infocommande infocommande=loader.getController();
            infocommande.showinformation(idcommande.getCellData(index));
            Scene scene=new Scene(root);
            Stage stage=new Stage();
            stage.setScene(scene);
            stage.setTitle("information Commande");
            stage.show();}
        else return;

    }
    public void detailachatbtn() throws IOException {
        index=tableachatmedcin.getSelectionModel().getSelectedIndex();
        if(index>-1){
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/sample/infoachat.fxml"));
            Parent root= loader.load();

            Infochat infochat=loader.getController();
            infochat.showinformation(idachat.getCellData(index));
            Scene scene=new Scene(root);
            Stage stage=new Stage();
            stage.setScene(scene);
            stage.setTitle("information Achat");
            stage.show();}
        else return;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
