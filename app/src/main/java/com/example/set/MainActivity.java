package com.example.set;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Mission> missions = new ArrayList<>();
    private List<Set> sets = new ArrayList<>();
    private RecyclerView rvSet;
    private SetAdapter setAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        setControl();

        setAdapter = new SetAdapter(sets, MainActivity.this);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        rvSet.setLayoutManager(layoutManager);

        rvSet.setAdapter(setAdapter);
    }

    private void initData() {
        missions.add(new Mission("ms001", "Skipping", "15x", "https://cdn2.stylecraze.com/wp-content/uploads/2014/07/Is-Rope-Jumping-Good-For-Health-Benefits-And-Precautions.jpg"));
        missions.add(new Mission("ms002", "Squats", "20x", "https://hips.hearstapps.com/hmg-prod/images/squat-jump-squat-178-1653334247.jpg?crop=0.574xw:0.863xh;0.204xw,0.137xh&resize=1200:*"));
        missions.add(new Mission("ms003", "Arm Raise", "00:53", "https://www.verywellfit.com/thmb/VAhObEJ06XnI1wynb7eYMOE-cQo=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/Frontraise-89445714d65d4c99a449e20aaa5bbadb.jpg"));
        missions.add(new Mission("ms004", "Rest and Drink", "02:00", "https://media.istockphoto.com/id/1094504278/photo/man-drinking-water-after-training-in-gym.jpg?s=612x612&w=0&k=20&c=7ewlyWMQZ6KIPagu3V4pZnWfCYBDXecW5ILHN3i18Mc="));

        sets.add(new Set("set001", "Set 1", missions));
        sets.add(new Set("set002", "Set 2", missions));
        sets.add(new Set("set003", "Set 3", missions));
    }

    private void setControl() {
        rvSet = findViewById(R.id.rvSet);
    }
}
