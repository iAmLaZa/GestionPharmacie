package sql;

import classes.Commande;
import classes.MédicamentPréscrit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class impcommande implements icommande {
    private static Connection con = BD.connect();
    @Override
    public ObservableList<MédicamentPréscrit> listemedprescritcoomande(int idcommande) throws SQLException {
        ObservableList<MédicamentPréscrit> list= FXCollections.observableArrayList();
        PreparedStatement ps=con.prepareStatement("select * from medicamentprescrit INNER JOIN produit on idmedprescrit=idprod where idcommande="+idcommande);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            list.add(new MédicamentPréscrit(rs.getInt("idmedprescrit"),rs.getString("nom"),rs.getInt("qte"),rs.getInt("prix"),rs.getDate("dure").toLocalDate()));
        }
        return list;
    }

    @Override
    public ObservableList<MédicamentPréscrit> listemedprescritachat(int idachat) throws SQLException {
        ObservableList<MédicamentPréscrit> list= FXCollections.observableArrayList();
        PreparedStatement ps=con.prepareStatement("select * from medicamentprescrit INNER JOIN produit on idmedprescrit=idprod where idachat="+idachat);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            list.add(new MédicamentPréscrit(rs.getInt("idmedprescrit"),rs.getString("nom"),rs.getInt("qte"),rs.getInt("prix"),rs.getDate("dure").toLocalDate()));
        }
        return list;
    }

    @Override
    public boolean ajoutermedprescrit(int idcommande, int idmedprescrit, int qte, LocalDate dure, String nom) {

        try {

           PreparedStatement ps = con.prepareStatement("insert into medicamentprescrit(idmedprescrit,idcommande,qte,dure,nom)values ("+idmedprescrit+","+idcommande+","+qte+",'"+dure+"','"+nom+"')");
            return ps.execute();


        } catch (Exception e) {
            try {

            } catch (Exception ex) {

            }

        }

        return true;
}


    @Override
    public ObservableList<Commande> listcommandeclient(int idclient) throws SQLException {
        ObservableList<Commande> list= FXCollections.observableArrayList();
        PreparedStatement ps=con.prepareStatement("select idcommande,prix from commande  where idclient="+idclient);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){

            list.add(new Commande(idclient,rs.getInt("idcommande"),rs.getInt("prix")));

        }

        return list;
    }

    @Override
    public ObservableList<Commande> listcommande() throws SQLException {
        ObservableList<Commande> list= FXCollections.observableArrayList();
        PreparedStatement ps=con.prepareStatement("select idclient,idcommande,prix from commande ");
        ResultSet rs=ps.executeQuery();
        while(rs.next()){

            list.add(new Commande(rs.getInt("idclient"),rs.getInt("idcommande"),rs.getInt("prix")));

        }

        return list;
    }
}
