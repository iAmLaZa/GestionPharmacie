package classes;

public class Produit {
    private int idprod,prix,qte;
    private String nomprod;

    public Produit(int idprod, int prix, int qte, String nomprod) {
        this.idprod = idprod;
        this.prix = prix;
        this.qte = qte;
        this.nomprod = nomprod;
    }

    public Produit() {
    }

    public Produit(int idprod, int qte, String nomprod) {
        this.idprod = idprod;
        this.qte = qte;
        this.nomprod = nomprod;
    }
    public Produit(int idprod, int qte, String nomprod,int prix) {
        this.idprod = idprod;
        this.qte = qte;
        this.nomprod = nomprod;
        this.prix=prix;
    }

    public Produit(int idprod, String nomprod) {
        this.idprod = idprod;
        this.nomprod = nomprod;
    }

    public int getIdprod() {
        return idprod;
    }

    public void setIdprod(int idprod) {
        this.idprod = idprod;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public String getNomprod() {
        return nomprod;
    }

    public void setNomprod(String nomprod) {
        this.nomprod = nomprod;
    }
}
