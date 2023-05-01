package frgp.utn.edu.ar.entidad;

public class Genero {

	private int id_genero;
	private String nombre;
	
	public Genero() {}
	
	public Genero(String nombre) {

		this.nombre=nombre;
	}
	
	@Override
	public String toString() {
		return id_genero + " - " + nombre;
	}

	public int getId_genero() {
		return id_genero;
	}

	public void setId_genero(int id_genero) {
		this.id_genero = id_genero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
