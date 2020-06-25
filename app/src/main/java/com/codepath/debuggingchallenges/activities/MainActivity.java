package com.codepath.debuggingchallenges.activities;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.debuggingchallenges.R;
import com.codepath.debuggingchallenges.adapters.MoviesAdapter;
import com.codepath.debuggingchallenges.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void launchActivity(Class klass) {
        Intent intent = new Intent(this, klass);
        startActivity(intent);
    }

    public void launchCurrentDayActivity(View view) {
        launchActivity(CurrentDayActivity.class);
    }

    public void launchMoviesActivity(View view) {
        launchActivity(MoviesActivity.class);
    }

    public void launchChangeBackgroundActivity(View view) {
        launchActivity(ChangeBackgroundActivity.class);
    }

    public void launchToolbarActivity(View view) {
        launchActivity(ToolbarActivity.class);
    }
}
