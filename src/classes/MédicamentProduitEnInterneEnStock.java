package classes;

import java.util.Date;

public class MédicamentProduitEnInterneEnStock extends MédicamentProduitEnInterne{

    private int Numlot;
    private Date dateExp;

    public MédicamentProduitEnInterneEnStock(int idprod, int prix, int qte, String nomprod, typeMed typeMed, modePrise modePriseMed, boolean ordRequise, int qtemin, double remise, int numlot, Date dateExp) {
        super(idprod, prix, qte, nomprod, typeMed, modePriseMed, ordRequise, qtemin, remise);
        Numlot = numlot;
        this.dateExp = dateExp;
    }

    public MédicamentProduitEnInterneEnStock(typeMed typeMed, modePrise modePriseMed, boolean ordRequise, int qtemin, double remise, int numlot, Date dateExp) {
        super(typeMed, modePriseMed, ordRequise, qtemin, remise);
        Numlot = numlot;
        this.dateExp = dateExp;
    }

    public MédicamentProduitEnInterneEnStock(int idprod, int qte, String nomprod, double remise, int numlot, Date dateExp) {
        super(idprod, qte, nomprod, remise);
        Numlot = numlot;
        this.dateExp = dateExp;
    }

    public int getNumlot() {
        return Numlot;
    }

    public void setNumlot(int numlot) {
        Numlot = numlot;
    }

    public Date getDateExp() {
        return dateExp;
    }

    public void setDateExp(Date dateExp) {
        this.dateExp = dateExp;
    }
}
