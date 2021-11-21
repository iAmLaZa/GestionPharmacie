package sql;

import classes.Fournisseur;
import classes.Livraison;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface Ifournisseur {

    public boolean ajouterfournisseur(String numtlf,String name) throws SQLException;
    public boolean update(int  id,String numtlf,String name);
    public boolean delete(int id);
    public ObservableList<Livraison> listelivraison(int id) throws SQLException;
    public ObservableList<Fournisseur> listefournisseur() throws SQLException;
    public int getid(String num) throws SQLException;



}
