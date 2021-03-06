package controller;



import classes.*;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXToggleButton;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import manipulation.outils;
import sql.*;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;


public class menu implements Initializable {
    public static void searchglobale(TextField searchgolbale,ObservableList list,TableView table){

        searchgolbale.textProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                if(searchgolbale.textProperty().get().isEmpty()){
                    table.setItems(list);
                    return;
                }
                ObservableList items= FXCollections.observableArrayList();
                ObservableList<TableColumn> colone=table.getColumns();

                for(int ligne=0;ligne<list.size();ligne++){
                    for(int col=0;col<colone.size();col++){
                        TableColumn colvar=colone.get(col);
                        String cellvalue=colvar.getCellData(list.get(ligne)).toString();
                        cellvalue=cellvalue.toLowerCase();
                        if(cellvalue.contains(searchgolbale.getText().toLowerCase() )&& cellvalue.startsWith(searchgolbale.getText().toLowerCase())){
                            items.add(list.get(ligne));
                            break;
                        }
                    }
                }
                table.setItems(items);
            }
        });
    }







    @FXML
    Button ajouterclient;
    @FXML
    Button ajouterfournisseur;
    @FXML
    Button ajoutermed;
    @FXML
    Button addpara;

    public void newclient(ActionEvent event) throws IOException {

        FXMLLoader loader=new FXMLLoader(getClass().getResource("/sample/addclient.fxml"));
        Parent root= loader.load();

        Addclient addclient=loader.getController();
        addclient.showinformation(listclient);
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setTitle("Ajouter un client");

        stage.show();
    }

    public void newmedcin() throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/sample/addmedcin.fxml"));
        Parent root= loader.load();

        addmedcin addmedcin=loader.getController();
        addmedcin.showinformation(listmedcin);
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setTitle("Ajouter un M??dcin");

        stage.show();
    }
    public void newfournisseur(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/sample/addfournisseur.fxml"));
        Parent root= loader.load();

        addfournisseur addfournisseur=loader.getController();
        addfournisseur.showinformation(listfournisseur);
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setTitle("Ajouter un fournisseur");

        stage.show();
    }
    public void newmed(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/sample/addmed.fxml"));
        Parent root= loader.load();

        Addmed addmed=loader.getController();
        addmed.showinformation(listmedint,listmedext);
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setTitle("Ajouter un Medicament");

        stage.show();
    }
    public void newpara(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/sample/addpara.fxml"));
        Parent root= loader.load();

        Addpara addpara=loader.getController();
        addpara.showinformation(listpara);
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setTitle("Ajouter un Produit parapharmacetique");

        stage.show();
    }
    int index=-1;

    public void infomedcin() throws IOException {

        index=tablemedcin.getSelectionModel().getSelectedIndex();

        FXMLLoader loader=new FXMLLoader(getClass().getResource("/sample/informationmedcin.fxml"));
        Parent root= loader.load();

        informationmedcin info=loader.getController();
        info.showinformation(listmedcin,index,tablemedcin.getItems().get(index));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setTitle("information medcin");


        stage.show();


    }
    public void infoclient() throws IOException {

        index=tableclient.getSelectionModel().getSelectedIndex();

        FXMLLoader loader=new FXMLLoader(getClass().getResource("/sample/information.fxml"));
        Parent root= loader.load();

        information info=loader.getController();
        info.showinformation(index,idclient.getCellData(index),nomclient.getCellData(index),prenomclient.getCellData(index),nsclient.getCellData(index),mcclient.getCellData(index),listclient,age.getCellData(index));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setTitle("information client");


        stage.show();


    }

    public void infofournisseur() throws IOException {

        index=tablefournisseur.getSelectionModel().getSelectedIndex();
        if(index>-1){
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/sample/infofournisseur.fxml"));
        Parent root= loader.load();

        infofournisseur infofournisseur=loader.getController();
        infofournisseur.showinformation(index,idfournisseur.getCellData(index),nomfournisseur.getCellData(index),tlffournisseur.getCellData(index),listfournisseur);
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setTitle("information fournisseur");


        stage.show();}
        else return;


    }

    public void infomedinterne() throws IOException {
        index=tablemedint.getSelectionModel().getSelectedIndex();
        if(index>-1){
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/sample/infomedinterne.fxml"));
            Parent root= loader.load();
            Infomedinterne infomedinterne=loader.getController();
            M??dicamentProduitEnInterne pr= listmedint.get(index);
            infomedinterne.showinformation(idmedint.getCellData(index),index,listmedint,pr);
           //infomedinterne.showinformation(idmedint.getCellData(index),listmedint,index,nommedint.getCellData(index),qteminint.getCellData(index).toString(),prixmedint.getCellData(index).toString(),ordint.getCellData(index),modepriseint.getCellData(index).toString(),typemedint.getCellData(index).toString(),Qteint.getCellData(index).toString());
            Scene scene=new Scene(root);
            Stage stage=new Stage();
            stage.setScene(scene);
            stage.setTitle("information M??dicament interne");


            stage.show();}
        else return;

    }


    @FXML
    Button menubtncaisse;
    @FXML
    Button menubtnproduit;
    @FXML
    Button menubtnclient;
    @FXML
    Button menubtnstock;
    @FXML
    Button menubtnfournisseur;


    @FXML
    AnchorPane menucaisse;
    @FXML
    AnchorPane menuproduit;
    @FXML
    AnchorPane menuclient;
    @FXML
    AnchorPane menustock;
    @FXML
    AnchorPane menufournisseur;

    public void btnproduit(){
        menuproduit.setVisible(true);
        menucaisse.setVisible(false);
        menuclient.setVisible(false);
        menustock.setVisible(false);
        menufournisseur.setVisible(false);

        impmedext impext=new impmedext();
        try {
            listmedext=impext.listmedext();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        tablemedext.setItems(listmedext);
        impmedint impint=new impmedint();
        try {
            listmedint=impint.listmedint();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        tablemedint.setItems(listmedint);
        impproduitpharmacetique imppara=new impproduitpharmacetique();
        try {
            listpara=imppara.listprduitparapharmacetique();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        tablepara.setItems(listpara);

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
    TextField searchpara;
    ObservableList<ProduitParapharmacetique> listpara;
    public void searchpara(){
        searchglobale(searchpara,listpara, tablepara);
    }


    @FXML
    TableView<M??dicamentProduitEnExterne> tablemedext;
    @FXML
    TableColumn<M??dicamentProduitEnExterne,Integer> idmedext;
    @FXML
    TableColumn<M??dicamentProduitEnExterne,String> nommedext;
    @FXML
    TableColumn<M??dicamentProduitEnExterne,Enum> typemedext;
    @FXML
    TableColumn<M??dicamentProduitEnExterne,Enum> modepriseext;
    @FXML
    TableColumn<M??dicamentProduitEnExterne,Boolean> ordext;
    @FXML
    TableColumn<M??dicamentProduitEnExterne,Integer> prixmedext;
    @FXML
    TableColumn<M??dicamentProduitEnExterne,String> nomfirme;
    @FXML
    TableColumn<M??dicamentProduitEnExterne,Integer> Qteext;
    @FXML
    TableColumn<M??dicamentProduitEnExterne,Integer> qteminext;

    ObservableList<M??dicamentProduitEnExterne> listmedext;


    @FXML
    TableView<M??dicamentProduitEnInterne> tablemedint;
    @FXML
    TableColumn<M??dicamentProduitEnInterne,Integer> idmedint;
    @FXML
    TableColumn<M??dicamentProduitEnInterne,String> nommedint;
    @FXML
    TableColumn<M??dicamentProduitEnInterne,Enum> typemedint;
    @FXML
    TableColumn<M??dicamentProduitEnInterne,Enum> modepriseint;
    @FXML
    TableColumn<M??dicamentProduitEnInterne,Boolean> ordint;
    @FXML
    TableColumn<M??dicamentProduitEnInterne,Integer> prixmedint;

    @FXML
    TableColumn<M??dicamentProduitEnInterne,Integer> Qteint;
    @FXML
    TableColumn<M??dicamentProduitEnInterne,Integer> qteminint;


    ObservableList<M??dicamentProduitEnInterne> listmedint;

    @FXML
    TextField searchmedext;
    public void searchmedext(){

        searchglobale(searchmedext,listmedext, tablemedext);
    }
    @FXML
    TextField searchmedint;
    public void searchmedint(){

        searchglobale(searchmedint,listmedint, tablemedint);
    }

    @FXML
    RadioButton jfxclient;
    @FXML
    RadioButton jfxmedcin;
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

    public void btncaisse(){
        menuproduit.setVisible(false);
        menucaisse.setVisible(true);
        menuclient.setVisible(false);
        menustock.setVisible(false);
        menufournisseur.setVisible(false);

    }
    @FXML
    Button caisseclientbtn;
    @FXML
    Button caissecommandebtn;
    @FXML
    Button caisseprodbtn;

    @FXML
    Label idclientlabel;

    public void caissemedcin() throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/sample/caissemedcin.fxml"));
        Parent root= loader.load();

        caissemedcin caissemedcin= new caissemedcin();
        caissemedcin.showinformation(idmedcinlabel);
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setTitle("Affecter un medcin a une commande");
        stage.show();

    }

    public void caisseclient() throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/sample/caisseclient.fxml"));
        Parent root= loader.load();

        caisseclient caisseclient=new caisseclient();
        caisseclient.showinformation(idclientlabel);
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setTitle("Affecter un client a une commande");
        stage.show();
    }
    public void caissecommande() throws IOException {

        FXMLLoader loader=new FXMLLoader(getClass().getResource("/sample/caissecomande.fxml"));
        Parent root= loader.load();

        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setTitle("Listes des commandes");
        stage.show();

    }

    @FXML
    TableView<M??dicamentPr??scrit> tableachat;
    @FXML
    TableColumn<M??dicamentPr??scrit,Integer> idproda;
    @FXML
    TableColumn<M??dicamentPr??scrit,String> nomproda;
    @FXML
    TableColumn<M??dicamentPr??scrit,Integer> qtea;
    @FXML
    TableColumn<M??dicamentPr??scrit,Integer> prixa;
    @FXML
    TableColumn<M??dicamentPr??scrit,LocalDate> dureea;
    ObservableList<M??dicamentPr??scrit> listeachat;

    @FXML
    TableView<M??dicamentPr??scrit> tablecommande;
    @FXML
    TableColumn<M??dicamentPr??scrit,Integer> idprodc;
    @FXML
    TableColumn<M??dicamentPr??scrit,String> nomprodc;
    @FXML
    TableColumn<M??dicamentPr??scrit,Integer> qtec;
    @FXML
    TableColumn<M??dicamentPr??scrit,Integer> prixc;
    @FXML
    TableColumn<M??dicamentPr??scrit,LocalDate> dureec;

    ObservableList<M??dicamentPr??scrit> listecommande;


    @FXML
    Label prixachat;
    @FXML
    Label prixcommande;
    @FXML
    Label prixachatsansremise;

    @FXML
    JFXToggleButton ORD;
    @FXML
    Button caissemdecinbtn;
    @FXML
    Label idmedcinlabel;
    @FXML
    Label bb;
    @FXML
    Label mm;
    public void ord(){
        if(ORD.isSelected()){
            caissemdecinbtn.setVisible(true);
            idmedcinlabel.setVisible(true);
            bb.setVisible(true);
            mm.setVisible(true);
        }
        else{
            caissemdecinbtn.setVisible(false);
            idmedcinlabel.setVisible(false);
            bb.setVisible(false);
            mm.setVisible(false);
        }

    }


    public void caisseprod() throws IOException {

        FXMLLoader loader=new FXMLLoader(getClass().getResource("/sample/caisse.fxml"));
        Parent root= loader.load();
        caisseprod caisseprod=loader.getController();
        caisseprod.showinformation(listeachat,listecommande,prixachat,prixcommande,prixachatsansremise,ORD.isSelected());
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setTitle("Ajouter des Produit");
        stage.show();

    }

    public void anullerachat(){
        listeachat.clear();
        prixachatsansremise.setText("00");
        prixachat.setText("00");
        idclientlabel.setText("ID");
    }
    public void anullercommande(){
        listecommande.clear();
        prixcommande.setText("00");
    }

    public void validerachat() throws SQLException {
        impclient impclient=new impclient();
        int idachat;
        try{

            impclient.ajouterachat(Integer.valueOf(idclientlabel.getText()), (int) (Double.parseDouble(prixachat.getText())));
             idachat = impclient.id();
        }catch (Exception e){
            impclient.ajouterachat(-1, (int) (Double.parseDouble(prixachat.getText())));
            idachat = impclient.id();
            outils.showconfirmationmessage("confirmation","aucun client");

        }

            impachat impachat = new impachat();
            impprod impprod = new impprod();


            for (int i = 0; i < listeachat.size(); i++) {

                impachat.ajoutermedprescrit(idachat, idproda.getCellData(i), qtea.getCellData(i), dureea.getCellData(i), nomproda.getCellData(i));
                impprod.updateget(idproda.getCellData(i), qtea.getCellData(i) * -1);
            }

        listeachat.clear();
        prixachatsansremise.setText("00");
        prixachat.setText("00");
        idclientlabel.setText("ID");
        idmedcinlabel.setText("");


    }
    public void passercommande() throws SQLException {
        try {
            impclient impclient = new impclient();
            impclient.ajoutercommande(Integer.valueOf(idclientlabel.getText()), (int) (Double.parseDouble(prixcommande.getText())));
            int idcommande = impclient.id();
            impcommande impcommande = new impcommande();

            for (int i = 0; i < listecommande.size(); i++) {
                impcommande.ajoutermedprescrit(idcommande, idprodc.getCellData(i), qtec.getCellData(i), dureec.getCellData(i), nomprodc.getCellData(i));
            }
            listecommande.clear();
            prixcommande.setText("00");
            idmedcinlabel.setText("");
        }catch (Exception e){
            outils.showerroronmessage("error","aucun client");
            listecommande.clear();
            prixcommande.setText("00");
            idmedcinlabel.setText("");
        }
    }




    public void btnclient(){

        menuproduit.setVisible(false);
        menucaisse.setVisible(false);
        menuclient.setVisible(true);
        menustock.setVisible(false);
        menufournisseur.setVisible(false);



    }


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
    @FXML
    TableColumn<Client,Integer> age;

    ObservableList<Client> listclient;



    @FXML
    TableView<M??dcinConvetionn??> tablemedcin;
    @FXML
    TableColumn<M??dcinConvetionn??,Integer> idmedcin;
    @FXML
    TableColumn<M??dcinConvetionn??,String> nommedcin;
    @FXML
    TableColumn<M??dcinConvetionn??,String> prenommedcin;
    @FXML
    TableColumn<M??dcinConvetionn??,Integer> agemedcin;
    @FXML
    TableColumn<M??dcinConvetionn??,String> adresse;
    @FXML
    TableColumn<M??dcinConvetionn??,String> specialite;

    ObservableList<M??dcinConvetionn??> listmedcin;
    @FXML
    TextField searchmc;
    public void searchmc(){

        searchglobale(searchmc,listmedcin, tablemedcin);
    }

    @FXML
    TextField search;
    public void searchclient(){

        searchglobale(search,listclient, tableclient);
    }
    public void btnfournisseur(){
        menuproduit.setVisible(false);
        menucaisse.setVisible(false);
        menuclient.setVisible(false);
        menustock.setVisible(false);
        menufournisseur.setVisible(true);


    }

    @FXML
    TableView<Fournisseur> tablefournisseur;
    @FXML
    TableColumn<Fournisseur,Integer> idfournisseur;
    @FXML
    TableColumn<Fournisseur,String> tlffournisseur;
    @FXML
    TableColumn<Fournisseur,String> nomfournisseur;

    ObservableList<Fournisseur> listfournisseur;

    @FXML
    Button logout;

    public void logout(){
        Stage stage=(Stage) logout.getScene().getWindow();
        stage.close();
    }


    @FXML
    TextField searchfournisseur;

    public void searchfournisseur(){

        searchglobale(searchfournisseur,listfournisseur, tablefournisseur);
    }
    public void btnstock(){
        menuproduit.setVisible(false);
        menucaisse.setVisible(false);
        menuclient.setVisible(false);
        menustock.setVisible(true);
        menufournisseur.setVisible(false);

    }

    @FXML
    JFXRadioButton intstock;
    @FXML
    JFXRadioButton extstock;

    @FXML
    AnchorPane medicamentextenstock;
    @FXML
    AnchorPane medicamentintenstock;

        public void intstock(){
            intstock.setSelected(true);
            intstock.requestFocus();
            extstock.setSelected(false);
            medicamentintenstock.setVisible(true);
            medicamentextenstock.setVisible(false);


            impmedinstock impintstock=new impmedinstock();
            try {
                listmedintstock=impintstock.listmedintstock();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            tablemedintstock.setItems(listmedintstock);
        }

    public void extstock(){
        intstock.setSelected(false);
        intstock.requestFocus();
        extstock.setSelected(true);
        medicamentintenstock.setVisible(false);
        medicamentextenstock.setVisible(true);


        impmedextstock impextstock=new impmedextstock();
        try {
            listmedextstock=impextstock.listmedextstock();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        tablemedextstock.setItems(listmedextstock);
    }

    @FXML
    TableView<M??dicamentProduitEnExterneEnStock> tablemedextstock;
    @FXML
    TableColumn<M??dicamentProduitEnExterneEnStock,Integer> idmedextstock;
    @FXML
    TableColumn<M??dicamentProduitEnExterneEnStock,String> nommedextstock;
    @FXML
    TableColumn<M??dicamentProduitEnExterneEnStock,Integer> qteextstock;
    @FXML
    TableColumn<M??dicamentProduitEnExterneEnStock,Integer> numlotext;
    @FXML
    TableColumn<M??dicamentProduitEnExterneEnStock, Date> dateext;



    ObservableList<M??dicamentProduitEnExterneEnStock> listmedextstock;
    @FXML
    TextField searchextstock;

    public void searchextstock(){
        searchglobale(searchextstock,listmedextstock,tablemedextstock);
    }


    @FXML
    TableView<M??dicamentProduitEnInterneEnStock> tablemedintstock;
    @FXML
    TableColumn<M??dicamentProduitEnInterneEnStock,Integer> idmedintstock;
    @FXML
    TableColumn<M??dicamentProduitEnInterneEnStock,String> nommedintstock;
    @FXML
    TableColumn<M??dicamentProduitEnInterneEnStock,Integer> qteintstock;
    @FXML
    TableColumn<M??dicamentProduitEnInterneEnStock,Integer> numlotint;
    @FXML
    TableColumn<M??dicamentProduitEnInterneEnStock, Date> dateint;



    ObservableList<M??dicamentProduitEnInterneEnStock> listmedintstock;
    @FXML
    TextField searchintstock;

    public void searchintstock(){
        searchglobale(searchintstock,listmedintstock,tablemedintstock);
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        idpara.setCellValueFactory(new PropertyValueFactory<ProduitParapharmacetique,Integer>("idprod"));
        nompara.setCellValueFactory(new PropertyValueFactory<ProduitParapharmacetique,String>("nomprod"));
        typepara.setCellValueFactory(new PropertyValueFactory<ProduitParapharmacetique,Enum>("typeProd"));
        prixpara.setCellValueFactory(new PropertyValueFactory<ProduitParapharmacetique,Integer>("prix"));

        impproduitpharmacetique imppara=new impproduitpharmacetique();
        try {
            listpara=imppara.listprduitparapharmacetique();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        tablepara.setItems(listpara);


        idmedext.setCellValueFactory(new PropertyValueFactory<M??dicamentProduitEnExterne,Integer>("idprod"));
        nommedext.setCellValueFactory(new PropertyValueFactory<M??dicamentProduitEnExterne,String>("nomprod"));
        typemedext.setCellValueFactory(new PropertyValueFactory<M??dicamentProduitEnExterne,Enum>("typeMed"));
        modepriseext.setCellValueFactory(new PropertyValueFactory<M??dicamentProduitEnExterne,Enum>("modePriseMed"));
        ordext.setCellValueFactory(new PropertyValueFactory<M??dicamentProduitEnExterne,Boolean>("ordRequise"));
        prixmedext.setCellValueFactory(new PropertyValueFactory<M??dicamentProduitEnExterne,Integer>("prix"));
        Qteext.setCellValueFactory(new PropertyValueFactory<M??dicamentProduitEnExterne,Integer>("qte"));
        qteminext.setCellValueFactory(new PropertyValueFactory<M??dicamentProduitEnExterne,Integer>("qtemin"));
        nomfirme.setCellValueFactory(new PropertyValueFactory<M??dicamentProduitEnExterne,String>("nomFirme"));

        impmedext impext=new impmedext();
        try {
            listmedext=impext.listmedext();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        tablemedext.setItems(listmedext);


        idmedint.setCellValueFactory(new PropertyValueFactory<M??dicamentProduitEnInterne,Integer>("idprod"));
        nommedint.setCellValueFactory(new PropertyValueFactory<M??dicamentProduitEnInterne,String>("nomprod"));
        typemedint.setCellValueFactory(new PropertyValueFactory<M??dicamentProduitEnInterne,Enum>("typeMed"));
        modepriseint.setCellValueFactory(new PropertyValueFactory<M??dicamentProduitEnInterne,Enum>("modePriseMed"));
        ordint.setCellValueFactory(new PropertyValueFactory<M??dicamentProduitEnInterne,Boolean>("ordRequise"));
        prixmedint.setCellValueFactory(new PropertyValueFactory<M??dicamentProduitEnInterne,Integer>("prix"));
        Qteint.setCellValueFactory(new PropertyValueFactory<M??dicamentProduitEnInterne,Integer>("qte"));
        qteminint.setCellValueFactory(new PropertyValueFactory<M??dicamentProduitEnInterne,Integer>("qtemin"));

        impmedint impint=new impmedint();
        try {
            listmedint=impint.listmedint();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        tablemedint.setItems(listmedint);

            idclient.setCellValueFactory(new PropertyValueFactory<Client, Integer>("idclient"));
            nomclient.setCellValueFactory(new PropertyValueFactory<Client, String>("nom"));
            prenomclient.setCellValueFactory(new PropertyValueFactory<Client, String>("prenom"));
            nsclient.setCellValueFactory(new PropertyValueFactory<Client, String>("numsocial"));
            mcclient.setCellValueFactory(new PropertyValueFactory<Client, Boolean>("maladiechronique"));
            age.setCellValueFactory(new PropertyValueFactory<Client, Integer>("age"));

            impclient impc = new impclient();
            try {
                listclient = impc.listclient();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            tableclient.setItems(listclient);



        idmedcin.setCellValueFactory(new PropertyValueFactory<M??dcinConvetionn??, Integer>("idMed"));
        nommedcin.setCellValueFactory(new PropertyValueFactory<M??dcinConvetionn??, String>("nom"));
        prenommedcin.setCellValueFactory(new PropertyValueFactory<M??dcinConvetionn??, String>("prenom"));
        agemedcin.setCellValueFactory(new PropertyValueFactory<M??dcinConvetionn??, Integer>("age"));
        adresse.setCellValueFactory(new PropertyValueFactory<M??dcinConvetionn??, String>("adresse"));
        specialite.setCellValueFactory(new PropertyValueFactory<M??dcinConvetionn??, String>("specialite"));

        impmedcin impmedcin=new impmedcin();
        try {
            listmedcin = impmedcin.listmedcin();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        tablemedcin.setItems(listmedcin);

        





        idfournisseur.setCellValueFactory(new PropertyValueFactory<Fournisseur,Integer>("idfournisseur"));
        tlffournisseur.setCellValueFactory(new PropertyValueFactory<Fournisseur,String>("numt??l"));
        nomfournisseur.setCellValueFactory(new PropertyValueFactory<Fournisseur,String>("name"));


        impfournisseur impf=new impfournisseur();
        try {
            listfournisseur=impf.listefournisseur();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        tablefournisseur.setItems(listfournisseur);


        idmedextstock.setCellValueFactory(new PropertyValueFactory<M??dicamentProduitEnExterneEnStock,Integer>("idprod"));
        nommedextstock.setCellValueFactory(new PropertyValueFactory<M??dicamentProduitEnExterneEnStock,String>("nomprod"));
        qteextstock.setCellValueFactory(new PropertyValueFactory<M??dicamentProduitEnExterneEnStock,Integer>("qte"));
        numlotext.setCellValueFactory(new PropertyValueFactory<M??dicamentProduitEnExterneEnStock,Integer>("numlot"));
        dateext.setCellValueFactory(new PropertyValueFactory<M??dicamentProduitEnExterneEnStock,Date>("dateExp"));

        impmedextstock impextstock=new impmedextstock();
        try {
            listmedextstock=impextstock.listmedextstock();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        tablemedextstock.setItems(listmedextstock);



        idmedintstock.setCellValueFactory(new PropertyValueFactory<M??dicamentProduitEnInterneEnStock,Integer>("idprod"));
        nommedintstock.setCellValueFactory(new PropertyValueFactory<M??dicamentProduitEnInterneEnStock,String>("nomprod"));
        qteintstock.setCellValueFactory(new PropertyValueFactory<M??dicamentProduitEnInterneEnStock,Integer>("qte"));
        numlotint.setCellValueFactory(new PropertyValueFactory<M??dicamentProduitEnInterneEnStock,Integer>("numlot"));
        dateint.setCellValueFactory(new PropertyValueFactory<M??dicamentProduitEnInterneEnStock,Date>("dateExp"));

        impmedinstock impintstock=new impmedinstock();
        try {
            listmedintstock=impintstock.listmedintstock();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        tablemedintstock.setItems(listmedintstock);


        idproda.setCellValueFactory(new PropertyValueFactory<M??dicamentPr??scrit,Integer>("id"));
        nomproda.setCellValueFactory(new PropertyValueFactory<M??dicamentPr??scrit,String>("nomMed"));
        qtea.setCellValueFactory(new PropertyValueFactory<M??dicamentPr??scrit,Integer>("qte"));
        prixa.setCellValueFactory(new PropertyValueFactory<M??dicamentPr??scrit,Integer>("prix"));
        dureea.setCellValueFactory(new PropertyValueFactory<M??dicamentPr??scrit, LocalDate>("duree"));

        impcommande impcommande=new impcommande();
        try {
            listeachat=impcommande.listemedprescritachat(0);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        tableachat.setItems(listeachat);

        idprodc.setCellValueFactory(new PropertyValueFactory<M??dicamentPr??scrit,Integer>("id"));
        nomprodc.setCellValueFactory(new PropertyValueFactory<M??dicamentPr??scrit,String>("nomMed"));
        qtec.setCellValueFactory(new PropertyValueFactory<M??dicamentPr??scrit,Integer>("qte"));
        prixc.setCellValueFactory(new PropertyValueFactory<M??dicamentPr??scrit,Integer>("prix"));
        dureec.setCellValueFactory(new PropertyValueFactory<M??dicamentPr??scrit,LocalDate>("duree"));


        try {
            listecommande=impcommande.listemedprescritcoomande(0);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        tablecommande.setItems(listecommande);






    }



}
