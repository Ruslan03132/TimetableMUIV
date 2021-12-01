package com.example.timetablemuiv;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Week {

    @SerializedName("dayName")
    @Expose
    private String dayName;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("couples")
    @Expose
    private List<Couple> couples = null;

    public String getDayName() {
        return dayName;
    }
    public String getDate() {
        return date;
    }
  public List<Couple> getCouples() {
        return couples;
    }
}