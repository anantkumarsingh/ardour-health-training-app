package com.app.atl_test_app_1.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.app.atl_test_app_1.R;

public class BookAppointment extends AppCompatActivity {

    private Spinner selectDateSpinner;
    private Spinner selectTimeSpinner;
    private String docName;
    private String docSpec;
    private TextView docNameView;
    private TextView docSpecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);

        docNameView = findViewById(R.id.doctor_name_bookpage);
        docSpecView = findViewById(R.id.doctor_spec_bookpage);
        selectDateSpinner = findViewById(R.id.select_date_doctor);
        selectTimeSpinner = findViewById(R.id.select_time_doctor);




        //GET INTENT FOR WORKOUT
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                docName= null;
                docSpec= null;
            } else {
                docName= extras.getString("DOCTOR_NAME");
                docSpec= extras.getString("DOCTOR_SPECIALTY");
            }
        } else {
            docName= (String) savedInstanceState.getSerializable("DOCTOR_NAME");
            docSpec= (String) savedInstanceState.getSerializable("DOCTOR_SPECIALTY");
        }

        docNameView.setText(docName);
        docSpecView.setText(docSpec);




        ArrayAdapter<CharSequence> spinDateadapter = ArrayAdapter.createFromResource(BookAppointment.this,
                R.array.select_date, android.R.layout.simple_spinner_item);
        spinDateadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectDateSpinner.setAdapter(spinDateadapter);


        ArrayAdapter<CharSequence> spinTimeAdapter = ArrayAdapter.createFromResource(BookAppointment.this,
                R.array.select_time, android.R.layout.simple_spinner_item);
        spinTimeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectTimeSpinner.setAdapter(spinTimeAdapter);


    }
}