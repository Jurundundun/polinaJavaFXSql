package com.example.polinajavafxsql.entity;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDate;

public class Tabletime {

    private LocalDate data;

    private String dayOfTheWeek;


    private int id;


    private int idOrganization;

    private int idService;
    private String  time;

    public Tabletime() {
    }

    public Tabletime(LocalDate data, String dayOfTheWeek, int id, int idOrganization, int idService, String time) {
        this.data = data;
        this.dayOfTheWeek = dayOfTheWeek;
        this.id = id;
        this.idOrganization = idOrganization;
        this.idService = idService;
        this.time = time;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public void setDayOfTheWeek(String dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(int idOrganization) {
        this.idOrganization = idOrganization;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
