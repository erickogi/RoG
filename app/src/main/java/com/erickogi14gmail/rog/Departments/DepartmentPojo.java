package com.erickogi14gmail.rog.Departments;

import java.io.Serializable;

/**
 * Created by kimani kogi on 8/15/2017.
 */

public class DepartmentPojo implements Serializable {
    private String phoneNo;
    private String emailAddress;
    private String text;

    public DepartmentPojo(String phoneNo, String text, String emailAddress) {
        this.phoneNo = phoneNo;
        this.emailAddress = emailAddress;
        this.text = text;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
