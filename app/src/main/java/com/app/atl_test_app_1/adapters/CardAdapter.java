package com.app.atl_test_app_1.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.atl_test_app_1.carddata.CardData;
import com.app.atl_test_app_1.R;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardViewHolder> {

    private List<CardData> cardDataList;

    public void setCardDataList(List<CardData> cardDataList) {
        this.cardDataList = cardDataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_item, parent, false);

        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        CardData cardData = cardDataList.get(position);
        holder.docName.setText(cardData.getDocName());
        holder.docSpecialty.setText(cardData.getDocSpec());
        holder.aptDate.setText(cardData.getAptDate());
        holder.aptTime.setText(cardData.getAptTime());
    }

    @Override
    public int getItemCount() {
        return cardDataList != null ? cardDataList.size() : 0;
    }
}
