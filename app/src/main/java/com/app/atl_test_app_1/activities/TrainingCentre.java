package com.app.atl_test_app_1.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import android.os.Bundle;

import com.app.atl_test_app_1.R;
import com.app.atl_test_app_1.adapters.TrainingCardAdapter;
import com.app.atl_test_app_1.carddata.TrainingCardData;

import java.util.ArrayList;
import java.util.List;

public class TrainingCentre extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TrainingCardAdapter adapter;
    public static List<TrainingCardData> trainingCardDataList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_centre);


        //RECYCLER VIEW & CARD
        recyclerView= findViewById(R.id.recycler_trainingCentre_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        trainingCardDataList = new ArrayList<TrainingCardData>();
        adapter = new TrainingCardAdapter(trainingCardDataList);
        recyclerView.setAdapter(adapter);

        // Initialize the data

        trainingCardDataList.add(new TrainingCardData("Hype The Gym","Manesar",null));
        trainingCardDataList.add(new TrainingCardData("Ahtlete X","Cyberhub, Gurgaon",null));
        trainingCardDataList.add(new TrainingCardData("Elysium","Sector 82",null));
        trainingCardDataList.add(new TrainingCardData("Gold's Gym","Manesar",null));
        adapter.setTrainingCardDataList(trainingCardDataList);


    }

    @Override
    public void onBackPressed() {

        finish();

    }
}