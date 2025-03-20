package com.example.gestion_construction.model;

public class Tache {

    private int idT;
    private String nomT;
    private String descriptionT;
    private String dateDebutT;
    private String dateFinT;

    public Tache() {
    }

    public Tache(int idT, String nomT, String descriptionT, String dateDebutT, String dateFinT) {
        this.idT = idT;
        this.nomT = nomT;
        this.descriptionT = descriptionT;
        this.dateDebutT = dateDebutT;
        this.dateFinT = dateFinT;
    }

    public int getIdT() {
        return idT;
    }

    public void setIdT(int idT) {
        this.idT = idT;
    }

    public String getNomT() {
        return nomT;
    }

    public void setNomT(String nomT) {
        this.nomT = nomT;
    }

    public String getDescriptionT() {
        return descriptionT;
    }

    public void setDescriptionT(String descriptionT) {
        this.descriptionT = descriptionT;
    }

    public String getDateDebutT() {
        return dateDebutT;
    }

    public void setDateDebutT(String dateDebutT) {
        this.dateDebutT = dateDebutT;
    }

    public String getDateFinT() {
        return dateFinT;
    }

    public void setDateFinT(String dateFinT) {
        this.dateFinT = dateFinT;
    }
}
