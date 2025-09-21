package DAO;

import MODEL.PacienteModel;
import UTIL.MySQL;
import UTIL.StaticVariables;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {
    MySQL conexion = new MySQL();    
    //CRUD
    
    //CREATE
    public void registrarPaciente(PacienteModel paciente) throws SQLException {
    String sql = "INSERT INTO paciente (DNI, nombre, apellido, edad, apoderado, celular, direccion, menor_edad, ante_medi, ante_odo, activo) "
               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    int idGenerado = -1;

    try (Connection conn = conexion.establecerConexion();
         PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

        
        stmt.setInt(1, paciente.getDni()); // si es VARCHAR
        stmt.setString(2, paciente.getNombre());
        stmt.setString(3, paciente.getApellido());
        stmt.setInt(4, paciente.getEdad());
        stmt.setString(5, paciente.getApoderado());
        stmt.setInt(6, paciente.getCelular()); // si es VARCHAR, no setInt
        stmt.setString(7, paciente.getDireccion());
        stmt.setString(8, paciente.getMenorEdad());
        stmt.setString(9, paciente.getAntMed());
        stmt.setString(10, paciente.getAntOdo());
        stmt.setInt(11, 1); // activo = 1

        int filas = stmt.executeUpdate();

        if (filas > 0) {
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    idGenerado = rs.getInt(1);
                }
            }
        }

        // Si obtuvimos el ID, crear historia clínica
        if (idGenerado != -1) {
            HistoriaDAO hDAO = new HistoriaDAO();
            hDAO.crearHistoriaClinica(idGenerado);
        }

    } catch (SQLException e) {
        System.err.println("Error DAO al registrar el paciente: " + e.getMessage());
        throw e; // volver a lanzar la excepción si quieres manejarla más arriba
    }
}
    //READ
     public List<PacienteModel> listarPacientes() {
        List<PacienteModel> pacientes = new ArrayList<>();
        String query = "SELECT id_paciente, DNI, nombre, apellido, edad FROM paciente WHERE activo = 1;";

        //luego poner un WHERE activo=Si
        try (Connection conn = conexion.establecerConexion();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                PacienteModel paciente = new PacienteModel();
                paciente.setId(rs.getInt("id_paciente"));
                paciente.setDni(rs.getInt("DNI"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setApellido(rs.getString("apellido"));
                paciente.setEdad(rs.getInt("edad"));
                
                pacientes.add(paciente); // Añadir el paciente a la lista
            }

        } catch (SQLException e) {
            System.err.println("Error al listar pacientes: " + e.getMessage());
        }

        return pacientes; // Retorna la lista de pacientes
    }
     
     
     //BUSCAR UN PACIENTE POR SU DNI O CODIGO DE HISTORIA CLINICA
    public List<PacienteModel> buscarPaciente(String sent, int codigo) {
        List<PacienteModel> UNpaciente = new ArrayList<>();
        String query = "SELECT DNI, nombre, apellido, edad FROM paciente " +
               "WHERE paciente.activo = 1 AND "+sent+codigo;
        try (Connection conn = conexion.establecerConexion();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                PacienteModel paciente = new PacienteModel();
                //Object extra;
                paciente.setDni(rs.getInt("DNI"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setApellido(rs.getString("apellido"));
                paciente.setEdad(rs.getInt("edad"));
                //extra=(rs.getInt("HisCod"));
                
                UNpaciente.add(paciente); // Añadir el paciente a la lista
            }

        } catch (SQLException e) {
            System.err.println("Error al listar pacientes: " + e.getMessage());
        }

        return UNpaciente; // Retorna la lista de pacientes
    }
    
    //UPDATE
    public void UpdatePaciente(PacienteModel paciente) throws SQLException{
        String sql="UPDATE paciente set DNI = ?, nombre = ?, apellido = ?, edad = ?, apoderado = ?, celular = ?, direccion = ?, menor_edad = ? WHERE DNI = ?";
       
        try (Connection conn = conexion.establecerConexion(); // Obtener conexión
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, paciente.getDni());
            ps.setString(2, paciente.getNombre());
            ps.setString(3, paciente.getApellido());
            ps.setInt(4, paciente.getEdad());
            ps.setString(5, paciente.getApoderado());
            ps.setInt(6, paciente.getCelular());
            ps.setString(7, paciente.getDireccion());
            ps.setString(8, paciente.getMenorEdad());
            ps.setInt(9, StaticVariables.DNI);
            

            
            
            int filasAfectadas = ps.executeUpdate();
           
                if(filasAfectadas>0){
                    System.out.println("Paciente editado correctamente");
                }else{
                    System.out.println("No se encontro ningun paciente con ese DNI "+StaticVariables.Regcod);
                }
            
        } catch (SQLException e) {
            System.err.println("Error al eliminar el registro "+e.getMessage());
        }    
    }
    
    //DELETE
    public void EliminarPacienteLogica(int DNI){
        String sql="UPDATE paciente set activo = 0 WHERE DNI = ?";
        
        //Declarar conexion
        try (Connection conn = conexion.establecerConexion(); // Obtener conexión
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, DNI); // Asignar el valor del parámetro
            int filasAfectadas = ps.executeUpdate();
           
                if(filasAfectadas>0){
                    System.out.println("Paciente eliminado correctamente");
                }else{
                    System.out.println("No se encontro ningun paceinte con DNI "+DNI);
                }
            
        } catch (SQLException e) {
            System.err.println("Error al eliminar el paciente "+e.getMessage());
        }
        
    }
    
    //OTHERS
    
}
