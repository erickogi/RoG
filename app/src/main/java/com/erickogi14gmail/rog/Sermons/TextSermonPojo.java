package com.erickogi14gmail.rog.Sermons;

import java.io.Serializable;

/**
 * Created by kimani kogi on 7/23/2017.
 */

public class TextSermonPojo  implements Serializable{
    private int sermon_id;

    private String sermon_link;
    private String sermon_title;
    private String sermon_preview;
    private String sermon_text;
    private String sermon_image;
    private String sermon_date;
    private  String sermon_by;

    public TextSermonPojo() {
    }

    public TextSermonPojo(int sermon_id, String sermon_link, String sermon_title, String sermon_preview, String sermon_text, String sermon_image, String sermon_date, String sermon_by) {
        this.sermon_id = sermon_id;
        this.sermon_link = sermon_link;
        this.sermon_title = sermon_title;
        this.sermon_preview = sermon_preview;
        this.sermon_text = sermon_text;
        this.sermon_image = sermon_image;
        this.sermon_date = sermon_date;
        this.sermon_by = sermon_by;
    }

    public String getSermon_title() {
        return sermon_title;
    }

    public void setSermon_title(String sermon_title) {
        this.sermon_title = sermon_title;
    }

    public int getSermon_id() {
        return sermon_id;
    }

    public void setSermon_id(int sermon_id) {
        this.sermon_id = sermon_id;
    }

    public String getSermon_link() {
        return sermon_link;
    }

    public void setSermon_link(String sermon_link) {
        this.sermon_link = sermon_link;
    }

    public String getSermon_preview() {
        return sermon_preview;
    }

    public void setSermon_preview(String sermon_preview) {
        this.sermon_preview = sermon_preview;
    }

    public String getSermon_text() {
        return sermon_text;
    }

    public void setSermon_text(String sermon_text) {
        this.sermon_text = sermon_text;
    }

    public String getSermon_image() {
        return sermon_image;
    }

    public void setSermon_image(String sermon_image) {
        this.sermon_image = sermon_image;
    }

    public String getSermon_date() {
        return sermon_date;
    }

    public void setSermon_date(String sermon_date) {
        this.sermon_date = sermon_date;
    }

    public String getSermon_by() {
        return sermon_by;
    }

    public void setSermon_by(String sermon_by) {
        this.sermon_by = sermon_by;
    }
}
