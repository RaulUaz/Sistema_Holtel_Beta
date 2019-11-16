/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import datechooser.beans.DateChooserCombo;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import sistemahotel.entity.Personal;
import sistemahotel.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author randompc
 */
public class PersonalRepository extends Personal {
    public static List obtenerPersonalPorId(int id,int totales) throws HibernateException{
        Session session = null;
        List resultList = null;
        List<Object[]> rows = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
                Query q = session.createQuery("select e, a from Personal e "
                        + " INNER JOIN e.puesto a where e.id="+id);
                if (totales!=0){
                    q.setMaxResults(totales);
                }
                //resultList = (List)q.list();
                rows = q.list();
                
                
            session.getTransaction().commit();
            
        }finally{
            if (session!=null){
                try{
                    session.close();
                }catch(HibernateException hex){
                   HibernateException ignore;
                   JOptionPane.showMessageDialog(null, 
                           "Error: "+hex.getMessage()+"\n"+
                                   " Archivo: CRUD.java\n"+
                                   "Lineas: 242-253.", 
                           "Error", JOptionPane.ERROR_MESSAGE);
                }//fin del catch
            }//fin del if
        }//fin finally
        return rows;
    }
    
    public static List obtenerTodos(String entidad, int totales)throws HibernateException{
        Session session = null;
        List resultList = null;
        List<Object[]> rows = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
                Query q = session.createQuery("select e, a from Personal e "
                        + " INNER JOIN e.puesto a");
                if (totales!=0){
                    q.setMaxResults(totales);
                }
                //resultList = (List)q.list();
                rows = q.list();
                
                
            session.getTransaction().commit();
            
        }finally{
            if (session!=null){
                try{
                    session.close();
                }catch(HibernateException hex){
                   HibernateException ignore;
                   JOptionPane.showMessageDialog(null, 
                           "Error: "+hex.getMessage()+"\n"+
                                   " Archivo: CRUD.java\n"+
                                   "Lineas: 242-253.", 
                           "Error", JOptionPane.ERROR_MESSAGE);
                }//fin del catch
            }//fin del if
        }//fin finally
        return rows;
    }
    

    public static List obtenerPersonalPorString(String attrib,String charBusqueda,int totales) throws HibernateException{
         Session session = null;
        List resultList = null;
        List<Object[]> rows = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
                Query q = session.createQuery("select e,a from Personal e "
                        + " INNER JOIN e.puesto a  where e."+attrib+"="+charBusqueda);
                if (totales!=0){
                    q.setMaxResults(totales);
                }
                //resultList = (List)q.list();
                rows = q.list();
                
                
            session.getTransaction().commit();
            
        }finally{
            if (session!=null){
                try{
                    session.close();
                }catch(HibernateException hex){
                   HibernateException ignore;
                   JOptionPane.showMessageDialog(null, 
                           "Error: "+hex.getMessage()+"\n"+
                                   " Archivo: CRUD.java\n"+
                                   "Lineas: 242-253.", 
                           "Error", JOptionPane.ERROR_MESSAGE);
                }//fin del catch
            }//fin del if
        }//fin finally
        return rows;
    } 
    
        public static Date fecha(DateChooserCombo dateChooserCombo)//recibe el jdatechooser
    {
        Date date = dateChooserCombo.getCurrent().getTime();//obtiene la fecha larga
        long d = date.getTime();//conversion long
        java.sql.Date fecha= new java.sql.Date(d);//conversion a sql
        return fecha;//regresa date
    }
    
    
}