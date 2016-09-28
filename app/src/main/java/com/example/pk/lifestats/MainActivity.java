package com.example.pk.lifestats;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String LIFE_STATS_KEY = "Life stats";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.activity_main_root, PutInformationFragment.newInstance());
        ft.addToBackStack(null);
        ft.commit();
    }
}
