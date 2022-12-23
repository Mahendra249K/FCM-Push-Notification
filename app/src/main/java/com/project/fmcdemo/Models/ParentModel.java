package com.project.fmcdemo.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ParentModel {

    @SerializedName("to")
    @Expose
    private String to;

    @SerializedName("data")
    @Expose
    private ChildModel data;


    public ParentModel(String to, ChildModel data) {
        this.to = to;
        this.data = data;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public ChildModel getData() {
        return data;
    }

    public void setData(ChildModel data) {
        this.data = data;
    }

}
