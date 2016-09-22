package com.example.pk.lifestats;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class StatsActivity extends AppCompatActivity {
    private TextView nameTextView;
    private TextView yearTextView;
    private TextView dayTextView;
    private TextView secondsTextView;
    private TextView zodiacSignTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        nameTextView = (TextView) findViewById(R.id.nameStatsTextView);
        yearTextView = (TextView) findViewById(R.id.yearStatsTextView);
        dayTextView = (TextView) findViewById(R.id.dayStatsTextView);
        secondsTextView = (TextView) findViewById(R.id.secondStatsTextView);
        zodiacSignTextView = (TextView) findViewById(R.id.zodiacSignTextView);

        fillingTextViews();
    }

    /**
     * This method filling text views life stats.
     */
    private void fillingTextViews() {
        LifeStatsModel lifeStatsModel = (LifeStatsModel)
                getIntent().getSerializableExtra("Life stats");

        int lifeStatsYear = getLifeStatsYears(lifeStatsModel.getDate());
        long lifeStatsDay = getLifeStatsDays(lifeStatsModel.getDate());
        long lifeStatsSecond = getLifeStatsSeconds(lifeStatsModel.getDate());
        String zodiacSign = getZodiacSign(lifeStatsModel.getDate());

        nameTextView.setText(String.format("Your name: %s", lifeStatsModel.getName()));
        yearTextView.setText(String.valueOf("You lived: " + lifeStatsYear + " years"));
        dayTextView.setText(String.valueOf("You lived: " + lifeStatsDay + " days"));
        secondsTextView.setText(String.valueOf("You lived: " + lifeStatsSecond + " seconds"));
        zodiacSignTextView.setText(String.format("Your zodiac sign: %s", zodiacSign));
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

    /**
     * This method calculate number of years that person lived.
     *
     * @param date - date of burn
     * @return - number of years
     */
    private int getLifeStatsYears(String date) {
       String[] splitArray = date.split("\\.");

        return getCurrentYear() - Integer.parseInt(splitArray[2]);
    }

    /**
     * This method calculate number of days that person lived.
     *
     * @param date - date of burn
     * @return - number of days
     */
    private long getLifeStatsDays(String date) {
        String[] splitArray = date.split("\\.");

        int day = Integer.parseInt(splitArray[0]);
        int month = Integer.parseInt(splitArray[1]);
        int year = Integer.parseInt(splitArray[2]);

        Calendar calendar = new GregorianCalendar(year, month, day);
        long bornSeconds = calendar.getTimeInMillis();

        long result = System.currentTimeMillis() - bornSeconds;

        return (result / 1000 / 60 / 60 / 24);
    }

    /**
     * This method calculate number of seconds that person lived.
     *
     * @param date - date of burn
     * @return - number of seconds
     */
    private long getLifeStatsSeconds(String date) {
        String[] splitArray = date.split("\\.");

        int day = Integer.parseInt(splitArray[0]);
        int month = Integer.parseInt(splitArray[1]);
        int year = Integer.parseInt(splitArray[2]);

        Calendar calendar = new GregorianCalendar(year, month, day);
        long bornSeconds = calendar.getTimeInMillis();

        long result = System.currentTimeMillis() - bornSeconds;

        return (result / 1000);
    }

    /**
     * This method calculate zodiac sign of person.
     *
     * @param date - date of burn
     * @return - zodiac sign
     */
    private String getZodiacSign(String date) {
        String result = "";

        String[] splitArray = date.split("\\.");

        int day = Integer.parseInt(splitArray[0]);
        int month = Integer.parseInt(splitArray[1]);

        if (day >= 22 && month == 3 || day <= 20 && month == 4) {
            result = "Aries";
        }
        if (day >= 21 && month == 4 || day <= 21 && month == 5) {
            result = "Taurus";
        }
        if (day >= 22 && month == 5 || day <= 21 && month == 6) {
            result = "Gemini";
        }
        if (day >= 22 && month == 6 || day <= 22 && month == 7) {
            result = "Cancer";
        }
        if (day >= 23 && month == 7 || day <= 22 && month == 8) {
            result = "Leo";
        }
        if (day >= 23 && month == 8 || day <= 22 && month == 9) {
            result = "Virgo";
        }
        if (day >= 23 && month == 9 || day <= 23 && month == 10) {
            result = "Libra";
        }
        if (day >= 24 && month == 10 || day <= 21 && month == 11) {
            result = "Scorpio";
        }
        if (day >= 22 && month == 11 || day <= 21 && month == 12) {
            result = "Sagittarius";
        }
        if (day >= 22 && month == 12 || day <= 20 && month == 1) {
            result = "Capricorn";
        }
        if (day >= 21 && month == 1 || day <= 21 && month == 2) {
            result = "Aquarius";
        }
        if (day >= 22 && month == 2 || day <= 21 && month == 3) {
            result = "Aries";
        }

        return result;
    }
}
