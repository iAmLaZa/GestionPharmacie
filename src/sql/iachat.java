package sql;

import java.time.LocalDate;

public interface iachat {
    public boolean ajoutermedprescrit(int idacaht, int idmedprescrit, int qte, LocalDate dure, String nom);
}
