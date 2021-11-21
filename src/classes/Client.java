package classes;


import java.util.ArrayList;

public class Client extends Personne{
    private int idclient;
    private String numsocial;
    private boolean maladiechronique;
    private ArrayList<Commande> commandes=new ArrayList<>();

    public Client(String nom, String prenom,  int idclient, String numsocial, boolean maladiechronique,int age) {
        super(nom, prenom, age);
        this.idclient = idclient;
        this.numsocial = numsocial;
        this.maladiechronique = maladiechronique;
    }

    public Client(int idclient, String numsocial, boolean maladiechronique) {
        this.idclient = idclient;
        this.numsocial = numsocial;
        this.maladiechronique = maladiechronique;

    }



    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public String getNumsocial() {
        return numsocial;
    }

    public void setNumsocial(String numsocial) {
        this.numsocial = numsocial;
    }

    public boolean isMaladiechronique() {
        return maladiechronique;
    }

    public void setMaladiechronique(boolean maladiechronique) {
        this.maladiechronique = maladiechronique;
    }

    public ArrayList<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(ArrayList<Commande> commandes) {
        this.commandes = commandes;
    }
}
