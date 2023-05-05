package frgp.utn.edu.ar.entidad;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Libro implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private String ISBN;
	private String titulo;
	private Date fechaLanzamiento;
	private String idioma;
	private int cantPaginas;
	private String descripcion;
	
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "id_autor",nullable = false)
	private Autor autor;
	
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinTable(
			name = "libro_genero", 
			joinColumns = { @JoinColumn(name = "ISBN_Libro") }, 
			inverseJoinColumns = { @JoinColumn(name = "id_genero") }
	)
	@Fetch (FetchMode.SELECT)
	private Set<Genero> generos = new HashSet<Genero>();
	
	public Libro() {}
	
	public Libro(String ISBN, 
				 String titulo,
				 Date fecha_lanzamiento, 
				 String idioma, 
				 int cantPaginas,
				 String descripcion, 
				 Autor autor) {
		this.ISBN = ISBN;
        this.titulo = titulo;
        this.fechaLanzamiento = fecha_lanzamiento;
        this.idioma = idioma;
        this.cantPaginas = cantPaginas;
        this.descripcion = descripcion;
        this.autor = autor;
    }

	
	@Override
	public String toString() {
		return "\nISBN: " + ISBN + " | Titulo: " + titulo + "\n" +"Descripcion: " + descripcion +" | Lanzamiento: " + fechaLanzamiento + "\n" +"Idioma: "
				+ idioma + " | Páginas: " + cantPaginas + " | Generos: " + listaDeGeneros() +"\n" + "Autor: " + autor.toString();
	}


	 private String listaDeGeneros() {
		String listaGeneros = new String();
		for (Genero genero : generos) {
			listaGeneros += genero.getNombre() + ", ";
		}
		return listaGeneros;
	}
	
	
	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
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
