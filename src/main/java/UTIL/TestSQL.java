/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTIL;

import java.sql.Connection;
import java.sql.SQLException;

public class TestSQL {

    public static void main(String[] args) {
        MySQL mysql = new MySQL();

        try (Connection conn = mysql.establecerConexion()) {
            if (conn != null) {
                System.out.println("✅ Conectado correctamente a la base de datos.");
            } else {
                System.out.println("❌ La conexión retornó null.");
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar: " + e.getMessage());
        }
    }
}
