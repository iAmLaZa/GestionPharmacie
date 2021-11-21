package controller;

import classes.MédcinConvetionné;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sql.impmedcin;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class caissemedcin implements Initializable {


    static Label idclientlabel;

    public void showinformation(Label l){idclientlabel=l; }

    @FXML
    TextField searchmc;

    @FXML
    TableView<MédcinConvetionné> tablemedcin;
    @FXML
    TableColumn<MédcinConvetionné,Integer> idmedcin;
    @FXML
    TableColumn<MédcinConvetionné,String> nommedcin;
    @FXML
    TableColumn<MédcinConvetionné,String> prenommedcin;
    @FXML
    TableColumn<MédcinConvetionné,Integer> agemedcin;
    @FXML
    TableColumn<MédcinConvetionné,String> adresse;
    @FXML
    TableColumn<MédcinConvetionné,String> specialite;


    ObservableList<MédcinConvetionné> listmedcin;


    public void searchmedcin(){
        menu menu= new menu();
        menu.searchglobale(searchmc,listmedcin,tablemedcin);
    }

    int index;

    @FXML
    Button valide;
    public void affecter(){
        index=tablemedcin.getSelectionModel().getSelectedIndex();
        String id=idmedcin.getCellData(index).toString();
        idclientlabel.setText(id);


    }

    public void valider(){
        Stage stag=(Stage) valide.getScene().getWindow();
        stag.close();
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idmedcin.setCellValueFactory(new PropertyValueFactory<MédcinConvetionné, Integer>("idMed"));
        nommedcin.setCellValueFactory(new PropertyValueFactory<MédcinConvetionné, String>("nom"));
        prenommedcin.setCellValueFactory(new PropertyValueFactory<MédcinConvetionné, String>("prenom"));
        agemedcin.setCellValueFactory(new PropertyValueFactory<MédcinConvetionné, Integer>("age"));
      adresse.setCellValueFactory(new PropertyValueFactory<MédcinConvetionné, String>("adresse"));
        specialite.setCellValueFactory(new PropertyValueFactory<MédcinConvetionné, String>("specialite"));

        impmedcin impmedcin=new impmedcin();
        try {
            listmedcin = impmedcin.listmedcin();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        tablemedcin.setItems(listmedcin);

    }
}
