package classes;


import java.util.ArrayList;

public class Livraison {
    private int idlivraison;
    private Fournisseur fournisseur;
    ArrayList<MédicamentProduitEnExterneEnStock> médicamentProduitEnExterneEnStocks=new ArrayList<>();

    public Livraison(int idlivraison, Fournisseur fournisseur) {
        this.idlivraison = idlivraison;
        this.fournisseur = fournisseur;
    }
    public Livraison(int idlivraison) {
        this.idlivraison = idlivraison;

    }

    public Livraison() {
    }

    public ArrayList<MédicamentProduitEnExterneEnStock> getMédicamentProduitEnExterneEnStocks() {
        return médicamentProduitEnExterneEnStocks;
    }

    public void setMédicamentProduitEnExterneEnStocks(ArrayList<MédicamentProduitEnExterneEnStock> médicamentProduitEnExterneEnStocks) {
        this.médicamentProduitEnExterneEnStocks = médicamentProduitEnExterneEnStocks;
    }

    public int getIdlivraison() {
        return idlivraison;
    }

    public void setIdlivraison(int idlivraison) {
        this.idlivraison = idlivraison;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }
}
