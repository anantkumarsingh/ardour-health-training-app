package com.app.atl_test_app_1.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.app.atl_test_app_1.R;
import com.app.atl_test_app_1.adapters.DoctorCardAdapter;
import com.app.atl_test_app_1.adapters.WorkoutCardAdapter;
import com.app.atl_test_app_1.carddata.DoctorCardData;
import com.app.atl_test_app_1.carddata.WorkoutCardData;
import com.app.atl_test_app_1.database.VisorDB;

import java.util.ArrayList;
import java.util.List;

public class AppointmentActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DoctorCardAdapter adapter;
    private String statusNotCompleted;

    CardView cardiologycard;
    CardView psychocard;
    CardView gynecard;
    CardView dermacard;


    VisorDB visorDB;
    public static List<DoctorCardData> doctorCardDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        visorDB = new VisorDB(this);
        //RECYCLER VIEW & CARD
        recyclerView= findViewById(R.id.recycler_view_doctors);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        doctorCardDataList = new ArrayList<DoctorCardData>();
        adapter = new DoctorCardAdapter(doctorCardDataList);
        recyclerView.setAdapter(adapter);


        // Initialize the data
        doctorCardDataList.add(new DoctorCardData("Dr. Ana Grewal", "Spine Surgeon",null));
        doctorCardDataList.add(new DoctorCardData("Dr. Shantanu Singh", "Dental Specialist",null));
        doctorCardDataList.add(new DoctorCardData("Dr. Karthik Khurana", "Therapist",null));
        doctorCardDataList.add(new DoctorCardData("Dr. Ankit Talwar", "Cardiologist",null));
        doctorCardDataList.add(new DoctorCardData("Dr. Rohan Sethi", "Heart Surgeon",null));
        doctorCardDataList.add(new DoctorCardData("Dr. Priya Aggarwal", "Psychiatrist",null));
        adapter.setDoctorCardList(doctorCardDataList);


    }
}