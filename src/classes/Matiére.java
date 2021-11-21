package classes;

public class Matiére {
    private String NomMatiére;
        private int idMatiére;

    public Matiére(String nomMatiére, int idMatiére) {
        NomMatiére = nomMatiére;
        this.idMatiére = idMatiére;
    }

    public Matiére(int idMatiére) {
        this.idMatiére = idMatiére;
    }

    public Matiére() {
    }

    public String getNomMatiére() {
        return NomMatiére;
    }

    public void setNomMatiére(String nomMatiére) {
        NomMatiére = nomMatiére;
    }

    public int getIdMatiére() {
        return idMatiére;
    }

    public void setIdMatiére(int idMatiére) {
        this.idMatiére = idMatiére;
    }
}
