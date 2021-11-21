package sql;


import classes.MédicamentProduitEnInterneEnStock;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.time.LocalDate;

public interface imedintstock {

    public boolean ajoutermedintstock(int numlot, LocalDate dateexp);
    public ObservableList<MédicamentProduitEnInterneEnStock> listmedintstock() throws SQLException;
    public int getid() throws SQLException;
    public LocalDate getdateexp(int id) throws SQLException;
}
