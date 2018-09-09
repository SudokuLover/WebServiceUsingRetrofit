package com.example.gauranggoel.webservicesusingretrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gaurang goel on 09-09-2018.
 */

public class Hero {
    @SerializedName("trigger_event")
    private String event;

    @SerializedName("number")
    private String num;


    public Hero(String event, String num) {
        this.event = event;
        this.num = num;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

}
