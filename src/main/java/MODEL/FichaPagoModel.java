package MODEL;

import java.math.BigDecimal;
import java.sql.Date;


public class FichaPagoModel {
    
    private int id;
    private int id_registro;
    private String tratamiento;
    private BigDecimal abono;
    private Date fechaPago;

    public FichaPagoModel() {
    }
    
    public FichaPagoModel(int id_registro, String tratamiento, BigDecimal abono, Date fechaPago) {
        this.id_registro = id_registro;
        this.tratamiento = tratamiento;
        this.abono = abono;
        this.fechaPago = fechaPago;
    }

    public FichaPagoModel(int id, int id_registro, String tratamiento, BigDecimal abono, Date fechaPago) {
        this.id = id;
        this.id_registro = id_registro;
        this.tratamiento = tratamiento;
        this.abono = abono;
        this.fechaPago = fechaPago;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_registro() {
        return id_registro;
    }

    public void setId_registro(int id_registro) {
        this.id_registro = id_registro;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public BigDecimal getAbono() {
        return abono;
    }

    public void setAbono(BigDecimal abono) {
        this.abono = abono;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }
    
    
}
