package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Quentin on 26/10/2017.
 */
@Entity
public class Categorie {
    private String codeCat;
    private String libelleCat;

    @Id
    @Column(name = "CodeCat")
    public String getCodeCat() {
        return codeCat;
    }

    public void setCodeCat(String codeCat) {
        this.codeCat = codeCat;
    }

    @Basic
    @Column(name = "LibelleCat")
    public String getLibelleCat() {
        return libelleCat;
    }

    public void setLibelleCat(String libelleCat) {
        this.libelleCat = libelleCat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Categorie categorie = (Categorie) o;

        if (codeCat != null ? !codeCat.equals(categorie.codeCat) : categorie.codeCat != null) return false;
        if (libelleCat != null ? !libelleCat.equals(categorie.libelleCat) : categorie.libelleCat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codeCat != null ? codeCat.hashCode() : 0;
        result = 31 * result + (libelleCat != null ? libelleCat.hashCode() : 0);
        return result;
    }
}
