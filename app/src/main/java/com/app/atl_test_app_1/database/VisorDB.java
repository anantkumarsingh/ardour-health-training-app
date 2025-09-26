package com.app.atl_test_app_1.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Date;

public class VisorDB extends SQLiteOpenHelper {

    //TOTAL WORKOUTS
    public static final String WORKOUT_TABLE = "workout_table";
    public static final String WORKOUT_ID = "workout_ID";
    public static final String WORKOUT_NAME = "workout_name";
    public static final String WORKOUT_TASK = "workout_task";
    public static final String WORKOUT_TIME = "workout_time";
    public static final String WORKOUT_STATUS = "workout_status";

    //CHEST TABLE
    public static final String CHEST_TABLE = "chest_table";
    public static final String CHEST_WORKOUT_ID = "chest_workout_ID";
    public static final String CHEST_WORKOUT_NAME = "chest_workout_name";
    public static final String CHEST_WORKOUT_TASK = "chest_workout_task";
    public static final String CHEST_WORKOUT_STATUS = "chest_workout_status";

    //WARMUP TABLE
    public static final String WARMUP_TABLE = "warmup_warmup_table";
    public static final String WARMUP_WORKOUT_ID = "warmup_workout_ID";
    public static final String WARMUP_WORKOUT_NAME = "warmup_workout_name";
    public static final String WARMUP_WORKOUT_TASK = "warmup_workout_task";
    public static final String WARMUP_WORKOUT_STATUS = "warmup_workout_status";

    //ABS TABLE
    public static final String ABS_TABLE = "abs_table";
    public static final String ABS_WORKOUT_ID = "abs_workout_ID";
    public static final String ABS_WORKOUT_NAME = "abs_workout_name";
    public static final String ABS_WORKOUT_TASK = "abs_workout_task";
    public static final String ABS_WORKOUT_STATUS = "abs_workout_status";

    //LEGS TABLE
    public static final String LEGS_TABLE = "legs_table";
    public static final String LEGS_WORKOUT_ID = "legs_workout_ID";
    public static final String LEGS_WORKOUT_NAME = "legs_workout_name";
    public static final String LEGS_WORKOUT_TASK = "legs_workout_task";
    public static final String LEGS_WORKOUT_STATUS = "legs_workout_status";

    //SHOULDERS TABLE
    public static final String SHOULDERS_TABLE = "shoulders_table";
    public static final String SHOULDERS_WORKOUT_ID = "shoulders_workout_ID";
    public static final String SHOULDERS_WORKOUT_NAME = "shoulders_workout_name";
    public static final String SHOULDERS_WORKOUT_TASK = "shoulders_workout_task";
    public static final String SHOULDERS_WORKOUT_STATUS = "shoulders_workout_status";

    //BACK TABLE
    public static final String BACK_TABLE = "back_table";
    public static final String BACK_WORKOUT_ID = "back_workout_ID";
    public static final String BACK_WORKOUT_NAME = "back_workout_name";
    public static final String BACK_WORKOUT_TASK = "back_workout_task";
    public static final String BACK_WORKOUT_STATUS = "back_workout_status";

    //ARMS TABLE
    public static final String ARMS_TABLE = "arms_table";
    public static final String ARMS_WORKOUT_ID = "arms_workout_ID";
    public static final String ARMS_WORKOUT_NAME = "arms_workout_name";
    public static final String ARMS_WORKOUT_TASK = "arms_workout_task";
    public static final String ARMS_WORKOUT_STATUS = "arms_workout_status";




    //LOGIN TABLE
    //DONORS_TABLE
    public static final String USERS_TABLE = "users_table";
    public static final String USER_NAME = "user_name";
    public static final String USER_EMAIL = "user_email";



