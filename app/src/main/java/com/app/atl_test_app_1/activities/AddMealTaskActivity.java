package com.app.atl_test_app_1.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;
import android.widget.Toast;

import com.app.atl_test_app_1.R;
import com.app.atl_test_app_1.adapters.FoodItemAdapter;
import com.app.atl_test_app_1.adapters.WorkoutCardAdapter;
import com.app.atl_test_app_1.carddata.ActivityCardData;
import com.app.atl_test_app_1.carddata.FoodItemData;
import com.app.atl_test_app_1.carddata.WorkoutCardData;

import java.util.ArrayList;
import java.util.List;

public class AddMealTaskActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FoodItemAdapter adapter;
    private String foodItemName;
    private String foodItemCals;
    private String foodItemDetails;
    private Integer foodItemCalsInt;
    private TextView foodItemNameView;
    private TextView foodItemCalsView;
    private TextView foodItemDetailsView;
    private Integer foodItemIntentInt;
    public static List<FoodItemData> foodItemDataList;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meal_task);


        //foodItemNameView = findViewById(R.id.food_item_name);
        adapter =new FoodItemAdapter(foodItemDataList);
        recyclerView = findViewById(R.id.recycler_food_items);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        foodItemDataList = new ArrayList<FoodItemData>();
        recyclerView.setAdapter(adapter);
        foodItemCals= "0";
        foodItemCalsInt = 0;


        foodItemCalsView=findViewById(R.id.calorie_count);




        //GET INTENT FOR WORKOUT
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                foodItemCals= "null";
                foodItemCalsInt = 0;
                foodItemCalsView.setText(foodItemCalsInt + " Cal");

            } else {
                foodItemCals= extras.getString("FOOD_ITEM_CAL");
            }
        } else {
            foodItemCals= (String) savedInstanceState.getSerializable("FOOD_ITEM_CAL");
        }

        //PARSING STR TO INT

        try {
            if (foodItemCals=="0"){
                foodItemCalsInt=0;
                foodItemCalsView.setText(0+" Cal");
            }else{
                foodItemIntentInt = Integer.parseInt(foodItemCals);
                foodItemCalsInt += foodItemIntentInt;
                foodItemCals = Integer.toString(foodItemCalsInt);
                foodItemCalsView.setText(foodItemCalsInt+" Cal");
            }

        } catch(NumberFormatException nfe) {
            System.out.println("Could not parse " + nfe);
        }





       // Toast.makeText(this, foodItemCals, Toast.LENGTH_SHORT).show();




            foodItemDataList.add(new FoodItemData(1,"Food Item 1", "Food Desc 1","100"));
            foodItemDataList.add(new FoodItemData(2,"Food Item 2", "Food Desc 2","200"));
            foodItemDataList.add(new FoodItemData(3,"Food Item 3", "Food Desc 3","300"));
            foodItemDataList.add(new FoodItemData(4,"Food Item 4", "Food Desc 4","150"));
            foodItemDataList.add(new FoodItemData(5,"Food Item 5", "Food Desc 5","100"));
            foodItemDataList.add(new FoodItemData(6,"Food Item 6", "Food Desc 6","250"));
            foodItemDataList.add(new FoodItemData(7,"Food Item 7", "Food Desc 7","500"));
            foodItemDataList.add(new FoodItemData(8,"Food Item 8", "Food Desc 8","200"));
            foodItemDataList.add(new FoodItemData(9,"Food Item 9", "Food Desc 9","750"));
            foodItemDataList.add(new FoodItemData(10,"Food Item 10", "Food Desc 10","520"));
            foodItemDataList.add(new FoodItemData(11,"Food Item 11", "Food Desc 11","150"));
            foodItemDataList.add(new FoodItemData(12,"Food Item 12", "Food Desc 12","140"));
            foodItemDataList.add(new FoodItemData(13,"Food Item 13", "Food Desc 13","400"));
            adapter.setFoodItemCardDataList(foodItemDataList);








    }

    @Override
    public void onBackPressed() {

        startActivity(new Intent(AddMealTaskActivity.this, MealActivity.class));

    }

}