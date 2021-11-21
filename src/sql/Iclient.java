package sql;

import classes.Client;
import classes.Commande;
import javafx.collections.ObservableList;

import java.sql.SQLException;


public interface Iclient {

    public boolean ajouterclient(String nom,String prenom,String numsocial,boolean maladiechronique,int age) throws SQLException;
    public boolean update(int id,String nom, String prenom, String numsocial, boolean maladiechronique,int age);
    public boolean delete(int id);
    public ObservableList<Commande> listecomandes(int id) throws SQLException;
    public ObservableList<Commande> listeachats(int id) throws SQLException;
    public boolean ajoutercommande(int id,double prix);
    public boolean ajouterachat(int id,double prix);
    public ObservableList<Client> listclient() throws SQLException;
    public int getid(String num) throws SQLException;
    public int id() throws SQLException;



}
