package dao;

import utildb.UtilDB;
import java.sql.*;
import models.*;

public class DAODepense {

    public DAODepense() {
        
    }

    public void addDepense(int userId, int previsionId, double amount) {
        DAOPrevision previsionDAO = new DAOPrevision();
        double remainingAmount = previsionDAO.calculateRemainingAmount(userId, previsionId);
        double totalDepenses = getTotalDepense(userId, previsionId) + amount;

        String sql = "INSERT INTO economie_depense (id_user, id_prevision, montant) VALUES (?, ?, ?)";

        if (remainingAmount > totalDepenses) {
            try (Connection conn = UtilDB.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setInt(1, userId);
                stmt.setInt(2, previsionId);
                stmt.setDouble(3, amount);
                stmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
          
        }
    }

    public double getTotalDepense(int userId, int previsionId) {
        String sql = "SELECT SUM(montant) AS total FROM economie_depense WHERE id_user = ? AND id_prevision = ?";
        double total = 0.0;

        try (Connection conn = UtilDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            stmt.setInt(2, previsionId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    total = rs.getDouble("total");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return total;
    }
}
