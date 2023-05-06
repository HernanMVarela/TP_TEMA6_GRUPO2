package frgp.utn.edu.ar.negocio;

import java.sql.Date;
import java.util.List;

import frgp.utn.edu.ar.dao.DaoHibernateBiblioteca;
import frgp.utn.edu.ar.dao.DaoHibernateLibro;
import frgp.utn.edu.ar.entidad.Autor;
import frgp.utn.edu.ar.entidad.Biblioteca;
import frgp.utn.edu.ar.entidad.Libro;
import frgp.utn.edu.ar.negocioInterfaz.INegocioBiblioteca;
import frgp.utn.edu.ar.negocioInterfaz.INegocioGenero;
import frgp.utn.edu.ar.negocioInterfaz.INegocioNacionalidad;

public class NegocioBiblioteca implements INegocioBiblioteca {

	//TO DO
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
    	Biblioteca biblio1 = new Biblioteca(libro1,"Prestado");
    	agegarBiblioteca(biblio1);
    
	}

	//TO DO
	@Override
	public void agegarBiblioteca(Biblioteca biblio) {
		DaoHibernateBiblioteca.AddBiblioteca(biblio); /// Lo guarda en la DB
	}

	//TO DO
	@Override
	public Biblioteca leerUno(int id) {
		return DaoHibernateBiblioteca.ReadOne(id); /// Lee un registro de la tabla libros
		
	}

	//TO DO
	@Override
	public List<Biblioteca> leerTodo() {
		return null;
	}

	//TO DO
	@Override
	public void modificarBiblioteca(Biblioteca biblio) {}

	//TO DO
	@Override
	public void deleteBiblioteca(Biblioteca biblio) {}
}