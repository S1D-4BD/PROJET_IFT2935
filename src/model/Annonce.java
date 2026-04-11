package model;

public class Annonce {
    private int idAnnonce;
    private int idProduct;
    private double proposedPrice;
    private String statut;

    public Annonce(int idAnnonce, int idProduct, double proposedPrice, String statut) {
        this.idAnnonce = idAnnonce;
        this.idProduct = idProduct;
        this.proposedPrice = proposedPrice;
        this.statut = statut;
    }

    public int getIdAnnonce() {
        return idAnnonce;
    }
    public void setIdAnnonce(int idAnnonce) {
        this.idAnnonce = idAnnonce;
    }
    //////////////
    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    ////////////////
    public double getProposedPrice() {
        return proposedPrice;
    }
    public void setProposedPrice(double proposedPrice) {
        this.proposedPrice = proposedPrice;
    }

    ////////////////
    public String getStatut() {
        return statut;
    }
        public void setStatut(String statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "Annonce #" + idAnnonce + " - " + proposedPrice + "$ (" + statut + ")";
    }
}