package com.app.atl_test_app_1.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.atl_test_app_1.R;
import com.app.atl_test_app_1.database.UserDB;

public class RegisterActivity extends AppCompatActivity {

    Button button;
    UserDB userDB;
    public static final String TAG = "RegisterActivity";
    public static String userID;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        button = (Button) findViewById(R.id.reg_signup_btn);
        EditText userid, pwd, username, useraddress, usermobile;

        userid = findViewById(R.id.reg_email_box);
        pwd = findViewById(R.id.reg_pwd_box);
        username = findViewById(R.id.reg_name_box);
        useraddress = findViewById(R.id.reg_adr_box);
        usermobile = findViewById(R.id.reg_mobile_box);
        userDB = new UserDB(RegisterActivity.this);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(userid.getText().toString()) || TextUtils.isEmpty(pwd.getText().toString()) || TextUtils.isEmpty(username.getText().toString())) {

                    String message = "Please Fill All Details";
                    Toast toast = Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_SHORT);
                    toast.show();


                } else {

                    String user_id = userid.getText().toString();
                    String user_password = pwd.getText().toString();
                    String user_name = username.getText().toString();
                    String user_address = useraddress.getText().toString();
                    String user_mobile = usermobile.getText().toString();

                    userID=user_id;


                    userDB.addUserDetails(user_id,user_name,user_address,user_mobile,user_password);

                    Toast.makeText(RegisterActivity.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
                    Intent homeIntent = new Intent(RegisterActivity.this, MainActivity.class);
                    homeIntent.putExtra("user_id_reg", userID);
                    startActivity(homeIntent);

                }



            }
        });

        TextView logInBtn  = findViewById(R.id.log_in_txt_btn);
        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
    @Override
    public void onBackPressed() {

        finish();

    }
}