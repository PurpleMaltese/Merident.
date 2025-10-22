package CONTROLADOR;

import DAO.CasoDAO;
import IGU.CrearCasoPanel;
import IGU.HistoriaClinicaPanel;
import MODEL.CasoModel;
import java.sql.SQLException;
import java.util.List;

public class CasoControlador {
    private final CasoDAO casoDAO;
    
    private final CrearCasoPanel crearCaso;
    private final HistoriaClinicaPanel historiaClinicaPanel;

    public CasoControlador(CasoDAO casoDAO, CrearCasoPanel crearCaso) {
        this.casoDAO = casoDAO;
        this.crearCaso = crearCaso;
        this.historiaClinicaPanel = null;
    }
    
    public CasoControlador(CasoDAO casoDAO, HistoriaClinicaPanel historiaClinicaPanel) {
        this.casoDAO = casoDAO;
        this.crearCaso = null;
        this.historiaClinicaPanel = historiaClinicaPanel;
    }

    public void crearCaso(CasoModel caso) {
        try {
            casoDAO.crearCaso(caso);
            System.out.println("Caso creado con éxito. CONTROLADOR");
        } catch (SQLException e) {
            System.err.println("Error al crear el caso: " + e.getMessage());
        }
    }

    public void ListarCasos(){
        List<CasoModel> casos = casoDAO.listarCasos();
        if (!casos.isEmpty()) {
            historiaClinicaPanel.actualizarTablaCasos(casos);
        } else {
            System.out.println("No hay casos registrados.");
        }
    }
    
    

    public List<CasoModel> listarCaso(int codigo) {
        return casoDAO.buscarCaso(codigo);
    }
}
