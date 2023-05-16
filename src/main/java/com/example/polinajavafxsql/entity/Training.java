package com.example.polinajavafxsql.entity;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class Training {

    private LocalDate data;


    private LocalDate dateOfReceiving;


    private int id;


    private int idEmployee;


    private String licenseNumber;


    private String  name;


    private LocalDate recordingDate;

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalDate getDateOfReceiving() {
        return dateOfReceiving;
    }

    public void setDateOfReceiving(LocalDate dateOfReceiving) {
        this.dateOfReceiving = dateOfReceiving;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getRecordingDate() {
        return recordingDate;
    }

    public void setRecordingDate(LocalDate recordingDate) {
        this.recordingDate = recordingDate;
    }

    public Training(LocalDate data, LocalDate dateOfReceiving, int id, int idEmployee, String licenseNumber, String name, LocalDate recordingDate) {
        this.data = data;
        this.dateOfReceiving = dateOfReceiving;
        this.id = id;
        this.idEmployee = idEmployee;
        this.licenseNumber = licenseNumber;
        this.name = name;
        this.recordingDate = recordingDate;
    }

    public Training() {
    }
}
