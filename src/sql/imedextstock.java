package sql;


import classes.MĂ©dicamentProduitEnExterneEnStock;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.time.LocalDate;

public interface imedextstock {

    public boolean ajoutermedextstock(int numlot, LocalDate dateexp);
    public ObservableList<MĂ©dicamentProduitEnExterneEnStock> listmedextstock() throws SQLException;
    public LocalDate getdateexp(int id) throws SQLException;
}
