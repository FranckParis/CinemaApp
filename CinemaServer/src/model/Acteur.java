package model;

import java.sql.Date;

/**
 * Created by Quentin on 18/10/2017.
 */
public class Acteur {
    private int noAct;
    private String nomAct;
    private String prenAct;
    private Date dateNaiss;
    private Date dateDeces;

    public Acteur(int noAct, String nomAct, String prenAct, Date dateNaiss, Date dateDeces) {
        this.noAct = noAct;
        this.nomAct = nomAct;
        this.prenAct = prenAct;
        this.dateNaiss = dateNaiss;
        this.dateDeces = dateDeces;
    }

    public int getNoAct() {
        return noAct;
    }

    public String getNomAct() {
        return nomAct;
    }

    public String getPrenAct() {
        return prenAct;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public Date getDateDeces() {
        return dateDeces;
    }
}
