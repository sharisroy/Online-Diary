package com.example.onlinediary.Model;

public class Notes {

    public String id;
    public String name;
    public String details;
    public String date;
    public String userId;

    public Notes() {
    }

    public Notes(String id, String name, String details, String date, String userId) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.date = date;
        this.userId = userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public String getDate() {
        return date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
