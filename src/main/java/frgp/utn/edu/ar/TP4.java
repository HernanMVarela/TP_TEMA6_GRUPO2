package frgp.utn.edu.ar;

import java.util.List;

import org.hibernate.Session;

import frgp.utn.edu.ar.dao.ConfigHibernate;
import frgp.utn.edu.ar.entidad.Libro;

public class TP4 {

	public static void main(String[] args) {
		
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		List<Libro> listaLibros = (List<Libro>) session.createQuery("FROM Libro ORDER BY ISBN DESC").list();
		
		for (Libro lib : listaLibros) {
			System.out.println("Libro: " + lib.toString());
		}
		
		ch.cerrarSession();
	}

}
