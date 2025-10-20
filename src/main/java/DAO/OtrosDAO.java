package DAO;

import UTIL.MySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OtrosDAO {
 
    private final MySQL conexion = new MySQL();
    
    // Método para obtener HisCod por DNIPac
    public int obtenerHisCodPorDNIPac(String idPac) {
        int hisCod = -1; // Si no encuentra nada, devuelve -1
        String sql = "SELECT id_historia FROM historiaclinica WHERE id_paciente = ?";

        // Declarar conexión
        try (Connection conn = conexion.establecerConexion(); // Obtener conexión
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, idPac); // Asignar el valor del parámetro
            try (ResultSet rs = ps.executeQuery()) { // Ejecutar la consulta
                if (rs.next()) {
                    hisCod = rs.getInt("id_historia"); // Obtener el HisCod
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener id_historia: " + e.getMessage());
        }
        return hisCod; // Retorna el HisCod o -1 si no se encontró
    }
    
    
    public String obtenerNombrePorDNI(String dniPac) {
        String nombre=null;// Si no encuentra nada, devuelve -1 SUPUESTAMENTE DEBE SER NULL PERO SI FUNCIONA DEJEMOSLO ASI
        String sql = "SELECT nombre, apellido FROM paciente WHERE DNI = ?";

        // Declarar conexión
        try (Connection conn = conexion.establecerConexion(); // Obtener conexión
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, dniPac); // Asignar el valor del parámetro
            
            try (ResultSet rs = ps.executeQuery()) { // Ejecutar la consulta
                if (rs.next()) {
                    nombre = rs.getString("nombre")+" "+rs.getString("apellido"); // Obtener el Nombre
                    System.out.println("Nombre encontrado");
                }else{
                    System.out.println("No se encontro ningun nombre con dni"+dniPac);
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Error al obtener el nombre: " + e.getMessage());
        }
        return nombre; // Retorna el HisCod o -1 si no se encontró
    }
}
