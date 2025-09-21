package DAO;

import MODEL.UsuarioModel;
import UTIL.MySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    MySQL conexion = new MySQL();
    
    public UsuarioModel validarUsuario(UsuarioModel usuario){
        String query ="SELECT * FROM usuarios WHERE username = ? AND password = ?";
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = conexion.establecerConexion();
            stmt = conn.prepareStatement(query);
            stmt.setString(1, usuario.getUsername());
            stmt.setString(2, usuario.getPassword());
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                String rol = rs.getString("rol");
                return new UsuarioModel(usuario.getUsername(), usuario.getPassword(), rol);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al obtener usuario "+e);
        }
        return null;
    }
    
}
