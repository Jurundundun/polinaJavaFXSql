package com.example.polinajavafxsql.entity;

import java.time.LocalDate;

public class Employee {
    private int id;
    private String fio;
    private LocalDate birthDate;
    private String gen;
    private String phoneNumber;
    private String email;
    private int idOrganization;
    private int idPosition;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Employee(int id, String fio, LocalDate birthDate, String gen, String phoneNumber, String email, int idOrganization, int idPosition) {
        this.id = id;
        this.fio = fio;
        this.birthDate = birthDate;
        this.gen = gen;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.idOrganization = idOrganization;
        this.idPosition = idPosition;
    }

    public Employee() {
    }
}
