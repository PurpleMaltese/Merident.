package MODEL;

public class RegistroModel {
    
    private int id;
    private int id_caso;
    private String evolucion;

    public RegistroModel() {
    }

    public RegistroModel(int id_caso, String evolucion) {
        this.id_caso = id_caso;
        this.evolucion = evolucion;
    }

    public RegistroModel(int id, int id_caso, String evolucion) {
        this.id = id;
        this.id_caso = id_caso;
        this.evolucion = evolucion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_caso() {
        return id_caso;
    }

    public void setId_caso(int id_caso) {
        this.id_caso = id_caso;
    }

    public String getEvolucion() {
        return evolucion;
    }

    public void setEvolucion(String evolucion) {
        this.evolucion = evolucion;
    }
}
