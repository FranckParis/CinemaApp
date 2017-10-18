package model;

/**
 * Created by Quentin on 18/10/2017.
 */
public class Categorie {
    private String codeCat;
    private String libelleCat;

    public Categorie(String codeCat, String libelleCat) {
        this.codeCat = codeCat;
        this.libelleCat = libelleCat;
    }

    public String getCodeCat() {
        return codeCat;
    }

    public String getLibelleCat() {
        return libelleCat;
    }
}
