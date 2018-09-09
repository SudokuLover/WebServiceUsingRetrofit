package com.example.gauranggoel.webservicesusingretrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gaurang goel on 09-09-2018.
 */

public class Hero {
    @SerializedName("trigger_event")
    private String trigger_event;

    @SerializedName("number")
    private int number;

    public Hero(String trigger_event, int number) {
        this.trigger_event = trigger_event;
        this.number = number;
    }

    public String getTrigger_event() {
        return trigger_event;
    }

    public void setTrigger_event(String trigger_event) {
        this.trigger_event = trigger_event;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
