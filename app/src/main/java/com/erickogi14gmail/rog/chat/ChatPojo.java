package com.erickogi14gmail.rog.chat;

import java.io.Serializable;

/**
 * Created by kimani kogi on 7/26/2017.
 */

public class ChatPojo implements Serializable {
    private int group_id;
    private int message_id;
    private int fromid;

    private String message_text;
    private String from_name;

    public ChatPojo(int group_id,int message_id, int fromid, String message_text, String from_name) {
        this.group_id=group_id;
        this.message_id = message_id;
        this.fromid = fromid;
        this.message_text = message_text;
        this.from_name=from_name;
    }

    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public int getFromid() {
        return fromid;
    }

    public void setFromid(int fromid) {
        this.fromid = fromid;
    }

    public String getMessage_text() {
        return message_text;
    }

    public void setMessage_text(String message_text) {
        this.message_text = message_text;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getFrom_name() {
        return from_name;
    }

    public void setFrom_name(String from_name) {
        this.from_name = from_name;
    }
}
