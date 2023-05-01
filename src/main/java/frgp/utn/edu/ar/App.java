package frgp.utn.edu.ar;

import org.hibernate.Session;

import frgp.utn.edu.ar.dao.ConfigHibernate;
import frgp.utn.edu.ar.entidad.Autor;
import frgp.utn.edu.ar.entidad.Biblioteca;

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
	    
	    Biblioteca libroFisico = new Biblioteca(7,"Malo");
	    session.save(libroFisico);
	    System.out.println(libroFisico.toString());
	    libroFisico= new Biblioteca(3,"De 10");
	    session.save(libroFisico);
	    System.out.println(libroFisico.toString());
	    
	    session.getTransaction().commit();    
		ch.cerrarSession();
        
    }
}
