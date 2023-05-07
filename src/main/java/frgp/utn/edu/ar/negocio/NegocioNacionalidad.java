package frgp.utn.edu.ar.negocio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import frgp.utn.edu.ar.entidad.Nacionalidad;
import frgp.utn.edu.ar.negocioInterfaz.INegocioNacionalidad;

public class NegocioNacionalidad implements INegocioNacionalidad {
private List<Nacionalidad> lista = new ArrayList<Nacionalidad>();
	
	public void cargarLista() {
		lista.add(new Nacionalidad("Argentina"));
		lista.add(new Nacionalidad("Uruguay"));
    	lista.add(new Nacionalidad("Brasil"));
    	lista.add(new Nacionalidad("Estados Unidos"));
	}
	
	public List<Nacionalidad> obtenerLista() {
		if(lista.size()>0) {
			return lista;
		}else {
			return null;
		}
	}
	
	public Nacionalidad getNacionalidad(String Nac) {
		Iterator<Nacionalidad> ite = lista.iterator();
		
		while(ite.hasNext()) {
			Nacionalidad Nacio = ite.next();
			if(Nacio.getDescripcion().equalsIgnoreCase(Nac)) {
				return Nacio;
			}
		}
		return null;
	}
}
