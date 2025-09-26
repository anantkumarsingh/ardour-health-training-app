package com.app.atl_test_app_1.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.atl_test_app_1.R;

public class BlogActivity extends AppCompatActivity {
    private TextView blogTitle;
    private TextView blogTxtP1;
    private TextView blogTxtP2;
    private ImageView blogImg;
    private String blogExtra;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        blogTitle = findViewById(R.id.blog_title);
        blogImg = findViewById(R.id.img_blog);
        blogTxtP1 = findViewById(R.id.blog_text_1);
        blogTxtP2 = findViewById(R.id.blog_text_2);

       // String message = getString(R.string.welcome_message);



        Intent intent = getIntent();
        blogExtra = intent.getStringExtra("CHECK_BLOG");

        if (blogExtra != null) {
            if (blogExtra.equals("BLOOD_DONATION")) {
                blogImg.setImageResource(R.drawable._7759b26_3b9c_409d_a4b8_8ad680dff5b7);
                blogTitle.setText("Blood Donation");
                blogTxtP1.setText(getString(R.string.blood_donation_blog_1));
                blogTxtP2.setText(getString(R.string.blood_donation_blog_2));
            } else if (blogExtra.equals("MUSCLE_RECOVERY")) {
                blogImg.setImageResource(R.drawable.young_man_stretching_himself_on_a_foam_roller_picture_id1182421361_752x401);
                blogTitle.setText("How To Speed Up Muscle Recovery");
                blogTxtP1.setText(getString(R.string.speed_muscle_recovery));
            } else if (blogExtra.equals("OVERCOME_MOTIVATION")) {
                blogImg.setImageResource(R.drawable.motivation_pic);
                blogTitle.setText("Overcome Lost Motivation");
                blogTxtP1.setText(getString(R.string.lost_motivation));
            } else if (blogExtra.equals("WHY_DONATE")) {
                blogImg.setImageResource(R.drawable.cafe7907549d063c99d7438efa389666);
                blogTitle.setText("Why Blood Donation is Important");
                blogTxtP1.setText(getString(R.string.why_donate_blog_1));
                blogTxtP2.setText(getString(R.string.why_donate_blog_2));
            } else if (blogExtra.equals("PROCESS_DONATION")) {
                blogImg.setImageResource(R.drawable._7f3162e6ceb9c8bbca98ce06951e4a0);
                blogTitle.setText("Process of Blood Donation");
                blogTxtP1.setText(getString(R.string.how_process_1));
                blogTxtP2.setText(getString(R.string.how_process_2));
            }
        } else {
            Toast.makeText(this, "blogExtra is null", Toast.LENGTH_SHORT).show();
        }



    }
}