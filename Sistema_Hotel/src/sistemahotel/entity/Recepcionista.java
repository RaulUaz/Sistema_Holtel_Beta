package sistemahotel.entity;
// Generated 8/11/2019 10:16:25 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Recepcionista generated by hbm2java
 */
public class Recepcionista  implements java.io.Serializable {


     private int id;
     private Personal personal;
     private String recepTurno;
     private String recepUname;
     private String recepPass;
     private Set reservacions = new HashSet(0);

    public Recepcionista() {
    }

	
    public Recepcionista(Personal personal, String recepTurno, String recepUname, String recepPass) {
        this.personal = personal;
        this.recepTurno = recepTurno;
        this.recepUname = recepUname;
        this.recepPass = recepPass;
    }
    public Recepcionista(Personal personal, String recepTurno, String recepUname, String recepPass, Set reservacions) {
       this.personal = personal;
       this.recepTurno = recepTurno;
       this.recepUname = recepUname;
       this.recepPass = recepPass;
       this.reservacions = reservacions;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Personal getPersonal() {
        return this.personal;
    }
    
    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
    public String getRecepTurno() {
        return this.recepTurno;
    }
    
    public void setRecepTurno(String recepTurno) {
        this.recepTurno = recepTurno;
    }
    public String getRecepUname() {
        return this.recepUname;
    }
    
    public void setRecepUname(String recepUname) {
        this.recepUname = recepUname;
    }
    public String getRecepPass() {
        return this.recepPass;
    }
    
    public void setRecepPass(String recepPass) {
        this.recepPass = recepPass;
    }
    public Set getReservacions() {
        return this.reservacions;
    }
    
    public void setReservacions(Set reservacions) {
        this.reservacions = reservacions;
    }




}

