package com.app.atl_test_app_1.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.atl_test_app_1.R;
import com.app.atl_test_app_1.activities.WorkoutTaskActivity;
import com.app.atl_test_app_1.carddata.WorkoutCardData;

import java.util.List;

public class WorkoutCardAdapter extends RecyclerView.Adapter<WorkoutCardAdapter.ViewHolder> {

    private List<WorkoutCardData> mCardDataList;
    private int[] images = {R.drawable.warmup_wrorkout,R.drawable.abs_workout, R.drawable.chest_workout, R.drawable.shoulder_workout,R.drawable.arms_workout,R.drawable.back_workout,R.drawable.legs_workout};



    public WorkoutCardAdapter(List<WorkoutCardData> cardDataList) {
        mCardDataList = cardDataList;

    }
    public void setWorkoutCardDataList(List<WorkoutCardData> cardDataList) {
        this.mCardDataList = cardDataList;
        notifyDataSetChanged();
    }




    @NonNull
    @Override
    public WorkoutCardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.workouts_card_item, parent, false);
        return new WorkoutCardAdapter.ViewHolder(view, mCardDataList);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        WorkoutCardData cardData = mCardDataList.get(position);
        holder.workoutName.setText(cardData.getmWorkoutName());
        holder.workoutTask.setText(cardData.getmWorkoutTask());
        holder.mWorkoutId = cardData.getmWorkoutID();
        holder.workoutImg.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return mCardDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView workoutImg;
        public TextView workoutTask;
        public TextView workoutName;
        public String mWorkoutId;

        public ViewHolder(View itemView, final List<WorkoutCardData> cardDataList) {
            super(itemView);
            workoutImg = itemView.findViewById(R.id.workout_image);
            workoutName = itemView.findViewById(R.id.workout_name);
            workoutTask = itemView.findViewById(R.id.workout_task);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    WorkoutCardData cardData = cardDataList.get(position);
                    Intent taskIntent = new Intent(v.getContext(), WorkoutTaskActivity.class);
                    taskIntent.putExtra("WORKOUT_NAME", workoutName.getText().toString());
                    taskIntent.putExtra("WORKOUT_TASK", workoutTask.getText().toString());
                    taskIntent.putExtra("WORKOUT_ID", cardData.getmWorkoutID());
                    v.getContext().startActivity(taskIntent);

                }
            });

        }
    }


}
