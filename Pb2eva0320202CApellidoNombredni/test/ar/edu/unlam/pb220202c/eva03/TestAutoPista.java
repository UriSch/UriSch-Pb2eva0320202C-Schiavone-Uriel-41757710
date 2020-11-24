package ar.edu.unlam.pb220202c.eva03;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAutoPista {
	
	@Test
	public void queSePuedaRegistrarTelepase () {
		Autopista autopista = new Autopista();
		Vehiculo auto = new Automovil("2aex", 90);
		
		assertTrue(autopista.registrarTelepase(1, auto));
	}
	
	@Test(expected = VehiculoNotFoundException.class)
	public void queAlSalirDelAutopistaNoestaEncirculacionLanceUnaExcepcion() throws VehiculoNotFoundException{
		Autopista autopista = new Autopista();
		Vehiculo auto = new Automovil("2aex", 90);
		
		autopista.salirAutopista(auto);
	}
	
	@Test
	public void queVerifiqueQueSeObtengaUnaListaDeAutosInsfractoresOrdenadaPorPatente(){
		Autopista autopista = new Autopista();
		Vehiculo auto = new Automovil("2aex", 90);
		Vehiculo auto2 = new Automovil("3aex", 150);
		Vehiculo camion = new Camion("5aex", 110, 2);
		Vehiculo camion2 = new Camion("2aez", 110, 2);
		
		autopista.registrarTelepase(1, auto);
		autopista.registrarTelepase(2, auto2);
		autopista.registrarTelepase(3, camion);
		autopista.registrarTelepase(4, camion2);
		
		try {
			autopista.ingresarAutopista(1);
			autopista.ingresarAutopista(2);
			autopista.ingresarAutopista(3);
			autopista.ingresarAutopista(4);
		} catch (VehiculoNotFoundException e) {
			e.printStackTrace();
		}
		
		
		Vehiculo expected = camion2;
		Vehiculo actual = autopista.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente().first();
		
		assertEquals(expected, actual);
	}

	@Test
	public void queNoIngresenVehiculosSinTelepase() throws VehiculoNotFoundException{
		Autopista autopista = new Autopista();
		Vehiculo auto = new Automovil("2aex", 90);
		Vehiculo auto2 = new Automovil("3aex", 150);
		Vehiculo camion = new Camion("5aex", 110, 2);
		Vehiculo camion2 = new Camion("2aez", 110, 2);
		
		autopista.registrarTelepase(1, auto);
		autopista.registrarTelepase(2, auto2);
		autopista.registrarTelepase(3, camion);
		
		try {
			autopista.ingresarAutopista(1);
			autopista.ingresarAutopista(2);
			autopista.ingresarAutopista(3);
			autopista.ingresarAutopista(4);
		} catch (VehiculoNotFoundException e) {
			e.printStackTrace();
		}
		
		Integer expected = autopista.cantidadDeVehiculosENCirculacion();
		Integer actual = 3;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void queUnVehiculoPuedaIngresarYSalirDelAutopista() throws VehiculoNotFoundException{
		Autopista autopista = new Autopista();
		Vehiculo auto = new Automovil("2aex", 90);
		
		autopista.registrarTelepase(1, auto);
		
		try {
			autopista.ingresarAutopista(1);
			autopista.salirAutopista(auto);
			
		} catch (VehiculoNotFoundException e) {
			e.printStackTrace();
		}
		
		Integer expected = autopista.cantidadDeVehiculosENCirculacion();
		Integer actual = 0;
		
		assertEquals(expected, actual);
	}
}
