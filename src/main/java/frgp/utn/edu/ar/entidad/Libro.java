package frgp.utn.edu.ar.entidad;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
	
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "id_autor")
	@Column(name="autor")
	private Autor autor;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
			name = "libro_genero", 
			joinColumns = { @JoinColumn(name = "ISBN") }, 
			inverseJoinColumns = { @JoinColumn(name = "id_genero") }
	)
	private Set<Genero> generos = new HashSet<Genero>();
	
	public Libro() {}
	
	public Libro(int ISBN, 
				 String titulo,
				 Date fecha_lanzamiento, 
				 String idioma, 
				 int cantPaginas,
				 String descripcion, 
				 Autor autor,
				 Set<Genero> generos) {
		this.ISBN = ISBN;
        this.titulo = titulo;
        this.fechaLanzamiento = fecha_lanzamiento;
        this.idioma = idioma;
        this.cantPaginas = cantPaginas;
        this.descripcion = descripcion;
        this.autor = autor;
		this.generos = generos;
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

	public Date getFechaLanzamiento() {
		return fechaLanzamiento;
	}

	public void setFechaLanzamiento(Date fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public int getCantPaginas() {
		return cantPaginas;
	}

	public void setCantPaginas(int cantPaginas) {
		this.cantPaginas = cantPaginas;
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
	
	public Set<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(Set<Genero> generos) {
		this.generos = generos;
	}	
}
