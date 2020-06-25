package com.codepath.debuggingchallenges.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.codepath.debuggingchallenges.R;
import com.codepath.debuggingchallenges.adapters.MoviesAdapter;
import com.codepath.debuggingchallenges.models.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.Headers;

public class MoviesActivity extends AppCompatActivity {

    public static final String URL = "https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";

    RecyclerView rvMovies;
    MoviesAdapter adapter;
    ArrayList<Movie> movies;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        rvMovies = findViewById(R.id.rvMovies);
        movies = new ArrayList<>();


        // Create the adapter to convert the array to views
        MoviesAdapter adapter = new MoviesAdapter(movies);

        // Attach the adapter to a ListView
        rvMovies.setAdapter(adapter);
        rvMovies.setLayoutManager(new LinearLayoutManager(this));

        fetchMovies();
    }


    private void fetchMovies() {
        Toast.makeText(getApplicationContext(), "connection starting...", Toast.LENGTH_SHORT).show();
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON response) {
                Toast.makeText(getApplicationContext(), "connection made", Toast.LENGTH_SHORT).show();
                Log.d("MoviesActivity", "onSuccess");
                JSONObject jsonObject = response.jsonObject;
                try {
                    JSONArray moviesJson = jsonObject.getJSONArray("results");
                    movies.addAll(Movie.fromJSONArray(moviesJson));
                    Log.i("MoviesActivity", "Results: " + moviesJson.toString());
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    Log.e("MoviesActivity", "Hit json exception ", e);
                }
            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                Log.e(MoviesActivity.class.getSimpleName(), "Error retrieving movies: ", throwable);
            }
        });
    }
}
