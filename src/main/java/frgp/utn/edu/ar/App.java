package frgp.utn.edu.ar;

import org.hibernate.Session;

import frgp.utn.edu.ar.dao.ConfigHibernate;
import frgp.utn.edu.ar.entidad.Autor;
import frgp.utn.edu.ar.entidad.Biblioteca;
import frgp.utn.edu.ar.entidad.Libro;
import frgp.utn.edu.ar.entidad.Nacionalidad;
import frgp.utn.edu.ar.negocio.NegocioBiblioteca;
import frgp.utn.edu.ar.negocio.NegocioLibro;
import frgp.utn.edu.ar.negocioInterfaz.INegocioBiblioteca;
import frgp.utn.edu.ar.negocioInterfaz.INegocioLibro;

public class App 
{
    public static void main( String[] args )
    {
        /*
    	Autor autor = new Autor();
    	autor.setNombre("Pepe");
    	autor.setApellido("123");
    	autor.setEmail("sdsd");
    	autor.setNacionalidad(new Nacionalidad("Argentina"));
    	autor.setId("1");
    	
    	Libro Lib = new Libro();
    	    	
    	Biblioteca Biblio = new Biblioteca(Lib,"Prestado");
        
    	ConfigHibernate ch = new ConfigHibernate();
        Session session= ch.abrirConexion();
		
	    session.beginTransaction();
	    //session.save(Lib);
		
		Biblio.guardarEnBD(session);
		Lib = new Libro();
		Biblio = new Biblioteca(Lib,"En Biblioteca");
		Biblio.guardarEnBD(session);
		//Biblio.cargarDeBD(session, 1);
        
		session.getTransaction().commit();
		ch.cerrarSession();
		
		INegocioLibro NegLib = new NegocioLibro();
    	NegLib.cargarLista();
		*/
    	INegocioBiblioteca NegLib = new NegocioBiblioteca();
    	NegLib.cargarLista();
    	
    	System.out.println(NegLib.leerUno(1).toString());
    }
}
