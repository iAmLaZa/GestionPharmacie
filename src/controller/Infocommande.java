package controller;


import classes.MédicamentPréscrit;
import com.jfoenix.controls.JFXToggleButton;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sql.impcommande;

import java.sql.SQLException;


public class Infocommande {

    int index;

    public void showinformation(int i) {
        index = i;
    }

    @FXML
    TableView<MédicamentPréscrit> infocommande;
    @FXML
    TableColumn<MédicamentPréscrit, Integer> idmed;
    @FXML
    TableColumn<MédicamentPréscrit, Integer> qte;
    @FXML
    TableColumn<MédicamentPréscrit, String> nommed;
    @FXML
    TableColumn<MédicamentPréscrit, Integer> prix;
    ObservableList<MédicamentPréscrit> listemedprescrit;

    @FXML
    JFXToggleButton jfxshow;

        public void showcommande(){
        if(jfxshow.isSelected()){
            infocommande.setVisible(true);
        idmed.setCellValueFactory(new PropertyValueFactory<MédicamentPréscrit, Integer>("id"));
        nommed.setCellValueFactory(new PropertyValueFactory<MédicamentPréscrit, String>("nomMed"));
        qte.setCellValueFactory(new PropertyValueFactory<MédicamentPréscrit, Integer>("qte"));
        prix.setCellValueFactory(new PropertyValueFactory<MédicamentPréscrit, Integer>("prix"));

        impcommande impcommande = new impcommande();
        try {
            listemedprescrit = impcommande.listemedprescritcoomande(index);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        infocommande.setItems(listemedprescrit);}
        else infocommande.setVisible(false);

    }
}

