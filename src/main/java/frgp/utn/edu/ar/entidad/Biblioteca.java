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
@Table(name="BIBLIOTECAS")
public class Biblioteca implements Serializable, Comparable<Biblioteca> {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_BIBLIOTECA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBiblioteca;
	
	@Column(name="FECHA_ALTA")
	private Date fechadealta = new Date(System.currentTimeMillis());
	
	@Column(name="ESTADO")
	private EEstadoBiblioteca estado;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="ISBN",nullable = false)
	private Libro libro;

	public Biblioteca() {
	}
	
	public Biblioteca(Libro nuevo,EEstadoBiblioteca estado, Date fechadealta) {
		super();
		this.fechadealta = fechadealta;
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

	public EEstadoBiblioteca getEstado() {
		return estado;
	}

	public void setEstado(EEstadoBiblioteca estado) {
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
	
	@Override
	public String toString() {
		return "\nRegistro de Biblioteca: "
				+ "\n Id en biblioteca: "  + idBiblioteca + 
				"\n Libro: " + libro.toString()
				+"\n Fecha de Alta: " + fechadealta.toString()
			    + "\n Estado: " + estado;
	}

	@Override
	public int compareTo(Biblioteca o) {
		if(this.idBiblioteca==o.idBiblioteca) {return 0;}
		else if(this.idBiblioteca>o.idBiblioteca) { return 1;}
		else { return -1;}
	}	
}
