package sql;


import classes.MédicamentProduitEnExterneEnStock;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class impmedextstock implements imedextstock {
    private static Connection con = BD.connect();
    @Override
    public boolean ajoutermedextstock(int numlot, LocalDate dateexp) {
        try {

            PreparedStatement ps = con.prepareStatement("insert into medexternestock values (last_insert_id()," + numlot +",'"+dateexp+ "')");
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
    public ObservableList<MédicamentProduitEnExterneEnStock> listmedextstock() throws SQLException {
        ObservableList<MédicamentProduitEnExterneEnStock> list = FXCollections.observableArrayList();
        PreparedStatement ps = con.prepareStatement("select * from produit inner join medexternestock on idprod=idmedexternestock inner join medicament on idmedexternestock=idmed ");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {

            list.add(new MédicamentProduitEnExterneEnStock(rs.getInt("idprod"),rs.getInt("Qte"),
                    rs.getString("nom"),rs.getDouble("remise"),rs.getInt("numlot"),rs.getDate("dateexp")));

        }

        return list;
    }
    @Override
    public LocalDate getdateexp(int id) throws SQLException {
        PreparedStatement ps=con.prepareStatement("select dateexp from medexternestock where idmedexternestock="+id);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){return rs.getDate("dateexp").toLocalDate();
        }
        else return null;
    }
}
