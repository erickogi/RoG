package com.erickogi14gmail.rog.Events;

import java.io.Serializable;

/**
 * Created by kimani kogi on 7/23/2017.
 */

public class EventsPojo implements Serializable{
    private int event_id;
    private String event_title;

    private String event_image;
    private String event_preview;
    private String event_date;
    private String event_time;
    private String event_place;
    private String event_description;


    public EventsPojo() {
    }

    public EventsPojo(int event_id, String event_title, String event_image, String event_preview, String event_date, String event_time, String event_place, String event_description) {
        this.event_id = event_id;
        this.event_title = event_title;
        this.event_image = event_image;
        this.event_preview = event_preview;
        this.event_date = event_date;
        this.event_time = event_time;
        this.event_place = event_place;
        this.event_description = event_description;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getEvent_title() {
        return event_title;
    }

    public void setEvent_title(String event_title) {
        this.event_title = event_title;
    }

    public String getEvent_image() {
        return event_image;
    }

    public void setEvent_image(String event_image) {
        this.event_image = event_image;
    }

    public String getEvent_preview() {
        return event_preview;
    }

    public void setEvent_preview(String event_preview) {
        this.event_preview = event_preview;
    }

    public String getEvent_date() {
        return event_date;
    }

    public void setEvent_date(String event_date) {
        this.event_date = event_date;
    }

    public String getEvent_time() {
        return event_time;
    }

    public void setEvent_time(String event_time) {
        this.event_time = event_time;
    }

    public String getEvent_place() {
        return event_place;
    }

    public void setEvent_place(String event_place) {
        this.event_place = event_place;
    }

    public String getEvent_description() {
        return event_description;
    }

    public void setEvent_description(String event_description) {
        this.event_description = event_description;
    }
}
