package model;

import java.sql.Date;

/**
 * Created by Quentin on 18/10/2017.
 */
public class Film {
    private int noFilm;
    private String titre;
    private int duree;
    private Date dateSortie;
    private int budget;
    private int montantRecette;
    private Realisateur realisateur;
    private Categorie categorie;

    public Film(int noFilm, String titre, int duree, Date dateSortie, int budget, int montantRecette, Realisateur realisateur, Categorie categorie) {
        this.noFilm = noFilm;
        this.titre = titre;
        this.duree = duree;
        this.dateSortie = dateSortie;
        this.budget = budget;
        this.montantRecette = montantRecette;
        this.realisateur = realisateur;
        this.categorie = categorie;
    }

    public int getNoFilm() {
        return noFilm;
    }

    public String getTitre() {
        return titre;
    }

    public int getDuree() {
        return duree;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public int getBudget() {
        return budget;
    }

    public int getMontantRecette() {
        return montantRecette;
    }

    public Realisateur getRealisateur() {
        return realisateur;
    }

    public Categorie getCategorie() {
        return categorie;
    }
}
