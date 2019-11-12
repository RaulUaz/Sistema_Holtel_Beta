/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemahotel.util;

import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sistemahotel.util.HibernateUtil;

/**
 *
 * @author alopezorozco
 */
public class CRUD {
    
    /**
     * Permite guardar un objeto en la base de datos y retorna el id
     * correspondiente
     * @param object
     * @return id
     * @throws HibernateException 
     */
    public static int guardar(Object object) throws HibernateException, Exception{
        int id = 0;
        Session session = null;
        
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            
            session.beginTransaction();
            
                id = (int)session.save(object);
            
            session.getTransaction().commit();       
        }catch(RuntimeException ex){
            try{
                if (session != null){
                    session.getTransaction().rollback();
                }
            }catch(HibernateException e1){
                throw new Exception("No se pudo guardar el nuevo registro");
            }
            throw ex;
        }finally{
            session.close();
        }
        return id;
    }//fin del método guardar
    
    /**
     * Permite actualizar un objeto en la base de datos 
     * @param object
     * @return id
     * @throws HibernateException 
     */
    public static int actualizar(Object object) throws HibernateException, Exception{
        int id = 0;
        Session session = null;
        
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            
            session.beginTransaction();
            
                session.update(object);
            
            session.getTransaction().commit();  
            id = 1;
        }catch(RuntimeException ex){
            try{
                if (session != null){
                    session.getTransaction().rollback();
                }
            }catch(HibernateException e1){
                        throw new Exception("No se pudieron guardar los cambios");
            }
            throw ex;
        }finally{
            session.close();
        }
        return id;
    }//fin del método guardar
    
    /**
     * Este método permite elimiar una categoría
     */
    public static int eliminar(Object object) throws Exception{
        int result = 0;
        Session session = null;
        Transaction transaction = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.getTransaction();
            transaction.begin();
                session.delete(object);
            transaction.commit();
            result = 1;
        }catch(RuntimeException ex){
            try{
                if (session != null){
                    session.getTransaction().rollback();
                }
            }catch(HibernateException e1){
                        throw new Exception("No se pudieron guardar los cambios");
            }
            throw ex;
        }finally{
            session.close();
        }
        return result;        
    }
    
    /**
     * Permite obtener el primer registro de la tabla pasado como parámetro
     * 
     */
    public static List obtenerPrimero(String entidad) throws HibernateException{
        Session session = null;
        List resultList = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
                Query q = session.createQuery("from "+ entidad + " a Order by "+ "a.id");
                q.setMaxResults(1);
                resultList = (List)q.list();
            session.getTransaction().commit();
            
        }finally{
            if (session!=null){
                try{
                    session.close();
                }catch(HibernateException hex){
                   HibernateException ignore;
                }//fin del catch
            }//fin del if
        }//fin finally
        return resultList;
    }
    
    /**
     * Permite obtener el anterior registro del id pasado como parámetro 
     * @param entidad
     * @param id
     * @return
     * @throws HibernateException 
     */
    public static List obtenerAnterior(String entidad, int id)throws HibernateException{
        Session session = null;
        List resultList = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
                Query q = session.createQuery("from "+ entidad + " a WHERE "+ "a.id < "+id+" ORDER BY a.id DESC");
                q.setMaxResults(1);
                resultList = (List)q.list();
            session.getTransaction().commit();
            
        }finally{
            if (session!=null){
                try{
                    session.close();
                }catch(HibernateException hex){
                   HibernateException ignore;
                }//fin del catch
            }//fin del if
        }//fin finally
        return resultList;
    }
    
    /**
     * Permite obtener el siguiente registro del id pasado como parámetro 
     * @param entidad
     * @param id
     * @return
     * @throws HibernateException 
     */
    public static List obtenerSiguiente(String entidad, int id)throws HibernateException{
        Session session = null;
        List resultList = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
                Query q = session.createQuery("from "+ entidad + " a WHERE "+ "a.id > "+id+" ORDER BY a.id ASC");
                q.setMaxResults(1);
                resultList = (List)q.list();
            session.getTransaction().commit();
            
        }finally{
            if (session!=null){
                try{
                    session.close();
                }catch(HibernateException hex){
                   HibernateException ignore;
                }//fin del catch
            }//fin del if
        }//fin finally
        return resultList;
    }
    
        public static List consultarNumeric(String entidad,String attrib, int num)throws HibernateException{
        Session session = null;
        List resultList = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
                Query q = session.createQuery("SELECT p FROM "+entidad+" p WHERE p."+attrib+"="+num);
                q.setMaxResults(1);
                resultList = (List)q.list();
            session.getTransaction().commit();
            
        }finally{
            if (session!=null){
                try{
                    session.close();
                }catch(HibernateException hex){
                   HibernateException ignore;
                }//fin del catch
            }//fin del if
        }//fin finally
        return resultList;
    }
        
            public static List consultarString(String entidad,String attrib, String search)throws HibernateException{
        Session session = null;
        List resultList = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
                Query q = session.createQuery("SELECT p FROM "+entidad+" p WHERE p."+attrib+"="+search);
                q.setMaxResults(1);
                resultList = (List)q.list();
            session.getTransaction().commit();
            
        }finally{
            if (session!=null){
                try{
                    session.close();
                }catch(HibernateException hex){
                   HibernateException ignore;
                }//fin del catch
            }//fin del if
        }//fin finally
        return resultList;
    }
    
    /**
     * Permite obtener el anterior registro del id pasado como parámetro 
     * @param entidad
     * @param id
     * @return
     * @throws HibernateException 
     */
    public static List obtenerUltimo(String entidad)throws HibernateException{
        Session session = null;
        List resultList = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
                Query q = session.createQuery("from "+ entidad + " a ORDER BY "+ "a.id DESC");
                q.setMaxResults(1);
                resultList = (List)q.list();
            session.getTransaction().commit();
            
        }finally{
            if (session!=null){
                try{
                    session.close();
                }catch(HibernateException hex){
                   HibernateException ignore;
                }//fin del catch
            }//fin del if
        }//fin finally
        return resultList;
    }
    
    /**
     * 
     * @param entidad
     * @param totales
     * @return
     * @throws HibernateException 
     */
    public static List obtenerTodos(String entidad, int totales)throws HibernateException{
        Session session = null;
        List resultList = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
                Query q = session.createQuery("from "+ entidad + " c ORDER BY "+ "c.id DESC");
                if (totales!=0){
                    q.setMaxResults(totales);
                }
                resultList = (List)q.list();
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
        return resultList;
    }
}