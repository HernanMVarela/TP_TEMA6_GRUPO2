package frgp.utn.edu.ar.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import frgp.utn.edu.ar.entidad.Biblioteca;
import frgp.utn.edu.ar.entidad.EEstadoBiblioteca;

public class DaoHibernateBiblioteca {
	
	public static List<Biblioteca> punto_2() {
		try {
			ConfigHibernate ch = new ConfigHibernate();
			Session session = ch.abrirConexion();
		
			session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Object[]> fullList = (List<Object[]>)session.createQuery("SELECT bib.idBiblioteca, "
																		+ "bib.fechadealta, "
																		+ "bib.estado "
																		+ "FROM Biblioteca as bib "
																		+ "WHERE bib.estado=1").list();
			session.getTransaction().commit();
			ch.cerrarSession();
			
			List<Biblioteca> bibliotecas = new ArrayList<Biblioteca>();
			
			for (Object[] objects : fullList) {
				Biblioteca biblio = new Biblioteca();
				biblio.setIdBiblioteca((Integer)objects[0]);
				biblio.setFechadealta((Date)objects[1]);
				biblio.setEstado((EEstadoBiblioteca)objects[2]);

				bibliotecas.add(biblio);
			}
			return bibliotecas;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}	
	
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