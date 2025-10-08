package CONTROLADOR;

import DAO.CasoDAO;
import IGU.CrearCasoPanel;
import MODEL.CasoModel;
import java.sql.SQLException;
import java.util.List;

public class CasoControlador {
    private final CasoDAO casoDAO;
    
    private final CrearCasoPanel crearCaso;

    public CasoControlador(CasoDAO casoDAO, CrearCasoPanel crearCaso) {
        this.casoDAO = casoDAO;
        this.crearCaso = crearCaso;
    }
    

    public void crearCaso(CasoModel caso) {
        try {
            casoDAO.crearCaso(caso);
            System.out.println("Caso creado con éxito. CONTROLADOR");
        } catch (SQLException e) {
            System.err.println("Error al crear el caso: " + e.getMessage());
        }
    }

    public List<CasoModel> listarCasos() {
        return casoDAO.listarCasos();
    }

    public List<CasoModel> listarCaso(int codigo) {
        return casoDAO.buscarCaso(codigo);
    }
}
