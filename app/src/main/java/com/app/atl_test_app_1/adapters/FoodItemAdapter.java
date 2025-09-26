package com.app.atl_test_app_1.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.atl_test_app_1.R;
import com.app.atl_test_app_1.activities.AddMealTaskActivity;
import com.app.atl_test_app_1.activities.WorkoutTaskActivity;
import com.app.atl_test_app_1.carddata.FoodItemData;
import com.app.atl_test_app_1.carddata.WorkoutCardData;
import com.google.android.material.button.MaterialButton;

import java.util.List;

public class FoodItemAdapter extends RecyclerView.Adapter<FoodItemAdapter.ViewHolder> {

    private List<FoodItemData> mCardDataList;
    private AdapterView.OnItemClickListener mListener;



    public FoodItemAdapter(List<FoodItemData> cardDataList) {
        mCardDataList = cardDataList;

    }
    public void setFoodItemCardDataList(List<FoodItemData> cardDataList) {
        this.mCardDataList = cardDataList;
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onFoodCalPassed(String cals);
    }


    @NonNull
    @Override
    public FoodItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.food_card_item, parent, false);
        return new FoodItemAdapter.ViewHolder(view, mCardDataList,mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodItemAdapter.ViewHolder holder, int position) {
        FoodItemData cardData = mCardDataList.get(position);
        holder.foodItemName.setText(cardData.getmFoodItemName());
        holder.foodItemDetails.setText(cardData.getmFoodItemDetails());
        holder.foodItemCals.setText(cardData.getmFoodItemCals());

    }


    @Override
    public int getItemCount() {
        return mCardDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public Integer foodItemID;
        public TextView foodItemName;
        public TextView foodItemDetails;
        public TextView foodItemCals;
        public MaterialButton addFoodBtn;
        private OnItemClickListener mListener;

        public ViewHolder(View itemView, final List<FoodItemData> cardDataList, AdapterView.OnItemClickListener listener) {
            super(itemView);
            mListener = (OnItemClickListener) listener;
            foodItemName = itemView.findViewById(R.id.food_item_name);
            foodItemCals = itemView.findViewById(R.id.food_item_cal);
            foodItemDetails = itemView.findViewById(R.id.food_item_details);
            addFoodBtn= itemView.findViewById(R.id.add_food_btn);

            addFoodBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    FoodItemData cardData = cardDataList.get(position);
                    Intent taskIntent = new Intent(v.getContext(), AddMealTaskActivity.class);
                    taskIntent.putExtra("FOOD_ITEM_CAL", foodItemCals.getText().toString());
                    v.getContext().startActivity(taskIntent);

                }
            });


        }
    }


}
