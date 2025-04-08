package dao;

import utildb.UtilDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.Prevision;

public class DAOPrevision {

    public DAOPrevision() {
        // Constructeur vide
    }

    // Ajoute une nouvelle prévision (crédit)
    public void addPrevision(int userId, String description, double amount) {
        String sql = "INSERT INTO economie_prevision (id_user, libelle, montant) VALUES (?, ?, ?)";

        try (Connection conn = UtilDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            stmt.setString(2, description);
            stmt.setDouble(3, amount);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Récupère toutes les prévisions
    public List<Prevision> getAllPrevisions() {
        List<Prevision> previsions = new ArrayList<>();
        String sql = "SELECT * FROM economie_prevision";

        try (Connection conn = UtilDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Prevision prevision = new Prevision(
                    rs.getInt("id_prevision"),
                    rs.getInt("id_user"),
                    rs.getString("libelle"),
                    rs.getDouble("montant")
                );
                previsions.add(prevision);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return previsions;
    }

    // Récupère une prévision par son ID
    public Prevision getPrevisionById(int previsionId) {
        String sql = "SELECT * FROM economie_prevision WHERE id_prevision = ?";

        try (Connection conn = UtilDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, previsionId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Prevision(
                        rs.getInt("id_prevision"),
                        rs.getInt("id_user"),
                        rs.getString("libelle"),
                        rs.getDouble("montant")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Calcule le reste disponible après les dépenses
    public double calculateRemainingAmount(int userId, int previsionId) {
        Prevision prevision = getPrevisionById(previsionId);
        DAODepense depenseDAO = new DAODepense();

        if (prevision == null) return 0;

        double totalPlanned = prevision.getMontant();
        double totalSpent = depenseDAO.getTotalDepense(userId, previsionId);

        return totalPlanned - totalSpent;
    }
}
