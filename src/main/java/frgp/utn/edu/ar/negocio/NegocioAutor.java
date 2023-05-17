package frgp.utn.edu.ar.negocio;

import java.util.List;

import frgp.utn.edu.ar.dao.DaoHibernateAutor;
import frgp.utn.edu.ar.entidad.Autor;
import frgp.utn.edu.ar.negocioInterfaz.INegocioAutor;

public class NegocioAutor implements INegocioAutor {
	
	@Override
	public List<Autor> punto_3() {
		List<Autor> listaAutor = DaoHibernateAutor.punto_3();
		return listaAutor;
	}	
}