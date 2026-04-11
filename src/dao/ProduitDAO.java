package dao;

import config.DatabaseConnection;
import model.Produit;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAO {

    public List<Produit> getAllProduits() {
        List<Produit> produits = new ArrayList<>();
        String query = "SELECT * FROM product";
        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_product");
                String title = rs.getString("title");
                String description = rs.getString("description");
                String etat = rs.getString("etat");
                Date publishDate = rs.getDate("publish_date");
                int idAnnonceur = rs.getInt("id_annonceur");
                int idCategory = rs.getInt("id_category");
                produits.add(new Produit(id, title, description, etat, publishDate, idAnnonceur, idCategory));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return produits;
    }

    public List<Produit> getProduitsByAnnonceur(int idAnnonceur) {
        List<Produit> produits = new ArrayList<>();
        String query = "SELECT * FROM product WHERE id_annonceur = ?";
        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(query)) {
            stmt.setInt(1, idAnnonceur);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_product");
                String title = rs.getString("title");
                String description = rs.getString("description");
                String etat = rs.getString("etat");
                Date publishDate = rs.getDate("publish_date");
                int idCategory = rs.getInt("id_category");
                produits.add(new Produit(id, title, description, etat, publishDate, idAnnonceur, idCategory));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return produits;
    }

    public void insertProduit(String title, String description, String etat, int idAnnonceur, int idCategory) {
        String query = "INSERT INTO product (title, description, etat, id_annonceur, id_category) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(query)) {
            stmt.setString(1, title);
            stmt.setString(2, description);
            stmt.setString(3, etat);
            stmt.setInt(4, idAnnonceur);
            stmt.setInt(5, idCategory);
            stmt.executeUpdate();
            System.out.println("Produit inserted");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}