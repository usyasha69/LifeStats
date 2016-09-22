package com.example.pk.lifestats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText nameEditText;
    private EditText dayEditText;
    private EditText monthEditText;
    private EditText yearEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = (EditText) findViewById(R.id.nameEditText);
        dayEditText = (EditText) findViewById(R.id.dayEditText);
        monthEditText = (EditText) findViewById(R.id.monthEditText);
        yearEditText = (EditText) findViewById(R.id.yearEditText);

        final Button checkLifeStatsButton = (Button) findViewById(R.id.lifeStatsButton);
        checkLifeStatsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (nameEditText.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please, enter the correctly name", Toast.LENGTH_SHORT).show();
            return;
        }

        if (dateIsCorrectly()) {
            String name = nameEditText.getText().toString();
            String day = dayEditText.getText().toString();
            String month = monthEditText.getText().toString();
            String year = yearEditText.getText().toString();

            String date = day +
                    "." +
                    month +
                    "." +
                    year;

            Intent intent = new Intent(this, StatsActivity.class);
            intent.putExtra("Life stats", new LifeStatsModel(name, date));

            startActivity(intent);
        } else {
            Toast.makeText(this, "Please, enter the correctly date", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * This method checked correctly date.
     *
     * @return - result of checked
     */
    private boolean dateIsCorrectly() {
        boolean result = true;

        String day = dayEditText.getText().toString();
        String month = monthEditText.getText().toString();
        String year = yearEditText.getText().toString();

        //checked day
        if (day.isEmpty()) {
            result = false;
        }

        if (!day.isEmpty() && (Integer.parseInt(day) <= 0 || Integer.parseInt(day) > 31)) {
            result = false;
        }

        //checked month
        if (month.isEmpty()) {
            result = false;
        }

        if (!month.isEmpty() && (Integer.parseInt(month) <= 0 || Integer.parseInt(month) > 12)) {
            result = false;
        }

        //checked year
        if (year.isEmpty()) {
            result = false;
        }

        if (!year.isEmpty() && Integer.parseInt(year) > getCurrentYear()) {
            result = false;
        }

        return result;
    }

    /**
     * This method find current year.
     *
     * @return - current year
     */
    private int getCurrentYear() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date(System.currentTimeMillis()));

        return calendar.get(Calendar.YEAR);
    }
}
