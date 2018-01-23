package cinemaandroidapp.polytech.com.cinemaandroidapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;

import cinemaandroidapp.polytech.com.cinemaandroidapp.R;
import cinemaandroidapp.polytech.com.cinemaandroidapp.entities.Category;
import cinemaandroidapp.polytech.com.cinemaandroidapp.entities.Movie;

/**
 * Created by franck on 23/01/18.
 */

public class MovieListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movielist);
        listMovies();
    }

    public ArrayList<Movie> listMovies(){

        ArrayList<Movie> movies = new ArrayList<>();

        try {
            JSONObject jsonResponse = new JSONObject("{ _embedded : { films : [ { titre : LÃ©on, duree : 110, dateSortie : 1994-04-14, budget : 17531000, montantRecette : 69250000, _links : { self : { href : 'http://localhost:8080/films/1' }, film : { href : 'http://localhost:8080/films/1' }, categorieByCodeCat : { href : 'http://localhost:8080/films/1/categorieByCodeCat' } } }, { titre : Cash, duree : 100, dateSortie : 2008-04-23, budget : 18340000, montantRecette : 60340000, _links : { self : { href : 'http://localhost:8080/films/2' }, film : { href : 'http://localhost:8080/films/2' }, categorieByCodeCat : { href : 'http://localhost:8080/films/2/categorieByCodeCat' } } }, { titre : La grande vadrouille, duree : 132, dateSortie : 1966-12-01, budget : 7227000, montantRecette : 51258000, _links : { self : { href : 'http://localhost:8080/films/3' }, film : { href : 'http://localhost:8080/films/3' }, categorieByCodeCat : { href : 'http://localhost:8080/films/3/categorieByCodeCat' } } }, { titre : Subway, duree : 104, dateSortie : 1985-04-10, budget : 10567000, montantRecette : 70500000, _links : { self : { href : 'http://localhost:8080/films/4' }, film : { href : 'http://localhost:8080/films/4' }, categorieByCodeCat : { 'href : http://localhost:8080/films/4/categorieByCodeCat' } } } ] }, _links : { self : { href : 'http://localhost:8080/films' }, profile : { href : 'http://localhost:8080/profile/films' } } }");
            JSONObject moviesJson = jsonResponse.getJSONObject("_embedded").getJSONObject("films");

            Iterator x = moviesJson.keys();
            JSONArray jsonArray = new JSONArray();

            while (x.hasNext()){
                String key = (String) x.next();
                jsonArray.put(moviesJson.get(key));
            }

            for(int i = 0 ; i < moviesJson.length(); i++) {
                JSONObject currentMovie = jsonArray.getJSONObject(i);

                String title = currentMovie.getString("titre");
                int length = Integer.parseInt(currentMovie.getString("duree"));
                Date releaseDate = Date.valueOf(currentMovie.getString("dateSortie"));
                int budget = Integer.parseInt(currentMovie.getString("budget"));
                int benefits = Integer.parseInt(currentMovie.getString("montantRecette"));

                //Add category id to sent JSON
                Category cat = new Category(1);

                Movie m = new Movie(title, length, releaseDate, budget, benefits, cat);
                movies.add(m);
                Log.i("test",m.toString());
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
