package com.app.atl_test_app_1.ui.home;

import static com.app.atl_test_app_1.database.UserDB.USERS_TABLE;
import static com.app.atl_test_app_1.database.UserDB.USER_ID;
import static com.app.atl_test_app_1.database.UserDB.USER_NAME;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.app.atl_test_app_1.activities.AppointmentActivity;
import com.app.atl_test_app_1.activities.BlogActivity;
import com.app.atl_test_app_1.activities.DineoutActivity;
import com.app.atl_test_app_1.activities.HospitalsActivity;
import com.app.atl_test_app_1.R;
import com.app.atl_test_app_1.activities.SearchDonorsActivity;
import com.app.atl_test_app_1.activities.ShopActivity;
import com.app.atl_test_app_1.activities.TrainingActivity;
import com.app.atl_test_app_1.activities.TrainingCentre;
import com.app.atl_test_app_1.activities.UserDonationActivity;
import com.app.atl_test_app_1.database.UserDB;
import com.app.atl_test_app_1.databinding.FragmentHomeBinding;

import org.w3c.dom.Text;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    CardView hospitalCardView;
    CardView trainingCentreCard;
    CardView appointmentCard;
    CardView donateBloodCard;
    CardView searchDonorCard;
    CardView shopCard;
    TextView nameView;
    TextView blogView;
    private String userName;
    private String userId;
    UserDB userDB;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        userDB =  new UserDB(getActivity());
        nameView = root.findViewById(R.id.name_user_home);

        donateBloodCard = root.findViewById(R.id.donate_blood_card);
        searchDonorCard = root.findViewById(R.id.search_donor_card);
        appointmentCard = root.findViewById(R.id.appointments_card);
        shopCard = root.findViewById(R.id.shop_card);







        blogView = root.findViewById(R.id.blog_txt);

        if (getArguments() != null) {
            userId = getArguments().getString("user_id_intent");
        }


        blogView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent blogIntent = new Intent(getActivity(), BlogActivity.class);
                blogIntent.putExtra("CHECK_BLOG","BLOOD_DONATION");
                startActivity(blogIntent);
            }
        });


        //SET USERNAME
        String  getUserInfoQuery = ("SELECT * FROM " + USERS_TABLE + " WHERE " + USER_ID + " = '"+userId+"'");
        Cursor cursor = userDB.getReadableDatabase().rawQuery(getUserInfoQuery, null);
        if (cursor.moveToFirst()){
            userName = cursor.getString(cursor.getColumnIndexOrThrow(USER_NAME));

        }else{

        }cursor.close();

        if (userName==null){
            userName="";
        }


        nameView.setText(userName +" 👋🏻");


        shopCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shopintent = new Intent(getActivity(), ShopActivity.class);
                startActivity(shopintent);
            }
        });


        appointmentCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent apptIntent = new Intent(getActivity(), AppointmentActivity.class);
                startActivity(apptIntent);
            }
        });

        donateBloodCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent donoIntent = new Intent(getActivity(), UserDonationActivity.class);
                startActivity(donoIntent);
            }
        });

        searchDonorCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchIntent = new Intent(getActivity(), SearchDonorsActivity.class);
                startActivity(searchIntent);
            }
        });





        hospitalCardView = root.findViewById(R.id.hospitals_card);
        hospitalCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hospitalIntent = new Intent(getActivity(), HospitalsActivity.class);
                startActivity(hospitalIntent);
            }
        });

        trainingCentreCard = root.findViewById(R.id.training_centre_card);
        trainingCentreCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent trainingIntent = new Intent(getActivity(), TrainingCentre.class);
                startActivity(trainingIntent);
            }
        });



        return root;



    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}