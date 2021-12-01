package com.example.timetablemuiv;

import android.icu.util.Calendar;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Post {
    @SerializedName("userId")
    @Expose
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @SerializedName("faculty")
    @Expose
    private String faculty;
    @SerializedName("formOfEdu")
    @Expose
    private String formOfEdu;
    @SerializedName("cource")
    @Expose
    private String cource;
    @SerializedName("weekId")
    @Expose
    private String weekId;
    @SerializedName("group")
    @Expose
    private List<com.example.timetablemuiv.Group> group = null;

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getFormOfEdu() {
        return formOfEdu;
    }

    public void setFormOfEdu(String formOfEdu) {
        this.formOfEdu = formOfEdu;
    }

    public String getCource() {
        return cource;
    }

    public void setCource(String cource) {
        this.cource = cource;
    }

    public String getWeekId() {
        return weekId;
    }

    public void setWeekId(String weekId) {
        this.weekId = weekId;
    }

    public List<com.example.timetablemuiv.Group> getGroup() {
        return group;
    }



}