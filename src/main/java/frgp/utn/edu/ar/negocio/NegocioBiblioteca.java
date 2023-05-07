package frgp.utn.edu.ar.negocio;

import java.sql.Date;
import java.util.List;

import frgp.utn.edu.ar.dao.DaoHibernateBiblioteca;
import frgp.utn.edu.ar.entidad.Biblioteca;
import frgp.utn.edu.ar.entidad.EEstadoBiblioteca;
import frgp.utn.edu.ar.negocioInterfaz.INegocioBiblioteca;
import frgp.utn.edu.ar.negocioInterfaz.INegocioLibro;

public class NegocioBiblioteca implements INegocioBiblioteca {

	@Override
	public void cargarLista() {    
		
		INegocioLibro NegLib = new NegocioLibro();
		
		NegLib.cargarLista();
		 	
    	agegarBiblioteca(new Biblioteca(NegLib.leerUno("9786075387611"),EEstadoBiblioteca.EN_BIBLIOTECA, Date.valueOf("2023-02-02"))); /// SE MODIFICA
    	agegarBiblioteca(new Biblioteca(NegLib.leerUno("9789504981015"),EEstadoBiblioteca.EN_BIBLIOTECA, Date.valueOf("2018-03-03"))); /// SE MODIFICA 
    	agegarBiblioteca(new Biblioteca(NegLib.leerUno("9789504981015"),EEstadoBiblioteca.EN_BIBLIOTECA, Date.valueOf("2017-01-01"))); /// SE BORRA REGISTRO
    	agegarBiblioteca(new Biblioteca(NegLib.leerUno("9788491134510"),EEstadoBiblioteca.PRESTADO, Date.valueOf("2020-03-03"))); /// QUEDA IGUAL
    	agegarBiblioteca(new Biblioteca(NegLib.leerUno("9788417347741"),EEstadoBiblioteca.PRESTADO, Date.valueOf("2023-02-02"))); /// SE BORRA LIBRO
   
	}

	@Override
	public void agegarBiblioteca(Biblioteca biblio) {
		DaoHibernateBiblioteca.AddBiblioteca(biblio); /// Guarda un registro en la DB
	}

	@Override
	public Biblioteca leerUno(int id) {
		return DaoHibernateBiblioteca.ReadOne(id); /// Lee un registro de la tabla bibliotecas
	}

	@Override
	public List<Biblioteca> leerTodo() {
		return DaoHibernateBiblioteca.ReadAll(); /// Lee todos los registros de la tabla bibliotecas
	}

	@Override
	public void modificarBiblioteca(Biblioteca biblio) {
		DaoHibernateBiblioteca.UpdateBiblioteca(biblio); /// Modifica un registro en la table bibliotecas
	}

	@Override
	public void deleteBiblioteca(Biblioteca biblio) {
		biblio.setLibro(null);
		DaoHibernateBiblioteca.DeleteBiblioteca(biblio); /// borra un registro de la tabla bibliotecas
	}
}