    public VisorDB(@Nullable Context context) {
        super(context, "visorDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + USERS_TABLE +
                " (" + USER_NAME + " TEXT," +
                " " + USER_EMAIL + " TEXT);"

        );


        db.execSQL("CREATE TABLE " + WORKOUT_TABLE +
                " (" + WORKOUT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                " " + WORKOUT_NAME + " TEXT," +
                " " + WORKOUT_TASK + " TEXT," +
                " " + WORKOUT_TIME + " INTEGER," +
                " " + WORKOUT_STATUS + " TEXT);"

        );


        db.execSQL("CREATE TABLE " + CHEST_TABLE +
                " (" + CHEST_WORKOUT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                " " + CHEST_WORKOUT_NAME + " TEXT," +
                " " + CHEST_WORKOUT_TASK + " TEXT," +
                " " + CHEST_WORKOUT_STATUS + " TEXT);"

        );

        db.execSQL("CREATE TABLE " + LEGS_TABLE +
                " (" + LEGS_WORKOUT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                " " + LEGS_WORKOUT_NAME + " TEXT," +
                " " + LEGS_WORKOUT_TASK + " TEXT," +
                " " + LEGS_WORKOUT_STATUS + " TEXT);"

        );

        db.execSQL("CREATE TABLE " + WARMUP_TABLE +
                " (" + WARMUP_WORKOUT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                " " + WARMUP_WORKOUT_NAME + " TEXT," +
                " " + WARMUP_WORKOUT_TASK + " TEXT," +
                " " + WARMUP_WORKOUT_STATUS + " TEXT);"

        );

        db.execSQL("CREATE TABLE " + SHOULDERS_TABLE +
                " (" + SHOULDERS_WORKOUT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                " " + SHOULDERS_WORKOUT_NAME + " TEXT," +
                " " + SHOULDERS_WORKOUT_TASK + " TEXT," +
                " " + SHOULDERS_WORKOUT_STATUS + " TEXT);"

        );

        db.execSQL("CREATE TABLE " + ABS_TABLE +
                " (" + ABS_WORKOUT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                " " + ABS_WORKOUT_NAME + " TEXT," +
                " " + ABS_WORKOUT_TASK + " TEXT," +
                " " + ABS_WORKOUT_STATUS + " TEXT);"

        );

        db.execSQL("CREATE TABLE " + BACK_TABLE +
                " (" + BACK_WORKOUT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                " " + BACK_WORKOUT_NAME + " TEXT," +
                " " + BACK_WORKOUT_TASK + " TEXT," +
                " " + BACK_WORKOUT_STATUS + " TEXT);"

        );

        db.execSQL("CREATE TABLE " + ARMS_TABLE +
                " (" + ARMS_WORKOUT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                " " + ARMS_WORKOUT_NAME + " TEXT," +
                " " + ARMS_WORKOUT_TASK + " TEXT," +
                " " + ARMS_WORKOUT_STATUS + " TEXT);"

        );





    }



    public void addUser(String userName, String userEmail) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(USER_NAME, userName);
        values.put(USER_EMAIL, userEmail);


