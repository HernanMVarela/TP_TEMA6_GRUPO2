package frgp.utn.edu.ar.entidad;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity (name="libros")
public class Libro implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ISBN")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ISBN;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="fecha_lanzamiento")
	private Date fechaLanzamiento;
	
	@Column(name="idioma")
	private String idioma;
	
	@Column(name="cant_paginas")
	private int cantPaginas;
	
	@Column(name="descripcion")
	private String descripcion;
	
	// Pendiente completar relacion 1aN 
	private Autor autor;
	
	// Pendiente completar relacion NaN
	//private Set<Genero> generos = new HashSet<Genero>();
	
	public Libro() {}
	
	public Libro(int ISBN, String titulo, Date fecha_lanzamiento, String idioma, int cant_paginas,
				 String descripcion, Autor autor) {
		this.ISBN = ISBN;
        this.titulo = titulo;
        this.fechaLanzamiento = fecha_lanzamiento;
        this.idioma = idioma;
        this.cantPaginas = cant_paginas;
        this.descripcion = descripcion;
        this.autor = autor;
    }
	/*	
	@Override
	public String toString() {
		return "\n ISBN: " + ISBN + " | Titulo: " + titulo + "\n" +"Descripcion: " + descripcion +" | Lanzamiento: " + fecha_lanzamiento + "\n" +"Idioma: "
				+ idioma + " | Páginas: " + cant_paginas + " | Generos: " + listaDeGeneros() +"\n" + "Autor: " + autor.toString();
	}


	 private String listaDeGeneros() {
		String listaGeneros = new String();
		for (Genero genero : generos) {
			listaGeneros += genero.getNombre() + ", ";
		}
		return listaGeneros;
	}
*/
	
	public long getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFecha_lanzamiento() {
		return fechaLanzamiento;
	}

	public void setFecha_lanzamiento(Date fecha_lanzamiento) {
		this.fechaLanzamiento = fecha_lanzamiento;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public int getCant_paginas() {
		return cantPaginas;
	}

	public void setCant_paginas(int cant_paginas) {
		this.cantPaginas = cant_paginas;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	/*
	public Set<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(Set<Genero> generos) {
		this.generos = generos;
	}
	*/		
}
