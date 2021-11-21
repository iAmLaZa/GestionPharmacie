package classes;

public  class Médicament extends Produit {

    private typeMed TypeMed;
    private modePrise ModePriseMed;
    private boolean OrdRequise;
    private int qtemin;
    private double remise;


    public Médicament(int idprod, int prix, int qte, String nomprod, typeMed typeMed, modePrise modePriseMed, boolean ordRequise, int qtemin,double remise) {
        super(idprod, prix, qte, nomprod);
        TypeMed = typeMed;
        ModePriseMed = modePriseMed;
        OrdRequise = ordRequise;
        this.qtemin = qtemin;
        this.remise=remise;
    }

    public Médicament(typeMed typeMed, modePrise modePriseMed, boolean ordRequise, int qtemin,double remise) {
        TypeMed = typeMed;
        ModePriseMed = modePriseMed;
        OrdRequise = ordRequise;
        this.qtemin = qtemin;
        this.remise=remise;

    }

    public Médicament(int idprod, int qte, String nomprod,double remise) {
        super(idprod, qte, nomprod);this.remise=remise;
    }


    public double getRemise() {
        return remise;
    }

    public void setRemise(double remise) {
        this.remise = remise;
    }

    public typeMed getTypeMed() {
        return TypeMed;
    }

    public void setTypeMed(typeMed typeMed) {
        TypeMed = typeMed;
    }

    public modePrise getModePriseMed() {
        return ModePriseMed;
    }

    public void setModePriseMed(modePrise modePriseMed) {
        ModePriseMed = modePriseMed;
    }

    public boolean isOrdRequise() {
        return OrdRequise;
    }

    public void setOrdRequise(boolean ordRequise) {
        OrdRequise = ordRequise;
    }

    public int getQtemin() {
        return qtemin;
    }

    public void setQtemin(int qtemin) {
        this.qtemin = qtemin;
    }
}
