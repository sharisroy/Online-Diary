package com.example.onlinediary.Model;


public class Userdetails {
    public String id;
    public String name;
    public String email;
    public String address;
    public String password;

    public Userdetails(String id, String name, String email, String address, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    public Userdetails(String id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String address) {
        this.address = address;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
