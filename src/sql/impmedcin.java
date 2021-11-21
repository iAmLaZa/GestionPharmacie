package sql;

import classes.Commande;
import classes.MédcinConvetionné;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class impmedcin implements imedcin {
    private static Connection con = BD.connect();
    @Override
    public boolean ajoutermedcin(String nom, String prenom, int age,String adresse,String specialite) throws SQLException {
        try {
            PreparedStatement ps = con.prepareStatement("insert into personne(nom,prenom,age) values('" + nom + "','" + prenom + "',"+age+")");
            ps.execute();
            ps = con.prepareStatement("insert into medcin values (last_insert_id()+'"+adresse+"','"+specialite+"' )");
            return ps.execute();


        } catch (Exception e) {
            try {

            } catch (Exception ex) {

            }

        }

        return true;
    }

    @Override
    public boolean updatemedcin(int id, String nom, String prenom, int age,String adresse,String specialite) {
        try {
            PreparedStatement ps = con.prepareStatement("update personne set nom='"+nom+"',prenom='"+prenom+"',age="+age+" where idpersonne="+id);
            ps.execute();
            ps = con.prepareStatement("update medcin set adresse='"+adresse+"',specialite="+specialite+" where idmedcin="+id);
            return !ps.execute();



        } catch (SQLException e) {

            System.out.println(e.getSQLState());
        }
        finally {
            try {

            } catch (Exception ex) {

            }
        }
        return false;
    }

    @Override
    public ObservableList<Commande> listecomandes(int id) throws SQLException {
        ObservableList<Commande> list= FXCollections.observableArrayList();
        PreparedStatement ps=con.prepareStatement("select idcommande,prix from commande where idclient="+id);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            list.add(new Commande(rs.getInt("idcommande"),rs.getInt("prix")));
        }
        return list;
    }

    @Override
    public ObservableList<Commande> listeachats(int id) throws SQLException {
        ObservableList<Commande> list= FXCollections.observableArrayList();
        PreparedStatement ps=con.prepareStatement("select idachat,prix from achat where idclient="+id);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            list.add(new Commande(rs.getInt("idachat"),rs.getInt("prix")));
        }
        return list;
    }

    @Override
    public boolean ajoutercommande(int id, int prix) {
        try {
            PreparedStatement ps = con.prepareStatement("insert into commande(prix,idclient) values ("+prix+","+id+")");

            return ps.execute();


        } catch (Exception e) {


        }
        finally {
            try {

            } catch (Exception ex) {

            }
        }

        return true;
    }

    @Override
    public boolean ajouterachat(int id, int prix) {
        try {
            PreparedStatement ps = con.prepareStatement("insert into achat(prix,idclient) values ("+prix+","+id+")");

            return ps.execute();


        } catch (Exception e) {


        }
        finally {
            try {

            } catch (Exception ex) {

            }
        }

        return true;
    }

    @Override
    public ObservableList<MédcinConvetionné> listmedcin() throws SQLException {
        ObservableList<MédcinConvetionné> list= FXCollections.observableArrayList();
        PreparedStatement ps=con.prepareStatement("select * from personne INNER JOIN medcin ON personne.idpersonne = medcin.idmedcin");
        ResultSet rs=ps.executeQuery();
        while(rs.next()){

            list.add(new MédcinConvetionné(rs.getString("nom"),rs.getString("prenom"),rs.getInt("age"),rs.getInt("idmedcin"),rs.getString("adresse"),rs.getString("specialite")));

        }

        return list;
    }

    @Override
    public int getidmedcin() throws SQLException {
        PreparedStatement ps=con.prepareStatement("select last_insert_id()");
        ResultSet rs=ps.executeQuery();
        if(rs.next()){return rs.getInt(1);
        }
        else return 0;
    }
}
