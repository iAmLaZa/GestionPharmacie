package sql;


import classes.ProduitParapharmacetique;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface Iproduitpharmacetique {
    public boolean ajouterproduitpharmacetique(int prix, int qte, String nomprod, String typeProd) throws SQLException;
    public boolean update(int idprod, int prix, int qte, String nomprod, String typeProd);
    public boolean delete(int id);
    public ObservableList<ProduitParapharmacetique> listprduitparapharmacetique() throws SQLException;
    public int getid() throws SQLException;

}
