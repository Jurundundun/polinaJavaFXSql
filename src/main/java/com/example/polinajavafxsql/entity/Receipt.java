package com.example.polinajavafxsql.entity;

public class Receipt {
    private int id;
    private int idContract;

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

    public Receipt() {
    }

    public Receipt(int id, int idContract) {
        this.id = id;
        this.idContract = idContract;
    }
}
