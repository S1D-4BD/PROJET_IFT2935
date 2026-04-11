package model;

import java.util.Date;

public class Estimation {
    private int idEstimation;
    private double montant;
    private String commentaire;
    private Date dateEstimation;
    private String statut;
    private int idAnnonce;
    private int idExpert;

    public Estimation(int idEstimation, double montant, String commentaire, Date dateEstimation, String statut, int idAnnonce, int idExpert) {
        this.idEstimation = idEstimation;
        this.montant = montant;
        this.commentaire = commentaire;
        this.dateEstimation = dateEstimation;
        this.statut = statut;
        this.idAnnonce = idAnnonce;
        this.idExpert = idExpert;
    }

    public int getIdEstimation() {
        return idEstimation;
    }
    public void setIdEstimation(int idEstimation) {
        this.idEstimation = idEstimation;
    }
    ////////////////////////
    public double getMontant() {
        return montant;
    }
    public void setMontant(double montant) {
        this.montant = montant;
    }
    ////////////////////////
    public String getCommentaire() {
        return commentaire;
    }
    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
    ////////////////////////
    public Date getDateEstimation() {
        return dateEstimation;
    }

    public void setDateEstimation(Date dateEstimation) {
        this.dateEstimation = dateEstimation;
    }
    ////////////////////////
    public String getStatut() {
        return statut;
    }
    public void setStatut(String statut) {
        this.statut = statut;
    }

    ////////////////////////
    public int getIdAnnonce() {
        return idAnnonce;
    }
    public void setIdAnnonce(int idAnnonce) {
        this.idAnnonce = idAnnonce;
    }
    ////////////////////////
    public int getIdExpert() {
        return idExpert;
    }
    public void setIdExpert(int idExpert) {
        this.idExpert = idExpert;
    }
    ////////////////////////



    @Override
    public String toString() {
        return "Estimation #" + idEstimation + " - " + montant + "$ (" + statut + ")";
    }
}