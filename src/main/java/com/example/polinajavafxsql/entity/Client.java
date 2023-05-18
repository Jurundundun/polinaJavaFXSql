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


    private LocalDate dataContract;


    private LocalDate dateOfPayment;



    private int idContract;


    private int idReciept;


    private String idSubdivision;


    private String issuedBy;


    private int pasportNumber;


    private int passportSeries;


    private String review;
    private LocalDate whenIssued;

    public Client(LocalDate birthDateChild, String email, String fioChild, String fioParent, int id, String phoneNumber, String idSubdivision, String issuedBy, int pasportNumber, int passportSeries, LocalDate whenIssued) {
        this.birthDateChild = birthDateChild;
        this.email = email;
        this.fioChild = fioChild;
        this.fioParent = fioParent;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.idSubdivision = idSubdivision;
        this.issuedBy = issuedBy;
        this.pasportNumber = pasportNumber;
        this.passportSeries = passportSeries;
        this.whenIssued = whenIssued;
    }

    public Client(LocalDate birthDateChild, String email, String fioChild, String fioParent, int id, String phoneNumber, LocalDate dataContract, LocalDate dateOfPayment, int idContract, int idReciept, String idSubdivision, String issuedBy, int pasportNumber, int passportSeries, String review, LocalDate whenIssued) {
        this.birthDateChild = birthDateChild;
        this.email = email;
        this.fioChild = fioChild;
        this.fioParent = fioParent;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.dataContract = dataContract;
        this.dateOfPayment = dateOfPayment;
        this.idContract = idContract;
        this.idReciept = idReciept;
        this.idSubdivision = idSubdivision;
        this.issuedBy = issuedBy;
        this.pasportNumber = pasportNumber;
        this.passportSeries = passportSeries;
        this.review = review;
        this.whenIssued = whenIssued;
    }

    public LocalDate getWhenIssued() {
        return whenIssued;
    }

    public void setWhenIssued(LocalDate whenIssued) {
        this.whenIssued = whenIssued;
    }

    public LocalDate getDataContract() {
        return dataContract;
    }

    public void setDataContract(LocalDate dataContract) {
        this.dataContract = dataContract;
    }

    public LocalDate getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(LocalDate dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public int getIdContract() {
        return idContract;
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }

    public int getIdReciept() {
        return idReciept;
    }

    public void setIdReciept(int idReciept) {
        this.idReciept = idReciept;
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

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }


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
