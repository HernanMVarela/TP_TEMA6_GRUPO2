package frgp.utn.edu.ar;

import java.sql.Date;

import org.hibernate.Session;

import frgp.utn.edu.ar.dao.ConfigHibernate;
import frgp.utn.edu.ar.entidad.Autor;
import frgp.utn.edu.ar.entidad.Biblioteca;
import frgp.utn.edu.ar.entidad.Libro;
import frgp.utn.edu.ar.entidad.Nacionalidad;
import frgp.utn.edu.ar.negocio.NegocioBiblioteca;
import frgp.utn.edu.ar.negocio.NegocioGenero;
import frgp.utn.edu.ar.negocio.NegocioLibro;
import frgp.utn.edu.ar.negocio.NegocioNacionalidad;
import frgp.utn.edu.ar.negocioInterfaz.INegocioBiblioteca;
import frgp.utn.edu.ar.negocioInterfaz.INegocioGenero;
import frgp.utn.edu.ar.negocioInterfaz.INegocioLibro;
import frgp.utn.edu.ar.negocioInterfaz.INegocioNacionalidad;

public class App 
{
    public static void main( String[] args )
    {
    	INegocioGenero NegGen = new NegocioGenero();
    	INegocioNacionalidad NegNac = new NegocioNacionalidad();
    	
    	NegGen.cargarLista(); /// Carga lista de generos con valores definidos
    	NegNac.cargarLista(); /// Carga lista de nacionalidad con valores definidos
    	
		/// CONTINUAR CREACION DE LIBROS
    	Libro libro1 = new Libro(
    			"9780132350884",
    			"Clean Code Test Update", Date.valueOf("2008-01-01"), "Ingles", 464,
    			"Un libro sobre programacion", 
    			new Autor(
    					"Robert C.",
    					"Martin",
    					NegNac.obtenerLista().get(0),
    					"robert.martin@mail.com"
    					)
    			);
    	
    	libro1.getGeneros().add(NegGen.obtenerLista().get(0));
    	libro1.getGeneros().add(NegGen.obtenerLista().get(1));
    	
        /*
		INegocioLibro NegLib = new NegocioLibro();
    	NegLib.cargarLista();y
		*/
    	
    	INegocioBiblioteca NegLib = new NegocioBiblioteca();
    	NegLib.cargarLista();
    	
    	System.out.println(NegLib.leerTodo().toString());
    	
    	
    	Biblioteca biblio2 = new Biblioteca(libro1,"En biblioteca");
    	biblio2.setIdBiblioteca(15);
    	
    	NegLib.modificarBiblioteca(biblio2);
    	
    	System.out.println(NegLib.leerTodo().toString());
    }
}
