package MODEL;

import java.math.BigDecimal;
import java.sql.Date;


public class CasoModel {

 private int id;
    private int id_historia;
    private String diagnostico;
    private String plan_trat;
    private String exam_aux;
    private String proforma;
    private String doctor;
    private String odontograma;
    private BigDecimal total;
    private Date fecha_inicio;
    private Date fecha_fin;    

    public CasoModel() {
    }
    
    //CONS DE INICIO
    public CasoModel(int id_historia, String diagnostico, String plan_trat, String exam_aux, String proforma, String doctor, String odontograma, BigDecimal total) {
        this.id_historia = id_historia;
        this.diagnostico = diagnostico;
        this.plan_trat = plan_trat;
        this.exam_aux = exam_aux;
        this.proforma = proforma;
        this.doctor = doctor;
        this.odontograma = odontograma;
        this.total = total;
    }

    public CasoModel(int id, int id_historia, String diagnostico, String plan_trat, String exam_aux, String proforma, String doctor, String odontograma, BigDecimal total, Date fecha_inicio, Date fecha_fin) {
        this.id = id;
        this.id_historia = id_historia;
        this.diagnostico = diagnostico;
        this.plan_trat = plan_trat;
        this.exam_aux = exam_aux;
        this.proforma = proforma;
        this.doctor = doctor;
        this.odontograma = odontograma;
        this.total = total;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_historia() {
        return id_historia;
    }

    public void setId_historia(int id_historia) {
        this.id_historia = id_historia;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getPlan_trat() {
        return plan_trat;
    }

    public void setPlan_trat(String plan_trat) {
        this.plan_trat = plan_trat;
    }

    public String getExam_aux() {
        return exam_aux;
    }

    public void setExam_aux(String exam_aux) {
        this.exam_aux = exam_aux;
    }

    public String getProforma() {
        return proforma;
    }

    public void setProforma(String proforma) {
        this.proforma = proforma;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getOdontograma() {
        return odontograma;
    }

    public void setOdontograma(String odontograma) {
        this.odontograma = odontograma;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
}
