package CONTROLADOR;

import DAO.CasoDAO;
import MODEL.CasoModel;
import java.sql.SQLException;
import java.util.List;

public class CasoControlador {
    private final CasoDAO casoDAO = new CasoDAO();

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
