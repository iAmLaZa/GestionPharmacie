package sql;

import classes.Produit;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface iprod {
    public boolean updateget(int id, int qte) throws SQLException;
    ObservableList<Produit> listeprod() throws SQLException;
    public int getqtemin(int id) throws SQLException;
    public int getqte(int id) throws SQLException;
}
