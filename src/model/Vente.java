package model;

import java.util.Date;

public class Vente {
    private int idVente;
    private Date dateVente;
    private double prixFinal;
    private int idProposition;

    public Vente(int idVente, Date dateVente, double prixFinal, int idProposition) {
        this.idVente = idVente;
        this.dateVente = dateVente;
        this.prixFinal = prixFinal;
        this.idProposition = idProposition;
    }
    /////////////////////////////////
    public int getIdVente() {
        return idVente;
    }
    public void setIdVente(int idVente) {
        this.idVente = idVente;
    }

    /////////////////////////////////
    public Date getDateVente() {
        return dateVente;
    }
    public void setDateVente(Date dateVente) {
        this.dateVente = dateVente;
    }

    /////////////////////////////////
    public double getPrixFinal() {
        return prixFinal;
    }
    public void setPrixFinal(double prixFinal) {
        this.prixFinal = prixFinal;
    }
    /////////////////////////////////
    public int getIdProposition() {
        return idProposition;
    }
    public void setIdProposition(int idProposition) {
        this.idProposition = idProposition;
    }



    @Override
    public String toString() {
        return "Vente #" + idVente + " - " + prixFinal + "$ le " + dateVente;
    }
}