package frgp.utn.edu.ar.negocioInterfaz;

import java.util.List;

import frgp.utn.edu.ar.entidad.Genero;

public interface INegocioGenero {
	public void cargarLista();
	public List<Genero> obtenerLista();
}
