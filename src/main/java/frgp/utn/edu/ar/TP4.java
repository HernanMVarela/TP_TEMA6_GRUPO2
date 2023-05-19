package frgp.utn.edu.ar;

import java.util.List;

import frgp.utn.edu.ar.entidad.Biblioteca;
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
		
		puntoUno();
		puntoDos();
		puntoTres();
		puntoCuatro();
		puntoCinco();
		puntoSeis();
	}
	
	private static void puntoUno() {
		
		INegocioLibro NegLib = new NegocioLibro();
		List<Libro> listaLibros = NegLib.punto_1();
		
		System.out.println("\n ---------------------------------------------------------------------------");
		System.out.println("                                    PUNTO 1");
		System.out.println("          Mostrar toados los libros ordenados según ISBN de mayor a menor.\n");
		
	    for (Libro lib : listaLibros) {
	    	System.out.println(" " + lib.toString());
	    }
	}
	
	private static void puntoDos() {

		System.out.println("\n ---------------------------------------------------------------------------");
		System.out.println("                                    PUNTO 2");
		System.out.println("     Mostrar todos los libros de la biblioteca que se encuentran prestados.\n");
		
		INegocioBiblioteca NegBib = new NegocioBiblioteca();
		List<Biblioteca> lista = NegBib.punto_2();
		if (lista != null) {
			for (Biblioteca biblioteca : lista) {
				System.out.println(" ID: " + biblioteca.getIdBiblioteca() + 
						   " | Fecha: " + biblioteca.getFechadealta().toString() + 
						   " | Estado: " + biblioteca.getEstado());
			}
		}else {
			System.out.println(" Ningún libro prestado.\n");
		}
	}
	
	private static void puntoTres() {

		System.out.println("\n ---------------------------------------------------------------------------");
		System.out.println("                                    PUNTO 3");
		System.out.println("           Mostrar todos los autores que sean de nacionalidad Argentina.");
		
		INegocioAutor NegAut = new NegocioAutor();
		List<Autor> listaAutor = NegAut.punto_3();

		if (listaAutor != null) {
			for (Autor autor : listaAutor) {
				System.out.println(" " + autor.toString());
			}
		}else {
			System.out.println(" Ningún autor argentino.\n");
		}
	}
	
	private static void puntoCuatro() {

		System.out.println("\n ---------------------------------------------------------------------------");
		System.out.println("                                    PUNTO 4");
		System.out.println("           Mostrar el libro con ISBN 12345 junto con todos sus géneros.\n");
		
		INegocioLibro NegLib = new NegocioLibro();
		
		Libro libro = NegLib.punto_4("12345"); /// Alternativamente, se puede probar con un ISBN real: 9788491134510
        if (libro != null) {
            System.out.println(libro.toString());
           
        } else {
            System.out.println(" No se encontró ningún libro con el ISBN buscado.");
        }
	}
	
	private static void puntoCinco() {
		System.out.println("\n ---------------------------------------------------------------------------");
		System.out.println("                                    PUNTO 5");
		System.out.println("              Mostrar el libro que tenga el mayor número de ISBN.\n");
		
		INegocioLibro NegLib = new NegocioLibro();
		String MaxISBN = NegLib.punto_5();

		if (MaxISBN != null) {
			System.out.println(" El libro de mayor ISBN es el " + MaxISBN + ".");
		}else {
			System.out.println(" Error.\n");
		}
	}
	
	private static void puntoSeis() {
		System.out.println("\n ---------------------------------------------------------------------------");
		System.out.println("                                    PUNTO 6");
		System.out.println("           Mostrar la cantidad de libros que existen para cada género.\n");
		
		INegocioLibro NegLib = new NegocioLibro();
		List<String> lista = NegLib.punto_6();
		
		if (lista != null) {
			for (String resultado : lista) {
				System.out.println(" " + resultado);
			}
		}else {
			System.out.println(" No se registran libros cargados.");
		}
	}
}



