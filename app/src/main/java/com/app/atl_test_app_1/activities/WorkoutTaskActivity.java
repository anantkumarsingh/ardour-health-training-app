package com.app.atl_test_app_1.activities;

import static com.app.atl_test_app_1.database.VisorDB.ABS_TABLE;
import static com.app.atl_test_app_1.database.VisorDB.ABS_WORKOUT_ID;
import static com.app.atl_test_app_1.database.VisorDB.ABS_WORKOUT_NAME;
import static com.app.atl_test_app_1.database.VisorDB.ABS_WORKOUT_STATUS;
import static com.app.atl_test_app_1.database.VisorDB.ABS_WORKOUT_TASK;
import static com.app.atl_test_app_1.database.VisorDB.ARMS_TABLE;
import static com.app.atl_test_app_1.database.VisorDB.ARMS_WORKOUT_ID;
import static com.app.atl_test_app_1.database.VisorDB.ARMS_WORKOUT_NAME;
import static com.app.atl_test_app_1.database.VisorDB.ARMS_WORKOUT_STATUS;
import static com.app.atl_test_app_1.database.VisorDB.ARMS_WORKOUT_TASK;
import static com.app.atl_test_app_1.database.VisorDB.BACK_TABLE;
import static com.app.atl_test_app_1.database.VisorDB.BACK_WORKOUT_ID;
import static com.app.atl_test_app_1.database.VisorDB.BACK_WORKOUT_NAME;
import static com.app.atl_test_app_1.database.VisorDB.BACK_WORKOUT_STATUS;
import static com.app.atl_test_app_1.database.VisorDB.BACK_WORKOUT_TASK;
import static com.app.atl_test_app_1.database.VisorDB.CHEST_TABLE;
import static com.app.atl_test_app_1.database.VisorDB.CHEST_WORKOUT_ID;
import static com.app.atl_test_app_1.database.VisorDB.CHEST_WORKOUT_NAME;
import static com.app.atl_test_app_1.database.VisorDB.CHEST_WORKOUT_STATUS;
import static com.app.atl_test_app_1.database.VisorDB.CHEST_WORKOUT_TASK;
import static com.app.atl_test_app_1.database.VisorDB.LEGS_TABLE;
import static com.app.atl_test_app_1.database.VisorDB.LEGS_WORKOUT_ID;
import static com.app.atl_test_app_1.database.VisorDB.LEGS_WORKOUT_NAME;
import static com.app.atl_test_app_1.database.VisorDB.LEGS_WORKOUT_STATUS;
import static com.app.atl_test_app_1.database.VisorDB.LEGS_WORKOUT_TASK;
import static com.app.atl_test_app_1.database.VisorDB.SHOULDERS_TABLE;
import static com.app.atl_test_app_1.database.VisorDB.SHOULDERS_WORKOUT_ID;
import static com.app.atl_test_app_1.database.VisorDB.SHOULDERS_WORKOUT_NAME;
import static com.app.atl_test_app_1.database.VisorDB.SHOULDERS_WORKOUT_STATUS;
import static com.app.atl_test_app_1.database.VisorDB.SHOULDERS_WORKOUT_TASK;
import static com.app.atl_test_app_1.database.VisorDB.WARMUP_TABLE;
import static com.app.atl_test_app_1.database.VisorDB.WARMUP_WORKOUT_ID;
import static com.app.atl_test_app_1.database.VisorDB.WARMUP_WORKOUT_NAME;
import static com.app.atl_test_app_1.database.VisorDB.WARMUP_WORKOUT_STATUS;
import static com.app.atl_test_app_1.database.VisorDB.WARMUP_WORKOUT_TASK;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.app.atl_test_app_1.R;
import com.app.atl_test_app_1.database.VisorDB;

public class WorkoutTaskActivity extends AppCompatActivity {

