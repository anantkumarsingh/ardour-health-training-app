package com.app.atl_test_app_1.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.atl_test_app_1.R;
import com.app.atl_test_app_1.activities.BookAppointment;
import com.app.atl_test_app_1.activities.WorkoutTaskActivity;
import com.app.atl_test_app_1.carddata.DoctorCardData;
import com.app.atl_test_app_1.carddata.WorkoutCardData;
import com.google.android.material.button.MaterialButton;

import java.util.List;

public class DoctorCardAdapter extends RecyclerView.Adapter<DoctorCardAdapter.ViewHolder> {

    private List<DoctorCardData> mCardDataList;




    public DoctorCardAdapter(List<DoctorCardData> cardDataList) {
        mCardDataList = cardDataList;

    }
    public void setDoctorCardList(List<DoctorCardData> cardDataList) {
        this.mCardDataList = cardDataList;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public DoctorCardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.doctor_card_item, parent, false);
        return new DoctorCardAdapter.ViewHolder(view, mCardDataList);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DoctorCardData cardData = mCardDataList.get(position);
        holder.doctorName.setText(cardData.getmDoctorName());
        holder.doctorSpecialty.setText(cardData.getmDoctorSpecialty());
    }

    @Override
    public int getItemCount() {
        return mCardDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView doctorName;
        public TextView doctorSpecialty;
        public MaterialButton button;

        public ViewHolder(View itemView, final List<DoctorCardData> cardDataList) {
            super(itemView);
            doctorName = itemView.findViewById(R.id.doc_name_apppt);
            doctorSpecialty = itemView.findViewById(R.id.doc_specialty_appt);
            button = itemView.findViewById(R.id.book_appt);


            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    DoctorCardData cardData = cardDataList.get(position);
                    Intent taskIntent = new Intent(v.getContext(), BookAppointment.class);
                    taskIntent.putExtra("DOCTOR_NAME", doctorName.getText().toString());
                    taskIntent.putExtra("DOCTOR_SPECIALTY", doctorSpecialty.getText().toString());
                    v.getContext().startActivity(taskIntent);

                }
            });

        }
    }
}
