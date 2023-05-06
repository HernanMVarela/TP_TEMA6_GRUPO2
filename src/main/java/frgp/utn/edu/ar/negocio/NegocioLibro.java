package frgp.utn.edu.ar.negocio;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import frgp.utn.edu.ar.dao.DaoHibernateBiblioteca;
import frgp.utn.edu.ar.dao.DaoHibernateLibro;
import frgp.utn.edu.ar.entidad.Autor;
import frgp.utn.edu.ar.entidad.Biblioteca;
import frgp.utn.edu.ar.entidad.Libro;
import frgp.utn.edu.ar.negocioInterfaz.INegocioBiblioteca;
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
    	libro1.getGeneros().add(NegGen.obtenerLista().get(0));
    	libro1.getGeneros().add(NegGen.obtenerLista().get(1));
    	agregarLibro(libro1);
	}

	@Override
	public void agregarLibro(Libro lib) {
		DaoHibernateLibro.AddLibro(lib); /// Lo guarda en la DB
	}

	@Override
	public void guardarLista(List<Libro> lista) {
		Iterator<Libro> ite = lista.iterator();
		
		/// Guarda cada libro de la lista en la base de datos
		while(ite.hasNext()) {
			DaoHibernateLibro.AddLibro(ite.next());
		}		
	}

	@Override
	public void modificarLibro(Libro lib) {
		DaoHibernateLibro.UpdateLibro(lib); /// Modifica un libro en la base de datos
		
	}

	@Override
	public void borrarLibro(Libro lib) {
		List<Biblioteca> listaBiblioteca = DaoHibernateBiblioteca.ReadAll();
		Iterator<Biblioteca> ite = listaBiblioteca.iterator();
		while(ite.hasNext()) {
			Biblioteca bib = ite.next();
			if(bib.getLibro().getISBN().equals(lib.getISBN())) {
				INegocioBiblioteca NegBib = new NegocioBiblioteca();
				NegBib.deleteBiblioteca(bib);
			}
		}
		DaoHibernateLibro.DeleteLibro(lib);; /// Remueve de la base de datos el libro indicado		
	}

	public Libro leerUno(String ISBN) {
		return DaoHibernateLibro.ReadOne(ISBN); /// Lee un registro de la tabla libros
	}
	
	public List<Libro> leerTodo(){		
		return DaoHibernateLibro.ReadAll(); /// Lee todos los registros de la tabla libros
	}

}
