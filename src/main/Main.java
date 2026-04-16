package main;

import dao.AnnonceDAO;
import dao.ProduitDAO;

import dao.UserDAO;
import model.Annonce;
import model.Produit;
import model.User;
import service.ServiceVente;

import java.util.List;
import gui.Home;

import gui.annonceur.AnnonceurFrame;
import gui.acheteur.AcheteurFrame;

public class Main {
    //
    public static void main(String[] args) {

        ///// test select * from product
        /*
        ProduitDAO produitDAO = new ProduitDAO();
        List<Produit> produits = produitDAO.getAllProduits();
        System.out.println("===produits tables===");
        for (Produit p : produits) {
            System.out.println(p);
        }

        // // // test select
        AnnonceDAO annonceDAO = new AnnonceDAO();
        List<Annonce> annonces = annonceDAO.getAnnoncesPubliees();
        System.out.println("=== ANNONCES PUBLIEES ===");
        for (Annonce a : annonces) {
            System.out.println(a);
        } */


        // /// test insert
        /*
        ServiceVente service = new ServiceVente();
        boolean venteConclue = service.soumettreProposition(800.00, 1, 2);
        System.out.println("Vente conclue : " + venteConclue);
        */
        //test user
        UserDAO userDAO = new UserDAO();

        userDAO.insertUser(
                "Udeme",
                "Obong-Itoro",
                "1234567890",
                "4326 udem",
                "usol@gmail.com",
                "1111"
        );


        System.out.println("\n user table ");
        List<User> users = userDAO.getAllUsers();
        if (users.isEmpty()) {
            System.out.println("Aucun user trouvé");
        } else {
            for (User u : users) {
                System.out.println("ID: " + u.getId() + " | Name: " + u.getFName() + " " + u.getLName() + " | Email: " + u.getEmail());
            }
        }


    }


//

/*
// test gui
        public static void main(String[] args) {
           // new AnnonceurFrame(1);
            // new AcheteurFrame(1);
            new Home();
        }
 */

}