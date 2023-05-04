package frgp.utn.edu.ar.entidad;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.Session;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="Biblioteca")
public class Biblioteca implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_biblioteca")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBiblioteca;
	
	@Column(name="fechaAlta")
	private Date fechadealta = new Date(System.currentTimeMillis());
	
	@Column(name="estado")
	private String estado;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="ISBN")
	private Libro libro;

	public Biblioteca() {
		super();
		this.libro = new Libro();
		this.estado = "Desconocido";
	}
	
	public Biblioteca(Libro nuevo,String estado) {
		super();
		this.libro = nuevo;
		this.estado = estado;
	}

	public int getIdBiblioteca() {
		return idBiblioteca;
	}
	
	public void setIdBiblioteca(int idBiblioteca) {
		this.idBiblioteca = idBiblioteca;
	}

	public Date getFechadealta() {
		return fechadealta;
	}

	public void setFechadealta(Date fechadealta) {
		this.fechadealta = fechadealta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}	

	public void guardarEnBD(Session SES) {
		SES.save(this);
	}
	
	public void updateEnBD(Session SES) {
		SES.save(this);
	}
	
	/*public void cargarDeBD(Session SES, int idCarga) {
		Biblioteca Bib = (Biblioteca)SES.get(Biblioteca.class,idCarga);
		//setId(Bib.getId());
		this.ISBN = Bib.getISBN();
		this.estado = Bib.getEstado();
		this.fechadealta = Bib.getFechadealta();
	}*/
	
	@Override
	public String toString() {
		return "Registro de Biblioteca: [ id = " + id + ", ISBN = " + libro.getISBN() + ", Fecha de Alta = " 
	+ fechadealta.toString() + ", Estado = " + estado + "]";
	}	
}
