package MODEL;

import java.sql.Date;

public class HistoriaModel {
    
    private int id;
    private int id_paciente;
    private Date fecha;

    public HistoriaModel() {
    }
    
    public HistoriaModel(int id_paciente, Date fecha) {
        this.id_paciente = id_paciente;
        this.fecha = fecha;
    }

    public HistoriaModel(int id, int id_paciente, Date fecha) {
        this.id = id;
        this.id_paciente = id_paciente;
        this.fecha = fecha;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
