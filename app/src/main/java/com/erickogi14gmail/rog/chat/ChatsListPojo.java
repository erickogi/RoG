package com.erickogi14gmail.rog.chat;

import java.io.Serializable;

/**
 * Created by kimani kogi on 7/26/2017.
 */

public class ChatsListPojo implements Serializable {
    private int chat_id;
    private int chats_no;
    private String sender_name;
    private String sender_message;

    public ChatsListPojo(int chat_id, int chats_no, String sender_name, String sender_message) {
        this.chat_id = chat_id;
        this.chats_no = chats_no;
        this.sender_name = sender_name;
        this.sender_message = sender_message;
    }

    public int getChat_id() {
        return chat_id;
    }

    public void setChat_id(int chat_id) {
        this.chat_id = chat_id;
    }

    public int getChats_no() {
        return chats_no;
    }

    public void setChats_no(int chats_no) {
        this.chats_no = chats_no;
    }

    public String getSender_name() {
        return sender_name;
    }

    public void setSender_name(String sender_name) {
        this.sender_name = sender_name;
    }

    public String getSender_message() {
        return sender_message;
    }

    public void setSender_message(String sender_message) {
        this.sender_message = sender_message;
    }
}
