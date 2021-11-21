package sql;

import classes.MédicamentProduitEnInterne;
import classes.matiéredossage;
import classes.modePrise;
import classes.typeMed;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class impmedint implements imedint {
    private static Connection con = BD.connect();
    @Override
    public boolean ajoutermedint() {
        try {

            PreparedStatement ps = con.prepareStatement("insert into medinterne values (last_insert_id())");
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
    public ObservableList<MédicamentProduitEnInterne> listmedint() throws SQLException {
        ObservableList<MédicamentProduitEnInterne> list = FXCollections.observableArrayList();
        PreparedStatement ps = con.prepareStatement("select *from medicament inner join produit on idmed=idprod " +
                "inner join medinterne on idmed=idmedinterne");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {

            list.add(new MédicamentProduitEnInterne(rs.getInt("idprod"), rs.getInt("prix"), rs.getInt("Qte"),rs.getString("nom"),
                    typeMed.valueOf(rs.getString("typemed")), modePrise.valueOf(rs.getString("modeprise")),rs.getBoolean("ordrequise"), rs.getInt("qtemin"),rs.getDouble("remise")));

        }

        return list;
    }

    @Override
    public ObservableList<matiéredossage> listmatieredossage(int idmedinterne) throws SQLException {
        ObservableList<matiéredossage> list= FXCollections.observableArrayList();
        PreparedStatement ps=con.prepareStatement("select *from matiere inner join matieredossage on matiere.idmatiere=matieredossage.idmatiere where idmedinterne="+idmedinterne);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            list.add(new matiéredossage(rs.getString("nom"),rs.getInt("idmatiere"),rs.getInt("dossage")));
        }
        return list;
    }

    @Override
    public boolean ajoutermatieredossage(int idmedinterne, int idmatiere, int dossage) {

        try {
            PreparedStatement ps = con.prepareStatement("insert into matieredossage values ("+idmatiere+","+idmedinterne+","+dossage+")");

            return ps.execute();


        } catch (Exception e) {
            System.out.println(e);

        }
        finally {
            try {

            } catch (Exception ex) {

            }
        }

        return true;
    }
}
