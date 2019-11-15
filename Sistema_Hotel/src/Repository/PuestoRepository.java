/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import sistemahotel.util.HibernateUtil;

/**
 *
 * @author randompc
 */
public class PuestoRepository {
    
        public static List obtenerTodos(String entidad, int totales)throws HibernateException{
        Session session = null;
        List resultList = null;
        List<Object[]> rows = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
                Query q = session.createQuery("from "+entidad);
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
    
}
