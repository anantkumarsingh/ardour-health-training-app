package com.app.atl_test_app_1.ui.training;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.app.atl_test_app_1.activities.DietActivity;
import com.app.atl_test_app_1.R;
import com.app.atl_test_app_1.activities.TrainingActivity;
import com.app.atl_test_app_1.databinding.FragmentTrainingBinding;


public class TrainingFragment extends Fragment {

    private FragmentTrainingBinding binding;
    ImageView trainingImgBtn;
    ImageView dietImgBtn;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TrainingViewModel dashboardViewModel =
                new ViewModelProvider(this).get(TrainingViewModel.class);

        binding = FragmentTrainingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        trainingImgBtn=root.findViewById(R.id.training_image_fragment);
        dietImgBtn=root.findViewById(R.id.diet_image_fragment);


        trainingImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent trainingIntent = new Intent(getActivity(), TrainingActivity.class);
                startActivity(trainingIntent);
            }
        });

        dietImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dietIntent = new Intent(getActivity(), DietActivity.class);
                dietIntent.putExtra("UPDATED_WATER","0");
                startActivity(dietIntent);
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