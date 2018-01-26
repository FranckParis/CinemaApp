package cinemaandroidapp.polytech.com.cinemaandroidapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import cinemaandroidapp.polytech.com.cinemaandroidapp.R;
import cinemaandroidapp.polytech.com.cinemaandroidapp.entities.Movie;

/**
 * Created by franck on 25/01/18.
 */

public class MovieEditActivity extends AppCompatActivity {

    private EditText formTitle;
    private EditText formLength;
    private EditText formBudget;
    private EditText formBenefits;
    private EditText formReleaseDate;
    private Spinner formCategory;
    private Spinner formDirector;

    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_form);

        this.formTitle = findViewById(R.id.formTitle);
        this.formLength = findViewById(R.id.formLength);
        this.formReleaseDate = findViewById(R.id.formReleaseDate);
        this.formBudget = findViewById(R.id.formBudget);
        this.formBenefits = findViewById(R.id.formBenefits);

        this.formCategory = findViewById(R.id.formCategory);
        String[] items = new String[]{"Action", "Comedie", "Policier", "Western"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        this.formCategory.setAdapter(adapter);

        this.formDirector = findViewById(R.id.formDirector);
        String[] items2 = new String[]{"Oury", "Chabrol", "Besson", "Besnard"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        this.formDirector.setAdapter(adapter2);

        this.sendButton = findViewById(R.id.sendButton);

        //Setting text

        this.formTitle.setText(getMovie().getTitle());
        this.formBenefits.setText(String.valueOf(getMovie().getBenefits()));
        this.formBudget.setText(String.valueOf(getMovie().getBudget()));
        this.formLength.setText(String.valueOf(getMovie().getLength()));
        this.formReleaseDate.setText(String.valueOf(getMovie().getReleaseDate()));
        this.formCategory.setSelection(getMovie().getCat().getId());
        this.formDirector.setSelection(getMovie().getDir().getId());
    }

    public Movie getMovie(){
        Intent i = getIntent();
        Movie m = (Movie)i.getSerializableExtra("selectedMovie");
        return m;
    }

    public void send(View v)
    {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://5.51.148.35:8080/films";
        StringRequest postRequest = new StringRequest(Request.Method.PUT, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d("Response", response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d("Error.Response", String.valueOf(error));
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("title", formTitle.toString());
                params.put("releaseDate", formReleaseDate.toString());
                params.put("budget", formBudget.toString());
                params.put("benefits", formBenefits.toString());
                params.put("length", formLength.toString());
                params.put("category", formCategory.toString());

                return params;
            }
        };
        queue.add(postRequest);
    }
}
