package dao;

import utildb.UtilDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.*;

public class DAOUser{

    public DAOUser(){

    }

    public User UserAuthentification(String username, String mdp) throws SQLException {
        String query = "select * from economie_user where username = ? and mdp = ?";
        try (Connection conn = UtilDB.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, mdp);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(rs.getInt("id_user"), rs.getString("username"), rs.getString("mdp"));
                }
            }
        }
        return null;
    }


}