package com.example.polinajavafxsql.entity;

public class Service {
    private int id;
    private String name;
    private String price;
    private int idOrganization;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(int idOrganization) {
        this.idOrganization = idOrganization;
    }

    public Service(int id, String name, String price, int idOrganization) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.idOrganization = idOrganization;
    }

    public Service() {
    }
}
