package controller;


import classes.MédicamentProduitEnInterne;
import classes.matiéredossage;
import com.jfoenix.controls.JFXToggleButton;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sql.impmedint;
import sql.impprod;

import java.sql.SQLException;

public class Infomedinterne {

    int index;
    ObservableList<MédicamentProduitEnInterne> liste;
    MédicamentProduitEnInterne m;
    int id;
    public void showinformation(int i,int j,ObservableList<MédicamentProduitEnInterne> list,MédicamentProduitEnInterne med){
        index=j;
        liste=list;
        m=med;
        id=i;
    }



    @FXML
    TableView<matiéredossage> infomedinterne;
    @FXML
    TableColumn<matiéredossage, Integer> idmatiere;
    @FXML
    TableColumn<matiéredossage, String> nom;
    @FXML
    TableColumn<matiéredossage,Integer> dossage;

    ObservableList<matiéredossage> listematieredossage;

    @FXML
    JFXToggleButton show;

    public void showdetail(){
        if(show.isSelected()){
            infomedinterne.setVisible(true);
            idmatiere.setCellValueFactory(new PropertyValueFactory<matiéredossage, Integer>("idMatiére"));
            nom.setCellValueFactory(new PropertyValueFactory<matiéredossage, String>("nomMatiére"));
            dossage.setCellValueFactory(new PropertyValueFactory<matiéredossage, Integer>("dossage"));


            impmedint impmedint= new impmedint();
            try {
                listematieredossage = impmedint.listmatieredossage(id);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            infomedinterne.setItems(listematieredossage);}
        else infomedinterne.setVisible(false);

    }


    @FXML
    TextField qteadd;
    @FXML
    Button addqte;

    public void addqte() throws SQLException {
        impprod impprod=new impprod();

        impprod.updateget(id,Integer.valueOf(qteadd.getText()));
        int quantite=m.getQte()+Integer.valueOf(qteadd.getText());
        m.setQte(quantite);
        liste.set(index,m);

        qteadd.setVisible(false);
        addqte.setVisible(true);


    }
}
