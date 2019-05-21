package superior.ncom;

import org.junit.Assert;
import org.junit.Test;

public class OperacionesServiceTests {

	@Test
	public void sumaDeComplejosCaso1() {
		ComplejoBinomico primero = new ComplejoBinomico(2D,3D);
		ComplejoBinomico segundo = new ComplejoBinomico(3D,2D);
		ComplejoBinomico resultado = new OperacionesService().suma(primero, segundo);
		Assert.assertEquals(5, resultado.getParteImaginaria(), 0);
		Assert.assertEquals(5, resultado.getParteReal(), 0);
	}

	@Test
	public void restaDeComplejosCaso1() {
		ComplejoBinomico primero = new ComplejoBinomico(2D,3D);
		ComplejoBinomico segundo = new ComplejoBinomico(3D,2D);
		ComplejoBinomico resultado = new OperacionesService().resta(primero, segundo);
		Assert.assertEquals(1, resultado.getParteImaginaria(), 0);
		Assert.assertEquals(-1, resultado.getParteReal(), 0);
	}


	@Test
	public void multiplicacionDeComplejosCaso1() {
		ComplejoBinomico primero = new ComplejoBinomico(3D,5D);
		ComplejoBinomico segundo = new ComplejoBinomico(2D,-3D);
		ComplejoBinomico resultado = new OperacionesService().multiplicacion(primero, segundo);
		Assert.assertEquals(1, resultado.getParteImaginaria(), 0);
		Assert.assertEquals(21, resultado.getParteReal(), 0);
	}

	@Test
	public void multiplicacionDeComplejosCaso2() {
		ComplejoPolar primero = new ComplejoPolar(2,Math.PI / 3);
		ComplejoPolar segundo = new ComplejoPolar(5,Math.PI / 5);
		ComplejoBinomico resultado = new OperacionesService().multiplicacion(primero, segundo);
//		ComplejoPolar resultadoPolar = restulado.transformarAPolar();
		Assert.assertEquals(Math.PI * 8/15, resultado.calcularArgumento(), 0.1);
		Assert.assertEquals(10, resultado.calcularModulo(), 0.1);
	}

	@Test
	public void divisionDeComplejosCaso1() {
		ComplejoBinomico primero = new ComplejoBinomico(3D,2D);
		ComplejoBinomico segundo = new ComplejoBinomico(5D,-3D);
		ComplejoBinomico resultado = new OperacionesService().division(primero, segundo);
		Assert.assertEquals(0.55, resultado.getParteImaginaria(), 0.1);
		Assert.assertEquals(0.26, resultado.getParteReal(), 0.1);
	}
	
	@Test
	public void potenciaDeComplejos() {
		ComplejoBinomico primero = new ComplejoBinomico(3D,4D);
		ComplejoBinomico resultado = new OperacionesService().potencia(primero, 2D);
		Assert.assertEquals(9, resultado.getParteReal(), 0);
		Assert.assertEquals(8, resultado.getParteImaginaria(), 0);
	}
	
	@Test
	public void raizDeComplejos() {
		ComplejoBinomico primero = new ComplejoBinomico(4D,1D);
		ComplejoBinomico resultado = new OperacionesService().raizNesima(primero, 2D);
		Assert.assertEquals(2, resultado.getParteReal(), 0.1);
		Assert.assertEquals(1, resultado.getParteImaginaria(), 0.1);
	}
}
