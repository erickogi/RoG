package com.erickogi14gmail.rog.Prayer;

import java.io.Serializable;

/**
 * Created by kimani kogi on 8/14/2017.
 */

public class prayerPojo implements Serializable {
    private  int prayer_id;
    private String prayer_request_title;
    private String prayer_request_text;
    private String prayer_request_date;
    private String prayer_request_name;
    private String prayer_request_email;
    private String prayer_request_full_text;

    public prayerPojo(int prayer_id, String prayer_request_title, String prayer_request_text, String prayer_request_date, String prayer_request_name, String prayer_request_email,String prayer_request_full_text) {
        this.prayer_id = prayer_id;
        this.prayer_request_title = prayer_request_title;
        this.prayer_request_text = prayer_request_text;
        this.prayer_request_date = prayer_request_date;
        this.prayer_request_name = prayer_request_name;
        this.prayer_request_email = prayer_request_email;
        this.prayer_request_full_text= prayer_request_full_text;
    }

    public int getPrayer_id() {
        return prayer_id;
    }

    public void setPrayer_id(int prayer_id) {
        this.prayer_id = prayer_id;
    }

    public String getPrayer_request_title() {
        return prayer_request_title;
    }

    public void setPrayer_request_title(String prayer_request_title) {
        this.prayer_request_title = prayer_request_title;
    }

    public String getPrayer_request_text() {
        return prayer_request_text;
    }

    public void setPrayer_request_text(String prayer_request_text) {
        this.prayer_request_text = prayer_request_text;
    }

    public String getPrayer_request_date() {
        return prayer_request_date;
    }

    public void setPrayer_request_date(String prayer_request_date) {
        this.prayer_request_date = prayer_request_date;
    }

    public String getPrayer_request_name() {
        return prayer_request_name;
    }

    public void setPrayer_request_name(String prayer_request_name) {
        this.prayer_request_name = prayer_request_name;
    }

    public String getPrayer_request_email() {
        return prayer_request_email;
    }

    public void setPrayer_request_email(String prayer_request_email) {
        this.prayer_request_email = prayer_request_email;
    }

    public String getPrayer_request_full_text() {
        return prayer_request_full_text;
    }

    public void setPrayer_request_full_text(String prayer_request_full_text) {
        this.prayer_request_full_text = prayer_request_full_text;
    }
}
