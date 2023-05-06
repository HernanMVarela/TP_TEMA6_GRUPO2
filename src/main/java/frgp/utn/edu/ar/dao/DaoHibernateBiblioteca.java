package frgp.utn.edu.ar.dao;

import java.util.List;

import org.hibernate.Session;

import frgp.utn.edu.ar.entidad.Biblioteca;

public class DaoHibernateBiblioteca {
	
	public static void AddBiblioteca(Biblioteca biblio) {
		try {
			ConfigHibernate ch = new ConfigHibernate();
			Session session = ch.abrirConexion();
		
			session.beginTransaction();
			session.save(biblio);
			
			session.getTransaction().commit();
			ch.cerrarSession();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public static Biblioteca ReadOne(int id) {
		
		try {
			ConfigHibernate ch = new ConfigHibernate();
			Session session = ch.abrirConexion();
			
			session.beginTransaction();
			Biblioteca biblio = (Biblioteca)session.get(Biblioteca.class, id);
			
			ch.cerrarSession();
			
			return biblio;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static List<Biblioteca> ReadAll() {
		try {
			ConfigHibernate ch = new ConfigHibernate();
			Session session = ch.abrirConexion();
			
			session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Biblioteca> biblio = (List<Biblioteca>)session.createCriteria(Biblioteca.class).list();
			
			ch.cerrarSession();
			
			return biblio;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static void UpdateBiblioteca(Biblioteca biblio) {
		try {
			ConfigHibernate ch = new ConfigHibernate();
			Session session = ch.abrirConexion();
			
			session.beginTransaction();
			session.update(biblio);
			
			session.getTransaction().commit();
			ch.cerrarSession();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public static void DeleteBiblioteca(Biblioteca biblio) {
		try {
			ConfigHibernate ch = new ConfigHibernate();
			Session session = ch.abrirConexion();
			
			session.beginTransaction();
			session.delete(biblio);
			
			session.getTransaction().commit();
			ch.cerrarSession();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}