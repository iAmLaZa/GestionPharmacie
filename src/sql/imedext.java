package sql;


import classes.MĂ©dicamentProduitEnExterne;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface imedext {
    public boolean ajoutermedext(String nomfirme);
    public ObservableList<MĂ©dicamentProduitEnExterne> listmedext() throws SQLException;
}
