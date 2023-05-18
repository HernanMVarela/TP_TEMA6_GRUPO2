package frgp.utn.edu.ar;

import java.util.List;

import org.hibernate.Session;

import frgp.utn.edu.ar.dao.ConfigHibernate;
import frgp.utn.edu.ar.dao.DaoHibernateLibro;
import frgp.utn.edu.ar.entidad.Biblioteca;
import frgp.utn.edu.ar.entidad.Genero;
import frgp.utn.edu.ar.entidad.Libro;
import frgp.utn.edu.ar.entidad.Autor;
import frgp.utn.edu.ar.negocio.NegocioAutor;
import frgp.utn.edu.ar.negocio.NegocioBiblioteca;
import frgp.utn.edu.ar.negocio.NegocioLibro;
import frgp.utn.edu.ar.negocioInterfaz.INegocioAutor;
import frgp.utn.edu.ar.negocioInterfaz.INegocioBiblioteca;
import frgp.utn.edu.ar.negocioInterfaz.INegocioLibro;

public class TP4 {

	public static void main(String[] args) {
		
		ConfigHibernate ch1 = new ConfigHibernate();
		Session session = ch1.abrirConexion();
		
		puntoUno(session);
		puntoDos();
		puntoTres();
		puntoCuatro(session);
		puntoCinco();
		puntoSeis();
		ch1.cerrarSession();		
		
	}
	
	private static void puntoUno(Session session) {
		System.out.println("\n---------------------------------------------------------------------------\n");
		System.out.println("\tPUNTO 1\n" );
		System.out.println("Mostrar todos los libros ordenados según ISBN de mayor a menor.\n");

		List<Libro> listaLibros = (List<Libro>) session.createQuery("FROM Libro ORDER BY ISBN DESC").list();

	    for (Libro lib : listaLibros) {

	    	System.out.println("\n ----- Información del Libro -----");
	        System.out.println("ISBN: " + lib.getISBN());
	        System.out.println("Título: " + lib.getTitulo());
	        System.out.println("Fecha de lanzamiento: " + lib.getFechaLanzamiento());
	        System.out.println("Idioma: " + lib.getIdioma());
	        System.out.println("Cantidad de páginas: " + lib.getCantPaginas());
	        System.out.println("Autor: " + lib.getAutor().getId() + " - " + lib.getAutor().getNombre() + " " + lib.getAutor().getApellido());
	        System.out.println("Descripción: " + lib.getDescripcion());

	        System.out.println("Géneros:");
	        for (Genero genero : lib.getGeneros()) {
	            System.out.println("ID Genero: " + genero.getId_genero() + " | Descripción: " + genero.getNombre());
	        }
	    }

		
	}
	private static void puntoDos() {

		System.out.println("\n---------------------------------------------------------------------------\n");
		System.out.println("\tPUNTO 2\n" );
		System.out.println("Mostrar todos los libros de la biblioteca que se encuentran prestados.\n");
		
		INegocioBiblioteca NegBib = new NegocioBiblioteca();
		List<Biblioteca> lista = NegBib.punto_2();
		if (lista != null) {
			for (Biblioteca biblioteca : lista) {
				System.out.println(" ID: " + biblioteca.getIdBiblioteca() + 
						   " | Fecha: " + biblioteca.getFechadealta().toString() + 
						   " | Estado: " + biblioteca.getEstado());
			}
		}else {
			System.out.println("Ningún libro prestado.\n");
		}
		
	}
	
	private static void puntoTres() {

		System.out.println("\n---------------------------------------------------------------------------\n");
		System.out.println("\tPUNTO 3\n" );
		System.out.println("Mostrar todos los autores que sean de nacionalidad Argentina.\n");
		
		INegocioAutor NegAut = new NegocioAutor();
		List<Autor> listaAutor = NegAut.punto_3();

		if (listaAutor != null) {
			for (Autor autor : listaAutor) {
				System.out.println(autor.toString());
			}
		}else {
			System.out.println("Ningún autor argentino.\n");
		}
		
	}

	
	private static void puntoCuatro(Session session) {

		System.out.println("\n---------------------------------------------------------------------------\n");
		System.out.println("\tPUNTO 4\n" );
		System.out.println("Mostrar el libro con ISBN 12345 junto con todos sus géneros.\n");

		

        Libro libro = (Libro) session.createQuery("SELECT l FROM Libro l LEFT JOIN FETCH l.generos WHERE l.ISBN = :isbn")
                .setParameter("isbn", "12345")
                .uniqueResult();

        if (libro != null) {

            System.out.println("\t\t----- Información del Libro -----");
            System.out.println( libro.toString());
           
        } else {
            System.out.println("No se encontró ningún libro con el ISBN buscado.");
        }


		
	}
	private static void puntoCinco() {
		System.out.println("\n---------------------------------------------------------------------------\n");
		System.out.println("\tPUNTO 5\n" );
		System.out.println("Mostrar el libro que tenga el mayor número de ISBN.\n");
		System.out.println("(El único campo que se debe mostrar es ISBN.) \n \n");
		
		INegocioLibro NegLib = new NegocioLibro();
		String MaxISBN = NegLib.MaxISBN();

		if (MaxISBN != null) {
			System.out.println("El libro de mayor ISBN es el correspondiente al ISBN " + MaxISBN + ".");
		}else {
			System.out.println("Error.\n");
		}
		

	}
	private static void puntoSeis() {
		System.out.println("\n---------------------------------------------------------------------------\n");
		System.out.println("                                    PUNTO 6");
		System.out.println("         Mostrar la cantidad de libros que existen para cada género.\n");
		
		INegocioLibro NegLib = new NegocioLibro();
		List<String> lista = NegLib.punto_6();
		
		if (lista != null) {
			for (String resultado : lista) {
				System.out.println(resultado);
			}
		} else {
			System.out.println("Ningún libro prestado.\n");
		}
	}
}



