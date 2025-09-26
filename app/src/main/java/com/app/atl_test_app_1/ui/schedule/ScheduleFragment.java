package com.app.atl_test_app_1.ui.schedule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.atl_test_app_1.R;
import com.app.atl_test_app_1.adapters.CardAdapter;
import com.app.atl_test_app_1.carddata.CardData;
import com.app.atl_test_app_1.databinding.FragmentScheduleBinding;

import java.util.ArrayList;
import java.util.List;

public class ScheduleFragment extends Fragment {

    private FragmentScheduleBinding binding;
    private RecyclerView recyclerView;
    private CardAdapter adapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ScheduleViewModel dashboardViewModel =
                new ViewModelProvider(this).get(ScheduleViewModel.class);

        binding = FragmentScheduleBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        //RECYCLER VIEW & CARD
        recyclerView = root.findViewById(R.id.card_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        adapter = new CardAdapter();
        recyclerView.setAdapter(adapter);

        // You can add your own data to the adapter
        addDataToAdapter();


        return root;
    }



    // You can add your own data to the adapter
    private void addDataToAdapter() {
        List<CardData> cardDataList = new ArrayList<>();
        cardDataList.add(new CardData("Dr. Anant Kumar", "Heart Surgeon", "Monday, 13 May","11:00 AM - 12:00 PM"));
        cardDataList.add(new CardData("Dr. Ana Grewal", "Spine Surgeon", "Tuesday, 26 May","11:00 AM - 12:00 PM"));
        cardDataList.add(new CardData("Dr. Shantanu Singh", "Dental Specialist", "Wednesday, 12 August","11:00 AM - 12:00 PM"));
        cardDataList.add(new CardData("Dr. Karthik Khurana", "Therapist", "Thursday, 30 June","11:00 AM - 12:00 PM"));
        cardDataList.add(new CardData("Dr. Ankit Talwar", "Therapist", "Friday, 6 October","11:00 AM - 12:00 PM"));
        cardDataList.add(new CardData("Dr. Rohan Sethi", "Heart Surgeon", "Saturday, 8 January","11:00 AM - 12:00 PM"));
        cardDataList.add(new CardData("Dr. Priya Aggarwal", "Spine Surgeon", "Sunday, 2 November","11:00 AM - 12:00 PM"));

        adapter.setCardDataList(cardDataList);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}