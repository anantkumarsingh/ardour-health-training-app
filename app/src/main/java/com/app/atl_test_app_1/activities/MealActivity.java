package com.app.atl_test_app_1.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.app.atl_test_app_1.R;
import com.google.android.material.button.MaterialButton;

public class MealActivity extends AppCompatActivity {

    private MaterialButton breakfastBtn;
    private MaterialButton lunchBtn;
    private MaterialButton dinnerBtn;
    private MaterialButton snacksBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);

        breakfastBtn = findViewById(R.id.add_breakfast_btn);
        lunchBtn = findViewById(R.id.add_lunch_btn);
        dinnerBtn = findViewById(R.id.add_dinner_btn);
        snacksBtn = findViewById(R.id.add_snacks_btn);

       breakfastBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent toAddMealIntent= new Intent(MealActivity.this, AddMealTaskActivity.class);
               toAddMealIntent.putExtra("FOOD_ITEM_CAL","0");
               startActivity(toAddMealIntent);

           }
       });

        lunchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toAddMealIntent= new Intent(MealActivity.this, AddMealTaskActivity.class);
                toAddMealIntent.putExtra("FOOD_ITEM_CAL","0");
                startActivity(toAddMealIntent);

            }
        });

        dinnerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toAddMealIntent= new Intent(MealActivity.this, AddMealTaskActivity.class);
                toAddMealIntent.putExtra("FOOD_ITEM_CAL","0");
                startActivity(toAddMealIntent);


            }
        });

        snacksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toAddMealIntent= new Intent(MealActivity.this, AddMealTaskActivity.class);
                toAddMealIntent.putExtra("FOOD_ITEM_CAL","0");
                startActivity(toAddMealIntent);

            }
        });




    }

    @Override
    public void onBackPressed() {

        Intent toAddMealIntent= new Intent(MealActivity.this, DietActivity.class);
        startActivity(toAddMealIntent);

    }

}