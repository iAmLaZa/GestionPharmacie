package controller;

import classes.Commande;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sql.impcommande;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Caissecommande implements Initializable {

    @FXML
    TextField search;

    public void searchcommande(){
        menu menu =new menu();
        menu.searchglobale(search,listecommande,tablecommande);
    }

    @FXML
    TableView<Commande> tablecommande;
    @FXML
    TableColumn<Commande,Integer> idcommande;
    @FXML
    TableColumn<Commande,Integer> idclient;
    @FXML
    TableColumn<Commande,Integer> prix;

    ObservableList<Commande> listecommande;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        idcommande.setCellValueFactory(new PropertyValueFactory<Commande,Integer>("idcommande"));
        idclient.setCellValueFactory(new PropertyValueFactory<Commande,Integer>("idclient"));
        prix.setCellValueFactory(new PropertyValueFactory<Commande,Integer>("prix"));


        impcommande impcommande=new impcommande();
        try {
            listecommande=impcommande.listcommande();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        tablecommande.setItems(listecommande);

    }
}
