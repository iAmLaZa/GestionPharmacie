package sql;


import classes.MĂ©dicamentProduitEnInterneEnStock;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.time.LocalDate;

public interface imedintstock {

    public boolean ajoutermedintstock(int numlot, LocalDate dateexp);
    public ObservableList<MĂ©dicamentProduitEnInterneEnStock> listmedintstock() throws SQLException;
    public int getid() throws SQLException;
    public LocalDate getdateexp(int id) throws SQLException;
}
