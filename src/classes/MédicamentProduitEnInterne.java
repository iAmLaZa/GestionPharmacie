package classes;

import java.util.ArrayList;

public class MédicamentProduitEnInterne extends Médicament{




    private ArrayList<matiéredossage> matiéredossages=new ArrayList<>();

    public MédicamentProduitEnInterne(int idprod, int prix, int qte, String nomprod, typeMed typeMed, modePrise modePriseMed, boolean ordRequise, int qtemin, double remise) {
        super(idprod, prix, qte, nomprod, typeMed, modePriseMed, ordRequise, qtemin, remise);
    }

    public MédicamentProduitEnInterne(typeMed typeMed, modePrise modePriseMed, boolean ordRequise, int qtemin, double remise) {
        super(typeMed, modePriseMed, ordRequise, qtemin, remise);
    }

    public MédicamentProduitEnInterne(int idprod, int qte, String nomprod, double remise) {
        super(idprod, qte, nomprod, remise);
    }

    public ArrayList<matiéredossage> getMatiéredossages() {
        return matiéredossages;
    }

    public void setMatiéredossages(ArrayList<matiéredossage> matiéredossages) {
        this.matiéredossages = matiéredossages;
    }
}
