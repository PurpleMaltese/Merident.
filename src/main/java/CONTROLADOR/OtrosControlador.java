package CONTROLADOR;

import DAO.OtrosDAO;
import IGU.BuscarPacientePanel;
import UTIL.StaticVariables;


public class OtrosControlador {
    
    private final OtrosDAO otrosDAO;
    
    private final BuscarPacientePanel buscarPaciente;

    
    public OtrosControlador(OtrosDAO otrosDAO, BuscarPacientePanel buscarPaciente) {
        this.otrosDAO = otrosDAO;
        this.buscarPaciente = buscarPaciente;
    }
    
    public void obtenerCodHis(String idPac) {
        StaticVariables.Hiscod = otrosDAO.obtenerHisCodPorDNIPac(idPac); //me comunico con el DAO para obtener el valor
        if (StaticVariables.Hiscod == -1) {
        System.err.println("ERROR en OtrosControlador: No se encontró la historia clínica del paciente con ID: " + idPac);
        } else{
            System.out.println("Hiscod obtenido");
        }
        
    }
    
    public void obtenerNombreCompleto(String DNI) {
        StaticVariables.Paciente = otrosDAO.obtenerNombrePorDNI(DNI);
    }
    
}
