package controller;

import classes.Client;
import classes.Commande;
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

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class information implements Initializable {

    @FXML
    Label idclientinfo;
    @FXML
    TextField nomclientinfo;
    @FXML
    TextField prenomclientinfo;
    @FXML
    TextField numsocialinfo;
    @FXML
    TextField age;
    @FXML
    ToggleButton maladiechroniqueinfo;
    ObservableList<Client> listcl;
    int index;

    public void showinformation(int i, int id, String nom, String prenom, String num, boolean maladie, ObservableList<Client> listc,int a){
        idclientinfo.setText(String.valueOf(id));
        nomclientinfo.setText(nom);
        prenomclientinfo.setText(prenom);
        numsocialinfo.setText(num);
        listcl=listc;
        index=i;
        age.setText(String.valueOf(a));
        if(maladie==true)maladiechroniqueinfo.setSelected(true);
        else maladiechroniqueinfo.setSelected(false);

    }

    @FXML
    Button afficherachats;
    @FXML
    Button affichercommandes;

    @FXML
    TableView<Commande> tablecommandeclient;
    @FXML
    TableColumn<Commande,Integer> idcommande;
    @FXML
    TableColumn<Commande,Integer> prixcommande;

    ObservableList<Commande> listecommande;

    @FXML
    TableView<Commande> tableachatclient;
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
            listeachat=impclient.listeachats(Integer.valueOf(idclientinfo.getText()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        tableachatclient.setItems(listeachat);

        tableachatclient.setVisible(true);

    }
    public void affichercommandes(){
        affichercommandes.setVisible(false);


        idcommande.setCellValueFactory(new PropertyValueFactory<Commande,Integer>("idcommande"));
        prixcommande.setCellValueFactory(new PropertyValueFactory<Commande,Integer>("prix"));


        impclient impclient=new impclient();
        try {
            listecommande=impclient.listecomandes(Integer.valueOf(idclientinfo.getText()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        tablecommandeclient.setItems(listecommande);

        tablecommandeclient.setVisible(true);

    }
    @FXML
    Button update;

    public void update() {
        impclient impclient=new impclient();
        if(maladiechroniqueinfo.isSelected()){
            impclient.update(Integer.valueOf(idclientinfo.getText()),nomclientinfo.getText(),prenomclientinfo.getText(),numsocialinfo.getText(),true,Integer.valueOf(age.getText()));
            listcl.set(index,new Client(nomclientinfo.getText(),prenomclientinfo.getText(),Integer.valueOf(idclientinfo.getText()),numsocialinfo.getText(),true,Integer.valueOf(age.getText())));
        }
        else {
            impclient.update(Integer.valueOf(idclientinfo.getText()),nomclientinfo.getText(),prenomclientinfo.getText(),numsocialinfo.getText(),false,Integer.valueOf(age.getText()));
            listcl.set(index,new Client(nomclientinfo.getText(),prenomclientinfo.getText(),Integer.valueOf(idclientinfo.getText()),numsocialinfo.getText(),false,Integer.valueOf(age.getText())));
        }
        Stage stage=(Stage) update.getScene().getWindow();
        stage.close();



    }


    public void detailcommandebtn() throws IOException {

        index=tablecommandeclient.getSelectionModel().getSelectedIndex();
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
        index=tableachatclient.getSelectionModel().getSelectedIndex();
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
