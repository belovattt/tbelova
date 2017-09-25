package ru.job4j.bank;

public class Account {
    private String requisites;
    private double value;

    public Account(String requisites, double value) {
        this.requisites = requisites;
        this.value = value;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
