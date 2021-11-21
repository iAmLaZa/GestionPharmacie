package sql;

import classes.Matiére;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface imatiere {
    public boolean ajoutermatiere(String nom);
    public ObservableList<Matiére> listematiere() throws SQLException;
}
