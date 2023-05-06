package frgp.utn.edu.ar.negocio;

import java.sql.Date;
import java.util.List;

import frgp.utn.edu.ar.dao.DaoHibernateBiblioteca;
import frgp.utn.edu.ar.dao.DaoHibernateLibro;
import frgp.utn.edu.ar.entidad.Biblioteca;
import frgp.utn.edu.ar.negocioInterfaz.INegocioBiblioteca;

public class NegocioBiblioteca implements INegocioBiblioteca {

	//TO DO
	@Override
	public void cargarLista() {    	
    
	}

	//TO DO
	@Override
	public void agegarBiblioteca(Biblioteca biblio) {}

	//TO DO
	@Override
	public Biblioteca leerUno(int id) {
		return null;
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