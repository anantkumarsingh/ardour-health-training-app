package com.app.atl_test_app_1.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.app.atl_test_app_1.R;
import com.app.atl_test_app_1.carddata.DineoutCardData;
import com.app.atl_test_app_1.adapters.DineoutCardAdapter;

import java.util.ArrayList;
import java.util.List;

public class DineoutActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DineoutCardAdapter adapter;
    private static List<DineoutCardData> dineoutCardDataList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dineout);


        //RECYCLER VIEW & CARD
        recyclerView= findViewById(R.id.recycler_food_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        dineoutCardDataList = new ArrayList<DineoutCardData>();
        adapter = new DineoutCardAdapter(dineoutCardDataList);
        recyclerView.setAdapter(adapter);

        // Initialize the data

        dineoutCardDataList.add(new DineoutCardData("BBQ Nation","Manesar",null));
        dineoutCardDataList.add(new DineoutCardData("Yum Yum Cha","Cyberhub, Gurgaon",null));
        dineoutCardDataList.add(new DineoutCardData("Dana Choga","Sector 82",null));
        dineoutCardDataList.add(new DineoutCardData("Salad Days","Manesar",null));
        dineoutCardDataList.add(new DineoutCardData("Taco bell","Ambience, Gurgaon",null));
        dineoutCardDataList.add(new DineoutCardData("Dariyaganj","Worldmark, Gurgaon",null));
        adapter.setDineoutCardDataList(dineoutCardDataList);

        // Initialize the adapter
      //  adapter = new ActivityCardAdapter(mData);

        // Set the adapter to the RecyclerView
     //   recyclerView.setAdapter(adapter);


    }
}