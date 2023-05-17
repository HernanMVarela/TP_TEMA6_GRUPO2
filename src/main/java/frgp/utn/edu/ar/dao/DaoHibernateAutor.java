package frgp.utn.edu.ar.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import frgp.utn.edu.ar.entidad.Autor;

public class DaoHibernateAutor {
	
	public static List<Autor> punto_3() {
		try {
			ConfigHibernate ch = new ConfigHibernate();
			Session session = ch.abrirConexion();
		
			session.beginTransaction();
			@SuppressWarnings("unchecked")
			
			
			List<Autor> autores = new ArrayList<Autor>();
			
			
			return autores;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}	
}