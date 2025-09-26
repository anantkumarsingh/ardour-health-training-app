package com.app.atl_test_app_1.carddata;

public class TrainingCardData  {



    private String mTrainingCentreName;
    private String mTrainingCentreArea;
    private Integer mTrainingCentreImage;

    // Constructor for Type One card data fields
    public TrainingCardData(String trainingCentreName, String trainingCentreArea, Integer trainingCentreImage) {
        mTrainingCentreName = trainingCentreName;
        mTrainingCentreArea = trainingCentreArea;
        mTrainingCentreImage = trainingCentreImage;
    }


    public String getTrainingCentreName() {
        return mTrainingCentreName;
    }

    public void setTrainingCentreName(String trainingCentreName) {
        mTrainingCentreName = trainingCentreName;
    }

    public String getTrainingCentreArea() {
        return mTrainingCentreArea;
    }

    public void setTrainingCentreArea(String trainingCentreArea) {
        mTrainingCentreArea = trainingCentreArea;
    }

    public Integer getmTrainingCentreImage() {
        return mTrainingCentreImage;
    }

    public void setmTrainingCentreImage(Integer trainingCentreImage) {
        mTrainingCentreImage = trainingCentreImage;
    }

}