package com.app.atl_test_app_1.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.app.atl_test_app_1.R;
import com.google.android.material.button.MaterialButton;

public class AddWaterActivity extends AppCompatActivity {

    private MaterialButton water250btn;
    private MaterialButton water500btn;
    private MaterialButton water1000btn;
    private MaterialButton waterCustomBtn;
    private MaterialButton saveWaterCount;
    private TextView waterCount;
    private Integer waterCountInt;
  //  private Integer customAmountINT;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_water);

        water250btn =  findViewById(R.id.button_250ml);
        water500btn =  findViewById(R.id.button_500ml);
        water1000btn =  findViewById(R.id.button_1000ml);
        waterCustomBtn =  findViewById(R.id.button_custom_water);
        waterCount = findViewById(R.id.water_count);
        saveWaterCount = findViewById(R.id.save_water_count);
        waterCountInt = 0;


        water250btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                waterCountInt = waterCountInt + 250;
                waterCount.setText(waterCountInt+" ml");
            }
        });

        water500btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                waterCountInt = waterCountInt + 500;
                waterCount.setText(waterCountInt+" ml");
            }
        });

        water1000btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                waterCountInt = waterCountInt + 1000;
                waterCount.setText(waterCountInt+" ml");
            }
        });

        waterCustomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Create an EditText view for the user to enter the custom amount
                final EditText customAmountEditText = new EditText(getApplicationContext());


                // Set the input type to be a number
                customAmountEditText.setInputType(InputType.TYPE_CLASS_NUMBER);

                // Create an alert dialog to prompt the user to enter the custom amount
                AlertDialog.Builder builder = new AlertDialog.Builder(AddWaterActivity.this);
                builder.setTitle("Enter Custom Amount");
                builder.setView(customAmountEditText);

                // Set up the buttons for the alert dialog
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Get the custom amount entered by the user
                        String customAmountString = customAmountEditText.getText().toString();
                       // Integer customAmount = Integer.parseInt(customAmountString);

                        // Convert the custom amount to an integer and save it to the customAmount variable
                        if (!customAmountString.equals("")) {
                           Integer customAmount = Integer.parseInt(customAmountString);
                           waterCountInt = waterCountInt + customAmount;
                           waterCount.setText(waterCountInt+" ml");

                        }
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing
                    }
                });

                // Show the alert dialog
                AlertDialog dialog = builder.create();
                dialog.show();



            }
        });
        saveWaterCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dietIntent = new Intent(AddWaterActivity.this,DietActivity.class);
                dietIntent.putExtra("UPDATED_WATER",waterCountInt.toString());
                startActivity(dietIntent);
            }
        });

    }

    @Override
    public void onBackPressed() {

        finish();

    }
}