package com.app.atl_test_app_1.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.atl_test_app_1.R;
import com.app.atl_test_app_1.carddata.TrainingCardData;

import java.util.List;

public class TrainingCardAdapter extends RecyclerView.Adapter<TrainingCardAdapter.ViewHolder> {

    private List<TrainingCardData> mCardDataList;
    private int[] images = {R.drawable.hype_gym,R.drawable.studio_profile_ff6f98b4824375, R.drawable.img_4702ss, R.drawable.axddbezmtndsbh73znx2wtfike};


    public TrainingCardAdapter(List<TrainingCardData> cardDataList) {
        mCardDataList = cardDataList;
    }
    public void setTrainingCardDataList(List<TrainingCardData> cardDataList) {
        this.mCardDataList = cardDataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.trainingcentre_view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TrainingCardData cardData = mCardDataList.get(position);
        holder.centreName.setText(cardData.getTrainingCentreName());
        holder.centreArea.setText(cardData.getTrainingCentreArea());
        holder.centreImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return mCardDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView centreImage;
        public TextView centreName;
        public TextView centreArea;

        public ViewHolder(View itemView) {
            super(itemView);
            centreImage = itemView.findViewById(R.id.centre_image);
            centreName = itemView.findViewById(R.id.centre_name);
            centreArea = itemView.findViewById(R.id.centre_area);
        }
    }
}
