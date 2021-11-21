package classes;

public class medlivraison {
    private int idlivraison,idmed,qteliv;
    private String nom;

    public medlivraison( int idmed, int qteliv, String nom) {

        this.idmed = idmed;
        this.qteliv = qteliv;
        this.nom = nom;
    }

    public int getIdlivraison() {
        return idlivraison;
    }

    public void setIdlivraison(int idlivraison) {
        this.idlivraison = idlivraison;
    }

    public int getIdmed() {
        return idmed;
    }

    public void setIdmed(int idmed) {
        this.idmed = idmed;
    }

    public int getQteliv() {
        return qteliv;
    }

    public void setQteliv(int qteliv) {
        this.qteliv = qteliv;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
