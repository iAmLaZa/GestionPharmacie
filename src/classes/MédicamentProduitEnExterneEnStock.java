package classes;
import java.util.Date;

public class MédicamentProduitEnExterneEnStock extends MédicamentProduitEnExterne {
    private int Numlot;
    private Date dateExp;

    public MédicamentProduitEnExterneEnStock(int idprod, int prix, int qte, String nomprod, typeMed typeMed, modePrise modePriseMed, boolean ordRequise, int qtemin, double remise, String nomFirme, int numlot, Date dateExp) {
        super(idprod, prix, qte, nomprod, typeMed, modePriseMed, ordRequise, qtemin, remise, nomFirme);
        Numlot = numlot;
        this.dateExp = dateExp;
    }

    public MédicamentProduitEnExterneEnStock(typeMed typeMed, modePrise modePriseMed, boolean ordRequise, int qtemin, double remise, String nomFirme, int numlot, Date dateExp) {
        super(typeMed, modePriseMed, ordRequise, qtemin, remise, nomFirme);
        Numlot = numlot;
        this.dateExp = dateExp;
    }

    public MédicamentProduitEnExterneEnStock(int idprod, int qte, String nomprod, double remise, String nomFirme, int numlot, Date dateExp) {
        super(idprod, qte, nomprod, remise, nomFirme);
        Numlot = numlot;
        this.dateExp = dateExp;
    }

    public MédicamentProduitEnExterneEnStock(int idprod, int qte, String nomprod, double remise, int numlot, Date dateExp) {
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
