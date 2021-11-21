package classes;

public class MédicamentProduitEnExterne extends Médicament {
    private String NomFirme;

    public MédicamentProduitEnExterne(int idprod, int prix, int qte, String nomprod, typeMed typeMed, modePrise modePriseMed, boolean ordRequise, int qtemin, double remise, String nomFirme) {
        super(idprod, prix, qte, nomprod, typeMed, modePriseMed, ordRequise, qtemin, remise);
        NomFirme = nomFirme;
    }

    public MédicamentProduitEnExterne(typeMed typeMed, modePrise modePriseMed, boolean ordRequise, int qtemin, double remise, String nomFirme) {
        super(typeMed, modePriseMed, ordRequise, qtemin, remise);
        NomFirme = nomFirme;
    }

    public MédicamentProduitEnExterne(int idprod, int qte, String nomprod, double remise, String nomFirme) {
        super(idprod, qte, nomprod, remise);
        NomFirme = nomFirme;
    }

    public MédicamentProduitEnExterne(int idprod, int qte, String nomprod, double remise) {
        super(idprod, qte, nomprod, remise);
    }

    public String getNomFirme() {
        return NomFirme;
    }

    public void setNomFirme(String nomFirme) {
        NomFirme = nomFirme;
    }
}
