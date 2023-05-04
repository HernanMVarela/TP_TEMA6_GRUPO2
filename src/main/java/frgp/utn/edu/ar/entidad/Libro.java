package frgp.utn.edu.ar.entidad;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity (name="libros")
public class Libro {

	@Id
	@Column(name="ISBN")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ISBN;
	@Column
	private String titulo;
	@Column
	private Date fecha_lanzamiento;
	@Column
	private String idioma;
	@Column
	private int cant_paginas;
	@Column
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
        this.fecha_lanzamiento = fecha_lanzamiento;
        this.idioma = idioma;
        this.cant_paginas = cant_paginas;
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
		return fecha_lanzamiento;
	}

	public void setFecha_lanzamiento(Date fecha_lanzamiento) {
		this.fecha_lanzamiento = fecha_lanzamiento;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public int getCant_paginas() {
		return cant_paginas;
	}

	public void setCant_paginas(int cant_paginas) {
		this.cant_paginas = cant_paginas;
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
