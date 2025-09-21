package DAO;

import MODEL.CasoModel;
import UTIL.MySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CasoDAO {
    
    MySQL conexion = new MySQL();
    
    //CRUD
    
    //CREATE
    public void crearCaso(CasoModel caso) throws SQLException {
    String sql = "INSERT INTO caso (id_historia, diagnostico, plan_trat, exam_aux, proforma, doctor, odontograma, total_tratamiento) "
               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";


    try (Connection conn = conexion.establecerConexion();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, caso.getId_historia()); 
        stmt.setString(2, caso.getDiagnostico());
        stmt.setString(3, caso.getPlan_trat());
        stmt.setString(4, caso.getExam_aux());
        stmt.setString(5, caso.getProforma());
        stmt.setString(6, caso.getDoctor());
        stmt.setString(7, caso.getOdontograma());
        stmt.setBigDecimal(8, caso.getTotal());
        
        int filas = stmt.executeUpdate();
        if (filas > 0) {
            System.out.println("✅ Caso registrado correctamente");
        } else {
            System.out.println("⚠ No se insertó ningún caso");
        }
        
    } catch (SQLException e) {
        System.err.println("Error DAO al registrar el caso: " + e.getMessage());
        throw e; // volver a lanzar la excepción si quieres manejarla más arriba
    }
}
    //READ
    public List<CasoModel> listarCasos() {
        List<CasoModel> casos = new ArrayList<>();
        String query = "SELECT id_caso, diagnostico, plan_trat, doctor, fecha_inicio, fecha_fin FROM caso WHERE activo = 1;";

        try (Connection conn = conexion.establecerConexion();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                CasoModel caso = new CasoModel();
                caso.setId(rs.getInt("id_caso"));
                caso.setDiagnostico(rs.getString("diagnostico"));
                caso.setPlan_trat(rs.getString("plan_trat"));
                caso.setDoctor(rs.getString("doctor"));
                caso.setFecha_inicio(rs.getDate("fecha_inicio"));
                caso.setFecha_fin(rs.getDate("fecha_fin"));
                
                casos.add(caso);
            }

        } catch (SQLException e) {
            System.err.println("Error al listar casos DAO: " + e.getMessage());
        }

        return casos; // Retorna la lista de casos
    }
    

    public List<CasoModel> buscarCaso(int codigo) {
        List<CasoModel> UNcaso = new ArrayList<>();
        String query = "SELECT id_caso, diagnostico, plan_trat, doctor, fecha_inicio, fecha_fin FROM caso WHERE activo = 1;" +
               " AND id_caso = "+codigo;
        try (Connection conn = conexion.establecerConexion();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                CasoModel caso = new CasoModel();
                
                caso.setId(rs.getInt("id_caso"));
                caso.setDiagnostico(rs.getString("diagnostico"));
                caso.setPlan_trat(rs.getString("plan_trat"));
                caso.setDoctor(rs.getString("doctor"));
                caso.setFecha_inicio(rs.getDate("fecha_inicio"));
                caso.setFecha_fin(rs.getDate("fecha_fin"));
                
                UNcaso.add(caso); 
            }

        } catch (SQLException e) {
            System.err.println("Error al listar casos DAO: " + e.getMessage());
        }

        return UNcaso; 
    }
    
    
    //UPDATE
    public boolean actualizarCaso(CasoModel caso) {
    String query = "UPDATE caso SET diagnostico = ?, plan_trat = ?, exam_aux = ?, profroma = ?"
            + " doctor = ?, odontograma = ?, fecha_inicio = ?, total_tratamiento = ?, fecha_fin = ? WHERE id_caso = ?";

    try (Connection conn = conexion.establecerConexion();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setString(1, caso.getDiagnostico());
        stmt.setString(2, caso.getPlan_trat());
        stmt.setString(3, caso.getExam_aux());
        stmt.setString(4, caso.getProforma());
        stmt.setString(5, caso.getDoctor());
        stmt.setString(6, caso.getOdontograma());
        stmt.setDate(7, new java.sql.Date(caso.getFecha_inicio().getTime()));
        stmt.setBigDecimal(8, caso.getTotal());
        stmt.setDate(9, new java.sql.Date(caso.getFecha_fin().getTime()));
        stmt.setInt(10, caso.getId());

        int filas = stmt.executeUpdate();
        return filas > 0; // true si se actualizó al menos un registro

    } catch (SQLException e) {
        System.err.println("Error al actualizar caso DAO: " + e.getMessage());
        return false;
    }
}

    //DELETE
    public boolean eliminarCasoLogico(int idCaso) {
    String query = "UPDATE caso SET activo = 0 WHERE id_caso = ?";

    try (Connection conn = conexion.establecerConexion();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setInt(1, idCaso);

        int filas = stmt.executeUpdate();
        return filas > 0; // true si se actualizó al menos un registro

    } catch (SQLException e) {
        System.err.println("Error al eliminar caso lógicamente DAO: " + e.getMessage());
        return false;
    }
}

    //OTHERS
    
}
