package frgp.utn.edu.ar.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="NACIONALIDADES")
public class Nacionalidad implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_NACIONALIDAD",nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idNacionalidad;

	@Column(name="DESCRIPCION",nullable = false)
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setNombre(String descripcion) {
		this.descripcion = descripcion;
	}	
}