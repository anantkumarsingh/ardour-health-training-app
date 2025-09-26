package com.app.atl_test_app_1.database;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UserDB extends SQLiteOpenHelper {


    //DONORS_TABLE
    public static final String DONORS_TABLE = "donors_table";
    public static final String DONOR_ID = "donor_id";
    public static final String DONOR_NAME = "donors_name";
    public static final String DONOR_PHONE = "donors_phone";
    public static final String DONOR_EMAIL = "donors_email";
    public static final String DONOR_ADDRESS = "donors_address";
    public static final String DONOR_DOB = "donors_dob";
    public static final String DONOR_BLOOD_GROUP = "donors_blood_group";
    public static final String DONATION_STATUS= "donation_status";


    //USERS TABLE LOGIN
    public static final String USERS_TABLE = "Users_table";
    public static final String USER_ID = "User_Id";
    public static final String USER_PWD = "User_pwd";
    public static final String USER_NAME = "User_Name";
    public static final String USER_ADDRESS = "User_Address";
    public static final String USER_MOBILE = "User_Mobile";


    public UserDB(Activity activity) {
        super(activity.getApplicationContext(), "user_db", null, 1);



    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + DONORS_TABLE +
                " (" + DONOR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                " " + DONOR_NAME + " TEXT," +
                " " + DONOR_PHONE + " TEXT," +
                " " + DONOR_ADDRESS + " TEXT," +
                " " + DONOR_EMAIL + " TEXT," +
                " " + DONOR_DOB + " TEXT," +
                " " + DONOR_BLOOD_GROUP + " TEXT," +
                " " + DONATION_STATUS + " TEXT);"

        );

        db.execSQL("CREATE TABLE " + USERS_TABLE +
                " (" + USER_ID + " TEXT PRIMARY KEY NOT NULL," +
                " " + USER_NAME + " TEXT," +
                " " + USER_ADDRESS + " TEXT," +
                " " + USER_MOBILE + " INTEGER," +
                " " + USER_PWD + " INTEGER);"
        );


    }



    public void addDonor(String donorName, String donorPhone, String donorAddress, String donorEmail, String donorDOB, String donorBloodGroup, String donationStatus) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(DONOR_NAME, donorName);
        values.put(DONOR_PHONE, donorPhone);
        values.put(DONOR_ADDRESS, donorAddress);
        values.put(DONOR_EMAIL, donorEmail);
        values.put(DONOR_DOB, donorDOB);
        values.put(DONOR_BLOOD_GROUP, donorBloodGroup);
        values.put(DONATION_STATUS, donationStatus);

        db.insert(DONORS_TABLE, null, values);
        db.close();

    }

    public boolean addUserDetails(String userId, String userName,String userAddress, String userMobile, String userPwd) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(USER_ID, userId);
        values.put(USER_NAME, userName);
        values.put(USER_ADDRESS, userAddress);
        values.put(USER_MOBILE, userMobile);
        values.put(USER_PWD, userPwd);




        db.insert(USERS_TABLE, null, values);
        db.close();

        return true;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + DONORS_TABLE);
        onCreate(db);

    }
}
