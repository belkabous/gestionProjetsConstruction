package com.example.gestion_construction.model;

public class Projet {
    private int idP;
    private String nomP;
    private String descriptionP;
    private String dateDebutP;
    private String dateFinP;
    private double budget;

    public Projet() {
    }

    public Projet(int idP, String nomP, String descriptionP, String dateDebutP, String dateFinP, double budget) {
        this.idP = idP;
        this.nomP = nomP;
        this.descriptionP = descriptionP;
        this.dateDebutP = dateDebutP;
        this.dateFinP = dateFinP;
        this.budget = budget;
    }

    public Projet(String nomP, String descriptionP, String dateDebutP, String dateFinP, Float budget) {
        this.nomP = nomP;
        this.descriptionP = descriptionP;
        this.dateDebutP = dateDebutP;
        this.dateFinP = dateFinP;
        this.budget = budget;
    }


    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getNomP() {
        return nomP;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    public String getDescriptionP() {
        return descriptionP;
    }

    public void setDescriptionP(String descriptionP) {
        this.descriptionP = descriptionP;
    }

    public String getDateDebutP() {
        return dateDebutP;
    }

    public void setDateDebutP(String dateDebutP) {
        this.dateDebutP = dateDebutP;
    }

    public String getDateFinP() {
        return dateFinP;
    }

    public void setDateFinP(String dateFinP) {
        this.dateFinP = dateFinP;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
}