package frgp.utn.edu.ar;

import java.sql.Date;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import frgp.utn.edu.ar.entidad.Biblioteca;
import frgp.utn.edu.ar.entidad.EEstadoBiblioteca;
import frgp.utn.edu.ar.negocio.NegocioBiblioteca;
import frgp.utn.edu.ar.negocio.NegocioLibro;
import frgp.utn.edu.ar.negocioInterfaz.INegocioBiblioteca;
import frgp.utn.edu.ar.negocioInterfaz.INegocioLibro;

public class App 
{
	
    public static void main( String[] args )
    {
    	    	
    	INegocioLibro NegLib = new NegocioLibro();
    	INegocioBiblioteca NegBib = new NegocioBiblioteca();
    	
    	/// CARGA LISTA DE LIBROS Y REGISTROS DE BIBLIOTECA
    	NegBib.cargarLista();
    	
    	List<Biblioteca> lista = NegBib.leerTodo(); /// CARGA TODOS LOS REGISTROS DE BIBLIOTECA EN UNA LISTA
    	Iterator<Biblioteca> ite = lista.iterator();
    	
    	System.out.println("\n \n----------------- DATOS ORIGINALES ---------------------------");
    	while(ite.hasNext()) {
    		System.out.println(ite.next().toString()); /// MUESTRA LA LISTA ORIGINAL POR CONSOLA
    	}   
    	
    	/// MODIFICACION DE REGISTROS
    	Biblioteca modify1 = NegBib.leerUno(1);
    	modify1.setEstado(EEstadoBiblioteca.PRESTADO); /// CAMBIO DE ESTADO
    	modify1.setFechadealta( Date.valueOf("2023-05-06")); /// CAMBIO DE FECHA
    	
    	Biblioteca modify2 = NegBib.leerUno(5);
    	modify2.setEstado(EEstadoBiblioteca.EN_BIBLIOTECA); /// CAMBIO DE ESTADO
    	modify2.setFechadealta( Date.valueOf("2023-05-06")); /// CAMBIO DE FECHA
    	
    	NegBib.modificarBiblioteca(modify1); /// MODIFICA REGISTRO
    	NegBib.modificarBiblioteca(modify2); /// MODIFICA REGISTRO
    	
    	/// BORRADO DE REGISTROS   	
    	NegBib.deleteBiblioteca(NegBib.leerUno(3)); /// BORRA BIBLIOTECA DE LA DB SIN BORRAR EL LIBRO
    	NegLib.borrarLibro(NegLib.leerUno("9788491134510")); /// BORRA LIBRO DE LA DB Y BIBLIOTECAS ASOCIADAS
    		
    	lista = NegBib.leerTodo(); /// CARGA NUEVAMENTE TODOS LOS REGISTROS MODIFICADOS DE BIBLIOTECA EN UNA LISTA
    	Collections.sort(lista); /// ORDENA LISTA POR ID DE BIBLIOTECA
    	ite = lista.iterator();
    	
    	System.out.println("\n\n ----------------- DATOS MODIFICADOS ---------------------------");
    	while(ite.hasNext()) {
    		System.out.println(ite.next().toString()); /// MUESTRA LA LISTA MODIFICADA POR CONSOLA
    	}   
    	
    }
}
