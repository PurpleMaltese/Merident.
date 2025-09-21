package MODEL;


public class PacienteModel {
    
    private int id;
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String menorEdad;
    private String apoderado;
    private int celular;
    private String direccion;
    private String AntMed;
    private String AntOdo;
    private int activo;

    public PacienteModel() {
    } 
   
    //sin ID
    public PacienteModel(int dni, String nombre, String apellido, int edad, String menorEdad, String apoderado, int celular, String direccion, String AntMed, String AntOdo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.menorEdad = menorEdad;
        this.apoderado = apoderado;
        this.celular = celular;
        this.direccion = direccion;
        this.AntMed = AntMed;
        this.AntOdo = AntOdo;
    }
    
    //con ID
    public PacienteModel(int id, int dni, String nombre, String apellido, int edad, String menorEdad, String apoderado, int celular, String direccion, String AntMed, String AntOdo, int activo) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.menorEdad = menorEdad;
        this.apoderado = apoderado;
        this.celular = celular;
        this.direccion = direccion;
        this.AntMed = AntMed;
        this.AntOdo = AntOdo;
        this.activo = activo;
    }
    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getMenorEdad() {
        return menorEdad;
    }

    public void setMenorEdad(String menorEdad) {
        this.menorEdad = menorEdad;
    }

    public String getApoderado() {
        return apoderado;
    }

    public void setApoderado(String apoderado) {
        this.apoderado = apoderado;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getAntMed() {
        return AntMed;
    }

    public void setAntMed(String AntMed) {
        this.AntMed = AntMed;
    }

    public String getAntOdo() {
        return AntOdo;
    }

    public void setAntOdo(String AntOdo) {
        this.AntOdo = AntOdo;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
    
}
