package sql;

import classes.Produit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class impprod  implements iprod{
    private static Connection con = BD.connect();
    @Override
    public boolean updateget(int id, int qte) throws SQLException {

        try {
            int Qte;
            PreparedStatement ps=con.prepareStatement("select Qte from produit where idprod="+id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){Qte= qte+rs.getInt("Qte");
            }
            else Qte=qte;
            System.out.println(Qte);
            ps = con.prepareStatement("update produit set Qte="+Qte+" where idprod="+id);

            return !ps.execute();


        } catch (SQLException e) {

            System.out.println(e);
        }
        finally {
            try {

            } catch (Exception ex) {

            }
        }
        return false;
    }

    @Override
    public ObservableList<Produit> listeprod() throws SQLException {

        ObservableList<Produit> list= FXCollections.observableArrayList();
        PreparedStatement ps=con.prepareStatement("select * from commande where idclient=0");
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            list.add(new Produit(rs.getInt("idprod"),rs.getInt("Qte"),rs.getString("nom"),rs.getInt("prix")));
        }
        return list;
    }

    @Override
    public int getqtemin(int id) throws SQLException {
        PreparedStatement ps=con.prepareStatement("select qtemin from medicament where idmed="+id);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){return rs.getInt("qtemin");
        }
        else return 0;
    }

    @Override
    public int getqte(int id) throws SQLException {
        PreparedStatement ps=con.prepareStatement("select Qte from produit where idprod="+id);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){return rs.getInt("Qte");
        }
        else return 0;
    }

}

