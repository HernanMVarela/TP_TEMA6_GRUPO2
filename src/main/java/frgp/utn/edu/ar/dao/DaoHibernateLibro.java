package frgp.utn.edu.ar.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import frgp.utn.edu.ar.entidad.Libro;

public class DaoHibernateLibro {
	public static void AddLibro(Libro libro) {
		try {
			ConfigHibernate ch = new ConfigHibernate();
			Session session = ch.abrirConexion();
		
			session.beginTransaction();
			session.save(libro);
			
			session.getTransaction().commit();
			ch.cerrarSession();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public static Libro ReadOne(String ISBN) {
		try {
			ConfigHibernate ch = new ConfigHibernate();
			Session session = ch.abrirConexion();
			
			session.beginTransaction();
			Libro libro = (Libro)session.get(Libro.class, ISBN);
			
			ch.cerrarSession();
			
			return libro;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static List<Libro> ReadAll() {
		try {
			ConfigHibernate ch = new ConfigHibernate();
			Session session = ch.abrirConexion();
			
			session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Libro> libro = (List<Libro>)session.createCriteria(Libro.class).list();
			
			ch.cerrarSession();
			
			return libro;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static void UpdateLibro(Libro libro) {
		try {
			ConfigHibernate ch = new ConfigHibernate();
			Session session = ch.abrirConexion();
			
			session.beginTransaction();
			session.update(libro);
			
			session.getTransaction().commit();
			ch.cerrarSession();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public static void DeleteLibro(Libro libro) {
		try {
			ConfigHibernate ch = new ConfigHibernate();
			Session session = ch.abrirConexion();
			
			session.beginTransaction();
			session.delete(libro);
			
			session.getTransaction().commit();
			ch.cerrarSession();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public static String MaxISBN() {
		try {
			ConfigHibernate ch = new ConfigHibernate();
			Session session = ch.abrirConexion();
		
			session.beginTransaction();
			@SuppressWarnings("unchecked")

			// Mostrar el libro que tenga el mayor número de ISBN

			String Lib = (String)session.createQuery("SELECT l.ISBN FROM Libro l "
												   + "WHERE l.ISBN = (SELECT MAX(l.ISBN) FROM Libro l)")
										.uniqueResult();

			session.getTransaction().commit();
			ch.cerrarSession();

			return Lib;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	public static void punto_6() {
		
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Object[]> lista = (List<Object[]>)session.createQuery("SELECT G.idGenero, G.nombre, COUNT(L.ISBN) "
																 + "FROM Libro L "
																 + "INNER JOIN L.generos G "
																 + "GROUP BY G.idGenero, G.nombre").list();
		ch.cerrarSession();
		
		for (Object[] objects : lista) {
			System.out.println(objects[0].toString() + " - " + objects[1].toString() + ": " + objects[2].toString());
		}
		
	try {	
	} catch (Exception e) {
		System.out.println(e.toString());

	}
}
}
