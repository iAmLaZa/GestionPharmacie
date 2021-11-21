package classes;

import java.util.ArrayList;

public class MédcinConvetionné extends Personne {
    private int idMed;
    String adresse;
    String specialite;
    private ArrayList<Commande> commandes=new ArrayList<>();


    public MédcinConvetionné(String nom, String prenom, int age, int idMed,String adresse,String specialite) {
        super(nom, prenom, age);
        this.idMed = idMed;
        this.adresse=adresse;
        this.specialite=specialite;
    }

    public MédcinConvetionné(int idMed) {

        this.idMed = idMed;
    }




    public MédcinConvetionné(int idMed, ArrayList<Commande> commandes) {
        this.idMed = idMed;
        this.commandes = commandes;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public int getIdMed() {
        return idMed;
    }

    public void setIdMed(int idMed) {
        this.idMed = idMed;
    }
}
