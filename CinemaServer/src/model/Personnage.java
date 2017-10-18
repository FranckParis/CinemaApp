package model;

/**
 * Created by Quentin on 18/10/2017.
 */
public class Personnage {
    private Film film;
    private Acteur acteur;
    private String nomPers;

    public Personnage(Film film, Acteur acteur, String nomPers) {
        this.film = film;
        this.acteur = acteur;
        this.nomPers = nomPers;
    }

    public Film getFilm() {
        return film;
    }

    public Acteur getActeur() {
        return acteur;
    }

    public String getNomPers() {
        return nomPers;
    }
}
