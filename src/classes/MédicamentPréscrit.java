package classes;

import java.time.LocalDate;

public class MédicamentPréscrit {
    private int id;
    private String NomMed;
    private LocalDate duree;
    private int Qte,prix;

    public MédicamentPréscrit(int id, String nomMed, int qte, int prix, LocalDate duree) {
        this.id=id;
        NomMed = nomMed;
        this.prix=prix;
        Qte = qte;
        this.duree=duree;
    }

    public MédicamentPréscrit() {
    }

    public String getNomMed() {
        return NomMed;
    }

    public void setNomMed(String nomMed) {
        NomMed = nomMed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDuree() {
        return duree;
    }

    public void setDuree(LocalDate duree) {
        this.duree = duree;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getQte() {
        return Qte;
    }

    public void setQte(int qte) {
        Qte = qte;
    }
}
