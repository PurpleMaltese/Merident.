package CONTROLADOR;

import DAO.PacienteDAO;
import IGU.BuscarPacientePanel;
import IGU.RegistrarPacientePanel;
import MODEL.PacienteModel;
import java.sql.SQLException;
import java.util.List;

public class PacienteControlador {
    
    private final PacienteDAO pacienteDAO;
    
    private final RegistrarPacientePanel registrarPaciente;
    private final BuscarPacientePanel buscarPaciente;
    
    //CONSTRUCTORES

    public PacienteControlador(PacienteDAO pacienteDAO, RegistrarPacientePanel registrarPaciente) {
        this.pacienteDAO = pacienteDAO;
        this.registrarPaciente = registrarPaciente;
        this.buscarPaciente = null;
    }
    
    public PacienteControlador(PacienteDAO pacienteDAO, BuscarPacientePanel buscarPaciente) {
        this.pacienteDAO = pacienteDAO;
        this.buscarPaciente = buscarPaciente;
        this.registrarPaciente = null;
    }
    
    
    
    public void registrarPaciente(PacienteModel paciente) {
        try {
            pacienteDAO.registrarPaciente(paciente);
            System.out.println("Paciente registrado con éxito.");
        } catch (SQLException e) {
            System.err.println("Error al registrar el paciente: " + e.getMessage());
        }
    }
    
    //listar todos los pacientes
    public void listarPacientes() {
        List<PacienteModel> pacientes = pacienteDAO.listarPacientes();
        if (!pacientes.isEmpty()) {
            buscarPaciente.actualizarTablaPacientes(pacientes);
        } else {
            System.out.println("No hay pacientes registrados.");
        }
    }
    
    //buscar en especifico
    public void buscarPaciente(int codigo) {
        String campo = (String.valueOf(codigo).length() == 8) ? "paciente.DNI =" : "historiaclinica.id_historia =";
        List<PacienteModel> pacientes = pacienteDAO.buscarPaciente(campo, codigo);
        if (!pacientes.isEmpty()) {
            buscarPaciente.actualizarTablaPacientes(pacientes);
        } else {
            System.out.println("No se encontró paciente.");
        }
    }
    
}
