package superior.ncom;

import org.junit.Assert;
import org.junit.Test;

public class OperacionesServiceTests {

	@Test
	public void sumaDeComplejosCaso1() {
		ComplejoBinomico primero = new ComplejoBinomico(2D,3D);
		ComplejoBinomico segundo = new ComplejoBinomico(3D,2D);
		ComplejoBinomico restulado = new OperacionesService().suma(primero, segundo);
		Assert.assertEquals(5, restulado.getParteImaginaria(), 0);
		Assert.assertEquals(5, restulado.getParteReal(), 0);
	}

	@Test
	public void restaDeComplejosCaso1() {
		ComplejoBinomico primero = new ComplejoBinomico(2D,3D);
		ComplejoBinomico segundo = new ComplejoBinomico(3D,2D);
		ComplejoBinomico restulado = new OperacionesService().resta(primero, segundo);
		Assert.assertEquals(1, restulado.getParteImaginaria(), 0);
		Assert.assertEquals(-1, restulado.getParteReal(), 0);
	}


	@Test
	public void multiplicacionDeComplejosCaso1() {
		ComplejoBinomico primero = new ComplejoBinomico(3D,5D);
		ComplejoBinomico segundo = new ComplejoBinomico(2D,-3D);
		ComplejoBinomico restulado = new OperacionesService().multiplicacion(primero, segundo);
		Assert.assertEquals(1, restulado.getParteImaginaria(), 0);
		Assert.assertEquals(21, restulado.getParteReal(), 0);
	}

	@Test
	public void multiplicacionDeComplejosCaso2() {
		ComplejoPolar primero = new ComplejoPolar(2,Math.PI / 3);
		ComplejoPolar segundo = new ComplejoPolar(5,Math.PI / 5);
		ComplejoBinomico resutlado = new OperacionesService().multiplicacion(primero, segundo);
//		ComplejoPolar resultadoPolar = restulado.transformarAPolar();
		Assert.assertEquals(Math.PI * 8/15, resutlado.calcularArgumento(), 0.1);
		Assert.assertEquals(10, resutlado.calcularModulo(), 0.1);
	}

	@Test
	public void divisionDeComplejosCaso1() {
		ComplejoBinomico primero = new ComplejoBinomico(3D,2D);
		ComplejoBinomico segundo = new ComplejoBinomico(5D,-3D);
		ComplejoBinomico restulado = new OperacionesService().division(primero, segundo);
		Assert.assertEquals(0.55, restulado.getParteImaginaria(), 0.1);
		Assert.assertEquals(0.26, restulado.getParteReal(), 0.1);
	}
}
