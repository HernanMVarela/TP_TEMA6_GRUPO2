package frgp.utn.edu.ar.negocioInterfaz;

import java.util.List;

import frgp.utn.edu.ar.entidad.Nacionalidad;

public interface INegocioNacionalidad {
	public void cargarLista();
	public List<Nacionalidad> obtenerLista();
}
