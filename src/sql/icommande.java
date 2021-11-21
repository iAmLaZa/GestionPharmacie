package sql;

import classes.Commande;
import classes.MédicamentPréscrit;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.time.LocalDate;

public interface icommande {

    public ObservableList<MédicamentPréscrit> listemedprescritcoomande(int idcommande) throws SQLException;
    public ObservableList<MédicamentPréscrit> listemedprescritachat(int idcommande) throws SQLException;
    public boolean ajoutermedprescrit(int idcommande, int idmedprescrit, int qte, LocalDate dure, String nom);
    public ObservableList<Commande> listcommandeclient(int idclient) throws SQLException;
    public ObservableList<Commande> listcommande() throws SQLException;
}
