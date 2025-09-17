package DAO;

import MODEL.FichaPagoModel;
import UTIL.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FichaPagoDAO {
        
    Conexion conexion = new Conexion();
    
    //CRUD
    
    //CREATE
    public void crearFichaPago(FichaPagoModel ficha) throws SQLException {
        String sql = "INSERT INTO ficha_pago (id_registro, tratamiento, abono, fecha_pago) "
                   + "VALUES (?, ?, ?, ?)";
        try (Connection conn = conexion.establecerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, ficha.getId_registro());
            stmt.setString(2, ficha.getTratamiento());
            stmt.setBigDecimal(3, ficha.getAbono());
            stmt.setDate(4, new java.sql.Date(ficha.getFechaPago().getTime()));

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("✅ Ficha de pago registrada correctamente");
            } else {
                System.out.println("⚠ No se insertó ninguna ficha de pago");
            }

        } catch (SQLException e) {
            System.err.println("❌ Error DAO al registrar ficha de pago: " + e.getMessage());
            throw e;
        }
    }
    //READ
    public List<FichaPagoModel> listarFichasPago() throws SQLException {
        List<FichaPagoModel> fichas = new ArrayList<>();
        String sql = "SELECT id, id_registro, tratamiento, abono, fecha_pago FROM ficha_pago WHERE activo = 1";

        try (Connection conn = conexion.establecerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                FichaPagoModel ficha = new FichaPagoModel();
                ficha.setId(rs.getInt("id"));
                ficha.setId_registro(rs.getInt("id_registro"));
                ficha.setTratamiento(rs.getString("tratamiento"));
                ficha.setAbono(rs.getBigDecimal("abono"));
                ficha.setFechaPago(rs.getDate("fecha_pago"));

                fichas.add(ficha);
            }

        } catch (SQLException e) {
            System.err.println("❌ Error DAO al listar fichas de pago: " + e.getMessage());
            throw e;
        }

        return fichas;
    }
    
    //UPDATE
    public void actualizarFichaPago(FichaPagoModel ficha) throws SQLException {
        String sql = "UPDATE ficha_pago SET tratamiento = ?, abono = ?, fecha_pago = ? "
                   + "WHERE id = ?";
        try (Connection conn = conexion.establecerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, ficha.getTratamiento());
            stmt.setBigDecimal(2, ficha.getAbono());
            stmt.setDate(3, new java.sql.Date(ficha.getFechaPago().getTime()));
            stmt.setInt(4, ficha.getId());

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("✅ Ficha de pago actualizada correctamente");
            } else {
                System.out.println("⚠ No se actualizó ninguna ficha de pago");
            }

        } catch (SQLException e) {
            System.err.println("❌ Error DAO al actualizar ficha de pago: " + e.getMessage());
            throw e;
        }
    }
    
    //DELETE
    public void eliminarFichaPago(int id) throws SQLException {
        String sql = "UPDATE ficha_pago SET activo = 0 WHERE id = ?";
        try (Connection conn = conexion.establecerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("✅ Ficha de pago eliminada lógicamente");
            } else {
                System.out.println("⚠ No se eliminó ninguna ficha de pago");
            }

        } catch (SQLException e) {
            System.err.println("❌ Error DAO al eliminar ficha de pago: " + e.getMessage());
            throw e;
        }
    }
    
    //OTHERS
    
}
