package sql;

import classes.Commande;
import classes.MédcinConvetionné;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface imedcin {
    public boolean ajoutermedcin(String nom,String prenom,int age,String adresse,String specialite) throws SQLException;
    public boolean updatemedcin(int id,String nom, String prenom,int age,String adresse,String specialite);
    public ObservableList<Commande> listecomandes(int id) throws SQLException;
    public ObservableList<Commande> listeachats(int id) throws SQLException;
    public boolean ajoutercommande(int id,int prix);
    public boolean ajouterachat(int id,int prix);
    public ObservableList<MédcinConvetionné> listmedcin() throws SQLException;
    public int getidmedcin() throws SQLException;
}
