package com.example.gestion_construction.model;

public class Ressource {
    private int idR;
    private String nomR;
    private String type;
    private float quantite;

    public Ressource() {
    }

    public Ressource(int idR, String nomR, String type, float quantite) {
        this.idR = idR;
        this.nomR = nomR;
        this.type = type;
        this.quantite = quantite;
    }

    public Ressource(String nomR, String type, float quantite) {
        this.nomR = nomR;
        this.type = type;
        this.quantite = quantite;
    }


    public int getIdR() {
        return idR;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    public String getNomR() {
        return nomR;
    }

    public void setNomR(String nomR) {
        this.nomR = nomR;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getQuantite() {
        return quantite;
    }

    public void setQuantite(float quantite) {
        this.quantite = quantite;
    }
}
