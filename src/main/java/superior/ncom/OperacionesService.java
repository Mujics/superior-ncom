package superior.ncom;

public class OperacionesService {

	public ComplejoBinomico suma(Complejo primero, Complejo segundo){
		double parteReal = primero.getParteReal() + segundo.getParteReal();
		double parteImaginaria = primero.getParteImaginaria() + segundo.getParteImaginaria();
		return new ComplejoBinomico( parteReal, parteImaginaria );
	}

	public ComplejoBinomico resta(Complejo primero, Complejo segundo){
		double parteReal = primero.getParteReal() - segundo.getParteReal();
		double parteImaginaria = primero.getParteImaginaria() - segundo.getParteImaginaria();
		return new ComplejoBinomico( parteReal, parteImaginaria );
	}

	public ComplejoBinomico multiplicacion(Complejo primero, Complejo segundo){
		double parteReal = primero.getParteReal() * segundo.getParteReal() - primero.getParteImaginaria() * segundo.getParteImaginaria();
		double parteImaginaria = primero.getParteReal() * segundo.getParteImaginaria() + segundo.getParteReal() * primero.getParteImaginaria();
		return new ComplejoBinomico( parteReal, parteImaginaria );
	}

//	public Complejo division(Complejo primero, Complejo segundo){
//		double denominador = Math.pow(segundo.getParteReal(),2) + Math.pow(segundo.getParteImaginaria(),2);
//		double parteReal = (primero.getParteReal() * segundo.getParteReal() + primero.getParteImaginaria() * segundo.getParteImaginaria())/ denominador;
//		double parteImaginaria = (segundo.getParteReal() * primero.getParteImaginaria() - primero.getParteReal()* segundo.getParteImaginaria())/ denominador;
//		return new ComplejoBinomico( parteReal, parteImaginaria );
//	}

	public ComplejoBinomico division(Complejo primero, Complejo segundo){
		Complejo conjugadoSegundo = segundo.transformarAConjugado();
		Complejo numerador = multiplicacion(primero, conjugadoSegundo);
		double denominador = multiplicacion(segundo, conjugadoSegundo).getParteReal();
		return new ComplejoBinomico(numerador.getParteReal() / denominador, numerador.getParteImaginaria() / denominador);
	}
}
