package DAO;

import MODEL.RegistroModel;
import UTIL.Conexion;
import UTIL.StaticVariables;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistroDAO {
    Conexion conexion = new Conexion();  
    //CRUD
    
    //CREATE
    public void crearRegistro(RegistroModel registro) throws SQLException {
    String sql = "INSERT INTO registro (id_caso, evolucion) VALUES (?, ?)";

    try (Connection conn = conexion.establecerConexion();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, registro.getId_caso());
        stmt.setString(2, registro.getEvolucion());

        int filas = stmt.executeUpdate();

        if (filas > 0) {
            System.out.println("✅ Registro creado correctamente");
        } else {
            System.out.println("⚠ No se insertó ningún registro");
        }

    } catch (SQLException e) {
        System.err.println("❌ Error al crear un nuevo registro: " + e.getMessage());
        throw e;
    }
}

    //READ
    public List<RegistroModel> listarResgistros() {
    List<RegistroModel> registros = new ArrayList<>();
    String query = "SELECT id_registro, id_caso, evolucion, fecha FROM registro ";
//    String query = "SELECT id_registro, id_caso, evolucion, fecha FROM registro WHERE id_caso = ?";

    try (Connection conn = conexion.establecerConexion();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        // Esta línea va después de abrir el PreparedStatement, no dentro de los parentersis del try
        stmt.setInt(1, StaticVariables.Hiscod);
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                RegistroModel registro = new RegistroModel();
                registro.setId(rs.getInt("id_registro"));
                registro.setId_caso(rs.getInt("id_caso"));
                registro.setEvolucion(rs.getString("fecha"));

                registros.add(registro);
            }
        }
    } catch (SQLException e) {
        System.err.println("Error al listar pacientes: " + e.getMessage());
    }
    return registros;
}
    
    //UPDATE
    public void UpdateRegistro(RegistroModel registro) throws SQLException{
        String sql="UPDATE registro set evolucion = ? WHERE id_registro = ?";
       
        try (Connection conn = conexion.establecerConexion(); // Obtener conexión
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, registro.getId()); // Asignar el valor del parámetro
            ps.setInt(2, registro.getId_caso());
            ps.setString(3, registro.getEvolucion());

            
            
            int filasAfectadas = ps.executeUpdate();
           
                if(filasAfectadas>0){
                    System.out.println("Registro editado correctamente");
                }else{
                    System.out.println("No se encontro ningun registro con ese codigo "+StaticVariables.Regcod);
                }
            
        } catch (SQLException e) {
            System.err.println("Error al eliminar el registro "+e.getMessage());
        }    
    }
    
    //DELETE
    public void EliminarRegistroLogica(int RegCod){
        String sql="UPDATE registro set RegActivo = 0 WHERE RegCod = ?";
        
        //Declarar conexion
        try (Connection conn = conexion.establecerConexion(); // Obtener conexión
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, RegCod); // Asignar el valor del parámetro
            int filasAfectadas = ps.executeUpdate();
           
                if(filasAfectadas>0){
                    System.out.println("Registro eliminado correctamente");
                }else{
                    System.out.println("No se encontro ningun registro con ese codigo "+RegCod);
                }
            
        } catch (SQLException e) {
            System.err.println("Error al eliminar el registro "+e.getMessage());
        }    
    }
    
    //OTHERS
    
}