    private TextView workoutHeading;
    private TextView workoutCardHeading;
    private TextView workoutCardTask;
    private TextView workoutTime;
    private TextView tableTaskDetails;
    private String workoutName;
    private String workoutTask;
    private String workoutID;
    private String getWorkoutQuery;
    private String columnIndexWKname;
    private String columnIndexWKtask;
    private String columnIndexWKid;
    private String columnIndexWKstatus;
    private String displayTask;
    private String displayTaskName;
    private String displayTaskID;
    private String displayTaskStatus;
    private int workoutTaskID;
    private TableLayout workoutTableLayout;
    private TableRow tr;
    VisorDB visorDB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_task);

        visorDB = new VisorDB(WorkoutTaskActivity.this);
        workoutHeading = findViewById(R.id.workout_name_headintask);
        workoutCardHeading = findViewById(R.id.workout_name_intask);
        workoutCardTask = findViewById(R.id.workout_taskCount_intask);
        workoutTime = findViewById(R.id.workout_time);


        //GET INTENT FOR WORKOUT
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                workoutName= null;
                workoutTask= null;
                workoutID="";
            } else {
                workoutName= extras.getString("WORKOUT_NAME");
                workoutTask= extras.getString("WORKOUT_TASK");
                workoutID =  extras.getString("WORKOUT_ID");
            }
        } else {
            workoutName= (String) savedInstanceState.getSerializable("WORKOUT_NAME");
            workoutTask= (String) savedInstanceState.getSerializable("WORKOUT_TASK");
            workoutID= (String) savedInstanceState.getSerializable("WORKOUT_ID");
        }

        //PARSING STR TO INT

        try {
            workoutTaskID = Integer.parseInt(workoutID.toString());
        } catch(NumberFormatException nfe) {
            System.out.println("Could not parse " + nfe);
        }


        workoutHeading.setText(workoutName);
        workoutCardHeading.setText("TRAINING: "+workoutName);
        workoutCardTask.setText("Tasks: "+workoutTask);
      //  Toast.makeText(this, workoutID, Toast.LENGTH_SHORT).show();



        //CHECK AND DISPLAY WORKOUT WITH TASK AND BUTTON
        if(workoutTaskID==1001){
            getWorkoutQuery = "select * from "+WARMUP_TABLE;
            columnIndexWKname = WARMUP_WORKOUT_NAME;
            columnIndexWKtask = WARMUP_WORKOUT_TASK;
            columnIndexWKid = WARMUP_WORKOUT_ID;
            columnIndexWKstatus = WARMUP_WORKOUT_STATUS;
        }else if(workoutTaskID==1002){
            getWorkoutQuery = "select * from "+ABS_TABLE;
            columnIndexWKname = ABS_WORKOUT_NAME;
            columnIndexWKtask = ABS_WORKOUT_TASK;
            columnIndexWKid = ABS_WORKOUT_ID;
            columnIndexWKstatus = ABS_WORKOUT_STATUS;
        }else if(workoutTaskID==1003){
            getWorkoutQuery = "select * from "+CHEST_TABLE;
            columnIndexWKname = CHEST_WORKOUT_NAME;
            columnIndexWKtask = CHEST_WORKOUT_TASK;
            columnIndexWKid = CHEST_WORKOUT_ID;
            columnIndexWKstatus = CHEST_WORKOUT_STATUS;
        }else if(workoutTaskID==1004){
            getWorkoutQuery = "select * from "+SHOULDERS_TABLE;
            columnIndexWKname = SHOULDERS_WORKOUT_NAME;
            columnIndexWKtask = SHOULDERS_WORKOUT_TASK;
            columnIndexWKid = SHOULDERS_WORKOUT_ID;
            columnIndexWKstatus = SHOULDERS_WORKOUT_STATUS;
        }else if(workoutTaskID==1005){
            getWorkoutQuery = "select * from "+ARMS_TABLE;
            columnIndexWKname = ARMS_WORKOUT_NAME;
            columnIndexWKtask = ARMS_WORKOUT_TASK;
            columnIndexWKid = ARMS_WORKOUT_ID;
            columnIndexWKstatus = ARMS_WORKOUT_STATUS;
        }else if(workoutTaskID==1006){
            getWorkoutQuery = "select * from "+BACK_TABLE;
            columnIndexWKname = BACK_WORKOUT_NAME;
            columnIndexWKtask = BACK_WORKOUT_TASK;
            columnIndexWKid = BACK_WORKOUT_ID;
            columnIndexWKstatus= BACK_WORKOUT_STATUS;
        }else if(workoutTaskID==1007){
            getWorkoutQuery = "select * from "+LEGS_TABLE;
            columnIndexWKname = LEGS_WORKOUT_NAME;
            columnIndexWKtask = LEGS_WORKOUT_TASK;
            columnIndexWKid = LEGS_WORKOUT_ID;
            columnIndexWKstatus = LEGS_WORKOUT_STATUS;
        }else{
            Toast.makeText(this, "Couldn't Fetch Workout", Toast.LENGTH_SHORT).show();
        }

        //FETCHING DATA FROM DB
        Cursor cursorWorkoutDisplay = visorDB.getReadableDatabase().rawQuery(getWorkoutQuery,null);
        if (cursorWorkoutDisplay.moveToFirst()) {
            while (!cursorWorkoutDisplay.isAfterLast()) {

                displayTask = cursorWorkoutDisplay.getString(cursorWorkoutDisplay.getColumnIndexOrThrow(columnIndexWKtask));
                displayTaskName = cursorWorkoutDisplay.getString(cursorWorkoutDisplay.getColumnIndexOrThrow(columnIndexWKname));
                displayTaskID = cursorWorkoutDisplay.getString(cursorWorkoutDisplay.getColumnIndexOrThrow(columnIndexWKid));
                displayTaskStatus = cursorWorkoutDisplay.getString(cursorWorkoutDisplay.getColumnIndexOrThrow(columnIndexWKstatus));

                workoutTableLayout = findViewById(R.id.workout_tasks_table);

                tr = new TableRow(this);
                tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));
                tr.setWeightSum(1);
              //  tr.setPadding(,15,3,15);

                TextView taskView = new TextView(this);
                taskView.setText(displayTaskName+"\n\n"+displayTask+"\n---------------------------------------------------------");
                taskView.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                taskView.setMaxLines(10000);
                taskView.setPadding(80,80,80,80);
                workoutTableLayout.setBaselineAligned(false);
                taskView.setTextColor(Color.BLACK);
                // taskView.setEllipsize(TextUtils.TruncateAt.END);
                tr.addView(taskView);



                if(displayTaskStatus.equals("YES")){

                    TextView textView3 = new TextView(this);
                    textView3.setText("Answer Submitted");
                    textView3.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                    textView3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    tr.addView(textView3);

                }else{

                    RadioButton statusRadioBtn = new RadioButton(this);
                    statusRadioBtn.setId(Integer.parseInt(displayTaskID));
                    statusRadioBtn.setId(Integer.parseInt(displayTaskID));
                    statusRadioBtn.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                    // statusRadioBtn.setTextColor(Color.parseColor("#FFFFFF"));
                    // actionBtn.setOnClickListener(this);
                   // tr.addView(statusRadioBtn);
                }



                workoutTableLayout.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));

                cursorWorkoutDisplay.moveToNext();
            }
        }





    }

    @Override
    public void onBackPressed() {

        finish();

    }

}