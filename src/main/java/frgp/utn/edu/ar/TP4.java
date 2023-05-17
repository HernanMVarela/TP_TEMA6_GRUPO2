package frgp.utn.edu.ar;

import java.util.List;

import org.hibernate.Session;

import frgp.utn.edu.ar.dao.ConfigHibernate;
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
		Session session1 = ch1.abrirConexion();
		
		System.out.println("\n---------------------------------------------------------------------------\n");
		System.out.println("\tPUNTO 1\n" );
		System.out.println("Mostrar todos los libros ordenados según ISBN de mayor a menor.\n");

		List<Libro> listaLibros = (List<Libro>) session1.createQuery("FROM Libro ORDER BY ISBN DESC").list();

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

		ch1.cerrarSession();		
		
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
		
        
		System.out.println("\n---------------------------------------------------------------------------\n");
		System.out.println("\tPUNTO 4\n" );
		System.out.println("Mostrar el libro con ISBN 12345 junto con todos sus géneros.\n");

		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();

        Libro libro = (Libro) session.createQuery("SELECT l FROM Libro l LEFT JOIN FETCH l.generos WHERE l.ISBN = :isbn")
                .setParameter("isbn", "12345")
                .uniqueResult();

        if (libro != null) {

            System.out.println("----- Información del Libro -----");
            System.out.println("ISBN: " + libro.getISBN());
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Fecha de lanzamiento: " + libro.getFechaLanzamiento());
            System.out.println("Idioma: " + libro.getIdioma());
            System.out.println("Cantidad de páginas: " + libro.getCantPaginas());
            System.out.println("Autor: " + libro.getAutor().getId() + " - " + libro.getAutor().getNombre() + " " + libro.getAutor().getApellido());
            System.out.println("Descripción: " + libro.getDescripcion());

            System.out.println("Géneros:");
            for (Genero genero : libro.getGeneros()) {
                System.out.println("ID Genero: " + genero.getId_genero() + " | Descripción: " + genero.getNombre());
            }
        } else {
            System.out.println("No se encontró ningún libro con el ISBN buscado.");
        }

		ch.cerrarSession();	
		
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

}
