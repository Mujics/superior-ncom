package superior.ncom;

public class ComplejoConjugado extends ComplejoBinomico implements Mostrable{

    public ComplejoConjugado(Double parteReal, Double parteImaginaria) {
        super(parteReal, -parteImaginaria);
    }
}
