package com.app.atl_test_app_1.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.app.atl_test_app_1.R;
import com.app.atl_test_app_1.ui.training.TrainingFragment;

public class DietActivity extends AppCompatActivity {

    private CardView addWaterCard;
    private CardView addMealCard;
    private String updatedWaterCount;
    private String updatedCalorieCount;
    private TextView waterIntakeView;
    private TextView mealIntakeView;
    private ProgressBar waterProgressBar;
    private ProgressBar mealProgressBar;
    private int updatedWaterCountInt;
    private int updatedCalorieCountInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);

        addWaterCard = findViewById(R.id.add_water_card);
        addMealCard = findViewById(R.id.add_meal_card);
        waterIntakeView = findViewById(R.id.water_intake_user);
        waterProgressBar = findViewById(R.id.progress_bar_water);
        mealProgressBar = findViewById(R.id.progress_bar);
        mealIntakeView = findViewById(R.id.calorie_intake_user);

        updatedWaterCountInt=0;
        updatedWaterCount="null";


        //GET INTENT FOR WORKOUT
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                updatedWaterCount= null;
                //updatedWaterCountInt=0;
            } else {
                updatedWaterCount= extras.getString("UPDATED_WATER");
            }
        } else {
            updatedWaterCount= (String) savedInstanceState.getSerializable("UPDATED_WATER");

        }

        //PARSING STR TO INT

        if (updatedWaterCount==null){
            //DO NOTHING
        }else {
            try {
                updatedWaterCountInt = Integer.parseInt(updatedWaterCount.toString());
            } catch(NumberFormatException nfe) {
                System.out.println("Could not parse " + nfe);
            }
        }





        waterIntakeView.setText(updatedWaterCountInt+"/5000mL");
        waterProgressBar.setMax(5000);
        waterProgressBar.setProgress(updatedWaterCountInt);



        addWaterCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent waterIntent = new Intent(DietActivity.this, AddWaterActivity.class);
                startActivity(waterIntent);
            }
        });

        addMealCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mealIntent = new Intent(DietActivity.this, MealActivity.class);
                startActivity(mealIntent);
            }
        });



    }

    @Override
    public void onBackPressed() {

        Intent backPageInt = new Intent(DietActivity.this, MainActivity.class);
        backPageInt.putExtra("FRAGMENT_ID", "DIET_FRAGMENT");
        startActivity(backPageInt);

    }
}