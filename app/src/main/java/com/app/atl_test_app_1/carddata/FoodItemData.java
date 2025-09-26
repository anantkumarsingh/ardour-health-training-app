package com.app.atl_test_app_1.carddata;

public class FoodItemData {

    private String mFoodItemName;
    private String mFoodItemDetails;
    private String mFoodItemCals;
    private Integer mFoodItemID;


    // Constructor for Type One card data fields
    public FoodItemData(Integer foodItemID, String foodItemName, String FoodItemDetails, String foodItemCals) {
        mFoodItemName = foodItemName;
        mFoodItemDetails = FoodItemDetails;
        mFoodItemCals = foodItemCals;
        mFoodItemID = foodItemID;
    }


    public String getmFoodItemName() {
        return mFoodItemName;
    }

    public String getmFoodItemDetails() {
        return mFoodItemDetails;
    }

    public String getmFoodItemCals() {
        return mFoodItemCals;
    }

   // public Integer getmFoodItemID() {
   //     return mFoodItemID;
  //  }



}
