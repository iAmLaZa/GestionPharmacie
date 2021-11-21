package controller;


import classes.*;
import com.jfoenix.controls.JFXRadioButton;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sql.*;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Detailmed  implements Initializable {

    ObservableList<MédicamentProduitEnInterne> listmedint;
    ObservableList<MédicamentProduitEnExterne> listmedext;
    Médicament med;

    public void showinformation(ObservableList<MédicamentProduitEnInterne> l1, ObservableList<MédicamentProduitEnExterne> l2,Médicament m ){
        listmedint=l1;
        listmedext=l2;
        med=m;
    }

    @FXML
    TextField numlot;
    @FXML
    DatePicker dateexp;
    @FXML
    JFXRadioButton interneaj;
    @FXML
    JFXRadioButton externeaj;

    @FXML
    AnchorPane detailint;
    @FXML
    AnchorPane detailext;


    public void ext(){
        externeaj.setSelected(true);
        interneaj.setSelected(false);
        externeaj.requestFocus();
        detailext.setVisible(true);
        detailint.setVisible(false);
    }
    public void intr(){
        externeaj.setSelected(false);
        interneaj.setSelected(true);
        interneaj.requestFocus();
        detailext.setVisible(false);

    }

    @FXML
    Button ajouter;
    @FXML
    Button terminer;
    @FXML
    TextField nomfirme;

    int index;

    public void ajouter() throws SQLException {
        if(externeaj.isSelected()){
            impmed impmed=new impmed();
            impmed.ajoutermed(med.getNomprod(),med.getTypeMed().toString(),med.getModePriseMed().toString(),med.isOrdRequise(),
                    med.getQtemin(),med.getQte(),med.getPrix(),med.getRemise());
            impmedext impmedext=new impmedext();
            impmedext.ajoutermedext(nomfirme.getText());
            impmedinstock impmedinstock=new impmedinstock();
            index=impmedinstock.getid();

            impmedextstock impmedextstock=new impmedextstock();
            impmedextstock.ajoutermedextstock(Integer.valueOf(numlot.getText()),dateexp.getValue());

                MédicamentProduitEnExterne mext=new MédicamentProduitEnExterne(index,med.getPrix(),med.getQte(),med.getNomprod(),med.getTypeMed(),med.getModePriseMed(),
                        med.isOrdRequise(),med.getQtemin(),med.getRemise(),nomfirme.getText());
                listmedext.add(mext);


            Stage stage=(Stage) ajouter.getScene().getWindow();
            stage.close();

        }else if(interneaj.isSelected()){
            impmed impmed=new impmed();
            impmed.ajoutermed(med.getNomprod(),med.getTypeMed().toString(),med.getModePriseMed().toString(),med.isOrdRequise(),
                    med.getQtemin(),med.getQte(),med.getPrix(),med.getRemise());
            impmedint impmedint=new impmedint();
            impmedint.ajoutermedint();

            impmedinstock impmedinstock=new impmedinstock();
            index=impmedinstock.getid();


            impmedinstock.ajoutermedintstock(Integer.valueOf(numlot.getText()),dateexp.getValue());

            detailint.setVisible(true);
            ajouter.setVisible(false);
            terminer.setVisible(true);
            index=impmedinstock.getid();
        }
    }
    int i;
    public void get(){
        i=tablematiere.getSelectionModel().getSelectedIndex();
        idtab.setText(idmatiere.getCellData(i).toString());
    }

    @FXML
    Button add;
    @FXML
    TextField searchmatiere;
    public void searchmat(){
        searchmatiere.textProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                if(searchmatiere.textProperty().get().isEmpty()){
                    tablematiere.setItems(listematiere);
                    return;
                }
                ObservableList items= FXCollections.observableArrayList();
                ObservableList<TableColumn<Matiére, ?>> colone=tablematiere.getColumns();

                for(int ligne=0;ligne<listematiere.size();ligne++){
                    for(int col=0;col<colone.size();col++){
                        TableColumn colvar=colone.get(col);
                        String cellvalue=colvar.getCellData(listematiere.get(ligne)).toString();
                        cellvalue=cellvalue.toLowerCase();
                        if(cellvalue.contains(searchmatiere.getText().toLowerCase() )&& cellvalue.startsWith(searchmatiere.getText().toLowerCase())){
                            items.add(listematiere.get(ligne));
                            break;
                        }
                    }
                }
                tablematiere.setItems(items);
            }
        });
    }


    @FXML
    TextField dossage;
    @FXML
    TableView<Matiére> tablematiere;
    @FXML
    TableColumn<Matiére,Integer> idmatiere;
    @FXML
    TableColumn<Matiére,String> nommatiere;

    ObservableList<Matiére> listematiere;


    @FXML
    TextField ajoutermatiere;
    public void addmatiere(){
        impmatiere impmatiere=new impmatiere();
        impmatiere.ajoutermatiere(ajoutermatiere.getText());
    }

    @FXML
    TableView<matiéredossage> tablematieredossage;
    @FXML
    TableColumn<matiéredossage,Integer> idmed;
    @FXML
    TableColumn<matiéredossage,Integer> idmat;
    @FXML
    TableColumn<matiéredossage,Integer> doss;

    ObservableList<matiéredossage> listmatdoss;

    @FXML
    Label idtab;


    public void add(){
        System.out.println(index);
        impmedint impmedint=new impmedint();
        impmedint.ajoutermatieredossage(index,Integer.valueOf(idtab.getText()),Integer.valueOf(dossage.getText()));
        listmatdoss.add( new matiéredossage(Integer.valueOf(idtab.getText()),index,Integer.valueOf(dossage.getText())));

    }
    public void terminer() throws SQLException {

        MédicamentProduitEnInterne mint=new MédicamentProduitEnInterne(index,med.getPrix(),med.getQte(),med.getNomprod(),med.getTypeMed(),med.getModePriseMed(),
                med.isOrdRequise(),med.getQtemin(),med.getRemise());

        listmedint.add(mint);

        Stage stage=(Stage) terminer.getScene().getWindow();
        stage.close();
    }

    @FXML
    TextField qteadd;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idmatiere.setCellValueFactory(new PropertyValueFactory<Matiére,Integer>("idMatiére"));
        nommatiere.setCellValueFactory(new PropertyValueFactory<Matiére,String>("nomMatiére"));

        idmed.setCellValueFactory(new PropertyValueFactory<matiéredossage,Integer>("idmedinterne"));
        idmat.setCellValueFactory(new PropertyValueFactory<matiéredossage,Integer>("idMatiére"));
        doss.setCellValueFactory(new PropertyValueFactory<matiéredossage,Integer>("dossage"));

        impmedint impmedint=new impmedint();
        try {
            listmatdoss=impmedint.listmatieredossage(0);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        tablematieredossage.setItems(listmatdoss);

        impmatiere impmatiere=new impmatiere();
        try {
            listematiere=impmatiere.listematiere();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        tablematiere.setItems(listematiere);

    }
}
