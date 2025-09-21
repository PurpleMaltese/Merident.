package CONTROLADOR;

import DAO.PacienteDAO;
import MODEL.PacienteModel;
import java.sql.SQLException;
import java.util.List;

public class PacienteControlador {
    
    private final PacienteDAO pacienteDAO = new PacienteDAO();
    
    public void registrarPaciente(PacienteModel paciente) {
        try {
            pacienteDAO.registrarPaciente(paciente);
            System.out.println("Paciente registrado con éxito.");
        } catch (SQLException e) {
            System.err.println("Error al registrar el paciente: " + e.getMessage());
        }
    }
    
}
