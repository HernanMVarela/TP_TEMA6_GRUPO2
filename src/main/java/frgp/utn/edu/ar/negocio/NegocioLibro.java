package frgp.utn.edu.ar.negocio;

import java.sql.Date;
import java.util.List;

import frgp.utn.edu.ar.dao.DaoHibernateLibro;
import frgp.utn.edu.ar.entidad.Autor;
import frgp.utn.edu.ar.entidad.Libro;
import frgp.utn.edu.ar.negocioInterfaz.INegocioGenero;
import frgp.utn.edu.ar.negocioInterfaz.INegocioLibro;
import frgp.utn.edu.ar.negocioInterfaz.INegocioNacionalidad;

public class NegocioLibro implements INegocioLibro {

	@Override
	public void cargarLista() {
		INegocioGenero NegGen = new NegocioGenero();
    	INegocioNacionalidad NegNac = new NegocioNacionalidad();
    	
    	NegGen.cargarLista(); /// Carga lista de generos con valores definidos
    	NegNac.cargarLista(); /// Carga lista de nacionalidad con valores definidos
    	
		/// CONTINUAR CREACION DE LIBROS
    	Libro libro1 = new Libro(
    			"9780132350884",
    			"Clean Code", Date.valueOf("2008-01-01"), "Ingles", 464,
    			"Un libro sobre programacion", 
    			new Autor(
    					"Robert C.",
    					"Martin",
    					NegNac.obtenerLista().get(0),
    					"robert.martin@mail.com"
    					)
    			);
    	
    	agregarLibro(libro1);
	}

	@Override
	public void agregarLibro(Libro lib) {
		DaoHibernateLibro.AddLibro(lib); /// Lo guarda en la DB
	}

	@Override
	public void guardarLista(List<Libro> lista) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarLibro(Libro lib) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrarLibro(Libro lib) {
		// TODO Auto-generated method stub
		
	}

	public Libro leerUno(String ISBN) {
		return DaoHibernateLibro.ReadOne(ISBN); /// Lee un registro de la tabla libros
	}
	
	public List<Libro> leerTodo(){		
		return DaoHibernateLibro.ReadAll(); /// Lee todos los registros de la tabla libros
	}

}
