package ar.edu.unlam.pb220202c.eva03;

import java.util.Comparator;

public class ComparadorPorPatente implements Comparator<Vehiculo>{

	@Override
	public int compare(Vehiculo o1, Vehiculo o2) {
		
		return o1.getPatente().compareTo(o2.getPatente());
	}

}
