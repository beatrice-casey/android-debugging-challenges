package com.codepath.debuggingchallenges.activities;

import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.codepath.debuggingchallenges.R;

public class ChangeBackgroundActivity extends AppCompatActivity {

    private int oldColor = Color.BLUE;
    Button gobtn;
    View mainView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_background);

        gobtn = findViewById(R.id.btnGo);
        mainView = findViewById(android.R.id.content);
        //Toast.makeText(getApplicationContext(), "app open", Toast.LENGTH_SHORT).show();
        gobtn.setOnClickListener(OnClickInstance);


    }

    public void onGoClick(View view) {

        mainView.setBackgroundColor(getNextColor());
    }

    private int getNextColor() {
        int newColor = (oldColor == Color.BLUE) ? Color.RED : Color.BLUE;
        oldColor = newColor;
        return newColor;
    }

    private View.OnClickListener OnClickInstance = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(), "button", Toast.LENGTH_SHORT).show();
            onGoClick(mainView);
        }
    };
}
