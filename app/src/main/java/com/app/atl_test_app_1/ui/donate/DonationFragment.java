package com.app.atl_test_app_1.ui.donate;

import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.atl_test_app_1.R;
import com.app.atl_test_app_1.activities.BlogActivity;
import com.app.atl_test_app_1.activities.HospitalsActivity;
import com.app.atl_test_app_1.activities.SearchDonorsActivity;
import com.app.atl_test_app_1.activities.TrainingCentre;
import com.app.atl_test_app_1.activities.UserDonationActivity;
import com.app.atl_test_app_1.database.VisorDB;
import com.app.atl_test_app_1.databinding.FragmentDonationBinding;
import com.app.atl_test_app_1.databinding.FragmentHomeBinding;
import com.app.atl_test_app_1.ui.home.HomeViewModel;
import com.google.android.material.button.MaterialButton;

public class DonationFragment extends Fragment {

    private DonationViewModel mViewModel;
    private FragmentDonationBinding binding;

    CardView donateBloodCard;
    CardView searchDonorCard;

    CardView blog1Card;
    CardView blog2Card;

    MaterialButton continueBtn;




    public static DonationFragment newInstance() {
        return new DonationFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(DonationViewModel.class);
        binding = FragmentDonationBinding.inflate(inflater, container, false);
        View root = binding.getRoot();




        donateBloodCard = root.findViewById(R.id.dono_blood_frag);
        donateBloodCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userDonoIntent = new Intent(getActivity(), UserDonationActivity.class);
                startActivity(userDonoIntent);
            }
        });

        continueBtn = root.findViewById(R.id.continue_dono_btn);
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent continueIntent = new Intent(getActivity(), UserDonationActivity.class);
                startActivity(continueIntent);
            }
        });

        searchDonorCard = root.findViewById(R.id.search_dono_frag);
        searchDonorCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchDonorIntent = new Intent(getActivity(), SearchDonorsActivity.class);
                startActivity(searchDonorIntent);
            }
        });

        blog1Card = root.findViewById(R.id.blog_1_card_donate);
        blog1Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent blogIntent = new Intent(getActivity(), BlogActivity.class);
                blogIntent.putExtra("CHECK_BLOG","WHY_DONATE");
                startActivity(blogIntent);
            }
        });


        blog2Card = root.findViewById(R.id.blog_2_card_donate);
        blog2Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent blogIntent = new Intent(getActivity(), BlogActivity.class);
                blogIntent.putExtra("CHECK_BLOG","PROCESS_DONATION");
                startActivity(blogIntent);
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