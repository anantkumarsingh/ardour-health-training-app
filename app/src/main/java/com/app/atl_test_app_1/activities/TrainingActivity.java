package com.app.atl_test_app_1.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.app.atl_test_app_1.R;
import com.app.atl_test_app_1.adapters.TrainingCardAdapter;
import com.app.atl_test_app_1.adapters.WorkoutCardAdapter;
import com.app.atl_test_app_1.carddata.TrainingCardData;
import com.app.atl_test_app_1.carddata.WorkoutCardData;
import com.app.atl_test_app_1.database.VisorDB;

import java.util.ArrayList;
import java.util.List;

public class TrainingActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private WorkoutCardAdapter adapter;
    private String statusNotCompleted;

    CardView blog1Card;
    CardView blog2Card;


    VisorDB visorDB;
    public static List<WorkoutCardData> workoutCardDataList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        visorDB = new VisorDB(TrainingActivity.this);
        statusNotCompleted = "NO";



        //RECYCLER VIEW & CARD
        recyclerView= findViewById(R.id.recycler_view_workouts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        workoutCardDataList = new ArrayList<WorkoutCardData>();
        adapter = new WorkoutCardAdapter(workoutCardDataList);
        recyclerView.setAdapter(adapter);


        blog1Card = findViewById(R.id.blog_1_card);
        blog1Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent blogIntent = new Intent(TrainingActivity.this, BlogActivity.class);
                blogIntent.putExtra("CHECK_BLOG","OVERCOME_MOTIVATION");
                startActivity(blogIntent);
            }
        });

        blog2Card = findViewById(R.id.blog_2_card);
        blog2Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent blogIntent = new Intent(TrainingActivity.this, BlogActivity.class);
                blogIntent.putExtra("CHECK_BLOG","MUSCLE_RECOVERY");
                startActivity(blogIntent);
            }
        });




        // Initialize the data
        workoutCardDataList.add(new WorkoutCardData("Warm Up","8 Tasks",null,"1001"));
        workoutCardDataList.add(new WorkoutCardData("Abs & Core","5 Tasks",null,"1002"));
        workoutCardDataList.add(new WorkoutCardData("Chest","6 Tasks",null,"1003"));
        workoutCardDataList.add(new WorkoutCardData("Shoulders","6 Tasks",null,"1004"));
        workoutCardDataList.add(new WorkoutCardData("Arms","6 Tasks",null,"1005"));
        workoutCardDataList.add(new WorkoutCardData("Back","6 Tasks",null,"1006"));
        workoutCardDataList.add(new WorkoutCardData("Legs","5 Tasks",null,"1007"));
        adapter.setWorkoutCardDataList(workoutCardDataList);

        //ADDING WORKOUT CATEGORIES
        visorDB.addWorkout(1,"Warm Up","8 Tasks","20 Mins",statusNotCompleted);
        visorDB.addWorkout(2,"Abs & Core","5 Tasks","40 Mins",statusNotCompleted);
        visorDB.addWorkout(3,"Chest","6 Tasks","90 Mins",statusNotCompleted);
        visorDB.addWorkout(4,"Shoulders","6 Tasks","90 Mins",statusNotCompleted);
        visorDB.addWorkout(5,"Arms","6 Tasks","90 Mins",statusNotCompleted);
        visorDB.addWorkout(6,"Back","6 Tasks","90 Mins",statusNotCompleted);
        visorDB.addWorkout(7,"Legs","5 Tasks","90 Mins",statusNotCompleted);


        //ADDING WARMUP WORKOUT
        visorDB.addWarmupWorkout(1,"Fast-Paced Walk","1 Set of 3 Mins with 30-45s Rest",statusNotCompleted);
        visorDB.addWarmupWorkout(2,"Plantar Fascia w/ Lacrosse Ball","1 Set of 15 reps, Each Foot with 30-45s Rest",statusNotCompleted);
        visorDB.addWarmupWorkout(3,"Donkey Calf Raise","1 Set of 15 reps with 30-45s Rest",statusNotCompleted);
        visorDB.addWarmupWorkout(4,"Dumbbell Goblet Squat","1 Set of 15 reps with 30-45s Rest",statusNotCompleted);
        visorDB.addWarmupWorkout(5,"Bodyweight Walking Lunge","1 Set of 10 reps, Each Leg with 30-45s Rest",statusNotCompleted);
        visorDB.addWarmupWorkout(6,"Side Plank","1 Set of 30s, Each Side with 30-45s Rest",statusNotCompleted);
        visorDB.addWarmupWorkout(7,"Plyometric Push Up","1 Set of 15 reps with 30-45s Rest",statusNotCompleted);
        visorDB.addWarmupWorkout(8,"Rack Lat Stretch","1 Set of 30s with 30-45s Rest",statusNotCompleted);


        //ADDING CHEST WORKOUT
        visorDB.addChestWorkout(1,"Barbell Bench Press","4 sets of 6,8,10,12 reps, Immediately into a horizontal chest cable or band crossover for 15 reps",statusNotCompleted);
        visorDB.addChestWorkout(2,"Incline DB Bench Press","4 sets of 6,8,10,12 reps, Immediately into a low to high cable or band crossover for 15 reps",statusNotCompleted);
        visorDB.addChestWorkout(3,"Weighted/ Bodyweight Dips","4 sets of 6,8,10,12 reps, Immediately into a high to low cable or band crossover for 15 reps",statusNotCompleted);
        visorDB.addChestWorkout(4,"Pushups","3 sets to Failure, Immediately into a banded crossover pushup for 15 reps with band on each arm",statusNotCompleted);
        visorDB.addChestWorkout(5,"Incline DB Flyes","3 sets of 10-12 reps, Each with 60-90s Rest",statusNotCompleted);
        visorDB.addChestWorkout(6,"Cable Crossover","4 sets of 10-12 reps, Each with 30-40s Rest",statusNotCompleted);


        //ADDING LEGS WORKOUT
        visorDB.addLegsWorkout(1,"Squats","4 sets of 8-12 reps, with suitable weight or only bodyweight, 40-60s rest between sets",statusNotCompleted);
        visorDB.addLegsWorkout(2,"Leg Curls","3 sets of 10 reps, with suitable weight, 40-60s rest between sets",statusNotCompleted);
        visorDB.addLegsWorkout(3,"Romanian Deadlift (RDL)","4 sets of 10-12 reps, with suitable weight , 60-90s rest between sets",statusNotCompleted);
        visorDB.addLegsWorkout(4,"Bulgarian Split Squats","3 sets to Failure, with suitable weight, 30-40s rest between sets",statusNotCompleted);
        visorDB.addLegsWorkout(5,"Leg Extensions","3 sets of 10 reps, with suitable weight, 40-60s rest between sets",statusNotCompleted);
        visorDB.addLegsWorkout(6,"Leg Press / Calf Raises","3 sets of 10-12 reps, with suitable weight, Each with 30-40s Rest",statusNotCompleted);


        //ADDING BACK WORKOUT
        visorDB.addBackWorkout(1,"Wide-grip Pull-ups","3 sets of 8-12 reps, with suitable weight or only bodyweight, 40-60s rest between sets \nKeep your shoulders down and back, and engage your core. If you can't do full pull-ups, try assisted pull-ups with a resistance band or machine.",statusNotCompleted);
        visorDB.addBackWorkout(2,"Bent-over Barbell Rows","3 sets of 10 reps, with suitable weight, 40-60s rest between sets \nStand with your feet shoulder-width apart, grasp the barbell with an overhand grip, and hinge forward from your hips. Pull the bar up towards your chest, then lower it back down to the starting position.",statusNotCompleted);
        visorDB.addBackWorkout(3,"Seated Cable Rows","4 sets of 10-12 reps, with suitable weight , 60-90s rest between sets \nKeep your shoulders down and back, and engage your core. Use a weight that allows you to maintain proper form throughout the set.",statusNotCompleted);
        visorDB.addBackWorkout(4,"Single-arm Dumbbell Rows","3 sets to 12 reps, with suitable weight, 30-40s rest between sets\nKeep your back straight and your core engaged. Use a weight that allows you to maintain proper form throughout the set.",statusNotCompleted);
        visorDB.addBackWorkout(5,"Hyperextensions","3 sets of 10 reps, with suitable weight, 40-60s rest between sets\nLie face down on a hyperextension bench with your feet secured and your hands behind your head. Lift your chest up, then lower it back down to the starting position.",statusNotCompleted);
        visorDB.addBackWorkout(6,"Reverse Flyes","3 sets of 10-12 reps, with suitable weight, Each with 30-40s Rest \nKeep your back straight and your elbows slightly bent. Use a weight that allows you to maintain proper form throughout the set.",statusNotCompleted);


        //ADDING ABS WORKOUT
        visorDB.addAbsWorkout(1,"Plank","3 sets, Hold for 30-60 seconds, 40-60s rest between sets \nEngage your core and don't let your hips drop. Increase the duration of each plank as you get stronger.",statusNotCompleted);
        visorDB.addAbsWorkout(2,"Russian Twists","3 sets of 20-30 reps, with suitable weight, 60-80s rest between sets \nKeep your back straight and your feet off the ground throughout the set. Increase the weight or reps as you get stronger.",statusNotCompleted);
        visorDB.addAbsWorkout(3,"Leg Raises","3 sets of 12-15 reps, 60-90s rest between sets \nKeep your lower back pressed into the ground and your legs straight throughout the set. Increase the reps or add ankle weights as you get stronger.",statusNotCompleted);
        visorDB.addAbsWorkout(4,"Bicycle Crunches","3 sets to 20-30 reps, 30-40s rest between sets\nKeep your elbows wide and your lower back pressed into the ground. Increase the reps or add a weight to the movement as you get stronger.",statusNotCompleted);
        visorDB.addAbsWorkout(5,"Dead Bug","3 sets of 12-15 reps, 40-60s rest between sets\nLie on your back with your arms extended towards the ceiling and your knees bent at a 90-degree angle. Slowly lower your right arm and left leg towards the ground, then return to the starting position. Repeat on the other side.",statusNotCompleted);


        //ADDING SHOULDERS WORKOUT
        visorDB.addShouldersWorkout(1,"Overhead Press","3 sets of 8-12 reps, with suitable weight, 60-90s rest between sets \nStart with a barbell or dumbbells at shoulder height. Press the weight up overhead until your arms are straight, then lower back down to shoulder height.",statusNotCompleted);
        visorDB.addShouldersWorkout(2,"Arnold Press","3 sets of 10-15 reps, with suitable weight, 60-90s rest between sets \nStart with dumbbells at shoulder height, with your palms facing towards you. As you press the weight up, rotate your palms to face away from you, then lower back down to shoulder height.",statusNotCompleted);
        visorDB.addShouldersWorkout(3,"Lateral Raises","3 sets of 12-15 reps, with suitable weight, 60-90s rest between sets \nStart with dumbbells at your sides. Raise your arms up to shoulder height, keeping your elbows slightly bent, then lower back down to your sides.",statusNotCompleted);
        visorDB.addShouldersWorkout(4,"Front Raises","3 sets to 20-30 reps, with suitable weight, 30-40s rest between sets\nStart with dumbbells at your sides. Raise your arms up in front of you to shoulder height, keeping your elbows slightly bent, then lower back down to your sides.",statusNotCompleted);
        visorDB.addShouldersWorkout(5,"Rear Delt Fly","3 sets of 12-15 reps, with suitable weight, 40-60s rest between sets\nHold dumbbells in each hand and bend over with your back flat. Raise your arms out to the sides, squeezing your shoulder blades together, then lower back down to the starting position.",statusNotCompleted);
        visorDB.addShouldersWorkout(6,"Face Pulls","3 sets of 10-12 reps, with suitable weight, Each with 30-40s Rest \nAttach a rope or band to a cable machine at shoulder height. Pull the rope or band towards your face, keeping your elbows high and your shoulders back, then slowly release back to the starting position.",statusNotCompleted);



        //ADDING SHOULDERS WORKOUT
        visorDB.addArmsWorkout(1,"Barbell Bicep Curls","3 sets of 8-12 reps, with suitable weight, 40-60s rest between sets \nKeep your back straight and engage your core. Increase weight gradually over time.",statusNotCompleted);
        visorDB.addArmsWorkout(2,"Tricep Dips","3 sets of 12-15 reps, with suitable weight, 60-80s rest between sets \nKeep your shoulders down and engage your core. Increase difficulty by placing your feet on a higher surface.",statusNotCompleted);
        visorDB.addArmsWorkout(3,"Hammer Curls","3 sets of 12-15 reps, with suitable weight, 60-90s rest between sets \nKeep your back straight and engage your core. Increase weight gradually over time.",statusNotCompleted);
        visorDB.addArmsWorkout(4,"Tricep Extensions","3 sets to 12-15 reps, with suitable weight, 30-40s rest between sets\nHold a dumbbell with both hands and raise it above your head. Lower the weight behind your head by bending your elbows, then extend your arms back up to the starting position.",statusNotCompleted);
        visorDB.addArmsWorkout(5,"Zottman Curls","3 sets of 12-15 reps, with suitable weight, 40-60s rest between sets\nHold dumbbells with palms facing up and hands at your sides. Curl the weight towards your chest, then rotate your palms to face downwards as you lower the weight back down to the starting position.",statusNotCompleted);
        visorDB.addArmsWorkout(6,"Skull Crushers","3 sets of 10-12 reps, with suitable weight, Each with 30-40s Rest \nLie on a bench with a barbell held above your head. Lower the weight towards your forehead by bending your elbows, then extend your arms back up to the starting position.",statusNotCompleted);



    }

    @Override
    public void onBackPressed() {

        finish();

    }
}