        db.insert(USERS_TABLE, null, values);
        db.close();

    }


    public void addWorkout(Integer workoutId, String workoutName, String workoutTask, String workoutTime,String workoutStatus) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(WORKOUT_ID, workoutId);
        values.put(WORKOUT_NAME, workoutName);
        values.put(WORKOUT_TASK, workoutTask);
        values.put(WORKOUT_TIME, workoutTime);
        values.put(WORKOUT_STATUS, workoutStatus);



        db.insert(WORKOUT_TABLE, null, values);
        db.close();

    }

    public void addLegsWorkout(Integer legsWorkoutId, String legsWorkoutName, String legsWorkoutTask,String legsWorkoutStatus) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(LEGS_WORKOUT_ID, legsWorkoutId);
        values.put(LEGS_WORKOUT_NAME, legsWorkoutName);
        values.put(LEGS_WORKOUT_TASK, legsWorkoutTask);
        values.put(LEGS_WORKOUT_STATUS, legsWorkoutStatus);



        db.insert(LEGS_TABLE, null, values);
        db.close();

    }

    public void addBackWorkout(Integer backWorkoutId, String backWorkoutName, String backWorkoutTask,String backWorkoutStatus) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(BACK_WORKOUT_ID, backWorkoutId);
        values.put(BACK_WORKOUT_NAME, backWorkoutName);
        values.put(BACK_WORKOUT_TASK, backWorkoutTask);
        values.put(BACK_WORKOUT_STATUS, backWorkoutStatus);



        db.insert(BACK_TABLE, null, values);
        db.close();

    }

    public void addShouldersWorkout(Integer shouldersWorkoutId, String shouldersWorkoutName, String shouldersWorkoutTask,String shouldersWorkoutStatus) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(SHOULDERS_WORKOUT_ID, shouldersWorkoutId);
        values.put(SHOULDERS_WORKOUT_NAME, shouldersWorkoutName);
        values.put(SHOULDERS_WORKOUT_TASK, shouldersWorkoutTask);
        values.put(SHOULDERS_WORKOUT_STATUS, shouldersWorkoutStatus);



        db.insert(SHOULDERS_TABLE, null, values);
        db.close();

    }

    public void addArmsWorkout(Integer armsWorkoutId, String armsWorkoutName, String armsWorkoutTask,String armsWorkoutStatus) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(ARMS_WORKOUT_ID, armsWorkoutId);
        values.put(ARMS_WORKOUT_NAME, armsWorkoutName);
        values.put(ARMS_WORKOUT_TASK, armsWorkoutTask);
        values.put(ARMS_WORKOUT_STATUS, armsWorkoutStatus);



        db.insert(ARMS_TABLE, null, values);
        db.close();

    }

    public void addWarmupWorkout(Integer warmupWorkoutId, String warmupWorkoutName, String warmupWorkoutTask,String warmupWorkoutStatus) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(WARMUP_WORKOUT_ID, warmupWorkoutId);
        values.put(WARMUP_WORKOUT_NAME, warmupWorkoutName);
        values.put(WARMUP_WORKOUT_TASK, warmupWorkoutTask);
        values.put(WARMUP_WORKOUT_STATUS, warmupWorkoutStatus);



        db.insert(WARMUP_TABLE, null, values);
        db.close();

    }

    public void addAbsWorkout(Integer absWorkoutId, String absWorkoutName, String absWorkoutTask,String absWorkoutStatus) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(ABS_WORKOUT_ID, absWorkoutId);
        values.put(ABS_WORKOUT_NAME, absWorkoutName);
        values.put(ABS_WORKOUT_TASK, absWorkoutTask);
        values.put(ABS_WORKOUT_STATUS, absWorkoutStatus);



        db.insert(ABS_TABLE, null, values);
        db.close();

    }

    public void addChestWorkout(Integer chestWorkoutId, String chestWorkoutName, String chestWorkoutTask,String chestWorkoutStatus) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(CHEST_WORKOUT_ID, chestWorkoutId);
        values.put(CHEST_WORKOUT_NAME, chestWorkoutName);
        values.put(CHEST_WORKOUT_TASK, chestWorkoutTask);
        values.put(CHEST_WORKOUT_STATUS, chestWorkoutStatus);



        db.insert(CHEST_TABLE, null, values);
        db.close();

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + WORKOUT_TABLE);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " + CHEST_TABLE);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " + LEGS_TABLE);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " + SHOULDERS_TABLE);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " + BACK_TABLE);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " + ARMS_TABLE);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " + ABS_TABLE);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " + WARMUP_TABLE);
        onCreate(db);



    }

    public SQLiteDatabase getReadableDatabase() {
        return super.getReadableDatabase();
    }

    public void cleardb() {

        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DELETE FROM " + WORKOUT_TABLE);
        db.execSQL("DELETE FROM " + CHEST_TABLE);
        db.execSQL("DELETE FROM " + LEGS_TABLE);
        db.execSQL("DELETE FROM " + SHOULDERS_TABLE);
        db.execSQL("DELETE FROM " + BACK_TABLE);
        db.execSQL("DELETE FROM " + ARMS_TABLE);
        db.execSQL("DELETE FROM " + ABS_TABLE);
        db.execSQL("DELETE FROM " + WARMUP_TABLE);

    }
}
