package superior.ncom;

public class OperacionesService {

	public Double potencia;
	public Double raiz;
	public Double i;
	public Double k;
	
	public class RaizN {
	    public Double calcular(Double base, Double n) {
	        return Math.pow(Math.E, Math.log(base)/n);
	    }
	}
	
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

	public ComplejoBinomico division(ComplejoBinomico primero, ComplejoBinomico segundo){
		Complejo conjugadoSegundo = segundo.transformarAConjugado();
		Complejo numerador = multiplicacion(primero, conjugadoSegundo);
		double denominador = multiplicacion(segundo, conjugadoSegundo).getParteReal();
		return new ComplejoBinomico(numerador.getParteReal() / denominador, numerador.getParteImaginaria() / denominador);
	}
	
	public ComplejoBinomico potencia(Complejo primero, Double potencia) {
		double parteReal = Math.pow(primero.getParteReal(), potencia);
		double parteImaginaria = primero.getParteImaginaria() * potencia;
		return new ComplejoBinomico (parteReal, parteImaginaria);
	}
	/*
	public ComplejoBinomico raizNesima (Complejo primero, Double raiz) {
		double parteReal = RaizN.calcular(primero.getParteReal(),raiz);
		double parteImaginaria = primero.getParteImaginaria() + (2*0*Math.PI)/raiz ;
		for(k=0.00; k<=raiz; k++) {
			System.out.println("las Partes imaginarias son" + (primero.getParteImaginaria()+ (2*k*Math.PI)/raiz));
		}
		return new ComplejoBinomico(parteReal, parteImaginaria);
	}
	*/	
}
