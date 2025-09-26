package com.app.atl_test_app_1.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.atl_test_app_1.carddata.DineoutCardData;
import com.app.atl_test_app_1.R;

import java.util.List;

public class DineoutCardAdapter extends RecyclerView.Adapter<DineoutCardAdapter.ViewHolder> {

    private List<DineoutCardData> mCardDataList;

    public DineoutCardAdapter(List<DineoutCardData> cardDataList) {
        mCardDataList = cardDataList;
    }

    public void setDineoutCardDataList(List<DineoutCardData> cardDataList) {
        this.mCardDataList = cardDataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.places_view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DineoutCardData cardData = mCardDataList.get(position);
        holder.dineoutName.setText(cardData.getDineoutName());
        holder.dineoutArea.setText(cardData.getDineoutArea());
//        holder.dineoutImage.setImageResource(cardData.getmDineoutImage());
    }

    @Override
    public int getItemCount() {
        return mCardDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView dineoutImage;
        public TextView dineoutName;
        public TextView dineoutArea;

        public ViewHolder(View itemView) {
            super(itemView);
            dineoutImage = itemView.findViewById(R.id.place_image);
            dineoutName = itemView.findViewById(R.id.place_name);
            dineoutArea = itemView.findViewById(R.id.place_area);
        }
    }
}
