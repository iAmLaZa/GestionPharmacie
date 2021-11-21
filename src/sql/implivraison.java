package sql;


import classes.medlivraison;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class implivraison implements ilivraison {
    private static Connection con = BD.connect();
    @Override
    public boolean ajouterlivraison(int idfournisseur) {
        try {
            PreparedStatement ps = con.prepareStatement("insert into livraison(idfournisseur) values(" +idfournisseur + ")");
            ps.execute();

        } catch (Exception e) {
            try {

            } catch (Exception ex) {

            }

        }

        return true;
    }

    @Override
    public ObservableList<medlivraison> listemedlivraison(int id) throws SQLException {
        ObservableList<medlivraison> list= FXCollections.observableArrayList();
        PreparedStatement ps=con.prepareStatement("select * from medlivraison INNER JOIN produit ON medlivraison.idmed = produit.idprod where idlivraison="+id);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            list.add(new medlivraison(rs.getInt("idmed"),rs.getInt("qte"),rs.getString("nom")));
        }
        return list;
    }

    @Override
    public boolean ajouterproduit(int id, int med, int qte) {

        try {
            PreparedStatement ps = con.prepareStatement("insert into medlivraison values(" + id + "," + med + "," + qte + ")");
            ps.execute();

        } catch (Exception e) {
            System.out.println(e);
            try {

            } catch (Exception ex) {

            }

        }


        return true;

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
