package frgp.utn.edu.ar.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GENEROS")
public class Genero implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_GENEROS",nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idGenero;

	@Column(name="NOMBRE",nullable = false)
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
