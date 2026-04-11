package dao;

import config.DatabaseConnection;
import model.Proposition;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PropositionDAO {

    public void insertProposition(double montant, int idAnnonce, int idAcheteur) {
        String query = "INSERT INTO proposition (montant, id_annonce, id_acheteur) VALUES (?, ?, ?)";
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setDouble(1, montant);
            stmt.setInt(2, idAnnonce);
            stmt.setInt(3, idAcheteur);
            stmt.executeUpdate();
            System.out.println("proposition inseree");
        } catch (SQLException e) {
            System.out.println("erreur insertProposition : " + e.getMessage());
        }
    }

    public List<Proposition> getPropositionsByAnnonce(int idAnnonce) {
        List<Proposition> propositions = new ArrayList<>();
        String query = "SELECT * FROM proposition WHERE id_annonce = ?";
        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(query)) {
            stmt.setInt(1, idAnnonce);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_proposition");
                double montant = rs.getDouble("montant");
                Date date = rs.getDate("date_proposition");
                String statut = rs.getString("statut");
                int idAnnonce2 = rs.getInt("id_annonce");
                int idAcheteur = rs.getInt("id_acheteur");
                propositions.add(new Proposition(id, montant, date, statut, idAnnonce2, idAcheteur));
            }
        } catch (SQLException e) {
            System.out.println("erreur getPropositionsByAnnonce : " + e.getMessage());
        }
        return propositions;
    }

    public void updateStatut(int idProposition, String statut) {
        String sql = "UPDATE proposition SET statut = ? WHERE id_proposition = ?";
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, statut);
            stmt.setInt(2, idProposition);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("erreur updateStatut proposition : " + e.getMessage());
        }
    }

    public Proposition getLastPropositionByAnnonce(int idAnnonce) {
        String query = "SELECT * FROM proposition WHERE id_annonce = ? ORDER BY montant DESC LIMIT 1";
        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(query)) {
            stmt.setInt(1, idAnnonce);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id_proposition");
                double montant = rs.getDouble("montant");
                Date date = rs.getDate("date_proposition");
                String statut = rs.getString("statut");
                int idAnnonce2 = rs.getInt("id_annonce");
                int idAcheteur = rs.getInt("id_acheteur");
                return new Proposition(id, montant, date, statut, idAnnonce2, idAcheteur);
            }
        } catch (SQLException e) {
            System.out.println("Erreur getLastProposition : " + e.getMessage());
        }
        return null;
    }
}