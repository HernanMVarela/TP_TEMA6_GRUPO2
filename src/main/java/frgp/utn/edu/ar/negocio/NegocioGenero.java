package frgp.utn.edu.ar.negocio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import frgp.utn.edu.ar.entidad.Genero;
import frgp.utn.edu.ar.negocioInterfaz.INegocioGenero;

public class NegocioGenero implements INegocioGenero{
	private List<Genero> lista = new ArrayList<Genero>();
	
	public void cargarLista() {
		lista.add(new Genero("Programacion"));
		lista.add(new Genero("Computacion"));
		lista.add(new Genero("Historia"));
		lista.add(new Genero("Humanidad"));
		lista.add(new Genero("Medicina"));
		lista.add(new Genero("Ficción"));
	}
	
	public List<Genero> obtenerLista() {
		if(lista.size()>0) {
			return lista;
		}else {
			return null;
		}
	}
	
	public Genero getGenero(String Gen) {
		Iterator<Genero> ite = lista.iterator();
		
		while(ite.hasNext()) {
			Genero Gene = ite.next();
			if(Gene.getNombre().equalsIgnoreCase(Gen)) {
				return Gene;
			}
		}
		return null;
	}
}
