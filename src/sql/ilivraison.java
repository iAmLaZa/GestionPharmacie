package sql;


import classes.medlivraison;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface ilivraison {
    public boolean ajouterlivraison(int idfournisseur);
    public ObservableList<medlivraison> listemedlivraison(int id) throws SQLException;
    public boolean ajouterproduit(int id,int med,int qte);

    public int getid() throws SQLException;
}
