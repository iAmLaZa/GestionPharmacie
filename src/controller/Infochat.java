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

public class Infochat {

    int index;

    public void showinformation(int i) {
        index = i;
    }

    @FXML
    TableView<MédicamentPréscrit> infoachat;
    @FXML
    TableColumn<MédicamentPréscrit, Integer> idprod;
    @FXML
    TableColumn<MédicamentPréscrit, Integer> qte;
    @FXML
    TableColumn<MédicamentPréscrit, String> nomprod;
    @FXML
    TableColumn<MédicamentPréscrit, Integer> prix;
    ObservableList<MédicamentPréscrit> listemedprescrit;

    @FXML
    JFXToggleButton jfxshow;

    public void showachat(){
        if(jfxshow.isSelected()){
            infoachat.setVisible(true);
            idprod.setCellValueFactory(new PropertyValueFactory<MédicamentPréscrit, Integer>("id"));
            nomprod.setCellValueFactory(new PropertyValueFactory<MédicamentPréscrit, String>("nomMed"));
            qte.setCellValueFactory(new PropertyValueFactory<MédicamentPréscrit, Integer>("qte"));
            prix.setCellValueFactory(new PropertyValueFactory<MédicamentPréscrit, Integer>("prix"));

            impcommande impcommande = new impcommande();
            try {
                listemedprescrit = impcommande.listemedprescritachat(index);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            infoachat.setItems(listemedprescrit);}
        else infoachat.setVisible(false);

    }
}
