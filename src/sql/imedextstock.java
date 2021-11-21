package sql;


import classes.MédicamentProduitEnExterneEnStock;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.time.LocalDate;

public interface imedextstock {

    public boolean ajoutermedextstock(int numlot, LocalDate dateexp);
    public ObservableList<MédicamentProduitEnExterneEnStock> listmedextstock() throws SQLException;
    public LocalDate getdateexp(int id) throws SQLException;
}
