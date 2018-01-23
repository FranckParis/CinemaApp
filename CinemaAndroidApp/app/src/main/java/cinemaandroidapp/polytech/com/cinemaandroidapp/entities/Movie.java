package cinemaandroidapp.polytech.com.cinemaandroidapp.entities;

import java.sql.Date;

/**
 * Created by franck on 23/01/18.
 */

public class Movie {

    private String title;
    private int length;
    private Date releaseDate;
    private int budget;
    private int benefits;
    private Category cat;

    public Movie(String title, int length, Date releaseDate, int budget, int benefits, Category cat) {
        this.title = title;
        this.length = length;
        this.releaseDate = releaseDate;
        this.budget = budget;
        this.benefits = benefits;
        this.cat = cat;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setlength(int length) {
        this.length = length;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getBenefits() {
        return benefits;
    }

    public void setBenefits(int benefits) {
        this.benefits = benefits;
    }

    public Category getCat() {
        return cat;
    }

    public void setCat(Category cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", length=" + length +
                ", releaseDate=" + releaseDate +
                ", budget=" + budget +
                ", benefits=" + benefits +
                ", cat=" + cat +
                '}';
    }
}
