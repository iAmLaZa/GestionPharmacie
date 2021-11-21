package sql;


import classes.MédicamentProduitEnExterne;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface imedext {
    public boolean ajoutermedext(String nomfirme);
    public ObservableList<MédicamentProduitEnExterne> listmedext() throws SQLException;
}
