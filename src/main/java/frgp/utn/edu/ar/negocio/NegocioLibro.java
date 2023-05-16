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
    			"9786075387611",
    			"Aprende A Programar En Java", Date.valueOf("2022-01-01"), "Español", 600,
    			"Dirigida a todos aquellos que quieren comenzar a programar", 
    			new Autor(
    					"Osvaldo Cairo ",
    					"Battistutti",
    					NegNac.getNacionalidad("Uruguay"),
    					"robert.martin@mail.com"
    					)
    			);
    	libro1.getGeneros().add(NegGen.getGenero("Computacion"));
    	libro1.getGeneros().add(NegGen.getGenero("Programacion"));
    	
		Libro libro2 = new Libro(
    			"9789504981015",
    			"El Nudo", Date.valueOf("2015-01-01"), "Español", 400,
    			"Un libro sobre Historia", 
    			new Autor(
    					"Carlos",
    					"Pagni",
    					NegNac.getNacionalidad("Uruguay"),
    					"carlos.pagni@mail.com"
    					)
    			);
		libro2.getGeneros().add(NegGen.getGenero("Historia"));
    	libro2.getGeneros().add(NegGen.getGenero("Humanidad"));
		
		Libro libro3 = new Libro(
    			"12345",
    			"Fundamentos de Enfermería", Date.valueOf("2019-01-01"), "Español", 1384,
    			"Un libro sobre medicina", 
    			new Autor(
    					"P.A.",
    					"Potter",
    					NegNac.getNacionalidad("Argentina"),
    					"pa.potter@mail.com"
    					)
    			);
		libro3.getGeneros().add(NegGen.getGenero("Medicina"));
		
		Libro libro4 = new Libro(
    			"9788417347741",
    			"Estelar", Date.valueOf("2020-01-01"), "Español", 464,
    			"Un libro sobre ciencia ficción", 
    			new Autor(
    					"Brandon",
    					"Sanderson",
    					NegNac.getNacionalidad("Estados Unidos"),
    					"brandon.sanderson@mail.com"
    					)
    			);
		libro4.getGeneros().add(NegGen.getGenero("Ficción"));
		
		Libro libro5 = new Libro(
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
    	libro5.getGeneros().add(NegGen.getGenero("Computacion"));
    	libro5.getGeneros().add(NegGen.getGenero("Programacion"));
    	
		Libro libro6 = new Libro(
    			"9781492056355",
    			"Fluent Python", Date.valueOf("2022-01-01"), "Ingles", 900,
    			"Un libro sobre Python", 
    			new Autor(
    					"Luciano",
    					"Ramalho",
    					NegNac.obtenerLista().get(2),
    					"luciano.ramalho@mail.com"
    					)
    			);
		libro6.getGeneros().add(NegGen.obtenerLista().get(0));
		libro6.getGeneros().add(NegGen.obtenerLista().get(1));
    	
    	agregarLibro(libro1);
    	agregarLibro(libro2);
    	agregarLibro(libro3);
    	agregarLibro(libro4);
    	agregarLibro(libro5);
    	agregarLibro(libro6);
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
	public void borrarLibro(Libro lib) {  /// Borra el libro y los registros de biblioteca asociados
		List<Biblioteca> listaBiblioteca = DaoHibernateBiblioteca.ReadAll(); /// Lee todos los registros de biblioteca
		Iterator<Biblioteca> ite = listaBiblioteca.iterator();
		while(ite.hasNext()) {
			Biblioteca bib = ite.next();
			if(bib.getLibro().getISBN().equals(lib.getISBN())) {  /// Busca el ISBN en el registro
				INegocioBiblioteca NegBib = new NegocioBiblioteca();
				NegBib.deleteBiblioteca(bib); /// Borra el registro correspondiente
			}
		}
		lib.getAutor().setNacionalidad(null); /// Se configura nacionalidad del autor en null para evitar borrado en cascada
		lib.getGeneros().clear(); /// Se borra lista de generos del libro para evitar borrado en cascada
		DaoHibernateLibro.DeleteLibro(lib);; /// Remueve de la base de datos el libro indicado		
	}

	public Libro leerUno(String ISBN) {
		return DaoHibernateLibro.ReadOne(ISBN); /// Lee un registro de la tabla libros
	}
	
	public List<Libro> leerTodo(){		
		return DaoHibernateLibro.ReadAll(); /// Lee todos los registros de la tabla libros
	}

}
