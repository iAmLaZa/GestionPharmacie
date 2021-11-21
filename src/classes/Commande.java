package classes;

import java.util.ArrayList;

public class Commande {

        private int idclient;
        private int idcommande,prix;
        private ArrayList<MédicamentPréscrit> médicamentPréscrits=new ArrayList<>();

    public Commande(int idclient, int idcommande, int prix) {
        this.idclient = idclient;
        this.idcommande = idcommande;
        this.prix = prix;
    }

    public Commande(int idcommande, int prix) {
        this.idcommande = idcommande;
        this.prix = prix;
    }

    public Commande() {
        }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public int getIdcommande() {
            return idcommande;
        }

        public void setIdcommande(int idcommande) {
            this.idcommande = idcommande;
        }

        public ArrayList<MédicamentPréscrit> getMédicamentPréscrits() {
            return médicamentPréscrits;
        }

        public void setMédicamentPréscrits(ArrayList<MédicamentPréscrit> médicamentPréscrits) {
            this.médicamentPréscrits = médicamentPréscrits;
        }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
}

