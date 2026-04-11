package dao;

import config.DatabaseConnection;
import model.Vente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VenteDAO {

    public void insertVente(double prixFinal, int idProposition) {
        String query = "INSERT INTO vente (prix_final, id_proposition) VALUES (?, ?)";
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setDouble(1, prixFinal);
            stmt.setInt(2, idProposition);
            stmt.executeUpdate();
            System.out.println("VENTE DONE");
        } catch (SQLException e) {
            System.out.println("ERREUR VENTE : " + e.getMessage());
        }
    }
    public List<Vente> getAllVentes() {
        List<Vente> ventes = new ArrayList<>();
        String query = "SELECT * FROM vente";
        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_vente");
                Date date = rs.getDate("date_vente");
                double prixFinal = rs.getDouble("prix_final");
                int idProposition = rs.getInt("id_proposition");
                ventes.add(new Vente(id, date, prixFinal, idProposition));
            }
        } catch (SQLException e) {
            System.out.println("erreur get : " + e.getMessage());
        }
        return ventes;
    }

    public boolean venteExistePourProposition(int idProposition) {
        String sql = "SELECT COUNT(*) FROM vente WHERE id_proposition = ?";
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idProposition);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.out.println("erreur existe : " + e.getMessage());
        }
        return false;
    }
}