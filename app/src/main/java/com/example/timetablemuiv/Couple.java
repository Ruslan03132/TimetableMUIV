
package com.example.timetablemuiv;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Couple {

    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("discipline")
    @Expose
    private String discipline;
    @SerializedName("otherInfo")
    @Expose
    private String otherInfo;

    public String getTime() {
        return time;
    }



    public String getDiscipline() {
        return discipline;
    }



    public String getOtherInfo() {
        return otherInfo;
    }



}