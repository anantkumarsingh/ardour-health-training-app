package com.app.atl_test_app_1.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.atl_test_app_1.carddata.ActivityCardData;
import com.app.atl_test_app_1.R;

import java.util.List;

public class ActivityCardAdapter extends RecyclerView.Adapter<ActivityCardAdapter.ViewHolder> {

    private List<ActivityCardData> mCardDataList;
    private int[] images = {R.drawable.medanta_hosp, R.drawable.mac_hosp, R.drawable.la_midas_hosp,R.drawable.paras_hosp,R.drawable.ck_birla};


    public ActivityCardAdapter(List<ActivityCardData> cardDataList) {
        mCardDataList = cardDataList;
    }

    public void setCardActDataList(List<ActivityCardData> cardDataList) {
        this.mCardDataList = cardDataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hospital_view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ActivityCardData cardData = mCardDataList.get(position);
        holder.hospitalName.setText(cardData.getHospitalName());
        holder.hospitalArea.setText(cardData.getHospitalArea());
        holder.hospitalImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return mCardDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView hospitalImage;
        public TextView hospitalName;
        public TextView hospitalArea;

        public ViewHolder(View itemView) {
            super(itemView);
            hospitalImage = itemView.findViewById(R.id.hospital_image);
            hospitalName = itemView.findViewById(R.id.hospital_name);
            hospitalArea = itemView.findViewById(R.id.hospital_area);
        }
    }
}
