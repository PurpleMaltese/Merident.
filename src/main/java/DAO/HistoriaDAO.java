package DAO;

import UTIL.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HistoriaDAO {
    Conexion conexion = new Conexion();
    //CRUD
    
    //CREATE
    public void crearHistoriaClinica(int id_paciente) throws SQLException{
        String sql = "INSERT INTO historiaclinica (id_paciente,fecha) "
                + "VALUE (?,NOW())";
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn =conexion.establecerConexion();
            if(conn != null){
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id_paciente);
                stmt.executeUpdate();
                
            }
            
        
    }catch (SQLException e) {
            System.err.println("Error al registrar el paciente HC: " + e.getMessage());
        }
        
    }
    
    //OTHERS
    
}
