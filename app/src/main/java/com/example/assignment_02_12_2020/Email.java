package com.example.assignment_02_12_2020;

public class Email {
    private String title;
    private  String details;
    private boolean stared = false;
    private String avatar;

    public Email(String title, String details, String avatar) {
        this.title = title;
        this.details = details;
        this.avatar = avatar;
    }

    public Email(String title, String details, boolean stared, String avatar) {
        this.title = title;
        this.details = details;
        this.stared = stared;
        this.avatar = avatar;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public boolean isStared() {
        return stared;
    }

    public void setStared(boolean stared) {
        this.stared = stared;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
