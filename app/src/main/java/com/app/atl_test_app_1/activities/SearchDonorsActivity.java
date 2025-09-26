package com.app.atl_test_app_1.activities;

import static com.app.atl_test_app_1.database.UserDB.DONORS_TABLE;
import static com.app.atl_test_app_1.database.UserDB.DONOR_ADDRESS;
import static com.app.atl_test_app_1.database.UserDB.DONOR_BLOOD_GROUP;
import static com.app.atl_test_app_1.database.UserDB.DONOR_DOB;
import static com.app.atl_test_app_1.database.UserDB.DONOR_EMAIL;
import static com.app.atl_test_app_1.database.UserDB.DONOR_NAME;
import static com.app.atl_test_app_1.database.UserDB.DONOR_PHONE;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import static com.app.atl_test_app_1.database.VisorDB.LEGS_TABLE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.app.atl_test_app_1.R;
import com.app.atl_test_app_1.adapters.DonorCardAdapter;
import com.app.atl_test_app_1.adapters.TrainingCardAdapter;
import com.app.atl_test_app_1.carddata.DonorCardData;
import com.app.atl_test_app_1.carddata.TrainingCardData;
import com.app.atl_test_app_1.database.UserDB;
import com.app.atl_test_app_1.database.VisorDB;

import java.util.ArrayList;
import java.util.List;

public class SearchDonorsActivity extends AppCompatActivity {

