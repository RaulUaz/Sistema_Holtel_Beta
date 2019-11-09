package sistemahotel.entity;
// Generated 8/11/2019 10:16:25 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Personal generated by hbm2java
 */
public class Personal  implements java.io.Serializable {


     private Integer id;
     private Puesto puesto;
     private String perNombre;
     private String perApellido;
     private String perDireccion;
     private String perCalle;
     private String perColonia;
     private String perTelefono;
     private Date perFechaNac;
     private String perCuidad;
     private Recepcionista recepcionista;

    public Personal() {
    }

	
    public Personal(Puesto puesto, String perNombre, String perApellido, String perDireccion, String perCalle, String perColonia, String perTelefono, Date perFechaNac, String perCuidad) {
        this.puesto = puesto;
        this.perNombre = perNombre;
        this.perApellido = perApellido;
        this.perDireccion = perDireccion;
        this.perCalle = perCalle;
        this.perColonia = perColonia;
        this.perTelefono = perTelefono;
        this.perFechaNac = perFechaNac;
        this.perCuidad = perCuidad;
    }
    public Personal(Puesto puesto, String perNombre, String perApellido, String perDireccion, String perCalle, String perColonia, String perTelefono, Date perFechaNac, String perCuidad, Recepcionista recepcionista) {
       this.puesto = puesto;
       this.perNombre = perNombre;
       this.perApellido = perApellido;
       this.perDireccion = perDireccion;
       this.perCalle = perCalle;
       this.perColonia = perColonia;
       this.perTelefono = perTelefono;
       this.perFechaNac = perFechaNac;
       this.perCuidad = perCuidad;
       this.recepcionista = recepcionista;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Puesto getPuesto() {
        return this.puesto;
    }
    
    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }
    public String getPerNombre() {
        return this.perNombre;
    }
    
    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }
    public String getPerApellido() {
        return this.perApellido;
    }
    
    public void setPerApellido(String perApellido) {
        this.perApellido = perApellido;
    }
    public String getPerDireccion() {
        return this.perDireccion;
    }
    
    public void setPerDireccion(String perDireccion) {
        this.perDireccion = perDireccion;
    }
    public String getPerCalle() {
        return this.perCalle;
    }
    
    public void setPerCalle(String perCalle) {
        this.perCalle = perCalle;
    }
    public String getPerColonia() {
        return this.perColonia;
    }
    
    public void setPerColonia(String perColonia) {
        this.perColonia = perColonia;
    }
    public String getPerTelefono() {
        return this.perTelefono;
    }
    
    public void setPerTelefono(String perTelefono) {
        this.perTelefono = perTelefono;
    }
    public Date getPerFechaNac() {
        return this.perFechaNac;
    }
    
    public void setPerFechaNac(Date perFechaNac) {
        this.perFechaNac = perFechaNac;
    }
    public String getPerCuidad() {
        return this.perCuidad;
    }
    
    public void setPerCuidad(String perCuidad) {
        this.perCuidad = perCuidad;
    }
    public Recepcionista getRecepcionista() {
        return this.recepcionista;
    }
    
    public void setRecepcionista(Recepcionista recepcionista) {
        this.recepcionista = recepcionista;
    }




}


