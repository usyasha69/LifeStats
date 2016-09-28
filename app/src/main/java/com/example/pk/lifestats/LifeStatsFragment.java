package com.example.pk.lifestats;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LifeStatsFragment extends Fragment {
    @BindView(R.id.nameStatsTextView) TextView nameTextView;
    @BindView(R.id.yearStatsTextView) TextView yearTextView;
    @BindView(R.id.dayStatsTextView) TextView dayTextView;
    @BindView(R.id.secondStatsTextView) TextView secondsTextView;
    @BindView(R.id.zodiacSignTextView) TextView zodiacSignTextView;

    private LifeStatsModel lifeStatsModel;

    public static LifeStatsFragment newInstance(LifeStatsModel lifeStatsModel) {

        Bundle args = new Bundle();
        args.putSerializable(MainActivity.LIFE_STATS_KEY, lifeStatsModel);

        LifeStatsFragment fragment = new LifeStatsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null && getArguments().containsKey(MainActivity.LIFE_STATS_KEY)) {
            lifeStatsModel = (LifeStatsModel)
                    getArguments().getSerializable(MainActivity.LIFE_STATS_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_life_stats, container, false);
        ButterKnife.bind(this, view);

        fillingTextViews();

        return view;
    }

    /**
     * This method filling text views life stats.
     */
    private void fillingTextViews() {
        LifeStatsCalculator lifeStatsCalculator = new LifeStatsCalculator();

        int lifeStatsYear = lifeStatsCalculator.getLifeStatsYears(lifeStatsModel.getDate());
        long lifeStatsDay = lifeStatsCalculator.getLifeStatsDays(lifeStatsModel.getDate());
        long lifeStatsSecond = lifeStatsCalculator.getLifeStatsSeconds(lifeStatsModel.getDate());
        String zodiacSign = lifeStatsCalculator.getZodiacSign(lifeStatsModel.getDate());

        nameTextView.setText(String.format("Your name: %s", lifeStatsModel.getName()));
        yearTextView.setText(String.valueOf("You lived: " + lifeStatsYear + " years"));
        dayTextView.setText(String.valueOf("You lived: " + lifeStatsDay + " days"));
        secondsTextView.setText(String.valueOf("You lived: " + lifeStatsSecond + " seconds"));
        zodiacSignTextView.setText(String.format("Your zodiac sign: %s", zodiacSign));
    }

}
