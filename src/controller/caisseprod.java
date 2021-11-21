package controller;

import classes.MédicamentProduitEnExterne;
import classes.MédicamentProduitEnInterne;
import classes.MédicamentPréscrit;
import classes.ProduitParapharmacetique;
import com.jfoenix.controls.JFXRadioButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import manipulation.outils;
import sql.*;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class caisseprod  implements Initializable {
    ObservableList<MédicamentPréscrit> listeachat= FXCollections.observableArrayList();
    ObservableList<MédicamentPréscrit> listecommande=FXCollections.observableArrayList();

    Label prixachat;
    Label prixachatsansremise;
    Label prixcommande;
    boolean ord;

    public void showinformation(ObservableList<MédicamentPréscrit> l1, ObservableList<MédicamentPréscrit> l2,Label l,Label c,Label sans,boolean o){
        listeachat=l1;
        listecommande=l2;
        prixachat=l;
        prixcommande=c;
        prixachatsansremise=sans;
        ord=o;

    }

    @FXML
    TableView<ProduitParapharmacetique> tablepara;
    @FXML
    TableColumn<ProduitParapharmacetique,Integer> idpara;
    @FXML
    TableColumn<ProduitParapharmacetique,String> nompara;
    @FXML
    TableColumn<ProduitParapharmacetique,Enum> typepara;
    @FXML
    TableColumn<ProduitParapharmacetique,Integer> prixpara;
    @FXML
    TableColumn<ProduitParapharmacetique,Integer> Qte;
    @FXML
    TextField searchpara;
    ObservableList<ProduitParapharmacetique> listpara;
    public void searchpara() {
        menu menu = new menu();
        menu.searchglobale(searchpara, listpara, tablepara);
    }

        @FXML
        TableView<MédicamentProduitEnExterne> tablemedext;
        @FXML
        TableColumn<MédicamentProduitEnExterne,Integer> idmedext;
        @FXML
        TableColumn<MédicamentProduitEnExterne,String> nommedext;
        @FXML
        TableColumn<MédicamentProduitEnExterne,Enum> typemedext;
        @FXML
        TableColumn<MédicamentProduitEnExterne,Enum> modepriseext;
        @FXML
        TableColumn<MédicamentProduitEnExterne,Boolean> ordext;
        @FXML
        TableColumn<MédicamentProduitEnExterne,Integer> prixmedext;
        @FXML
        TableColumn<MédicamentProduitEnExterne,Double> remiseext;
        @FXML
        TableColumn<MédicamentProduitEnExterne,Integer> Qteext;
        @FXML
        TableColumn<MédicamentProduitEnExterne,Integer> qteminext;

        ObservableList<MédicamentProduitEnExterne> listmedext;


        @FXML
        TableView<MédicamentProduitEnInterne> tablemedint;
        @FXML
        TableColumn<MédicamentProduitEnInterne,Integer> idmedint;
        @FXML
        TableColumn<MédicamentProduitEnInterne,String> nommedint;
        @FXML
        TableColumn<MédicamentProduitEnInterne,Enum> typemedint;
        @FXML
        TableColumn<MédicamentProduitEnInterne,Enum> modepriseint;
        @FXML
        TableColumn<MédicamentProduitEnInterne,Boolean> ordint;
        @FXML
        TableColumn<MédicamentProduitEnInterne,Integer> prixmedint;

        @FXML
        TableColumn<MédicamentProduitEnInterne,Integer> Qteint;
        @FXML
        TableColumn<MédicamentProduitEnInterne,Integer> qteminint;
        @FXML
        TableColumn<MédicamentProduitEnInterne,Double> remiseint;


        ObservableList<MédicamentProduitEnInterne> listmedint;



    @FXML
    TextField searchmedext;
    public void searchmedext(){
        menu menu= new menu();
        menu.searchglobale(searchmedext,listmedext, tablemedext);
    }
    @FXML
    TextField searchmedint;
    public void searchmedint(){
        menu menu= new menu();
        menu.searchglobale(searchmedint,listmedint, tablemedint);
    }



    @FXML
    JFXRadioButton jfxmed;

    @FXML
    JFXRadioButton jfxpara;
    @FXML
    JFXRadioButton jfxinterne;
    @FXML
    JFXRadioButton jfxexterne;

    @FXML
    AnchorPane medicamentftr;
    @FXML
    AnchorPane parapharmacetiqueftr;



    public void radiomedmenu(){
        jfxmed.setSelected(true);
        jfxpara.setSelected(false);
        jfxmed.requestFocus();
        medicamentftr.setVisible(true);
        parapharmacetiqueftr.setVisible(false);
    }
    public void radioparamenu(){
        jfxpara.setSelected(true);
        jfxmed.setSelected(false);
        jfxpara.requestFocus();
        medicamentftr.setVisible(false);
        parapharmacetiqueftr.setVisible(true);

        impproduitpharmacetique imppara=new impproduitpharmacetique();
        try {
            listpara=imppara.listprduitparapharmacetique();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        tablepara.setItems(listpara);
    }
    public void radiointernemenu(){
        jfxinterne.setSelected(true);
        jfxexterne.setSelected(false);
        jfxinterne.requestFocus();
        tablemedint.setVisible(true);
        tablemedext.setVisible(false);
        searchmedext.setVisible(false);
        searchmedint.setVisible(true);

    }
    public void radioexternemenu(){
        jfxinterne.setSelected(false);
        jfxexterne.setSelected(true);
        jfxexterne.requestFocus();
        tablemedint.setVisible(false);
        tablemedext.setVisible(true);
        searchmedext.setVisible(true);
        searchmedint.setVisible(false);

    }

    static int i;

    public void getpara(){
        i=tablepara.getSelectionModel().getSelectedIndex();
    }
    public void getmedext(){
        i=tablemedext.getSelectionModel().getSelectedIndex();
        if(ord==false && ordext.getCellData(i)==true){
            outils.showerroronmessage("error"," le médicament vendre avec ordonnance ");
            i=-1;
        }

    }
    public void getmedint(){
        i=tablemedint.getSelectionModel().getSelectedIndex();
        if(ord==false && ordint.getCellData(i)==true){
            outils.showerroronmessage("error"," le médicament vendre avec ordonnance ");
            i=-1;
        }
    }

    @FXML
    Button ajoutermed;
    @FXML
    TextField qtemedachat;
    @FXML
    DatePicker duree;
    Double prix;
    int prixsans;

    public void ajoutermed() throws SQLException {
        if(jfxinterne.isSelected() && i!=-1){
            MédicamentPréscrit p=new MédicamentPréscrit(idmedint.getCellData(i),nommedint.getCellData(i),Integer.valueOf(qtemedachat.getText()),prixmedint.getCellData(i),duree.getValue());
            if(Integer.valueOf(qtemedachat.getText()) < Qteint.getCellData(i)){
                impmedinstock impmedinstock=new impmedinstock();
                if(duree.getValue().compareTo( impmedinstock.getdateexp(idmedint.getCellData(i)))<0){
                    listeachat.add(p);
                    MédicamentProduitEnInterne interne=listmedint.get(i);
                    interne.setQte(interne.getQte()-Integer.valueOf(qtemedachat.getText()));
                    listmedint.set(i,interne);
                    prix=Integer.valueOf(qtemedachat.getText())*prixmedint.getCellData(i)-
                            (Integer.valueOf(qtemedachat.getText())*prixmedint.getCellData(i)*(remiseint.getCellData(i)/100))
                            +Double.valueOf(prixachat.getText());
                    prixachat.setText(String.valueOf(prix));
                    prixsans=Integer.valueOf(qtemedachat.getText())*prixmedint.getCellData(i)+Integer.valueOf(prixachatsansremise.getText());
                    prixachatsansremise.setText(String.valueOf(prixsans));
                    impprod impprod=new impprod();
                    if((impprod.getqte(idmedint.getCellData(i))-Integer.valueOf(qtemedachat.getText())) <impprod.getqtemin(idmedint.getCellData(i))){
                        String message="veuillez contacter le fournisseur\n"+"qte de <"+nommedint.getCellData(i)+"> inferieur au seuil minimal";
                        outils.showerroronmessage(" Prudence",message);
                    }

                }
                else{
                    outils.showerroronmessage("error"," le médicament  expirera avant la fin du traitement \n ajouter au commande");
                    listecommande.add(p);
                    prix=Integer.valueOf(qtemedachat.getText())*prixmedint.getCellData(i)-
                            (Integer.valueOf(qtemedachat.getText())*prixmedint.getCellData(i)*(remiseint.getCellData(i)/100))
                            +Double.valueOf(prixcommande.getText());
                    prixcommande.setText(String.valueOf(prix));
                }
            }
            else{
                outils.showerroronmessage("error","qte en stock insufisante \n Produit ajouter a la liste commande");
                listecommande.add(p);
                prix=Integer.valueOf(qtemedachat.getText())*prixmedint.getCellData(i)-
                        (Integer.valueOf(qtemedachat.getText())*prixmedint.getCellData(i)*(remiseint.getCellData(i)/100))
                        +Double.valueOf(prixcommande.getText());
                prixcommande.setText(String.valueOf(prix));
            }

        }
        else if(jfxexterne.isSelected() && i!=-1){
            MédicamentPréscrit p=new MédicamentPréscrit(idmedext.getCellData(i),nommedext.getCellData(i),Integer.valueOf(qtemedachat.getText()),prixmedext.getCellData(i),duree.getValue());            if(Integer.valueOf(qtemedachat.getText()) < Qteext.getCellData(i)){
                impmedextstock impmedextstock=new impmedextstock();

                if(duree.getValue().compareTo( impmedextstock.getdateexp(idmedext.getCellData(i)))<0){
                    listeachat.add(p);
                    MédicamentProduitEnExterne externe=listmedext.get(i);
                    externe.setQte(externe.getQte()-Integer.valueOf(qtemedachat.getText()));
                    listmedext.set(i,externe);
                    prixsans=Integer.valueOf(qtemedachat.getText())*prixmedext.getCellData(i)+Integer.valueOf(prixachatsansremise.getText());
                    prixachatsansremise.setText(String.valueOf(prixsans));

                    prix=Integer.valueOf(qtemedachat.getText())*prixmedext.getCellData(i)-
                            (Integer.valueOf(qtemedachat.getText())*prixmedext.getCellData(i)*(remiseext.getCellData(i)/100))
                            +Double.valueOf(prixachat.getText());
                     prixachat.setText(String.valueOf(prix));
                    impprod impprod=new impprod();
                    if((impprod.getqte(idmedext.getCellData(i))-Integer.valueOf(qtemedachat.getText())) <impprod.getqtemin(idmedext.getCellData(i))){
                        String message="veuillez realimenter le stock \n"+"qte de <"+nommedext.getCellData(i)+"> inferieur au seuil minimal";
                        outils.showerroronmessage(" Prudence",message);
                    }

                }
                else{
                    outils.showerroronmessage("error"," le médicament  expirera avant la fin du traitement \n ajouter au commande");
                    listecommande.add(p);

                    prix=Integer.valueOf(qtemedachat.getText())*prixmedext.getCellData(i)-
                            (Integer.valueOf(qtemedachat.getText())*prixmedext.getCellData(i)*(remiseext.getCellData(i)/100))
                            +Double.valueOf(prixcommande.getText());

                }
            }
            else{
                outils.showerroronmessage("error","qte en stock insufisante \n Produit ajouter a la liste commande");
                listecommande.add(p);


                prix=Integer.valueOf(qtemedachat.getText())*prixmedext.getCellData(i)-
                        (Integer.valueOf(qtemedachat.getText())*prixmedext.getCellData(i)*(remiseext.getCellData(i)/100))
                        +Double.valueOf(prixcommande.getText());

            }


        }
        else {
            outils.showerroronmessage("error"," le médicament vendre avec ordonnance ");
        }
    }





    @FXML
    TextField qteachatpara;

    @FXML
    Button ajouterpara;

    public void ajouterpara(){

        MédicamentPréscrit p=new MédicamentPréscrit(idpara.getCellData(i),nompara.getCellData(i),Integer.valueOf(qteachatpara.getText()),prixpara.getCellData(i),LocalDate.now());

        if(Integer.valueOf(qteachatpara.getText()) < Qte.getCellData(i)){
            listeachat.add(p);
            prix=Integer.valueOf(qteachatpara.getText())*prixpara.getCellData(i)+Double.valueOf(prixachat.getText());
             prixachat.setText(String.valueOf(prix));
            prix=Integer.valueOf(qteachatpara.getText())*prixpara.getCellData(i)+Double.valueOf(prixachatsansremise.getText());
             prixachatsansremise.setText(String.valueOf(prix));
        }else
        {
            outils.showerroronmessage("error","qte en stock insufisante");

        }
    }

    @FXML
    Button valider;
    public void valider(){
        Stage stage= (Stage) valider.getScene().getWindow();
        stage.close();
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idpara.setCellValueFactory(new PropertyValueFactory<ProduitParapharmacetique,Integer>("idprod"));
        nompara.setCellValueFactory(new PropertyValueFactory<ProduitParapharmacetique,String>("nomprod"));
        typepara.setCellValueFactory(new PropertyValueFactory<ProduitParapharmacetique,Enum>("typeProd"));
        prixpara.setCellValueFactory(new PropertyValueFactory<ProduitParapharmacetique,Integer>("prix"));
        Qte.setCellValueFactory(new PropertyValueFactory<ProduitParapharmacetique,Integer>("qte"));

        impproduitpharmacetique imppara=new impproduitpharmacetique();
        try {
            listpara=imppara.listprduitparapharmacetique();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        tablepara.setItems(listpara);



        idmedext.setCellValueFactory(new PropertyValueFactory<MédicamentProduitEnExterne,Integer>("idprod"));
        nommedext.setCellValueFactory(new PropertyValueFactory<MédicamentProduitEnExterne,String>("nomprod"));
        typemedext.setCellValueFactory(new PropertyValueFactory<MédicamentProduitEnExterne,Enum>("typeMed"));
        modepriseext.setCellValueFactory(new PropertyValueFactory<MédicamentProduitEnExterne,Enum>("modePriseMed"));
        ordext.setCellValueFactory(new PropertyValueFactory<MédicamentProduitEnExterne,Boolean>("ordRequise"));
        prixmedext.setCellValueFactory(new PropertyValueFactory<MédicamentProduitEnExterne,Integer>("prix"));
        Qteext.setCellValueFactory(new PropertyValueFactory<MédicamentProduitEnExterne,Integer>("qte"));
        qteminext.setCellValueFactory(new PropertyValueFactory<MédicamentProduitEnExterne,Integer>("qtemin"));
        remiseext.setCellValueFactory(new PropertyValueFactory<MédicamentProduitEnExterne,Double>("remise"));

        impmedext impext=new impmedext();
        try {
            listmedext=impext.listmedext();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        tablemedext.setItems(listmedext);

        idmedint.setCellValueFactory(new PropertyValueFactory<MédicamentProduitEnInterne,Integer>("idprod"));
        nommedint.setCellValueFactory(new PropertyValueFactory<MédicamentProduitEnInterne,String>("nomprod"));
        typemedint.setCellValueFactory(new PropertyValueFactory<MédicamentProduitEnInterne,Enum>("typeMed"));
        modepriseint.setCellValueFactory(new PropertyValueFactory<MédicamentProduitEnInterne,Enum>("modePriseMed"));
        ordint.setCellValueFactory(new PropertyValueFactory<MédicamentProduitEnInterne,Boolean>("ordRequise"));
        prixmedint.setCellValueFactory(new PropertyValueFactory<MédicamentProduitEnInterne,Integer>("prix"));
        Qteint.setCellValueFactory(new PropertyValueFactory<MédicamentProduitEnInterne,Integer>("qte"));
        qteminint.setCellValueFactory(new PropertyValueFactory<MédicamentProduitEnInterne,Integer>("qtemin"));
        remiseint.setCellValueFactory(new PropertyValueFactory<MédicamentProduitEnInterne,Double>("remise"));

        impmedint impint=new impmedint();
        try {
            listmedint=impint.listmedint();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        tablemedint.setItems(listmedint);
    }
}
