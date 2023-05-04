package frgp.utn.edu.ar.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Nacionalidad implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_nacionalidad")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idNacionalidad;

	@Column(name="descripcion")
	private String descripcion;
	
	public Nacionalidad() {}
	
	public Nacionalidad(String descripcion) {
		this.descripcion=descripcion;
	}
	
	@Override
	public String toString() {
		return idNacionalidad + " - " + descripcion;
	}

	public int getIdNacionalidad() {
		return idNacionalidad;
	}

	public void setIdNacionalidad(int idNacionalidad) {
		this.idNacionalidad = idNacionalidad;
	}

	public String getdescripcion() {
		return descripcion;
	}

	public void setNombre(String descripcion) {
		this.descripcion = descripcion;
	}	
}