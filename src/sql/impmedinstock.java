package sql;


import classes.MédicamentProduitEnInterneEnStock;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class impmedinstock implements imedintstock{
    private static Connection con = BD.connect();
    @Override
    public boolean ajoutermedintstock(int numlot, LocalDate dateexp) {
        try {

            PreparedStatement ps = con.prepareStatement("insert into medinternestock values (last_insert_id()," + numlot +",'"+dateexp+ "')");
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
    public ObservableList<MédicamentProduitEnInterneEnStock> listmedintstock() throws SQLException {
        ObservableList<MédicamentProduitEnInterneEnStock> list = FXCollections.observableArrayList();
        PreparedStatement ps = con.prepareStatement("select * from produit inner join medinternestock on idprod=idmedinternestock inner join medicament on idmedinternestock=idmed");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {

            list.add(new MédicamentProduitEnInterneEnStock(rs.getInt("idprod"),rs.getInt("Qte"),
                    rs.getString("nom"),rs.getDouble("remise"),rs.getInt("numlot"),rs.getDate("dateexp")));

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

    @Override
    public LocalDate getdateexp(int id) throws SQLException {
        PreparedStatement ps=con.prepareStatement("select dateexp from medinternestock where idmedinternestock="+id);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){

            return rs.getDate("dateexp").toLocalDate();
        }
        else return null;
    }
}
