package com.app.atl_test_app_1.carddata;

public class DineoutCardData {




    private String mDineoutName;
    private String mDineoutArea;
    private Integer mDineoutImage;



    // Constructor for Type One card data fields
    public DineoutCardData( String dineoutName, String dineoutArea, Integer dineoutImage) {

        mDineoutName = dineoutName;
        mDineoutArea = dineoutArea;
        mDineoutImage = dineoutImage;
    }


    public String getDineoutName() {
        return mDineoutName;
    }

    public void setDineoutName(String dineoutName) {
        mDineoutName = dineoutName;
    }

    public String getDineoutArea() {
        return mDineoutArea;
    }

    public void setDineoutArea(String dineoutArea) {
        mDineoutArea = dineoutArea;
    }

    public Integer getmDineoutImage() {
        return mDineoutImage;
    }

    public void setmDineoutImage(Integer dineoutImage) {
        mDineoutImage = dineoutImage;
    }

}
