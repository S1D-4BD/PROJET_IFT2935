package model;

import java.util.Date;

public class Produit {
    private int idProduit;
    private String title;
    private String description;
    private String etat;
    private Date publishDate;
    private int idAnnonceur;
    private int idCategory;

    public Produit(int idProduit, String title, String description, String etat, Date publishDate, int idAnnonceur, int idCategory) {
        this.idProduit = idProduit;
        this.title = title;
        this.description = description;
        this.etat = etat;
        this.publishDate = publishDate;
        this.idAnnonceur = idAnnonceur;
        this.idCategory = idCategory;
    }

    public int getIdProduit() {
        return idProduit;
    }
    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getEtat() {
        return etat;
    }
    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Date getPublishDate() {
        return publishDate;
    }
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public int getIdAnnonceur() {
        return idAnnonceur;
    }
    public void setIdAnnonceur(int idAnnonceur) {
        this.idAnnonceur = idAnnonceur;
    }

    public int getIdCategory() {
        return idCategory;
    }
    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;

    }

    @Override
    public String toString() {
        return title + description + " (" + etat + ")" ;
    }
}