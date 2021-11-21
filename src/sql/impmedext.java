package sql;

import classes.MédicamentProduitEnExterne;
import classes.modePrise;
import classes.typeMed;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class impmedext implements imedext {
    private static Connection con = BD.connect();
    @Override
    public boolean ajoutermedext(String nomfirme) {
        try {

            PreparedStatement ps = con.prepareStatement("insert into medexterne values (last_insert_id(),'" + nomfirme + "')");
            return ps.execute();


        } catch (Exception e) {
            try {

            } catch (Exception ex) {

            }

        }

        return true;
    }

    @Override
    public ObservableList<MédicamentProduitEnExterne> listmedext() throws SQLException {
        ObservableList<MédicamentProduitEnExterne> list = FXCollections.observableArrayList();
        PreparedStatement ps = con.prepareStatement("select *from medicament inner join produit on idmed=idprod " +
                "inner join medexterne on idmed=idmedexterne");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {

            list.add(new MédicamentProduitEnExterne(rs.getInt("idprod"),rs.getInt("prix"),
                    rs.getInt("Qte"),rs.getString("nom"), typeMed.valueOf(rs.getString("typemed")),
                    modePrise.valueOf(rs.getString("modeprise")),rs.getBoolean("ordrequise"),
                    rs.getInt("qtemin"),rs.getDouble("remise"),rs.getString("nomfirme")));

        }

        return list;
    }

}
