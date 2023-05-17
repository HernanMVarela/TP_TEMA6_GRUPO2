package frgp.utn.edu.ar.negocioInterfaz;

import java.util.List;

import frgp.utn.edu.ar.entidad.Biblioteca;

public interface INegocioBiblioteca {
	public List<Biblioteca> punto_2();
	public void cargarLista();
	public void agegarBiblioteca(Biblioteca biblio);
	public Biblioteca leerUno(int id);
	public List<Biblioteca> leerTodo();
	public void modificarBiblioteca(Biblioteca biblio);
	public void deleteBiblioteca(Biblioteca biblio);
}