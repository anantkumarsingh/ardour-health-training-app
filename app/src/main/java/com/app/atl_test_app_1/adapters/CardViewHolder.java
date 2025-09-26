package com.app.atl_test_app_1.adapters;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.app.atl_test_app_1.R;
import com.app.atl_test_app_1.carddata.CardData;

public class CardViewHolder extends RecyclerView.ViewHolder {

    public TextView docName;
    public TextView docSpecialty;
    public TextView aptDate;
    public TextView aptTime;
    public TextView hospitalName;
    public TextView hospitalArea;

    public CardViewHolder(View itemView) {
        super(itemView);

        //DOC
        docName = itemView.findViewById(R.id.doc_name);
        docSpecialty = itemView.findViewById(R.id.doc_specialty);
        aptDate = itemView.findViewById(R.id.date_appointment);
        aptTime = itemView.findViewById(R.id.time_appointment);

        //HOSPITAL
        hospitalName=itemView.findViewById(R.id.hospital_name);
        hospitalArea=itemView.findViewById(R.id.hospital_area);
    }

    public void bind(CardData cardData) {
        docName.setText(cardData.getDocName());
        docSpecialty.setText(cardData.getDocSpec());
        aptDate.setText(cardData.getAptDate());
        aptTime.setText(cardData.getAptTime());
    }



}
