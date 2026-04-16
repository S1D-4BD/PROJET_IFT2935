package dao;

import config.DatabaseConnection;
import model.Annonce;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


//source : https://docs.oracle.com/javase/tutorial/jdbc/basics/retrieving.html
public class AnnonceDAO {

    /// TOUTES LES METHODES quon peut call pour une annonce, c est pr chaque methode une query sql possible

    // very nice, on a vu les requetes preparees en ift3225, on prepare also pour eviter les injections sql

    public List<Annonce> getAnnoncesPubliees() {
        List<Annonce> annonces = new ArrayList<>(); // on s attend a recevoir une liste d annonces
        String query = "SELECT * FROM annonce WHERE statut = 'publiee'"; // on recup tout le contenu de la table annonce dont le statut est publiee
        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(query)) { // on instancie la query
            ResultSet rs = stmt.executeQuery(); //on execute la query
            while (rs.next()) { // la query obtenue est un tableau, ilf aut quon recup pour chaque ligne du tableau recu les informations des colonnes
                int id = rs.getInt("id_annonce");
                int idProduct = rs.getInt("id_product");
                double proposedPrice = rs.getDouble("proposed_price");
                String statut = rs.getString("statut");
                annonces.add(new Annonce(id, idProduct, proposedPrice, statut)); // apres avoir eu tt les fields, on instancie l'objet annonce recues et on concatene a la liste reponse quon attend du debut
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return annonces;
    }

    public Annonce getAnnonceById(int idAnnonce) {
        String query = "SELECT * FROM annonce WHERE id_annonce = ?";
        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(query)) {
            stmt.setInt(1, idAnnonce);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id_annonce");
                int idProduct = rs.getInt("id_product");
                double proposedPrice = rs.getDouble("proposed_price");
                String statut = rs.getString("statut");
                return new Annonce(id, idProduct, proposedPrice, statut);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void insertAnnonce(int idProduct, double proposedPrice) {
        String query = "INSERT INTO annonce (id_product, proposed_price) VALUES (?, ?)";
        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(query)) {
            stmt.setInt(1, idProduct);
            stmt.setDouble(2, proposedPrice);
            stmt.executeUpdate();
            System.out.println("insert annonce");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateStatut(int idAnnonce, String statut) {
        String query = "UPDATE annonce SET statut = ? WHERE id_annonce = ?";
        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(query)) {
            stmt.setString(1, statut);
            stmt.setInt(2, idAnnonce);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void deleteAnnonceById(int idAnnonce) {
        return;
    }
}