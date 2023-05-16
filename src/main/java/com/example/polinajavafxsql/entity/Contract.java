package com.example.polinajavafxsql.entity;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDate;

public class Contract {
    private LocalDate contractData;


    private LocalDate dateOfPayment;


    private int id;


    private int idClient;


    private int idOrganization;

    public LocalDate getContractData() {
        return contractData;
    }

    public void setContractData(LocalDate contractData) {
        this.contractData = contractData;
    }

    public LocalDate getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(LocalDate dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(int idOrganization) {
        this.idOrganization = idOrganization;
    }

    public Contract() {
    }

    public Contract(LocalDate contractData, LocalDate dateOfPayment, int id, int idClient, int idOrganization) {
        this.contractData = contractData;
        this.dateOfPayment = dateOfPayment;
        this.id = id;
        this.idClient = idClient;
        this.idOrganization = idOrganization;
    }
}
