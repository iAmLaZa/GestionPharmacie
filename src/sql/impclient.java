package sql;

import classes.Client;
import classes.Commande;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class impclient implements Iclient {
    private static Connection con = BD.connect();

    @Override
    public boolean ajouterclient(String nom, String prenom, String numsocial, boolean maladiechronique,int age) throws SQLException {



            try {
                PreparedStatement ps = con.prepareStatement("insert into personne(nom,prenom,age) values('" + nom + "','" + prenom + "',"+age+")");
                ps.execute();
                ps = con.prepareStatement("insert into client values (last_insert_id(),'" + numsocial + "'," + maladiechronique + ")");
                return ps.execute();


            } catch (Exception e) {
                try {

                } catch (Exception ex) {

                }

            }

        return true;
    }


    @Override
    public boolean update( int id,String nom, String prenom, String numsocial, boolean maladiechronique,int age) {

        try {
            PreparedStatement ps = con.prepareStatement("update personne set nom='"+nom+"',prenom='"+prenom+"',age="+age+" where idpersonne="+id);
            ps.execute();
            ps = con.prepareStatement("update client set numsocial='"+numsocial+"',maladiechronique="+maladiechronique+" where idclient="+id);
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
    public boolean delete(int id) {
        try {
            PreparedStatement ps = con.prepareStatement("delete from client where idclient="+id);
            ps.execute();
            ps = con.prepareStatement("delete from personne where idpersonne="+id);
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
    public boolean ajoutercommande(int id,double prix) {
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
    public boolean ajouterachat(int id, double prix) {
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
        public ObservableList<Client> listclient() throws SQLException {
            ObservableList<Client> list= FXCollections.observableArrayList();
            PreparedStatement ps=con.prepareStatement("select * from personne INNER JOIN client ON personne.idpersonne = client.idclient");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){

                list.add(new Client(rs.getString("nom"),rs.getString("prenom"),rs.getInt("idclient"),rs.getString("numsocial"),rs.getBoolean("maladiechronique"),rs.getInt("age")));

            }

            return list;
    }

    @Override
    public int getid(String num) throws SQLException {
        PreparedStatement ps=con.prepareStatement("select idclient from client where numsocial="+num);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){return rs.getInt("idclient");
        }
        else return 0;
    }
    @Override
    public int id() throws SQLException {
        PreparedStatement ps=con.prepareStatement("select last_insert_id()");
        ResultSet rs=ps.executeQuery();
        if(rs.next()){return rs.getInt(1);
        }
        else return 0;
    }

}
