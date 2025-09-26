package com.app.atl_test_app_1.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.app.atl_test_app_1.R;
import com.app.atl_test_app_1.adapters.ActivityCardAdapter;
import com.app.atl_test_app_1.carddata.ActivityCardData;

import java.util.ArrayList;
import java.util.List;

public class HospitalsActivity extends AppCompatActivity {

    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    private ActivityCardAdapter adapter;
    public static List<ActivityCardData> cardDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitals);

        //RECYCLER VIEW & CARD
        recyclerView1 = findViewById(R.id.recycler_view_gmap);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        cardDataList = new ArrayList<ActivityCardData>();
        adapter = new ActivityCardAdapter(cardDataList);
        recyclerView1.setAdapter(adapter);


        //RECYCLER 2
        recyclerView2 = findViewById(R.id.recycler_view_saved);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        recyclerView2.setAdapter(adapter);

        // You can add your own data to the adapter
        addDataToAdapter();


    }

    private void addDataToAdapter() {

        cardDataList.add(new ActivityCardData("Medanta: The Medicity", "DLF Phase IV",null));
        cardDataList.add(new ActivityCardData("Max Hospital", "Sushant Lok, Gurgaon",null));
        cardDataList.add(new ActivityCardData("La Midas Hospital", "DLF Phase 3, Gurgaon",null));
        cardDataList.add(new ActivityCardData("Paras Hospital", "Sushant Lok, Gurgaon",null));
        cardDataList.add(new ActivityCardData("CK Birla", "Mayfield Garden, Gurgaon",null));
        adapter.setCardActDataList(cardDataList);
    }

    @Override
    public void onBackPressed() {

        finish();

    }

}