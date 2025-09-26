package com.app.atl_test_app_1.carddata;

public class DoctorCardData {


    private String mDoctorName;
    private String mDoctorSpecialty;
    private Integer mDoctorImg;
    private String mWorkoutID;

    // Constructor for Type One card data fields
    public DoctorCardData(String doctorName, String doctorSpecialty, Integer doctorImg) {
        mDoctorName = doctorName;
        mDoctorSpecialty = doctorSpecialty;
        mDoctorImg = doctorImg;
    }


    public String getmDoctorName() {
        return mDoctorName;
    }

    public String getmDoctorSpecialty() {
        return mDoctorSpecialty;
    }

    public Integer getmDoctorImg() {
        return mDoctorImg;
    }

}
