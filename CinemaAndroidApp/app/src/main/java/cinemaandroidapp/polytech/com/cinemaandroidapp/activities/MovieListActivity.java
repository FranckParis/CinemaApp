package cinemaandroidapp.polytech.com.cinemaandroidapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;

import cinemaandroidapp.polytech.com.cinemaandroidapp.R;
import cinemaandroidapp.polytech.com.cinemaandroidapp.adapters.MovieAdapter;
import cinemaandroidapp.polytech.com.cinemaandroidapp.entities.Category;
import cinemaandroidapp.polytech.com.cinemaandroidapp.entities.Movie;

/**
 * Created by franck on 23/01/18.
 */

public class MovieListActivity extends AppCompatActivity {

    private ListView movieList;
    private ArrayList<Movie> movies;
    MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.movies = new ArrayList<>();
        this.movieList = (ListView) findViewById(R.id.movie_list);
        listMovies();
        super.onCreate(savedInstanceState);

    }

    public void listMovies(){

        RequestQueue queue = Volley.newRequestQueue(this);
        final ArrayList<Movie> movies = new ArrayList<>();
        String url = "http://5.51.148.35:8080/films";

        // Request a string response from the provided URL.
        JsonObjectRequest request = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        //System.out.println(response.toString());
                        try {
                            JSONObject moviesJsonEmbed = response.getJSONObject("_embedded");
                            JSONArray moviesJson = moviesJsonEmbed.getJSONArray("films");

                            System.out.println(moviesJson);

                            for(int i = 0 ; i < moviesJson.length(); i++) {
                                JSONObject currentMovie = moviesJson.getJSONObject(i);

                                String title = currentMovie.getString("titre");
                                int length = Integer.parseInt(currentMovie.getString("duree"));
                                Date releaseDate = Date.valueOf(currentMovie.getString("dateSortie"));
                                int budget = Integer.parseInt(currentMovie.getString("budget"));
                                int benefits = Integer.parseInt(currentMovie.getString("montantRecette"));

                                //Add category id to sent JSON
                                Category cat = new Category(1);

                                Movie m = new Movie(title, length, releaseDate, budget, benefits, cat);
                                movies.add(m);
                            }
                            System.out.println(movies);

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Date d = Date.valueOf("1966-12-01");
                            movies.add(new Movie("",0, d,0,0, new Category(1)));
                        }

                        adapter = new MovieAdapter(getApplicationContext(), movies);
                        movieList.setAdapter(adapter);

                        movieList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        });
                    }
                    
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("That didn't work!");
                Date d = Date.valueOf("1966-12-01");
                movies.add(new Movie("",0, d,0,0, new Category(1)));
                adapter = new MovieAdapter(getApplicationContext(), movies);
                movieList.setAdapter(adapter);
            }
        });

        // Add the request to the RequestQueue.
        queue.add(request);
    }
}
