package controller;


import classes.Client;
import classes.MédcinConvetionné;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sql.impclient;
import sql.impmedcin;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class caisseclient implements Initializable {

    static  Label idclientlabel;

    public void showinformation(Label l){idclientlabel=l; }

    @FXML
    TextField search;

    @FXML
    TableView<Client> tableclient;
    @FXML
    TableColumn<Client,Integer> idclient;
    @FXML
    TableColumn<Client,String> nomclient;
    @FXML
    TableColumn<Client,String> prenomclient;
    @FXML
    TableColumn<Client,String> nsclient;
    @FXML
    TableColumn<Client,Boolean> mcclient;

    ObservableList<Client> listclient;


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


    public void searchclient(){
        menu menu= new menu();
        menu.searchglobale(search,listclient,tableclient);
    }
    int index;

    @FXML
    Button valide;
    @FXML
    RadioButton jfxclient;
    @FXML
    RadioButton jfxmedcin;

    public void affecter(){
        if(jfxclient.isSelected()) {
            index = tableclient.getSelectionModel().getSelectedIndex();
            String id = idclient.getCellData(index).toString();
            idclientlabel.setText(id);
        }
        else{
            index = tablemedcin.getSelectionModel().getSelectedIndex();
            String id = idmedcin.getCellData(index).toString();
            idclientlabel.setText(id);

        }


    }

    public void valider(){
        Stage stag=(Stage) valide.getScene().getWindow();
        stag.close();
    }

    @FXML
    AnchorPane anchorclient;
    @FXML
    AnchorPane anchormedcin;


    public void radioclient(){
        jfxclient.setSelected(true);
        jfxmedcin.setSelected(false);
        jfxclient.requestFocus();
        anchorclient.setVisible(true);
        anchormedcin.setVisible(false);
    }
    public void radiomedcin(){
        jfxclient.setSelected(false);
        jfxmedcin.setSelected(true);
        jfxmedcin.requestFocus();
        anchorclient.setVisible(false);
        anchormedcin.setVisible(true);


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idclient.setCellValueFactory(new PropertyValueFactory<Client, Integer>("idclient"));
        nomclient.setCellValueFactory(new PropertyValueFactory<Client, String>("nom"));
        prenomclient.setCellValueFactory(new PropertyValueFactory<Client, String>("prenom"));
        nsclient.setCellValueFactory(new PropertyValueFactory<Client, String>("numsocial"));
        mcclient.setCellValueFactory(new PropertyValueFactory<Client, Boolean>("maladiechronique"));

        impclient impc = new impclient();
        try {
            listclient = impc.listclient();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        tableclient.setItems(listclient);

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
