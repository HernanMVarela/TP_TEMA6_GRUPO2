package frgp.utn.edu.ar.negocioInterfaz;

import java.util.List;

import frgp.utn.edu.ar.entidad.Libro;

public interface INegocioLibro {
	public void cargarLista();
	public void agregarLibro(Libro lib);
	public void guardarLista(List<Libro> lista);
	public void modificarLibro(Libro lib);
	public void borrarLibro(Libro lib);
	public Libro leerUno(String ISBN);
	public List<Libro> leerTodo();
	public String MaxISBN();	

}
