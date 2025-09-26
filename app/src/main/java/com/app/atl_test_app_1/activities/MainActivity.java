package com.app.atl_test_app_1.activities;

import static com.app.atl_test_app_1.database.UserDB.USERS_TABLE;
import static com.app.atl_test_app_1.database.UserDB.USER_ID;
import static com.app.atl_test_app_1.database.UserDB.USER_NAME;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.app.atl_test_app_1.R;
import com.app.atl_test_app_1.database.UserDB;
import com.app.atl_test_app_1.database.VisorDB;
import com.app.atl_test_app_1.databinding.ActivityMainBinding;
import com.app.atl_test_app_1.ui.aboutus.AboutUsFragment;
import com.app.atl_test_app_1.ui.account.AccountFragment;
import com.app.atl_test_app_1.ui.donate.DonationFragment;
import com.app.atl_test_app_1.ui.home.HomeFragment;;
import com.app.atl_test_app_1.ui.schedule.ScheduleFragment;
import com.app.atl_test_app_1.ui.training.TrainingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener {

    private ActivityMainBinding binding;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    private String userName;
    private String userId;
 //   private TextView nameUserView;
 //   private DrawerLayout drawer;
    private BottomNavigationView bottomNavView;
    UserDB userDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        userDB= new UserDB(this);
        SQLiteDatabase db = userDB.getReadableDatabase();
       // nameUserView= findViewById(R.id.name_user_home);


        Intent intent = getIntent();
        String user_Id = intent.getStringExtra("user_id");
        String user_Id_Reg = intent.getStringExtra("user_id_reg");


        if (user_Id ==null){
            userId = user_Id_Reg;
        }else if(user_Id_Reg==null){
            userId = user_Id;
        }else{
            userId=null;
        }


      //  Toast.makeText(this, userId, Toast.LENGTH_SHORT).show();



        String fragmentId = getIntent().getStringExtra("FRAGMENT_ID");
        if (fragmentId != null && fragmentId.equals("MY_FRAGMENT")) {
            DonationFragment fragment = new DonationFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.nav_host_fragment_activity_main, fragment);
            transaction.commit();
        }else if (fragmentId != null && fragmentId.equals("DIET_FRAGMENT")) {
            TrainingFragment fragment = new TrainingFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.nav_host_fragment_activity_main, fragment);
            transaction.commit();
        }


        bottomNavView = findViewById(R.id.bottom_nav_view);
        bottomNavView.setOnNavigationItemSelectedListener(this);


        //NAV DRAWER

        navigationView = findViewById(R.id.nav_view_drawer);


      navigationView.setNavigationItemSelectedListener(this);





    }


//NAV FOR DRAWER AND BOTTOM NAV
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
      //  drawer.closeDrawers();
        switch (id){
            case R.id.nav_drawer_home:
            case R.id.navigation_home:
                Fragment fragmenthome = new HomeFragment();
                Bundle bundle = new Bundle();
                bundle.putString("user_id_intent", userId);
                fragmenthome.setArguments(bundle);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_activity_main,fragmenthome).commit();
                break;

            case R.id.nav_drawer_schedule:
            case R.id.navigation_schedule:
                Fragment fragmentschedule = new ScheduleFragment();
                FragmentTransaction fragmentTransactionschedule = getSupportFragmentManager().beginTransaction();
                fragmentTransactionschedule.replace(R.id.nav_host_fragment_activity_main,fragmentschedule).commit();
                break;

            case R.id.nav_drawer_donate:
            case R.id.navigation_donate:
                Fragment fragmentDonate = new DonationFragment();
                FragmentTransaction fragmentTransactionReport = getSupportFragmentManager().beginTransaction();
                fragmentTransactionReport.replace(R.id.nav_host_fragment_activity_main,fragmentDonate).commit();
                break;

            case R.id.nav_drawer_account:
            case R.id.navigation_account:
                Fragment fragmentAcc = new AccountFragment();
                Bundle accbundle = new Bundle();
                accbundle.putString("user_id_intent", userId);
                fragmentAcc.setArguments(accbundle);
                FragmentTransaction fragmentTransactionAcc = getSupportFragmentManager().beginTransaction();
                fragmentTransactionAcc.replace(R.id.nav_host_fragment_activity_main,fragmentAcc).commit();
                break;

            case R.id.nav_drawer_aboutus:
                Fragment fragmentAbUs = new AboutUsFragment();
                FragmentTransaction fragmentTransactionAbUs = getSupportFragmentManager().beginTransaction();
                fragmentTransactionAbUs.replace(R.id.nav_host_fragment_activity_main,fragmentAbUs).commit();
                break;

            case R.id.navigation_training:
                Fragment fragmentTraining = new TrainingFragment();
                FragmentTransaction fragmentTrainingTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTrainingTransaction.replace(R.id.nav_host_fragment_activity_main,fragmentTraining).commit();
                break;

        }
        return true;


    }

    @Override
    public void onBackPressed() {

        finish();

    }


}