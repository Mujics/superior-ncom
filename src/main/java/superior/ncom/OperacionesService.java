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

	public ComplejoBinomico division(ComplejoBinomico primero, ComplejoBinomico segundo){
		Complejo conjugadoSegundo = segundo.transformarAConjugado();
		Complejo numerador = multiplicacion(primero, conjugadoSegundo);
		double denominador = multiplicacion(segundo, conjugadoSegundo).getParteReal();
		return new ComplejoBinomico(numerador.getParteReal() / denominador, numerador.getParteImaginaria() / denominador);
	}
	
	public ComplejoBinomico potencia(Complejo primero, Integer potencia) {
        ComplejoBinomico complejoBinomico = multiplicacion(primero, primero);
	    for (int i = 1; i < potencia - 1; i++) {
	        complejoBinomico = multiplicacion(complejoBinomico, primero);
        }
        return complejoBinomico;
	}

	public ComplejoBinomico raizNesima (Complejo primero, Double raiz) {
		double parteReal = Math.pow(Math.E, Math.log(primero.getParteReal())/raiz);
		double parteImaginaria = primero.getParteImaginaria() + (2*0*Math.PI)/raiz ;
		for(Double k=0.00; k<raiz; k++) {
			System.out.println("las Partes imaginarias son" + (primero.getParteImaginaria()+ (2*k*Math.PI)/raiz));
		}
		return new ComplejoBinomico(parteReal, parteImaginaria);
	}

}
