package UTIL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/mi_base";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public Connection establecerConexion() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException("Error al conectar a la BD", e);
        }
    }
}
