package frgp.utn.edu.ar.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name="Biblioteca")
public class Biblioteca {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private long libro;
	
	@Column
	private Date fechadealta = new Date(System.currentTimeMillis());
	
	@Column
	private String estado;
	
	public Biblioteca() {
		super();
		this.libro = 0;
		this.estado = "Desconocido";
	}
	
	public Biblioteca(long libro,String estado) {
		super();
		this.libro = libro;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public long getLibro() {
		return libro;
	}

	public void setLibro(long libro) {
		this.libro = libro;
	}

	/*public String getFechadealta() {
		return fechadealta;
	}

	public void setFechadealta(long fechadealta) {
		this.fechadealta = fechadealta;
	}*/

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Registro de Biblioteca: [ id = " + id + ", Libro = " + libro + ", Fecha de Alta = " 
	+ fechadealta.toString() + ", Estado = " + estado + "]";
	}
	
}
