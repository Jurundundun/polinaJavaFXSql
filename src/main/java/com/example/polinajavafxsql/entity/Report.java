package com.example.polinajavafxsql.entity;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class Report {

    private LocalDate data;


    private int id;


    private int idContract;


    private int idEmployee;


    private int idService;

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdContract() {
        return idContract;
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public Report(LocalDate data, int id, int idContract, int idEmployee, int idService) {
        this.data = data;
        this.id = id;
        this.idContract = idContract;
        this.idEmployee = idEmployee;
        this.idService = idService;
    }

    public Report() {
    }
}