    private Spinner bloodGroupSpinner;
    private RecyclerView recyclerView;
    private String userBloodGroup;
    private String displayDonorName;
    private String displayDonorEmail;
    private String displayDonorDOB;
    private String displayDonorPhone;
    private String displayDonorAddress;
    private String displayDonorBG;
    private String getDonorQuery;
    private DonorCardAdapter adapter;
    private Button searchBtn;
    public static List<DonorCardData> donorCardDataList;
    UserDB userDB;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_donors);

        bloodGroupSpinner = findViewById(R.id.search_donor_bg);
        recyclerView = findViewById(R.id.recycler_donor_items);
        userDB = new UserDB(SearchDonorsActivity.this);
        searchBtn = findViewById(R.id.search_btn_bg);


        recyclerView= findViewById(R.id.recycler_donor_items);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        donorCardDataList = new ArrayList<DonorCardData>();
        adapter = new DonorCardAdapter(donorCardDataList);
        recyclerView.setAdapter(adapter);


        ArrayAdapter<CharSequence> spinadapter = ArrayAdapter.createFromResource(SearchDonorsActivity.this,
                R.array.blood_groups, android.R.layout.simple_spinner_item);
        spinadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bloodGroupSpinner.setAdapter(spinadapter);

        //CHECK IF DATA ALREADY THERE
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        boolean dataAddedBefore = prefs.getBoolean("dataAddedBefore", false);



        //ADDING SOME DEFAULT VALUES TO DISPLAY SOME DATA
        if (!dataAddedBefore) {
            userDB.addDonor("Raman Aggarwal","9926372186","DLF Phase IV","email1@gmail.com","04/05/1993","A+","NOT OCCUPIED");
            userDB.addDonor("Saksham Singh","9916273646","Sector 82, Gurgaon","email2@gmail.com","23/05/2000","A-","NOT OCCUPIED");
            userDB.addDonor("Avigyan Das","8836294738","Sushant Lok, Gurgaon","email3@gmail.com","16/03/97","O-","NOT OCCUPIED");
            userDB.addDonor("Krishna Kapoor","8829304765","Rajouri Gardent, New Delhi","email4@gmail.com","27/09/2002","A+","NOT OCCUPIED");
            userDB.addDonor("Poornima Singh","9836283745","Nehru Place, New Delhi","email5@gmail.com","25/03/2004","O+","NOT OCCUPIED");
            userDB.addDonor("Ethan S. Krishnan","7389274895","DLF Primus, Gurgaon","email6@gmail.com","17/06/1983","AB+","NOT OCCUPIED");
            userDB.addDonor("Heema Singhal","8573948695","Bestech Grand Spa, Gurgaon","email7@gmail.com","18/01/1987","AB-","NOT OCCUPIED");
            userDB.addDonor("Pratham Sabarwal","9845786457","Sector 14, Gurgaon","email8@gmail.com","30/07/1980","B+","NOT OCCUPIED");

            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("dataAddedBefore", true);
            editor.apply();
        }




        getDonorQuery = "select * from "+DONORS_TABLE;
        Cursor cursorDonorDisplay = userDB.getReadableDatabase().rawQuery(getDonorQuery,null);
        if (cursorDonorDisplay.moveToFirst()) {
            while (!cursorDonorDisplay.isAfterLast()) {

                displayDonorName = cursorDonorDisplay.getString(cursorDonorDisplay.getColumnIndexOrThrow(DONOR_NAME));
                displayDonorEmail = cursorDonorDisplay.getString(cursorDonorDisplay.getColumnIndexOrThrow(DONOR_EMAIL));
                displayDonorDOB = cursorDonorDisplay.getString(cursorDonorDisplay.getColumnIndexOrThrow(DONOR_DOB));
                displayDonorPhone = cursorDonorDisplay.getString(cursorDonorDisplay.getColumnIndexOrThrow(DONOR_PHONE));
                displayDonorAddress = cursorDonorDisplay.getString(cursorDonorDisplay.getColumnIndexOrThrow(DONOR_ADDRESS));
                displayDonorBG = cursorDonorDisplay.getString(cursorDonorDisplay.getColumnIndexOrThrow(DONOR_BLOOD_GROUP));


                donorCardDataList.add(new DonorCardData(displayDonorName,displayDonorEmail,displayDonorDOB,"+91 "+displayDonorPhone,displayDonorAddress,displayDonorBG));
                adapter.setDonorCardDataList(donorCardDataList);
                //recyclerView.setAdapter(adapter);


                cursorDonorDisplay.moveToNext();
            }
        }


        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                showRecyclerViewBG();


            }
        });




    }

    private void showRecyclerViewBG(){

        String userbg = bloodGroupSpinner.getSelectedItem().toString();
        userBloodGroup = userbg;
      //  Toast.makeText(SearchDonorsActivity.this, userBloodGroup, Toast.LENGTH_SHORT).show();



        getDonorQuery = "select * from "+DONORS_TABLE+" where "+DONOR_BLOOD_GROUP+" ='"+userBloodGroup+"'";
        //Toast.makeText(SearchDonorsActivity.this, getDonorQuery, Toast.LENGTH_SHORT).show();
        Cursor  cursorDonorDisplay = userDB.getReadableDatabase().rawQuery(getDonorQuery, null);
        donorCardDataList.clear(); // clear old data from the list
        if (cursorDonorDisplay.moveToFirst()) {
            do {
                displayDonorName = cursorDonorDisplay.getString(cursorDonorDisplay.getColumnIndexOrThrow(DONOR_NAME));
                displayDonorEmail = cursorDonorDisplay.getString(cursorDonorDisplay.getColumnIndexOrThrow(DONOR_EMAIL));
                displayDonorDOB = cursorDonorDisplay.getString(cursorDonorDisplay.getColumnIndexOrThrow(DONOR_DOB));
                displayDonorPhone = cursorDonorDisplay.getString(cursorDonorDisplay.getColumnIndexOrThrow(DONOR_PHONE));
                displayDonorAddress = cursorDonorDisplay.getString(cursorDonorDisplay.getColumnIndexOrThrow(DONOR_ADDRESS));
                displayDonorBG = cursorDonorDisplay.getString(cursorDonorDisplay.getColumnIndexOrThrow(DONOR_BLOOD_GROUP));

                donorCardDataList.add(new DonorCardData(displayDonorName,displayDonorEmail,displayDonorDOB,displayDonorPhone,displayDonorAddress,displayDonorBG));
                adapter.setDonorCardDataList(donorCardDataList);
            } while (cursorDonorDisplay.moveToNext());
        }

        cursorDonorDisplay.close();

        adapter.notifyDataSetChanged();



    }

    @Override
    public void onBackPressed() {

        finish();

    }

}