package com.app.atl_test_app_1.carddata;

public class WorkoutCardData {


    private String mWorkoutName;
    private String mWorkoutTask;
    private Integer mWorkoutImg;
    private String mWorkoutID;

    // Constructor for Type One card data fields
    public WorkoutCardData(String workoutName, String workoutTask, Integer workoutImg, String workoutID) {
        mWorkoutName = workoutName;
        mWorkoutTask = workoutTask;
        mWorkoutImg = workoutImg;
        mWorkoutID = workoutID;
    }


    public String getmWorkoutName() {
        return mWorkoutName;
    }

    public void setmWorkoutName(String workoutName) {
        mWorkoutName = workoutName;
    }

    public String getmWorkoutTask() {
        return mWorkoutTask;
    }

    public void setmWorkoutTask(String workoutTask) {
        mWorkoutTask = workoutTask;
    }

    public Integer getmWorkoutImg() {
        return mWorkoutImg;
    }

    public String getmWorkoutID() {
        return mWorkoutID;
    }

    public void setmWorkoutImg(Integer workoutImg) {
        mWorkoutImg = workoutImg;
    }


}
