package com.erickogi14gmail.rog.Service;

import java.io.Serializable;

/**
 * Created by kimani kogi on 8/16/2017.
 */

public class DaysPojo implements Serializable {
    private int id;
    private String day;
    private String date;
    private String content;

    public DaysPojo(int id, String day, String date,String content) {
        this.id = id;
        this.day = day;
        this.date = date;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
