package com.erickogi14gmail.rog.Hymns;

import java.io.Serializable;

/**
 * Created by kimani kogi on 7/25/2017.
 */

public class HymnsPojo implements Serializable {
    private int hymn_id;
    private int hymn_no;
    private String hymn_title;
    private String hymn_text;

    public HymnsPojo() {
    }

    public HymnsPojo(int hymn_id, int hymn_no, String hymn_title, String hymn_text) {
        this.hymn_id = hymn_id;
        this.hymn_no = hymn_no;
        this.hymn_title = hymn_title;
        this.hymn_text = hymn_text;
    }

    public int getHymn_id() {
        return hymn_id;
    }

    public void setHymn_id(int hymn_id) {
        this.hymn_id = hymn_id;
    }

    public int getHymn_no() {
        return hymn_no;
    }

    public void setHymn_no(int hymn_no) {
        this.hymn_no = hymn_no;
    }

    public String getHymn_title() {
        return hymn_title;
    }

    public void setHymn_title(String hymn_title) {
        this.hymn_title = hymn_title;
    }

    public String getHymn_text() {
        return hymn_text;
    }

    public void setHymn_text(String hymn_text) {
        this.hymn_text = hymn_text;
    }
}
