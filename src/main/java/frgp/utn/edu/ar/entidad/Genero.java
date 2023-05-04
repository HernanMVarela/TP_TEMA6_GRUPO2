package frgp.utn.edu.ar.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Genero implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_genero")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idGenero;

	@Column(name="nombre")
	private String nombre;
	
	public Genero() {}
	
	public Genero(String nombre) {
		this.nombre=nombre;
	}
	
	@Override
	public String toString() {
		return idGenero + " - " + nombre;
	}

	public int getId_genero() {
		return idGenero;
	}

	public void setId_genero(int id_genero) {
		this.idGenero = id_genero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
}
