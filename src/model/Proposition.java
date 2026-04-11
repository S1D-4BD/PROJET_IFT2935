package model;

import java.util.Date;

public class Proposition {
    private int idProposition;
    private double montant;
    private Date dateProposition;
    private String statut;
    private int idAnnonce;
    private int idAcheteur;

    public Proposition(int idProposition, double montant, Date dateProposition, String statut, int idAnnonce, int idAcheteur) {
        this.idProposition = idProposition;
        this.montant = montant;
        this.dateProposition = dateProposition;
        this.statut = statut;
        this.idAnnonce = idAnnonce;
        this.idAcheteur = idAcheteur;
    }

    public int getIdProposition() {
        return idProposition;
    }
    public void setIdProposition(int idProposition) {
        this.idProposition = idProposition;
    }
    /////////////////////// /
    public double getMontant() {
        return montant;
    }
    public void setMontant(double montant) {
        this.montant = montant;
    }
    /////////////////////// /
    public Date getDateProposition() {
        return dateProposition;
    }

    public void setDateProposition(Date dateProposition) {
        this.dateProposition = dateProposition;
    }
    /////////////////////// /
    public String getStatut() {
        return statut;
    }
    public void setStatut(String statut) {
        this.statut = statut;
    }
    /////////////////////// /
    public int getIdAnnonce() {
        return idAnnonce;
    }
    public void setIdAnnonce(int idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    /////////////////////// /
    public int getIdAcheteur() {
        return idAcheteur;
    }
    public void setIdAcheteur(int idAcheteur) {
        this.idAcheteur = idAcheteur;
    }

    @Override
    public String toString() {
        return "proposition " + idProposition + " - " + montant + "$ (" + statut + ")";
    }
}