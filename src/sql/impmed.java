package sql;

import sample.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class impmed implements imed {
    private static Connection con = BD.connect();
    @Override
    public boolean ajoutermed(String nom, String typemed, String modeprise, boolean ordrequise, int qtemin, int Qte, int prix,double remise) {
        try {
           PreparedStatement ps = con.prepareStatement("insert into produit(nom,Qte,prix) values('" + nom + "'," + Qte +","+prix+ ")");
            ps.execute();
            ps = con.prepareStatement("insert into medicament values (last_insert_id(),'" + typemed + "','" + modeprise +"',"+ordrequise+","+qtemin+","+remise+ ")");
            return ps.execute();


        } catch (Exception e) {
            try {
                System.out.println(ordrequise);

            } catch (Exception ex) {

            }

        }

        return true;
    }
}
