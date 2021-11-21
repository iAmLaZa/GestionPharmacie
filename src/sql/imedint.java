package sql;


import classes.MédicamentProduitEnInterne;
import classes.matiéredossage;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface imedint {
    public boolean ajoutermedint();
    public ObservableList<MédicamentProduitEnInterne> listmedint() throws SQLException;
    public ObservableList<matiéredossage> listmatieredossage(int idmedinterne) throws SQLException;
    public boolean ajoutermatieredossage(int idmedinterne ,int idmatiere,int dossage);
}
