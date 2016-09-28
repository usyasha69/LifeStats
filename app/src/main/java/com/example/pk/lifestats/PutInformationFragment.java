package com.example.pk.lifestats;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PutInformationFragment extends Fragment {
    @BindView(R.id.nameEditText) EditText nameEditText;
    @BindView(R.id.dayEditText) EditText dayEditText;
    @BindView(R.id.monthEditText) EditText monthEditText;
    @BindView(R.id.yearEditText) EditText yearEditText;
    @BindView(R.id.lifeStatsButton) Button checkLifeStatsButton;

    public static PutInformationFragment newInstance() {

        Bundle args = new Bundle();

        PutInformationFragment fragment = new PutInformationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @OnClick(R.id.lifeStatsButton)
    public void checkLifeStats() {
        if (nameEditText.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), "Please, enter the correctly name"
                    , Toast.LENGTH_SHORT).show();
            return;
        }

        if (LifeStatsInspector.dateIsCorrectly(dayEditText.getText().toString()
                , monthEditText.getText().toString(), yearEditText.getText().toString())) {
            String name = nameEditText.getText().toString();
            String day = dayEditText.getText().toString();
            String month = monthEditText.getText().toString();
            String year = yearEditText.getText().toString();

            String date = day +
                    "." +
                    month +
                    "." +
                    year;

            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.activity_main_root
                    , LifeStatsFragment.newInstance(new LifeStatsModel(name, date)));
            ft.addToBackStack(null);
            ft.commit();
        } else {
            Toast.makeText(getContext(), "Please, enter the correctly date"
                    , Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_put_information, container, false);
        ButterKnife.bind(this, view);

        return view;
    }
}
