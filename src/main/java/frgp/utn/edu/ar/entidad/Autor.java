package frgp.utn.edu.ar.entidad;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="AUTORES")
public class Autor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_AUTOR")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAutor;
	@Column(name="NOMBRE", nullable = false)
	private String nombre;
	@Column(name="APELLIDO", nullable = false)
	private String apellido;
	@Column(name="EMAIL")
	private String email;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="ID_NACIONALIDAD",nullable = true)
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
