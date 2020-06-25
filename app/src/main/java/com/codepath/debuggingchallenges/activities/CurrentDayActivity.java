package com.codepath.debuggingchallenges.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

import com.codepath.debuggingchallenges.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CurrentDayActivity extends AppCompatActivity {

    TextView tvDay;
    Calendar cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_day);
        tvDay = (TextView) findViewById(R.id.tvDay);
        tvDay.setText(getDayOfMonth());
    }

    private String getDayOfMonth() {
        cal = Calendar.getInstance();
        return Integer.toString(cal.get(Calendar.DAY_OF_MONTH));

    }
}
