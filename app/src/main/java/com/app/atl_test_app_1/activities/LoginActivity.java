package com.app.atl_test_app_1.activities;

import static com.app.atl_test_app_1.database.UserDB.USERS_TABLE;
import static com.app.atl_test_app_1.database.UserDB.USER_ID;
import static com.app.atl_test_app_1.database.UserDB.USER_PWD;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.atl_test_app_1.R;
import com.app.atl_test_app_1.database.UserDB;

public class LoginActivity extends AppCompatActivity {


    Button button;
    TextView forgotpassbtn;
    TextView register_btn;
    UserDB userDB;
    public static String userID;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        button = findViewById(R.id.login_btn);

        EditText loginforUserid, loginUserforPwd;
        loginforUserid = findViewById(R.id.login_email_box);
        loginUserforPwd = findViewById(R.id.login_pwd_box);
        userDB = new UserDB(LoginActivity.this);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(loginforUserid.getText().toString()) || TextUtils.isEmpty(loginUserforPwd.getText().toString())){

                    String message = "All Fields Are Required";
                    Toast toast =  Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT);
                    toast.show();


                }else {

                    String user_id = loginforUserid.getText().toString();
                    String user_password = loginUserforPwd.getText().toString();
                    userID=user_id;



                    // AUTHENTICATE USER USING API START



                    String stdAuthQuery = "SELECT "+USER_ID+","+USER_PWD+" FROM "+USERS_TABLE+" WHERE "+USER_ID+"='"+user_id+"' AND "+USER_PWD+"='"+user_password+"'";
                    // Toast.makeText(LoginActivity.this, user_id, Toast.LENGTH_SHORT).show();

                    Cursor checkUserAuth = userDB.getReadableDatabase().rawQuery(stdAuthQuery, null);
                    int checkAssessmentProgress = checkUserAuth.getCount();
                    if (checkAssessmentProgress>0) {

                        Intent homeIntent = new Intent(LoginActivity.this, MainActivity.class);
                        homeIntent.putExtra("user_id",userID);
                        startActivity(homeIntent);
                        Toast.makeText(LoginActivity.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();

                    }else{
                        Toast.makeText(LoginActivity.this, "Record Not Found", Toast.LENGTH_SHORT).show();
                    }
                }

            }


            //INTENT TO TERMS OF SERVICE
        });
        register_btn = (TextView) findViewById(R.id.sign_up_btn);
        register_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

        forgotpassbtn = findViewById(R.id.forgot_pass_btn);
        forgotpassbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });



    }
    @Override
    public void onBackPressed() {
    }
}