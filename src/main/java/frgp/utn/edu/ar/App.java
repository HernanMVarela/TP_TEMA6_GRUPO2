package frgp.utn.edu.ar;

import org.hibernate.Session;

import frgp.utn.edu.ar.dao.ConfigHibernate;
import frgp.utn.edu.ar.entidad.Autor;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
        Autor autor = new Autor();
    	autor.setNombre("Pepe");
    	autor.setApellido("123");
    	autor.setEmail("sdsd");
    	autor.setNacionalidad("Argentino");
    	autor.setId("1");
        
        ConfigHibernate ch = new ConfigHibernate();
		Session session= ch.abrirConexion();
		
	        
	    session.beginTransaction();
	    session.save(autor);
	    
	    session.getTransaction().commit();    
		ch.cerrarSession();
        
    }
}
