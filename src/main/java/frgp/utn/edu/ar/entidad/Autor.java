package frgp.utn.edu.ar.entidad;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Autor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAutor;
	private String nombre;
	private String apellido;
	private String email;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="id")
	private Nacionalidad nacionalidad;
	
	public Autor() {}
	
	public Autor(String nombre, String apellido, Nacionalidad nacionalidad, String email) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacionalidad = nacionalidad;
		this.email = email;
	}
	
	
	public int getId() {
		return idAutor;
	}

	public void setId(int id) {
		this.idAutor = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Nacionalidad getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Nacionalidad nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ID: " + idAutor + " | Nombre: " + nombre + " " + apellido + " | Nacionalidad: " + nacionalidad.getDescripcion() + " | Correo: " + email;
	}
}
