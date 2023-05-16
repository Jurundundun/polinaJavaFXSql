package com.example.polinajavafxsql.entity;

public class Reviews {

    private int id;


    private int idClient;


    private String reviews;

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

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public Reviews() {
    }

    public Reviews(int id, int idClient, String reviews) {
        this.id = id;
        this.idClient = idClient;
        this.reviews = reviews;
    }
}
