package classes;

import java.util.ArrayList;

public class Fournisseur  {

    private int idfournisseur;
    private String name,numtél;

    private ArrayList<Livraison> livraisons=new ArrayList<>();

    public Fournisseur(int idfournisseur, String numtél, String name) {
        this.idfournisseur = idfournisseur;
        this.numtél = numtél;
        this.name = name;
    }

    public int getIdfournisseur() {
        return idfournisseur;
    }

    public void setIdfournisseur(int idfournisseur) {
        this.idfournisseur = idfournisseur;
    }

    public String getNumtél() {
        return numtél;
    }

    public void setNumtél(String numtél) {
        this.numtél = numtél;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Livraison> getLivraisons() {
        return livraisons;
    }

    public void setLivraisons(ArrayList<Livraison> livraisons) {
        this.livraisons = livraisons;
    }
}
