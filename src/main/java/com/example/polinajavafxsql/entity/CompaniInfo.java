package com.example.polinajavafxsql.entity;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CompaniInfo {

    private String actualAddress;


    private String email;


    private String fioDirector;


    private int id;


    private String lawAddress;


    private String name;


    private String phoneNumber;

    public CompaniInfo(String actualAddress, String email, String fioDirector, int id, String lawAddress, String name, String phoneNumber) {
        this.actualAddress = actualAddress;
        this.email = email;
        this.fioDirector = fioDirector;
        this.id = id;
        this.lawAddress = lawAddress;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public CompaniInfo() {
    }

    public String getActualAddress() {
        return actualAddress;
    }

    public void setActualAddress(String actualAddress) {
        this.actualAddress = actualAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFioDirector() {
        return fioDirector;
    }

    public void setFioDirector(String fioDirector) {
        this.fioDirector = fioDirector;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLawAddress() {
        return lawAddress;
    }

    public void setLawAddress(String lawAddress) {
        this.lawAddress = lawAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
