package frgp.utn.edu.ar.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import frgp.utn.edu.ar.entidad.Autor;
import frgp.utn.edu.ar.entidad.Nacionalidad;

public class DaoHibernateAutor {
	
	public static List<Autor> punto_3() {
		try {
			ConfigHibernate ch = new ConfigHibernate();
			Session session = ch.abrirConexion();
		
			session.beginTransaction();
			@SuppressWarnings("unchecked")

			List<Autor> fullList = (List<Autor>)session.createQuery("SELECT a FROM Autor "
																  + "a LEFT JOIN a.nacionalidad n "
																  + "WHERE n.descripcion = :nombrePais")
														.setParameter("nombrePais", "Argentina")
														.list();

			session.getTransaction().commit();
			ch.cerrarSession();

			return fullList;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}	
}