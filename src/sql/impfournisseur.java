package sql;

import classes.Fournisseur;
import classes.Livraison;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class impfournisseur implements Ifournisseur {
    private static Connection con = BD.connect();
    @Override
    public boolean ajouterfournisseur(String numtlf,String name) throws SQLException {
        try {
            PreparedStatement ps = con.prepareStatement("insert  into fournisseur(numtel,nom) values ('" + numtlf +"','"+name+ "')");
            return ps.execute();


        } catch (Exception e) {
            try {

            } catch (Exception ex) {

            }

        }

        return true;
    }

    @Override
    public boolean update(int id, String numtlf,String name) {
        try {
            PreparedStatement ps = con.prepareStatement("update fournisseur set numtel='"+numtlf+"',nom='"+name+"' where idfournisseur="+id);
            return !ps.execute();


        } catch (Exception e) {

            System.out.println(12);
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
            PreparedStatement ps = con.prepareStatement("delete from fournisseur where idfournisseur="+id);
            ps.execute();
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
    public ObservableList<Livraison> listelivraison(int id) throws SQLException {
        ObservableList<Livraison> list= FXCollections.observableArrayList();
        PreparedStatement ps=con.prepareStatement("select idlivraison from livraison where idfournisseur="+id);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            list.add(new Livraison(rs.getInt("idlivraison")));
        }
        return list;
    }

    @Override
    public ObservableList<Fournisseur> listefournisseur() throws SQLException {
        ObservableList<Fournisseur> list= FXCollections.observableArrayList();
        PreparedStatement ps=con.prepareStatement("select * from fournisseur ");
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            list.add(new Fournisseur(rs.getInt("idfournisseur"),rs.getString("numtel"),rs.getString("nom")));
        }
        return list;
    }

    @Override
    public int getid(String num) throws SQLException {
        PreparedStatement ps=con.prepareStatement("select idfournisseur from fournisseur where numtel="+num);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){return rs.getInt("idfournisseur");
        }
        else return 0;
    }

}
