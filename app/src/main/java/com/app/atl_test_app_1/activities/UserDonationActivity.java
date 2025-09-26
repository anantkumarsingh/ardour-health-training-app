package com.app.atl_test_app_1.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.app.atl_test_app_1.R;
import com.app.atl_test_app_1.database.UserDB;
import com.app.atl_test_app_1.database.VisorDB;
import com.app.atl_test_app_1.ui.donate.DonationFragment;

import java.util.Calendar;
import java.util.Date;

public class UserDonationActivity extends AppCompatActivity {

    private EditText nameBox;
    private EditText emailBox;
    private EditText addressBox;
    private EditText phoneBox;
    private DatePicker dobBox;
    private Spinner bloodGroupSpinner;

    public String userName;
    private String userEmail;
    private String userAddress;
    private String userPhone;
    private String userDob;
    private String userBloodGroup;

    private Button signupBtn;
    SQLiteDatabase database;
    UserDB userDB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_donation);

        //INITIALIZE
        nameBox = findViewById(R.id.reg_name_box_donor);
        emailBox = findViewById(R.id.reg_email_box_donor);
        addressBox = findViewById(R.id.reg_adr_box_donor);
        phoneBox = findViewById(R.id.reg_mobile_box_donor);
        dobBox = findViewById(R.id.reg_dob_box_donor);
        bloodGroupSpinner = findViewById(R.id.reg_bg_box);
        signupBtn = findViewById(R.id.reg_signup_btn_donor);

        userDB = new UserDB(this);
        database = userDB.getWritableDatabase();


       // dobBox.setBackgroundColor(getResources().getColor(R.color.white));



        //Spinner of Blood Group
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(UserDonationActivity.this,
                R.array.blood_groups, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bloodGroupSpinner.setAdapter(adapter);

        bloodGroupSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedValue = parent.getItemAtPosition(position).toString();
                if (selectedValue=="Select Blood Group"){
                    Toast.makeText(UserDonationActivity.this, "Please Select A Blood Group", Toast.LENGTH_SHORT).show();
                }else{
                    userBloodGroup = selectedValue;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(UserDonationActivity.this, "Please Select A Blood Group", Toast.LENGTH_SHORT).show();
            }
        });




        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(nameBox.getText().toString()) || TextUtils.isEmpty(emailBox.getText().toString()) || TextUtils.isEmpty(phoneBox.getText().toString()) || dobBox.getYear() == 0 || dobBox.getMonth() == 0 || dobBox.getDayOfMonth() == 0 || TextUtils.isEmpty(bloodGroupSpinner.getSelectedItem().toString()) || TextUtils.isEmpty(addressBox.getText().toString())){

                    String message = "All Fields Are Required";
                    Toast toast =  Toast.makeText(UserDonationActivity.this, message, Toast.LENGTH_SHORT);
                    toast.show();
                    return;

                }else{


                    Calendar calendar = Calendar.getInstance();
                    calendar.set(dobBox.getYear(), dobBox.getMonth(), dobBox.getDayOfMonth());
                    Date selectedDate = calendar.getTime();

// Calculate age
                    Calendar today = Calendar.getInstance();
                    int age = today.get(Calendar.YEAR) - calendar.get(Calendar.YEAR);
                    if (today.get(Calendar.DAY_OF_YEAR) < calendar.get(Calendar.DAY_OF_YEAR)){
                        age--;
                    }

                    if (age < 18) {
                        Toast.makeText(UserDonationActivity.this, "Donor must be 18 years or above", Toast.LENGTH_SHORT).show();
                    } else {
                        //GET VALUE
                        userName = nameBox.getText().toString();
                        userEmail = emailBox.getText().toString();
                        userAddress = addressBox.getText().toString();
                        userPhone = phoneBox.getText().toString();
                        userDob=selectedDate.toString();
                        userBloodGroup = bloodGroupSpinner.getSelectedItem().toString();

                        userDB.addDonor(userName,userPhone,userAddress,userEmail,userDob,userBloodGroup,"NOT OCCUPIED");

                        Intent backPageInt = new Intent(UserDonationActivity.this, MainActivity.class);
                        backPageInt.putExtra("FRAGMENT_ID", "MY_FRAGMENT");
                        startActivity(backPageInt);

                    }





                }


            }
        });





    }

    @Override
    public void onBackPressed() {

        finish();

    }
}