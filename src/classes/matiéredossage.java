package classes;

public class matiéredossage  extends Matiére{

        private int idmedinterne;
        private int dossage;

    public matiéredossage(String nomMatiére, int idMatiére,  int dossage) {
        super(nomMatiére, idMatiére);
        this.dossage = dossage;
    }

    public matiéredossage(int idmedinterne, int dossage) {
        this.idmedinterne = idmedinterne;
        this.dossage = dossage;
    }

    public matiéredossage(int idMatiére, int idmedinterne, int dossage) {
        super(idMatiére);
        this.idmedinterne = idmedinterne;
        this.dossage = dossage;
    }

    public int getIdmedinterne() {
        return idmedinterne;
    }

    public void setIdmedinterne(int idmedinterne) {
        this.idmedinterne = idmedinterne;
    }

    public int getDossage() {
        return dossage;
    }

    public void setDossage(int dossage) {
        this.dossage = dossage;
    }
}

