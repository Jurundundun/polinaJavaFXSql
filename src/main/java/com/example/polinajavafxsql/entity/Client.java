package com.example.polinajavafxsql.entity;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDate;

public class Client {

    private LocalDate birthDateChild;


    private String  email;


    private String fioChild;


    private String  fioParent;


    private int id;


    private String phoneNumber;

    public Client(LocalDate birthDateChild, String email, String fioChild, String fioParent, int id, String phoneNumber) {
        this.birthDateChild = birthDateChild;
        this.email = email;
        this.fioChild = fioChild;
        this.fioParent = fioParent;
        this.id = id;
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthDateChild() {
        return birthDateChild;
    }

    public void setBirthDateChild(LocalDate birthDateChild) {
        this.birthDateChild = birthDateChild;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFioChild() {
        return fioChild;
    }

    public void setFioChild(String fioChild) {
        this.fioChild = fioChild;
    }

    public String getFioParent() {
        return fioParent;
    }

    public void setFioParent(String fioParent) {
        this.fioParent = fioParent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Client() {
    }
}
