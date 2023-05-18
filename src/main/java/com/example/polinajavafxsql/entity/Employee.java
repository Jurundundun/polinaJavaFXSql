package com.example.polinajavafxsql.entity;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDate;

public class Employee {

    private LocalDate birthDate;

    private LocalDate data;

    private String email;

    private String fio;


    private String gen;


    private int id;


    private String idSubdivision;


    private String issuedBy;

    private String nameOfCourse;

    private int pasportNumber;

    private int passportSeries;

    private String phoneNumber;


    private LocalDate whenIssued;

    private int idOrganization;
    private int idPosition;

    public Employee(LocalDate birthDate, String email, String fio, String gen, int id, String idSubdivision, String issuedBy, int pasportNumber, int passportSeries, String phoneNumber, LocalDate whenIssued, int idOrganization, int idPosition) {
        this.birthDate = birthDate;
        this.email = email;
        this.fio = fio;
        this.gen = gen;
        this.id = id;
        this.idSubdivision = idSubdivision;
        this.issuedBy = issuedBy;
        this.pasportNumber = pasportNumber;
        this.passportSeries = passportSeries;
        this.phoneNumber = phoneNumber;
        this.whenIssued = whenIssued;
        this.idOrganization = idOrganization;
        this.idPosition = idPosition;
    }

    public Employee(LocalDate birthDate, String email, String fio, String gen, int id, String phoneNumber, int idOrganization, int idPosition) {
        this.birthDate = birthDate;
        this.email = email;
        this.fio = fio;
        this.gen = gen;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.idOrganization = idOrganization;
        this.idPosition = idPosition;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdSubdivision() {
        return idSubdivision;
    }

    public void setIdSubdivision(String idSubdivision) {
        this.idSubdivision = idSubdivision;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public String getNameOfCourse() {
        return nameOfCourse;
    }

    public void setNameOfCourse(String nameOfCourse) {
        this.nameOfCourse = nameOfCourse;
    }

    public int getPasportNumber() {
        return pasportNumber;
    }

    public void setPasportNumber(int pasportNumber) {
        this.pasportNumber = pasportNumber;
    }

    public int getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(int passportSeries) {
        this.passportSeries = passportSeries;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getWhenIssued() {
        return whenIssued;
    }

    public void setWhenIssued(LocalDate whenIssued) {
        this.whenIssued = whenIssued;
    }

    public int getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(int idOrganization) {
        this.idOrganization = idOrganization;
    }

    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

    public Employee() {
    }

    public Employee(LocalDate birthDate, LocalDate data, String email, String fio, String gen, int id, String idSubdivision, String issuedBy, String nameOfCourse, int pasportNumber, int passportSeries, String phoneNumber, LocalDate whenIssued, int idOrganization, int idPosition) {
        this.birthDate = birthDate;
        this.data = data;
        this.email = email;
        this.fio = fio;
        this.gen = gen;
        this.id = id;
        this.idSubdivision = idSubdivision;
        this.issuedBy = issuedBy;
        this.nameOfCourse = nameOfCourse;
        this.pasportNumber = pasportNumber;
        this.passportSeries = passportSeries;
        this.phoneNumber = phoneNumber;
        this.whenIssued = whenIssued;
        this.idOrganization = idOrganization;
        this.idPosition = idPosition;
    }
}
