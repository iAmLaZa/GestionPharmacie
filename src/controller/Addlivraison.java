package controller;

import classes.MédicamentProduitEnExterne;
import classes.Produit;
import classes.ProduitParapharmacetique;
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
import sql.implivraison;
import sql.impmedext;
import sql.impprod;
import sql.impproduitpharmacetique;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Addlivraison  implements Initializable {
    int index,idlivraison;
    public void showinformation(int i,int j){index=i;idlivraison=j;}


    @FXML
    RadioButton medlivraison;
    @FXML
    RadioButton paralivraison;
    @FXML
    AnchorPane medftr;
    @FXML
    AnchorPane paraftr;


    public void medlivraison(){
        medlivraison.setSelected(true);
        medlivraison.requestFocus();
        paralivraison.setSelected(false);
        medftr.setVisible(true);
        paraftr.setVisible(false);
    }
    public void paralivraison(){
        medlivraison.setSelected(false);
        paralivraison.requestFocus();
        paralivraison.setSelected(true);
        medftr.setVisible(false);
        paraftr.setVisible(true);

    }

    @FXML
    TextField searchmed;

    public void searchmed(){
        searchmed.textProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                if(searchmed.textProperty().get().isEmpty()){
                    tablemed.setItems(listemed);
                    return;
                }
                ObservableList items= FXCollections.observableArrayList();
                ObservableList<TableColumn<MédicamentProduitEnExterne, ?>> colone=tablemed.getColumns();

                for(int ligne=0;ligne<listemed.size();ligne++){
                    for(int col=0;col<colone.size();col++){
                        TableColumn colvar=colone.get(col);
                        String cellvalue=colvar.getCellData(listemed.get(ligne)).toString();
                        cellvalue=cellvalue.toLowerCase();
                        if(cellvalue.contains(searchmed.getText().toLowerCase() )&& cellvalue.startsWith(searchmed.getText().toLowerCase())){
                            items.add(listemed.get(ligne));
                            break;
                        }
                    }
                }
                tablemed.setItems(items);
            }
        });
    }

    @FXML
    TableView<MédicamentProduitEnExterne> tablemed;
    @FXML
    TableColumn<MédicamentProduitEnExterne,Integer> idmed;
    @FXML
    TableColumn<MédicamentProduitEnExterne,String> nommed;

    ObservableList<MédicamentProduitEnExterne> listemed;

    @FXML
    TextField qtemed;
    @FXML
    Button ajoutermed;





    @FXML
    TextField searchpara;
    public void searchpara(){
        searchpara.textProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                if(searchpara.textProperty().get().isEmpty()){
                    tablepara.setItems(listepara);
                    return;
                }
                ObservableList items= FXCollections.observableArrayList();
                ObservableList<TableColumn<ProduitParapharmacetique, ?>> colone=tablepara.getColumns();

                for(int ligne=0;ligne<listepara.size();ligne++){
                    for(int col=0;col<colone.size();col++){
                        TableColumn colvar=colone.get(col);
                        String cellvalue=colvar.getCellData(listepara.get(ligne)).toString();
                        cellvalue=cellvalue.toLowerCase();
                        if(cellvalue.contains(searchpara.getText().toLowerCase() )&& cellvalue.startsWith(searchpara.getText().toLowerCase())){
                            items.add(listepara.get(ligne));
                            break;
                        }
                    }
                }
                tablepara.setItems(items);
            }
        });
    }


    @FXML
    TableView<ProduitParapharmacetique> tablepara;
    @FXML
    TableColumn<ProduitParapharmacetique,Integer> idpara;
    @FXML
    TableColumn<ProduitParapharmacetique,String> nompara;

    ObservableList<ProduitParapharmacetique> listepara;

    @FXML
    TextField qtepara;
    @FXML
    Button ajouterpara;

    @FXML
    TableView<Produit> tablelivraison;
    @FXML
    TableColumn<Produit,Integer> idprod;
    @FXML
    TableColumn<Produit,String> nomprod;
    @FXML
    TableColumn<Produit,Integer> qteprod;

    ObservableList<Produit> listeprod;


    @FXML
    Button confirmer;

    public void confirmer(){
        Stage stage=(Stage) confirmer.getScene().getWindow();
        stage.close();
    }


    @FXML
    Label labelidmed;
    @FXML
    Label labelnommed;
    @FXML
    Label labelidpara;
    @FXML
    Label labelnompara;

    int i;
    public void getmed(){
        i=tablemed.getSelectionModel().getSelectedIndex();
        labelidmed.setText(idmed.getCellData(i).toString());
        labelnommed.setText(nommed.getCellData(i));
    }
    public void getpara(){
        i=tablepara.getSelectionModel().getSelectedIndex();
        labelidpara.setText(idpara.getCellData(i).toString());
        labelnompara.setText(nompara.getCellData(i));

    }


    public void ajouterpara() throws SQLException {
        implivraison implivraison=new implivraison();
        implivraison.ajouterproduit(idlivraison,Integer.valueOf(labelidpara.getText()),Integer.valueOf(qtepara.getText()));

        impprod impprod=new impprod();

        impprod.updateget(Integer.valueOf(labelidpara.getText()),Integer.valueOf(qtepara.getText()));
        listeprod.add(new Produit(Integer.valueOf(labelidpara.getText()),Integer.valueOf(qtepara.getText()),labelnompara.getText()));


    }
    public void ajoutermed() throws SQLException {

        implivraison implivraison=new implivraison();
        implivraison.ajouterproduit(idlivraison,Integer.valueOf(labelidmed.getText()),Integer.valueOf(qtemed.getText()));

        impprod impprod=new impprod();

        impprod.updateget(Integer.valueOf(labelidmed.getText()),Integer.valueOf(qtemed.getText()));
        listeprod.add(new Produit(Integer.valueOf(labelidmed.getText()),Integer.valueOf(qtemed.getText()),labelnommed.getText()));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        idprod.setCellValueFactory(new PropertyValueFactory<Produit,Integer>("idprod"));
        nomprod.setCellValueFactory(new PropertyValueFactory<Produit,String>("nomprod"));
        qteprod.setCellValueFactory(new PropertyValueFactory<Produit,Integer>("qte"));

        impprod impprod=new impprod();
        try {
            listeprod=impprod.listeprod();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        tablelivraison.setItems(listeprod);


        idmed.setCellValueFactory(new PropertyValueFactory<MédicamentProduitEnExterne,Integer>("idprod"));
        nommed.setCellValueFactory(new PropertyValueFactory<MédicamentProduitEnExterne,String>("nomprod"));

        impmedext impmedext=new impmedext();
        try {
            listemed=impmedext.listmedext();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        tablemed.setItems(listemed);


        idpara.setCellValueFactory(new PropertyValueFactory<ProduitParapharmacetique,Integer>("idprod"));
        nompara.setCellValueFactory(new PropertyValueFactory<ProduitParapharmacetique,String>("nomprod"));

        impproduitpharmacetique impp=new impproduitpharmacetique();
        try {
            listepara=impp.listprduitparapharmacetique();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        tablepara.setItems(listepara);
    }
}
