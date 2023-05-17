package frgp.utn.edu.ar;

import java.util.List;


import org.hibernate.Session;

import frgp.utn.edu.ar.dao.ConfigHibernate;
import frgp.utn.edu.ar.entidad.Biblioteca;
import frgp.utn.edu.ar.entidad.Genero;
import frgp.utn.edu.ar.entidad.Libro;
import frgp.utn.edu.ar.negocio.NegocioBiblioteca;
import frgp.utn.edu.ar.negocioInterfaz.INegocioBiblioteca;

public class TP4 {

	public static void main(String[] args) {
		
		
		/*
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		List<Libro> listaLibros = (List<Libro>) session.createQuery("FROM Libro ORDER BY ISBN DESC").list();
		
		for (Libro lib : listaLibros) {
			System.out.println("Libro: " + lib.toString());
		}
		
		ch.cerrarSession();
		
		*/
		
		System.out.println("\n---------------------------------------------------------------------------\n");
		System.out.println("                                    PUNTO 2");
		System.out.println("    Mostrar todos los libros de la biblioteca que se encuentran prestados.\n");
		
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
		
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();

        Libro libro = (Libro) session.createQuery("SELECT l FROM Libro l LEFT JOIN FETCH l.generos WHERE l.ISBN = :isbn")
                .setParameter("isbn", "12345")
                .uniqueResult();
        
        System.out.println("\n\t\t ------------ PUNTO 4 --------------------\n" );
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
	}

}
