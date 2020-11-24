package ar.edu.unlam.pb220202c.eva03;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Autopista {
	//Si es necesario Utilice herencia o implemente de Interfaces
	//Se debe crear contructeres getters y Setters y los atributos o metodos que crean convenientes
	private HashMap <Integer,Vehiculo> telepase;
	private HashSet <Vehiculo> vehiculosEnCirculacion;
	
	public Autopista() {
		super();
		this.telepase = new HashMap<>();
		this.vehiculosEnCirculacion = new HashSet<>();
	}
	
	public Boolean registrarTelepase (Integer numeroTelpase, Vehiculo vehiculo) {
		if(telepase.put(numeroTelpase, vehiculo) == null) {
			return true;
		}
		return false;
	}
	
	public Boolean ingresarAutopista (Integer numeroTelepase) throws VehiculoNotFoundException {
		//si el telepase no esta registrado lanza una Exceptios del tipo VehiculoNotFoundException
	   // y no permite ingresar al autopista	
		if(telepase.containsKey(numeroTelepase)) {
			return vehiculosEnCirculacion.add(telepase.get(numeroTelepase));
		}
		else{
			throw new VehiculoNotFoundException("Vehiculo no registrado");
		}
	}
	
	public void salirAutopista (Vehiculo vehiculo) throws VehiculoNotFoundException {
		//lanza Una exception VehiculoNotFounException si no esta en circulacion
		if(!vehiculosEnCirculacion.remove(vehiculo))
			throw new VehiculoNotFoundException("Vehiculo no registrado");
	}
	
	public TreeSet<Vehiculo> obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente(){
		Comparator<Vehiculo> comparator = new ComparadorPorPatente();
		TreeSet<Vehiculo> vehiculosConExcesosDeVelocidad = new TreeSet<Vehiculo>(comparator);
		
		for (Vehiculo vehiculo : vehiculosEnCirculacion) {
			if(vehiculo.getVelocidadActual() >= vehiculo.getLimiteVelocidad())
				vehiculosConExcesosDeVelocidad.add(vehiculo);
		}
		
		return vehiculosConExcesosDeVelocidad;
    }

	public Integer cantidadDeVehiculosENCirculacion() {
		return vehiculosEnCirculacion.size();
	}

	public HashMap<Integer, Vehiculo> getTelepase() {
		return telepase;
	}

	public void setTelepase(HashMap<Integer, Vehiculo> telepase) {
		this.telepase = telepase;
	}

	public HashSet<Vehiculo> getVehiculosEnCirculacion() {
		return vehiculosEnCirculacion;
	}

	public void setVehiculosEnCirculacion(HashSet<Vehiculo> vehiculosEnCirculacion) {
		this.vehiculosEnCirculacion = vehiculosEnCirculacion;
	}
}
