package com.app.atl_test_app_1.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.atl_test_app_1.R;
import com.app.atl_test_app_1.carddata.DineoutCardData;
import com.app.atl_test_app_1.carddata.DonorCardData;

import java.util.List;

public class DonorCardAdapter extends RecyclerView.Adapter<DonorCardAdapter.ViewHolder> {


    private List<DonorCardData> mCardDataList;

    public DonorCardAdapter(List<DonorCardData> cardDataList) {
        mCardDataList = cardDataList;
    }

    public void setDonorCardDataList(List<DonorCardData> cardDataList) {
        this.mCardDataList = cardDataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DonorCardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.donor_card_item, parent, false);
        return new DonorCardAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DonorCardAdapter.ViewHolder holder, int position) {
        DonorCardData cardData = mCardDataList.get(position);
        holder.donorName.setText(cardData.getmDonorName());
        holder.donorEmail.setText(cardData.getmDonorEmail());
        holder.donorPhone.setText(cardData.getmDonorPhone());
        holder.donorDOB.setText(cardData.getmDonorDOB());
        holder.donorAddress.setText(cardData.getmDonorAddress());
        holder.donorBG.setText(cardData.getmDonorBG());
    }

    @Override
    public int getItemCount() {
        return mCardDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView donorName;
        public TextView donorEmail;
        public TextView donorPhone;
        public TextView donorDOB;
        public TextView donorAddress;
        public TextView donorBG;

        public ViewHolder(View itemView) {
            super(itemView);
            donorName = itemView.findViewById(R.id.donor_name_item);
            donorEmail = itemView.findViewById(R.id.donor_email_item);
            donorPhone = itemView.findViewById(R.id.donor_phone_item);
            donorDOB = itemView.findViewById(R.id.donor_DOB_item);
            donorAddress = itemView.findViewById(R.id.donor_address_item);
            donorBG = itemView.findViewById(R.id.donor_BG_item);

        }
    }


}
