package com.erickogi14gmail.rog.Appointment;

import java.io.Serializable;

/**
 * Created by kimani kogi on 8/15/2017.
 */

public class AppointmentPojo implements Serializable {
    private int id;
    private String day;
    private String time;
    private String to;
    private String comment;
    private int status;

    public AppointmentPojo(int id, String day, String time, String to, String comment, int status) {
        this.id = id;
        this.day = day;
        this.time = time;
        this.to = to;
        this.comment = comment;
        this.status = status;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
