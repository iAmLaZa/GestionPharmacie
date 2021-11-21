package classes;

public class ProduitParapharmacetique extends Produit {

    private typeProd TypeProd;


    public ProduitParapharmacetique(int idprod, int prix, int qte, String nomprod, typeProd typeProd) {
        super(idprod, prix, qte, nomprod);
        TypeProd = typeProd;
    }

    public ProduitParapharmacetique(typeProd typeProd) {
        TypeProd = typeProd;
    }

    public typeProd getTypeProd() {
        return TypeProd;
    }

    public void setTypeProd(typeProd typeProd) {
        TypeProd = typeProd;
    }
}
