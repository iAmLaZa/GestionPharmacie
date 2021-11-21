package sql;


import classes.ProduitParapharmacetique;
import classes.typeProd;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class impproduitpharmacetique implements Iproduitpharmacetique {
    private static Connection con = BD.connect();
    @Override
    public boolean ajouterproduitpharmacetique(int prix, int qte, String nomprod, String typeProd) throws SQLException {
        try {

            PreparedStatement ps = con.prepareStatement("insert into produit(nom,Qte,prix) values('" + nomprod + "'," + qte +","+prix+ ")");
            ps.execute();
            ps = con.prepareStatement("insert into produitparapharmacetique values (last_insert_id(),'" +typeProd  + "')");
            return ps.execute();


        } catch (Exception e) {

            System.out.println(e);
            try {

            } catch (Exception ex) {

            }

        }

        return true;
    }

    @Override
    public boolean update(int idprod, int prix, int qte, String nomprod, String typeProd) {
        try {
            PreparedStatement ps = con.prepareStatement("update produit set nom="+nomprod+",Qte="+qte+",prix="+prix+"where idprod="+idprod);
            ps.execute();
            ps = con.prepareStatement("update produitparapharmacetique set typeprod="+typeProd+"where idpara="+idprod);
            return !ps.execute();


        } catch (Exception e) {


        }
        finally {
            try {

            } catch (Exception ex) {

            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            PreparedStatement ps = con.prepareStatement("delete from produitparapharmacetique where idpara="+id);
            ps.execute();
            ps = con.prepareStatement("delete from produit where idprod="+id);
            return !ps.execute();


        } catch (Exception e) {


        }
        finally {
            try {

            } catch (Exception ex) {

            }
        }
        return false;
    }

    @Override
    public ObservableList<ProduitParapharmacetique> listprduitparapharmacetique() throws SQLException {
        ObservableList<ProduitParapharmacetique> list= FXCollections.observableArrayList();
        PreparedStatement ps=con.prepareStatement("select * from produit INNER JOIN produitparapharmacetique ON produit.idprod = produitparapharmacetique.idpara");
        ResultSet rs=ps.executeQuery();
        while(rs.next()){

            list.add(new ProduitParapharmacetique(rs.getInt("idprod"),rs.getInt("prix"),rs.getInt("Qte"),rs.getString("nom"), typeProd.valueOf(rs.getString("typeprod"))));
        }

        return list;
    }

    @Override
    public int getid() throws SQLException {
        PreparedStatement ps=con.prepareStatement("select last_insert_id()");
        ResultSet rs=ps.executeQuery();
        if(rs.next()){return rs.getInt(1);
        }
        else return 0;
    }
}
