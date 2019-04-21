package superior.ncom;

public class Complejo {
    protected Double parteReal;
    protected Double parteImaginaria;

    public Complejo(Double parteReal, Double parteImaginaria) {
        this.parteReal = parteReal;
        this.parteImaginaria = parteImaginaria;
    }

    public Complejo transformarAConjugado() {
        return new ComplejoConjugado(parteReal, parteImaginaria);
    }
}
