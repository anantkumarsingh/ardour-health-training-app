package com.app.atl_test_app_1.carddata;

public class DonorCardData {

    private String mDonorName;
    private String mDonorEmail;
    private String mDonorDOB;
    private String mDonorPhone;
    private String mDonorAddress;
    private String mDonorBG;


    // Constructor for Type One card data fields
    public DonorCardData(String donorName, String donorEmail, String donorDOB, String donorPhone, String donorAddress, String donorBG) {
        mDonorName = donorName;
        mDonorEmail = donorEmail;
        mDonorDOB = donorDOB;
        mDonorPhone = donorPhone;
        mDonorAddress = donorAddress;
        mDonorBG = donorBG;
    }


    public String getmDonorName() {
        return mDonorName;
    }

    public String getmDonorEmail() {
        return mDonorEmail;
    }

    public String getmDonorDOB() {
        return mDonorDOB;
    }

    public String getmDonorPhone() {
        return mDonorPhone;
    }

    public String getmDonorAddress() {
        return mDonorAddress;
    }

    public String getmDonorBG() {
        return mDonorBG;
    }




}
