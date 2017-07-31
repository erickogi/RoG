package com.erickogi14gmail.rog.Notifications;

/**
 * Created by kimani kogi on 7/22/2017.
 */

public class NotificationsPojo {
    private int notification_id;
    private String notification_title;
    private String notification_message;
    private String notification_date;
    private String notification_department;
    private String notification_image;

    public NotificationsPojo() {
    }

    public NotificationsPojo(int notification_id, String notification_title, String notification_message, String notification_date, String notification_department,String notification_image) {
        this.notification_id = notification_id;
        this.notification_title = notification_title;
        this.notification_message = notification_message;
        this.notification_date = notification_date;
        this.notification_department=notification_department;
        this.notification_image = notification_image;
    }

    public int getNotification_id() {
        return notification_id;
    }

    public void setNotification_id(int notification_id) {
        this.notification_id = notification_id;
    }

    public String getNotification_title() {
        return notification_title;
    }

    public void setNotification_title(String notification_title) {
        this.notification_title = notification_title;
    }

    public String getNotification_message() {
        return notification_message;
    }

    public void setNotification_message(String notification_message) {
        this.notification_message = notification_message;
    }

    public String getNotification_date() {
        return notification_date;
    }

    public void setNotification_date(String notification_date) {
        this.notification_date = notification_date;
    }

    public String getNotification_department() {
        return notification_department;
    }

    public void setNotification_department(String notification_department) {
        this.notification_department = notification_department;
    }

    public String getNotification_image() {
        return notification_image;
    }

    public void setNotification_image(String notification_image) {
        this.notification_image = notification_image;
    }
}
