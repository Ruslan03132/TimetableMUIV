package com.example.timetablemuiv;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Group {

    @SerializedName("groupName")
    @Expose
    private String groupName;
    @SerializedName("week")
    @Expose
    private List<Week> week = null;

    public String getGroupName() {
        return groupName;
    }



    public List<Week> getWeek() {
        return week;
    }



}