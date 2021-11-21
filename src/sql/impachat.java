package sql;

import sample.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;

public class impachat implements iachat {
    private static Connection con = BD.connect();
    @Override
    public boolean ajoutermedprescrit(int idachat, int idmedprescrit, int qte, LocalDate dure, String nom) {
        try {

            PreparedStatement ps = con.prepareStatement("insert into medicamentprescrit(idmedprescrit,idachat,qte,dure,nom)values ("+idmedprescrit+","+idachat+","+qte+",'"+dure+"','"+nom+"')");
            return ps.execute();


        } catch (Exception e) {
            try {

            } catch (Exception ex) {

            }

        }

        return true;
    }
}
