package utildb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilDB {
    private static final String URL = "jdbc:mysql://172.80.237.53:3306/db_s2_ETU003321";
    private static final String USER = "ETU003321";
    private static final String PASSWORD = "5f6bbtBW";


    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connexion réussie !");
            return connection;
        } catch (ClassNotFoundException e) {
            System.err.println("Pilote MySQL non trouvé : " + e.getMessage());
            throw new SQLException("Pilote non chargé", e);
        } catch (SQLException e) {
            System.err.println("Erreur de connexion : " + e.getMessage());
            throw e;
        }
    }
}