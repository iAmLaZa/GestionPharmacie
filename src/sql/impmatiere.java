package sql;

import classes.Matiére;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import manipulation.outils;
import sample.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class impmatiere implements imatiere{
    private static Connection con = BD.connect();
    @Override
    public boolean ajoutermatiere(String nom) {
        try {
            PreparedStatement ps = con.prepareStatement("insert into matiere(nom) values('"+ nom +"')");

            return ps.execute();

        } catch (Exception e) {
            outils.showerroronmessage("error","matiere existe deja");
            try {


            } catch (Exception ex) {

            }

        }

        return true;
    }

    @Override
    public ObservableList<Matiére> listematiere() throws SQLException {
        ObservableList<Matiére> list= FXCollections.observableArrayList();
        PreparedStatement ps=con.prepareStatement("select *from matiere");
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            list.add(new Matiére(rs.getString("nom"),rs.getInt("idmatiere")));
        }
        return list;
    }
}
