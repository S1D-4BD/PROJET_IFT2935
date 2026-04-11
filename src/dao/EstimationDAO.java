package dao;

import config.DatabaseConnection;
import model.Estimation;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstimationDAO {


    public static void viewTableEStimation() throws SQLException {
        String query = "SELECT * FROM estimation";
        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery(); //EXECUTE LA QUEERY PREPAREE
            while (rs.next()) {
                int id_estimation = rs.getInt("id_estimation");
                String commentaire  = rs.getString("commentaire");

                System.out.println(id_estimation + ", " + commentaire);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public Estimation getEstimationAccepteeByAnnonce(int idAnnonce) {
        String query = "SELECT * FROM estimation WHERE id_annonce = ? AND statut = 'acceptee'";
        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(query)) {
            stmt.setInt(1, idAnnonce);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id_estimation");
                double montant = rs.getDouble("montant");
                String commentaire = rs.getString("commentaire");
                Date date = rs.getDate("date_estimation");
                String statut = rs.getString("statut");
                int idAnnonce2 = rs.getInt("id_annonce");
                int idExpert = rs.getInt("id_expert");
                return new Estimation(id, montant, commentaire, date, statut, idAnnonce2, idExpert);
            }
        } catch (SQLException e) {
            System.out.println("Erreur getEstimationAcceptee : " + e.getMessage());
        }
        return null;
    }

    public void insertEstimation(double montant, String commentaire, int idAnnonce, int idExpert) {
        String sql = "INSERT INTO estimation (montant, commentaire, id_annonce, id_expert) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
            stmt.setDouble(1, montant);
            stmt.setString(2, commentaire);
            stmt.setInt(3, idAnnonce);
            stmt.setInt(4, idExpert);
            stmt.executeUpdate();
            System.out.println("inserted estimation");
        } catch (SQLException e) {
            System.out.println("Erreur insertEstimation : " + e.getMessage());
        }
    }

    public void updateStatut(int idEstimation, String statut) {
        String sql = "UPDATE estimation SET statut = ? WHERE id_estimation = ?";
        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
            stmt.setString(1, statut);
            stmt.setInt(2, idEstimation);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error updateStatut estimation : " + e.getMessage());
        }
    }

    public List<Estimation> getEstimationsByAnnonce(int idAnnonce) {
        List<Estimation> estimations = new ArrayList<>();
        String sql = "SELECT * FROM estimation WHERE id_annonce = ?";
        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, idAnnonce);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                int id = rs.getInt("id_estimation");
                double montant = rs.getDouble("montant");
                String commentaire = rs.getString("commentaire");
                Date date = rs.getDate("date_estimation");
                String statut = rs.getString("statut");
                int id_annonce = rs.getInt("id_annonce");
                int id_expert = rs.getInt("id_expert");

                estimations.add(new Estimation(id,montant,commentaire,date,statut,id_annonce,id_expert));
            }
        } catch (SQLException e) {
            System.out.println("Erreur getEstimationsByAnnonce : " + e.getMessage());
        }
        return estimations;
    }
}