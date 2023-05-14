package frgp.utn.edu.ar;

import java.util.List;

import org.hibernate.Session;

import frgp.utn.edu.ar.dao.ConfigHibernate;
import frgp.utn.edu.ar.dao.DaoHibernateBiblioteca;
import frgp.utn.edu.ar.entidad.Biblioteca;
import frgp.utn.edu.ar.entidad.Libro;

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
		
		List<Biblioteca> lista = DaoHibernateBiblioteca.punto_2();
		
		for (Biblioteca biblioteca : lista) {
			System.out.println(" ID: " + biblioteca.getIdBiblioteca() + 
					   " | Fecha: " + biblioteca.getFechadealta().toString() + 
					   " | Estado: " + biblioteca.getEstado());
		}
		
	}

}
